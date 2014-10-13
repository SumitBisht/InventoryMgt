/*   1:    */ package com.tss.ocean.controller;
/*   2:    */ 
/*   3:    */ import com.tss.ocean.idao.IEmployeeAttendancesDAO;
/*   4:    */ import com.tss.ocean.idao.IEmployeeLeaveTypesDAO;
/*   5:    */ import com.tss.ocean.idao.IEmployeesDAO;
/*   6:    */ import com.tss.ocean.pojo.AttendanceDate;
/*   7:    */ import com.tss.ocean.pojo.EmployeeAttendances;
/*   8:    */ import com.tss.ocean.pojo.EmployeeLeaveTypes;
/*   9:    */ import com.tss.ocean.pojo.Employees;
/*  10:    */ import com.tss.ocean.util.Utilities;

/*  11:    */ import java.io.Serializable;
/*  12:    */ import java.text.DecimalFormat;
/*  13:    */ import java.util.ArrayList;
/*  14:    */ import java.util.Calendar;
/*  15:    */ import java.util.Date;
/*  16:    */ import java.util.LinkedHashMap;
/*  17:    */ import java.util.List;
/*  18:    */ import java.util.Locale;
/*  19:    */ import java.util.Map;
/*  20:    */ import java.util.Map.Entry;

/*  21:    */ import javax.validation.Valid;

/*  22:    */ import org.slf4j.Logger;
/*  23:    */ import org.slf4j.LoggerFactory;
/*  24:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  25:    */ import org.springframework.context.MessageSource;
/*  26:    */ import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/*  27:    */ import org.springframework.ui.ModelMap;
/*  28:    */ import org.springframework.validation.BindingResult;
/*  29:    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*  30:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  31:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  32:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  33:    */ import org.springframework.web.servlet.ModelAndView;
/*  34:    */ 
/*  35:    */ @Controller
/*  36:    */ public class EmployeeLeaveController
/*  37:    */ {
/*  38:    */   @Autowired
/*  39:    */   IEmployeeLeaveTypesDAO employeeLeaveTypesDAO;
/*  40:    */   @Autowired
/*  41:    */   IEmployeesDAO employeesDAO;
/*  42:    */   @Autowired
/*  43:    */   private MessageSource messageSource;
/*  44:    */   @Autowired
/*  45:    */   IEmployeeAttendancesDAO employeeAttendancesDAO;
/*  46: 55 */   private static final Logger logger = LoggerFactory.getLogger(EmployeeLeaveController.class);
/*  47:    */   
/*  48:    */   @RequestMapping(value={"/leave_types.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  49:    */   public ModelAndView leaveTypes(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/*  50:    */     throws Exception
/*  51:    */   {
/*  52: 61 */     logger.info("leave types called.");
/*  53: 62 */     ModelAndView mav = new ModelAndView("leave_types");
/*  54: 63 */     List<EmployeeLeaveTypes> leaveTypes = this.employeeLeaveTypesDAO.getList();
/*  55:    */     
/*  56: 65 */     mav.getModelMap().put("leaveTypesList", leaveTypes);
/*  57: 66 */     if (success != null) {
/*  58: 67 */       mav.getModelMap().put("success", success);
/*  59:    */     }
/*  60: 69 */     if (error != null) {
/*  61: 70 */       mav.getModelMap().put("error", error);
/*  62:    */     }
/*  63: 72 */     return mav;
/*  64:    */   }
/*  65:    */   
/*  66:    */   @RequestMapping(value={"/add_leave_type"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  67:    */   public ModelAndView addLeaveTypeGet(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/*  68:    */     throws Exception
/*  69:    */   {
/*  70: 79 */     logger.info("addLeaveTypeGet called.");
/*  71: 80 */     ModelAndView mav = new ModelAndView("add_leave_type");
/*  72: 81 */     EmployeeLeaveTypes leaveType = new EmployeeLeaveTypes();
/*  73: 82 */     if (success != null) {
/*  74: 83 */       mav.getModelMap().put("success", success);
/*  75:    */     }
/*  76: 85 */     if (error != null) {
/*  77: 86 */       mav.getModelMap().put("error", error);
/*  78:    */     }
/*  79: 88 */     mav.getModelMap().put("leaveType", leaveType);
/*  80: 89 */     return mav;
/*  81:    */   }
/*  82:    */   
/*  83:    */   @RequestMapping(value={"/add_leave_type.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  84:    */   public ModelAndView addLeaveTypePost(@ModelAttribute("leaveType") @Valid EmployeeLeaveTypes employeeLeaveTypes, BindingResult result, ModelMap model, Locale locale)
/*  85:    */     throws Exception
/*  86:    */   {
/*  87: 97 */     logger.info("add_leave_type-post called.");
/*  88: 98 */     if (!result.hasErrors())
/*  89:    */     {
/*  90: 99 */       int insertResult = ((Integer)this.employeeLeaveTypesDAO.insert(employeeLeaveTypes)).intValue();
/*  91:100 */       if (insertResult > 0)
/*  92:    */       {
/*  93:101 */         logger.info("Employee leave types Added Successfully with id " + insertResult);
/*  94:102 */         return new ModelAndView("redirect:add_leave_type.html").addObject("success", Utilities.getSpringMessage(this.messageSource, "leavetype.add.success", locale));
/*  95:    */       }
/*  96:105 */       logger.info("Error while inserting " + employeeLeaveTypes);
/*  97:106 */       return new ModelAndView("add_leave_type", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "leavetype.add.error", locale));
/*  98:    */     }
/*  99:110 */     return new ModelAndView("add_leave_type", model);
/* 100:    */   }
/* 101:    */   
/* 102:    */   @RequestMapping(value={"/edit_leave_type.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 103:    */   public ModelAndView editLeaveTypeGet(@RequestParam("id") int id, Locale locale, @RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/* 104:    */     throws Exception
/* 105:    */   {
/* 106:120 */     logger.info("edit_leave_type called.");
/* 107:    */     
/* 108:122 */     EmployeeLeaveTypes employeeLeaveTypes = (EmployeeLeaveTypes)this.employeeLeaveTypesDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 109:    */     ModelAndView mav;
/* 110:123 */     if (employeeLeaveTypes != null)
/* 111:    */     {
/* 112:124 */        mav = new ModelAndView("edit_leave_type");
/* 113:125 */       mav.getModelMap().put("leaveType", employeeLeaveTypes);
/* 114:    */     }
/* 115:    */     else
/* 116:    */     {
/* 117:128 */       mav = new ModelAndView("redirect:leave_types.html");
/* 118:129 */       List<EmployeeLeaveTypes> leaveTypes = this.employeeLeaveTypesDAO.getList();
/* 119:    */       
/* 120:131 */       mav.getModelMap().put("leaveTypesList", leaveTypes);
/* 121:    */     }
/* 122:133 */     if (success != null) {
/* 123:134 */       mav.getModelMap().put("success", success);
/* 124:    */     }
/* 125:136 */     if (error != null) {
/* 126:137 */       mav.getModelMap().put("error", error);
/* 127:    */     }
/* 128:139 */     return mav;
/* 129:    */   }
/* 130:    */   
/* 131:    */   @RequestMapping(value={"/edit_leave_type.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 132:    */   public ModelAndView editLeaveTypePost(@ModelAttribute("leaveType") @Valid EmployeeLeaveTypes employeeLeaveTypes, BindingResult result, ModelMap model, Locale locale)
/* 133:    */     throws Exception
/* 134:    */   {
/* 135:147 */     logger.info("edit_leave_type-post called.");
/* 136:148 */     if (!result.hasErrors())
/* 137:    */     {
/* 138:149 */       int updateResult = this.employeeLeaveTypesDAO.update(employeeLeaveTypes);
/* 139:150 */       if (updateResult > 0)
/* 140:    */       {
/* 141:151 */         logger.info("leave_type updated Successfully with id={0}", Integer.valueOf(updateResult));
/* 142:152 */         ModelAndView mav = new ModelAndView("redirect:leave_types.html");
/* 143:153 */         List<EmployeeLeaveTypes> leaveTypes = this.employeeLeaveTypesDAO.getList();
/* 144:154 */         mav.getModelMap().put("leaveTypesList", leaveTypes);
/* 145:155 */         return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "leavetype.update.success", locale));
/* 146:    */       }
/* 147:158 */       logger.warn("Error occurred updating leave type :{0}", employeeLeaveTypes);
/* 148:159 */       return new ModelAndView("edit_leave_type", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "leavetype.update.error", locale));
/* 149:    */     }
/* 150:163 */     logger.warn("Leave types values are not valid:", employeeLeaveTypes);
/* 151:164 */     return new ModelAndView("edit_employee_category", model);
/* 152:    */   }
/* 153:    */   
/* 154:    */   @RequestMapping({"/delete_leave_type.html"})
/* 155:    */   @ResponseBody
/* 156:    */   public ModelAndView deleteLeaveType(@RequestParam("id") int id, Locale locale)
/* 157:    */     throws Exception
/* 158:    */   {
/* 159:171 */     logger.info("deleteLeaveType called.");
/* 160:172 */     EmployeeLeaveTypes employeeLeaveTypes = (EmployeeLeaveTypes)this.employeeLeaveTypesDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 161:173 */     ModelAndView mav = new ModelAndView("redirect:leave_types.html");
/* 162:174 */     List<EmployeeLeaveTypes> leaveTypes = this.employeeLeaveTypesDAO.getList();
/* 163:175 */     mav.getModelMap().put("leaveTypesList", leaveTypes);
/* 164:176 */     if (employeeLeaveTypes != null)
/* 165:    */     {
/* 166:177 */       int updateResult = this.employeeLeaveTypesDAO.delete(employeeLeaveTypes);
/* 167:179 */       if (updateResult > 0)
/* 168:    */       {
/* 169:180 */         logger.info("Leave Type with id {0} deleted successfully", employeeLeaveTypes.getId());
/* 170:    */         
/* 171:182 */         return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "leavetype.delete.success", locale));
/* 172:    */       }
/* 173:185 */       logger.warn("Error occurred while deleting leave type with id {0}", employeeLeaveTypes.getId());
/* 174:186 */       return mav.addObject("error", Utilities.getSpringMessage(this.messageSource, "leavetype.delete.error", locale));
/* 175:    */     }
/* 176:190 */     logger.info("leave type with id {0} is already deleted", employeeLeaveTypes.getId());
/* 177:191 */     return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "leavetype.delete.success", locale));
/* 178:    */   }
/* 179:    */   
/* 180:    */   @RequestMapping(value={"/hr_attendence.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 181:    */   public ModelAndView attendanceRegister(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/* 182:    */     throws Exception
/* 183:    */   {
/* 184:199 */     logger.info("leave types called.");
/* 185:200 */     ModelAndView mav = new ModelAndView("attendance_register");
/* 186:201 */     mav.getModelMap().put("attendance", new EmployeeAttendances());
/* 187:202 */     if (success != null) {
/* 188:203 */       mav.getModelMap().put("success", success);
/* 189:    */     }
/* 190:205 */     if (error != null) {
/* 191:206 */       mav.getModelMap().put("error", error);
/* 192:    */     }
/* 193:208 */     return mav;
/* 194:    */   }
/* 195:    */   
/* 196:    */   @RequestMapping(value={"/add_attendance.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 197:    */   public ModelAndView addAttendance(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/* 198:    */     throws Exception
/* 199:    */   {
/* 200:215 */     logger.info("add_attendance called.");
/* 201:216 */     ModelAndView mav = new ModelAndView("add_attendance");
/* 202:217 */     List<Employees> employeeList = this.employeesDAO.getList();
/* 203:218 */     List<EmployeeLeaveTypes> employeeLeaveTypeList = this.employeeLeaveTypesDAO.getList();
/* 204:219 */     DecimalFormat decimalFormat = new DecimalFormat("00");
/* 205:220 */     List<String> hoursList = new ArrayList();
/* 206:221 */     for (int i = 0; i < 23; i++) {
/* 207:222 */       hoursList.add(decimalFormat.format(i));
/* 208:    */     }
/* 209:224 */     List<String> minutesList = new ArrayList();
/* 210:225 */     for (int i = 0; i < 59; i++) {
/* 211:226 */       minutesList.add(decimalFormat.format(i));
/* 212:    */     }
/* 213:228 */     if (success != null) {
/* 214:229 */       mav.getModelMap().put("success", success);
/* 215:    */     }
/* 216:231 */     if (error != null) {
/* 217:232 */       mav.getModelMap().put("error", error);
/* 218:    */     }
/* 219:234 */     mav.getModelMap().put("employeeList", employeeList);
/* 220:235 */     mav.getModelMap().put("employeeLeaveTypeList", employeeLeaveTypeList);
/* 221:236 */     mav.getModelMap().put("hoursList", hoursList);
/* 222:237 */     mav.getModelMap().put("minutesList", minutesList);
/* 223:238 */     mav.getModelMap().put("attendance", new EmployeeAttendances());
/* 224:239 */     return mav;
/* 225:    */   }
/* 226:    */   
/* 227:    */   @RequestMapping(value={"/add_attendance.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 228:    */   public ModelAndView addAttendance(@ModelAttribute("attendance") @Valid EmployeeAttendances employeeAttendances, BindingResult result, ModelMap model, Locale locale)
/* 229:    */     throws Exception
/* 230:    */   {
/* 231:247 */     logger.info("add_attendance-post called.");
/* 232:248 */     if (!result.hasErrors())
/* 233:    */     {
/* 234:249 */       List<Employees> employeeList = this.employeesDAO.getList();
/* 235:250 */       List<EmployeeLeaveTypes> employeeLeaveTypeList = this.employeeLeaveTypesDAO.getList();
/* 236:    */       
/* 237:252 */       DecimalFormat decimalFormat = new DecimalFormat("00");
/* 238:253 */       List<String> hoursList = new ArrayList();
/* 239:254 */       for (int i = 0; i < 23; i++) {
/* 240:255 */         hoursList.add(decimalFormat.format(i));
/* 241:    */       }
/* 242:257 */       List<String> minutesList = new ArrayList();
/* 243:258 */       for (int i = 0; i < 59; i++) {
/* 244:259 */         minutesList.add(decimalFormat.format(i));
/* 245:    */       }
/* 246:261 */       ModelAndView mav = new ModelAndView("add_attendance");
/* 247:262 */       mav.getModelMap().put("employeeList", employeeList);
/* 248:263 */       mav.getModelMap().put("employeeLeaveTypeList", employeeLeaveTypeList);
/* 249:264 */       mav.getModelMap().put("hoursList", hoursList);
/* 250:265 */       mav.getModelMap().put("minutesList", minutesList);
/* 251:266 */       mav.getModelMap().put("attendance", new EmployeeAttendances());
/* 252:267 */       employeeAttendances.setInTime(employeeAttendances.getInHour() + ":" + employeeAttendances.getInMinutes());
/* 253:268 */       employeeAttendances.setOutTime(employeeAttendances.getOutHour() + ":" + employeeAttendances.getOutMinutes());
/* 254:269 */       if (!employeeAttendances.getIsLeave().booleanValue()) {
/* 255:271 */         employeeAttendances.setEmployeeLeaveTypeId(null);
/* 256:    */       }
/* 257:273 */       int insertResult = ((Integer)this.employeeAttendancesDAO.insert(employeeAttendances)).intValue();
/* 258:274 */       if (insertResult > 0)
/* 259:    */       {
/* 260:275 */         logger.info("Employee attendance Added Successfully with id " + insertResult);
/* 261:276 */         return mav.addObject("success", Utilities.getSpringMessage(this.messageSource, "attendance.add.success", locale));
/* 262:    */       }
/* 263:279 */       logger.info("Error while inserting " + employeeAttendances);
/* 264:280 */       return mav.addObject("error", Utilities.getSpringMessage(this.messageSource, "attendance.add.error", locale));
/* 265:    */     }
/* 266:284 */     return new ModelAndView("add_attendance", model);
/* 267:    */   }
/* 268:    */   
/* 269:    */   @RequestMapping(value={"/attendance_register.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 270:    */   public ModelAndView getAttendanceRegister(@ModelAttribute("attendance") @Valid EmployeeAttendances employeeAttendances, BindingResult result, ModelMap model, Locale locale)
/* 271:    */     throws Exception
/* 272:    */   {
/* 273:294 */     logger.info("attendance_register-post called.");
/* 274:295 */     if (!result.hasErrors())
/* 275:    */     {
/* 276:296 */       List<Employees> employeeList = this.employeesDAO.getList();
/* 277:297 */       Map<Integer, String> employeeMap = new LinkedHashMap();
/* 278:298 */       for (Employees employees : employeeList) {
/* 279:299 */         employeeMap.put(employees.getId(), employees.getEmployeeNumber());
/* 280:    */       }
/* 281:301 */       List<EmployeeAttendances> employeeAttendanceList = getEmployeeAttendanceByDate(employeeAttendances.getAttendanceDate());
/* 282:    */       
/* 283:303 */       ModelAndView mav = new ModelAndView("add_attendance");
/* 284:304 */       mav.getModelMap().put("employeeMap", employeeMap);
/* 285:305 */       mav.getModelMap().put("employeeAttendanceList", employeeAttendanceList);
/* 286:306 */       mav.getModelMap().put("attendance", new EmployeeAttendances());
/* 287:307 */       return mav;
/* 288:    */     }
/* 289:309 */     return new ModelAndView("hr_atendance", model);
/* 290:    */   }
/* 291:    */   
/* 292:    */   private List<EmployeeAttendances> getEmployeeAttendanceByDate(Date attendanceDate)
/* 293:    */   {
/* 294:313 */     return this.employeeAttendancesDAO.getListByFromClause(" FROM EmployeeAttendances e WHERE e.attendanceDate=" + attendanceDate);
/* 295:    */   }
/* 296:    */   
/* 297:    */   @RequestMapping(value={"/hr_attendence_report.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 298:    */   public ModelAndView attendanceReport(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/* 299:    */     throws Exception
/* 300:    */   {
/* 301:320 */     logger.info("hr_attendence");
/* 302:321 */     ModelAndView mav = new ModelAndView("attendance_report");
/* 303:322 */     mav.getModelMap().put("attendance", new AttendanceDate());
/* 304:323 */     if (success != null) {
/* 305:324 */       mav.getModelMap().put("success", success);
/* 306:    */     }
/* 307:326 */     if (error != null) {
/* 308:327 */       mav.getModelMap().put("error", error);
/* 309:    */     }
/* 310:329 */     return mav;
/* 311:    */   }
/* 312:    */   
/* 313:    */   @RequestMapping(value={"/get_attendance.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 314:    */   public ModelAndView getAttendanceReport(@ModelAttribute("attendance") @Valid AttendanceDate attendanceDate, BindingResult result, ModelMap model, Locale locale)
/* 315:    */     throws Exception
/* 316:    */   {
/* 317:337 */     logger.info("get_attendancecalled." + attendanceDate.getFromDate() + "  " + attendanceDate.getToDate());
/* 318:338 */     Map<Integer, AttendanceDate> attendanceMap = new LinkedHashMap();
/* 319:339 */     ModelAndView mav = new ModelAndView("attendance_report_list");
/* 320:340 */     List<EmployeeAttendances> employeeAttendanceses = getAttendancebetweendates(attendanceDate.getFromDate(), attendanceDate.getToDate());
/* 321:341 */     logger.info("Here list size  " + employeeAttendanceses.size());
/* 322:342 */     Calendar cal = Calendar.getInstance();
/* 323:344 */     for (EmployeeAttendances employeeAttendance : employeeAttendanceses) {
/* 324:345 */       if (attendanceMap.containsKey(employeeAttendance.getEmployeeId()))
/* 325:    */       {
/* 326:346 */         cal.setTime(employeeAttendance.getAttendanceDate());
/* 327:347 */         setAttendanceData((AttendanceDate)attendanceMap.get(employeeAttendance.getEmployeeId()), cal, employeeAttendance);
/* 328:    */       }
/* 329:    */       else
/* 330:    */       {
/* 331:350 */         AttendanceDate attendanceDate1 = new AttendanceDate();
/* 332:351 */         attendanceDate1.setPresentDays(Integer.valueOf(0));
/* 333:352 */         attendanceDate1.setAbsentDays(Integer.valueOf(0));
/* 334:353 */         attendanceDate1.setTotalDays(Integer.valueOf(0));
/* 335:354 */         attendanceDate1.setFromDate(attendanceDate.getFromDate());
/* 336:355 */         attendanceDate1.setToDate(attendanceDate.getToDate());
/* 337:356 */         cal.setTime(employeeAttendance.getAttendanceDate());
/* 338:357 */         setAttendanceData(attendanceDate1, cal, employeeAttendance);
/* 339:358 */         attendanceMap.put(employeeAttendance.getEmployeeId(), attendanceDate1);
/* 340:    */       }
/* 341:    */     }
/* 342:361 */     List<AttendanceDate> attendancereportList = new ArrayList();
/* 343:362 */     for (Map.Entry<Integer, AttendanceDate> entrySet : attendanceMap.entrySet())
/* 344:    */     {
/* 345:363 */       Employees employees = (Employees)this.employeesDAO.getRecordByPrimaryKey(entrySet.getKey());
/* 346:    */       
/* 347:365 */       ((AttendanceDate)entrySet.getValue()).setEmployee(employees.getFirstName() + "(" + employees.getEmployeeNumber() + ")");
/* 348:366 */       attendancereportList.add(entrySet.getValue());
/* 349:    */     }
/* 350:369 */     mav.getModelMap().put("attendanceReportList", attendancereportList);
/* 351:370 */     return mav;
/* 352:    */   }
/* 353:    */   
/* 354:    */   private List<EmployeeAttendances> getAttendancebetweendates(Date fromDate, Date toDate)
/* 355:    */   {
/* 356:374 */     return this.employeeAttendancesDAO.getEmployeeAttendanceBetweenDates(fromDate, toDate);
/* 357:    */   }
/* 358:    */   
/* 359:    */   private void setAttendanceData(AttendanceDate attendanceDate, Calendar cal, EmployeeAttendances employeeAttendances)
/* 360:    */   {
/* 361:378 */     int dayOfWeek = cal.get(7);
/* 362:379 */     logger.info("setAttendanceData called " + dayOfWeek + "   " + 7 + "  " + 1);
/* 363:    */     
/* 364:381 */     logger.info(" 111 setAttendanceData called");
/* 365:382 */     attendanceDate.setTotalDays(Integer.valueOf(attendanceDate.getTotalDays().intValue() + 1));
/* 366:383 */     if (employeeAttendances.getIsLeave().booleanValue())
/* 367:    */     {
/* 368:384 */       logger.info("isleave");
/* 369:385 */       attendanceDate.setAbsentDays(Integer.valueOf(attendanceDate.getAbsentDays().intValue() + 1));
/* 370:    */     }
/* 371:    */     else
/* 372:    */     {
/* 373:387 */       logger.info("isleave no");
/* 374:388 */       attendanceDate.setPresentDays(Integer.valueOf(attendanceDate.getPresentDays().intValue() + 1));
/* 375:    */     }
/* 376:    */   }
@RequestMapping(value={"/hr_employee_report.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
public ModelAndView employeeReport(Model model)
{
  logger.debug("Calling the reports of the employees");
  List<Employees> employees = this.employeesDAO.getList();
  logger.debug("Total employees found:" + employees.size());
  ModelAndView report =  new ModelAndView("employee_report");
  report.getModelMap().put("employees", employees);
  return report;
}
/* 377:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.controller.EmployeeLeaveController
 * JD-Core Version:    0.7.1
 */