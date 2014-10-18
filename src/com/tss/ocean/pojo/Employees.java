/*   1:    */package com.tss.ocean.pojo;

/*   2:    */
/*   3:    */import java.io.Serializable;
/*   4:    */
import java.sql.Blob;
/*   5:    */
import java.util.Date;
/*   6:    */
import javax.validation.constraints.NotNull;
/*   7:    */
import org.hibernate.validator.constraints.NotEmpty;
/*   8:    */
import org.springframework.format.annotation.DateTimeFormat;
/*   9:    */
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/*  10:    */
/*  11:    */public class Employees
/* 12: */implements Serializable
/* 13: */{
	/* 14: */private Integer id;
	/* 15: */@NotNull
	/* 16: */private Integer employeeCategoryId;
	/* 17: */
	/* 18: */private String employeeNumber;
	/* 19: */
	/* 20: */private String username;
	/* 21: */
	/* 22: */private String password;
	/* 23: */@DateTimeFormat(pattern = "dd/MM/yyyy")
	/* 24: */private Date joiningDate;
	/* 25: */@NotEmpty
	/* 26: */private String firstName;
	/* 27: */private String middleName;
	/* 28: */@NotEmpty
	/* 29: */private String lastName;
	/* 30: */private Boolean gender;
	/* 31: */private String jobTitle;
	/* 32: */private Integer employeePositionId;
	/* 33: */@NotNull
	/* 34: */private Integer employeeDepartmentId;
	/* 35: */private Integer reportingManagerId;
	/* 36: */private Integer employeeGradeId;
	/* 37: */private String qualification;
	/* 38: */private String experienceDetail;
	/* 39: */private Integer experienceYear;
	/* 40: */private Integer experienceMonth;
	/* 41: */private Boolean status;
	/* 42: */private String statusDescription;
	/* 43: */@DateTimeFormat(pattern = "dd/MM/yyyy")
	/* 44: */@NotNull
	/* 45: */private Date dateOfBirth;
	/* 46: */private String maritalStatus;
	/* 47: */private Integer childrenCount;
	/* 48: */private String fatherName;
	/* 49: */private String motherName;
	/* 50: */private String husbandName;
	/* 51: */private String bloodGroup;
	/* 52: */private Integer nationalityId;
	/* 53: */private String homeAddressLine1;
	/* 54: */private String homeAddressLine2;
	/* 55: */private String homeCity;
	/* 56: */private String homeState;
	/* 57: */private Integer homeCountryId;
	/* 58: */private String homePinCode;
	/* 59: */private String officeAddressLine1;
	/* 60: */private String officeAddressLine2;
	/* 61: */private String officeCity;
	/* 62: */private String officeState;
	/* 63: */private Integer officeCountryId;
	/* 64: */private String officePinCode;
	/* 65: */private String officePhone1;
	/* 66: */private String officePhone2;
	/* 67: */private String mobilePhone;
	/* 68: */private String homePhone;
	/* 69: */private String email;
	/* 70: */private String fax;
	/* 71: */private String photoFileName;
	/* 72: */private String photoContentType;
	/* 73: */private Blob photoData;
	/* 74: */private Date createdAt;
	/* 75: */private Date updatedAt;
	/* 76: */private Integer photoFileSize;
	/* 77: */private Integer userId;
	/* 78: */private CommonsMultipartFile fileData;
	/* 79: */private String passportNumber;
	/* 80: */@DateTimeFormat(pattern = "dd/MM/yyyy")
	/* 81: */private Date passportExpiryDate;
	private String iqamaNumber;
	/* 80: */@DateTimeFormat(pattern = "dd/MM/yyyy")
	/* 81: */private Date iqamaExpiryDate;
	/* 82: */private Long salary;
	/* 83: */private Integer bankId;
	/* 84: */private String accountNumber;
	/* 85: */private String codeNumber;

	/* 86: */
	/* 87: */public Employees() {
	}

	/* 88: */
	/* 89: */public Employees(Integer employeeCategoryId,
			String employeeNumber, String username, String password,
			Date joiningDate, String firstName, String middleName,
			String lastName, Boolean gender, String jobTitle,
			Integer employeePositionId, Integer employeeDepartmentId,
			Integer reportingManagerId, Integer employeeGradeId,
			String qualification, String experienceDetail,
			Integer experienceYear, Integer experienceMonth, Boolean status,
			String statusDescription, Date dateOfBirth, String maritalStatus,
			Integer childrenCount, String fatherName, String motherName,
			String husbandName, String bloodGroup, Integer nationalityId,
			String homeAddressLine1, String homeAddressLine2, String homeCity,
			String homeState, Integer homeCountryId, String homePinCode,
			String officeAddressLine1, String officeAddressLine2,
			String officeCity, String officeState, Integer officeCountryId,
			String officePinCode, String officePhone1, String officePhone2,
			String mobilePhone, String homePhone, String email, String fax,
			String photoFileName, String photoContentType, Blob photoData,
			Date createdAt, Date updatedAt, Integer photoFileSize,
			Integer userId)
	/* 90: */{
		/* 91: 93 */this.employeeCategoryId = employeeCategoryId;
		/* 92: 94 */this.employeeNumber = employeeNumber;
		/* 93: 95 */this.username = username;
		/* 94: 96 */this.password = password;
		/* 95: 97 */this.joiningDate = joiningDate;
		/* 96: 98 */this.firstName = firstName;
		/* 97: 99 */this.middleName = middleName;
		/* 98:100 */this.lastName = lastName;
		/* 99:101 */this.gender = gender;
		/* 100:102 */this.jobTitle = jobTitle;
		/* 101:103 */this.employeePositionId = employeePositionId;
		/* 102:104 */this.employeeDepartmentId = employeeDepartmentId;
		/* 103:105 */this.reportingManagerId = reportingManagerId;
		/* 104:106 */this.employeeGradeId = employeeGradeId;
		/* 105:107 */this.qualification = qualification;
		/* 106:108 */this.experienceDetail = experienceDetail;
		/* 107:109 */this.experienceYear = experienceYear;
		/* 108:110 */this.experienceMonth = experienceMonth;
		/* 109:111 */this.status = status;
		/* 110:112 */this.statusDescription = statusDescription;
		/* 111:113 */this.dateOfBirth = dateOfBirth;
		/* 112:114 */this.maritalStatus = maritalStatus;
		/* 113:115 */this.childrenCount = childrenCount;
		/* 114:116 */this.fatherName = fatherName;
		/* 115:117 */this.motherName = motherName;
		/* 116:118 */this.husbandName = husbandName;
		/* 117:119 */this.bloodGroup = bloodGroup;
		/* 118:120 */this.nationalityId = nationalityId;
		/* 119:121 */this.homeAddressLine1 = homeAddressLine1;
		/* 120:122 */this.homeAddressLine2 = homeAddressLine2;
		/* 121:123 */this.homeCity = homeCity;
		/* 122:124 */this.homeState = homeState;
		/* 123:125 */this.homeCountryId = homeCountryId;
		/* 124:126 */this.homePinCode = homePinCode;
		/* 125:127 */this.officeAddressLine1 = officeAddressLine1;
		/* 126:128 */this.officeAddressLine2 = officeAddressLine2;
		/* 127:129 */this.officeCity = officeCity;
		/* 128:130 */this.officeState = officeState;
		/* 129:131 */this.officeCountryId = officeCountryId;
		/* 130:132 */this.officePinCode = officePinCode;
		/* 131:133 */this.officePhone1 = officePhone1;
		/* 132:134 */this.officePhone2 = officePhone2;
		/* 133:135 */this.mobilePhone = mobilePhone;
		/* 134:136 */this.homePhone = homePhone;
		/* 135:137 */this.email = email;
		/* 136:138 */this.fax = fax;
		/* 137:139 */this.photoFileName = photoFileName;
		/* 138:140 */this.photoContentType = photoContentType;
		/* 139:141 */this.photoData = photoData;
		/* 140:142 */this.createdAt = createdAt;
		/* 141:143 */this.updatedAt = updatedAt;
		/* 142:144 */this.photoFileSize = photoFileSize;
		/* 143:145 */this.userId = userId;
		/* 144: */}

	/* 145: */
	/* 146: */public Integer getId()
	/* 147: */{
		/* 148:149 */return this.id;
		/* 149: */}

	/* 150: */
	/* 151: */public void setId(Integer id)
	/* 152: */{
		/* 153:153 */this.id = id;
		/* 154: */}

	/* 155: */
	/* 156: */public Integer getEmployeeCategoryId()
	/* 157: */{
		/* 158:157 */return this.employeeCategoryId;
		/* 159: */}

	/* 160: */
	/* 161: */public void setEmployeeCategoryId(Integer employeeCategoryId)
	/* 162: */{
		/* 163:161 */this.employeeCategoryId = employeeCategoryId;
		/* 164: */}

	/* 165: */
	/* 166: */public String getEmployeeNumber()
	/* 167: */{
		/* 168:165 */return this.employeeNumber;
		/* 169: */}

	/* 170: */
	/* 171: */public void setEmployeeNumber(String employeeNumber)
	/* 172: */{
		/* 173:169 */this.employeeNumber = employeeNumber;
		/* 174: */}

	/* 175: */
	/* 176: */public Date getJoiningDate()
	/* 177: */{
		/* 178:173 */return this.joiningDate;
		/* 179: */}

	/* 180: */
	/* 181: */public void setJoiningDate(Date joiningDate)
	/* 182: */{
		/* 183:177 */this.joiningDate = joiningDate;
		/* 184: */}

	/* 185: */
	/* 186: */public String getFirstName()
	/* 187: */{
		/* 188:181 */return this.firstName;
		/* 189: */}

	/* 190: */
	/* 191: */public void setFirstName(String firstName)
	/* 192: */{
		/* 193:185 */this.firstName = firstName;
		/* 194: */}

	/* 195: */
	/* 196: */public String getMiddleName()
	/* 197: */{
		/* 198:189 */return this.middleName;
		/* 199: */}

	/* 200: */
	/* 201: */public void setMiddleName(String middleName)
	/* 202: */{
		/* 203:193 */this.middleName = middleName;
		/* 204: */}

	/* 205: */
	/* 206: */public String getLastName()
	/* 207: */{
		/* 208:197 */return this.lastName;
		/* 209: */}

	/* 210: */
	/* 211: */public void setLastName(String lastName)
	/* 212: */{
		/* 213:201 */this.lastName = lastName;
		/* 214: */}

	/* 215: */
	/* 216: */public Boolean getGender()
	/* 217: */{
		/* 218:205 */return this.gender;
		/* 219: */}

	/* 220: */
	/* 221: */public void setGender(Boolean gender)
	/* 222: */{
		/* 223:209 */this.gender = gender;
		/* 224: */}

	/* 225: */
	/* 226: */public String getJobTitle()
	/* 227: */{
		/* 228:213 */return this.jobTitle;
		/* 229: */}

	/* 230: */
	/* 231: */public void setJobTitle(String jobTitle)
	/* 232: */{
		/* 233:217 */this.jobTitle = jobTitle;
		/* 234: */}

	/* 235: */
	/* 236: */public Integer getEmployeePositionId()
	/* 237: */{
		/* 238:221 */return this.employeePositionId;
		/* 239: */}

	/* 240: */
	/* 241: */public void setEmployeePositionId(Integer employeePositionId)
	/* 242: */{
		/* 243:225 */this.employeePositionId = employeePositionId;
		/* 244: */}

	/* 245: */
	/* 246: */public Integer getEmployeeDepartmentId()
	/* 247: */{
		/* 248:229 */return this.employeeDepartmentId;
		/* 249: */}

	/* 250: */
	/* 251: */public void setEmployeeDepartmentId(Integer employeeDepartmentId)
	/* 252: */{
		/* 253:233 */this.employeeDepartmentId = employeeDepartmentId;
		/* 254: */}

	/* 255: */
	/* 256: */public Integer getReportingManagerId()
	/* 257: */{
		/* 258:237 */return this.reportingManagerId;
		/* 259: */}

	/* 260: */
	/* 261: */public void setReportingManagerId(Integer reportingManagerId)
	/* 262: */{
		/* 263:241 */this.reportingManagerId = reportingManagerId;
		/* 264: */}

	/* 265: */
	/* 266: */public Integer getEmployeeGradeId()
	/* 267: */{
		/* 268:245 */return this.employeeGradeId;
		/* 269: */}

	/* 270: */
	/* 271: */public void setEmployeeGradeId(Integer employeeGradeId)
	/* 272: */{
		/* 273:249 */this.employeeGradeId = employeeGradeId;
		/* 274: */}

	/* 275: */
	/* 276: */public String getQualification()
	/* 277: */{
		/* 278:253 */return this.qualification;
		/* 279: */}

	/* 280: */
	/* 281: */public void setQualification(String qualification)
	/* 282: */{
		/* 283:257 */this.qualification = qualification;
		/* 284: */}

	/* 285: */
	/* 286: */public String getExperienceDetail()
	/* 287: */{
		/* 288:261 */return this.experienceDetail;
		/* 289: */}

	/* 290: */
	/* 291: */public void setExperienceDetail(String experienceDetail)
	/* 292: */{
		/* 293:265 */this.experienceDetail = experienceDetail;
		/* 294: */}

	/* 295: */
	/* 296: */public Integer getExperienceYear()
	/* 297: */{
		/* 298:269 */return this.experienceYear;
		/* 299: */}

	/* 300: */
	/* 301: */public void setExperienceYear(Integer experienceYear)
	/* 302: */{
		/* 303:273 */this.experienceYear = experienceYear;
		/* 304: */}

	/* 305: */
	/* 306: */public Integer getExperienceMonth()
	/* 307: */{
		/* 308:277 */return this.experienceMonth;
		/* 309: */}

	/* 310: */
	/* 311: */public void setExperienceMonth(Integer experienceMonth)
	/* 312: */{
		/* 313:281 */this.experienceMonth = experienceMonth;
		/* 314: */}

	/* 315: */
	/* 316: */public Boolean getStatus()
	/* 317: */{
		/* 318:285 */return this.status;
		/* 319: */}

	/* 320: */
	/* 321: */public void setStatus(Boolean status)
	/* 322: */{
		/* 323:289 */this.status = status;
		/* 324: */}

	/* 325: */
	/* 326: */public String getStatusDescription()
	/* 327: */{
		/* 328:293 */return this.statusDescription;
		/* 329: */}

	/* 330: */
	/* 331: */public void setStatusDescription(String statusDescription)
	/* 332: */{
		/* 333:297 */this.statusDescription = statusDescription;
		/* 334: */}

	/* 335: */
	/* 336: */public Date getDateOfBirth()
	/* 337: */{
		/* 338:301 */return this.dateOfBirth;
		/* 339: */}

	/* 340: */
	/* 341: */public void setDateOfBirth(Date dateOfBirth)
	/* 342: */{
		/* 343:305 */this.dateOfBirth = dateOfBirth;
		/* 344: */}

	/* 345: */
	/* 346: */public String getMaritalStatus()
	/* 347: */{
		/* 348:309 */return this.maritalStatus;
		/* 349: */}

	/* 350: */
	/* 351: */public void setMaritalStatus(String maritalStatus)
	/* 352: */{
		/* 353:313 */this.maritalStatus = maritalStatus;
		/* 354: */}

	/* 355: */
	/* 356: */public Integer getChildrenCount()
	/* 357: */{
		/* 358:317 */return this.childrenCount;
		/* 359: */}

	/* 360: */
	/* 361: */public void setChildrenCount(Integer childrenCount)
	/* 362: */{
		/* 363:321 */this.childrenCount = childrenCount;
		/* 364: */}

	/* 365: */
	/* 366: */public String getFatherName()
	/* 367: */{
		/* 368:325 */return this.fatherName;
		/* 369: */}

	/* 370: */
	/* 371: */public void setFatherName(String fatherName)
	/* 372: */{
		/* 373:329 */this.fatherName = fatherName;
		/* 374: */}

	/* 375: */
	/* 376: */public String getMotherName()
	/* 377: */{
		/* 378:333 */return this.motherName;
		/* 379: */}

	/* 380: */
	/* 381: */public void setMotherName(String motherName)
	/* 382: */{
		/* 383:337 */this.motherName = motherName;
		/* 384: */}

	/* 385: */
	/* 386: */public String getHusbandName()
	/* 387: */{
		/* 388:341 */return this.husbandName;
		/* 389: */}

	/* 390: */
	/* 391: */public void setHusbandName(String husbandName)
	/* 392: */{
		/* 393:345 */this.husbandName = husbandName;
		/* 394: */}

	/* 395: */
	/* 396: */public String getBloodGroup()
	/* 397: */{
		/* 398:349 */return this.bloodGroup;
		/* 399: */}

	/* 400: */
	/* 401: */public void setBloodGroup(String bloodGroup)
	/* 402: */{
		/* 403:353 */this.bloodGroup = bloodGroup;
		/* 404: */}

	/* 405: */
	/* 406: */public Integer getNationalityId()
	/* 407: */{
		/* 408:357 */return this.nationalityId;
		/* 409: */}

	/* 410: */
	/* 411: */public void setNationalityId(Integer nationalityId)
	/* 412: */{
		/* 413:361 */this.nationalityId = nationalityId;
		/* 414: */}

	/* 415: */
	/* 416: */public String getHomeAddressLine1()
	/* 417: */{
		/* 418:365 */return this.homeAddressLine1;
		/* 419: */}

	/* 420: */
	/* 421: */public void setHomeAddressLine1(String homeAddressLine1)
	/* 422: */{
		/* 423:369 */this.homeAddressLine1 = homeAddressLine1;
		/* 424: */}

	/* 425: */
	/* 426: */public String getHomeAddressLine2()
	/* 427: */{
		/* 428:373 */return this.homeAddressLine2;
		/* 429: */}

	/* 430: */
	/* 431: */public void setHomeAddressLine2(String homeAddressLine2)
	/* 432: */{
		/* 433:377 */this.homeAddressLine2 = homeAddressLine2;
		/* 434: */}

	/* 435: */
	/* 436: */public String getHomeCity()
	/* 437: */{
		/* 438:381 */return this.homeCity;
		/* 439: */}

	/* 440: */
	/* 441: */public void setHomeCity(String homeCity)
	/* 442: */{
		/* 443:385 */this.homeCity = homeCity;
		/* 444: */}

	/* 445: */
	/* 446: */public String getHomeState()
	/* 447: */{
		/* 448:389 */return this.homeState;
		/* 449: */}

	/* 450: */
	/* 451: */public void setHomeState(String homeState)
	/* 452: */{
		/* 453:393 */this.homeState = homeState;
		/* 454: */}

	/* 455: */
	/* 456: */public Integer getHomeCountryId()
	/* 457: */{
		/* 458:397 */return this.homeCountryId;
		/* 459: */}

	/* 460: */
	/* 461: */public void setHomeCountryId(Integer homeCountryId)
	/* 462: */{
		/* 463:401 */this.homeCountryId = homeCountryId;
		/* 464: */}

	/* 465: */
	/* 466: */public String getHomePinCode()
	/* 467: */{
		/* 468:405 */return this.homePinCode;
		/* 469: */}

	/* 470: */
	/* 471: */public void setHomePinCode(String homePinCode)
	/* 472: */{
		/* 473:409 */this.homePinCode = homePinCode;
		/* 474: */}

	/* 475: */
	/* 476: */public String getOfficeAddressLine1()
	/* 477: */{
		/* 478:413 */return this.officeAddressLine1;
		/* 479: */}

	/* 480: */
	/* 481: */public void setOfficeAddressLine1(String officeAddressLine1)
	/* 482: */{
		/* 483:417 */this.officeAddressLine1 = officeAddressLine1;
		/* 484: */}

	/* 485: */
	/* 486: */public String getOfficeAddressLine2()
	/* 487: */{
		/* 488:421 */return this.officeAddressLine2;
		/* 489: */}

	/* 490: */
	/* 491: */public void setOfficeAddressLine2(String officeAddressLine2)
	/* 492: */{
		/* 493:425 */this.officeAddressLine2 = officeAddressLine2;
		/* 494: */}

	/* 495: */
	/* 496: */public String getOfficeCity()
	/* 497: */{
		/* 498:429 */return this.officeCity;
		/* 499: */}

	/* 500: */
	/* 501: */public void setOfficeCity(String officeCity)
	/* 502: */{
		/* 503:433 */this.officeCity = officeCity;
		/* 504: */}

	/* 505: */
	/* 506: */public String getOfficeState()
	/* 507: */{
		/* 508:437 */return this.officeState;
		/* 509: */}

	/* 510: */
	/* 511: */public void setOfficeState(String officeState)
	/* 512: */{
		/* 513:441 */this.officeState = officeState;
		/* 514: */}

	/* 515: */
	/* 516: */public Integer getOfficeCountryId()
	/* 517: */{
		/* 518:445 */return this.officeCountryId;
		/* 519: */}

	/* 520: */
	/* 521: */public void setOfficeCountryId(Integer officeCountryId)
	/* 522: */{
		/* 523:449 */this.officeCountryId = officeCountryId;
		/* 524: */}

	/* 525: */
	/* 526: */public String getOfficePinCode()
	/* 527: */{
		/* 528:453 */return this.officePinCode;
		/* 529: */}

	/* 530: */
	/* 531: */public void setOfficePinCode(String officePinCode)
	/* 532: */{
		/* 533:457 */this.officePinCode = officePinCode;
		/* 534: */}

	/* 535: */
	/* 536: */public String getOfficePhone1()
	/* 537: */{
		/* 538:461 */return this.officePhone1;
		/* 539: */}

	/* 540: */
	/* 541: */public void setOfficePhone1(String officePhone1)
	/* 542: */{
		/* 543:465 */this.officePhone1 = officePhone1;
		/* 544: */}

	/* 545: */
	/* 546: */public String getOfficePhone2()
	/* 547: */{
		/* 548:469 */return this.officePhone2;
		/* 549: */}

	/* 550: */
	/* 551: */public void setOfficePhone2(String officePhone2)
	/* 552: */{
		/* 553:473 */this.officePhone2 = officePhone2;
		/* 554: */}

	/* 555: */
	/* 556: */public String getMobilePhone()
	/* 557: */{
		/* 558:477 */return this.mobilePhone;
		/* 559: */}

	/* 560: */
	/* 561: */public void setMobilePhone(String mobilePhone)
	/* 562: */{
		/* 563:481 */this.mobilePhone = mobilePhone;
		/* 564: */}

	/* 565: */
	/* 566: */public String getHomePhone()
	/* 567: */{
		/* 568:485 */return this.homePhone;
		/* 569: */}

	/* 570: */
	/* 571: */public void setHomePhone(String homePhone)
	/* 572: */{
		/* 573:489 */this.homePhone = homePhone;
		/* 574: */}

	/* 575: */
	/* 576: */public String getEmail()
	/* 577: */{
		/* 578:493 */return this.email;
		/* 579: */}

	/* 580: */
	/* 581: */public void setEmail(String email)
	/* 582: */{
		/* 583:497 */this.email = email;
		/* 584: */}

	/* 585: */
	/* 586: */public String getFax()
	/* 587: */{
		/* 588:501 */return this.fax;
		/* 589: */}

	/* 590: */
	/* 591: */public void setFax(String fax)
	/* 592: */{
		/* 593:505 */this.fax = fax;
		/* 594: */}

	/* 595: */
	/* 596: */public String getPhotoFileName()
	/* 597: */{
		/* 598:509 */return this.photoFileName;
		/* 599: */}

	/* 600: */
	/* 601: */public void setPhotoFileName(String photoFileName)
	/* 602: */{
		/* 603:513 */this.photoFileName = photoFileName;
		/* 604: */}

	/* 605: */
	/* 606: */public String getPhotoContentType()
	/* 607: */{
		/* 608:517 */return this.photoContentType;
		/* 609: */}

	/* 610: */
	/* 611: */public void setPhotoContentType(String photoContentType)
	/* 612: */{
		/* 613:521 */this.photoContentType = photoContentType;
		/* 614: */}

	/* 615: */
	/* 616: */public Blob getPhotoData()
	/* 617: */{
		/* 618:525 */return this.photoData;
		/* 619: */}

	/* 620: */
	/* 621: */public void setPhotoData(Blob photoData)
	/* 622: */{
		/* 623:529 */this.photoData = photoData;
		/* 624: */}

	/* 625: */
	/* 626: */public Date getCreatedAt()
	/* 627: */{
		/* 628:533 */return this.createdAt;
		/* 629: */}

	/* 630: */
	/* 631: */public void setCreatedAt(Date createdAt)
	/* 632: */{
		/* 633:537 */this.createdAt = createdAt;
		/* 634: */}

	/* 635: */
	/* 636: */public Date getUpdatedAt()
	/* 637: */{
		/* 638:541 */return this.updatedAt;
		/* 639: */}

	/* 640: */
	/* 641: */public void setUpdatedAt(Date updatedAt)
	/* 642: */{
		/* 643:545 */this.updatedAt = updatedAt;
		/* 644: */}

	/* 645: */
	/* 646: */public Integer getPhotoFileSize()
	/* 647: */{
		/* 648:549 */return this.photoFileSize;
		/* 649: */}

	/* 650: */
	/* 651: */public void setPhotoFileSize(Integer photoFileSize)
	/* 652: */{
		/* 653:553 */this.photoFileSize = photoFileSize;
		/* 654: */}

	/* 655: */
	/* 656: */public Integer getUserId()
	/* 657: */{
		/* 658:557 */return this.userId;
		/* 659: */}

	/* 660: */
	/* 661: */public void setUserId(Integer userId)
	/* 662: */{
		/* 663:561 */this.userId = userId;
		/* 664: */}

	/* 665: */
	/* 666: */public CommonsMultipartFile getFileData()
	/* 667: */{
		/* 668:565 */return this.fileData;
		/* 669: */}

	/* 670: */
	/* 671: */public void setFileData(CommonsMultipartFile fileData)
	/* 672: */{
		/* 673:569 */this.fileData = fileData;
		/* 674: */}

	/* 675: */
	/* 676: */public String getPassportNumber()
	/* 677: */{
		/* 678:573 */return this.passportNumber;
		/* 679: */}

	/* 680: */
	/* 681: */public void setPassportNumber(String passportNumber)
	/* 682: */{
		/* 683:577 */this.passportNumber = passportNumber;
		/* 684: */}

	/* 685: */
	/* 686: */public Date getPassportExpiryDate()
	/* 687: */{
		/* 688:581 */return this.passportExpiryDate;
		/* 689: */}

	/* 690: */
	/* 691: */public void setPassportExpiryDate(Date passportExpiryDate)
	/* 692: */{
		/* 693:585 */this.passportExpiryDate = passportExpiryDate;
		/* 694: */}

	/* 695: */public String getIqamaNumber() {
		return iqamaNumber;
	}

	public void setIqamaNumber(String iqamaNumber) {
		this.iqamaNumber = iqamaNumber;
	}

	public Date getIqamaExpiryDate() {
		return iqamaExpiryDate;
	}

	public void setIqamaExpiryDate(Date iqamaExpiryDate) {
		this.iqamaExpiryDate = iqamaExpiryDate;
	}

	/* 696: */public Long getSalary()
	/* 697: */{
		/* 698:589 */return this.salary;
		/* 699: */}

	/* 700: */
	/* 701: */public void setSalary(Long salary)
	/* 702: */{
		/* 703:593 */this.salary = salary;
		/* 704: */}

	/* 705: */
	/* 706: */public Integer getBankId()
	/* 707: */{
		/* 708:597 */return this.bankId;
		/* 709: */}

	/* 710: */
	/* 711: */public void setBankId(Integer bankId)
	/* 712: */{
		/* 713:601 */this.bankId = bankId;
		/* 714: */}

	/* 715: */
	/* 716: */public String getAccountNumber()
	/* 717: */{
		/* 718:605 */return this.accountNumber;
		/* 719: */}

	/* 720: */
	/* 721: */public void setAccountNumber(String accountNumber)
	/* 722: */{
		/* 723:609 */this.accountNumber = accountNumber;
		/* 724: */}

	/* 725: */
	/* 726: */public String getCodeNumber()
	/* 727: */{
		/* 728:613 */return this.codeNumber;
		/* 729: */}

	/* 730: */
	/* 731: */public void setCodeNumber(String codeNumber)
	/* 732: */{
		/* 733:617 */this.codeNumber = codeNumber;
		/* 734: */}

	/* 735: */
	/* 736: */public boolean equals(Object obj)
	/* 737: */{
		/* 738: */try
		/* 739: */{
			/* 740:623 */if ((obj instanceof Employees))
			/* 741: */{
				/* 742:624 */Employees emp = (Employees) obj;
				/* 743:625 */if (emp.getId().intValue() == getId().intValue()) {
					/* 744:626 */return true;
					/* 745: */}
				/* 746:628 */return false;
				/* 747: */}
			/* 748:631 */return false;
			/* 749: */}
		/* 750: */catch (Exception e)
		/* 751: */{
			/* 752:634 */e.printStackTrace();
			/* 753: */}
		/* 754:636 */return super.equals(obj);
		/* 755: */}

	/* 756: */
	/* 757: */public String getUsername()
	/* 758: */{
		/* 759:640 */return this.username;
		/* 760: */}

	/* 761: */
	/* 762: */public void setUsername(String username)
	/* 763: */{
		/* 764:644 */this.username = username;
		/* 765: */}

	/* 766: */
	/* 767: */public String getPassword()
	/* 768: */{
		/* 769:648 */return this.password;
		/* 770: */}

	/* 771: */
	/* 772: */public void setPassword(String password)
	/* 773: */{
		/* 774:652 */this.password = password;
		/* 775: */}
	/* 776: */
}

/*
 * Location: C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * 
 * Qualified Name: com.tss.ocean.pojo.Employees
 * 
 * JD-Core Version: 0.7.1
 */