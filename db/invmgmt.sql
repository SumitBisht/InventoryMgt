# Host: localhost  (Version: 5.5.40)
# Date: 2014-10-14 23:51:34
# Generator: MySQL-Front 5.3  (Build 4.170)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "accounts"
#

DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `type` int(10) unsigned NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address2` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `postal` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `firstname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone2` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fax` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `notes` text COLLATE utf8_unicode_ci,
  `visible` tinyint(1) DEFAULT NULL,
  `maxdebt` decimal(15,2) DEFAULT NULL,
  `curdebt` decimal(15,2) DEFAULT NULL,
  `image` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='system accounts : Customer or Supplier';

#
# Data for table "accounts"
#

INSERT INTO `accounts` VALUES (1,'Supplier1',1,'Add1','Add2','330001','Banglore','KA','indi','Supp','First','supp@inv.com','98989898','99966996','','',1,NULL,NULL,X'');

#
# Structure for table "acl"
#

DROP TABLE IF EXISTS `acl`;
CREATE TABLE `acl` (
  `aclid` varchar(255) NOT NULL,
  `aclmodule` varchar(255) NOT NULL,
  `parentaclid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aclid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "acl"
#

INSERT INTO `acl` VALUES ('account','Accounts',NULL),('item','Item',NULL),('itemcategory','Item Category',NULL),('itemunit','Item unit',NULL),('purchaseorder','Purchase Order',NULL),('purchaserequisition','Purchase Requisition',NULL);

#
# Structure for table "acl_entity"
#

DROP TABLE IF EXISTS `acl_entity`;
CREATE TABLE `acl_entity` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `aclid` varchar(255) NOT NULL,
  `entityid` int(10) unsigned NOT NULL,
  `entitytype` int(10) unsigned NOT NULL,
  `permissionlevel` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_index` (`aclid`,`entityid`,`entitytype`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

#
# Data for table "acl_entity"
#

INSERT INTO `acl_entity` VALUES (6,'purchaseorder',1,2,7),(7,'itemcategory',1,2,7),(8,'itemunit',1,2,7),(9,'item',1,2,3),(10,'account',1,2,7),(11,'purchaserequisition',1,2,7),(12,'account',2,2,0),(13,'item',2,2,0),(14,'itemcategory',2,2,0),(15,'itemunit',2,2,0),(16,'purchaseorder',2,2,0),(17,'purchaserequisition',2,2,0),(18,'account',3,2,0),(19,'item',3,2,0),(20,'itemcategory',3,2,0),(21,'itemunit',3,2,0),(22,'purchaseorder',3,2,0),(23,'purchaserequisition',3,2,0),(24,'account',4,2,0),(25,'item',4,2,0),(26,'itemcategory',4,2,0),(27,'itemunit',4,2,0),(28,'purchaseorder',4,2,0),(29,'purchaserequisition',4,2,0);

#
# Structure for table "alarmevent"
#

DROP TABLE IF EXISTS `alarmevent`;
CREATE TABLE `alarmevent` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `alarmid` int(10) unsigned NOT NULL,
  `value` int(10) unsigned DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `attributes` blob,
  `expirydate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Alarm occurances';

#
# Data for table "alarmevent"
#


#
# Structure for table "alarms"
#

DROP TABLE IF EXISTS `alarms`;
CREATE TABLE `alarms` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Description` text COLLATE utf8_unicode_ci,
  `active` tinyint(1) DEFAULT NULL,
  `createdat` int(10) unsigned DEFAULT NULL,
  `updatedat` int(10) unsigned DEFAULT NULL,
  `createdby` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='no of Alarms for the system';

#
# Data for table "alarms"
#


#
# Structure for table "apply_leaves"
#

DROP TABLE IF EXISTS `apply_leaves`;
CREATE TABLE `apply_leaves` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `employee_leave_types_id` int(11) DEFAULT NULL,
  `is_half_day` tinyint(1) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `reason` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `approved` tinyint(1) DEFAULT '0',
  `viewed_by_manager` tinyint(1) DEFAULT '0',
  `manager_remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "apply_leaves"
#


#
# Structure for table "bank"
#

DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address1` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `country_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "bank"
#

INSERT INTO `bank` VALUES (1,'Bank1','Add','','C',NULL);

#
# Structure for table "country"
#

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `code` varchar(45) NOT NULL,
  `createdby` varchar(45) NOT NULL,
  `createdate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "country"
#


#
# Structure for table "employee_attendances"
#

DROP TABLE IF EXISTS `employee_attendances`;
CREATE TABLE `employee_attendances` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attendance_date` date DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `employee_leave_type_id` int(11) DEFAULT NULL,
  `reason` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_half_day` tinyint(1) DEFAULT NULL,
  `in_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `out_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_leave` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "employee_attendances"
#

INSERT INTO `employee_attendances` VALUES (2,'2014-09-01',1,NULL,NULL,0,'null:null','null:null',0),(3,'2014-09-01',1,NULL,NULL,0,'1:2','18:1',0);

#
# Structure for table "employee_category"
#

DROP TABLE IF EXISTS `employee_category`;
CREATE TABLE `employee_category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category` varchar(100) NOT NULL,
  `prefix` varchar(45) NOT NULL,
  `isactive` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

#
# Data for table "employee_category"
#

INSERT INTO `employee_category` VALUES (2,'finance','fn',0000000001),(3,'admin','001',0000000001);

#
# Structure for table "employee_department"
#

DROP TABLE IF EXISTS `employee_department`;
CREATE TABLE `employee_department` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `department` varchar(100) NOT NULL,
  `code` varchar(45) NOT NULL,
  `isactive` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Data for table "employee_department"
#

INSERT INTO `employee_department` VALUES (1,'Depqrtment12','d12',1),(2,'payroll','pl',1);

#
# Structure for table "employee_leave_types"
#

DROP TABLE IF EXISTS `employee_leave_types`;
CREATE TABLE `employee_leave_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `max_leave_count` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `carry_forward` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "employee_leave_types"
#

INSERT INTO `employee_leave_types` VALUES (1,'Sick leave1','SL',1,'10',1),(2,'Sick','00220',1,'5',1);

#
# Structure for table "employee_leaves"
#

DROP TABLE IF EXISTS `employee_leaves`;
CREATE TABLE `employee_leaves` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `employee_leave_type_id` int(11) DEFAULT NULL,
  `leave_count` decimal(5,1) DEFAULT '0.0',
  `leave_taken` decimal(5,1) DEFAULT '0.0',
  `reset_date` date DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "employee_leaves"
#


#
# Structure for table "employee_position"
#

DROP TABLE IF EXISTS `employee_position`;
CREATE TABLE `employee_position` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `position` varchar(100) NOT NULL,
  `categoryid` int(10) unsigned NOT NULL,
  `isactive` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "employee_position"
#


#
# Structure for table "employees"
#

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_category_id` int(11) DEFAULT NULL,
  `employee_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `joining_date` date DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `middle_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `job_title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee_position_id` int(11) DEFAULT NULL,
  `employee_department_id` int(11) DEFAULT NULL,
  `reporting_manager_id` int(11) DEFAULT NULL,
  `employee_grade_id` int(11) DEFAULT NULL,
  `qualification` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `experience_detail` text COLLATE utf8_unicode_ci,
  `experience_year` int(11) DEFAULT NULL,
  `experience_month` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `status_description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `marital_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `children_count` int(11) DEFAULT NULL,
  `father_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mother_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `husband_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `blood_group` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nationality_id` int(11) DEFAULT NULL,
  `home_address_line1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `home_address_line2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `home_city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `home_state` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `home_country_id` int(11) DEFAULT NULL,
  `home_pin_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `office_address_line1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `office_address_line2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `office_city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `office_state` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `office_country_id` int(11) DEFAULT NULL,
  `office_pin_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `office_phone1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `office_phone2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mobile_phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `home_phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fax` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo_file_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo_content_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo_data` mediumblob,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `photo_file_size` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `passport_number` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `passport_expiry_date` datetime DEFAULT NULL,
  `bank_id` int(10) unsigned DEFAULT NULL,
  `account_number` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `salary` int(10) unsigned DEFAULT NULL,
  `code_number` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `iqama_number` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `iqama_expiry_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_employees_on_employee_number` (`employee_number`(10))
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "employees"
#

INSERT INTO `employees` VALUES (1,1,'001','admin','admin','2014-09-01','Admin','sys','1',1,'',NULL,1,NULL,NULL,'','',NULL,NULL,1,NULL,'2014-09-01','',NULL,'','','','',NULL,'','','','',NULL,'','','','','',NULL,'','','','','','','','','application/octet-stream',X'',NULL,NULL,0,NULL,'',NULL,NULL,'',NULL,'',NULL,NULL),(8,2,'002','user2','user2','2014-09-01','Admin2','system','admin2',1,'',NULL,1,NULL,NULL,'','',NULL,NULL,1,NULL,'2014-09-01','',NULL,'','','','',NULL,'','','','',NULL,'','','','','',NULL,'','','','','','','','','application/octet-stream',X'',NULL,NULL,0,NULL,'',NULL,NULL,'',NULL,'',NULL,NULL),(9,3,'4545',NULL,NULL,NULL,'rtt','rete','ertert',1,'ertet',NULL,1,1,NULL,'dftert','',NULL,NULL,NULL,NULL,'2014-10-23','',NULL,'','','','',NULL,'','','','',NULL,'','','','','',NULL,'','','','','','','','','application/octet-stream',X'',NULL,NULL,0,NULL,'','2014-10-23 00:00:00',NULL,'',NULL,'',NULL,NULL);

#
# Structure for table "item"
#

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `alias` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `categoryid` int(10) unsigned NOT NULL,
  `typeid` int(10) unsigned NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `taxid` int(10) unsigned NOT NULL,
  `unitid` int(10) unsigned NOT NULL,
  `currstock` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "item"
#

INSERT INTO `item` VALUES (1,'Item1','123',0,1,500.00,0,1,5),(2,'Item2','123',0,2,200.00,0,1,10),(3,'Ø§ÙØªÙÙÙÙ','123',0,1,60.00,0,1,40);

#
# Structure for table "itemtype"
#

DROP TABLE IF EXISTS `itemtype`;
CREATE TABLE `itemtype` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "itemtype"
#

INSERT INTO `itemtype` VALUES (1,'Category1','category 1 description'),(2,'Category2','Item category Desc 2');

#
# Structure for table "itemunit"
#

DROP TABLE IF EXISTS `itemunit`;
CREATE TABLE `itemunit` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "itemunit"
#

INSERT INTO `itemunit` VALUES (1,'KG','Kilogrram Unit.'),(2,'Lt','Liter Desc');

#
# Structure for table "monthly_payslips"
#

DROP TABLE IF EXISTS `monthly_payslips`;
CREATE TABLE `monthly_payslips` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salary_date` date DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `payroll_category_id` int(11) DEFAULT NULL,
  `amount` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_approved` tinyint(1) NOT NULL DEFAULT '0',
  `approver_id` int(11) DEFAULT NULL,
  `is_rejected` tinyint(1) NOT NULL DEFAULT '0',
  `rejector_id` int(11) DEFAULT NULL,
  `reason` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "monthly_payslips"
#

INSERT INTO `monthly_payslips` VALUES (1,'2014-09-02',1,1,'5000.0',0,NULL,0,NULL,NULL,NULL),(2,'2014-09-07',8,1,'4500.0',0,NULL,0,NULL,NULL,NULL);

#
# Structure for table "new table"
#

DROP TABLE IF EXISTS `new table`;
CREATE TABLE `new table` (
  `aclid` int(10) unsigned NOT NULL,
  `aclmodule` varchar(255) NOT NULL,
  `parentaclid` varchar(255) NOT NULL,
  PRIMARY KEY (`aclid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "new table"
#


#
# Structure for table "payroll_categories"
#

DROP TABLE IF EXISTS `payroll_categories`;
CREATE TABLE `payroll_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `percentage` float DEFAULT NULL,
  `payroll_category_id` int(11) DEFAULT NULL,
  `is_deduction` tinyint(1) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "payroll_categories"
#

INSERT INTO `payroll_categories` VALUES (1,'Basic',20,NULL,0,1),(2,'HRA',10,NULL,0,1),(3,'Pro TAX',NULL,NULL,1,1),(4,'Genral',10,2,1,1);

#
# Structure for table "prstatus"
#

DROP TABLE IF EXISTS `prstatus`;
CREATE TABLE `prstatus` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `status` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `order` int(10) unsigned NOT NULL,
  `usertype` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Purchase requisition statuses';

#
# Data for table "prstatus"
#

INSERT INTO `prstatus` VALUES (1,'PR Init','Purchase Initiated',1,0),(2,'Supplier Bind','Supplier is binded with PR',2,0),(3,'supervisor Approved','PR approval with supervison',3,0),(4,'Fin Approved','Finance dept approval ',4,0);

#
# Structure for table "purorder"
#

DROP TABLE IF EXISTS `purorder`;
CREATE TABLE `purorder` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `purrequisition` int(10) unsigned DEFAULT NULL,
  `supplier` int(10) unsigned DEFAULT NULL,
  `createdat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedat` datetime DEFAULT NULL,
  `createdby` int(10) unsigned DEFAULT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `updatedby` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Purchase Orders';

#
# Data for table "purorder"
#

INSERT INTO `purorder` VALUES (1,1,1,'2014-09-02 00:00:00',NULL,1,500.00,NULL);

#
# Structure for table "purorderdt"
#

DROP TABLE IF EXISTS `purorderdt`;
CREATE TABLE `purorderdt` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `purorderid` int(10) unsigned NOT NULL,
  `itemid` int(10) unsigned NOT NULL,
  `qty` int(10) unsigned NOT NULL,
  `price` decimal(15,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Purchase Order detail';

#
# Data for table "purorderdt"
#


#
# Structure for table "purreq_item"
#

DROP TABLE IF EXISTS `purreq_item`;
CREATE TABLE `purreq_item` (
  `purrequisition_id` int(10) unsigned NOT NULL,
  `item_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`purrequisition_id`,`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "purreq_item"
#

INSERT INTO `purreq_item` VALUES (1,2),(2,1),(2,2),(9,2);

#
# Structure for table "purrequisition"
#

DROP TABLE IF EXISTS `purrequisition`;
CREATE TABLE `purrequisition` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `prno` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `suplierid` int(10) unsigned DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  `approvedby` int(10) unsigned DEFAULT NULL,
  `approvedbydate` datetime DEFAULT NULL,
  `nextapprovedby` int(10) unsigned DEFAULT NULL,
  `createdat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedat` datetime DEFAULT NULL,
  `isbilled` tinyint(1) DEFAULT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `createdby` int(10) unsigned DEFAULT NULL,
  `updatedby` int(10) unsigned DEFAULT NULL,
  `approvalStatus` tinyint(3) DEFAULT '0',
  `processed` tinyint(3) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='purchase requisition ';

#
# Data for table "purrequisition"
#

INSERT INTO `purrequisition` VALUES (1,'1009946660534726753949927870281738355832',1,1,NULL,NULL,NULL,'2014-09-03 00:00:00',NULL,0,500.00,NULL,NULL,0,0),(2,'1229342777065735978814358205994209775224',1,1,NULL,NULL,NULL,'2014-09-02 00:00:00',NULL,1,200.00,NULL,NULL,0,0),(3,'450',1,5,NULL,NULL,NULL,'2014-09-20 19:26:19',NULL,NULL,500.00,1,NULL,0,0),(4,'249',1,5,NULL,NULL,NULL,'2014-09-20 19:33:07',NULL,NULL,50.00,1,NULL,0,0),(5,'795',1,5,NULL,NULL,NULL,'2014-09-21 11:38:25',NULL,NULL,500.00,1,NULL,0,0),(6,'575',1,1,NULL,NULL,NULL,'2014-09-21 00:00:00',NULL,NULL,500.00,NULL,NULL,0,0),(7,'240',1,1,NULL,NULL,NULL,'2014-09-21 00:00:00',NULL,NULL,500.00,NULL,NULL,0,0),(8,'193',1,1,NULL,NULL,1,'2014-09-21 12:15:09',NULL,NULL,5000.00,1,NULL,1,0),(9,'411',1,1,NULL,NULL,1,'2014-10-14 18:52:04',NULL,1,888888888888.00,1,NULL,0,0);

#
# Structure for table "purrequisitiondt"
#

DROP TABLE IF EXISTS `purrequisitiondt`;
CREATE TABLE `purrequisitiondt` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `purreqid` int(10) unsigned NOT NULL,
  `itemid` int(10) unsigned NOT NULL,
  `qty` int(10) unsigned NOT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Purchase Requisition Detail';

#
# Data for table "purrequisitiondt"
#

INSERT INTO `purrequisitiondt` VALUES (1,6,1,50,50.00),(2,6,1,50,5.00),(3,7,1,50,500.00),(4,7,1,50,50.00),(7,8,1,50,50.00),(8,8,1,20,200.00);

#
# Structure for table "purrequisitiondtlog"
#

DROP TABLE IF EXISTS `purrequisitiondtlog`;
CREATE TABLE `purrequisitiondtlog` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `purreqid` int(10) unsigned NOT NULL,
  `itemid` int(10) unsigned NOT NULL,
  `qty` int(10) unsigned NOT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Purchase Requisition Detail logs';

#
# Data for table "purrequisitiondtlog"
#


#
# Structure for table "purrequisitionlog"
#

DROP TABLE IF EXISTS `purrequisitionlog`;
CREATE TABLE `purrequisitionlog` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `prno` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `suplierid` int(10) unsigned DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  `approvedby` int(10) unsigned DEFAULT NULL,
  `createdat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedat` datetime DEFAULT NULL,
  `isbilled` tinyint(1) DEFAULT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `createdby` int(10) unsigned DEFAULT NULL,
  `updatedby` int(10) unsigned DEFAULT NULL,
  `comments` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='purchase requisition ';

#
# Data for table "purrequisitionlog"
#


#
# Structure for table "settings"
#

DROP TABLE IF EXISTS `settings`;
CREATE TABLE `settings` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `key` varchar(45) NOT NULL,
  `value` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Application Settings.';

#
# Data for table "settings"
#

INSERT INTO `settings` VALUES (1,'app.title','Inventory Management System');

#
# Structure for table "users"
#

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `usertypeid` int(10) unsigned DEFAULT NULL,
  `isactive` tinyint(1) DEFAULT NULL,
  `createdat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updateat` datetime DEFAULT NULL,
  `image` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "users"
#

INSERT INTO `users` VALUES (1,'admin','admin',1,1,'2014-09-08 14:02:23',NULL,NULL);

#
# Structure for table "purord_approvers"
#

DROP TABLE IF EXISTS `purord_approvers`;
CREATE TABLE `purord_approvers` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL,
  `level` int(10) unsigned NOT NULL,
  `createdby` int(10) unsigned NOT NULL,
  `createdat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_purord_approvers_1` (`userid`),
  CONSTRAINT `FK_purord_approvers_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Purchase order approvers';

#
# Data for table "purord_approvers"
#

INSERT INTO `purord_approvers` VALUES (1,1,0,1,'2014-09-21 11:42:45');

#
# Structure for table "usertype"
#

DROP TABLE IF EXISTS `usertype`;
CREATE TABLE `usertype` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `usertype` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `createdat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updateat` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='User type of the system';

#
# Data for table "usertype"
#

INSERT INTO `usertype` VALUES (1,'admin',NULL,'2014-09-30 22:29:58',NULL);
