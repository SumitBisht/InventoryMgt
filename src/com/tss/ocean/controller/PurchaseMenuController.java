/*   1:    */ package com.tss.ocean.controller;
/*   2:    */ 
/*   3:    */ import com.tss.ocean.idao.IAccountsDAO;
/*   4:    */ import com.tss.ocean.idao.IEmployeeCategoryDAO;
/*   5:    */ import com.tss.ocean.idao.IEmployeesDAO;
/*   6:    */ import com.tss.ocean.idao.IItemDAO;
/*   7:    */ import com.tss.ocean.idao.IPurchaseApproverDAO;
/*   8:    */ import com.tss.ocean.idao.IPurrequisitionDAO;
/*   9:    */ import com.tss.ocean.idao.IPurrequisitiondtDAO;
/*  10:    */ import com.tss.ocean.pojo.Accounts;
/*  11:    */ import com.tss.ocean.pojo.Employees;
/*  12:    */ import com.tss.ocean.pojo.Item;
/*  13:    */ import com.tss.ocean.pojo.PurordApprovers;
/*  14:    */ import com.tss.ocean.pojo.Purrequisition;
/*  15:    */ import com.tss.ocean.pojo.Purrequisitiondt;
/*  16:    */ import com.tss.ocean.util.Utilities;
/*  17:    */ import java.security.Principal;
/*  18:    */ import java.util.Date;
/*  19:    */ import java.util.HashMap;
/*  20:    */ import java.util.List;
/*  21:    */ import java.util.Locale;
/*  22:    */ import java.util.Map;
/*  23:    */ import java.util.Set;
/*  24:    */ import javax.servlet.http.HttpServletRequest;
/*  25:    */ import javax.validation.Valid;
/*  26:    */ import org.slf4j.Logger;
/*  27:    */ import org.slf4j.LoggerFactory;
/*  28:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  29:    */ import org.springframework.beans.propertyeditors.CustomCollectionEditor;
/*  30:    */ import org.springframework.context.MessageSource;
/*  31:    */ import org.springframework.security.access.prepost.PreAuthorize;
/*  32:    */ import org.springframework.stereotype.Controller;
/*  33:    */ import org.springframework.ui.ModelMap;
/*  34:    */ import org.springframework.validation.BindingResult;
/*  35:    */ import org.springframework.web.bind.ServletRequestDataBinder;
/*  36:    */ import org.springframework.web.bind.annotation.InitBinder;
/*  37:    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*  38:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  39:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  40:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  41:    */ import org.springframework.web.servlet.ModelAndView;
/*  42:    */ 
/*  43:    */ @Controller
/*  44:    */ public class PurchaseMenuController
/*  45:    */ {
/*  46: 53 */   private static final Logger LOG = LoggerFactory.getLogger(PurchaseMenuController.class);
/*  47:    */   @Autowired
/*  48:    */   private IPurchaseApproverDAO purchaseApproversDAO;
/*  49:    */   @Autowired
/*  50:    */   private IPurrequisitionDAO purrequisitionDAO;


/*  51:    */   @Autowired
/*  52:    */   private IPurrequisitiondtDAO purrequisitiondtDAO;
/*  53:    */   @Autowired
/*  54:    */   private IAccountsDAO accountsDAO;
/*  55:    */   @Autowired
/*  56:    */   private MessageSource messageSource;
/*  57:    */   @Autowired
/*  58:    */   private IItemDAO itemDAO;
/*  59:    */   @Autowired
/*  60:    */   private IEmployeesDAO employeesDAO;
/*  61:    */   @Autowired
/*  62:    */   IEmployeeCategoryDAO employeeCategoryDAO;
/*  63:    */   
/*  64:    */   @InitBinder
/*  65:    */   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
/*  66:    */     throws Exception
/*  67:    */   {
/*  68: 81 */     binder.registerCustomEditor(Set.class, new CustomCollectionEditor(Set.class)
/*  69:    */     {
/*  70:    */       protected Object convertElement(Object element)
/*  71:    */       {
/*  72: 84 */         String itemId = (String)element;
/*  73: 85 */         return PurchaseMenuController.this.itemDAO.getRecordByPrimaryKey(Integer.valueOf(itemId));
/*  74:    */       }
/*  75:    */     });
/*  76:    */   }
/*  77:    */   
/*  78:    */   @RequestMapping(value={"/add-purchase_request.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  79:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/*  80:    */   public ModelAndView add_purrequisition_get(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, HttpServletRequest request, Locale locale)
/*  81:    */     throws Exception
/*  82:    */   {
/*  83: 95 */     LOG.debug("add-purchase_request called.");
/*  84: 96 */     ModelAndView mav = new ModelAndView("purchase_request");
/*  85: 97 */     Purrequisition purrequisition = new Purrequisition();
/*  86: 98 */     if (success != null) {
/*  87: 99 */       mav.getModelMap().put("success", success);
/*  88:    */     }
/*  89:101 */     if (error != null) {
/*  90:102 */       mav.getModelMap().put("error", error);
/*  91:    */     }
/*  92:104 */     mav.getModelMap().put("supplierList", getSupplierList());
/*  93:105 */     mav.getModelMap().put("statusList", getStatusList(locale));
/*  94:106 */     mav.getModelMap().put("purrequisition", purrequisition);
/*  95:107 */     mav.getModelMap().put("itemList", this.itemDAO.getList());
/*  96:108 */     return mav;
/*  97:    */   }
/*  98:    */   
/*  99:    */   @RequestMapping(value={"/add-purchase_request.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 100:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/* 101:    */   public ModelAndView add_purrequisition_post(@ModelAttribute("purrequisition") @Valid Purrequisition purrequisition, BindingResult result, ModelMap model, Locale locale, Principal principal)
/* 102:    */     throws Exception
/* 103:    */   {
/* 104:117 */     LOG.debug("add-purchase_request-post called.");
/* 105:118 */     if (!result.hasErrors())
/* 106:    */     {
/* 107:119 */       List<Purrequisitiondt> list = purrequisition.getPurrequisitiondts();
/* 108:120 */       if ((list != null) && (!list.isEmpty())) {
/* 109:121 */         for (Purrequisitiondt dt : list) {
/* 110:122 */           LOG.debug("purchase dt :" + dt);
/* 111:    */         }
/* 112:    */       } else {
/* 113:125 */         LOG.debug("purchase dt is null");
/* 114:    */       }
/* 115:128 */       PurordApprovers approvers = null;
/* 116:129 */       List<PurordApprovers> approverlist = this.purchaseApproversDAO.getListByCondition("t where t.level=0");
/* 117:130 */       if ((approverlist != null) && (!approverlist.isEmpty())) {
/* 118:131 */         approvers = (PurordApprovers)approverlist.get(0);
/* 119:    */       }
/* 120:133 */       if (approvers != null)
/* 121:    */       {
/* 122:134 */         purrequisition.setNextapprovedby(Integer.valueOf(approvers.getUserid()));
/* 123:135 */         purrequisition.setStatus(Integer.valueOf(1));
/* 124:    */       }
/* 125:    */       else
/* 126:    */       {
/* 127:137 */         String loggedinusername = principal.getName();
/* 128:138 */         Employees employees = (Employees)this.employeesDAO.getRecordByKeyandValue("username", loggedinusername);
/* 129:139 */         int userid = 0;
/* 130:140 */         if (employees != null) {
/* 131:141 */           userid = employees.getId().intValue();
/* 132:    */         }
/* 133:143 */         purrequisition.setNextapprovedby(Integer.valueOf(0));
/* 134:144 */         purrequisition.setStatus(Integer.valueOf(5));
/* 135:    */       }
/* 136:146 */       purrequisition.setCreatedby(Integer.valueOf(1));
/* 137:147 */       purrequisition.setPrno(Utilities.getRandomString(10));
/* 138:148 */       purrequisition.setCreatedat(new Date());
/* 139:    */       
/* 140:150 */       int insertResult = ((Integer)this.purrequisitionDAO.insert(purrequisition)).intValue();
/* 141:151 */       if (insertResult > 0)
/* 142:    */       {
/* 143:153 */         LOG.debug("Purrequisition Added Successfully with id={0}", Integer.valueOf(insertResult));
/* 144:154 */         model.put("purrequisition", purrequisition);
/* 145:155 */         return new ModelAndView("redirect:edit-purchase_request.html?id=" + insertResult).addObject("success", Utilities.getSpringMessage(this.messageSource, "purrequisition.add.success", locale));
/* 146:    */       }
/* 147:158 */       LOG.debug("Error occurred inserting purrequisition:{0}", purrequisition.toString());
/* 148:159 */       model.put("supplierList", getSupplierList());
/* 149:160 */       model.put("itemList", this.itemDAO.getList());
/* 150:161 */       model.put("statusList", getStatusList(locale, 1));
/* 151:162 */       return new ModelAndView("purchase_request", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "purrequisition.add.error", locale));
/* 152:    */     }
/* 153:167 */     LOG.debug("Purchase_request values are not valid:", purrequisition.toString());
/* 154:168 */     model.put("supplierList", getSupplierList());
/* 155:169 */     model.put("itemList", this.itemDAO.getList());
/* 156:170 */     model.put("statusList", getStatusList(locale, 1));
/* 157:171 */     return new ModelAndView("purchase_request", model);
/* 158:    */   }
/* 159:    */   
/* 160:    */   @RequestMapping(value={"/edit-purchase_request.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 161:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/* 162:    */   public ModelAndView edit_purrequisition_get(@RequestParam("id") int id, Locale locale, @RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/* 163:    */     throws Exception
/* 164:    */   {
/* 165:181 */     LOG.debug("edit-purchase_request called.");
/* 166:    */     
/* 167:183 */     Purrequisition purrequisition = (Purrequisition)this.purrequisitionDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 168:    */     ModelAndView mav;
/* 169:184 */     if (purrequisition != null)
/* 170:    */     {
/* 171:185 */        mav = new ModelAndView("purchase_request");
/* 172:186 */       purrequisition.setPurrequisitiondts(this.purrequisitiondtDAO.getListByCondition("t where t.purreqid=" + purrequisition.getId()));
/* 173:187 */       mav.getModelMap().put("purrequisition", purrequisition);
/* 174:188 */       mav.getModelMap().put("purrequisitiondts", this.purrequisitiondtDAO.getListByCondition("t where t.purreqid=" + purrequisition.getId()));
/* 175:    */       
/* 176:190 */       mav.getModelMap().put("supplierList", getSupplierList());
/* 177:191 */       mav.getModelMap().put("itemList", this.itemDAO.getList());
/* 178:192 */       mav.getModelMap().put("statusList", getStatusList(locale));
/* 179:    */     }
/* 180:    */     else
/* 181:    */     {
/* 182:195 */       mav = new ModelAndView("redirect:purchase_request.html");
/* 183:    */     }
/* 184:197 */     if (success != null) {
/* 185:198 */       mav.getModelMap().put("success", success);
/* 186:    */     }
/* 187:200 */     if (error != null) {
/* 188:201 */       mav.getModelMap().put("error", error);
/* 189:    */     }
/* 190:203 */     return mav;
/* 191:    */   }
/* 192:    */   
/* 193:    */   @RequestMapping(value={"/edit-purchase_request.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 194:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/* 195:    */   public ModelAndView edit_purrequisition_post(@ModelAttribute("purrequisition") @Valid Purrequisition purrequisition, BindingResult result, ModelMap model, Locale locale)
/* 196:    */     throws Exception
/* 197:    */   {
/* 198:212 */     LOG.debug("edit-purchase_request-post called.");
/* 199:213 */     if (!result.hasErrors())
/* 200:    */     {
/* 201:214 */       purrequisition.setUpdatedat(new Date());
/* 202:215 */       int updateResult = this.purrequisitionDAO.update(purrequisition);
/* 203:216 */       if (updateResult > 0)
/* 204:    */       {
/* 205:217 */         LOG.debug("purchase_request updated Successfully with id={0}", Integer.valueOf(updateResult));
/* 206:218 */         return new ModelAndView("redirect:edit-purchase_request.html").addObject("success", Utilities.getSpringMessage(this.messageSource, "purrequisition.update.success", locale));
/* 207:    */       }
/* 208:222 */       LOG.debug("Error occurred updating purchase_request:{0}", purrequisition.toString());
/* 209:223 */       model.put("supplierList", getSupplierList());
/* 210:224 */       model.put("itemList", this.itemDAO.getList());
/* 211:225 */       model.put("statusList", getStatusList(locale));
/* 212:226 */       return new ModelAndView("purchase_request", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "purrequisition.update.error", locale));
/* 213:    */     }
/* 214:231 */     LOG.debug("Purchase_request values are not valid:", purrequisition.toString());
/* 215:232 */     model.put("supplierList", getSupplierList());
/* 216:233 */     model.put("itemList", this.itemDAO.getList());
/* 217:234 */     model.put("statusList", getStatusList(locale));
/* 218:235 */     return new ModelAndView("purchase_request", model);
/* 219:    */   }
/* 220:    */   
/* 221:    */   @RequestMapping(value={"/purchase_request.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 222:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/* 223:    */   public ModelAndView purrequisition(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale, Principal principal)
/* 224:    */     throws Exception
/* 225:    */   {
/* 226:244 */     LOG.debug("purchase_request called.");
/* 227:245 */     ModelAndView mav = new ModelAndView("purchase_request-list");
/* 228:246 */     List<Accounts> accountsList = this.accountsDAO.getList();
/* 229:    */     
/* 230:248 */     String loggedinusername = principal.getName();
/* 231:249 */     Employees employees = (Employees)this.employeesDAO.getRecordByKeyandValue("username", loggedinusername);
/* 232:250 */     int userid = 0;
/* 233:251 */     if (employees != null) {
/* 234:252 */       userid = employees.getId().intValue();
/* 235:    */     }
/* 236:255 */     HashMap<Integer, String> accountMap = new HashMap(accountsList.size());
/* 237:256 */     for (Accounts account : accountsList) {
/* 238:257 */       accountMap.put(account.getId(), account.getName());
/* 239:    */     }
/* 240:262 */     mav.getModelMap().put("purrequisitionList", this.purrequisitionDAO.getListByCondition("t where t.nextapprovedby=" + userid));
/* 241:    */     
/* 242:    */ 
/* 243:    */ 
/* 244:266 */     mav.getModelMap().put("accountMap", accountMap);
/* 245:267 */     mav.getModelMap().put("statusList", getStatusList(locale));
/* 246:268 */     if (success != null) {
/* 247:269 */       mav.getModelMap().put("success", success);
/* 248:    */     }
/* 249:271 */     if (error != null) {
/* 250:272 */       mav.getModelMap().put("error", error);
/* 251:    */     }
/* 252:274 */     return mav;
/* 253:    */   }
/* 254:    */   
/* 255:    */   @RequestMapping({"/delete-purchase_request.html"})
/* 256:    */   @ResponseBody
/* 257:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/* 258:    */   public boolean delete_purrequisition(@RequestParam("id") int id)
/* 259:    */     throws Exception
/* 260:    */   {
/* 261:281 */     LOG.debug("delete-purchase_request called.");
/* 262:282 */     Purrequisition purrequisition = (Purrequisition)this.purrequisitionDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 263:283 */     if (purrequisition != null)
/* 264:    */     {
/* 265:284 */       int updateResult = this.purrequisitionDAO.delete(purrequisition);
/* 266:285 */       if (updateResult > 0)
/* 267:    */       {
/* 268:286 */         LOG.debug("Purrequisition with id {0} deleted successfully", purrequisition.getId());
/* 269:287 */         return true;
/* 270:    */       }
/* 271:290 */       LOG.debug("Error occurred while deleting purrequisition with id {0}", purrequisition.getId());
/* 272:291 */       return false;
/* 273:    */     }
/* 274:294 */     LOG.debug("Purrequisition with id {0} is already deleted", Integer.valueOf(id));
/* 275:295 */     return true;
/* 276:    */   }
/* 277:    */   
/* 278:    */   private List<Accounts> getSupplierList()
/* 279:    */   {
/* 280:299 */     return this.accountsDAO.getListByFromClause(" FROM Accounts a WHERE a.visible=true and a.type=1");
/* 281:    */   }
/* 282:    */   
/* 283:    */   private Map<Integer, String> getStatusList(Locale local)
/* 284:    */   {
/* 285:303 */     Map<Integer, String> statusList = new HashMap();
/* 286:304 */     statusList.put(Integer.valueOf(1), Utilities.getSpringMessage(this.messageSource, "label.purrequisition.status.created", local));
/* 287:305 */     statusList.put(Integer.valueOf(4), Utilities.getSpringMessage(this.messageSource, "label.purrequisition.status.approved", local));
/* 288:306 */     statusList.put(Integer.valueOf(2), Utilities.getSpringMessage(this.messageSource, "label.purrequisition.status.suspended", local));
/* 289:307 */     statusList.put(Integer.valueOf(3), Utilities.getSpringMessage(this.messageSource, "label.purrequisition.status.placed", local));
/* 290:308 */     return statusList;
/* 291:    */   }
/* 292:    */   
/* 293:    */   private Map<Integer, String> getStatusList(Locale local, int purchasereq)
/* 294:    */   {
/* 295:312 */     Map<Integer, String> statusList = new HashMap();
/* 296:313 */     statusList.put(Integer.valueOf(1), Utilities.getSpringMessage(this.messageSource, "label.purrequisition.status.created", local));
/* 297:314 */     statusList.put(Integer.valueOf(4), Utilities.getSpringMessage(this.messageSource, "label.purrequisition.status.approved", local));
/* 298:315 */     statusList.put(Integer.valueOf(2), Utilities.getSpringMessage(this.messageSource, "label.purrequisition.status.suspended", local));
/* 299:316 */     return statusList;
/* 300:    */   }
/* 301:    */   
/* 302:    */   @RequestMapping(value={"/addpuritem.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 303:    */   @ResponseBody
/* 304:    */   public String add_itemdummy(@RequestParam("item") String item, @RequestParam("price") double price, @RequestParam("qty") int qty, @RequestParam("purreqid") int purreqid, Map<String, Object> model, HttpServletRequest request)
/* 305:    */     throws Exception
/* 306:    */   {
/* 307:323 */     LOG.debug("add-item called.");
/* 308:324 */     Purrequisition purrequisition = (Purrequisition)this.purrequisitionDAO.getRecordByPrimaryKey(Integer.valueOf(purreqid));
/* 309:325 */     int status = 0;
/* 310:326 */     if (purrequisition != null)
/* 311:    */     {
/* 312:327 */       Item oitem = (Item)this.itemDAO.getRecordByKeyandValue("name", item);
/* 313:328 */       if (oitem != null)
/* 314:    */       {
/* 315:329 */         Purrequisitiondt purrequisitiondt = new Purrequisitiondt(purreqid, oitem.getId().intValue(), qty, oitem, price);
/* 316:330 */         status = ((Integer)this.purrequisitiondtDAO.insert(purrequisitiondt)).intValue();
/* 317:    */       }
/* 318:    */       else
/* 319:    */       {
/* 320:332 */         LOG.debug("purchase req item not found...");
/* 321:333 */         throw new Exception("Item not found.");
/* 322:    */       }
/* 323:    */     }
/* 324:    */     else
/* 325:    */     {
/* 326:336 */       LOG.debug("purchase req is not found for adding item...");
/* 327:337 */       throw new Exception("Purchase Requisition not found.");
/* 328:    */     }
/* 329:339 */     return new Integer(status).toString();
/* 330:    */   }
/* 331:    */   
/* 332:    */   @RequestMapping({"/delpurdt.html"})
/* 333:    */   @ResponseBody
/* 334:    */   public int delete_purrequisitiondt(@RequestParam("id") int id)
/* 335:    */     throws Exception
/* 336:    */   {
/* 337:345 */     LOG.debug("delete_purrequisitiondt called.");
/* 338:346 */     Purrequisitiondt purrequisitiondt = (Purrequisitiondt)this.purrequisitiondtDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 339:347 */     int updateResult = 0;
/* 340:348 */     if (purrequisitiondt != null)
/* 341:    */     {
/* 342:349 */       updateResult = this.purrequisitiondtDAO.delete(purrequisitiondt);
/* 343:350 */       if (updateResult > 0)
/* 344:    */       {
/* 345:351 */         LOG.debug("Purrequisition with id {0} deleted successfully", purrequisitiondt.getId());
/* 346:352 */         return updateResult;
/* 347:    */       }
/* 348:355 */       LOG.debug("Error occurred while deleting purrequisition with id {0}", purrequisitiondt.getId());
/* 349:356 */       return updateResult;
/* 350:    */     }
/* 351:359 */     LOG.debug("Purrequisition with id {0} is already deleted", Integer.valueOf(id));
/* 352:360 */     return updateResult;
/* 353:    */   }
/* 354:    */ 


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.controller.PurrequisitionController
 * JD-Core Version:    0.7.1
 */


/* 332:    */   @RequestMapping({"/action.html"})
/* 333:    */   
/* 334:    */   public String approveNonapprove(@RequestParam("id") int id,@RequestParam("act") int act)
/* 335:    */     throws Exception
/* 336:    */   {
/* 337:345 */     LOG.debug("delete_purrequisitiondt called.");
    Purrequisition purrequissition  = (Purrequisition)this.purrequisitionDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 339:347 */     int updateResult = 0;
/* 340:348 */     if (purrequissition != null)
/* 341:    */     {
/* 342:349 */       
	purrequissition.setApprovalStatus(act);
	
	purrequisitionDAO.update(purrequissition);
	
/* 343:350 */       if (updateResult > 0)
/* 344:    */       {
/* 345:351 */         LOG.debug("Purrequisition with id {0} deleted successfully", purrequissition.getId());
/* 346:352 */         return "redirect:approve.html";
/* 347:    */       }
/* 348:355 */       LOG.debug("Error occurred while deleting purrequisition with id {0}", purrequissition.getId());
/* 346:352 */         return "redirect:approve.html";
/* 350:    */     }
/* 351:359 */     LOG.debug("Purrequisition with id {0} is already deleted", Integer.valueOf(id));
/* 346:352 */         return "redirect:approve.html";
/* 353:    */   }
/* 354:    */ 


/* 332:    */   @RequestMapping({"/finaction.html"})
/* 333:    */   
/* 334:    */   public String Processedforfinance(@RequestParam("id") int id,@RequestParam("act") int act)
/* 335:    */     throws Exception
/* 336:    */   {
/* 337:345 */     LOG.debug("delete_purrequisitiondt called.");
    Purrequisition purrequissition  = (Purrequisition)this.purrequisitionDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 339:347 */     int updateResult = 0;
/* 340:348 */     if (purrequissition != null)
/* 341:    */     {
/* 342:349 */       
	purrequissition.setProcessed(act);
	
	purrequisitionDAO.update(purrequissition);
	
/* 343:350 */       if (updateResult > 0)
/* 344:    */       {
/* 345:351 */         LOG.debug("Purrequisition with id {0} deleted successfully", purrequissition.getId());
/* 346:352 */         return "redirect:approvedForFinance.html";
/* 347:    */       }
/* 348:355 */       LOG.debug("Error occurred while deleting purrequisition with id {0}", purrequissition.getId());
/* 346:352 */         return "redirect:approvedForFinance.html";
/* 350:    */     }
/* 351:359 */     LOG.debug("Purrequisition with id {0} is already deleted", Integer.valueOf(id));
/* 346:352 */         return "redirect:approvedForFinance.html";
/* 353:    */   }
/* 354:    */ 







/*ApproveModule*/

@RequestMapping(value={"/approve.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 222:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/* 223:    */   public ModelAndView approve(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale, Principal principal)
/* 224:    */     throws Exception
/* 225:    */   {
/* 226:244 */     LOG.debug("purchase_request called.");
/* 227:245 */     ModelAndView mav = new ModelAndView("approve_request-list");
/* 228:246 */     List<Accounts> accountsList = this.accountsDAO.getList();
/* 229:    */     
/* 230:248 */     String loggedinusername = principal.getName();
/* 231:249 */     Employees employees = (Employees)this.employeesDAO.getRecordByKeyandValue("username", loggedinusername);
/* 232:250 */     int userid = 0;
/* 233:251 */     if (employees != null) {
/* 234:252 */       userid = employees.getId().intValue();
/* 235:    */     }
/* 236:255 */     HashMap<Integer, String> accountMap = new HashMap(accountsList.size());
/* 237:256 */     for (Accounts account : accountsList) {
/* 238:257 */       accountMap.put(account.getId(), account.getName());
/* 239:    */     }
/* 240:262 */     mav.getModelMap().put("purrequisitionList", this.purrequisitionDAO.getListByCondition("t where t.nextapprovedby=" + userid));
/* 241:    */     
/* 242:    */ 
/* 243:    */ 
/* 244:266 */     mav.getModelMap().put("accountMap", accountMap);
/* 245:267 */     mav.getModelMap().put("statusList", getStatusList(locale));
/* 246:268 */     if (success != null) {
/* 247:269 */       mav.getModelMap().put("success", success);
/* 248:    */     }
/* 249:271 */     if (error != null) {
/* 250:272 */       mav.getModelMap().put("error", error);
/* 251:    */     }
/* 252:274 */     return mav;
/* 253:    */   }








@RequestMapping(value={"/approvedForFinance.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 222:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/* 223:    */   public ModelAndView approvedOrders(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale, Principal principal)
/* 224:    */     throws Exception
/* 225:    */   {
/* 226:244 */     LOG.debug("purchase_request called.");
/* 227:245 */     ModelAndView mav = new ModelAndView("approved_finance-list");
/* 228:246 */     List<Accounts> accountsList = this.accountsDAO.getList();
/* 229:    */     
/* 230:248 */     String loggedinusername = principal.getName();
/* 231:249 */     Employees employees = (Employees)this.employeesDAO.getRecordByKeyandValue("username", loggedinusername);
/* 232:250 */     int userid = 0;
/* 233:251 */     if (employees != null) {
/* 234:252 */       userid = employees.getId().intValue();
/* 235:    */     }
/* 236:255 */     HashMap<Integer, String> accountMap = new HashMap(accountsList.size());
/* 237:256 */     for (Accounts account : accountsList) {
/* 238:257 */       accountMap.put(account.getId(), account.getName());
/* 239:    */     }
/* 240:262 */     mav.getModelMap().put("purrequisitionList", this.purrequisitionDAO.getListByCondition("t where t.approvalStatus=1"));
/* 241:    */     
/* 242:    */ 
/* 243:    */ 
/* 244:266 */     mav.getModelMap().put("accountMap", accountMap);
/* 245:267 */     mav.getModelMap().put("statusList", getStatusList(locale));
/* 246:268 */     if (success != null) {
/* 247:269 */       mav.getModelMap().put("success", success);
/* 248:    */     }
/* 249:271 */     if (error != null) {
/* 250:272 */       mav.getModelMap().put("error", error);
/* 251:    */     }
/* 252:274 */     return mav;
/* 253:    */   }





}


