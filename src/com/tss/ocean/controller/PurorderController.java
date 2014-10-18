/*   1:    */ package com.tss.ocean.controller;
/*   2:    */ 
/*   3:    */ import com.tss.ocean.idao.IAccountsDAO;
/*   4:    */ import com.tss.ocean.idao.IPurorderDAO;
/*   5:    */ import com.tss.ocean.idao.IPurrequisitionDAO;
/*   6:    */ import com.tss.ocean.pojo.Accounts;
/*   7:    */ import com.tss.ocean.pojo.Purorder;
/*   8:    */ import com.tss.ocean.pojo.Purrequisition;
/*   9:    */ import com.tss.ocean.util.Utilities;
/*  10:    */ import java.io.PrintStream;
/*  11:    */ import java.text.SimpleDateFormat;
/*  12:    */ import java.util.Calendar;
/*  13:    */ import java.util.Date;
/*  14:    */ import java.util.HashMap;
/*  15:    */ import java.util.List;
/*  16:    */ import java.util.Locale;
/*  17:    */ import java.util.logging.Level;
/*  18:    */ import java.util.logging.Logger;
/*  19:    */ import javax.validation.Valid;
/*  20:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  21:    */ import org.springframework.context.MessageSource;
/*  22:    */ import org.springframework.security.access.prepost.PreAuthorize;
/*  23:    */ import org.springframework.stereotype.Controller;
/*  24:    */ import org.springframework.ui.ModelMap;
/*  25:    */ import org.springframework.validation.BindingResult;
/*  26:    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*  27:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  28:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  29:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  30:    */ import org.springframework.web.servlet.ModelAndView;
/*  31:    */ 
/*  32:    */ @Controller
/*  33:    */ public class PurorderController
/*  34:    */ {
/*  35: 40 */   private static final Logger logger = Logger.getLogger(ViewController.class.getName());
/*  36:    */   @Autowired
/*  37:    */   IPurorderDAO purorderDAO;
/*  38:    */   @Autowired
/*  39:    */   IAccountsDAO accountsDAO;
/*  40:    */   @Autowired
/*  41:    */   IPurrequisitionDAO purrequisitionDAO;
/*  42:    */   @Autowired
/*  43:    */   private MessageSource messageSource;
/*  44:    */   
/*  45:    */   @RequestMapping(value={"/add-purchase_order.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  46:    */   @PreAuthorize("hasAnyRole('ROLE_USER')")
/*  47:    */   public ModelAndView add_purorder_get(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/*  48:    */     throws Exception
/*  49:    */   {
/*  50: 59 */     logger.log(Level.FINE, "add-purchase_order called.");
/*  51: 60 */     ModelAndView mav = new ModelAndView("purchase_order");
/*  52: 61 */     Purorder purorder = new Purorder();
/*  53: 62 */     if (success != null) {
/*  54: 63 */       mav.getModelMap().put("success", success);
/*  55:    */     }
/*  56: 65 */     if (error != null) {
/*  57: 66 */       mav.getModelMap().put("error", error);
/*  58:    */     }
/*  59: 68 */     mav.getModelMap().put("supplierList", getSupplierList());
/*  60: 69 */     mav.getModelMap().put("purrequisitionList", getPurrequisitionList());
/*  61: 70 */     mav.getModelMap().put("purorder", purorder);
/*  62: 71 */     return mav;
/*  63:    */   }
/*  64:    */   
/*  65:    */   @RequestMapping(value={"/add-purchase_order.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  66:    */   @PreAuthorize("hasAnyRole('ROLE_USER')")
/*  67:    */   public ModelAndView add_purorder_post(@ModelAttribute("purorder") @Valid Purorder purorder, BindingResult result, ModelMap model, Locale locale)
/*  68:    */     throws Exception
/*  69:    */   {
/*  70: 80 */     logger.log(Level.FINE, "add-purchase_order-post called.");
/*  71: 81 */     if (!result.hasErrors())
/*  72:    */     {
/*  73: 82 */       purorder.setCreatedby(Integer.valueOf(1));
/*  74: 83 */       int insertResult = ((Integer)this.purorderDAO.insert(purorder)).intValue();
/*  75: 84 */       if (insertResult > 0)
/*  76:    */       {
/*  77: 85 */         logger.log(Level.INFO, "Purorder Added Successfully with id={0}", Integer.valueOf(insertResult));
/*  78: 86 */         return new ModelAndView("redirect:add-purchase_order.html").addObject("success", Utilities.getSpringMessage(this.messageSource, "purorder.add.success", locale));
/*  79:    */       }
/*  80: 89 */       logger.log(Level.WARNING, "Error occurred inserting purorder:{0}", purorder.toString());
/*  81: 90 */       model.put("supplierList", getSupplierList());
/*  82: 91 */       model.put("purrequisitionList", getPurrequisitionList());
/*  83: 92 */       return new ModelAndView("purchase_order", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "purorder.add.error", locale));
/*  84:    */     }
/*  85: 96 */     logger.log(Level.WARNING, "Purchase_order values are not valid:", purorder.toString());
/*  86: 97 */     model.put("supplierList", getSupplierList());
/*  87: 98 */     model.put("purrequisitionList", getPurrequisitionList());
/*  88: 99 */     return new ModelAndView("purchase_order", model);
/*  89:    */   }
/*  90:    */   
/*  91:    */   @RequestMapping(value={"/edit-purchase_order.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  92:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/*  93:    */   public ModelAndView edit_purorder_get(@RequestParam("id") int id, Locale locale, @RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/*  94:    */     throws Exception
/*  95:    */   {
/*  96:109 */     logger.log(Level.FINE, "edit-purchase_order called.");
/*  97:    */     
/*  98:111 */     Purorder purorder = (Purorder)this.purorderDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/*  99:    */     ModelAndView mav;
/* 100:112 */     if (purorder != null)
/* 101:    */     {
/* 102:113 */        mav = new ModelAndView("purchase_order");
/* 103:114 */       mav.getModelMap().put("purorder", purorder);
/* 104:115 */       mav.getModelMap().put("supplierList", getSupplierList());
/* 105:116 */       mav.getModelMap().put("purrequisitionList", getPurrequisitionList());
/* 106:    */     }
/* 107:    */     else
/* 108:    */     {
/* 109:118 */       mav = new ModelAndView("redirect:purchase_order.html");
/* 110:    */     }
/* 111:120 */     if (success != null) {
/* 112:121 */       mav.getModelMap().put("success", success);
/* 113:    */     }
/* 114:123 */     if (error != null) {
/* 115:124 */       mav.getModelMap().put("error", error);
/* 116:    */     }
/* 117:126 */     return mav;
/* 118:    */   }
/* 119:    */   
/* 120:    */   @RequestMapping(value={"/edit-purchase_order.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 121:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/* 122:    */   public ModelAndView edit_purorder_post(@ModelAttribute("purorder") @Valid Purorder purorder, BindingResult result, ModelMap model, Locale locale)
/* 123:    */     throws Exception
/* 124:    */   {
/* 125:135 */     logger.log(Level.FINE, "edit-purchase_order-post called.");
/* 126:136 */     if (!result.hasErrors())
/* 127:    */     {
/* 128:137 */       int updateResult = this.purorderDAO.update(purorder);
/* 129:138 */       if (updateResult > 0)
/* 130:    */       {
/* 131:139 */         logger.log(Level.INFO, "purchase_order updated Successfully with id={0}", Integer.valueOf(updateResult));
/* 132:140 */         return new ModelAndView("redirect:purchase_order.html").addObject("success", Utilities.getSpringMessage(this.messageSource, "purorder.update.success", locale));
/* 133:    */       }
/* 134:143 */       logger.log(Level.WARNING, "Error occurred updating purchase_order:{0}", purorder.toString());
/* 135:144 */       model.put("supplierList", getSupplierList());
/* 136:145 */       model.put("purrequisitionList", getPurrequisitionList());
/* 137:146 */       return new ModelAndView("purchase_order", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "purorder.update.error", locale));
/* 138:    */     }
/* 139:150 */     logger.log(Level.WARNING, "Purchase_order values are not valid:", purorder.toString());
/* 140:151 */     model.put("supplierList", getSupplierList());
/* 141:152 */     model.put("purrequisitionList", getPurrequisitionList());
/* 142:153 */     return new ModelAndView("purchase_order", model);
/* 143:    */   }
/* 144:    */   
/* 145:    */   @RequestMapping(value={"/purchase_order.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 146:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/* 147:    */   public ModelAndView purorder(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/* 148:    */     throws Exception
/* 149:    */   {
/* 150:162 */     logger.log(Level.FINE, "add-purchase_order called.");
/* 151:163 */     ModelAndView mav = new ModelAndView("purchase_order-list");
/* 152:164 */     List<Purrequisition> purrequisitionList = this.purrequisitionDAO.getList();
/* 153:165 */     HashMap<Integer, String> purrequisitionMap = new HashMap(purrequisitionList.size());
/* 154:166 */     for (Purrequisition purrequisition : purrequisitionList) {
/* 155:167 */       purrequisitionMap.put(purrequisition.getId(), purrequisition.getPrno());
/* 156:    */     }
/* 157:170 */     List<Accounts> accountsList = this.accountsDAO.getList();
/* 158:171 */     HashMap<Integer, String> accountMap = new HashMap(accountsList.size());
/* 159:172 */     for (Accounts account : accountsList) {
/* 160:173 */       accountMap.put(account.getId(), account.getName());
/* 161:    */     }
/* 162:176 */     mav.getModelMap().put("purrequisitionMap", purrequisitionMap);
/* 163:177 */     mav.getModelMap().put("accountMap", accountMap);
/* 164:178 */     mav.getModelMap().put("purorderList", this.purorderDAO.getList());
/* 165:179 */     if (success != null) {
/* 166:180 */       mav.getModelMap().put("success", success);
/* 167:    */     }
/* 168:182 */     if (error != null) {
/* 169:183 */       mav.getModelMap().put("error", error);
/* 170:    */     }
/* 171:185 */     return mav;
/* 172:    */   }
/* 173:    */   
/* 174:    */   @RequestMapping({"/delete-purchase_order.html"})
/* 175:    */   @ResponseBody
/* 176:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/* 177:    */   public boolean delete_purorder(@RequestParam("id") int id)
/* 178:    */     throws Exception
/* 179:    */   {
/* 180:192 */     logger.log(Level.FINE, "delete-purchase_order called.");
/* 181:193 */     Purorder purorder = (Purorder)this.purorderDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 182:194 */     if (purorder != null)
/* 183:    */     {
/* 184:195 */       int updateResult = this.purorderDAO.delete(purorder);
/* 185:196 */       if (updateResult > 0)
/* 186:    */       {
/* 187:197 */         logger.log(Level.INFO, "Purorder with id {0} deleted successfully", purorder.getId());
/* 188:198 */         return true;
/* 189:    */       }
/* 190:200 */       logger.log(Level.WARNING, "Error occurred while deleting purorder with id {0}", purorder.getId());
/* 191:201 */       return false;
/* 192:    */     }
/* 193:204 */     logger.log(Level.INFO, "Purorder with id {0} is already deleted", Integer.valueOf(id));
/* 194:205 */     return true;
/* 195:    */   }
/* 196:    */   
/* 197:    */   @RequestMapping(value={"/purchase_order_recipt_finance.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 198:    */   public ModelAndView purorder_finance(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/* 199:    */     throws Exception
/* 200:    */   {
/* 201:212 */     logger.log(Level.FINE, "purchase_order_recipt_finance called.");
/* 202:213 */     ModelAndView mav = new ModelAndView("pur_order_finance_report");
/* 203:214 */     List<Purrequisition> purrequisitionList = this.purrequisitionDAO.getList();
/* 204:215 */     HashMap<Integer, String> purrequisitionMap = new HashMap(purrequisitionList.size());
/* 205:216 */     for (Purrequisition purrequisition : purrequisitionList) {
/* 206:217 */       purrequisitionMap.put(purrequisition.getId(), purrequisition.getPrno());
/* 207:    */     }
/* 208:220 */     List<Accounts> accountsList = this.accountsDAO.getList();
/* 209:221 */     HashMap<Integer, String> accountMap = new HashMap(accountsList.size());
/* 210:222 */     for (Accounts account : accountsList) {
/* 211:223 */       accountMap.put(account.getId(), account.getName());
/* 212:    */     }
/* 213:226 */     mav.getModelMap().put("purrequisitionMap", purrequisitionMap);
/* 214:227 */     mav.getModelMap().put("accountMap", accountMap);
/* 215:228 */     mav.getModelMap().put("purorderList", this.purorderDAO.getList());
/* 216:229 */     if (success != null) {
/* 217:230 */       mav.getModelMap().put("success", success);
/* 218:    */     }
/* 219:232 */     if (error != null) {
/* 220:233 */       mav.getModelMap().put("error", error);
/* 221:    */     }
/* 222:235 */     return mav;
/* 223:    */   }
/* 224:    */   
/* 225:    */   @RequestMapping(value={"/get_purorder_daterange.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 226:    */   public ModelAndView get_purorder_daterange(@RequestParam("fromDate") String strfromDate, @RequestParam("toDate") String strtoDate, Locale locale, @RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/* 227:    */     throws Exception
/* 228:    */   {
/* 229:244 */     logger.log(Level.FINE, "get_purorder_daterange called.");
/* 230:245 */     ModelAndView mav = new ModelAndView("pur_order_finance_report");
/* 231:246 */     if ((strfromDate != null) && (strtoDate != null))
/* 232:    */     {
/* 233:248 */       System.out.println("from Date : " + strfromDate);
/* 234:249 */       SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
/* 235:250 */       Date fromDate = sf.parse(strfromDate);
/* 236:251 */       Date toDate = sf.parse(strtoDate);
/* 237:252 */       Calendar c = Calendar.getInstance();
/* 238:253 */       c.setTime(fromDate);
/* 239:254 */       c.set(10, 0);
/* 240:255 */       c.set(12, 0);
/* 241:256 */       c.set(13, 0);
/* 242:257 */       fromDate = c.getTime();
/* 243:    */       
/* 244:259 */       c.setTime(toDate);
/* 245:260 */       c.set(10, 23);
/* 246:261 */       c.set(12, 59);
/* 247:262 */       c.set(13, 59);
/* 248:263 */       toDate = c.getTime();
/* 249:    */       
/* 250:265 */       System.out.println("********** from Date " + fromDate);
/* 251:266 */       System.out.println("********** to Date " + toDate);
/* 252:267 */       List purorderList = this.purorderDAO.getPurOrderList_dateRange(fromDate, toDate);
/* 253:    */       
/* 254:269 */       List<Purrequisition> purrequisitionList = this.purrequisitionDAO.getList();
/* 255:270 */       HashMap<Integer, String> purrequisitionMap = new HashMap(purrequisitionList.size());
/* 256:271 */       for (Purrequisition purrequisition : purrequisitionList) {
/* 257:272 */         purrequisitionMap.put(purrequisition.getId(), purrequisition.getPrno());
/* 258:    */       }
/* 259:275 */       List<Accounts> accountsList = this.accountsDAO.getList();
/* 260:276 */       HashMap<Integer, String> accountMap = new HashMap(accountsList.size());
/* 261:277 */       for (Accounts account : accountsList) {
/* 262:278 */         accountMap.put(account.getId(), account.getName());
/* 263:    */       }
/* 264:280 */       mav.getModelMap().put("purrequisitionMap", purrequisitionMap);
/* 265:281 */       mav.getModelMap().put("accountMap", accountMap);
/* 266:282 */       mav.getModelMap().put("purorderList", purorderList);
/* 267:283 */       if (success != null) {
/* 268:284 */         mav.getModelMap().put("success", success);
/* 269:    */       }
/* 270:286 */       if (error != null) {
/* 271:287 */         mav.getModelMap().put("error", error);
/* 272:    */       }
/* 273:    */     }
/* 274:290 */     return mav;
/* 275:    */   }
/* 276:    */   
/* 277:    */   private List<Accounts> getSupplierList()
/* 278:    */   {
/* 279:294 */     return this.accountsDAO.getListByFromClause(" FROM Accounts a WHERE a.visible=true and a.type=1");
/* 280:    */   }
/* 281:    */   
/* 282:    */   private List<Purrequisition> getPurrequisitionList()
/* 283:    */   {
/* 284:298 */     return this.purrequisitionDAO.getListByCondition("t where t.status=5");
/* 285:    */   }
/* 286:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.controller.PurorderController
 * JD-Core Version:    0.7.1
 */