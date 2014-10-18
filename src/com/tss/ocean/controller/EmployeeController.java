/*   1:    */ package com.tss.ocean.controller;
/*   2:    */ 
/*   3:    */ import com.techshark.hibernate.base.HibernateDAOFactory;
/*   4:    */ import com.tss.ocean.idao.IBankDAO;
/*   5:    */ import com.tss.ocean.idao.IEmployeeCategoryDAO;
/*   6:    */ import com.tss.ocean.idao.IEmployeeDepartmentDAO;
/*   7:    */ import com.tss.ocean.idao.IEmployeesDAO;
/*   8:    */ import com.tss.ocean.idao.IPurchaseApproverDAO;
/*   9:    */ import com.tss.ocean.pojo.Bank;
/*  10:    */ import com.tss.ocean.pojo.EmployeeCategory;
/*  11:    */ import com.tss.ocean.pojo.EmployeeDepartment;
/*  12:    */ import com.tss.ocean.pojo.Employees;
/*  13:    */ import com.tss.ocean.pojo.PurordApprovers;
/*  14:    */ import com.tss.ocean.util.Utilities;

/*  15:    */ import java.sql.Blob;
/*  16:    */ import java.sql.SQLException;
import java.text.SimpleDateFormat;
/*  17:    */ import java.util.ArrayList;
import java.util.Date;
/*  18:    */ import java.util.HashMap;
/*  19:    */ import java.util.Iterator;
/*  20:    */ import java.util.List;
/*  21:    */ import java.util.Locale;
/*  22:    */ import java.util.Map;

/*  23:    */ import javax.validation.Valid;

/*  24:    */ import org.hibernate.Hibernate;
/*  25:    */ import org.slf4j.Logger;
/*  26:    */ import org.slf4j.LoggerFactory;
/*  27:    */ import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
/*  28:    */ import org.springframework.context.MessageSource;
/*  29:    */ import org.springframework.stereotype.Controller;
/*  30:    */ import org.springframework.ui.Model;
/*  31:    */ import org.springframework.ui.ModelMap;
/*  32:    */ import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
/*  33:    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*  34:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  35:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  36:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  37:    */ import org.springframework.web.multipart.commons.CommonsMultipartFile;
/*  38:    */ import org.springframework.web.servlet.ModelAndView;
/*  39:    */ 
/*  40:    */ @Controller
/*  41:    */ public class EmployeeController
/*  42:    */ {
/*  43: 51 */   private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
/*  44:    */   IEmployeesDAO employeesDAO;
/*  45:    */   @Autowired
/*  46:    */   IEmployeeCategoryDAO employeeCategoryDAO;
/*  47:    */   @Autowired
/*  48:    */   private MessageSource messageSource;
/*  49:    */   @Autowired
/*  50:    */   private IEmployeeDepartmentDAO employeeDepartmentDAO;
/*  51:    */   @Autowired
/*  52:    */   private IBankDAO bankDAO;
/*  53:    */   @Autowired
/*  54:    */   private IPurchaseApproverDAO purchaseApproversDAO;
/*  55:    */   
/*  56:    */   public EmployeeController()
/*  57:    */   {
/*  58: 65 */     this.employeesDAO = new HibernateDAOFactory().getEmployeesDAO();
/*  59:    */   }
/*  60:    */   
/*  61:    */   @RequestMapping(value={"/addemployee.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  62:    */   public ModelAndView addEmployee(@ModelAttribute Employees employee, Model model)
/*  63:    */   {
/*  64: 71 */     logger.debug("addEmployee called :" + employee);
/*  65:    */     
/*  66: 73 */     int status = ((Integer)this.employeesDAO.insert(employee)).intValue();
/*  67: 74 */     logger.debug("addEmployee insert status:" + status);
/*  68:    */     
/*  69: 76 */     return new ModelAndView("employees");
/*  70:    */   }
/*  71:    */   
/*  72:    */   @RequestMapping(value={"/employee_category.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  73:    */   public ModelAndView employeeCategory(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/*  74:    */     throws Exception
/*  75:    */   {
/*  76: 83 */     logger.info("employee_categogy called.");
/*  77: 84 */     ModelAndView mav = new ModelAndView("employee_category");
/*  78: 85 */     List<EmployeeCategory> employeeCategoryList = this.employeeCategoryDAO.getList();
/*  79:    */     
/*  80: 87 */     mav.getModelMap().put("employeeCategoryList", employeeCategoryList);
/*  81: 88 */     if (success != null) {
/*  82: 89 */       mav.getModelMap().put("success", success);
/*  83:    */     }
/*  84: 91 */     if (error != null) {
/*  85: 92 */       mav.getModelMap().put("error", error);
/*  86:    */     }
/*  87: 94 */     return mav;
/*  88:    */   }
/*  89:    */   
/*  90:    */   @RequestMapping(value={"/add_employee_category"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  91:    */   public ModelAndView add_employee_cat_get(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/*  92:    */     throws Exception
/*  93:    */   {
/*  94:101 */     logger.info("add_employee_category called.");
/*  95:102 */     ModelAndView mav = new ModelAndView("add_employee_category");
/*  96:103 */     EmployeeCategory employeeCategory = new EmployeeCategory();
/*  97:104 */     if (success != null) {
/*  98:105 */       mav.getModelMap().put("success", success);
/*  99:    */     }
/* 100:107 */     if (error != null) {
/* 101:108 */       mav.getModelMap().put("error", error);
/* 102:    */     }
/* 103:110 */     mav.getModelMap().put("employeecategory", employeeCategory);
/* 104:111 */     return mav;
/* 105:    */   }
/* 106:    */   
/* 107:    */   @RequestMapping(value={"/add_employee_category.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 108:    */   public ModelAndView addEmployeeCategory(@ModelAttribute("employeecategory") @Valid EmployeeCategory employeeCategory, BindingResult result, ModelMap model, Locale locale)
/* 109:    */     throws Exception
/* 110:    */   {
/* 111:119 */     logger.info("add_employee_category-post called.");
/* 112:120 */     if (!result.hasErrors())
/* 113:    */     {
/* 114:121 */       employeeCategory.setIsActive(Integer.valueOf(1));
/* 115:122 */       int insertResult = ((Integer)this.employeeCategoryDAO.insert(employeeCategory)).intValue();
/* 116:123 */       if (insertResult > 0)
/* 117:    */       {
/* 118:124 */         logger.info("Employee category Added Successfully with id " + insertResult);
/* 119:125 */         return new ModelAndView("redirect:add_employee_category.html").addObject("success", Utilities.getSpringMessage(this.messageSource, "empcategory.add.success", locale));
/* 120:    */       }
/* 121:128 */       logger.info("Error while inserting " + employeeCategory);
/* 122:129 */       return new ModelAndView("add_employee_category", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "empcategory.add.error", locale));
/* 123:    */     }
/* 124:133 */     return new ModelAndView("add_employee_category", model);
/* 125:    */   }
/* 126:    */   
/* 127:    */   @RequestMapping(value={"/edit_employee_category.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 128:    */   public ModelAndView editEmployeeCategoryget(@RequestParam("id") int id, Locale locale, @RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/* 129:    */     throws Exception
/* 130:    */   {
/* 131:143 */     logger.info("edit_employee_category called.");
/* 132:    */     
/* 133:145 */     EmployeeCategory employeeCategory = (EmployeeCategory)this.employeeCategoryDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 134:    */     ModelAndView mav;
/* 135:146 */     if (employeeCategory != null)
/* 136:    */     {
/* 137:147 */        mav = new ModelAndView("edit_employee_category");
/* 138:148 */       mav.getModelMap().put("employeecategory", employeeCategory);
/* 139:    */     }
/* 140:    */     else
/* 141:    */     {
/* 142:151 */       mav = new ModelAndView("redirect:employee_category.html");
/* 143:152 */       List<EmployeeCategory> employeeCategoryList = this.employeeCategoryDAO.getList();
/* 144:153 */       mav.getModelMap().put("employeeCategoryList", employeeCategoryList);
/* 145:    */     }
/* 146:155 */     if (success != null) {
/* 147:156 */       mav.getModelMap().put("success", success);
/* 148:    */     }
/* 149:158 */     if (error != null) {
/* 150:159 */       mav.getModelMap().put("error", error);
/* 151:    */     }
/* 152:161 */     return mav;
/* 153:    */   }
/* 154:    */   
/* 155:    */   @RequestMapping(value={"/edit_employee_category.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 156:    */   public ModelAndView editEmployeeCategoryPost(@ModelAttribute("employeecategory") @Valid EmployeeCategory employeeCategory, BindingResult result, ModelMap model, Locale locale)
/* 157:    */     throws Exception
/* 158:    */   {
/* 159:169 */     logger.info("edit_employee_category-post called.");
/* 160:170 */     if (!result.hasErrors())
/* 161:    */     {
/* 162:171 */       int updateResult = this.employeeCategoryDAO.update(employeeCategory);
/* 163:172 */       if (updateResult > 0)
/* 164:    */       {
/* 165:173 */         logger.info("employee_category updated Successfully with id={0}", Integer.valueOf(updateResult));
/* 166:174 */         ModelAndView mav = new ModelAndView("redirect:employee_category.html");
/* 167:175 */         List<EmployeeCategory> employeeCategoryList = this.employeeCategoryDAO.getList();
/* 168:176 */         mav.getModelMap().put("employeeCategoryList", employeeCategoryList);
/* 169:177 */         return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "empcategory.update.success", locale));
/* 170:    */       }
/* 171:180 */       logger.warn("Error occurred updating employee categry:{0}", employeeCategory);
/* 172:181 */       return new ModelAndView("edit_employee_category", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "empcategory.update.error", locale));
/* 173:    */     }
/* 174:185 */     logger.warn("Employee category values are not valid:", employeeCategory);
/* 175:186 */     return new ModelAndView("edit_employee_category", model);
/* 176:    */   }
/* 177:    */   
/* 178:    */   @RequestMapping({"/delete_employee_category.html"})
/* 179:    */   @ResponseBody
/* 180:    */   public ModelAndView deleteEmployeeCategory(@RequestParam("id") int id, Locale locale)
/* 181:    */     throws Exception
/* 182:    */   {
/* 183:193 */     logger.info("delete_employee_category called.");
/* 184:194 */     EmployeeCategory employeeCategory = (EmployeeCategory)this.employeeCategoryDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 185:195 */     ModelAndView mav = new ModelAndView("redirect:employee_category.html");
/* 186:196 */     List<EmployeeCategory> employeeCategoryList = this.employeeCategoryDAO.getList();
/* 187:197 */     mav.getModelMap().put("employeeCategoryList", employeeCategoryList);
/* 188:198 */     if (employeeCategory != null)
/* 189:    */     {
/* 190:199 */       int updateResult = this.employeeCategoryDAO.delete(employeeCategory);
/* 191:201 */       if (updateResult > 0)
/* 192:    */       {
/* 193:202 */         logger.info("Employee category with id {0} deleted successfully", employeeCategory.getId());
/* 194:    */         
/* 195:204 */         return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "empcategory.delete.success", locale));
/* 196:    */       }
/* 197:207 */       logger.warn("Error occurred while deleting employee category with id {0}", employeeCategory.getId());
/* 198:208 */       return mav.addObject("error", Utilities.getSpringMessage(this.messageSource, "empcategory.delete.error", locale));
/* 199:    */     }
/* 200:212 */     logger.info("Employee category with id {0} is already deleted", employeeCategory.getId());
/* 201:213 */     return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "empcategory.delete.success", locale));
/* 202:    */   }
/* 203:    */   
/* 204:    */   @RequestMapping(value={"/employee_department.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 205:    */   public ModelAndView employeeDepartment(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/* 206:    */     throws Exception
/* 207:    */   {
/* 208:221 */     logger.info("employee_department called.");
/* 209:222 */     ModelAndView mav = new ModelAndView("employee_department");
/* 210:223 */     List<EmployeeDepartment> employeeDepartmentList = this.employeeDepartmentDAO.getList();
/* 211:    */     
/* 212:225 */     mav.getModelMap().put("employeeDepartmentList", employeeDepartmentList);
/* 213:226 */     if (success != null) {
/* 214:227 */       mav.getModelMap().put("success", success);
/* 215:    */     }
/* 216:229 */     if (error != null) {
/* 217:230 */       mav.getModelMap().put("error", error);
/* 218:    */     }
/* 219:232 */     return mav;
/* 220:    */   }
/* 221:    */   
/* 222:    */   @RequestMapping(value={"/add_employee_department.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 223:    */   public ModelAndView addEmployeeDeptGet(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/* 224:    */     throws Exception
/* 225:    */   {
/* 226:239 */     logger.info("add_employee_department called.");
/* 227:240 */     ModelAndView mav = new ModelAndView("add_employee_department");
/* 228:241 */     EmployeeDepartment employeeDepartment = new EmployeeDepartment();
/* 229:242 */     if (success != null) {
/* 230:243 */       mav.getModelMap().put("success", success);
/* 231:    */     }
/* 232:245 */     if (error != null) {
/* 233:246 */       mav.getModelMap().put("error", error);
/* 234:    */     }
/* 235:248 */     mav.getModelMap().put("employeedepartment", employeeDepartment);
/* 236:249 */     return mav;
/* 237:    */   }
/* 238:    */   
/* 239:    */   @RequestMapping(value={"/add_employee_department.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 240:    */   public ModelAndView addEmployeeDepartment(@ModelAttribute("employeedepartment") @Valid EmployeeDepartment employeeDepartment, BindingResult result, ModelMap model, Locale locale)
/* 241:    */     throws Exception
/* 242:    */   {
/* 243:257 */     logger.info("add_employee_department-post called.");
/* 244:258 */     if (!result.hasErrors())
/* 245:    */     {
/* 246:259 */       int insertResult = ((Integer)this.employeeDepartmentDAO.insert(employeeDepartment)).intValue();
/* 247:260 */       if (insertResult > 0)
/* 248:    */       {
/* 249:261 */         logger.info("Employee Department Added Successfully with id " + insertResult);
/* 250:262 */         return new ModelAndView("redirect:add_employee_department.html").addObject("success", Utilities.getSpringMessage(this.messageSource, "empdepartment.add.success", locale));
/* 251:    */       }
/* 252:265 */       logger.info("Error while inserting " + employeeDepartment);
/* 253:266 */       return new ModelAndView("add_employee_department", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "empdepartment.add.error", locale));
/* 254:    */     }
/* 255:270 */     return new ModelAndView("add_employee_department", model);
/* 256:    */   }
/* 257:    */   
/* 258:    */   @RequestMapping(value={"/edit_employee_department.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 259:    */   public ModelAndView editEmployeeDepartmentGet(@RequestParam("id") int id, Locale locale, @RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/* 260:    */     throws Exception
/* 261:    */   {
/* 262:280 */     logger.info("edit_employee_department called.");
/* 263:    */     
/* 264:282 */     EmployeeDepartment employeeDepartment = (EmployeeDepartment)this.employeeDepartmentDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 265:    */     ModelAndView mav;
/* 266:283 */     if (employeeDepartment != null)
/* 267:    */     {
/* 268:284 */        mav = new ModelAndView("edit_employee_department");
/* 269:285 */       mav.getModelMap().put("employeedepartment", employeeDepartment);
/* 270:    */     }
/* 271:    */     else
/* 272:    */     {
/* 273:287 */       mav = new ModelAndView("redirect:employee_department.html");
/* 274:288 */       List<EmployeeDepartment> employeeDepartmentList = this.employeeDepartmentDAO.getList();
/* 275:289 */       mav.getModelMap().put("employeeDepartmentList", employeeDepartmentList);
/* 276:    */     }
/* 277:291 */     if (success != null) {
/* 278:292 */       mav.getModelMap().put("success", success);
/* 279:    */     }
/* 280:294 */     if (error != null) {
/* 281:295 */       mav.getModelMap().put("error", error);
/* 282:    */     }
/* 283:297 */     return mav;
/* 284:    */   }
/* 285:    */   
/* 286:    */   @RequestMapping(value={"/edit_employee_department.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 287:    */   public ModelAndView editEmployeeDepartmentPost(@ModelAttribute("employeedepartment") @Valid EmployeeDepartment employeeDepartment, BindingResult result, ModelMap model, Locale locale)
/* 288:    */     throws Exception
/* 289:    */   {
/* 290:305 */     logger.info("edit_employee_department-post called.");
/* 291:306 */     if (!result.hasErrors())
/* 292:    */     {
/* 293:307 */       int updateResult = this.employeeDepartmentDAO.update(employeeDepartment);
/* 294:308 */       if (updateResult > 0)
/* 295:    */       {
/* 296:309 */         logger.info("employee_departmen updated Successfully with id={0}", Integer.valueOf(updateResult));
/* 297:310 */         ModelAndView mav = new ModelAndView("redirect:employee_department.html");
/* 298:311 */         List<EmployeeDepartment> employeeDepartmentList = this.employeeDepartmentDAO.getList();
/* 299:312 */         mav.getModelMap().put("employeeDepartmentList", employeeDepartmentList);
/* 300:313 */         return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "empdepartment.update.success", locale));
/* 301:    */       }
/* 302:316 */       logger.warn("Error occurred updating employee Department:{0}", employeeDepartment);
/* 303:317 */       return new ModelAndView("edit_employee_department", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "empdepartment.update.error", locale));
/* 304:    */     }
/* 305:321 */     logger.warn("Employee department values are not valid:", employeeDepartment);
/* 306:322 */     return new ModelAndView("edit_employee_department", model);
/* 307:    */   }
/* 308:    */   
/* 309:    */   @RequestMapping({"/delete_employee_department.html"})
/* 310:    */   @ResponseBody
/* 311:    */   public ModelAndView deleteEmployeeDepartment(@RequestParam("id") int id, Locale locale)
/* 312:    */     throws Exception
/* 313:    */   {
/* 314:329 */     logger.info("delete_employee_department called.");
/* 315:330 */     EmployeeDepartment employeeDepartment = (EmployeeDepartment)this.employeeDepartmentDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 316:331 */     ModelAndView mav = new ModelAndView("redirect:employee_department.html");
/* 317:332 */     List<EmployeeDepartment> employeeDepartmentList = this.employeeDepartmentDAO.getList();
/* 318:333 */     mav.getModelMap().put("employeeDepartmentList", employeeDepartmentList);
/* 319:334 */     if (employeeDepartment != null)
/* 320:    */     {
/* 321:335 */       int updateResult = this.employeeDepartmentDAO.delete(employeeDepartment);
/* 322:337 */       if (updateResult > 0)
/* 323:    */       {
/* 324:338 */         logger.info("Employee department with id {0} deleted successfully", employeeDepartment.getId());
/* 325:    */         
/* 326:340 */         return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "empdepartment.delete.success", locale));
/* 327:    */       }
/* 328:343 */       logger.warn("Error occurred while deleting employee department with id {0}", employeeDepartment.getId());
/* 329:344 */       return mav.addObject("error", Utilities.getSpringMessage(this.messageSource, "empcategory.delete.error", locale));
/* 330:    */     }
/* 331:348 */     logger.info("Employee Department with id {0} is already deleted", employeeDepartment.getId());
/* 332:349 */     return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "empdepartment.delete.error", locale));
/* 333:    */   }
/* 334:    */   
/* 335:    */   @RequestMapping(value={"/employee.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 336:    */   public ModelAndView getEmployyes(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/* 337:    */     throws Exception
/* 338:    */   {
/* 339:357 */     logger.info("employee called.");
/* 340:358 */     ModelAndView mav = new ModelAndView("employee");
/* 341:359 */     List<Employees> employeeList = this.employeesDAO.getList();
/* 342:360 */     Map<Integer, String> departmentMap = new HashMap();
/* 343:361 */     Map<Integer, String> categoryMap = new HashMap();
/* 344:362 */     mav.getModelMap().put("employeeList", employeeList);
/* 345:363 */     List<EmployeeDepartment> departmentList = this.employeeDepartmentDAO.getList();
/* 346:364 */     for (EmployeeDepartment employeeDepartment : departmentList) {
/* 347:365 */       departmentMap.put(employeeDepartment.getId(), employeeDepartment.getDepartment());
/* 348:    */     }
/* 349:367 */     mav.getModelMap().put("departmentmap", departmentMap);
/* 350:    */     
/* 351:369 */     List<EmployeeCategory> categoryList = this.employeeCategoryDAO.getList();
/* 352:370 */     for (EmployeeCategory employeeCategory : categoryList) {
/* 353:371 */       categoryMap.put(employeeCategory.getId(), employeeCategory.getCategory());
/* 354:    */     }
/* 355:373 */     mav.getModelMap().put("categorymap", categoryMap);
/* 356:374 */     if (success != null) {
/* 357:375 */       mav.getModelMap().put("success", success);
/* 358:    */     }
/* 359:377 */     if (error != null) {
/* 360:378 */       mav.getModelMap().put("error", error);
/* 361:    */     }
/* 362:380 */     return mav;
/* 363:    */   }
/* 364:    */   
/* 365:    */   @RequestMapping(value={"/add_employee"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 366:    */   public ModelAndView addEmployeeGet(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/* 367:    */     throws Exception
/* 368:    */   {
/* 369:387 */     logger.info("add_employee called.");
/* 370:388 */     ModelAndView mav = new ModelAndView("add_employee");
/* 371:389 */     Employees employee = new Employees();
/* 372:390 */     if (success != null) {
/* 373:391 */       mav.getModelMap().put("success", success);
/* 374:    */     }
/* 375:393 */     if (error != null) {
/* 376:394 */       mav.getModelMap().put("error", error);
/* 377:    */     }
/* 378:396 */     List<Employees> employeeList = this.employeesDAO.getList();
/* 379:397 */     List<EmployeeDepartment> departmentList = this.employeeDepartmentDAO.getList();
/* 380:398 */     List<EmployeeCategory> categoryList = this.employeeCategoryDAO.getList();
/* 381:399 */     List<Bank> bankList = this.bankDAO.getList();
/* 382:400 */     mav.getModelMap().put("employee", employee);
/* 383:401 */     mav.getModelMap().put("employeeDepartmentList", departmentList);
/* 384:402 */     mav.getModelMap().put("employeeCategoryList", categoryList);
/* 385:403 */     mav.getModelMap().put("employeeList", employeeList);
/* 386:404 */     mav.getModelMap().put("bankList", bankList);
/* 387:405 */     return mav;
/* 388:    */   }
/* 389:    */   
/* 390:    */   @RequestMapping(value={"/add_employee.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 391:    */   public ModelAndView addEmployeePost(@ModelAttribute("employee") @Valid Employees employees, BindingResult result, ModelMap model, Locale locale)
/* 392:    */     throws Exception
/* 393:    */   {
/* 394:413 */     logger.info("add_employee Post called.");
/* 395:414 */     ModelAndView mav = new ModelAndView("redirect:add_employee.html");
/* 396:415 */    
System.out.println("ERRORS OCCURED"+result.getAllErrors().size());


for (ObjectError e:result.getAllErrors())
{
	System.out.println(e.toString());
}

if (!result.hasErrors())
/* 397:    */     {
/* 398:416 */       if (employees.getFileData() != null)
/* 399:    */       {
/* 400:417 */         employees.setPhotoData(Hibernate.createBlob(employees.getFileData().getInputStream()));
/* 401:418 */         employees.setPhotoFileName(employees.getFileData().getOriginalFilename());
/* 402:419 */         employees.setPhotoContentType(employees.getFileData().getContentType());
/* 403:420 */         employees.setPhotoFileSize(Integer.valueOf(new Long(employees.getFileData().getSize()).intValue()));
/* 404:    */       }
/* 405:422 */       int insertResult = ((Integer)this.employeesDAO.insert(employees)).intValue();
/* 406:423 */      
System.out.println("HAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSNNNNNNNNNNNOOOOOOOOOOOEEEEEEEEERRRRRRRRRRRR"+employees.toString());

List<Employees> employeeList = this.employeesDAO.getList();
/* 407:424 */       List<EmployeeDepartment> departmentList = this.employeeDepartmentDAO.getList();
/* 408:425 */       List<EmployeeCategory> categoryList = this.employeeCategoryDAO.getList();
/* 409:426 */       List<Bank> bankList = this.bankDAO.getList();
/* 410:427 */       mav.getModelMap().put("employee", employees);
/* 411:428 */       mav.getModelMap().put("employeeDepartmentList", departmentList);
/* 412:429 */       mav.getModelMap().put("employeeCategoryList", categoryList);
/* 413:430 */       mav.getModelMap().put("employeeList", employeeList);
/* 414:431 */       mav.getModelMap().put("bankList", bankList);
/* 415:432 */       if (insertResult > 0)
/* 416:    */       {
/* 417:433 */         logger.info("Employee category Added Successfully with id " + insertResult);
/* 418:434 */         return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "employee.add.success", locale));
/* 419:    */       }
/* 420:436 */       logger.info("Error while inserting " + employees);
/* 421:437 */       return mav.addObject("error", Utilities.getSpringMessage(this.messageSource, "employee.add.error", locale));
/* 422:    */     }


System.out.println("_________________________"+employees.toString());

/* 423:440 */     return new ModelAndView("add_employee", model);
/* 424:    */   }
/* 425:    */   
/* 426:    */   @RequestMapping(value={"/edit_employee.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 427:    */   public ModelAndView editEmployeeGet(@RequestParam("id") int id, Locale locale, @RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/* 428:    */     throws Exception
/* 429:    */   {
/* 430:450 */     logger.info("edit_employee called.");
/* 431:    */     
/* 432:452 */     Employees employees = (Employees)this.employeesDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 433:    */     ModelAndView mav;
/* 434:453 */     if (employees != null)
/* 435:    */     {
/* 436:454 */        mav = new ModelAndView("edit_employee");
/* 437:455 */       mav.getModelMap().put("employee", employees);
/* 438:456 */       List<Employees> employeeList = this.employeesDAO.getList();
/* 439:457 */       List<EmployeeDepartment> departmentList = this.employeeDepartmentDAO.getList();
/* 440:458 */       List<EmployeeCategory> categoryList = this.employeeCategoryDAO.getList();
/* 441:459 */       List<Bank> bankList = this.bankDAO.getList();
/* 442:460 */       mav.getModelMap().put("employeeDepartmentList", departmentList);
/* 443:461 */       mav.getModelMap().put("employeeCategoryList", categoryList);
/* 444:462 */       mav.getModelMap().put("employeeList", employeeList);
/* 445:463 */       mav.getModelMap().put("bankList", bankList);
/* 446:    */     }
/* 447:    */     else
/* 448:    */     {
/* 449:466 */       mav = new ModelAndView("redirect:employee.html");
/* 450:467 */       List<Employees> employeeList = this.employeesDAO.getList();
/* 451:468 */       Map<Integer, String> departmentMap = new HashMap();
/* 452:469 */       Map<Integer, String> categoryMap = new HashMap();
/* 453:470 */       mav.getModelMap().put("employeeList", employeeList);
/* 454:471 */       List<EmployeeDepartment> departmentList = this.employeeDepartmentDAO.getList();
/* 455:472 */       for (EmployeeDepartment employeeDepartment : departmentList) {
/* 456:473 */         departmentMap.put(employeeDepartment.getId(), employeeDepartment.getDepartment());
/* 457:    */       }
/* 458:475 */       mav.getModelMap().put("departmentmap", departmentMap);
/* 459:    */       
/* 460:477 */       List<EmployeeCategory> categoryList = this.employeeCategoryDAO.getList();
/* 461:478 */       for (EmployeeCategory employeeCategory : categoryList) {
/* 462:479 */         categoryMap.put(employeeCategory.getId(), employeeCategory.getCategory());
/* 463:    */       }
/* 464:481 */       mav.getModelMap().put("categorymap", categoryMap);
/* 465:    */     }
/* 466:483 */     if (success != null) {
/* 467:484 */       mav.getModelMap().put("success", success);
/* 468:    */     }
/* 469:486 */     if (error != null) {
/* 470:487 */       mav.getModelMap().put("error", error);
/* 471:    */     }
/* 472:489 */     return mav;
/* 473:    */   }
/* 474:    */   
/* 475:    */   @RequestMapping(value={"/edit_employee.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 476:    */   public ModelAndView editEmployeePost(@ModelAttribute("employee") @Valid Employees employees, BindingResult result, ModelMap model, Locale locale)
/* 477:    */     throws Exception
/* 478:    */   {
/* 479:497 */     logger.info("edit_employee-post called.");
/* 480:498 */     ModelAndView mav = new ModelAndView("redirect:employee.html");
/* 481:499 */    

System.out.println("ERRORS OCCURED"+result.getAllErrors().size());


for (ObjectError e:result.getAllErrors())
{
	System.out.println(e.toString());
}

System.out.println("____________RRRRRRRRR_____________"+employees.getPassportExpiryDate());


if (!result.hasErrors())
/* 482:    */     {
/* 483:500 */       if (employees.getFileData() != null)
/* 484:    */       {
/* 485:501 */         employees.setPhotoData(Hibernate.createBlob(employees.getFileData().getInputStream()));
/* 486:502 */         employees.setPhotoFileName(employees.getFileData().getOriginalFilename());
/* 487:503 */         employees.setPhotoContentType(employees.getFileData().getContentType());
/* 488:504 */         employees.setPhotoFileSize(Integer.valueOf(new Long(employees.getFileData().getSize()).intValue()));
/* 489:    */       }
/* 490:506 */       int updateResult = this.employeesDAO.update(employees);
/* 491:507 */       List<Employees> employeeList = this.employeesDAO.getList();
/* 492:508 */       Map<Integer, String> departmentMap = new HashMap();
/* 493:509 */       Map<Integer, String> categoryMap = new HashMap();
/* 494:510 */       mav.getModelMap().put("employeeList", employeeList);
/* 495:511 */       List<EmployeeDepartment> departmentList = this.employeeDepartmentDAO.getList();
/* 496:512 */       for (EmployeeDepartment employeeDepartment : departmentList) {
/* 497:513 */         departmentMap.put(employeeDepartment.getId(), employeeDepartment.getDepartment());
/* 498:    */       }
/* 499:515 */       mav.getModelMap().put("departmentmap", departmentMap);
/* 500:    */       
/* 501:517 */       List<EmployeeCategory> categoryList = this.employeeCategoryDAO.getList();
/* 502:518 */       for (EmployeeCategory employeeCategory : categoryList) {
/* 503:519 */         categoryMap.put(employeeCategory.getId(), employeeCategory.getCategory());
/* 504:    */       }
/* 505:521 */       mav.getModelMap().put("categorymap", categoryMap);
/* 506:522 */       if (updateResult > 0)
/* 507:    */       {
/* 508:523 */         logger.info("employee  updated Successfully with id={0}", Integer.valueOf(updateResult));
/* 509:    */         
/* 510:525 */         List<EmployeeCategory> employeeCategoryList = this.employeeCategoryDAO.getList();
/* 511:526 */         mav.getModelMap().put("employeeCategoryList", employeeCategoryList);
/* 512:527 */         return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "employee.update.success", locale));
/* 513:    */       }
/* 514:530 */       logger.warn("Error occurred updating employee categry:{0}", employees);
/* 515:531 */     


/*return new ModelAndView("edit_employee", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "employee.update.error", locale));
*//* 516:    */     }
/* 517:535 */     logger.warn("Employee  values are not valid:", employees);
/* 518:536 */     List<Employees> employeeList = this.employeesDAO.getList();
/* 519:537 */     List<EmployeeDepartment> departmentList = this.employeeDepartmentDAO.getList();
/* 520:538 */     List<EmployeeCategory> categoryList = this.employeeCategoryDAO.getList();
/* 521:539 */     List<Bank> bankList = this.bankDAO.getList();
/* 522:540 */     mav.getModelMap().put("employeeDepartmentList", departmentList);
/* 523:541 */     mav.getModelMap().put("employeeCategoryList", categoryList);
/* 524:542 */     mav.getModelMap().put("employeeList", employeeList);
/* 525:543 */     mav.getModelMap().put("bankList", bankList);
/* 526:544 */     return new ModelAndView("edit_employee", model);
/* 527:    */   }
/* 528:    */   
/* 529:    */   @RequestMapping(value={"/employee_image.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 530:    */   @ResponseBody
/* 531:    */   public byte[] getImage(@RequestParam("id") int id, Locale locale, @RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/* 532:    */     throws SQLException
/* 533:    */   {
/* 534:555 */     logger.info("emoloyeeimage called.");
/* 535:556 */     Employees employees = (Employees)this.employeesDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 536:558 */     if (employees.getPhotoData() != null)
/* 537:    */     {
/* 538:559 */       int blobLength = (int)employees.getPhotoData().length();
/* 539:560 */       byte[] blobAsBytes = employees.getPhotoData().getBytes(1L, blobLength);
/* 540:561 */       return blobAsBytes;
/* 541:    */     }
/* 542:563 */     return null;
/* 543:    */   }
/* 544:    */   
/* 545:    */   @RequestMapping(value={"/delete_employee.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 546:    */   @ResponseBody
/* 547:    */   public ModelAndView deleteEmployee(@RequestParam("id") int id, Locale locale)
/* 548:    */     throws Exception
/* 549:    */   {
/* 550:570 */     logger.info("delete_employee called.");
/* 551:571 */     Employees employees = (Employees)this.employeesDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 552:572 */     ModelAndView mav = new ModelAndView("redirect:employee.html");
/* 553:573 */     List<Employees> employeeList = this.employeesDAO.getList();
/* 554:574 */     Map<Integer, String> departmentMap = new HashMap();
/* 555:575 */     Map<Integer, String> categoryMap = new HashMap();
/* 556:576 */     mav.getModelMap().put("employeeList", employeeList);
/* 557:577 */     List<EmployeeDepartment> departmentList = this.employeeDepartmentDAO.getList();
/* 558:578 */     for (EmployeeDepartment employeeDepartment : departmentList) {
/* 559:579 */       departmentMap.put(employeeDepartment.getId(), employeeDepartment.getDepartment());
/* 560:    */     }
/* 561:581 */     mav.getModelMap().put("departmentmap", departmentMap);
/* 562:    */     
/* 563:583 */     List<EmployeeCategory> categoryList = this.employeeCategoryDAO.getList();
/* 564:584 */     for (EmployeeCategory employeeCategory : categoryList) {
/* 565:585 */       categoryMap.put(employeeCategory.getId(), employeeCategory.getCategory());
/* 566:    */     }
/* 567:587 */     mav.getModelMap().put("categorymap", categoryMap);
/* 568:588 */     if (employees != null)
/* 569:    */     {
/* 570:589 */       int updateResult = this.employeesDAO.delete(employees);
/* 571:591 */       if (updateResult > 0)
/* 572:    */       {
/* 573:592 */         logger.info("Employee  with id {0} deleted successfully", employees.getId());
/* 574:    */         
/* 575:594 */         return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "employee.delete.success", locale));
/* 576:    */       }
/* 577:597 */       logger.warn("Error occurred while deleting employee  with id {0}", employees.getId());
/* 578:598 */       return mav.addObject("error", Utilities.getSpringMessage(this.messageSource, "employee.delete.error", locale));
/* 579:    */     }
/* 580:602 */     logger.info("Employee Department with id {0} is already deleted", employees.getId());
/* 581:603 */     return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "employee.delete.error", locale));
/* 582:    */   }
/* 583:    */   
/* 584:    */   @RequestMapping(value={"/AddApprover.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 585:    */   public String add_approverGet(Map<String, Object> model)
/* 586:    */     throws Exception
/* 587:    */   {
/* 588:611 */     logger.debug("get add-approver called.");
/* 589:612 */     List<Employees> empList = this.employeesDAO.getList();
/* 590:613 */     List<Employees> empselected = new ArrayList();
/* 591:    */     
/* 592:615 */     List<PurordApprovers> approvers = this.purchaseApproversDAO.getListByCondition("t order by t.level");
/* 593:616 */     if (approvers != null)
/* 594:    */     {
/* 595:617 */       Iterator<PurordApprovers> iterate = approvers.iterator();
/* 596:618 */       while (iterate.hasNext())
/* 597:    */       {
/* 598:619 */         PurordApprovers purordApprovers = (PurordApprovers)iterate.next();
/* 599:620 */         Employees emp = (Employees)this.employeesDAO.getRecordByPrimaryKey(Integer.valueOf(purordApprovers.getUserid()));
/* 600:621 */         empselected.add(emp);
/* 601:622 */         empList.remove(emp);
/* 602:    */       }
/* 603:    */     }
/* 604:626 */     logger.debug("get add-approver :" + empList.size() + ":" + empselected.size());
/* 605:627 */     model.put("emplist", empList);
/* 606:628 */     model.put("empselected", empselected);
/* 607:    */     
/* 608:    */ 
/* 609:    */ 
/* 610:    */ 
/* 611:    */ 
/* 612:634 */     return "add-purchase_approver";
/* 613:    */   }
/* 614:    */   
/* 615:    */   @RequestMapping(value={"/AddApprover.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 616:    */   public String add_approverPost(@RequestParam("users") int[] users, Map<String, Object> model)
/* 617:    */     throws Exception
/* 618:    */   {
/* 619:640 */     logger.debug("add-item called.");
/* 620:641 */     List<Employees> empList = this.employeesDAO.getList();
/* 621:642 */     List<Employees> empselected = new ArrayList();
/* 622:    */     
/* 623:644 */     List<PurordApprovers> approvers = this.purchaseApproversDAO.getListByCondition("t order by t.level");
/* 624:645 */     if (approvers != null)
/* 625:    */     {
/* 626:646 */       Iterator<PurordApprovers> iterate = approvers.iterator();
/* 627:647 */       while (iterate.hasNext())
/* 628:    */       {
/* 629:648 */         PurordApprovers purordApprovers = (PurordApprovers)iterate.next();
/* 630:649 */         Employees emp = (Employees)this.employeesDAO.getRecordByPrimaryKey(Integer.valueOf(purordApprovers.getUserid()));
/* 631:650 */         empselected.add(emp);
/* 632:651 */         empList.remove(emp);
/* 633:    */       }
/* 634:    */     }
/* 635:654 */     model.put("emplist", empList);
/* 636:655 */     model.put("empselected", empselected);
/* 637:    */     
/* 638:    */ 
/* 639:    */ 
/* 640:    */ 
/* 641:660 */     return "add-purchase_approver";
/* 642:    */   }



/* 426:    */   @RequestMapping(value={"/view_employee.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 427:    */   public ModelAndView printemp(@RequestParam("id") int id, Locale locale, @RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/* 428:    */     throws Exception
/* 429:    */   {
/* 430:450 */     logger.info("edit_employee called.");
/* 431:    */     
/* 432:452 */     Employees employees = (Employees)this.employeesDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 433:    */     ModelAndView mav;
/* 434:453 */     if (employees != null)
/* 435:    */     {
/* 436:454 */        mav = new ModelAndView("print_employee");
/* 437:455 */       mav.getModelMap().put("employee", employees);
/* 438:456 */       List<Employees> employeeList = this.employeesDAO.getList();
/* 439:457 */       List<EmployeeDepartment> departmentList = this.employeeDepartmentDAO.getList();
/* 440:458 */       List<EmployeeCategory> categoryList = this.employeeCategoryDAO.getList();
/* 441:459 */       List<Bank> bankList = this.bankDAO.getList();
/* 442:460 */       mav.getModelMap().put("employeeDepartmentList", departmentList);
/* 443:461 */       mav.getModelMap().put("employeeCategoryList", categoryList);
/* 444:462 */       mav.getModelMap().put("employeeList", employeeList);
/* 444:462 */       mav.getModelMap().put("employee", employees);

/* 445:463 */       mav.getModelMap().put("bankList", bankList);
/* 446:    */     }
/* 447:    */     else
/* 448:    */     {
/* 449:466 */       mav = new ModelAndView("redirect:employee.html");
/* 450:467 */       List<Employees> employeeList = this.employeesDAO.getList();
/* 451:468 */       Map<Integer, String> departmentMap = new HashMap();
/* 452:469 */       Map<Integer, String> categoryMap = new HashMap();
/* 453:470 */       mav.getModelMap().put("employeeList", employeeList);
/* 454:471 */       List<EmployeeDepartment> departmentList = this.employeeDepartmentDAO.getList();
/* 455:472 */       for (EmployeeDepartment employeeDepartment : departmentList) {
/* 456:473 */         departmentMap.put(employeeDepartment.getId(), employeeDepartment.getDepartment());
/* 457:    */       }
/* 458:475 */       mav.getModelMap().put("departmentmap", departmentMap);
/* 459:    */       
/* 460:477 */       List<EmployeeCategory> categoryList = this.employeeCategoryDAO.getList();
/* 461:478 */       for (EmployeeCategory employeeCategory : categoryList) {
/* 462:479 */         categoryMap.put(employeeCategory.getId(), employeeCategory.getCategory());
/* 463:    */       }
/* 464:481 */       mav.getModelMap().put("categorymap", categoryMap);
/* 465:    */     }
/* 466:483 */     if (success != null) {
/* 467:484 */       mav.getModelMap().put("success", success);
/* 468:    */     }
/* 469:486 */     if (error != null) {
/* 470:487 */       mav.getModelMap().put("error", error);
/* 471:    */     }
/* 472:489 */     return mav;
/* 473:    */   }













 }

