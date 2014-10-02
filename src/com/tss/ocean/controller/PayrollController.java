/*   1:    */ package com.tss.ocean.controller;
/*   2:    */ 
/*   3:    */ import com.tss.ocean.idao.IEmployeesDAO;
/*   4:    */ import com.tss.ocean.idao.IMonthlyPayslipsDAO;
/*   5:    */ import com.tss.ocean.idao.IPayrollCategoriesDAO;
/*   6:    */ import com.tss.ocean.pojo.Employees;
/*   7:    */ import com.tss.ocean.pojo.MonthlyPayslips;
/*   8:    */ import com.tss.ocean.pojo.PayrollCategories;
/*   9:    */ import com.tss.ocean.pojo.Payslip;
/*  10:    */ import com.tss.ocean.pojo.PayslipContainer;
/*  11:    */ import com.tss.ocean.util.Utilities;
/*  12:    */ import java.util.ArrayList;
/*  13:    */ import java.util.Calendar;
/*  14:    */ import java.util.Date;
/*  15:    */ import java.util.HashMap;
/*  16:    */ import java.util.List;
/*  17:    */ import java.util.Locale;
/*  18:    */ import java.util.Map;
/*  19:    */ import javax.servlet.http.HttpServletRequest;
/*  20:    */ import javax.servlet.http.HttpSession;
/*  21:    */ import javax.validation.Valid;
/*  22:    */ import org.slf4j.Logger;
/*  23:    */ import org.slf4j.LoggerFactory;
/*  24:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  25:    */ import org.springframework.context.MessageSource;
/*  26:    */ import org.springframework.stereotype.Controller;
/*  27:    */ import org.springframework.ui.ModelMap;
/*  28:    */ import org.springframework.validation.BindingResult;
/*  29:    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*  30:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  31:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  32:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  33:    */ import org.springframework.web.servlet.ModelAndView;
/*  34:    */ 
/*  35:    */ @Controller
/*  36:    */ public class PayrollController
/*  37:    */ {
/*  38: 47 */   private static final Logger LOGGER = LoggerFactory.getLogger(PayrollController.class);
/*  39:    */   @Autowired
/*  40:    */   IPayrollCategoriesDAO payrollCategoriesDAO;
/*  41:    */   @Autowired
/*  42:    */   IMonthlyPayslipsDAO monthlyPayslipsDAO;
/*  43:    */   @Autowired
/*  44:    */   IEmployeesDAO employeesDAO;
/*  45:    */   @Autowired
/*  46:    */   private MessageSource messageSource;
/*  47:    */   
/*  48:    */   @RequestMapping(value={"/payroll_category.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  49:    */   public ModelAndView employeeCategory(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/*  50:    */     throws Exception
/*  51:    */   {
/*  52: 63 */     LOGGER.info("payroll_category called.");
/*  53: 64 */     ModelAndView mav = new ModelAndView("payroll_category");
/*  54: 65 */     List<PayrollCategories> payrollcategoryList = this.payrollCategoriesDAO.getList();
/*  55: 66 */     HashMap<Integer, String> payrollCategorymap = new HashMap(payrollcategoryList.size());
/*  56: 67 */     for (PayrollCategories payrollCategories : payrollcategoryList) {
/*  57: 68 */       payrollCategorymap.put(payrollCategories.getId(), payrollCategories.getName());
/*  58:    */     }
/*  59: 70 */     mav.getModelMap().put("payrollCategoryList", payrollcategoryList);
/*  60: 71 */     mav.getModelMap().put("payrollCategorymap", payrollCategorymap);
/*  61: 72 */     if (success != null) {
/*  62: 73 */       mav.getModelMap().put("success", success);
/*  63:    */     }
/*  64: 75 */     if (error != null) {
/*  65: 76 */       mav.getModelMap().put("error", error);
/*  66:    */     }
/*  67: 78 */     return mav;
/*  68:    */   }
/*  69:    */   
/*  70:    */   @RequestMapping(value={"/add_payroll_category"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  71:    */   public ModelAndView addpayrollCategoryGet(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/*  72:    */     throws Exception
/*  73:    */   {
/*  74: 85 */     LOGGER.info("add_payroll_category called.");
/*  75: 86 */     ModelAndView mav = new ModelAndView("add_payroll_category");
/*  76: 87 */     PayrollCategories payrollCategories = new PayrollCategories();
/*  77: 88 */     if (success != null) {
/*  78: 89 */       mav.getModelMap().put("success", success);
/*  79:    */     }
/*  80: 91 */     if (error != null) {
/*  81: 92 */       mav.getModelMap().put("error", error);
/*  82:    */     }
/*  83: 94 */     List<PayrollCategories> payrollcategoryList = this.payrollCategoriesDAO.getList();
/*  84: 95 */     mav.getModelMap().put("payrollCategoryList", payrollcategoryList);
/*  85: 96 */     mav.getModelMap().put("payrollcategory", payrollCategories);
/*  86: 97 */     return mav;
/*  87:    */   }
/*  88:    */   
/*  89:    */   @RequestMapping(value={"/add_payroll_category.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  90:    */   public ModelAndView addPayrollCategoryPost(@ModelAttribute("payrollcategory") @Valid PayrollCategories payrollCategories, BindingResult result, ModelMap model, Locale locale)
/*  91:    */     throws Exception
/*  92:    */   {
/*  93:105 */     LOGGER.info("add_payroll_category-post called.");
/*  94:106 */     if (!result.hasErrors())
/*  95:    */     {
/*  96:107 */       int insertResult = ((Integer)this.payrollCategoriesDAO.insert(payrollCategories)).intValue();
/*  97:108 */       if (insertResult > 0)
/*  98:    */       {
/*  99:109 */         LOGGER.info("Payroll category Added Successfully with id " + insertResult);
/* 100:110 */         return new ModelAndView("redirect:add_payroll_category.html").addObject("success", Utilities.getSpringMessage(this.messageSource, "payrollcategory.add.success", locale));
/* 101:    */       }
/* 102:113 */       LOGGER.info("Error while inserting " + payrollCategories);
/* 103:114 */       return new ModelAndView("add_payroll_category", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "payrollcategory.add.error", locale));
/* 104:    */     }
/* 105:118 */     return new ModelAndView("add_payroll_category", model);
/* 106:    */   }
/* 107:    */   
/* 108:    */   @RequestMapping(value={"/edit_payroll_category.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 109:    */   public ModelAndView editPayrollCategoryGet(@RequestParam("id") int id, Locale locale, @RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/* 110:    */     throws Exception
/* 111:    */   {
/* 112:128 */     LOGGER.info("edit_payroll_category called.");
/* 113:    */     
/* 114:130 */     PayrollCategories payrollCategories = (PayrollCategories)this.payrollCategoriesDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 115:131 */     List<PayrollCategories> payrollcategoryList = this.payrollCategoriesDAO.getList();
/* 116:    */     ModelAndView mav;
/* 117:132 */     if (payrollCategories != null)
/* 118:    */     {
/* 119:133 */        mav = new ModelAndView("edit_payroll_category");
/* 120:134 */       mav.getModelMap().put("payrollCategoryList", payrollcategoryList);
/* 121:135 */       mav.getModelMap().put("payrollcategory", payrollCategories);
/* 122:    */     }
/* 123:    */     else
/* 124:    */     {
/* 125:137 */       mav = new ModelAndView("redirect:payroll_category.html");
/* 126:138 */       HashMap<Integer, String> payrollCategorymap = new HashMap(payrollcategoryList.size());
/* 127:139 */       for (PayrollCategories payrollCategories1 : payrollcategoryList) {
/* 128:140 */         payrollCategorymap.put(payrollCategories1.getId(), payrollCategories1.getName());
/* 129:    */       }
/* 130:142 */       mav.getModelMap().put("payrollCategoryList", payrollcategoryList);
/* 131:143 */       mav.getModelMap().put("payrollCategorymap", payrollCategorymap);
/* 132:    */     }
/* 133:145 */     if (success != null) {
/* 134:146 */       mav.getModelMap().put("success", success);
/* 135:    */     }
/* 136:148 */     if (error != null) {
/* 137:149 */       mav.getModelMap().put("error", error);
/* 138:    */     }
/* 139:151 */     return mav;
/* 140:    */   }
/* 141:    */   
/* 142:    */   @RequestMapping(value={"/edit_payroll_category.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 143:    */   public ModelAndView editPayrollCategoryPost(@ModelAttribute("payrollcategory") @Valid PayrollCategories payrollCategories, BindingResult result, ModelMap model, Locale locale)
/* 144:    */     throws Exception
/* 145:    */   {
/* 146:159 */     LOGGER.info("edit_payroll_category-post called.");
/* 147:160 */     List<PayrollCategories> payrollcategoryList = this.payrollCategoriesDAO.getList();
/* 148:161 */     if (!result.hasErrors())
/* 149:    */     {
/* 150:162 */       int updateResult = this.payrollCategoriesDAO.update(payrollCategories);
/* 151:163 */       if (updateResult > 0)
/* 152:    */       {
/* 153:164 */         LOGGER.info("payroll_category updated Successfully with id={0}", Integer.valueOf(updateResult));
/* 154:165 */         ModelAndView mav = new ModelAndView("redirect:payroll_category.html");
/* 155:166 */         HashMap<Integer, String> payrollCategorymap = new HashMap(payrollcategoryList.size());
/* 156:167 */         for (PayrollCategories payrollCategories1 : payrollcategoryList) {
/* 157:168 */           payrollCategorymap.put(payrollCategories1.getId(), payrollCategories1.getName());
/* 158:    */         }
/* 159:170 */         mav.getModelMap().put("payrollCategoryList", payrollcategoryList);
/* 160:171 */         mav.getModelMap().put("payrollCategorymap", payrollCategorymap);
/* 161:172 */         return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "payrollcategory.update.success", locale));
/* 162:    */       }
/* 163:175 */       LOGGER.warn("Error occurred updating payroll category:{0}", payrollCategories);
/* 164:176 */       return new ModelAndView("edit_payroll_category", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "payrollcategory.update.error", locale));
/* 165:    */     }
/* 166:180 */     LOGGER.warn("Employee department values are not valid:", payrollCategories);
/* 167:181 */     return new ModelAndView("edit_payroll_category", model);
/* 168:    */   }
/* 169:    */   
/* 170:    */   @RequestMapping({"/delete_payroll_category.html"})
/* 171:    */   @ResponseBody
/* 172:    */   public ModelAndView deletePayrollCategory(@RequestParam("id") int id, Locale locale)
/* 173:    */     throws Exception
/* 174:    */   {
/* 175:188 */     LOGGER.info("delete_payroll_category called.");
/* 176:189 */     PayrollCategories payrollCategories = (PayrollCategories)this.payrollCategoriesDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 177:190 */     ModelAndView mav = new ModelAndView("redirect:payroll_category.html");
/* 178:191 */     List<PayrollCategories> payrollcategoryList = this.payrollCategoriesDAO.getList();
/* 179:192 */     HashMap<Integer, String> payrollCategorymap = new HashMap(payrollcategoryList.size());
/* 180:193 */     for (PayrollCategories payrollCategories1 : payrollcategoryList) {
/* 181:194 */       payrollCategorymap.put(payrollCategories1.getId(), payrollCategories1.getName());
/* 182:    */     }
/* 183:196 */     mav.getModelMap().put("payrollCategoryList", payrollcategoryList);
/* 184:197 */     mav.getModelMap().put("payrollCategorymap", payrollCategorymap);
/* 185:198 */     if (payrollCategories != null)
/* 186:    */     {
/* 187:199 */       int updateResult = this.payrollCategoriesDAO.delete(payrollCategories);
/* 188:201 */       if (updateResult > 0)
/* 189:    */       {
/* 190:202 */         LOGGER.info("Payroll Category with id {0} deleted successfully", payrollCategories.getId());
/* 191:    */         
/* 192:204 */         return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "payrollcategory.delete.success", locale));
/* 193:    */       }
/* 194:207 */       LOGGER.warn("Error occurred while deleting employee department with id {0}", payrollCategories.getId());
/* 195:208 */       return mav.addObject("error", Utilities.getSpringMessage(this.messageSource, "payrollcategory.delete.error", locale));
/* 196:    */     }
/* 197:212 */     LOGGER.info("Payroll Department with id {0} is already deleted", payrollCategories.getId());
/* 198:213 */     return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "payrollcategory.delete.error", locale));
/* 199:    */   }
/* 200:    */   
/* 201:    */   @RequestMapping(value={"/payslips.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 202:    */   public ModelAndView payslip(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/* 203:    */     throws Exception
/* 204:    */   {
/* 205:221 */     LOGGER.info("payslips called.");
/* 206:222 */     PayslipContainer payslipContainer = new PayslipContainer();
/* 207:223 */     ModelAndView mav = new ModelAndView("payslips");
/* 208:224 */     List<MonthlyPayslips> monthlyPayslips = new ArrayList();
/* 209:225 */     payslipContainer.setMonthlyPayslipList(monthlyPayslips);
/* 210:226 */     List<Employees> employeeList = this.employeesDAO.getList();
/* 211:227 */     List<PayrollCategories> payrollCategoryList = this.payrollCategoriesDAO.getList();
/* 212:228 */     mav.getModelMap().put("employeeList", employeeList);
/* 213:229 */     mav.getModelMap().put("payslipContainer", payslipContainer);
/* 214:230 */     mav.getModelMap().put("payrollcategoryList", payrollCategoryList);
/* 215:231 */     if (success != null) {
/* 216:232 */       mav.getModelMap().put("success", success);
/* 217:    */     }
/* 218:234 */     if (error != null) {
/* 219:235 */       mav.getModelMap().put("error", error);
/* 220:    */     }
/* 221:237 */     return mav;
/* 222:    */   }
/* 223:    */   
/* 224:    */   @RequestMapping(value={"/create_payslip.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 225:    */   public ModelAndView createPayslip(@ModelAttribute("payslipContainer") @Valid PayslipContainer payslipContainer, BindingResult result, ModelMap model, Locale locale)
/* 226:    */     throws Exception
/* 227:    */   {
/* 228:245 */     LOGGER.info("create_payslip post called." + payslipContainer.getMonthlyPayslipList());
/* 229:246 */     ModelAndView mav = new ModelAndView("payslips");
/* 230:    */     
/* 231:248 */     List<MonthlyPayslips> monthlyPayslips = new ArrayList();
/* 232:249 */     PayslipContainer payslipContainerNew = new PayslipContainer();
/* 233:250 */     payslipContainerNew.setMonthlyPayslipList(monthlyPayslips);
/* 234:251 */     List<Employees> employeeList = this.employeesDAO.getList();
/* 235:252 */     List<PayrollCategories> payrollCategoryList = this.payrollCategoriesDAO.getList();
/* 236:253 */     mav.getModelMap().put("employeeList", employeeList);
/* 237:254 */     mav.getModelMap().put("payslipContainer", payslipContainerNew);
/* 238:255 */     mav.getModelMap().put("payrollcategoryList", payrollCategoryList);
/* 239:256 */     if (!result.hasErrors())
/* 240:    */     {
/* 241:258 */       if (!isPayslipCreated(payslipContainer.getEmployeeId(), payslipContainer.getSalaryDate()))
/* 242:    */       {
/* 243:259 */         int insertResult = 0;
/* 244:260 */         List<MonthlyPayslips> monthlyPayslipList = payslipContainer.getMonthlyPayslipList();
/* 245:261 */         if ((monthlyPayslipList != null) && (!monthlyPayslipList.isEmpty())) {
/* 246:262 */           for (MonthlyPayslips monthlyPayslips1 : payslipContainer.getMonthlyPayslipList())
/* 247:    */           {
/* 248:263 */             monthlyPayslips1.setEmployeeId(payslipContainer.getEmployeeId());
/* 249:264 */             monthlyPayslips1.setSalaryDate(payslipContainer.getSalaryDate());
/* 250:265 */             monthlyPayslips1.setIsApproved(false);
/* 251:266 */             monthlyPayslips1.setIsRejected(false);
/* 252:267 */             insertResult = ((Integer)this.monthlyPayslipsDAO.insert(monthlyPayslips1)).intValue();
/* 253:    */           }
/* 254:    */         }
/* 255:271 */         if (insertResult > 0)
/* 256:    */         {
/* 257:272 */           LOGGER.info("Payslips created");
/* 258:273 */           return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "payslip.add.success", locale));
/* 259:    */         }
/* 260:276 */         LOGGER.info("Error while inserting ");
/* 261:277 */         return mav.addObject("error", Utilities.getSpringMessage(this.messageSource, "payslip.add.error", locale));
/* 262:    */       }
/* 263:281 */       LOGGER.info("Payslip created ");
/* 264:282 */       Calendar calendar = Calendar.getInstance();
/* 265:283 */       calendar.setTime(payslipContainer.getSalaryDate());
/* 266:284 */       return mav.addObject("error", "Payslip is created for employee for month " + calendar.getDisplayName(2, 2, Locale.getDefault()));
/* 267:    */     }
/* 268:289 */     return new ModelAndView("payslips", model);
/* 269:    */   }
/* 270:    */   
/* 271:    */   private List<MonthlyPayslips> getMonthlyPayslipByEmployee(Integer employeeId)
/* 272:    */   {
/* 273:294 */     return this.monthlyPayslipsDAO.getListByFromClause(" FROM MonthlyPayslips m WHERE m.employeeId=" + employeeId);
/* 274:    */   }
/* 275:    */   
/* 276:    */   private boolean isPayslipCreated(Integer employeeId, Date createDate)
/* 277:    */   {
/* 278:298 */     Calendar createdatecal = Calendar.getInstance();
/* 279:299 */     createdatecal.setTime(createDate);
/* 280:300 */     Calendar salarycal = Calendar.getInstance();
/* 281:301 */     List<MonthlyPayslips> monthlyPayslipsList = getMonthlyPayslipByEmployee(employeeId);
/* 282:302 */     if ((monthlyPayslipsList != null) && (!monthlyPayslipsList.isEmpty())) {
/* 283:303 */       for (MonthlyPayslips monthlyPayslips : monthlyPayslipsList)
/* 284:    */       {
/* 285:304 */         salarycal.setTime(monthlyPayslips.getSalaryDate());
/* 286:305 */         if ((createdatecal.get(2) == salarycal.get(2)) && (createdatecal.get(1) == salarycal.get(1))) {
/* 287:306 */           return true;
/* 288:    */         }
/* 289:    */       }
/* 290:    */     }
/* 291:310 */     return false;
/* 292:    */   }
/* 293:    */   
/* 294:    */   @RequestMapping(value={"/payslips_list.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 295:    */   public ModelAndView getPayslipList(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/* 296:    */     throws Exception
/* 297:    */   {
/* 298:317 */     LOGGER.info("payslips called.");
/* 299:318 */     ModelAndView mav = new ModelAndView("payslips_list");
/* 300:320 */     if (success != null) {
/* 301:321 */       mav.getModelMap().put("success", success);
/* 302:    */     }
/* 303:323 */     if (error != null) {
/* 304:324 */       mav.getModelMap().put("error", error);
/* 305:    */     }
/* 306:326 */     return mav;
/* 307:    */   }
/* 308:    */   
/* 309:    */   @RequestMapping(value={"/get_payslip.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 310:    */   public ModelAndView getPayslipList(HttpServletRequest request, @RequestParam("month") String month, @RequestParam("year") String year, Locale locale, @RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/* 311:    */     throws Exception
/* 312:    */   {
/* 313:335 */     LOGGER.info("payslips called.");
/* 314:336 */     ModelAndView mav = new ModelAndView("payslips_list");
/* 315:    */     
/* 316:338 */     HashMap<Integer, Payslip> payslipMap = new HashMap();
/* 317:339 */     if ((month != null) && (year != null))
/* 318:    */     {
/* 319:340 */       List<MonthlyPayslips> payslips = getMonthlyPayslipsForMonthYear(Integer.valueOf(month).intValue(), Integer.valueOf(year).intValue());
/* 320:341 */       List<Integer> employeeList = new ArrayList();
/* 321:342 */       if ((payslips != null) && (!payslips.isEmpty()))
/* 322:    */       {
/* 323:343 */         for (MonthlyPayslips monthlyPayslips : payslips) {
/* 324:344 */           if (payslipMap.containsKey(monthlyPayslips.getEmployeeId()))
/* 325:    */           {
/* 326:345 */             Payslip payslip = (Payslip)payslipMap.get(monthlyPayslips.getEmployeeId());
/* 327:346 */             PayrollCategories payrollCategories = (PayrollCategories)this.payrollCategoriesDAO.getRecordByPrimaryKey(monthlyPayslips.getPayrollCategoryId());
/* 328:347 */             if (payrollCategories.getIsDeduction().booleanValue())
/* 329:    */             {
/* 330:348 */               payslip.setDeductions(Double.valueOf(payslip.getDeductions().doubleValue() + monthlyPayslips.getAmount().doubleValue()));
/* 331:349 */               payslip.setTotal(Double.valueOf(payslip.getTotal().doubleValue() - monthlyPayslips.getAmount().doubleValue()));
/* 332:350 */               payslip.getDeductionList().add(monthlyPayslips);
/* 333:    */             }
/* 334:    */             else
/* 335:    */             {
/* 336:352 */               payslip.setSalary(Double.valueOf(payslip.getSalary().doubleValue() + monthlyPayslips.getAmount().doubleValue()));
/* 337:353 */               payslip.setTotal(Double.valueOf(payslip.getTotal().doubleValue() + monthlyPayslips.getAmount().doubleValue()));
/* 338:354 */               payslip.getSalaryList().add(monthlyPayslips);
/* 339:    */             }
/* 340:    */           }
/* 341:    */           else
/* 342:    */           {
/* 343:358 */             Payslip payslip = new Payslip();
/* 344:359 */             Employees employee = (Employees)this.employeesDAO.getRecordByPrimaryKey(monthlyPayslips.getEmployeeId());
/* 345:360 */             payslip.setEmployeeId(monthlyPayslips.getEmployeeId());
/* 346:361 */             if (employee != null)
/* 347:    */             {
/* 348:362 */               payslip.setEmployeeNumber(employee.getEmployeeNumber());
/* 349:363 */               payslip.setFirstName(employee.getFirstName());
/* 350:364 */               payslip.setLastName(employee.getLastName());
/* 351:    */             }
/* 352:366 */             payslip.setSalary(Double.valueOf(0.0D));
/* 353:367 */             payslip.setDeductions(Double.valueOf(0.0D));
/* 354:368 */             payslip.setTotal(Double.valueOf(0.0D));
/* 355:369 */             PayrollCategories payrollCategories = (PayrollCategories)this.payrollCategoriesDAO.getRecordByPrimaryKey(monthlyPayslips.getPayrollCategoryId());
/* 356:371 */             if (payrollCategories.getIsDeduction().booleanValue())
/* 357:    */             {
/* 358:372 */               payslip.setDeductions(Double.valueOf(payslip.getDeductions().doubleValue() + monthlyPayslips.getAmount().doubleValue()));
/* 359:373 */               payslip.setTotal(Double.valueOf(payslip.getTotal().doubleValue() - monthlyPayslips.getAmount().doubleValue()));
/* 360:374 */               payslip.setDeductionList(new ArrayList());
/* 361:375 */               payslip.getDeductionList().add(monthlyPayslips);
/* 362:    */             }
/* 363:    */             else
/* 364:    */             {
/* 365:377 */               payslip.setSalary(Double.valueOf(payslip.getSalary().doubleValue() + monthlyPayslips.getAmount().doubleValue()));
/* 366:378 */               payslip.setTotal(Double.valueOf(payslip.getTotal().doubleValue() + monthlyPayslips.getAmount().doubleValue()));
/* 367:379 */               payslip.setSalaryList(new ArrayList());
/* 368:380 */               payslip.getSalaryList().add(monthlyPayslips);
/* 369:    */             }
/* 370:383 */             payslipMap.put(monthlyPayslips.getEmployeeId(), payslip);
/* 371:384 */             employeeList.add(monthlyPayslips.getEmployeeId());
/* 372:    */           }
/* 373:    */         }
/* 374:388 */         mav.getModelMap().put("employeeList", employeeList);
/* 375:389 */         mav.getModelMap().put("payslipmap", payslipMap);
/* 376:390 */         request.getSession().setAttribute("payslipmap", payslipMap);
/* 377:    */       }
/* 378:    */     }
/* 379:395 */     if (success != null) {
/* 380:396 */       mav.getModelMap().put("success", success);
/* 381:    */     }
/* 382:398 */     if (error != null) {
/* 383:399 */       mav.getModelMap().put("error", error);
/* 384:    */     }
/* 385:401 */     return mav;
/* 386:    */   }
/* 387:    */   
/* 388:    */   List<MonthlyPayslips> getMonthlyPayslipsForMonthYear(int month, int year)
/* 389:    */   {
/* 390:405 */     List<MonthlyPayslips> list = this.monthlyPayslipsDAO.getList();
/* 391:406 */     List<MonthlyPayslips> monthlyPayslipList = new ArrayList();
/* 392:407 */     if ((list != null) && (!list.isEmpty())) {
/* 393:408 */       for (MonthlyPayslips payslip : list)
/* 394:    */       {
/* 395:409 */         Calendar cal = Calendar.getInstance();
/* 396:410 */         cal.setTime(payslip.getSalaryDate());
/* 397:411 */         LOGGER.info("salary yeaar : " + cal.get(1));
/* 398:412 */         LOGGER.info("salary month : " + cal.get(2));
/* 399:413 */         LOGGER.info("param yeaar : " + year);
/* 400:414 */         LOGGER.info("param month : " + month);
/* 401:416 */         if ((month == cal.get(2)) && (year == cal.get(1))) {
/* 402:417 */           monthlyPayslipList.add(payslip);
/* 403:    */         }
/* 404:    */       }
/* 405:    */     }
/* 406:421 */     return monthlyPayslipList;
/* 407:    */   }
/* 408:    */   
/* 409:    */   @RequestMapping(value={"/payslip_detail.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 410:    */   public ModelAndView getDetailedPayslip(HttpServletRequest request, @RequestParam("id") Integer id, Locale locale, @RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/* 411:    */     throws Exception
/* 412:    */   {
/* 413:430 */     LOGGER.info("payslip_detail called.");
/* 414:431 */     ModelAndView mav = new ModelAndView("payslip_detail");
/* 415:432 */     List<MonthlyPayslips> monthlyPayslips = new ArrayList();
/* 416:433 */     List<PayrollCategories> payrollCategorieses = this.payrollCategoriesDAO.getList();
/* 417:434 */     Map<Integer, String> payrollCategoryMap = new HashMap();
/* 418:435 */     if ((payrollCategorieses != null) && (!payrollCategorieses.isEmpty())) {
/* 419:436 */       for (PayrollCategories payrollCategories : payrollCategorieses) {
/* 420:437 */         payrollCategoryMap.put(payrollCategories.getId(), payrollCategories.getName());
/* 421:    */       }
/* 422:    */     }
/* 423:441 */     HashMap<Integer, Payslip> payslipMap = (HashMap)request.getSession().getAttribute("payslipmap");
/* 424:442 */     LOGGER.info("id is " + id);
/* 425:443 */     LOGGER.info("payslipMap is " + payslipMap);
/* 426:444 */     if (id != null)
/* 427:    */     {
/* 428:445 */       Payslip payslip = (Payslip)payslipMap.get(id);
/* 429:446 */       LOGGER.info("Payslip " + payslip);
/* 430:447 */       mav.getModelMap().put("payslip", payslip);
/* 431:448 */       if (payslip != null)
/* 432:    */       {
/* 433:449 */         if (payslip.getSalaryList() != null) {
/* 434:450 */           for (MonthlyPayslips monthlyPayslips1 : payslip.getSalaryList()) {
/* 435:451 */             monthlyPayslips.add(monthlyPayslips1);
/* 436:    */           }
/* 437:    */         }
/* 438:454 */         if (payslip.getDeductionList() != null) {
/* 439:455 */           for (MonthlyPayslips monthlyPayslips2 : payslip.getDeductionList())
/* 440:    */           {
/* 441:456 */             monthlyPayslips2.setAmount(Double.valueOf(monthlyPayslips2.getAmount().doubleValue() * -1.0D));
/* 442:457 */             monthlyPayslips.add(monthlyPayslips2);
/* 443:    */           }
/* 444:    */         }
/* 445:    */       }
/* 446:    */     }
/* 447:463 */     mav.getModelMap().put("monthlyPayslips", monthlyPayslips);
/* 448:464 */     mav.getModelMap().put("payrollcategormap", payrollCategoryMap);
/* 449:466 */     if (success != null) {
/* 450:467 */       mav.getModelMap().put("success", success);
/* 451:    */     }
/* 452:469 */     if (error != null) {
/* 453:470 */       mav.getModelMap().put("error", error);
/* 454:    */     }
/* 455:472 */     return mav;
/* 456:    */   }
/* 457:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.controller.PayrollController
 * JD-Core Version:    0.7.1
 */