# Host: localhost  (Version: 5.6.20)
# Date: 2014-10-14 11:12:06
# Generator: MySQL-Front 5.3  (Build 4.175)

/*!40101 SET NAMES utf8 */;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "employees"
#

INSERT INTO `employees` VALUES (1,1,'001',NULL,NULL,'2014-09-01','Admin','sys','1',1,'',NULL,1,1,NULL,'','',NULL,NULL,NULL,NULL,'2014-09-01','',NULL,'','','','',NULL,'','','','',NULL,'','','','','',NULL,'','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'23234242213','2014-10-29 00:00:00',NULL,'',NULL,'',NULL,NULL),(8,2,'002',NULL,NULL,'2014-09-01','Admin2','system','admin2',1,'',NULL,1,NULL,NULL,'','',NULL,NULL,NULL,NULL,'2014-09-01','',NULL,'','','','',NULL,'','','','',NULL,'','','','','',NULL,'','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','2014-10-28 00:00:00',NULL,'',NULL,'',NULL,NULL),(10,1,'323',NULL,NULL,NULL,'mukesh','kumar','singh',1,'12121212',NULL,2,1,NULL,'mca','SDSDDS',32,2323,NULL,NULL,'2014-09-01','',1,'1','1','1','',NULL,'1','1','1','1',NULL,'1','1','Q','Q','ZAQ',NULL,'1','1','1','1','1','1','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'10','2014-10-01 00:00:00',1,'323232323232323',323232323,'2323','2120','2014-10-31 00:00:00');
