CREATE DATABASE  IF NOT EXISTS `enrollmentdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `enrollmentdb`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: enrollmentdb
-- ------------------------------------------------------
-- Server version	5.6.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admission_mt`
--

DROP TABLE IF EXISTS `admission_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admission_mt` (
  `admission_id` int(11) NOT NULL AUTO_INCREMENT,
  `registration_id` int(11) NOT NULL,
  `gradelevel_id` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `isComplete` bit(1) NOT NULL DEFAULT b'1',
  `completion_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`admission_id`),
  UNIQUE KEY `registration_id_UNIQUE` (`registration_id`),
  KEY `fk_admission_mtTABLE_gradelevel_idCOL_idx` (`gradelevel_id`),
  KEY `fk_admission_mtTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_admission_mtTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_admission_mtTABLE_registration_idCOL` FOREIGN KEY (`registration_id`) REFERENCES `registration_mt` (`registration_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_admission_mtTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1 COMMENT='This is a table to be used for new students only.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admission_mt`
--

LOCK TABLES `admission_mt` WRITE;
/*!40000 ALTER TABLE `admission_mt` DISABLE KEYS */;
INSERT INTO `admission_mt` VALUES (21,7,301,432,'','2018-02-07 10:04:46'),(22,8,308,432,'','2018-02-12 20:52:55'),(23,9,302,432,'','2018-02-12 22:01:02');
/*!40000 ALTER TABLE `admission_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `balancebreakdown`
--

DROP TABLE IF EXISTS `balancebreakdown`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `balancebreakdown` (
  `balancebreakdown_id` int(11) NOT NULL AUTO_INCREMENT,
  `balancebreakdown_name` varchar(45) NOT NULL,
  `balancebreakdown_amount` decimal(10,2) NOT NULL,
  `due_date` date DEFAULT NULL,
  `category` varchar(1) DEFAULT NULL,
  `student_id` int(11) NOT NULL,
  `paymentterm_id` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `date_assigned` datetime DEFAULT CURRENT_TIMESTAMP,
  `is_active` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`balancebreakdown_id`),
  UNIQUE KEY `uk_bbname_student_id_syId` (`balancebreakdown_name`,`student_id`,`schoolyear_id`),
  KEY `fk_balancebreakdownTABLE_student_idCOL_idx` (`student_id`),
  KEY `fk_balancebreakdownTABLE_paymentterm_idCOL_idx` (`paymentterm_id`),
  KEY `fk_balancebreakdownTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_balancebreakdownTABLE_paymentterm_idCOL` FOREIGN KEY (`paymentterm_id`) REFERENCES `paymentterm_mt` (`paymentterm_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_balancebreakdownTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_balancebreakdownTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `balancebreakdown`
--

LOCK TABLES `balancebreakdown` WRITE;
/*!40000 ALTER TABLE `balancebreakdown` DISABLE KEYS */;
INSERT INTO `balancebreakdown` VALUES (134,'2nd Semester',6812.07,'2018-01-03','B',19,4,432,'2018-02-07 10:07:28',''),(135,'1st Semester',6812.07,'2018-01-02','B',19,4,432,'2018-02-07 10:07:28',''),(136,'Downpayment',1500.00,'2018-01-01','D',19,4,432,'2018-02-07 10:07:28',''),(137,'Field Trip',1250.65,'1970-01-01','O',19,4,432,'2018-02-07 10:07:28',''),(138,'Taekwondo',1500.00,'1970-01-01','O',19,4,432,'2018-02-07 10:07:28',''),(139,'2nd Semester',6812.07,'2018-01-03','B',20,4,432,'2018-02-12 20:55:12',''),(140,'1st Semester',6812.07,'2018-01-02','B',20,4,432,'2018-02-12 20:55:12',''),(141,'Downpayment',1500.00,'2018-01-01','D',20,4,432,'2018-02-12 20:55:12',''),(142,'Field Trip',1250.65,'1970-01-01','O',20,4,432,'2018-02-12 20:55:12',''),(143,'Taekwondo',1500.00,'1970-01-01','O',20,4,432,'2018-02-12 20:55:12',''),(144,'2nd Semester',6812.07,'2018-01-03','B',21,4,432,'2018-02-12 22:01:39',''),(145,'1st Semester',6812.07,'2018-01-02','B',21,4,432,'2018-02-12 22:01:39',''),(146,'Downpayment',1500.00,'2018-01-01','D',21,4,432,'2018-02-12 22:01:39',''),(147,'Field Trip',1250.65,'1970-01-01','O',21,4,432,'2018-02-12 22:01:39',''),(148,'Taekwondo',1500.00,'1970-01-01','O',21,4,432,'2018-02-12 22:01:39','');
/*!40000 ALTER TABLE `balancebreakdown` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credential_requirements_lt`
--

DROP TABLE IF EXISTS `credential_requirements_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credential_requirements_lt` (
  `credential_id` int(11) NOT NULL COMMENT 'This table contains all required credentials to be submitted by a student.\nSchool year column is added to know when or what school year the credential was required for that gradelevel..',
  `gradelevel_id` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `fk_credential_requirements_ltTABLE_credential_idCOL_idx` (`credential_id`),
  KEY `fk_credential_requirements_ltTABLE_gradelevel_idCOL_idx` (`gradelevel_id`),
  KEY `fk_credential_requirements_ltTABLE_schoolyearl_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_credential_requirements_ltTABLE_credential_idCOL` FOREIGN KEY (`credential_id`) REFERENCES `credentials_mt` (`credential_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_credential_requirements_ltTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_credential_requirements_ltTABLE_schoolyearl_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credential_requirements_lt`
--

LOCK TABLES `credential_requirements_lt` WRITE;
/*!40000 ALTER TABLE `credential_requirements_lt` DISABLE KEYS */;
/*!40000 ALTER TABLE `credential_requirements_lt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credentials_mt`
--

DROP TABLE IF EXISTS `credentials_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credentials_mt` (
  `credential_id` int(11) NOT NULL AUTO_INCREMENT,
  `credential_name` varchar(45) NOT NULL,
  `date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `credential_description` text NOT NULL,
  PRIMARY KEY (`credential_id`),
  UNIQUE KEY `credential_name_UNIQUE` (`credential_name`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1 COMMENT='Master Table of Credentials';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credentials_mt`
--

LOCK TABLES `credentials_mt` WRITE;
/*!40000 ALTER TABLE `credentials_mt` DISABLE KEYS */;
INSERT INTO `credentials_mt` VALUES (18,'Birth Certificate','2017-03-24 01:31:07',''),(19,'Baptismal','2017-03-24 01:32:20',''),(20,'ID','2017-03-24 01:33:00',''),(21,'Report Card','2017-03-24 01:33:35',''),(22,'Certificate Of Good Moral','2017-03-24 01:33:58','');
/*!40000 ALTER TABLE `credentials_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credentials_received_lt`
--

DROP TABLE IF EXISTS `credentials_received_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credentials_received_lt` (
  `credential_id` int(11) NOT NULL,
  `registration_id` int(11) NOT NULL,
  `date_received` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `credentials_received_ltTABLE_credential_idCOL_idx` (`credential_id`),
  KEY `credentials_received_ltTABLE_registration_idCOL_idx` (`registration_id`),
  CONSTRAINT `credentials_received_ltTABLE_credential_idCOL` FOREIGN KEY (`credential_id`) REFERENCES `credentials_mt` (`credential_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `credentials_received_ltTABLE_registration_idCOL` FOREIGN KEY (`registration_id`) REFERENCES `registration_mt` (`registration_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credentials_received_lt`
--

LOCK TABLES `credentials_received_lt` WRITE;
/*!40000 ALTER TABLE `credentials_received_lt` DISABLE KEYS */;
/*!40000 ALTER TABLE `credentials_received_lt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curriculum_mt`
--

DROP TABLE IF EXISTS `curriculum_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curriculum_mt` (
  `curriculum_id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolyear_id` int(11) NOT NULL,
  `curriculum_title` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `isActive` bit(1) DEFAULT b'1',
  `date_created` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`curriculum_id`),
  UNIQUE KEY `curriculum_title_UNIQUE` (`curriculum_title`),
  KEY `fk_curriculum_mtTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_curriculum_mtTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Curriculum Master Table to hold all Curriculums.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curriculum_mt`
--

LOCK TABLES `curriculum_mt` WRITE;
/*!40000 ALTER TABLE `curriculum_mt` DISABLE KEYS */;
/*!40000 ALTER TABLE `curriculum_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curriculum_subject_lt`
--

DROP TABLE IF EXISTS `curriculum_subject_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curriculum_subject_lt` (
  `curriculum_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `subject_hours` decimal(10,2) NOT NULL,
  KEY `fk_curriculum_subject_ltTABLE_curriculum_idCOL_idx` (`curriculum_id`),
  KEY `fk_curriculum_subject_ltTABLE_subject_idCOL_idx` (`subject_id`),
  CONSTRAINT `fk_curriculum_subject_ltTABLE_curriculum_idCOL` FOREIGN KEY (`curriculum_id`) REFERENCES `curriculum_mt` (`curriculum_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_curriculum_subject_ltTABLE_subject_idCOL` FOREIGN KEY (`subject_id`) REFERENCES `subject_mt` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curriculum_subject_lt`
--

LOCK TABLES `curriculum_subject_lt` WRITE;
/*!40000 ALTER TABLE `curriculum_subject_lt` DISABLE KEYS */;
/*!40000 ALTER TABLE `curriculum_subject_lt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dashboardpermission`
--

DROP TABLE IF EXISTS `dashboardpermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dashboardpermission` (
  `dashboardpermission_id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  `can_access_registration` bit(1) NOT NULL,
  `can_access_grades` bit(1) NOT NULL,
  `can_access_payment` bit(1) NOT NULL,
  `can_access_enrollment` bit(1) NOT NULL,
  `can_access_settings` bit(1) NOT NULL,
  `can_access_accounts` bit(1) NOT NULL,
  `can_access_reports` bit(1) DEFAULT NULL,
  `date_last_modified` datetime DEFAULT NULL,
  `modified_by_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`dashboardpermission_id`),
  KEY `fk_dashboardpermissionTABLE_modified_by_idCOL_idx` (`modified_by_id`),
  CONSTRAINT `fk_dashboardpermissionTABLE_modified_by_idCOL` FOREIGN KEY (`modified_by_id`) REFERENCES `user_mt` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboardpermission`
--

LOCK TABLES `dashboardpermission` WRITE;
/*!40000 ALTER TABLE `dashboardpermission` DISABLE KEYS */;
INSERT INTO `dashboardpermission` VALUES (1,'Administrator Dashboard Permission','','','','','','','',NULL,NULL),(2,'Cashier Dashboard Permission','\0','\0','','','\0','\0','\0',NULL,NULL),(3,'Registrar Dashboard Permission','','\0','\0','','\0','\0','',NULL,NULL),(4,'Faculty Dashboard Permission','\0','','\0','\0','\0','\0','',NULL,NULL);
/*!40000 ALTER TABLE `dashboardpermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount_mt`
--

DROP TABLE IF EXISTS `discount_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discount_mt` (
  `discount_id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_name` varchar(45) NOT NULL,
  `percentage` int(11) NOT NULL,
  `description` text NOT NULL,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isActive` bit(1) DEFAULT b'1',
  PRIMARY KEY (`discount_id`),
  UNIQUE KEY `discount_name_UNIQUE` (`discount_name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COMMENT='MASTER table of dicounts';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount_mt`
--

LOCK TABLES `discount_mt` WRITE;
/*!40000 ALTER TABLE `discount_mt` DISABLE KEYS */;
INSERT INTO `discount_mt` VALUES (4,'Employee Relative',15,'Employee Relative','2017-03-14 14:08:19',''),(5,'Varsity',8,'Discount for Varsity','2017-03-14 14:08:19',''),(7,'Referral',6,'Referral Discount','2017-03-14 14:08:19',''),(8,'Scholar-B',50,'50% Scholarship','2017-03-14 19:15:22',''),(9,'Scholar-A',100,'100% Discount for Scholars','2017-03-14 19:16:57',''),(10,'Scholar-C',25,'25% Discount for Scholars','2017-03-14 19:25:41',''),(11,'sibling discount',30,'sibling discount','2017-03-25 17:42:50','');
/*!40000 ALTER TABLE `discount_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `downpayment_mt`
--

DROP TABLE IF EXISTS `downpayment_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `downpayment_mt` (
  `downpayment_id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolyear_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `date_paid` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`downpayment_id`),
  KEY `fk_downpyament_mtTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_downpyament_mtTABLE_student_idCOL_idx` (`student_id`),
  CONSTRAINT `fk_downpyament_mtTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_downpyament_mtTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `downpayment_mt`
--

LOCK TABLES `downpayment_mt` WRITE;
/*!40000 ALTER TABLE `downpayment_mt` DISABLE KEYS */;
/*!40000 ALTER TABLE `downpayment_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollment`
--

DROP TABLE IF EXISTS `enrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enrollment` (
  `enrollment_id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolyear_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `enrollment_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isEnrollmentWithdrawn` bit(1) NOT NULL DEFAULT b'0',
  `enrollment_type` varchar(1) NOT NULL COMMENT 'R = Regular Enrollment\nS = Summer Enrollment',
  PRIMARY KEY (`enrollment_id`),
  KEY `fk_enrolleesTABLE_student_idCOL_idx` (`student_id`),
  KEY `fk_enrolleesTABLE_schoolyear_idCOL_idx` (`schoolyear_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollment`
--

LOCK TABLES `enrollment` WRITE;
/*!40000 ALTER TABLE `enrollment` DISABLE KEYS */;
INSERT INTO `enrollment` VALUES (3,432,13,'2018-02-04 10:03:56','\0','R'),(4,432,14,'2018-02-04 11:06:48','\0','R'),(5,432,15,'2018-02-05 12:30:17','\0','R'),(6,432,16,'2018-02-05 18:59:22','\0','R'),(7,432,17,'2018-02-07 09:45:19','\0','R'),(8,432,18,'2018-02-07 09:54:15','\0','R'),(9,432,19,'2018-02-07 10:07:28','\0','R'),(10,432,20,'2018-02-12 20:55:12','\0','R'),(11,432,21,'2018-02-12 22:01:40','\0','R');
/*!40000 ALTER TABLE `enrollment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollmentpermission`
--

DROP TABLE IF EXISTS `enrollmentpermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enrollmentpermission` (
  `enrollmentpermission_id` int(11) NOT NULL AUTO_INCREMENT,
  `can_view_registered_students` bit(1) NOT NULL,
  `can_search_student` bit(1) NOT NULL,
  `can_complete_student_admission` bit(1) NOT NULL,
  PRIMARY KEY (`enrollmentpermission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollmentpermission`
--

LOCK TABLES `enrollmentpermission` WRITE;
/*!40000 ALTER TABLE `enrollmentpermission` DISABLE KEYS */;
/*!40000 ALTER TABLE `enrollmentpermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_mt`
--

DROP TABLE IF EXISTS `faculty_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty_mt` (
  `faculty_id` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `middleName` varchar(45) NOT NULL,
  `contactNo` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `status` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`faculty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_mt`
--

LOCK TABLES `faculty_mt` WRITE;
/*!40000 ALTER TABLE `faculty_mt` DISABLE KEYS */;
INSERT INTO `faculty_mt` VALUES (4,'Antonio','John Ferdinand','Maala','09054484843','ferdinandantonio75@gmail.com',''),(5,'Dayao','Reuben','A.','09123456789','dayao@gmail.com',''),(6,'Grimes','Rick','L.','09123456789','grimes@gmail.com',''),(7,'Bertud','Mira','A','79797','bertud@yahoo.com',''),(8,'Smith','Daryl','Y','808098','smith@ymail.com',''),(9,'Ong','Glenn','O','8945453','ong@gmail.com',''),(10,'Antonio','Gregorio','M','913234','greg@gmail.com',''),(11,'Masigla','Eric','E','923244','eric@gmail.com',''),(12,'Cordova','Mae','L.','924243','mae@mymail.com',''),(13,'Salud','Lani','V','924113','lani@gmail.com',''),(14,'Tan','Lea','S','9355465','lea@ymail.com',''),(15,'Cruz','Elena','E','9312323','cruz@yahoo.com',''),(16,'Reyes','Roland','D','09231234567','reyes_roland@yahoo.com',''),(17,'Cagasab','Laura','L.','09251234567','lauracagasab@yahoo.com',''),(18,'Nagac','Nancy','W','09151234567','nancynagac@gmail.com',''),(19,'Retalia','Cecil','Y','09186547987','cecilretalia@gmail.com',''),(20,'Chuan','Cora','Q','09221234567','corachuan@gmail.com',''),(21,'Akot','Chinita','P','09191234567','chinitaakot@gmail.com',''),(22,'Amador','Pinky','P','09164536788','amadorpinky@gmail.com',''),(23,'Puerto','Ludy','H','09122234555','ludypuerto@gmail.com',''),(24,'Concepcion','Leonora','K','09271234568','leonoraconcepcion@yahoo.com','');
/*!40000 ALTER TABLE `faculty_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_schedule`
--

DROP TABLE IF EXISTS `faculty_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty_schedule` (
  `faculty_schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `faculty_id` int(11) NOT NULL,
  `schedule_id` int(11) NOT NULL,
  `date_assigned` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`faculty_schedule_id`),
  KEY `fk_faculty_scheduleTABLE_faculty_idCOL_idx` (`faculty_id`),
  KEY `fk_faculty_scheduleTABLE_schedule_idCOL_idx` (`schedule_id`),
  CONSTRAINT `fk_faculty_scheduleTABLE_faculty_idCOL` FOREIGN KEY (`faculty_id`) REFERENCES `faculty_mt` (`faculty_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_faculty_scheduleTABLE_schedule_idCOL` FOREIGN KEY (`schedule_id`) REFERENCES `schedule_mt` (`schedule_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_schedule`
--

LOCK TABLES `faculty_schedule` WRITE;
/*!40000 ALTER TABLE `faculty_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `faculty_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_specialization`
--

DROP TABLE IF EXISTS `faculty_specialization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty_specialization` (
  `faculty_specialization_id` int(11) NOT NULL AUTO_INCREMENT,
  `faculty_id` int(11) NOT NULL,
  `specialization_id` int(11) NOT NULL,
  `date_assigned` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `schoolyear_id` int(11) NOT NULL COMMENT 'schoolyear_id of when the specialization was assigned to faculty member',
  PRIMARY KEY (`faculty_specialization_id`),
  KEY `fk_faculty_specializationTABLE_faculty_idCOL_idx` (`faculty_id`),
  KEY `fk_faculty_specializationTABLE_specialization_idCOL_idx` (`specialization_id`),
  KEY `fk_faculty_specializationTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_faculty_specializationTABLE_faculty_idCOL` FOREIGN KEY (`faculty_id`) REFERENCES `faculty_mt` (`faculty_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_faculty_specializationTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_faculty_specializationTABLE_specialization_idCOL` FOREIGN KEY (`specialization_id`) REFERENCES `subjectcategory_mt` (`subjectcategory_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_specialization`
--

LOCK TABLES `faculty_specialization` WRITE;
/*!40000 ALTER TABLE `faculty_specialization` DISABLE KEYS */;
INSERT INTO `faculty_specialization` VALUES (15,4,41,'2018-02-12 16:09:16',432),(16,5,41,'2018-02-12 16:09:32',432),(17,6,41,'2018-02-12 16:09:45',432),(18,7,42,'2018-02-12 16:09:56',432),(19,8,42,'2018-02-12 16:10:44',432),(20,9,42,'2018-02-12 16:11:21',432),(21,10,40,'2018-02-12 16:11:30',432),(22,11,40,'2018-02-12 16:12:13',432),(23,12,40,'2018-02-12 16:12:24',432),(24,13,43,'2018-02-12 16:12:36',432),(26,15,43,'2018-02-12 16:12:56',432),(27,16,44,'2018-02-12 16:14:26',432),(28,22,44,'2018-02-12 16:14:37',432),(29,21,44,'2018-02-12 16:14:43',432),(30,17,44,'2018-02-12 16:14:54',432),(31,20,42,'2018-02-12 16:14:59',432),(32,14,43,'2018-02-12 21:56:05',432),(33,14,44,'2018-02-12 21:56:05',432);
/*!40000 ALTER TABLE `faculty_specialization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee_category_mt`
--

DROP TABLE IF EXISTS `fee_category_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee_category_mt` (
  `fee_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `fee_category` varchar(45) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`fee_category_id`),
  UNIQUE KEY `feetype_UNIQUE` (`fee_category`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='Master Table to store all types of categories such as (Basic Fee, Miscellaneous Fee, Downpayment Fee, Other Fee)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_category_mt`
--

LOCK TABLES `fee_category_mt` WRITE;
/*!40000 ALTER TABLE `fee_category_mt` DISABLE KEYS */;
INSERT INTO `fee_category_mt` VALUES (1,'Basic',''),(2,'Miscellaneous',''),(3,'Others',''),(4,'Downpayment','');
/*!40000 ALTER TABLE `fee_category_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee_mt`
--

DROP TABLE IF EXISTS `fee_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee_mt` (
  `fee_id` int(11) NOT NULL AUTO_INCREMENT,
  `fee_name` varchar(45) NOT NULL,
  `fee_description` text,
  `fee_category_id` int(11) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`fee_id`),
  KEY `fk_fee_mtTABLE_fee_category_idCOL_idx` (`fee_category_id`),
  CONSTRAINT `fk_fee_mtTABLE_fee_category_idCOL` FOREIGN KEY (`fee_category_id`) REFERENCES `fee_category_mt` (`fee_category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1 COMMENT='MASTER';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_mt`
--

LOCK TABLES `fee_mt` WRITE;
/*!40000 ALTER TABLE `fee_mt` DISABLE KEYS */;
INSERT INTO `fee_mt` VALUES (33,'Tablet Fee','Tablet Fee',2,''),(34,'Downpayment','Downpayment',4,''),(35,'Basic Fee','Basic Fee',1,''),(36,'Computer Fee','Computer Fee',2,''),(37,'Field Trip','Field Trip',3,''),(38,'Taekwondo','Taekwondo ',3,'');
/*!40000 ALTER TABLE `fee_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee_schoolyear_lt`
--

DROP TABLE IF EXISTS `fee_schoolyear_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee_schoolyear_lt` (
  `fee_id` int(11) NOT NULL,
  `fee_amount` decimal(10,2) NOT NULL,
  `gradelevel_id` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL COMMENT 'this column represents the schoolyearid of when this fee was created.',
  KEY `fk_fee_schoolyear_ltTABLE_fee_idCOL_idx` (`fee_id`),
  KEY `fk_fee_schoolyear_ltTABLE_gradelevel_idCOL_idx` (`gradelevel_id`),
  KEY `fk_fee_schoolyear_ltTABLE_year_createdCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_fee_schoolyear_ltTABLE_fee_idCOL` FOREIGN KEY (`fee_id`) REFERENCES `fee_mt` (`fee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fee_schoolyear_ltTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fee_schoolyear_ltTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contains the amounts of fees per gradelevel per schoolyear.\nAnswers the question "What were the fees during year X? for gradelevel Y?"';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_schoolyear_lt`
--

LOCK TABLES `fee_schoolyear_lt` WRITE;
/*!40000 ALTER TABLE `fee_schoolyear_lt` DISABLE KEYS */;
INSERT INTO `fee_schoolyear_lt` VALUES (34,1500.00,301,432),(34,1500.00,302,432),(34,1500.00,303,432),(34,1500.00,304,432),(34,1500.00,305,432),(34,1500.00,306,432),(34,1500.00,307,432),(34,1500.00,308,432),(34,1500.00,309,432),(34,1500.00,310,432),(34,1500.00,311,432),(35,8000.50,301,432),(35,8000.50,302,432),(35,8000.50,303,432),(35,8000.50,304,432),(35,8000.50,305,432),(35,8000.50,306,432),(35,8000.50,307,432),(35,8000.50,308,432),(35,8000.50,309,432),(35,8000.50,310,432),(35,8000.50,311,432),(33,623.64,301,432),(33,623.64,302,432),(33,623.64,303,432),(33,623.64,304,432),(33,623.64,305,432),(33,623.64,306,432),(33,623.64,307,432),(33,623.64,308,432),(33,623.64,309,432),(33,623.64,310,432),(33,623.64,311,432),(37,1250.65,301,432),(37,1250.65,302,432),(37,1250.65,303,432),(37,1250.65,304,432),(37,1250.65,305,432),(37,1250.65,306,432),(37,1250.65,307,432),(37,1250.65,308,432),(37,1250.65,309,432),(37,1250.65,310,432),(37,1250.65,311,432),(36,5000.00,301,432),(36,5000.00,302,432),(36,5000.00,303,432),(36,5000.00,304,432),(36,5000.00,305,432),(36,5000.00,306,432),(36,5000.00,307,432),(36,5000.00,308,432),(36,5000.00,309,432),(36,5000.00,310,432),(36,5000.00,311,432),(38,1500.00,301,432),(38,1500.00,302,432),(38,1500.00,303,432),(38,1500.00,304,432),(38,1500.00,305,432),(38,1500.00,306,432),(38,1500.00,307,432),(38,1500.00,308,432),(38,1500.00,309,432),(38,1500.00,310,432),(38,1500.00,311,432);
/*!40000 ALTER TABLE `fee_schoolyear_lt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade` (
  `grade_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `grading_period_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `subject_grade` decimal(10,2) DEFAULT NULL,
  `schoolyear_id` int(11) DEFAULT NULL,
  `grade_type` varchar(1) DEFAULT NULL COMMENT 'S - Summer Class Grade\nR - Regular Class Grade',
  `added_by_user_id` int(11) DEFAULT NULL,
  `date_added` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`grade_id`),
  KEY `fk_gradeTABLE_student_idCOL_idx` (`student_id`),
  KEY `fk_gradeTABLE_grading_period_icCOL_idx` (`grading_period_id`),
  KEY `fk_gradeTABLE_subject_idCOL_idx` (`subject_id`),
  KEY `fk_gradeTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_gradeTABLE_added_by_user_idCOL_idx` (`added_by_user_id`),
  CONSTRAINT `fk_gradeTABLE_added_by_user_idCOL` FOREIGN KEY (`added_by_user_id`) REFERENCES `user_mt` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_gradeTABLE_grading_period_idCOL` FOREIGN KEY (`grading_period_id`) REFERENCES `gradingperiod_mt` (`gradingperiod_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_gradeTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_gradeTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_gradeTABLE_subject_idCOL` FOREIGN KEY (`subject_id`) REFERENCES `subject_mt` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gradelevel_mt`
--

DROP TABLE IF EXISTS `gradelevel_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gradelevel_mt` (
  `gradelevel_id` int(11) NOT NULL AUTO_INCREMENT,
  `grade_level` int(11) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`gradelevel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=312 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gradelevel_mt`
--

LOCK TABLES `gradelevel_mt` WRITE;
/*!40000 ALTER TABLE `gradelevel_mt` DISABLE KEYS */;
INSERT INTO `gradelevel_mt` VALUES (301,0,''),(302,1,''),(303,2,''),(304,3,''),(305,4,''),(306,5,''),(307,6,''),(308,7,''),(309,8,''),(310,9,''),(311,10,'');
/*!40000 ALTER TABLE `gradelevel_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gradingperiod_mt`
--

DROP TABLE IF EXISTS `gradingperiod_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gradingperiod_mt` (
  `gradingperiod_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Contains grading period names such as :\n\n1st Grading Period\n2nd Grading Period\n3rd Grading Period\n4th Grading Period',
  `gradeperiod` int(11) NOT NULL,
  `description` varchar(45) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  `date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`gradingperiod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7004 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gradingperiod_mt`
--

LOCK TABLES `gradingperiod_mt` WRITE;
/*!40000 ALTER TABLE `gradingperiod_mt` DISABLE KEYS */;
INSERT INTO `gradingperiod_mt` VALUES (7000,1,'1st Period','','2017-07-19 21:09:13'),(7001,2,'2nd Period','','2017-07-19 21:09:14'),(7002,3,'3rd Period','','2017-07-19 21:09:16'),(7003,4,'4th Period','','2017-07-19 21:09:17');
/*!40000 ALTER TABLE `gradingperiod_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holiday_mt`
--

DROP TABLE IF EXISTS `holiday_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `holiday_mt` (
  `holiday_id` int(11) NOT NULL AUTO_INCREMENT,
  `holiday_name` varchar(45) NOT NULL,
  `description` text,
  `date_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`holiday_id`),
  UNIQUE KEY `holiday_name_UNIQUE` (`holiday_name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holiday_mt`
--

LOCK TABLES `holiday_mt` WRITE;
/*!40000 ALTER TABLE `holiday_mt` DISABLE KEYS */;
INSERT INTO `holiday_mt` VALUES (5,'Maundy Thursday','Maundy Thursday','2017-07-07 20:46:23','','2017-04-13','2017-04-13'),(6,'New Year\'s Day','New Year\'s Day','2017-07-07 20:48:01','','2017-01-01','2017-01-01'),(7,'Public Holiday','Public Holiday','2017-07-07 20:48:36','','2017-01-02','2017-01-02'),(8,'Chinese New Year','Chinese New Year','2017-07-07 20:49:21','','2017-01-28','2017-01-28'),(9,'People Power Revolution','People Power Revolution','2017-07-07 20:49:58','','2017-02-25','2017-02-25'),(10,'Labor Day','Labor Day','2017-07-07 20:50:37','','2017-05-01','2017-05-01'),(11,'National Heroes Day','National Heroes Day','2017-07-07 20:52:10','','2017-08-28','2017-08-28'),(12,'Eid Al Adha','Eid Al Adha','2017-07-07 20:53:31','','2017-09-01','2017-09-01');
/*!40000 ALTER TABLE `holiday_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `or_no_mt`
--

DROP TABLE IF EXISTS `or_no_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `or_no_mt` (
  `or_no_id` int(11) NOT NULL AUTO_INCREMENT,
  `or_no` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `is_used` bit(1) DEFAULT b'0',
  `date_generated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `generated_by_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`or_no_id`),
  UNIQUE KEY `or_no_UNIQUE` (`or_no`),
  KEY `fk_or_no_mtTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_or_no_mtTABLE_generated_by_user_idCOL_idx` (`generated_by_user_id`),
  CONSTRAINT `fk_or_no_mtTABLE_generated_by_user_idCOL` FOREIGN KEY (`generated_by_user_id`) REFERENCES `user_mt` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_or_no_mtTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `or_no_mt`
--

LOCK TABLES `or_no_mt` WRITE;
/*!40000 ALTER TABLE `or_no_mt` DISABLE KEYS */;
INSERT INTO `or_no_mt` VALUES (1,10001,432,'','2018-02-02 10:56:48',NULL),(2,10002,432,'','2018-02-02 10:56:50',NULL),(3,10003,432,'','2018-02-02 10:56:51',NULL),(4,10004,432,'','2018-02-02 10:56:52',NULL),(5,10005,432,'','2018-02-02 10:56:52',NULL),(6,10006,432,'','2018-02-02 10:56:53',NULL),(7,10007,432,'','2018-02-02 10:56:54',NULL),(8,10008,432,'','2018-02-02 10:56:55',NULL),(9,10009,432,'','2018-02-02 10:56:56',NULL),(10,100010,432,'','2018-02-02 10:59:33',NULL),(11,100011,432,'','2018-02-02 10:59:35',NULL),(12,100012,432,'','2018-02-02 10:59:36',NULL),(13,100013,432,'','2018-02-02 10:59:36',NULL),(14,100014,432,'\0','2018-02-02 10:59:37',NULL),(15,100015,432,'\0','2018-02-02 10:59:38',NULL),(16,100016,432,'\0','2018-02-02 10:59:39',NULL),(17,100017,432,'\0','2018-02-02 10:59:40',NULL),(18,100018,432,'\0','2018-02-02 10:59:41',NULL);
/*!40000 ALTER TABLE `or_no_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentterm_mt`
--

DROP TABLE IF EXISTS `paymentterm_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentterm_mt` (
  `paymentterm_id` int(11) NOT NULL AUTO_INCREMENT,
  `paymentterm_name` varchar(45) NOT NULL,
  `isPaymentTermActive` bit(1) NOT NULL DEFAULT b'1',
  `divisor` int(11) NOT NULL,
  PRIMARY KEY (`paymentterm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentterm_mt`
--

LOCK TABLES `paymentterm_mt` WRITE;
/*!40000 ALTER TABLE `paymentterm_mt` DISABLE KEYS */;
INSERT INTO `paymentterm_mt` VALUES (2,'Cash','',1),(3,'Quarterly','',4),(4,'Semestral','',2),(5,'Monthly','',10);
/*!40000 ALTER TABLE `paymentterm_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentterm_penalty`
--

DROP TABLE IF EXISTS `paymentterm_penalty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentterm_penalty` (
  `penalty_id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolyear_id` int(11) NOT NULL,
  `paymentterm_id` int(11) NOT NULL,
  `penalty_amount` decimal(10,2) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  `date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`penalty_id`),
  UNIQUE KEY `uk_paymentterm_penaltyTABLE` (`schoolyear_id`,`paymentterm_id`),
  KEY `fk_paymentterm_penaltyTABLE_paymentterm_idCOL_idx` (`paymentterm_id`),
  KEY `fk_paymentterm_penaltyTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_paymentterm_penaltyTABLE_paymentterm_idCOL` FOREIGN KEY (`paymentterm_id`) REFERENCES `paymentterm_mt` (`paymentterm_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_paymentterm_penaltyTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 COMMENT='Stores how much penalty fee is charged for late payments per schoolyear.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentterm_penalty`
--

LOCK TABLES `paymentterm_penalty` WRITE;
/*!40000 ALTER TABLE `paymentterm_penalty` DISABLE KEYS */;
INSERT INTO `paymentterm_penalty` VALUES (4,432,4,500.26,'','2018-01-26 14:03:56'),(5,432,3,512.39,'','2018-01-26 14:03:56'),(6,432,5,525.25,'','2018-01-26 14:03:56'),(7,432,2,500.50,'','2018-02-01 11:19:03');
/*!40000 ALTER TABLE `paymentterm_penalty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentterm_period`
--

DROP TABLE IF EXISTS `paymentterm_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentterm_period` (
  `paymentterm_period_id` int(11) NOT NULL AUTO_INCREMENT,
  `paymentterm_id` int(11) NOT NULL,
  `period_id` int(11) NOT NULL,
  `date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`paymentterm_period_id`),
  KEY `fk_paymentterm_divisionTABLE_paymentterm_idCOL_idx` (`paymentterm_id`),
  KEY `fk_paymentterm_divisionTABLE_division_idCOL_idx` (`period_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentterm_period`
--

LOCK TABLES `paymentterm_period` WRITE;
/*!40000 ALTER TABLE `paymentterm_period` DISABLE KEYS */;
INSERT INTO `paymentterm_period` VALUES (1,4,5,'2017-07-13 16:37:54'),(2,4,6,'2017-07-13 16:37:59'),(3,3,4,'2017-07-13 16:38:04'),(4,3,3,'2017-07-13 16:38:09'),(5,3,2,'2017-07-13 16:38:15'),(6,3,1,'2017-07-13 16:38:19'),(7,5,16,'2017-07-13 16:41:46'),(8,5,15,'2017-07-13 16:41:52'),(9,5,14,'2017-07-13 16:41:56'),(10,5,13,'2017-07-13 16:41:59'),(11,5,12,'2017-07-13 16:42:04'),(12,5,11,'2017-07-13 16:42:07'),(13,5,10,'2017-07-13 16:42:11'),(14,5,9,'2017-07-13 16:42:14'),(15,5,8,'2017-07-13 16:42:18'),(16,5,7,'2017-07-13 16:42:22'),(18,3,17,'2018-02-01 11:09:29'),(19,4,17,'2018-02-01 11:09:48'),(20,5,17,'2018-02-01 11:10:19'),(21,2,17,'2018-02-01 14:03:19');
/*!40000 ALTER TABLE `paymentterm_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentterm_period_paymentdeadline`
--

DROP TABLE IF EXISTS `paymentterm_period_paymentdeadline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentterm_period_paymentdeadline` (
  `paymentterm_period_paymentdeadline_id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolyear_id` int(11) NOT NULL,
  `paymentterm_id` int(11) NOT NULL,
  `period_id` int(11) NOT NULL,
  `paymentdeadline` date NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`paymentterm_period_paymentdeadline_id`),
  KEY `fk_payment_deadlineTABLE_paymentterm_idCOL_idx` (`paymentterm_id`),
  KEY `fk_payment_deadlineTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_payment_deadlineTABLE_period_idCOL_idx` (`period_id`),
  CONSTRAINT `fk_paymentterm_period_paymentdeadlineTABLE_paymentterm_idCOL` FOREIGN KEY (`paymentterm_id`) REFERENCES `paymentterm_mt` (`paymentterm_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_paymentterm_period_paymentdeadlineTABLE_period_idCOL` FOREIGN KEY (`period_id`) REFERENCES `period` (`period_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_paymentterm_period_paymentdeadlineTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentterm_period_paymentdeadline`
--

LOCK TABLES `paymentterm_period_paymentdeadline` WRITE;
/*!40000 ALTER TABLE `paymentterm_period_paymentdeadline` DISABLE KEYS */;
INSERT INTO `paymentterm_period_paymentdeadline` VALUES (1,432,4,6,'2018-01-02',''),(2,432,4,5,'2018-01-03',''),(3,432,3,4,'2018-01-10',''),(4,432,3,3,'2018-01-11',''),(5,432,3,2,'2018-01-12',''),(6,432,3,1,'2018-01-13',''),(7,432,5,7,'2018-01-15',''),(8,432,5,8,'2018-01-16',''),(9,432,5,9,'2018-01-17',''),(10,432,5,10,'2018-01-18',''),(11,432,5,11,'2018-01-19',''),(12,432,5,12,'2018-01-20',''),(13,432,5,13,'2018-01-21',''),(14,432,5,14,'2018-01-22',''),(15,432,5,15,'2018-01-23',''),(16,432,5,16,'2018-01-24',''),(17,432,2,17,'2018-01-01','');
/*!40000 ALTER TABLE `paymentterm_period_paymentdeadline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `period`
--

DROP TABLE IF EXISTS `period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `period` (
  `period_id` int(11) NOT NULL AUTO_INCREMENT,
  `period_code` varchar(10) NOT NULL,
  `period_name` varchar(255) NOT NULL,
  PRIMARY KEY (`period_id`),
  UNIQUE KEY `code_UNIQUE` (`period_code`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `period`
--

LOCK TABLES `period` WRITE;
/*!40000 ALTER TABLE `period` DISABLE KEYS */;
INSERT INTO `period` VALUES (1,'FOQTR','4th Quarter'),(2,'TQTR','3rd Quarter'),(3,'SQTR','2nd Quarter'),(4,'FIQTR','1st Quarter'),(5,'SSEM','2nd Semester'),(6,'FSEM','1st Semester'),(7,'FMO','1st Month'),(8,'SECMO','2nd Month'),(9,'THMO','3rd Month'),(10,'FOMO','4th Month'),(11,'FIMO','5th Month'),(12,'SIMO','6th Month'),(13,'SEVMO','7th Month'),(14,'EMO','8th Month'),(15,'NIMO','9th Month'),(16,'TEMO','10th Month'),(17,'DPAY','Downpayment');
/*!40000 ALTER TABLE `period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quarter_mt`
--

DROP TABLE IF EXISTS `quarter_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quarter_mt` (
  `quarter_id` int(11) NOT NULL AUTO_INCREMENT,
  `quarter_no` int(11) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  `description` text,
  `date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`quarter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quarter_mt`
--

LOCK TABLES `quarter_mt` WRITE;
/*!40000 ALTER TABLE `quarter_mt` DISABLE KEYS */;
INSERT INTO `quarter_mt` VALUES (29,1,'',NULL,'2017-07-07 22:56:30'),(30,2,'',NULL,'2017-07-07 22:56:31'),(31,3,'',NULL,'2017-07-07 22:56:31'),(32,4,'',NULL,'2017-07-07 22:56:31'),(33,1,'',NULL,'2017-07-08 09:48:00'),(34,2,'',NULL,'2017-07-08 09:48:00'),(35,3,'',NULL,'2017-07-08 09:48:00'),(36,4,'',NULL,'2017-07-08 09:48:00'),(37,1,'',NULL,'2017-07-08 09:57:05'),(38,2,'',NULL,'2017-07-08 09:57:05'),(39,3,'',NULL,'2017-07-08 09:57:06'),(40,4,'',NULL,'2017-07-08 09:57:06'),(41,1,'',NULL,'2017-07-08 10:30:33'),(42,2,'',NULL,'2017-07-08 10:30:34'),(43,3,'',NULL,'2017-07-08 10:30:34'),(44,4,'',NULL,'2017-07-08 10:30:34'),(45,1,'',NULL,'2017-07-08 10:36:19'),(46,2,'',NULL,'2017-07-08 10:36:19'),(47,3,'',NULL,'2017-07-08 10:36:19'),(48,4,'',NULL,'2017-07-08 10:36:19'),(49,1,'',NULL,'2017-08-12 10:40:55'),(50,2,'',NULL,'2017-08-12 10:40:55'),(51,3,'',NULL,'2017-08-12 10:40:56'),(52,4,'',NULL,'2017-08-12 10:40:56');
/*!40000 ALTER TABLE `quarter_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration_mt`
--

DROP TABLE IF EXISTS `registration_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registration_mt` (
  `registration_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_type` varchar(2) NOT NULL COMMENT 'N = New Student\nT = Transferee\n',
  `lastname` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `middlename` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `pob` varchar(45) NOT NULL,
  `nationality` varchar(45) NOT NULL,
  `religion` varchar(45) NOT NULL,
  `gender` bit(1) NOT NULL,
  `father_firstname` varchar(45) NOT NULL,
  `father_middlename` varchar(45) NOT NULL,
  `father_lastname` varchar(45) NOT NULL,
  `father_occupation` varchar(45) NOT NULL,
  `father_officephone_no` varchar(45) NOT NULL,
  `father_mobile_no` varchar(45) DEFAULT NULL,
  `isFatherContactInCaseEmergency` bit(1) NOT NULL DEFAULT b'0',
  `mother_firstname` varchar(45) NOT NULL,
  `mother_middlename` varchar(45) DEFAULT NULL,
  `mother_lastname` varchar(45) NOT NULL,
  `mother_occupation` varchar(45) NOT NULL,
  `mother_officephone_no` varchar(45) NOT NULL,
  `mother_mobile_no` varchar(45) DEFAULT NULL,
  `isMotherContactInCaseEmergency` bit(1) NOT NULL DEFAULT b'0',
  `guardian_lastname` varchar(45) DEFAULT NULL,
  `guardian_firstname` varchar(45) DEFAULT NULL,
  `guardian_middlename` varchar(45) DEFAULT NULL,
  `guardian_occupation` varchar(45) DEFAULT NULL,
  `guardian_mobile_no` varchar(45) DEFAULT NULL,
  `guardian_relation_to_student` varchar(45) DEFAULT NULL,
  `isGuardianContactInCaseEmergency` bit(1) DEFAULT b'0',
  `school_last_attended` varchar(45) DEFAULT NULL,
  `school_last_attended_address` varchar(100) DEFAULT NULL,
  `room_or_house_no` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `brgy_or_subd` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `region` varchar(45) DEFAULT NULL,
  `gradelevel_no` int(11) NOT NULL,
  `schoolyear_yearfrom` int(11) DEFAULT NULL,
  `date_registered` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`registration_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COMMENT='Master Table for registration of new students and transferees ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration_mt`
--

LOCK TABLES `registration_mt` WRITE;
/*!40000 ALTER TABLE `registration_mt` DISABLE KEYS */;
INSERT INTO `registration_mt` VALUES (7,'N','Test','Test','Test','2018-02-13','Test','Test','Test','','Test','Test','Test','Test','Test','Test','','Test','Test','Test','Test','Test','Test','','TestTest','Test','Test','Test','Test','Test','\0','Test','Test','Test','Test','Test','Test','Test',0,2018,'2018-02-07 10:04:30'),(8,'T','Ashton','Alvin','Nuggets','2018-02-21','Philippines','Catholic','','','Test','Test','Test','Test','Test','Test','\0','Test','Test','Test','Test','Test','Test','','Test','Test','Test','Test','Test','','','Test','Test','Test','Test','Test','Test','Test',7,2018,'2018-02-07 13:01:18'),(9,'N','Doe','John','D.','2017-05-14','Quezon City','Filipino','Catholic','','Sr. John','Sr. John','Doe','Dentist','9152626','09211234567','','','','','','9152626','','\0','','','','','','','\0','','','12','Jade','Capitol','Quezon City','',1,2018,'2018-02-12 22:00:39');
/*!40000 ALTER TABLE `registration_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(25) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Administrator',''),(2,'Cashier',''),(3,'Registrar',''),(4,'Faculty','');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_permission` (
  `role_permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `dashboardpermission_id` int(11) NOT NULL,
  `enrollmentpermission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_permission_id`),
  KEY `fk_role_permissionTABLE_role_idCOL_idx` (`role_id`),
  KEY `fk_role_permissionTABLE_dashboardpermission_idCOL_idx` (`dashboardpermission_id`),
  KEY `fk_role_permissionTABLE_enrollmentpermission_idCOL_idx` (`enrollmentpermission_id`),
  CONSTRAINT `fk_role_permissionTABLE_dashboardpermission_idCOL` FOREIGN KEY (`dashboardpermission_id`) REFERENCES `dashboardpermission` (`dashboardpermission_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_permissionTABLE_enrollmentpermission_idCOL` FOREIGN KEY (`enrollmentpermission_id`) REFERENCES `enrollmentpermission` (`enrollmentpermission_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_permissionTABLE_role_idCOL` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` VALUES (5,1,1,NULL),(6,2,2,NULL),(7,3,3,NULL),(8,4,4,NULL);
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_mt`
--

DROP TABLE IF EXISTS `room_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room_mt` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_name_or_num` varchar(45) NOT NULL,
  `bldg_name_or_num` varchar(45) NOT NULL,
  `capacity` int(11) NOT NULL,
  `status` bit(1) NOT NULL DEFAULT b'1',
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `notes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_mt`
--

LOCK TABLES `room_mt` WRITE;
/*!40000 ALTER TABLE `room_mt` DISABLE KEYS */;
INSERT INTO `room_mt` VALUES (67,'300','1',25,'','2018-02-12 15:54:26','Room 300'),(68,'301','1',25,'','2018-02-12 15:54:55','Room 301'),(69,'302','1',25,'','2018-02-12 15:55:45','Room 302'),(70,'303','1',25,'','2018-02-12 15:56:19','Room 303');
/*!40000 ALTER TABLE `room_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_mt`
--

DROP TABLE IF EXISTS `schedule_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_mt` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `schedule_day` varchar(2) NOT NULL COMMENT 'Values to contain are \n\nM, T, W, TH, F, S, SU ',
  `startTime` int(11) NOT NULL,
  `endTime` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `section_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `gradelevel_id` int(11) NOT NULL,
  `faculty_id` int(11) NOT NULL,
  `schedule_session` varchar(2) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`schedule_id`),
  KEY `class_schedule_TABLE_roomId_COL_idx` (`room_id`),
  KEY `fk_class_schedule_TABLE_subjectId_COLUMN_idx` (`subject_id`),
  KEY `fk_scheduleTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_scheduleTABLE_section_idCOL_idx` (`section_id`),
  KEY `fk_scheduleTABLE_gradelevel_idCOL_idx` (`gradelevel_id`),
  KEY `fk_scheduleTABLE_faculty_idCOL_idx` (`faculty_id`),
  CONSTRAINT `fk_scheduleTABLE_faculty_idCOL` FOREIGN KEY (`faculty_id`) REFERENCES `faculty_mt` (`faculty_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_scheduleTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_scheduleTABLE_room_idCOL` FOREIGN KEY (`room_id`) REFERENCES `room_mt` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_scheduleTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_scheduleTABLE_section_idCOL` FOREIGN KEY (`section_id`) REFERENCES `section_mt` (`section_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_scheduleTABLE_subject_idCOL` FOREIGN KEY (`subject_id`) REFERENCES `subject_mt` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_mt`
--

LOCK TABLES `schedule_mt` WRITE;
/*!40000 ALTER TABLE `schedule_mt` DISABLE KEYS */;
INSERT INTO `schedule_mt` VALUES (26,'M',1200,1300,432,664,100,67,301,14,'PM',''),(27,'M',1300,1400,432,668,100,67,301,11,'PM',''),(28,'M',1400,1500,432,679,100,67,301,21,'PM',''),(29,'M',1500,1600,432,690,100,67,301,20,'PM',''),(30,'T',1200,1300,432,664,100,67,301,13,'PM',''),(31,'T',1300,1400,432,668,100,67,301,12,'PM',''),(32,'T',1400,1500,432,679,100,67,301,16,'PM',''),(33,'T',1500,1600,432,690,100,67,301,9,'PM',''),(34,'W',1200,1300,432,664,100,67,301,14,'PM',''),(35,'W',1300,1400,432,668,100,67,301,11,'PM',''),(36,'W',1400,1500,432,679,100,67,301,21,'PM',''),(37,'W',1500,1600,432,690,100,67,301,20,'PM',''),(38,'TH',1200,1300,432,664,100,67,301,13,'PM',''),(39,'TH',1300,1400,432,668,100,67,301,12,'PM',''),(40,'TH',1400,1500,432,679,100,67,301,16,'PM',''),(41,'TH',1500,1600,432,690,100,67,301,9,'PM',''),(42,'F',1200,1300,432,664,100,67,301,14,'PM',''),(43,'F',1300,1400,432,668,100,67,301,11,'PM',''),(44,'F',1400,1500,432,679,100,67,301,21,'PM',''),(45,'F',1500,1600,432,690,100,67,301,20,'PM',''),(46,'M',700,800,432,665,102,67,302,14,'AM',''),(47,'M',800,900,432,669,102,67,302,11,'AM',''),(48,'M',900,1000,432,680,102,67,302,14,'AM',''),(49,'M',1000,1100,432,691,102,67,302,9,'AM',''),(50,'T',700,800,432,665,102,67,302,14,'AM',''),(51,'T',800,900,432,669,102,67,302,11,'AM',''),(52,'T',900,1000,432,680,102,67,302,14,'AM',''),(53,'T',1000,1100,432,691,102,67,302,9,'AM',''),(54,'W',700,800,432,665,102,67,302,14,'AM',''),(55,'W',800,900,432,669,102,67,302,11,'AM',''),(56,'W',900,1000,432,680,102,67,302,14,'AM',''),(57,'W',1000,1100,432,691,102,67,302,9,'AM',''),(58,'TH',700,800,432,665,102,67,302,14,'AM',''),(59,'TH',800,900,432,669,102,67,302,11,'AM',''),(60,'TH',900,1000,432,680,102,67,302,14,'AM',''),(61,'TH',1000,1100,432,691,102,67,302,9,'AM',''),(62,'F',700,800,432,665,102,67,302,14,'AM',''),(63,'F',800,900,432,669,102,67,302,11,'AM',''),(64,'F',900,1000,432,680,102,67,302,14,'AM',''),(65,'F',1000,1100,432,691,102,67,302,9,'AM','');
/*!40000 ALTER TABLE `schedule_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolyear_mt`
--

DROP TABLE IF EXISTS `schoolyear_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolyear_mt` (
  `schoolyear_id` int(11) NOT NULL AUTO_INCREMENT,
  `yearFrom` int(11) NOT NULL,
  `yearTo` int(11) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `reg_enroll_start_date` date NOT NULL,
  `reg_enroll_end_date` date NOT NULL,
  `summer_enroll_start_date` date NOT NULL,
  `summer_enroll_end_date` date NOT NULL,
  `summer_class_start_date` date NOT NULL,
  `summer_class_end_date` date NOT NULL,
  `isCurrentSchoolYear` bit(1) DEFAULT b'0',
  PRIMARY KEY (`schoolyear_id`),
  UNIQUE KEY `yearFrom_UNIQUE` (`yearFrom`),
  UNIQUE KEY `yearTo_UNIQUE` (`yearTo`)
) ENGINE=InnoDB AUTO_INCREMENT=434 DEFAULT CHARSET=latin1 COMMENT='School Year Master Table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolyear_mt`
--

LOCK TABLES `schoolyear_mt` WRITE;
/*!40000 ALTER TABLE `schoolyear_mt` DISABLE KEYS */;
INSERT INTO `schoolyear_mt` VALUES (432,2018,2019,'','2018-01-01','2018-12-31','2018-01-01','2018-01-31','2018-03-01','2018-04-30','2019-05-01','2019-06-30',''),(433,2019,2020,'\0','2019-01-01','2019-12-31','2019-01-01','2019-01-31','2019-03-01','2019-04-30','2018-05-01','2018-06-30','\0');
/*!40000 ALTER TABLE `schoolyear_mt` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `yearEndCheck_before_insert` BEFORE INSERT ON `schoolyear_mt` FOR EACH ROW BEGIN
IF(NEW.yearTo != NEW.yearFrom + 1) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid Year End';

END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `schoolyear_quarter_lt`
--

DROP TABLE IF EXISTS `schoolyear_quarter_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolyear_quarter_lt` (
  `schoolyear_id` int(11) NOT NULL,
  `quarter_no` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `grading_due_date` date NOT NULL,
  `isCurrentQuarter` bit(1) NOT NULL DEFAULT b'0',
  KEY `fk_schoolyear_quarter_ltTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_schoolyear_quarter_ltTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolyear_quarter_lt`
--

LOCK TABLES `schoolyear_quarter_lt` WRITE;
/*!40000 ALTER TABLE `schoolyear_quarter_lt` DISABLE KEYS */;
INSERT INTO `schoolyear_quarter_lt` VALUES (432,1,'2018-01-01','2018-03-31','2018-03-15','\0'),(432,2,'2018-04-01','2018-06-30','2018-06-15','\0'),(432,3,'2018-07-01','2018-09-30','2018-09-15','\0'),(432,4,'2018-10-01','2018-12-30','2018-12-15','\0'),(433,1,'2019-01-01','2019-03-31','2019-03-15','\0'),(433,2,'2019-04-01','2019-06-30','2019-06-15','\0'),(433,3,'2019-07-01','2019-09-30','2019-09-15','\0'),(433,4,'2019-10-01','2019-12-30','2019-12-15','\0');
/*!40000 ALTER TABLE `schoolyear_quarter_lt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolyear_section_lt`
--

DROP TABLE IF EXISTS `schoolyear_section_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolyear_section_lt` (
  `schoolyear_section_id` int(11) NOT NULL AUTO_INCREMENT,
  `section_id` int(11) NOT NULL,
  `session_id` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `gradelevel_id` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  PRIMARY KEY (`schoolyear_section_id`),
  UNIQUE KEY `uc_schoolyear_sectionTABLE_section_id_schoolyear_id_session_id` (`section_id`,`session_id`,`schoolyear_id`),
  KEY `fk_schoolyear_sectionTABLE_section_idCOL_idx` (`section_id`),
  KEY `fk_schoolyear_sectionTABLE_session_idCOL_idx` (`session_id`),
  KEY `fk_schoolyear_sectionTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_schoolyear_sectionTABLE_gradelevel_idCOL_idx` (`gradelevel_id`),
  CONSTRAINT `fk_schoolyear_sectionTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schoolyear_sectionTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schoolyear_sectionTABLE_section_idCOL` FOREIGN KEY (`section_id`) REFERENCES `section_mt` (`section_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schoolyear_sectionTABLE_session_idCOL` FOREIGN KEY (`session_id`) REFERENCES `session_mt` (`session_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolyear_section_lt`
--

LOCK TABLES `schoolyear_section_lt` WRITE;
/*!40000 ALTER TABLE `schoolyear_section_lt` DISABLE KEYS */;
/*!40000 ALTER TABLE `schoolyear_section_lt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolyear_student_lt`
--

DROP TABLE IF EXISTS `schoolyear_student_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolyear_student_lt` (
  `schoolyear_student_lt_id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolyear_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `gradelevel_id` int(11) NOT NULL,
  `section_id` int(11) DEFAULT NULL COMMENT 'Answers the question: "What was the student''s section during schoolyear X for gradelevel Y',
  `passed` bit(1) DEFAULT NULL COMMENT 'Answers the question: Did the student passed grade X during schoolyear Y?',
  `isActiveGradeLevelAndSchoolYear` bit(1) NOT NULL DEFAULT b'1' COMMENT 'used to check or mark if record is on-going or active for schoolyear',
  PRIMARY KEY (`schoolyear_student_lt_id`),
  UNIQUE KEY `uk_schoolyear_IdCOL_student_idCOL_gradelevel_idCOL` (`schoolyear_id`,`student_id`,`gradelevel_id`),
  KEY `fk_schoolyear_student_ltTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_schoolyear_student_ltTABLE_student_idCOL_idx` (`student_id`),
  KEY `fk_schoolyear_student_ltTABLE_gradelevel_idCOL_idx` (`gradelevel_id`),
  KEY `fk_schoolyear_student_ltTABLE_section_idCOL_idx` (`section_id`),
  CONSTRAINT `fk_schoolyear_student_ltTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schoolyear_student_ltTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schoolyear_student_ltTABLE_section_idCOL` FOREIGN KEY (`section_id`) REFERENCES `section_mt` (`section_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schoolyear_student_ltTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolyear_student_lt`
--

LOCK TABLES `schoolyear_student_lt` WRITE;
/*!40000 ALTER TABLE `schoolyear_student_lt` DISABLE KEYS */;
INSERT INTO `schoolyear_student_lt` VALUES (7,432,19,301,NULL,NULL,''),(8,432,20,308,NULL,NULL,''),(9,432,21,302,NULL,NULL,'');
/*!40000 ALTER TABLE `schoolyear_student_lt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section_mt`
--

DROP TABLE IF EXISTS `section_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section_mt` (
  `section_id` int(11) NOT NULL AUTO_INCREMENT,
  `sectionName` varchar(45) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  `date_created` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`section_id`),
  UNIQUE KEY `sectionName_UNIQUE` (`sectionName`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=latin1 COMMENT='Master table for storing all sections only. Students sections information will be put on a different table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_mt`
--

LOCK TABLES `section_mt` WRITE;
/*!40000 ALTER TABLE `section_mt` DISABLE KEYS */;
INSERT INTO `section_mt` VALUES (100,'Mercury','','2018-02-04 15:37:21'),(102,'Santan','','2018-02-04 19:04:09'),(105,'Jupiter','','2018-02-04 19:37:55'),(107,'Earth','','2018-02-05 08:46:36'),(108,'Saturn','','2018-02-08 15:33:40'),(109,'Mars','','2018-02-08 16:22:27'),(110,'Pluto','','2018-02-08 16:22:59'),(111,'Daisy','','2018-02-09 21:22:23'),(112,'Viola','','2018-02-10 10:54:11'),(113,'Carnation','','2018-02-12 16:19:36'),(114,'Hyacinth','','2018-02-12 16:42:02'),(115,'Citrine','','2018-02-12 21:02:24');
/*!40000 ALTER TABLE `section_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section_settings_lt`
--

DROP TABLE IF EXISTS `section_settings_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section_settings_lt` (
  `section_settings_lt_id` int(11) NOT NULL AUTO_INCREMENT,
  `section_id` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `gradelevel_id` int(11) NOT NULL,
  `adviser_id` int(11) DEFAULT NULL,
  `session` varchar(2) NOT NULL COMMENT 'faculty_id COL represents the faculty member assigned as ADVISER for a section',
  `capacity` int(11) NOT NULL,
  PRIMARY KEY (`section_settings_lt_id`),
  KEY `fk_section_settings_ltTABLE_section_idCOL_idx` (`section_id`),
  KEY `fk_section_settings_ltTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_section_settings_ltTABLE_gradelevel_idCOL_idx` (`gradelevel_id`),
  KEY `fk_section_settings_ltTABLE_adviser_idCOL_idx` (`adviser_id`),
  CONSTRAINT `fk_section_settings_ltTABLE_adviser_idCOL` FOREIGN KEY (`adviser_id`) REFERENCES `faculty_mt` (`faculty_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_settings_ltTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_settings_ltTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_settings_ltTABLE_section_idCOL` FOREIGN KEY (`section_id`) REFERENCES `section_mt` (`section_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_settings_lt`
--

LOCK TABLES `section_settings_lt` WRITE;
/*!40000 ALTER TABLE `section_settings_lt` DISABLE KEYS */;
INSERT INTO `section_settings_lt` VALUES (2,100,432,301,4,'PM',25),(3,102,432,302,7,'AM',25),(6,105,432,301,9,'PM',25),(8,107,432,301,8,'PM',25),(9,108,432,301,6,'AM',25),(10,109,432,301,5,'AM',25),(11,110,432,301,5,'AM',25),(12,111,432,302,15,'WD',25),(13,112,432,302,4,'WD',25),(14,113,432,302,22,'WD',25),(15,114,432,302,19,'WD',25),(16,115,432,308,14,'WD',25);
/*!40000 ALTER TABLE `section_settings_lt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section_student`
--

DROP TABLE IF EXISTS `section_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section_student` (
  `section_student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `section_id` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  `sectionedby_user_id` int(11) DEFAULT NULL,
  `date_sectioned` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`section_student_id`),
  KEY `fk_students_sectionTABLE_section_idCOL_idx` (`section_id`),
  KEY `fk_students_sectionTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_section_studentTABLE_sectionedby_user_idCOL_idx` (`sectionedby_user_id`),
  KEY `fk_section_studentTABLE_student_idCOL_idx` (`student_id`),
  CONSTRAINT `fk_section_studentTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_studentTABLE_section_idCOL` FOREIGN KEY (`section_id`) REFERENCES `section_mt` (`section_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_studentTABLE_sectionedby_user_idCOL` FOREIGN KEY (`sectionedby_user_id`) REFERENCES `user_mt` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_studentTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_student`
--

LOCK TABLES `section_student` WRITE;
/*!40000 ALTER TABLE `section_student` DISABLE KEYS */;
INSERT INTO `section_student` VALUES (1,19,100,432,'',NULL,'2018-02-12 16:27:50'),(2,20,115,432,'',NULL,'2018-02-12 21:29:08'),(3,21,102,432,'',NULL,'2018-02-12 22:02:53');
/*!40000 ALTER TABLE `section_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session_mt`
--

DROP TABLE IF EXISTS `session_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `session_mt` (
  `session_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL COMMENT 'Session title of WD means Whole Day',
  `start_time` int(11) DEFAULT NULL,
  `end_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session_mt`
--

LOCK TABLES `session_mt` WRITE;
/*!40000 ALTER TABLE `session_mt` DISABLE KEYS */;
INSERT INTO `session_mt` VALUES (1,'AM',NULL,NULL),(2,'PM',NULL,NULL),(3,'WD',NULL,NULL);
/*!40000 ALTER TABLE `session_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_address_lt`
--

DROP TABLE IF EXISTS `student_address_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_address_lt` (
  `students_address_id` int(10) NOT NULL AUTO_INCREMENT,
  `student_id` int(10) NOT NULL,
  `room_houseNo` int(10) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `brgy_or_subd` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`students_address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Students Address Child Table of Students ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_address_lt`
--

LOCK TABLES `student_address_lt` WRITE;
/*!40000 ALTER TABLE `student_address_lt` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_address_lt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_discount_lt`
--

DROP TABLE IF EXISTS `student_discount_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_discount_lt` (
  `student_id` int(11) NOT NULL,
  `discount_id` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `date_applied` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` decimal(10,2) NOT NULL,
  KEY `fk_student_discount_ltTABLE_student_idCOL_idx` (`student_id`),
  KEY `fk_student_discount_ltTABLE_discount_idCOL_idx` (`discount_id`),
  KEY `fk_student_discount_ltTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_student_discount_ltTABLE_discount_idCOL` FOREIGN KEY (`discount_id`) REFERENCES `discount_mt` (`discount_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_discount_ltTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_discount_ltTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_discount_lt`
--

LOCK TABLES `student_discount_lt` WRITE;
/*!40000 ALTER TABLE `student_discount_lt` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_discount_lt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_fee`
--

DROP TABLE IF EXISTS `student_fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_fee` (
  `student_fee_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL COMMENT 'Table to store assigned fees to students',
  `fee_id` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL COMMENT 'This column will be used to retrieve record of  student fees by SCHOOL YR',
  `date_assigned` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isActive` bit(1) DEFAULT b'0' COMMENT 'isActive status is set to 1 after payment of student for either cash/downpayment',
  PRIMARY KEY (`student_fee_id`),
  KEY `fk_student_feeTABLE_student_id_idx` (`student_id`),
  KEY `fk_student_feeTABLE_fee_idCOL_idx` (`fee_id`),
  KEY `fk_student_feeTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_student_feeTABLE_fee_idCOL` FOREIGN KEY (`fee_id`) REFERENCES `fee_mt` (`fee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_feeTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_feeTABLE_student_id` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_fee`
--

LOCK TABLES `student_fee` WRITE;
/*!40000 ALTER TABLE `student_fee` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_mt`
--

DROP TABLE IF EXISTS `student_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_mt` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `admission_id` int(11) NOT NULL COMMENT 'registration_id is a foreign key referencing to registration_mt table',
  `student_no` varchar(45) NOT NULL,
  `student_type` varchar(1) NOT NULL,
  `entry_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isGraduated` bit(1) NOT NULL DEFAULT b'0' COMMENT 'isGraduate column gets updated with 1 when student graduates',
  `date_graduated` datetime DEFAULT NULL,
  `isActive` bit(1) DEFAULT b'0' COMMENT 'isActive column resets to 0 EVERY after 1 schoolyear.\nThe date depends on the EXACT start date of schoolyear.\n\nAll enrolled students will have isActive status of 1 which mean ENROLLED',
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `student_no_UNIQUE` (`student_no`),
  KEY `fk_student_mtTABLE_admission_idCOL_idx` (`admission_id`),
  CONSTRAINT `fk_student_mtTABLE_admission_idCOL` FOREIGN KEY (`admission_id`) REFERENCES `admission_mt` (`admission_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1 COMMENT='Students Master Table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_mt`
--

LOCK TABLES `student_mt` WRITE;
/*!40000 ALTER TABLE `student_mt` DISABLE KEYS */;
INSERT INTO `student_mt` VALUES (19,21,'20180021','N','2018-02-07 10:04:46','\0',NULL,''),(20,22,'20180022','T','2018-02-12 20:52:55','\0',NULL,''),(21,23,'20180023','N','2018-02-12 22:01:02','\0',NULL,'');
/*!40000 ALTER TABLE `student_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_promotion`
--

DROP TABLE IF EXISTS `student_promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_promotion` (
  `student_promotion_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `gradelevel_id_from` int(11) NOT NULL,
  `gradelevel_id_to` int(11) NOT NULL,
  `date_of_promotion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`student_promotion_id`),
  KEY `fk_student_promotionTABLE_student_idCOL_idx` (`student_id`),
  KEY `fk_student_promotionTABLE_gradelevel_id_fromCOL_idx` (`gradelevel_id_from`),
  KEY `fk_student_promotionTABLE_gradelevel_id_toCOL_idx` (`gradelevel_id_to`),
  CONSTRAINT `fk_student_promotionTABLE_gradelevel_id_fromCOL` FOREIGN KEY (`gradelevel_id_from`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_promotionTABLE_gradelevel_id_toCOL` FOREIGN KEY (`gradelevel_id_to`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_promotionTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_promotion`
--

LOCK TABLES `student_promotion` WRITE;
/*!40000 ALTER TABLE `student_promotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_summer`
--

DROP TABLE IF EXISTS `student_summer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_summer` (
  `student_summer_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`student_summer_id`),
  KEY `fk_student_summerTABLE_student_idCOL_idx` (`student_id`),
  KEY `fk_student_summerTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_student_summerTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_summerTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_summer`
--

LOCK TABLES `student_summer` WRITE;
/*!40000 ALTER TABLE `student_summer` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_summer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_gradelevel_lt`
--

DROP TABLE IF EXISTS `subject_gradelevel_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_gradelevel_lt` (
  `subject_id` int(10) NOT NULL,
  `gradelevel_id` int(10) NOT NULL,
  `year_created_schoolyear_id` int(11) NOT NULL,
  KEY `fk_subjects_gradelevel_dtTable_subjectId_idx` (`subject_id`),
  KEY `fk_subjects_gradelevel_Table_gradeLevelId_idx` (`gradelevel_id`),
  KEY `fk_subject_gradelevelTABLE_year_create_schoolyear_idCOL_idx` (`year_created_schoolyear_id`),
  CONSTRAINT `fk_subject_gradelevelTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_subject_gradelevelTABLE_subject_idCOL` FOREIGN KEY (`subject_id`) REFERENCES `subject_mt` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_subject_gradelevelTABLE_year_create_schoolyear_idCOL` FOREIGN KEY (`year_created_schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_gradelevel_lt`
--

LOCK TABLES `subject_gradelevel_lt` WRITE;
/*!40000 ALTER TABLE `subject_gradelevel_lt` DISABLE KEYS */;
INSERT INTO `subject_gradelevel_lt` VALUES (664,301,432),(665,302,432),(666,303,432),(667,304,432),(668,301,432),(669,302,432),(670,303,432),(671,304,432),(672,305,432),(673,305,432),(674,307,432),(675,308,432),(676,309,432),(677,310,432),(678,311,432),(679,301,432),(680,302,432),(681,303,432),(682,304,432),(683,305,432),(684,306,432),(685,307,432),(686,308,432),(687,309,432),(688,310,432),(689,311,432),(690,301,432),(691,302,432),(692,303,432),(693,304,432),(694,305,432),(695,306,432),(696,307,432),(697,308,432),(698,309,432),(699,310,432),(700,311,432),(701,304,432),(702,305,432),(703,306,432),(704,307,432),(705,308,432),(706,309,432),(707,310,432),(708,311,432);
/*!40000 ALTER TABLE `subject_gradelevel_lt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_mt`
--

DROP TABLE IF EXISTS `subject_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_mt` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`subject_id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=709 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_mt`
--

LOCK TABLES `subject_mt` WRITE;
/*!40000 ALTER TABLE `subject_mt` DISABLE KEYS */;
INSERT INTO `subject_mt` VALUES (664,'K-MTHTNG','Mother Tongue','Mother Tongue','','2018-02-12 15:06:22'),(665,'G1-MTHTNG','Mother Tongue','Monther Tongue','','2018-02-12 15:07:27'),(666,'G2-MTHTNG','Mother Tongue','Mother Tongue','','2018-02-12 15:08:00'),(667,'G3-MTHTNG','Mother Tongue','Mother Tongue','','2018-02-12 15:08:32'),(668,'K-FIL','Filipino','Filipino','','2018-02-12 15:10:11'),(669,'G1-FIL','Filipino','Filipino','','2018-02-12 15:10:54'),(670,'G2-FIL','Filipino','Filipino','','2018-02-12 15:11:39'),(671,'G3-FIL','Filipino','Filipino','','2018-02-12 15:12:07'),(672,'G4-FIL','Filipino','Filipino','','2018-02-12 15:12:45'),(673,'G5-FIL','Filipino','Filipino','','2018-02-12 15:13:17'),(674,'G6-FIL','Filipino','Filipino','','2018-02-12 15:13:56'),(675,'G7-FIL','Filipino','Filipino','','2018-02-12 15:14:23'),(676,'G8-FIL','Filipino','Filipino','','2018-02-12 15:15:05'),(677,'G9-FIL','Filipino','Filipino','','2018-02-12 15:15:37'),(678,'G10-FIL','Filipino','Filipino','','2018-02-12 15:16:24'),(679,'K-ENG','English','English','','2018-02-12 15:18:39'),(680,'G1-ENG','English','English','','2018-02-12 15:21:04'),(681,'G2-ENG','English','English','','2018-02-12 15:21:29'),(682,'G3-ENG','English','English','','2018-02-12 15:23:39'),(683,'G4-ENG','English','English','','2018-02-12 15:24:11'),(684,'G5-ENG','English','English','','2018-02-12 15:26:58'),(685,'G6-ENG','English','English','','2018-02-12 15:28:23'),(686,'G7-ENG','English','English','','2018-02-12 15:29:07'),(687,'G8-ENG','English','English','','2018-02-12 15:30:19'),(688,'G9-ENG','English','English','','2018-02-12 15:30:44'),(689,'G10-ENG','English','English','','2018-02-12 15:31:20'),(690,'K-MATH','Mathematics','Mathematics','','2018-02-12 15:34:04'),(691,'G1-MATH','Mathematics','Mathematics','','2018-02-12 15:34:26'),(692,'G2-MATH','Mathematics','Mathematics','','2018-02-12 15:34:53'),(693,'G3-MATH','Mathematics','Mathematics','','2018-02-12 15:35:38'),(694,'G4-MATH','Mathematics','Mathematics','','2018-02-12 15:36:07'),(695,'G5-MATH','Mathematics','Mathematics','','2018-02-12 15:36:38'),(696,'G6-MATH','Mathematics','Mathematics','','2018-02-12 15:37:01'),(697,'G7-MATH','Mathematics','Mathematics','','2018-02-12 15:37:30'),(698,'G8-MATH','Mathematics','Mathematics','','2018-02-12 15:37:47'),(699,'G9-MATH','Mathematics','Mathematics','','2018-02-12 15:38:10'),(700,'G10-MATH','Mathematics','Mathematics','','2018-02-12 15:38:31'),(701,'G3-SCI','Science','Science','','2018-02-12 15:41:39'),(702,'G4-SCI','Science','Science','','2018-02-12 15:42:03'),(703,'G5-SCI','Science','Science','','2018-02-12 15:42:19'),(704,'G6-SCI','Science','Science','','2018-02-12 15:42:35'),(705,'G7-SCI','Science','Science','','2018-02-12 15:42:52'),(706,'G8-SCI','Science','Science','','2018-02-12 15:43:06'),(707,'G9-SCI','Science','Science','','2018-02-12 15:43:25'),(708,'G10-SCI','Science','Science','','2018-02-12 15:48:34');
/*!40000 ALTER TABLE `subject_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjectcategory_mt`
--

DROP TABLE IF EXISTS `subjectcategory_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjectcategory_mt` (
  `subjectcategory_id` int(11) NOT NULL AUTO_INCREMENT,
  `subjectcategory_name` varchar(45) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  `description` text NOT NULL,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`subjectcategory_id`),
  UNIQUE KEY `specialization_title_UNIQUE` (`subjectcategory_name`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjectcategory_mt`
--

LOCK TABLES `subjectcategory_mt` WRITE;
/*!40000 ALTER TABLE `subjectcategory_mt` DISABLE KEYS */;
INSERT INTO `subjectcategory_mt` VALUES (40,'Filipino','','Filipino','2018-02-12 15:46:27'),(41,'Science','','Science ','2018-02-12 15:48:02'),(42,'Mathematics','','Mathematics','2018-02-12 15:50:42'),(43,'Mother Tongue','','Mother Tongue','2018-02-12 15:52:40'),(44,'English','','English','2018-02-12 16:14:10');
/*!40000 ALTER TABLE `subjectcategory_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjectcategory_subject`
--

DROP TABLE IF EXISTS `subjectcategory_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjectcategory_subject` (
  `subjectcategory_subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `subjectcategory_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `date_assigned` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`subjectcategory_subject_id`),
  KEY `fk_specialization_subjectTABLE_specialization_idCOL_idx` (`subjectcategory_id`),
  KEY `fk_specialization_subjectTABLE_subject_idCOL_idx` (`subject_id`),
  CONSTRAINT `fk_subjectcategory_subjectTABLE_subject_idCOL` FOREIGN KEY (`subject_id`) REFERENCES `subject_mt` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_subjectcategory_subjectTABLE_subjectcategory_idCOL` FOREIGN KEY (`subjectcategory_id`) REFERENCES `subjectcategory_mt` (`subjectcategory_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjectcategory_subject`
--

LOCK TABLES `subjectcategory_subject` WRITE;
/*!40000 ALTER TABLE `subjectcategory_subject` DISABLE KEYS */;
INSERT INTO `subjectcategory_subject` VALUES (34,42,690,'2018-02-12 15:50:42'),(35,42,691,'2018-02-12 15:50:42'),(36,42,692,'2018-02-12 15:50:42'),(37,42,693,'2018-02-12 15:50:42'),(38,42,694,'2018-02-12 15:50:42'),(39,42,695,'2018-02-12 15:50:42'),(40,42,696,'2018-02-12 15:50:42'),(41,42,697,'2018-02-12 15:50:42'),(42,42,698,'2018-02-12 15:50:42'),(43,42,699,'2018-02-12 15:50:42'),(44,42,700,'2018-02-12 15:50:42'),(45,43,664,'2018-02-12 15:52:40'),(46,43,665,'2018-02-12 15:52:40'),(47,43,666,'2018-02-12 15:52:40'),(48,43,667,'2018-02-12 15:52:40'),(49,44,679,'2018-02-12 16:14:10'),(50,44,680,'2018-02-12 16:14:10'),(51,44,681,'2018-02-12 16:14:10'),(52,44,682,'2018-02-12 16:14:10'),(53,44,683,'2018-02-12 16:14:10'),(54,44,684,'2018-02-12 16:14:10'),(55,44,685,'2018-02-12 16:14:10'),(56,44,686,'2018-02-12 16:14:10'),(57,44,687,'2018-02-12 16:14:10'),(58,44,688,'2018-02-12 16:14:10'),(59,44,689,'2018-02-12 16:14:10'),(60,40,668,'2018-02-12 17:01:28'),(61,40,669,'2018-02-12 17:01:29'),(62,40,670,'2018-02-12 17:01:29'),(63,40,671,'2018-02-12 17:01:29'),(64,40,672,'2018-02-12 17:01:29'),(65,40,673,'2018-02-12 17:01:29'),(66,40,674,'2018-02-12 17:01:29'),(67,40,675,'2018-02-12 17:01:29'),(68,40,676,'2018-02-12 17:01:29'),(69,40,677,'2018-02-12 17:01:29'),(70,40,678,'2018-02-12 17:01:29'),(71,41,701,'2018-02-12 17:01:40'),(72,41,702,'2018-02-12 17:01:40'),(73,41,703,'2018-02-12 17:01:40'),(74,41,704,'2018-02-12 17:01:40'),(75,41,705,'2018-02-12 17:01:40'),(76,41,706,'2018-02-12 17:01:40'),(77,41,707,'2018-02-12 17:01:40'),(78,41,708,'2018-02-12 17:01:40');
/*!40000 ALTER TABLE `subjectcategory_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_balancebreakdown`
--

DROP TABLE IF EXISTS `transaction_balancebreakdown`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_balancebreakdown` (
  `transaction_balancebreakdown_id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_id` int(11) NOT NULL,
  `balancebreakdown_id` int(11) NOT NULL,
  `amount_paid` decimal(10,2) NOT NULL,
  PRIMARY KEY (`transaction_balancebreakdown_id`),
  KEY `fk_transaction_balancebreakdownTABLE_transaction_idCOL_idx` (`transaction_id`),
  KEY `fk_transaction_balancebreakdownTABLE_balancebreakdown_idCOL_idx` (`balancebreakdown_id`),
  CONSTRAINT `fk_transaction_balancebreakdownTABLE_balancebreakdown_idCOL` FOREIGN KEY (`balancebreakdown_id`) REFERENCES `balancebreakdown` (`balancebreakdown_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_balancebreakdownTABLE_transaction_idCOL` FOREIGN KEY (`transaction_id`) REFERENCES `transaction_mt` (`transaction_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_balancebreakdown`
--

LOCK TABLES `transaction_balancebreakdown` WRITE;
/*!40000 ALTER TABLE `transaction_balancebreakdown` DISABLE KEYS */;
INSERT INTO `transaction_balancebreakdown` VALUES (25,31,136,1000.00),(26,32,136,500.00),(27,33,141,1500.00),(28,34,146,1250.00);
/*!40000 ALTER TABLE `transaction_balancebreakdown` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_mt`
--

DROP TABLE IF EXISTS `transaction_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_mt` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `amount_received` decimal(10,2) NOT NULL,
  `amount_charged` decimal(10,2) NOT NULL,
  `or_no_attached` int(11) NOT NULL,
  `date_charged` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`transaction_id`),
  KEY `fk_transaction_mtTABLE_student_idCOL_idx` (`student_id`),
  CONSTRAINT `fk_transaction_mtTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_mt`
--

LOCK TABLES `transaction_mt` WRITE;
/*!40000 ALTER TABLE `transaction_mt` DISABLE KEYS */;
INSERT INTO `transaction_mt` VALUES (31,19,1300.00,1000.00,100010,'2018-02-07 12:33:33'),(32,19,500.00,500.00,100011,'2018-02-07 12:34:24'),(33,20,1500.00,1500.00,100012,'2018-02-12 20:55:12'),(34,21,1250.00,1250.00,100013,'2018-02-12 22:01:39');
/*!40000 ALTER TABLE `transaction_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_faculty`
--

DROP TABLE IF EXISTS `user_faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_faculty` (
  `user_faculty_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `faculty_id` int(11) NOT NULL,
  `date_created` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_faculty_id`),
  KEY `user_facultyTABLE_user_idCOL_idx` (`user_id`),
  KEY `user_facultyTABLE_faculty_idCOL_idx` (`faculty_id`),
  CONSTRAINT `user_facultyTABLE_faculty_idCOL` FOREIGN KEY (`faculty_id`) REFERENCES `faculty_mt` (`faculty_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_facultyTABLE_user_idCOL` FOREIGN KEY (`user_id`) REFERENCES `user_mt` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_faculty`
--

LOCK TABLES `user_faculty` WRITE;
/*!40000 ALTER TABLE `user_faculty` DISABLE KEYS */;
INSERT INTO `user_faculty` VALUES (1,51,4,'2018-02-12 20:35:42'),(2,52,14,'2018-02-12 20:52:06');
/*!40000 ALTER TABLE `user_faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_mt`
--

DROP TABLE IF EXISTS `user_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_mt` (
  `user_id` int(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `isActive` smallint(1) NOT NULL DEFAULT '1',
  `isLocked` smallint(1) NOT NULL DEFAULT '0',
  `lastname` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `middlename` varchar(255) NOT NULL,
  `lastLoginDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `addedBy` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uc_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1 COMMENT='Users Master Table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_mt`
--

LOCK TABLES `user_mt` WRITE;
/*!40000 ALTER TABLE `user_mt` DISABLE KEYS */;
INSERT INTO `user_mt` VALUES (46,'admin','admin',1,0,'Default','Admin','Login','2018-02-13 10:20:38','2017-08-19 10:13:26','DB Administrator'),(48,'registrar','registrar',1,0,'Registrar','Registrar','Registrar','2018-01-25 11:14:26','2018-01-23 16:16:37',''),(51,'jordan','jordan123',1,0,'Antonio','John Ferdinand','Maala','2018-02-13 09:46:51','2018-02-12 20:35:42',''),(52,'leatan','faculty123',1,0,'Tan','Lea','S','2018-02-12 20:52:06','2018-02-12 20:52:06','');
/*!40000 ALTER TABLE `user_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `fk_user_roleTABLE_user_idCOL_idx` (`user_id`),
  KEY `fk_user_roleTABLE_role_idCOL_idx` (`role_id`),
  CONSTRAINT `fk_user_roleTABLE_role_idCOL` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_roleTABLE_user_idCOL` FOREIGN KEY (`user_id`) REFERENCES `user_mt` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (39,46,1),(41,48,3),(44,51,4),(45,52,4);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'enrollmentdb'
--
/*!50106 SET @save_time_zone= @@TIME_ZONE */ ;
/*!50106 DROP EVENT IF EXISTS `e_setAllStudentsInactive` */;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8 */ ;;
/*!50003 SET character_set_results = utf8 */ ;;
/*!50003 SET collation_connection  = utf8_general_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`root`@`localhost`*/ /*!50106 EVENT `e_setAllStudentsInactive` ON SCHEDULE EVERY 1 SECOND STARTS '2017-02-27 09:53:26' ON COMPLETION NOT PRESERVE ENABLE DO CALL setAllStudentsInactive */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `e_setCurrentSchoolYear` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8 */ ;;
/*!50003 SET character_set_results = utf8 */ ;;
/*!50003 SET collation_connection  = utf8_general_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`root`@`localhost`*/ /*!50106 EVENT `e_setCurrentSchoolYear` ON SCHEDULE EVERY 1 SECOND STARTS '2017-02-17 18:55:28' ON COMPLETION NOT PRESERVE ENABLE DO CALL setCurrentSchoolYear() */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
DELIMITER ;
/*!50106 SET TIME_ZONE= @save_time_zone */ ;

--
-- Dumping routines for database 'enrollmentdb'
--
/*!50003 DROP PROCEDURE IF EXISTS ` getAllSchoolYearInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE ` getAllSchoolYearInfo`()
BEGIN
	SELECT * FROM schoolyear_mt;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `activateStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `activateStudent`(studentId INT)
BEGIN

UPDATE student_mt SET isActive = 1 
WHERE student_id = studentId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addAdmission` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addAdmission`(registrationId INT,
gradeLevelId INT,
schoolyearId INT,
OUT admissionId INT
)
BEGIN

INSERT INTO admission_mt(registration_id,gradelevel_id,schoolyear_id)
VALUES(registrationId,gradeLevelId, schoolYearId);
SELECT LAST_INSERT_ID() INTO admissionId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addBalanceBreakDownFee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addBalanceBreakDownFee`(
balancebreakdownFeeName VARCHAR(255),
balancebreakdownFeeAmount DECIMAL(10,2),
balancebreakdownFeeDueDate DATE,
balancebreakdownFeeCategory VARCHAR(255),
studentId INT,
paymentTermId INT,
schoolyearId INT,
OUT balancebreakdownFeeId INT
)
BEGIN

INSERT INTO balancebreakdown(balancebreakdown_name, balancebreakdown_amount, due_date, category,student_id,paymentterm_id,schoolyear_id)
VALUES(balancebreakdownFeeName,balancebreakdownFeeAmount,balancebreakdownFeeDueDate,balancebreakdownFeeCategory,studentId,paymentTermId,schoolyearId);
SELECT LAST_INSERT_ID() INTO balancebreakdownFeeId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addCredential` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addCredential`(aCredentialName VARCHAR(255),aCredentialDescription VARCHAR(255),OUT aCredentialId INT)
BEGIN

INSERT INTO credentials_mt(credential_name,credential_description)
VALUES(aCredentialName,aCredentialDescription);

SELECT LAST_INSERT_ID() INTO aCredentialId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addCurriculum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addCurriculum`(
	schoolYearId INT,
    curriculumTitle VARCHAR(255),
    description VARCHAR(255),
    OUT curriculumId INT
)
BEGIN
	INSERT INTO curriculum_mt(schoolyear_id, curriculum_title, description)
	VALUES(schoolYearId, curriculumTitle, description);
    SELECT LAST_INSERT_ID() INTO curriculumId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addCurriculumSubjects` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addCurriculumSubjects`( 
curriculumId INT,
subjectId INT,
subjectHours DECIMAL
)
BEGIN
	
    INSERT INTO curriculum_subject_lt(curriculum_id, subject_id, subject_hours)
    VALUES(curriculumId, subjectId, subjectHours);
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addDiscount` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addDiscount`(aDiscountName VARCHAR(255), aDiscountPercentage INT,
aDescription TEXT)
BEGIN

DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
        RESIGNAL;
    END;
    
    START TRANSACTION;
		INSERT INTO discount_mt (discount_name, percentage, description)
		VALUES(aDiscountName, aDiscountPercentage, aDescription);
	COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addEnrollment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addEnrollment`(schoolYearId INT, studentId INT, enrollmentType VARCHAR(1), OUT enrollmentId INT)
BEGIN

INSERT INTO enrollment(schoolyear_id, student_id,enrollment_type)
VALUES(schoolYearId, studentId, enrollmentType);

SELECT LAST_INSERT_ID() INTO enrollmentId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addFaculty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addFaculty`(
IN p_firstName varchar(45),
    IN p_lastName varchar(45),
    IN p_middleName varchar(45),
    IN p_email varchar (45),
    IN p_contact varchar(45)
)
BEGIN

	INSERT INTO faculty_mt (firstName,lastName,middleName,email,contactNo)
    VALUES(p_firstName,p_lastName,p_middleName,p_email,p_contact);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addFacultyAndSpecialization` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addFacultyAndSpecialization`(IN p_faculty_id INT,
IN p_specialization_id INT, 
IN p_schoolyear_id INT
)
BEGIN

	INSERT INTO faculty_specialization(faculty_id,specialization_id,schoolyear_id)
    VALUES(p_faculty_id,p_specialization_id,p_schoolyear_id);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addFacultyAsUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addFacultyAsUser`(
aUserId INT, aFacultyId INT
)
BEGIN

INSERT INTO user_faculty(user_id,faculty_id)
VALUES(aUserId, aFacultyId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addFee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addFee`(
IN aFeeName VARCHAR(255), 
IN aFeeDescription VARCHAR(255),
IN aFeeCategoryId INT,
OUT aFeeId INT)
BEGIN
    INSERT INTO fee_mt(fee_name, fee_description, fee_category_id)
    VALUES(aFeeName, aFeeDescription, aFeeCategoryId);
    
    SELECT LAST_INSERT_ID() INTO aFeeId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addGradeLevel`(IN aGradeLevel VARCHAR(255))
BEGIN
	DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
        RESIGNAL;
    END;
    
    START TRANSACTION;
		INSERT INTO gradelevel_mt(grade_level)
		VALUES(aGradeLevel);
	COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addHoliday` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addHoliday`(aHolidayName VARCHAR(255), aDescription TEXT, aStartDate DATE, aEndDate DATE)
BEGIN

INSERT INTO holiday_mt(holiday_name, description,start_date,end_date)
VALUES(aHolidayName, aDescription,aStartDate, aEndDate);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addPaymentTermPenalty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addPaymentTermPenalty`(aSchoolYearId INT, aPaymentTermId INT, aPenaltyAmount DECIMAL(10,2))
BEGIN

INSERT INTO paymentterm_penalty(schoolyear_id, paymentterm_id, penalty_amount)
VALUES(aSchoolYearId, aPaymentTermId, aPenaltyAmount);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addPaymentTermPeriodPaymentDeadline` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addPaymentTermPeriodPaymentDeadline`(
aSchoolYearId INT, aPaymentTermId INT, aPeriodId INT, aDeadline DATE)
BEGIN

INSERT INTO paymentterm_period_paymentdeadline(schoolyear_id, paymentterm_id, period_id, paymentdeadline)
VALUES(aSchoolYearId, aPaymentTermId, aPeriodId, aDeadline);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addPenalty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addPenalty`(aPaymentTermId INT, aSchoolYearId INT, alateFeeAmount decimal(10,2))
BEGIN

INSERT INTO penalty(paymentterm_id, schoolyear_id, late_fee)
VALUES(aPaymentTermId, aSchoolYearId, aLateFeeAmount);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addQuarter` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addQuarter`(
aQuarterNo INT, 
aDescription TEXT,
aStartDate DATE, 
aEndDate DATE, 
aSchoolYearId INT
)
BEGIN
	DECLARE aQuarterId INT;

	DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
		RESIGNAL;
    END;
    
    START TRANSACTION;
    
    INSERT INTO quarter_mt(quarter_no, description)
    VALUES(aQuarterNo, aDescription);
    
    SELECT LAST_INSERT_ID() INTO aQuarterId;
    
    INSERT INTO schoolyear_quarter_lt
    (schoolyear_id, quarter_id, start_date, end_date)
    VALUES(aSchoolYearId, aQuarterId, aStartDate, aEndDate);
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addRegistration` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addRegistration`(
aStudentType VARCHAR(255),
aStudentLastName VARCHAR(255),
aStudentFirstName VARCHAR(255),
aStudentMiddleName VARCHAR(255),
aDOB DATE,
aPOB VARCHAR(255),
aNationality VARCHAR(255),
aReligion VARCHAR(255),
aGender INT,
aFatherFirstName VARCHAR(255),
aFatherMiddleName VARCHAR(255),
aFatherLastName VARCHAR(255),
aFatherOccupation VARCHAR(255),
aFatherOfficePhoneNo VARCHAR(255),
aFatherMobileNo VARCHAR(255),
aIsFatherContactInCaseEmergency BIT(1),
aMotherFirstName VARCHAR(255),
aMotherMiddleName VARCHAR(255),
aMotherLastName VARCHAR(255),
aMotherOccupation VARCHAR(255),
aMotherOfficePhoneNo VARCHAR(255),
aMotherMobileNo VARCHAR(255),
aIsMotherContactInCaseEmergency BIT(1),
aGuardianLastName VARCHAR(255),
aGuardianFirstName VARCHAR(255),
aGuardianMiddleName VARCHAR(255),
aGuardianOccupation VARCHAR(255),
aGuardianMobileNo VARCHAR(255),
aGuardianRelationToStudent VARCHAR(255),
aIsGuardianContactInCaseEmergency BIT(1),
aSchoolLastAttended VARCHAR(255),
aSchoolLastAttendedAddress VARCHAR(255),
aRoomOrHouseNo VARCHAR(255),
aStreet VARCHAR(255),
aBrgyOrSubd VARCHAR(255),
aCity VARCHAR(255),
aRegion VARCHAR(255),
aGradeLevelNo INT,
aSchoolYearYearFrom INT
)
BEGIN

INSERT INTO registration_mt(
student_type, 
lastname, 
firstname, 
middlename, 
dob, 
pob, 
nationality, 
religion, 
gender, 
father_firstname, father_middlename, father_lastname, 
father_occupation, father_officephone_no, father_mobile_no, isFatherContactInCaseEmergency, 
mother_firstname, mother_middlename, mother_lastname,mother_occupation, mother_officephone_no, mother_mobile_no, 
isMotherContactInCaseEmergency, guardian_lastname, guardian_firstname, guardian_middlename, 
guardian_occupation,guardian_mobile_no, guardian_relation_to_student, 
isGuardianContactInCaseEmergency, school_last_attended, school_last_attended_address, 
room_or_house_no, street, brgy_or_subd, city, region,
gradelevel_no,schoolyear_yearfrom 
)

VALUES(
aStudentType,
aStudentLastName,
aStudentFirstName,
aStudentMiddleName,
aDOB,
aPOB,
aNationality,
aReligion,
aGender,
aFatherFirstName,
aFatherMiddleName,
aFatherLastName,
aFatherOccupation,
aFatherOfficePhoneNo,
aFatherMobileNo,
aIsFatherContactInCaseEmergency,
aMotherFirstName,
aMotherMiddleName,
aMotherLastName,
aMotherOccupation,
aMotherOfficePhoneNo,
aMotherMobileNo,
aIsMotherContactInCaseEmergency,
aGuardianLastName,
aGuardianFirstName,
aGuardianMiddleName,
aGuardianOccupation,
aGuardianMobileNo,
aGuardianRelationToStudent,
aIsGuardianContactInCaseEmergency,
aSchoolLastAttended,aSchoolLastAttendedAddress,
aRoomOrHouseNo,
aStreet,
aBrgyOrSubd,
aCity,
aRegion,
aGradeLevelNo,
aSchoolYearYearFrom
);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addRoom` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addRoom`(
	p_roomName VARCHAR(45),
    p_buildingName Varchar(45),
    p_capacity Varchar(45),
    p_description TEXT
)
BEGIN

	INSERT INTO room_mt (room_name_or_num,bldg_name_or_num,capacity,notes)
    VALUES (p_roomName,p_buildingName,p_capacity,p_description);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSchedule` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSchedule`(
aDay VARCHAR(2), 
aStartTime INT, 
aEndTime INT,
aSchoolYearId INT, 
aSubjectId INT, 
aSectionId INT,
aRoomId INT,
aGradeLevelId INT,
aFacultyId INT,
aSession VARCHAR(2),
OUT aScheduleId INT)
BEGIN
INSERT INTO schedule_mt (
schedule_day, startTime, endTime, schoolyear_id, subject_id, section_id, room_id,gradelevel_id,faculty_id,schedule_session)
VALUES(
aDay,aStartTime,aEndtime,aSchoolYearId, aSubjectId, aSectionId, aRoomId, aGradeLevelId, aFacultyId, aSession);

SELECT LAST_INSERT_ID() INTO aScheduleId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addScheduleToFaculty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addScheduleToFaculty`(aFacultyId INT,aScheduleId INT)
BEGIN
INSERT INTO faculty_schedule(faculty_id, schedule_id)
VALUES(aFacultyId, aScheduleId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSchoolYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSchoolYear`(
aYearFrom INT, 
aYearTo INT, 
schoolYearStartDate DATE,
schoolYearEndDate DATE,
regEnrollStartDate DATE,
regEnrollEndDate DATE,
summerEnrollStartDate DATE,
summerEnrollEndDate DATE,
summerClassStartDate DATE,
summerClassEndDate DATE,
OUT schoolYearId INT)
BEGIN

INSERT INTO schoolyear_mt
(yearFrom, yearTo, start_date, end_date, reg_enroll_start_date, reg_enroll_end_date,
summer_enroll_start_date, summer_enroll_end_date, summer_class_start_date, summer_class_end_date)
VALUES
(aYearFrom, aYearTo, schoolYearStartDate, schoolYearEndDate, 
regEnrollStartDate, regEnrollEndDate, summerEnrollStartDate, summerEnrollEndDate, summerClassStartDate, summerClassEndDate);

SELECT LAST_INSERT_ID() INTO schoolYearId;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSchoolYearQuarterSchedule` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSchoolYearQuarterSchedule`(
schoolYearId INT,
quarterNo INT,
startDate DATE,
endDate DATE,
gradingDueDate DATE
)
BEGIN

INSERT INTO schoolyear_quarter_lt
(schoolyear_id,quarter_no,start_date,end_date,grading_due_date)
VALUES
(schoolYearId,quarterNo, startDate, endDate, gradingDueDate);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSchoolYearStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSchoolYearStudent`(schoolyearId INT, studentId INT, gradeLevelId INT)
BEGIN

INSERT INTO schoolyear_student_lt(schoolyear_id, student_id, gradelevel_id)
VALUES(schoolyearId, studentId, gradeLevelId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSection` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSection`(aSectionName VARCHAR(255), OUT aSectionId INT)
BEGIN

INSERT INTO section_mt(sectionName)
VALUES(aSectionName);

SELECT LAST_INSERT_ID() INTO aSectionId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSectionDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSectionDetails`(aSectionId INT, aSessionId INT, aSchoolYearId INT, aGradeLevelId INT, aCapacity INT)
BEGIN

INSERT INTO schoolyear_section_lt
(section_id, session_id, schoolyear_id, gradelevel_id, capacity)
VALUES(aSectionId,aSessionId,aSchoolYearId,aGradeLevelId,aCapacity);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSectionSetting` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSectionSetting`(
aSectionId INT,
aSchoolYearId INT,
aGradeLevelId INT,
aSession VARCHAR(2),
aFacultyId INT,
aCapacity INT
)
BEGIN

INSERT INTO section_settings_lt(
section_id, schoolyear_id, gradelevel_id,`session`,adviser_id,capacity)
VALUES(aSectionId, aSchoolYearId, aGradeLevelId,aSession,aFacultyId,aCapacity);


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSemester` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSemester`(
aSemesterNo INT, 
aDescription TEXT,
aStartDate DATE, 
aEndDate DATE, 
aSchoolYearId INT
)
BEGIN
	DECLARE aSemesterId INT;

	DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
		RESIGNAL;
    END;
    
    START TRANSACTION;
    
    INSERT INTO semester_mt(semester_no, description)
    VALUES(aSemesterNo, aDescription);
    
    SELECT LAST_INSERT_ID() INTO aSemesterId;
    
    INSERT INTO schoolyear_semester_lt
    (schoolyear_id, semester_id, start_date, end_date)
    VALUES(aSchoolYearId, aSemesterId, aStartDate, aEndDate);
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSession` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSession`(aSession VARCHAR(2))
BEGIN
 INSERT INTO `session`(title)
 VALUES(aSession);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSpecialization` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSpecialization`(
    IN	p_title varchar(45),
    IN	p_desciption text
)
BEGIN
	INSERT into specialization(specialization_title,description)
    VALUES(p_title,p_desciption);
 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSpecializationSubject` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSpecializationSubject`(pSpecializationId INT, pSubjectId INT)
BEGIN

INSERT INTO specialization_subject(specialization_id, subject_id)
VALUES(pSpecializationId, pSubjectId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSpecializationToFaculty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSpecializationToFaculty`(

    IN	p_specialization_title varchar(45),

    OUT aSpecializationID INT

    
   
)
BEGIN
	INSERT into specialization(specialization_title)
    VALUES(p_specialization_title);
	SELECT LAST_INSERT_ID()INTO aSpecializationID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addStudent`(
admissionId INT,
studentType VARCHAR(1),
OUT studentId INT
)
BEGIN

INSERT INTO student_mt(admission_id,student_no,student_type)
VALUES(
admissionId, 
CONCAT(YEAR(curdate()) * 10000 + admissionId), 
studentType);

SELECT LAST_INSERT_ID() INTO studentId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addStudentDiscount` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addStudentDiscount`(IN aStudentId INT, IN aDiscountId INT, IN aSchoolYearId INT, IN anAmount DECIMAL(10,2) )
BEGIN

INSERT INTO student_discount_lt(student_id, discount_id, schoolyear_id, amount)
VALUES(aStudentId,aDiscountId,aSchoolYearId, anAmount);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addStudentPaymentTerm` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addStudentPaymentTerm`(IN aStudentId INT, IN aPaymentTermId INT,IN aSchoolYearId INT)
BEGIN

INSERT INTO student_paymentterm_lt(student_id, paymentterm_id, schoolyear_id)
VALUES(aStudentId,aPaymentTermId,aSchoolYearId);


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addStudentToSection` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addStudentToSection`(aStudentId INT, aSectionId INT, aSchoolYearId INT)
BEGIN

INSERT INTO section_student (student_id, section_id, schoolyear_id)
VALUES(aStudentId, aSectionId, aSchoolYearId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSubject` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSubject`(
IN p_subjName varchar(50), 
IN p_subjCode varchar(50), 
IN p_subjUnits INT, 
IN p_subjDesc TEXT, 
IN p_gradeLevelId INT,
IN p_schoolYearId INT,
IN p_addedBy_UserId varchar(50)

)
BEGIN
	
    DECLARE var_subjectId INT;
    DECLARE EXIT HANDLER FOR sqlexception
	BEGIN
		ROLLBACK;
        RESIGNAL;
    END;
    
    START TRANSACTION;
    
    INSERT INTO subjects(`code`, `name`, units, description)
    VALUES(p_subjCode,p_subjName,p_subjUnits,p_subjDesc);
    
    SELECT LAST_INSERT_ID() INTO @var_subjectId;
    
    INSERT INTO subjects_gradelevel(subjectId, gradeLevelId, schoolYearId)
    VALUES(@var_subjectId,p_gradeLevelId,p_schoolYearId);
    
    INSERT INTO subjects_hd(subjectId, addedBy_UserId, editedBy_UserId)
    VALUES(@var_subjectId,p_addedBy_UserId,p_addedBy_UserId);
    
		COMMIT ;
        SELECT 'successfully added subject';
    
    
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSubjectCategory` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSubjectCategory`(
subjectCtgyName VARCHAR(255), 
subjectCtgyDescription VARCHAR(255),
OUT subjectCtgyId INT
)
BEGIN

INSERT INTO subjectcategory_mt(subjectcategory_name,description)
VALUES(subjectCtgyName,subjectCtgyDescription);

SELECT LAST_INSERT_ID() INTO subjectCtgyId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSubjectCategoryAssignedSubjects` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSubjectCategoryAssignedSubjects`(
aSubjectCategoryId INT, aSubjectId INT
)
BEGIN

INSERT INTO subjectcategory_subject(subjectcategory_id, subject_id)
VALUES(aSubjectCategoryId, aSubjectId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addTransaction` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addTransaction`(
studentId INT,
amountReceived DECIMAL(10,2),
amountCharged DECIMAL(10,2),
orNo INT,
OUT transactionId INT
)
BEGIN

INSERT INTO 
transaction_mt (student_id,amount_received,amount_charged,or_no_attached)
VALUES (studentId,amountReceived,amountCharged,orNo);

SELECT LAST_INSERT_ID() INTO transactionId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addTransactionBalanceBreakdown` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addTransactionBalanceBreakdown`(
transactionId INT,
balancebreakdownId INT,
amountPaid DECIMAL(10,2)
)
BEGIN

INSERT INTO 
transaction_balancebreakdown(transaction_id,balancebreakdown_id,amount_paid)
VALUES(transactionId, balancebreakdownId, amountPaid);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addTransferee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addTransferee`(aStudentId INT)
BEGIN

INSERT INTO transferee_student(student_id)
VALUES(aStudentId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addTransfereeGrade` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addTransfereeGrade`(

aStudentId INT, 
aFirstQuarterGrade DECIMAL(10,2),
aSecondQuarterGrade DECIMAL(10,2),
aThirdQuarterGrade DECIMAL(10,2),
aFourthQuarterGrade DECIMAL(10,2),
aGwaGrade DECIMAL(10,2))
BEGIN

INSERT INTO transferee_grade(student_id, firstquarter_grade, secondquarter_grade, thirdquarter_grade, fourthquarter_grade, gwa)
VALUES(aStudentId,aFirstQuarterGrade,aSecondQuarterGrade,aThirdQuarterGrade,aFourthQuarterGrade,aGwaGrade);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addUser`(aUserName VARCHAR(20), 
aPassword VARCHAR(255),
aLastName VARCHAR(255),
aFirstName VARCHAR(255),
aMiddleName VARCHAR(255),
OUT aUserId INT )
BEGIN

INSERT INTO user_mt(username, `password`, lastname, firstname, middlename) 
VALUES(aUserName,aPassword,aLastName,aFirstName,aMiddleName);

SELECT LAST_INSERT_ID() INTO aUserId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addUserFaculty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addUserFaculty`(IN pUserId INT, IN pFacultyId INT)
BEGIN

INSERT INTO user_faculty(user_id, faculty_id)
VALUES(pUserId,pFacultyId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addUserRole` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addUserRole`(aUserId INT, aRoleId INT)
BEGIN

INSERT INTO user_role(user_id, role_id)
VALUES(aUserId, aRoleId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `assignCredential` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `assignCredential`(aCredentialId INT, aGradeLevelId INT, aSchoolYearId INT)
BEGIN

INSERT INTO credential_requirements_lt
(credential_id, gradelevel_id, schoolyear_id)
VALUES
(aCredentialId,aGradeLevelId,aSchoolYearId);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `assignFee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `assignFee`(
IN aFeeId INT, 
IN aFeeAmount DECIMAL,
IN aGradeLevelId INT,
IN aSchoolYearId INT)
BEGIN
    INSERT INTO fee_schoolyear_lt(fee_id, fee_amount, gradelevel_id, schoolyear_id)
    VALUES(aFeeId,aFeeAmount,aGradeLevelId,aSchoolYearId);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `assignFeesToStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `assignFeesToStudent`(aStudentId INT, aFeeId INT, aSchoolYearId INT)
BEGIN

INSERT INTO student_fee(student_id, fee_id,schoolyear_id)
VALUES(aStudentId, aFeeId, aSchoolYearId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `assignFeeToGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `assignFeeToGradeLevel`(
IN aFeeId INT, 
IN aFeeAmount DECIMAL(10,2),
IN aGradeLevelId INT,
IN aSchoolYearId INT)
BEGIN
    INSERT INTO fee_schoolyear_lt(fee_id, fee_amount, gradelevel_id, schoolyear_id)
    VALUES(aFeeId,aFeeAmount,aGradeLevelId,aSchoolYearId);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `assignScheduleToFaculty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `assignScheduleToFaculty`(aFacultyId INT, aScheduleId INT)
BEGIN

INSERT INTO faculty_schedule(faculty_id, schedule_id)
VALUES(aFacultyId, aScheduleId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkCurriculumChanges` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkCurriculumChanges`(IN pIN_curriculumId INT)
BEGIN
	
    SELECT gradelevel_mt.grade_level, 
		schoolyear_mt.yearFrom, schoolyear_mt.yearTo,
        curriculum_mt.curriculum_title, curriculum_mt.description,
        subject_mt.code, subject_mt.title
			FROM curriculum_subject_lt
            
            INNER JOIN curriculum_mt ON curriculum_mt.curriculum_id = curriculum_subject_lt.curriculum_id
            INNER JOIN subject_mt ON subject_mt.subject_id = curriculum_subject_lt.subject_id
            INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = curriculum_mt.gradelevel_id
            INNER JOIN schoolyear_mt ON schoolyear_mt.schoolyear_id = curriculum_mt.schoolyear_id
		
        WHERE curriculum_mt.curriculum_id = pIN_curriculumId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkCurriculumExists` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkCurriculumExists`(
	IN pIN_schoolyearId INT, IN pIN_curriculumTitle VARCHAR(250)
)
BEGIN
	SELECT  schoolyear_id, curriculum_title FROM curriculum_mt
    WHERE schoolyear_id = pIN_schoolyearId
    AND curriculum_title = pIN_curriculumTitle;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkCurriculumSubjectExists` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkCurriculumSubjectExists`(IN pIN_curriculumId INT)
BEGIN
	
    SELECT subject_id FROM curriculum_subject_lt WHERE curriculum_id = pIN_curriculumId;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkFacultyExist` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkFacultyExist`(
IN pIN_lastName VARCHAR(150), IN pIN_firstName VARCHAR(150), IN pIN_middleName VARCHAR(150), OUT pOUT_result VARCHAR(10)
)
BEGIN

IF EXISTS(SELECT lastName, firstName, middleName FROM faculty_mt WHERE lastName = pIN_lastName AND firstName = pIN_firstName
	AND middleName = pIN_middleName) THEN
		SET pOUT_result = "Duplicate";
		SELECT pOUT_result;
	ELSE
		SET pOUT_result = "GAGO";
		SELECT pOUT_result;
	END IF;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkSubjectChanges` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkSubjectChanges`(IN pIN_subjectId INT)
BEGIN
	
    SELECT subject_mt.code, subject_mt.title, subject_mt.description, 
		gradelevel_mt.grade_level FROM subject_gradelevel_lt
        
		INNER JOIN subject_mt ON subject_mt.subject_id = subject_gradelevel_lt.subject_id
		INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = subject_gradelevel_lt.gradelevel_id
        
        WHERE subject_mt.subject_id = pIN_subjectId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkSubjectExists` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkSubjectExists`(IN pIN_subjectCode VARCHAR(150))
BEGIN
	
    SELECT code FROM subject_mt WHERE code = pIN_subjectCode;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `completeAdmission` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `completeAdmission`( IN aRegistrationId INT)
BEGIN

START TRANSACTION;

UPDATE admission_mt 
SET isComplete = 1 
WHERE registration_id = aRegistrationId;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `countFacultySpecialization` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `countFacultySpecialization`(
IN pIN_facultyId INT, OUT pOUT_count INT
)
BEGIN

SELECT COUNT(*) INTO pOUT_count FROM faculty_specialization WHERE faculty_id = pIN_facultyId;
SELECT pOUT_count;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `countStudentGradeByGradingId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `countStudentGradeByGradingId`(IN pIN_gradingPeriodId INT)
BEGIN
	
    SELECT COUNT(*) FROM grade
	WHERE gradingperiod_id = pIN_gradingPeriodId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `createCurriculumSubjects` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `createCurriculumSubjects`(
	IN pIN_curriculumId INT,
    IN pIN_subjectId INT,
    IN pIN_subjectHours DOUBLE,
    IN pIN_gradeLevelId INT
)
BEGIN
	
    DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
    BEGIN
		ROLLBACK;
			SELECT "Failed creating Curriculum with Subjects";
        RESIGNAL;
    END;
		
    START TRANSACTION;    
        
	INSERT INTO curriculum_subject_lt(curriculum_id, subject_id, subject_hours, gradelevel_id)
	VALUES(pIN_curriculumId, pIN_subjectId,pIN_subjectHours, pIN_gradeLevelId);
	
    UPDATE subject_mt SET isAdded = 1
    WHERE subject_mt.subject_id = pIN_subjectId;
    
    COMMIT;
    
	SELECT 'Successfully added curriculum with subject' AS msg;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `createSection` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `createSection`(IN pIN_sectionName VARCHAR(50), OUT pOUT_sectionId INT)
BEGIN
	
    INSERT INTO section_mt (sectionName)
    VALUES (pIN_sectionName);
    
    SET pOUT_sectionId = LAST_INSERT_ID();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `createSectionSettings` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `createSectionSettings`(
IN pIN_sectionId INT,
IN pIN_schoolYearId INT,
IN pIN_gradeLevelId INT,
IN pIN_sessionId INT,
IN pIN_adviserId INT,
IN pIN_requiredAverage VARCHAR(150)
)
BEGIN


    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
		ROLLBACK;
			SELECT "Failed creating section settings";
        RESIGNAL;
    END;
    
    START TRANSACTION;
    
    IF (pIN_adviserId = 0) THEN
    
		INSERT INTO section_settings_lt (section_id, schoolyear_id, gradelevel_id, session_id, requiredAverage, adviser_id)
		VALUES (pIN_sectionId, pIN_schoolYearId, pIN_gradeLevelId, pIN_sessionId, pIN_requiredAverage, NULL);
    
    ELSE
    
		INSERT INTO section_settings_lt (section_id, schoolyear_id, gradelevel_id, session_id, requiredAverage, adviser_id)
		VALUES (pIN_sectionId, pIN_schoolYearId, pIN_gradeLevelId, pIN_sessionId, pIN_requiredAverage, pIN_adviserId);
    
    END IF;
    COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `createStudentGrade` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `createStudentGrade`(
	IN pIN_subjectId INT,
    IN pIN_grade VARCHAR(10),
    IN pIN_schoolyearId INT,
    IN pIN_gradingperiodId INT,
    IN pIN_studentId INT
)
BEGIN
	
  DECLARE tempGradeId INT;
	
    START TRANSACTION;
    
    IF(pIN_grade = 0.0) THEN
		
		INSERT INTO grade (subject_id, grade, schoolyear_id, gradingperiod_id)
		VALUES (pIN_subjectId, NULL, pIN_schoolyearId, pIN_gradingperiodId);
    
		SET tempGradeId = LAST_INSERT_ID();
    
		INSERT INTO student_grade (student_id, grade_id)
		VALUES (pIN_studentId, tempGradeId); 
    
    ELSE
    
		INSERT INTO grade (subject_id, grade, schoolyear_id, gradingperiod_id)
		VALUES (pIN_subjectId, pIN_grade, pIN_schoolyearId, pIN_gradingperiodId);
    
		SET tempGradeId = LAST_INSERT_ID();
    
		INSERT INTO student_grade (student_id, grade_id)
		VALUES (pIN_studentId, tempGradeId); 
    
    END IF;
    
    COMMIT;
  
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `createStudentSection` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `createStudentSection`(IN pIN_sectionId INT, IN pIN_studentId INT, IN pIN_schoolYearId INT)
BEGIN
	
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
		ROLLBACK;
			SELECT 'Failed student section';
        RESIGNAL;
    END;
    
    START TRANSACTION;
    
		INSERT INTO section_student (section_id, student_id, schoolyear_id) 
        VALUES (pIN_sectionId, pIN_studentId, pIN_schoolYearId);
        
        UPDATE schoolyear_student_lt SET section_id = pIN_sectionId
        WHERE student_id = pIN_studentId
        AND schoolyear_id = pIN_schoolYearId
        AND schoolyear_student_lt.isActive = 1;
        
    COMMIT;	
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `createStudentSummer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `createStudentSummer`(
IN pIN_schoolyearId INT,
IN pIN_studentId INT,
IN pIN_gradeLevelId INT,
IN pIN_subjectId INT,
IN pIN_studentGrade DOUBLE
)
BEGIN
	
    DECLARE tempSummerId DOUBLE;
    
	START TRANSACTION;
	
    INSERT INTO student_summer (student_id, schoolyear_id, gradelevel_id)
	VALUES (pIN_studentId, pIN_schoolyearId, pIN_gradeLevelId);
		
	SET tempSummerId = LAST_INSERT_ID();
    
    IF (pIN_studentGrade >= 75) THEN
        
		INSERT INTO student_summer_grade (student_summer_id, subject_id, grade, isPassed)
		VALUES (tempSummerId, pIN_subjectId, pIN_studentGrade, true);
		
        INSERT INTO grade (subject_id, schoolyear_id, gwa)
        VALUES (pIN_subjectId, pIN_schoolyearId, pIN_studentGrade);
        
    ELSE
    
		INSERT INTO student_summer_grade (student_summer_id, subject_id, grade, isPassed)
		VALUES (tempSummerId, pIN_subjectId, pIN_studentGrade, false);
    
    END IF;
    
    COMMIT;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `createSubject` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `createSubject`(
	IN pIN_subjectCode VARCHAR(250), 
    IN pIN_subjectTitle VARCHAR(250), 
    IN pIN_subjectDescription VARCHAR(250),
    OUT pOUT_subjectId INT,
    IN pIN_gradeLevelId INT,
    IN pIN_schoolyearId INT
)
BEGIN
	
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
		ROLLBACK;
			SELECT "Failed creating subject";
        RESIGNAL;
    END;
	
    START TRANSACTION;
    
	INSERT INTO subject_mt(`code`,title,description,isActive)
	VALUES(pIN_subjectCode, pIN_subjectTitle, pIN_subjectDescription, TRUE);
			
	SET pOUT_subjectId = LAST_INSERT_ID();
    
	INSERT INTO subject_gradelevel_lt (subject_id, gradelevel_id,`year_created_schoolyear_id`)
	VALUES (pOUT_subjectId,pIN_gradeLevelId,pIN_schoolyearId);
			
	COMMIT;
        

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `createTuitionFee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `createTuitionFee`(aFeeTitle VARCHAR(100),aFeeAmount DECIMAL, aFeeDescription TEXT, aFeeTypeId INT,aGradeLevelId INT, aSchoolYearId INT, aAddedByUserId INT, aLastEditedByUserId INT)
BEGIN
	
    DECLARE myFeeId INT;
    DECLARE myTuitionId INT;
    DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
        SELECT 'error occured' AS msg;
        RESIGNAL;
    END;

	START TRANSACTION;
	
    IF NOT EXISTS(SELECT id FROM tuition WHERE gradelevel_id = aGradeLevelId AND schoolyear_id = aSchoolYearId)
    THEN
		INSERT INTO tuition(gradelevel_id,schoolyear_id)VALUES(aGradeLevelId,aSchoolYearId);
        
        SELECT LAST_INSERT_ID() INTO myTuitionId;
        INSERT INTO fees(title, amount, description, feetype_id)
    VALUES(aFeeTitle,aFeeAmount,aFeeDescription,aFeeTypeId);
    
    
	SELECT LAST_INSERT_ID() INTO myFeeId;
    
    INSERT INTO fees_hd(fees_id, addedByUserId, lastEditedByUserId, dateLastEdited)
    VALUES(myFeeId,aAddedByUserId,aLastEditedByUserId,CURRENT_TIMESTAMP);
    
    INSERT INTO tuition_fee(fees_id, tuition_id)
    VALUES(myFeeId,myTuitionId);
    
    
    ELSE
		
		SELECT t.id INTO myTuitionId FROM tuition t WHERE t.gradelevel_id = aGradeLevelId AND t.schoolyear_id = aSchoolYearId;
    
    
    INSERT INTO fees(title, amount, description, feetype_id)
    VALUES(aFeeTitle,aFeeAmount,aFeeDescription,aFeeTypeId);
    SELECT LAST_INSERT_ID() INTO myFeeId;
    INSERT INTO fees_hd(fees_id, addedByUserId, lastEditedByUserId, dateLastEdited)
    VALUES(myFeeId,aAddedByUserId,aLastEditedByUserId,CURRENT_TIMESTAMP);
    
    
    INSERT INTO tuition_fee(fees_id, tuition_id)
    VALUES(myFeeId,myTuitionId);
    
    END IF;
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `credentialAlreadyExists` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `credentialAlreadyExists`(aCredentialName VARCHAR(255))
BEGIN

SELECT * FROM credentials_mt WHERE credential_name = aCredentialName;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `curriculumExists` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `curriculumExists`(IN aGradeLevelId INT, IN aSchoolYearId INT)
BEGIN
	select * from curriculum_mt where gradelevel_id = aGradeLevelId AND schoolyear_id = aSchoolYearId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deactivateGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deactivateGradeLevel`(IN aGradeLevelId INT)
BEGIN
	DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
        RESIGNAL;
    END;
    
    
    START TRANSACTION;

	UPDATE gradelevel_mt SET isActive = 0
    WHERE gradelevel_id = aGradeLevelId;
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteAllCurriculumSubjects` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteAllCurriculumSubjects`(IN p_curriculumId INT, IN p_subjectId INT)
BEGIN

	DELETE FROM curriculum_subjects WHERE curriculumId = p_curriculumId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteAllCurriculumSubjectsOf` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteAllCurriculumSubjectsOf`(p_curriculumId INT)
BEGIN
	DELETE FROM curriculum_subjects WHERE curriculumId = p_curriculumId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteCreatedCurriculumById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteCreatedCurriculumById`(IN pIN_curriculumId INT)
BEGIN
	
    DELETE FROM curriculum_subject_lt WHERE curriculum_id = pIN_curriculumId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteCurriculumById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteCurriculumById`(IN pIN_curriculumId INT)
BEGIN
	
    DELETE FROM curriculum_subject_lt 
    WHERE curriculum_id = pIN_curriculumId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteDiscount` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteDiscount`(aDiscountId INT)
BEGIN
	DELETE FROM discount WHERE discount_id = aDiscountId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteFacultySpecialization` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteFacultySpecialization`(IN pIN_facultyId INT)
BEGIN

DELETE FROM faculty_specialization WHERE faculty_specialization.faculty_id = pIN_facultyId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteFee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteFee`(aFeeId INT)
BEGIN

DECLARE EXIT handler for sqlexception
BEGIN
	rollback;
    resignal;
END;

start transaction;

DELETE FROM fee_schoolyear_lt 
WHERE
    fee_id = aFeeId;
DELETE FROM fee_mt 
WHERE
    fee_id = aFeeId;
    
commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteFeeFromFeeSchoolYearById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteFeeFromFeeSchoolYearById`(aFeeId INT)
BEGIN

DELETE FROM fee_schoolyear_lt WHERE fee_id = aFeeId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteGradeByStudentId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteGradeByStudentId`(IN pIN_studentId INT)
BEGIN
	
    DELETE student_grade, grade FROM student_grade
	INNER JOIN grade
	WHERE student_id = pIN_studentId
	AND isActive = 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteStudentSectionById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteStudentSectionById`(IN pIN_sectionId INT)
BEGIN
	
    
    DELETE FROM section_student 
    WHERE section_id = pIN_sectionId;
    
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `enrollStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `enrollStudent`(
aSchoolYearId INT, 
aStudentId INT, 
aGradeLevelId INT
)
BEGIN

	DECLARE aEnrollmentId INT;

	DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
		ROLLBACK;
        RESIGNAL;
    END;
    
    /* UPDATE student_mt SET isActive = 1 WHERE student_id = aStudentId;
	INSERT INTO schoolyear_student_lt (schoolyear_id,student_id,gradelevel_id)
    VALUES(aSchoolYearId, aStudentId, aGradeLevelId); */
    
    START TRANSACTION;
    
    SELECT enrollment_id INTO aEnrollmentId FROM enrollment_mt
    WHERE schoolyear_id = aSchoolYearId;
    
    UPDATE student_mt SET isActive = 1 WHERE student_id = aStudentId;
	INSERT INTO schoolyear_student_lt (schoolyear_id,student_id,gradelevel_id)
    VALUES(aSchoolYearId, aStudentId, aGradeLevelId);
    
    
    INSERT INTO enrollment_student_lt
    (enrollment_id, student_id, date_of_enrollment)
    VALUES(aEnrollmentId,aStudentId,CURDATE());
    
    IF CURDATE() < 
		(SELECT DATE(opening_date) 
			FROM enrollment_mt 
				WHERE schoolyear_id = aSchoolYearId)
		THEN 
		UPDATE enrollment_student_lt 
			SET isEarlyEnrollment = 1
				WHERE student_id = aStudentId;
    
	ELSEIF CURDATE() >
		(SELECT DATE(closing_date) 
			FROM enrollment_mt 
				WHERE schoolyear_id = aSchoolYearId)
		THEN
        UPDATE enrollment_student_lt 
			SET isLateEnrollment = 1
				WHERE student_id = aStudentId;
    END IF;
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `facultyhasAdvisory` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `facultyhasAdvisory`(pInFacultyId INT, pInSchoolYearId INT)
BEGIN

DECLARE count INT;
DECLARE hasAdvisory BOOLEAN;

SELECT COUNT(*) INTO count 
FROM section_settings_lt WHERE adviser_id = pInFacultyId
AND schoolyear_id = pInSchoolYearId;

IF (count > 1)
THEN SET hasAdvisory = TRUE;
ELSE SET hasAdvisory = FALSE;
ENd IF;

SELECT hasAdvisory;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `feeExists` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `feeExists`(aFeeName VARCHAR(255))
BEGIN
	SELECT * FROM fee_mt f WHERE f.fee_name = aFeeName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAdmissionGradeLevelByRegistrationId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAdmissionGradeLevelByRegistrationId`(
aRegistrationId INT)
BEGIN

SELECT gl.grade_level AS admissionGradeLevel
FROM registration_mt r
INNER JOIN admission_mt a ON r.registration_id = a.registration_id
INNER JOIN gradelevel_mt gl ON r.gradelevel_id = gl.gradelevel_id
WHERE r.registration_id = aRegistrationId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAdmissionInfoByRegistrationId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAdmissionInfoByRegistrationId`(IN aRegistrationId INT)
BEGIN

SELECT * FROM admission_mt WHERE registration_id = aRegistrationId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAdmissionStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAdmissionStatus`(aRegistrationId INT)
BEGIN
	SELECT r.isAdmissionComplete FROM registration r WHERE r.registration_id = aRegistrationId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAdviserIdByUserId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAdviserIdByUserId`(aUserId INT)
BEGIN

SELECT uf.user_id ,sslt.adviser_id FROM section_settings_lt sslt
INNER JOIN user_faculty uf ON sslt.adviser_id = uf.faculty_id
WHERE uf.user_id = aUserId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllActiveGradeLevels` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllActiveGradeLevels`()
BEGIN
	SELECT * FROM gradelevel_mt WHERE isActive = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllActivePaymentTerms` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllActivePaymentTerms`()
BEGIN
	SELECT * FROM paymentterm_mt WHERE isActive = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllActiveRooms` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllActiveRooms`()
BEGIN

SELECT * FROM room_mt WHERE `status` = 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllCreatedCurriculumInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllCreatedCurriculumInfo`()
BEGIN

	SELECT 
		curriculum_mt.curriculum_id,
		subject_mt.code, subject_mt.title, 
        schoolyear_mt.yearFrom, schoolyear_mt.yearTo
			FROM curriculum_subject_lt
		INNER JOIN subject_mt ON subject_mt.subject_id = curriculum_subject_lt.subject_id
        INNER JOIN curriculum_mt ON curriculum_mt.curriculum_id = curriculum_subject_lt.curriculum_id
        INNER JOIN schoolyear_mt ON schoolyear_mt.schoolyear_id = curriculum_mt.schoolyear_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllCredentials` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllCredentials`()
BEGIN

SELECT c.*,cr.*,gl.grade_level,sy.yearFrom, sy.yearTo FROM credentials_mt c
INNER JOIN credential_requirements_lt cr ON c.credential_id
INNER JOIN gradelevel_mt gl ON cr.gradelevel_id = gl.gradelevel_id
INNER JOIN schoolyear_mt sy ON cr.schoolyear_id = sy.schoolyear_id
GROUP BY c.credential_name;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllCurriculum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllCurriculum`()
BEGIN
	
SELECT c.*,sy.yearFrom,
(SELECT COUNT(*) FROM curriculum_subject_lt cslt WHERE cslt.curriculum_id = c.curriculum_id )
AS subjectCount
FROM curriculum_mt c 
INNER JOIN schoolyear_mt sy ON c.schoolyear_id = sy.schoolyear_id;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllCurriculumByStartYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllCurriculumByStartYear`(
	IN pIN_schoolYearStart VARCHAR(50)
)
BEGIN
	
    SELECT curriculum_mt.curriculum_title FROM curriculum_subject_lt
		INNER JOIN curriculum_mt ON curriculum_mt.curriculum_id = curriculum_subject_lt.curriculum_id
		INNER JOIN schoolyear_mt ON schoolyear_mt.schoolyear_id = curriculum_mt.schoolyear_id
			WHERE schoolyear_mt.yearFrom = pIN_schoolYearStart;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllCurriculumInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllCurriculumInfo`()
BEGIN
	SELECT 
    c.*,
    es.educationstage,
    chd.dateAdded,
    CONCAT(uA.lastname,', ',uA.firstname,' ',uA.middlename) AS addedBy,
    chd.dateLastEdited,
    CONCAT(uB.lastname,', ',uB.firstname,' ',uB.middlename) AS lastEditedBy,
    gl.`level`,
    sy.yearFrom,
    sy.yearTo
    
    FROM 		curriculum 				c
    
    INNER JOIN 	gradelevel 				gl 	ON c.gradelevel_id = gl.gradelevel_id
    
    INNER JOIN 	curriculum_schoolyears 	csy ON c.curriculum_id = csy.curriculum_id
    
    INNER JOIN 	schoolyear	 			sy 	ON csy.schoolyear_id = sy.schoolyear_id
    
    INNER JOIN 	curriculum_hd 			chd ON c.curriculum_id = chd.curriculum_id
    
    INNER JOIN 	user					uA	ON chd.addedBy_UserId = uA.user_id
    
    INNER JOIN 	user					uB	ON chd.editedBy_UserId = uB.user_id
    
    INNER JOIN 	educationalstage		es	ON c.educationalstage_id = es.educationalstage_id
    
    ORDER BY `yearFrom`;
    
     
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllCurriculumNameByGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllCurriculumNameByGradeLevel`(IN pIN_gradeLevel INT)
BEGIN
	SELECT curriculum_title FROM curriculum_mt 
    INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = curriculum_mt.gradelevel_id
    WHERE gradelevel_mt.grade_level = pIN_gradeLevel;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllDiscounts` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllDiscounts`()
BEGIN
	SELECT * FROM discount;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllEnrolledBySchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllEnrolledBySchoolYearId`(aSchoolYearId INT)
BEGIN

SELECT
secstu.section_id, 
CASE WHEN sec.sectionName IS NULL THEN 'Unassigned' ELSE sec.sectionName END AS sectionname,
secset.adviser_id, 
CASE WHEN f.lastName IS NULL THEN '' ELSE f.lastName END AS facultyLastName, 
CASE WHEN f.firstName IS NULL THEN '' ELSE f.firstName END AS facultyFirstName, 
CASE WHEN f.middleName IS NULL THEN '' ELSE f.middleName END AS facultyMiddleName, 
r.*,a.admission_id,
a.isComplete AS isAdmissionComplete,
s.student_id,
s.student_no,
s.isActive AS isStudentActive,
s.student_type AS finalStudentType,
g.grade_level AS currentGradeLevel, 
e.enrollment_id, 
e.schoolyear_id AS enrolledSchoolYearId, 
DATE(e.enrollment_date) AS dateEnrolled,
e.isEnrollmentWithdrawn,e.enrollment_type
FROM registration_mt r
LEFT JOIN admission_mt a ON r.registration_id = a.registration_id
LEFT JOIN student_mt s ON a.admission_id = s.admission_id
LEFT JOIN schoolyear_student_lt ss ON s.student_id = ss.student_id
LEFT JOIN gradelevel_mt g ON ss.gradelevel_id = g.gradelevel_id
LEFT JOIN enrollment e ON s.student_id = e.student_id
LEFT JOIN section_student secstu ON s.student_id = secstu.student_id
LEFT JOIN section_mt sec ON secstu.section_id = sec.section_id
LEFT JOIN section_settings_lt secset ON sec.section_id = secset.section_id
LEFT JOIN faculty_mt f ON secset.adviser_id = f.faculty_id
WHERE s.isActive = 1 AND e.schoolyear_id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllEnrolledBySchoolYearIdAndGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllEnrolledBySchoolYearIdAndGradeLevelId`(aSchoolYearId INT, aGradeLevelId INT)
BEGIN

SELECT
r.*,a.admission_id,
a.isComplete AS isAdmissionComplete,
s.student_id,s.student_no,s.isActive AS isStudentActive,s.student_type AS finalStudentType,
g.grade_level AS currentGradeLevel, 
e.enrollment_id, e.schoolyear_id AS enrolledSchoolYearId, DATE(e.enrollment_date) AS dateEnrolled,
e.isEnrollmentWithdrawn,e.enrollment_type
FROM registration_mt r
LEFT JOIN admission_mt a ON r.registration_id = a.registration_id
LEFT JOIN student_mt s ON a.admission_id = s.admission_id
LEFT JOIN schoolyear_student_lt ss ON s.student_id = ss.student_id
LEFT JOIN gradelevel_mt g ON ss.gradelevel_id = g.gradelevel_id
LEFT JOIN enrollment e ON s.student_id = e.student_id
WHERE s.isActive = 1 AND e.schoolyear_id = aSchoolYearId AND g.gradelevel_id = aGradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllEnrolledUnsectionedByGradeLevelIdAndSchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllEnrolledUnsectionedByGradeLevelIdAndSchoolYearId`(
aGradeLevelId INT, aSchoolYearId INT
)
BEGIN

SELECT
r.*,a.admission_id,
a.isComplete AS isAdmissionComplete,
s.student_id,s.student_no,s.isActive AS isStudentActive,s.student_type AS finalStudentType,
g.grade_level AS currentGradeLevel, 
e.enrollment_id, e.schoolyear_id AS enrolledSchoolYearId, DATE(e.enrollment_date) AS dateEnrolled,
e.isEnrollmentWithdrawn,e.enrollment_type
FROM registration_mt r
LEFT JOIN admission_mt a ON r.registration_id = a.registration_id
LEFT JOIN student_mt s ON a.admission_id = s.admission_id
LEFT JOIN schoolyear_student_lt ss ON s.student_id = ss.student_id
LEFT JOIN gradelevel_mt g ON ss.gradelevel_id = g.gradelevel_id
LEFT JOIN enrollment e ON s.student_id = e.student_id
WHERE s.isActive = 1 
AND e.schoolyear_id = aSchoolYearId 
AND g.gradelevel_id = aGradeLevelId
AND 
(SELECT COUNT(*) FROM section_student ss WHERE ss.student_id = s.student_id) = 0;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllEnrollees` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllEnrollees`()
BEGIN

SELECT g.grade_level,
eslt.enrollment_id,eslt.student_id,
r.lastname,r.middlename,r.firstname,eslt.date_of_enrollment,sy.yearFrom AS schoolYear,
eslt.withdrawn 
FROM enrollment_student_lt eslt
INNER JOIN student_mt s ON eslt.student_id = s.student_id
INNER JOIN registration_mt r ON s.registration_id = r.registration_id
INNER JOIN schoolyear_student_lt sslt ON eslt.student_id = sslt.student_id
INNER JOIN gradelevel_mt g ON sslt.gradelevel_id = g.gradelevel_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllEnrolleesBySchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllEnrolleesBySchoolYearId`(aSchoolYearId INT)
BEGIN

SELECT g.grade_level,
eslt.enrollment_id,eslt.student_id,
r.lastname,r.middlename,r.firstname,eslt.date_of_enrollment,sy.yearFrom AS schoolYear,
eslt.withdrawn 
FROM enrollment_student_lt eslt
INNER JOIN student_mt s ON eslt.student_id = s.student_id
INNER JOIN registration_mt r ON s.registration_id = r.registration_id
INNER JOIN schoolyear_student_lt sslt ON eslt.student_id = sslt.student_id
INNER JOIN gradelevel_mt g ON sslt.gradelevel_id = g.gradelevel_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id
WHERE sslt.schoolyear_id = aSchoolYearId;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllEnrolleesBySchoolYearIdAndGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllEnrolleesBySchoolYearIdAndGradeLevelId`(aSchoolYearId INT, aGradeLevelId INT)
BEGIN

SELECT g.grade_level,
eslt.enrollment_id,eslt.student_id,
r.lastname,r.middlename,r.firstname,eslt.date_of_enrollment,sy.yearFrom AS schoolYear,
eslt.withdrawn 
FROM enrollment_student_lt eslt
INNER JOIN student_mt s ON eslt.student_id = s.student_id
INNER JOIN registration_mt r ON s.registration_id = r.registration_id
INNER JOIN schoolyear_student_lt sslt ON eslt.student_id = sslt.student_id
INNER JOIN gradelevel_mt g ON sslt.gradelevel_id = g.gradelevel_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id
WHERE sslt.schoolyear_id = aSchoolYearId
AND sslt.gradelevel_id = aGradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllEnrollmentSchedulesOfAllSchoolYears` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllEnrollmentSchedulesOfAllSchoolYears`()
BEGIN

SELECT 
    e.enrollment_id,
    e.schoolyear_id,sy.yearFrom, sy.yearTo,
    e.opening_date, e.closing_date, 
    IF(e.closing_date < CURDATE(),1,0) AS isClosed,
    e.date_created
    FROM enrollment_mt e
    INNER JOIN schoolyear_mt sy ON e.schoolyear_id = sy.schoolyear_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllFaculty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllFaculty`()
BEGIN

SELECT * FROM faculty_mt;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllFacultyByAdviserId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllFacultyByAdviserId`(IN pIN_adviserId INT)
BEGIN
	
    SELECT 
	faculty_mt.faculty_id, faculty_mt.firstName, faculty_mt.middleName, faculty_mt.lastName
    
    FROM faculty_schedule
    
    INNER JOIN faculty_mt ON faculty_mt.faculty_id = faculty_schedule.faculty_id
    INNER JOIN schedule_mt ON schedule_mt.schedule_id = faculty_schedule.schedule_id
    INNER JOIN section_mt ON section_mt.section_id = schedule_mt.section_id
    INNER JOIN section_settings_lt ON section_settings_lt.section_id = section_mt.section_id
    
    WHERE section_settings_lt.adviser_id = pIN_adviserId
    AND schedule_mt.isActive = 1
    
    GROUP BY faculty_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllFacultyByStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllFacultyByStatus`(aStatus INT(1))
BEGIN

SELECT f.* FROM faculty_mt f  WHERE f.`status` = aStatus;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllFacultyHandlingSubjectBySubjectCode` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllFacultyHandlingSubjectBySubjectCode`(
aSubjectCode VARCHAR(255), aSchoolYearId INT
)
BEGIN

SELECT 
faculty_id, lastName, firstName, middleName, contactNo,email,`status` 
FROM faculty_mt f 
WHERE faculty_id 
IN (SELECT faculty_id FROM subjectcategory_subject ss
LEFT JOIN faculty_specialization fs ON ss.subjectcategory_id = fs.specialization_id
LEFT JOIN subject_mt s ON ss.subject_id = s.subject_id
WHERE s.`code` = aSubjectCode AND schoolyear_id = aSchoolYearId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllFacultySectionByFacultyId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllFacultySectionByFacultyId`(IN pIN_facultyId INT)
BEGIN
	SELECT section_mt.sectionName FROM faculty_schedule
		INNER JOIN schedule_mt ON schedule_mt.schedule_id = faculty_schedule.schedule_id
		INNER JOIN section_mt ON section_mt.section_id = schedule_mt.section_id
        
        WHERE faculty_schedule.faculty_id = pIN_facultyId
        
        GROUP BY section_mt.section_id;
    
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllFacultyWithNoAdvisory` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllFacultyWithNoAdvisory`()
BEGIN

SELECT * FROM faculty_mt f 
WHERE 
(SELECT COUNT(*) FROM section_settings_lt sslt WHERE sslt.adviser_id = faculty_id) = 0
AND f.`status` = 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllFeeCategory` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllFeeCategory`()
BEGIN
	SELECT * FROM fee_category_mt;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllFeeNames` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllFeeNames`()
BEGIN
	SELECT fee_name FROM fee_mt;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllFeesInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllFeesInfo`()
BEGIN

SELECT 
f1.*, f2.*,
gl.*,
f3.*,
sy.*

FROM fee_mt f1 
INNER JOIN fee_schoolyear_lt f2 ON f1.fee_id = f2.fee_id
INNER JOIN fee_category_mt f3 ON f1.fee_category_id = f3.fee_category_id
INNER JOIN gradelevel_mt gl ON f2.gradelevel_id = gl.gradelevel_id
INNER JOIN schoolyear_mt sy;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllFeesInfoGroupedById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllFeesInfoGroupedById`()
BEGIN

SELECT 
f1.*, f2.*,
gl.*,
f3.*,
sy.*

FROM fee_mt f1 
INNER JOIN fee_schoolyear_lt f2 ON f1.fee_id = f2.fee_id
INNER JOIN fee_category_mt f3 ON f1.fee_category_id = f3.fee_category_id
INNER JOIN gradelevel_mt gl ON f2.gradelevel_id = gl.gradelevel_id
INNER JOIN schoolyear_mt sy
GROUP BY f1.fee_id
;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllGradeLevelsInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllGradeLevelsInfo`()
BEGIN
	SELECT * FROM gradelevel_mt ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllGradeLevelsStudentPassed` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllGradeLevelsStudentPassed`(aStudentId INT)
BEGIN

SELECT grade_level FROM schoolyear_student_lt sslt
INNER JOIN gradelevel_mt gl ON sslt.gradelevel_id = gl.gradelevel_id
WHERE 
student_id = aStudentId AND passed = 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllInactiveGradeLevels` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllInactiveGradeLevels`()
BEGIN
SELECT * FROM gradelevel_mt WHERE isActive = 0;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllInActivePaymentTerms` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllInActivePaymentTerms`()
BEGIN
	SELECT * FROM paymentterm_mt WHERE isActive = 0;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllInactiveStudents` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllInactiveStudents`()
BEGIN

SELECT 
r.*,s.*,a.*,
s.student_type AS aStudentType, 
s.isActive AS aStudentStatus
 
FROM registration_mt r
INNER JOIN admission_mt a ON r.registration_id = a.registration_Id
INNER JOIN student_mt s ON r.registration_id = s.registration_id
LEFT JOIN schoolyear_student_lt sslt ON s.student_id = sslt.student_id
WHERE s.isActive = 0
GROUP BY r.registration_id ORDER BY r.lastname;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllInactiveStudentsBySchoolYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllInactiveStudentsBySchoolYear`(IN aSchoolYearId INT)
BEGIN

SELECT 
s.*, r.*,a.*,
sy.schoolyear_id,
sy.yearFrom , sy.yearTo,

gl.grade_level,
gla.grade_level AS 		last_gradelevel_enrolled,
sslt.passed AS 			has_passed_last_gradelevel,
sslt.schoolyear_id AS 	last_gradelevel_enrolled_schoolyear_id,
sya.yearFrom AS 		last_gradelevel_enrolled_schoolyear_yearFrom,
sya.yearTo AS 			last_gradelevel_enrolled_schoolyear_yearTo,

CASE 
WHEN r.student_type = 'New' THEN gl.grade_level
WHEN r.student_type = 'Transferee' THEN gl.grade_level
WHEN r.student_type = 'Old' AND sslt.passed = 0 THEN gla.grade_level
WHEN r.student_type = 'Old' AND sslt.passed = 1 THEN gla.grade_level+1
END AS recommended_gradelevel_to_enroll

FROM registration_mt r 
INNER JOIN schoolyear_mt sy ON r.schoolyear_id = sy.schoolyear_id
INNER JOIN gradelevel_mt gl ON r.gradelevel_id = gl.gradelevel_id

INNER JOIN admission_mt a ON r.registration_id = a.registration_id
INNER JOIN student_mt s ON  a.registration_id = s.registration_id

LEFT OUTER JOIN schoolyear_student_lt sslt ON s.student_id = sslt.student_id
LEFT OUTER JOIN schoolyear_mt sya ON sslt.schoolyear_id = sya.schoolyear_id
LEFT OUTER JOIN gradelevel_mt gla ON sslt.gradelevel_id = gla.gradelevel_id

INNER JOIN 
(SELECT gl.grade_level 
	FROM registration_mt r 
	INNER JOIN gradelevel_mt gl 
	ON r.gradelevel_id = gl.gradelevel_id
	ORDER BY r.gradelevel_id ASC LIMIT 1) 
		AS registration_gradelevel_selected

WHERE s.isActive = 0 AND
sy.schoolyear_id = aSchoolYearId
GROUP BY recommended_gradelevel_to_enroll
ORDER BY sya.yearFrom DESC, sya.yearTo DESC, gla.grade_level DESC
;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllNewStudentsByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllNewStudentsByGradeLevelId`(IN pIN_gradeLevelId INT)
BEGIN
	
    SELECT 
    student_mt.student_id, 
	registration_mt.firstname, registration_mt.middlename, registration_mt.lastname,
    transferee_grade.gwa
    
    FROM transferee_grade
    
    INNER JOIN student_mt ON student_mt.student_id = transferee_grade.student_id
    INNER JOIN registration_mt ON registration_mt.registration_id = student_mt.registration_id
    
    WHERE registration_mt.gradelevel_id = pIN_gradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllOfficialReceiptsByStudentIdandSchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllOfficialReceiptsByStudentIdandSchoolYearId`(
aStudentId INT, aSchoolYearId INT
)
BEGIN

SELECT 
t.student_id, 
o.or_no_id, t.or_no_attached,
t.amount_received, t.amount_charged, 
(t.amount_received - t.amount_charged) AS change_amount, t.date_charged,
o.schoolyear_id,sy.yearfrom,yearTo
FROM transaction_mt t 
INNER JOIN or_no_mt o ON t.or_no_attached = o.or_no
LEFT JOIN schoolyear_mt sy ON o.schoolyear_id = sy.schoolyear_id
WHERE t.student_id = aStudentId AND o.schoolyear_id = aSchoolYearId
GROUP BY t.or_no_attached;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllOldStudentsByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllOldStudentsByGradeLevelId`(IN pIN_gradeLevelId INT)
BEGIN
	SELECT 
		student_mt.student_id,
		registration_mt.firstname, registration_mt.middlename, registration_mt.lastname,
		grade.gwa

		FROM schoolyear_student_lt

		INNER JOIN student_mt ON student_mt.student_id = schoolyear_student_lt.student_id
		INNER JOIN registration_mt ON registration_mt.registration_id = student_mt.registration_id
		INNER JOIN student_grade ON student_grade.student_id = student_mt.student_id
		INNER JOIN grade ON grade.grade_id = student_grade.grade_id

		WHERE schoolyear_student_lt.isActive = 1 
		AND schoolyear_student_lt.gradelevel_id =  pIN_gradeLevelId
		AND student_grade.isActive = 1
        
        GROUP BY
        student_mt.student_id,
		registration_mt.firstname, registration_mt.middlename, registration_mt.lastname,
		grade.gwa;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllPaymentTermPeriods` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllPaymentTermPeriods`()
BEGIN

SELECT ptmt.paymentterm_id, ptmt.paymentterm_name,
ptp.period_id AS ptp_period_id, ptpay.period_id AS ptpay_period_id,
p.period_id ,p.period_code,p.period_name,ptpay.paymentdeadline
FROM paymentterm_mt ptmt 
LEFT JOIN paymentterm_period ptp ON ptmt.paymentterm_id = ptp.paymentterm_id
LEFT JOIN period p ON ptp.period_id = p.period_id
LEFT JOIN paymentterm_period_paymentdeadline ptpay ON ptp.period_id = ptpay.period_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllPaymentTermsInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllPaymentTermsInfo`()
BEGIN
	
SELECT pt.*,pp.penalty_id, pp.schoolyear_id,pp.penalty_amount,pp.isActive AS isPenaltyActive, pp.date_added 
FROM paymentterm_mt pt
LEFT JOIN paymentterm_penalty pp ON pt.paymentterm_id = pp.paymentterm_id; 
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllPromotedStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllPromotedStudent`(IN pIN_schoolyearId INT)
BEGIN
SELECT 
	
	student_mt.student_id, 
    registration_mt.firstname, registration_mt.middlename, registration_mt.lastname,
    gradelevel_mt.grade_level
    
    FROM schoolyear_student_lt
    
    INNER JOIN student_mt ON student_mt.student_id = schoolyear_student_lt.student_id
    INNER JOIN registration_mt ON registration_mt.registration_id = student_mt.registration_id
    INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = schoolyear_student_lt.gradelevel_id
    
    WHERE schoolyear_student_lt.passed = 1
    AND schoolyear_student_lt.isActive = 0
    AND schoolyear_student_lt.schoolyear_id = pIN_schoolyearId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllQuarters` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllQuarters`()
BEGIN
	SELECT 
    s.quarter_id,
    s.quarter_no,
    s.isActive,
    s.description,
    s.date_added,
    sslt.isCurrentQuarter,
    sslt.start_date,
    sslt.end_date,
    sslt.schoolyear_id,
    sy.yearFrom,
    sy.yearTo
FROM
    quarter_mt s
        INNER JOIN
    schoolyear_quarter_lt sslt ON s.quarter_id = sslt.quarter_id
        INNER JOIN
    schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllRegisteredStudentsByGradeId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllRegisteredStudentsByGradeId`(IN pIN_gradeLevelId INT)
BEGIN 
	SELECT schoolyear_student_lt.student_id, 
		registration_mt.firstname, registration_mt.middlename, registration_mt.lastname, 
		gradelevel_mt.grade_level
        
        FROM schoolyear_student_lt
        
			INNER JOIN student_mt ON student_mt.student_id = schoolyear_student_lt.student_id
			INNER JOIN registration_mt ON registration_mt.registration_id = student_mt.registration_id
			INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = registration_mt.gradelevel_id
			WHERE schoolyear_student_lt.gradelevel_id = pIN_gradeLevelId;     
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllRegisteredSubjectGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllRegisteredSubjectGradeLevel`()
BEGIN 
	SELECT gradelevel_mt.grade_level FROM gradelevel_mt
    INNER JOIN subject_gradelevel_lt
    ON gradelevel_mt.gradelevel_id = subject_gradelevel_lt.gradelevel_id 
    GROUP BY grade_level ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllRegistrationInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllRegistrationInfo`()
BEGIN
	SELECT r.*,g.*,s.*,a.*
    FROM registration_mt r
    INNER JOIN gradelevel_mt g ON r.gradelevel_id = g.gradelevel_id
    INNER JOIN schoolyear_mt s ON r.schoolyear_id = s.schoolyear_id
    LEFT JOIN admission_mt a ON r.registration_id = a.registration_id
    ORDER BY r.lastname;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllRegistrationInfoByAdmissionStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllRegistrationInfoByAdmissionStatus`(admissionStatus INT)
BEGIN

	IF admissionStatus = 0
	THEN
		SELECT r.*,
		CASE 
		WHEN a.isComplete IS NULL THEN 'No' 
		WHEN a.isComplete = 0 THEN 'No'
		WHEN a.isComplete = 1 THEN 'Yes' END AS isAdmissionComplete
		FROM registration_mt r 
		LEFT JOIN admission_mt a ON r.registration_id = a.registration_id
		WHERE a.isComplete = 0 OR a.isComplete IS NULL;
	END IF;

	IF admissionStatus = 1
	THEN 
		SELECT r.*,
		CASE 
		WHEN a.isComplete IS NULL THEN 'No' 
		WHEN a.isComplete = 0 THEN 'No'
		WHEN a.isComplete = 1 THEN 'Yes' END AS isAdmissionComplete
		FROM registration_mt r 
		LEFT JOIN admission_mt a ON r.registration_id = a.registration_id
		WHERE a.isComplete = 1;
	END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllRegistrationInfoBySyYearFrom` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllRegistrationInfoBySyYearFrom`(aSchoolYearYearFrom INT)
BEGIN

SELECT r.*,s.student_no,
CASE 
WHEN a.isComplete IS NULL THEN 'No' 
WHEN a.isComplete = 0 THEN 'No'
WHEN a.isComplete = 1 THEN 'Yes' END AS isAdmissionComplete
FROM registration_mt r 
LEFT JOIN admission_mt a ON r.registration_id = a.registration_id
LEFT JOIN student_mt s ON a.admission_id = s.admission_id
WHERE schoolyear_yearfrom = aSchoolYearYearFrom;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllRegistrationInfoByWildCard` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllRegistrationInfoByWildCard`(wildCardChar VARCHAR(255))
BEGIN
	
SELECT r.*, 
CASE 
WHEN a.isComplete IS NULL THEN 'No' 
WHEN a.isComplete = 0 THEN 'No'
WHEN a.isComplete = 1 THEN 'Yes' END AS isAdmissionComplete
FROM registration_mt r 
LEFT JOIN admission_mt a ON r.registration_id = a.registration_id
WHERE 
r.lastname LIKE CONCAT('%',wildCardChar,'%') or
r.firstname LIKE CONCAT('%',wildCardChar,'%') or 
r.middlename LIKE CONCAT('%',wildCardChar,'%')
ORDER BY r.lastname ASC;

    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllRoles` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllRoles`()
BEGIN

SELECT * FROM role;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllRoomInformation` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllRoomInformation`()
BEGIN
	SELECT 
    r.room_name_or_num,
    r.bldg_name_or_num,
    r.capacity,
    CONCAT(u.lastname,', ',u.firstname,' ',u.middlename) AS addedBy,
    rhd.dateAdded,
    CONCAT(usr.lastname,', ',usr.firstname,' ',usr.middlename) AS lastEditedBy,
    rhd.dateLastEdited
    FROM room r
    INNER JOIN room_schoolyear 	rs 	ON r.room_id = rs.room_id
    INNER JOIN room_hd 			rhd ON r.room_id = rhd.room_id
    INNER JOIN schoolyear 		sy 	ON rs.schoolyear_id = sy.schoolyear_id
    INNER JOIN user 			u 	ON rhd.addedBy_UserId = u.user_id
    INNER JOIN user 			usr ON rhd.editedBy_UserId = u.user_id
    
    ORDER BY rhd.dateAdded ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllRoomsInfoByWildCard` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllRoomsInfoByWildCard`(wildCardChar VARCHAR (255))
BEGIN

SELECT r.*
FROM room_mt r 
WHERE r.room_id LIKE CONCAT('%',wildCardChar,'%') OR
r.room_name_or_num  LIKE CONCAT('%',wildCardChar,'%') OR
r.bldg_name_or_num LIKE CONCAT('%',wildCardChar,'%')
GROUP BY r.room_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllScheduleBySchoolYearSectionAndStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllScheduleBySchoolYearSectionAndStatus`(
aSchoolYearId INT, aSectionId INT, aStatus INT
)
BEGIN

SELECT 
sched.schedule_id,
sched.schedule_day, sched.startTime, sched.endTime, 
sched.schoolyear_id, sy.yearFrom, sy.yearTo, sy.isCurrentSchoolYear, sy.isActive,
sched.subject_id, subj.title, subj.`code`, subj.isActive, 
sched.section_id, sec.sectionName, sec.isActive, 
sched.room_id, r.room_name_or_num, r.bldg_name_or_num, r.capacity, r.notes, r.`status`,
sched.gradelevel_id, gl.grade_level, gl.isActive, 
sched.faculty_id, f.lastName, f.firstName, f.middleName, f.contactNo, f.email, f.`status`,
sched.schedule_session,sched.isActive AS schedule_status
FROM schedule_mt sched
LEFT JOIN schoolyear_mt sy ON sched.schoolyear_id = sy.schoolyear_id
LEFT JOIN subject_mt subj ON sched.subject_id = subj.subject_id
LEFT JOIN section_mt sec ON sched.section_id = sec.section_id
LEFT JOIN room_mt r ON sched.room_id = r.room_id
LEFT JOIN gradelevel_mt gl ON sched.gradelevel_id = gl.gradelevel_id
LEFT JOIN faculty_mt f ON sched.faculty_id = f.faculty_id
WHERE sched.schoolyear_id = aSchoolYearId AND 
sched.section_id = aSectionId AND
sched.isActive = aStatus;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSchedules` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSchedules`()
BEGIN

SELECT 
sched.schedule_id,
sched.schedule_day, sched.startTime, sched.endTime, 
sched.schoolyear_id, sy.yearFrom, sy.yearTo, sy.isCurrentSchoolYear, sy.isActive,
sched.subject_id, subj.title, subj.`code`, subj.isActive, 
sched.section_id, sec.sectionName, sec.isActive, 
sched.room_id, r.room_name_or_num, r.bldg_name_or_num, r.capacity, r.notes, r.`status`,
sched.gradelevel_id, gl.grade_level, gl.isActive, 
sched.faculty_id, f.lastName, f.firstName, f.middleName, f.contactNo, f.email, f.`status`,
sched.schedule_session,sched.isActive AS schedule_status
FROM schedule_mt sched
LEFT JOIN schoolyear_mt sy ON sched.schoolyear_id = sy.schoolyear_id
LEFT JOIN subject_mt subj ON sched.subject_id = subj.subject_id
LEFT JOIN section_mt sec ON sched.section_id = sec.section_id
LEFT JOIN room_mt r ON sched.room_id = r.room_id
LEFT JOIN gradelevel_mt gl ON sched.gradelevel_id = gl.gradelevel_id
LEFT JOIN faculty_mt f ON sched.faculty_id = f.faculty_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSchedulesBySchoolYearAndStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSchedulesBySchoolYearAndStatus`(
aSchoolYearId INT, aStatus INT
)
BEGIN

SELECT 
sched.schedule_id,
sched.schedule_day, sched.startTime, sched.endTime, 
sched.schoolyear_id, sy.yearFrom, sy.yearTo, sy.isCurrentSchoolYear, sy.isActive,
sched.subject_id, subj.title, subj.`code`, subj.isActive, 
sched.section_id, sec.sectionName, sec.isActive, 
sched.room_id, r.room_name_or_num, r.bldg_name_or_num, r.capacity, r.notes, r.`status`,
sched.gradelevel_id, gl.grade_level, gl.isActive, 
sched.faculty_id, f.lastName, f.firstName, f.middleName, f.contactNo, f.email, f.`status`,
sched.schedule_session,sched.isActive AS schedule_status
FROM schedule_mt sched
LEFT JOIN schoolyear_mt sy ON sched.schoolyear_id = sy.schoolyear_id
LEFT JOIN subject_mt subj ON sched.subject_id = subj.subject_id
LEFT JOIN section_mt sec ON sched.section_id = sec.section_id
LEFT JOIN room_mt r ON sched.room_id = r.room_id
LEFT JOIN gradelevel_mt gl ON sched.gradelevel_id = gl.gradelevel_id
LEFT JOIN faculty_mt f ON sched.faculty_id = f.faculty_id
WHERE sched.schoolyear_id = aSchoolYearId AND sched.isActive = aStatus;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSchedulesBySchoolYearFacultyAndStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSchedulesBySchoolYearFacultyAndStatus`(
aSchoolYearId INT, aFacultyId INT, aStatus INT
)
BEGIN

SELECT 
sched.schedule_id,
sched.schedule_day, sched.startTime, sched.endTime, 
sched.schoolyear_id, sy.yearFrom, sy.yearTo, sy.isCurrentSchoolYear, sy.isActive,
sched.subject_id, subj.title, subj.`code`, subj.isActive, 
sched.section_id, sec.sectionName, sec.isActive, 
sched.room_id, r.room_name_or_num, r.bldg_name_or_num, r.capacity, r.notes, r.`status`,
sched.gradelevel_id, gl.grade_level, gl.isActive, 
sched.faculty_id, f.lastName, f.firstName, f.middleName, f.contactNo, f.email, f.`status`,
sched.schedule_session,sched.isActive AS schedule_status
FROM schedule_mt sched
LEFT JOIN schoolyear_mt sy ON sched.schoolyear_id = sy.schoolyear_id
LEFT JOIN subject_mt subj ON sched.subject_id = subj.subject_id
LEFT JOIN section_mt sec ON sched.section_id = sec.section_id
LEFT JOIN room_mt r ON sched.room_id = r.room_id
LEFT JOIN gradelevel_mt gl ON sched.gradelevel_id = gl.gradelevel_id
LEFT JOIN faculty_mt f ON sched.faculty_id = f.faculty_id
WHERE sched.schoolyear_id = aSchoolYearId AND 
sched.faculty_id = aFacultyId AND
sched.isActive = aStatus;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSchedulesBySchoolYearGradeLevelAndStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSchedulesBySchoolYearGradeLevelAndStatus`(
aSchoolYearId INT, aGradeLevelId INT, aStatus INT(1)
)
BEGIN

SELECT
sched.schedule_id, 
sched.schedule_day, sched.startTime, sched.endTime, 
sched.schoolyear_id, sy.yearFrom, sy.yearTo, sy.isCurrentSchoolYear, sy.isActive,
sched.subject_id, subj.title, subj.`code`, subj.isActive, 
sched.section_id, sec.sectionName, sec.isActive, 
sched.room_id, r.room_name_or_num, r.bldg_name_or_num, r.capacity, r.notes, r.`status`,
sched.gradelevel_id, gl.grade_level, gl.isActive, 
sched.faculty_id, f.lastName, f.firstName, f.middleName, f.contactNo, f.email, f.`status`,
sched.schedule_session,sched.isActive AS schedule_status
FROM schedule_mt sched
LEFT JOIN schoolyear_mt sy ON sched.schoolyear_id = sy.schoolyear_id
LEFT JOIN subject_mt subj ON sched.subject_id = subj.subject_id
LEFT JOIN section_mt sec ON sched.section_id = sec.section_id
LEFT JOIN room_mt r ON sched.room_id = r.room_id
LEFT JOIN gradelevel_mt gl ON sched.gradelevel_id = gl.gradelevel_id
LEFT JOIN faculty_mt f ON sched.faculty_id = f.faculty_id
WHERE sched.schoolyear_id = aSchoolYearId AND 
sched.gradelevel_id = aGradeLevelId AND
sched.isActive = aStatus;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSchoolYearInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSchoolYearInfo`()
BEGIN
 
SELECT sy.*,
(SELECT start_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 1) AS Q1Start,
(SELECT end_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 1) AS Q1End ,
(SELECT grading_due_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 1) AS Q1GradingDueDate ,
(SELECT start_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 2) AS Q2Start ,
(SELECT end_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 2) AS Q2End ,
(SELECT grading_due_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 2) AS Q2GradingDueDate ,
(SELECT start_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 3) AS Q3Start ,
(SELECT end_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 3) AS Q3End,
(SELECT grading_due_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 3) AS Q3GradingDueDate ,
(SELECT start_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 4) AS Q4Start ,
(SELECT end_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 4) AS Q4End,
(SELECT grading_due_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 4) AS Q4GradingDueDate      
FROM
schoolyear_mt sy
INNER JOIN schoolyear_quarter_lt syq ON sy.schoolyear_id = syq.schoolyear_id
GROUP BY sy.schoolyear_id ORDER BY sy.yearFrom ASC;
 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSectionNameByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSectionNameByGradeLevelId`(IN pIN_gradeLevelId INT)
BEGIN
	
    SELECT section_mt.sectionName FROM section_settings_lt
	INNER JOIN section_mt ON section_mt.section_id = section_settings_lt.section_id
	WHERE section_settings_lt.gradelevel_id = pIN_gradeLevelId

	GROUP BY section_mt.sectionName;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSections` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSections`()
BEGIN

SELECT s.*,sy.yearFrom,g.grade_level,sslt.`session`,sslt.capacity,
f.faculty_id,f.lastName,f.firstName,f.middleName
FROM section_mt s
INNER JOIN section_settings_lt sslt ON s.section_id = sslt.section_id
INNER JOIN faculty_mt f ON sslt.adviser_id = f.faculty_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id
INNER JOIN gradelevel_mt g ON sslt.gradelevel_id = g.gradelevel_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSectionsByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSectionsByGradeLevelId`(IN pIN_gradeLevelId INT)
BEGIN
	SELECT 
		section_mt.section_id, section_mt.sectionName,
        gradelevel_mt.grade_level,
        faculty_mt.firstName, faculty_mt.middleName, faculty_mt.lastName,
		section_settings_lt.requiredAverage,
        session_mt.title,
        schoolyear_mt.yearFrom, schoolyear_mt.yearTo,
        section_mt.isActive
		FROM section_settings_lt
        
    INNER JOIN section_mt ON section_mt.section_id = section_settings_lt.section_id
    INNER JOIN session_mt ON session_mt.session_id = section_settings_lt.session_id
    INNER JOIN schoolyear_mt ON schoolyear_mt.schoolyear_id = section_settings_lt.schoolyear_id
    INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = section_settings_lt.gradelevel_id
    LEFT JOIN faculty_mt ON faculty_mt.faculty_id = section_settings_lt.adviser_id
    
    WHERE section_settings_lt.gradelevel_id = pIN_gradeLevelId;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSectionsByStatusAndSchoolYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSectionsByStatusAndSchoolYear`(
aIsActive boolean,
aSchoolYearId INT
)
BEGIN

SELECT s.*,sy.yearFrom,g.grade_level,sslt.`session`,sslt.capacity,
f.faculty_id,f.lastName,f.firstName,f.middleName
FROM section_mt s
INNER JOIN section_settings_lt sslt ON s.section_id = sslt.section_id
INNER JOIN faculty_mt f ON sslt.adviser_id = f.faculty_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id
INNER JOIN gradelevel_mt g ON sslt.gradelevel_id = g.gradelevel_id
WHERE s.isActive = aIsActive AND sslt.schoolyear_id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSectionsInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSectionsInfo`()
BEGIN
	SELECT 
    s.sectionName,s.isActive,
    g.`level`,
    CONCAT(sy.yearFrom,'-',sy.yearTo) AS schoolYear,
    se.title AS `session`,
    CONCAT(u.lastname,', ',u.firstname,' ',u.middlename) AS addedBy,
    shd.dateAdded,
    CONCAT(f.lastName,', ',f.firstName,' ',(SELECT LEFT(f.middleName,1)) ) AS adviser
    
    FROM section s
    INNER JOIN section_gradelevel 	sg 	ON s.section_id 		= sg.section_id
    INNER JOIN section_hd 			shd ON s.section_id 		= shd.section_id
    INNER JOIN gradelevel 			g 	ON sg.gradelevel_id 	= g.gradelevel_id
    INNER JOIN schoolyear 			sy 	ON sg.schoolyear_id 	= sy.schoolyear_id
    INNER JOIN `session` 			se 	ON sg.session_id 		= se.session_id
    INNER JOIN user 				u 	ON shd.addedBy_UserId 	= u.user_id
    INNER JOIN user 				usr ON shd.editedBy_UserId 	= u.user_id
    INNER JOIN section_adviser 		sa 	ON s.section_id 		= sa.section_id
    INNER JOIN faculty 				f 	ON sa.faculty_id 		= f.faculty_id;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSpecializations` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSpecializations`()
BEGIN
	SELECT * FROM specialization;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllStudent`()
BEGIN
	
    SELECT 
	student_mt.student_id, 
    registration_mt.firstname, registration_mt.middlename, registration_mt.lastname
    
    FROM student_mt
    
    INNER JOIN registration_mt ON registration_mt.registration_id = student_mt.registration_id;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllStudentByAdviserId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllStudentByAdviserId`(IN pIN_adviserId INT, IN pIN_currentSchoolYearId INT)
BEGIN
	
    DECLARE temp_sectionId INT;
    
    SELECT section_id INTO temp_sectionId FROM section_settings_lt
	WHERE adviser_id = pIN_adviserId;
	
    SELECT student_mt.student_id,
	registration_mt.firstname, registration_mt.middlename, registration_mt.lastname
	FROM section_student
        
	INNER JOIN section_mt ON section_mt.section_id = section_student.section_id
	INNER JOIN student_mt ON student_mt.student_id = section_student.student_id
	INNER JOIN registration_mt ON registration_mt.registration_id = student_mt.registration_id
	INNER JOIN section_settings_lt ON section_settings_lt.section_id = section_mt.section_id
    
	WHERE section_student.section_id = temp_sectionId
	AND section_student.schoolyear_id = pIN_currentSchoolYearId
	AND section_student.isActive = 1;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllStudentByAdviserSectionId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllStudentByAdviserSectionId`(IN pIN_adviserId INT, IN pIN_currentSchoolYearId INT)
BEGIN
	
    DECLARE temp_sectionId INT;
    
    SELECT section_id INTO temp_sectionId FROM section_settings_lt
	WHERE adviser_id = pIN_adviserId;
	
    SELECT student_mt.student_id,
	registration_mt.firstname, registration_mt.middlename, registration_mt.lastname
	FROM section_student
        
	INNER JOIN section_mt ON section_mt.section_id = section_student.section_id
	INNER JOIN student_mt ON student_mt.student_id = section_student.student_id
	INNER JOIN registration_mt ON registration_mt.registration_id = student_mt.registration_id
	INNER JOIN section_settings_lt ON section_settings_lt.section_id = section_mt.section_id
    
	WHERE section_student.section_id = temp_sectionId
	AND section_student.schoolyear_id = pIN_currentSchoolYearId
	AND section_student.isActive = 1;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllStudentBySectionId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllStudentBySectionId`(IN pIN_sectionId INT, pIN_currentSchoolYearId INT)
BEGIN


		SELECT student_mt.student_id,
		registration_mt.firstname, registration_mt.middlename, registration_mt.lastname
		FROM section_student
        
        INNER JOIN section_mt ON section_mt.section_id = section_student.section_id
		INNER JOIN student_mt ON student_mt.student_id = section_student.student_id
		INNER JOIN registration_mt ON registration_mt.registration_id = student_mt.registration_id
        
        WHERE section_student.section_id = pIN_sectionId
        AND section_student.schoolyear_id = pIN_currentSchoolYearId
        AND section_student.isActive = 1;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllStudentGradeByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllStudentGradeByGradeLevelId`(IN pIN_gradeLevelId INT, IN pIN_schoolYearId INT)
BEGIN
	 SELECT 
	student_mt.student_id, 
    registration_mt.firstname, registration_mt.middlename, registration_mt.lastname,
    MAX(gradelevel_mt.grade_level) AS grade_level,
    grade.gwa
    
    FROM schoolyear_student_lt
    
    INNER JOIN student_mt ON student_mt.student_id = schoolyear_student_lt.student_id
    INNER JOIN registration_mt ON registration_mt.registration_id = student_mt.registration_id
    INNER JOIN student_grade ON student_grade.student_id = schoolyear_student_lt.student_id
    INNER JOIN grade ON grade.grade_id = student_grade.grade_id
    INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = schoolyear_student_lt.gradelevel_id
    
    
    WHERE gradelevel_mt.gradelevel_id = pIN_gradeLevelId
    AND grade.schoolyear_id = pIN_schoolYearId
    AND student_grade.isActive = 1
    AND schoolyear_student_lt.isActive = 1
    
    GROUP BY student_mt.student_id, 
    registration_mt.firstname, registration_mt.middlename, registration_mt.lastname,
    gradelevel_mt.grade_level,
    grade.gwa;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllStudentGradeBySectionId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllStudentGradeBySectionId`(IN pIN_facultyId INT, IN pIN_sectionId INT)
BEGIN
	
	SELECT subject_mt.subject_id, student_mt.student_id,
	   MAX(g.gradingperiod_id) AS gradingperiod_id,
	   registration_mt.firstname, registration_mt.middlename, registration_mt.lastname,
       subject_mt.title,
       MAX(IF(g.gradingperiod_id = 7000, g.grade, "")) AS first,
       MAX(IF(g.gradingperiod_id = 7001, g.grade, "")) AS second,
       MAX(IF(g.gradingperiod_id = 7002, g.grade, "")) AS third,
       MAX(IF(g.gradingperiod_id = 7003, g.grade, "")) AS fourth,
       g.final

	FROM faculty_schedule
	INNER JOIN schedule_mt ON schedule_mt.schedule_id = faculty_schedule.schedule_id
	INNER JOIN section_mt ON section_mt.section_id = schedule_mt.section_id
	INNER JOIN section_student ON section_student.section_id = section_mt.section_id
	INNER JOIN student_mt ON student_mt.student_id = section_student.student_id
	INNER JOIN registration_mt ON registration_mt.registration_id = student_mt.registration_id
	INNER JOIN subject_mt ON subject_mt.subject_id = schedule_mt.subject_id
	LEFT JOIN student_grade AS sg ON sg.student_id = student_mt.student_id
    LEFT JOIN grade AS g ON g.grade_id = sg.grade_id
    
	WHERE faculty_schedule.faculty_id = pIN_facultyId
	AND schedule_mt.section_id = pIN_sectionId
    AND section_student.isActive = TRUE
    
    GROUP BY 
    subject_mt.subject_id, student_mt.student_id,
	registration_mt.firstname, registration_mt.middlename, registration_mt.lastname,
	subject_mt.title,
	g.final;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllStudentGradeByStudentId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllStudentGradeByStudentId`(IN pIN_studentId INT)
BEGIN

	SELECT
	   subject_mt.subject_id, subject_mt.title,
	   MAX(IF(g.gradingperiod_id = 7000, g.grade, ""))AS first,
       MAX(IF(g.gradingperiod_id = 7001, g.grade, "")) AS second,
       MAX(IF(g.gradingperiod_id = 7002, g.grade, "")) AS third,
       MAX(IF(g.gradingperiod_id = 7003, g.grade, "")) AS fourth,
       g.final

	FROM grade AS g
    INNER JOIN subject_mt ON subject_mt.subject_id = g.subject_id
	INNER JOIN student_grade AS sg ON sg.grade_id = g.grade_id
    WHERE sg.student_id = pIN_studentId
    AND sg.isActive = 1
    
    GROUP BY 
    subject_mt.subject_id, subject_mt.title,
    g.final;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllStudentGradeGWAByStudentId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllStudentGradeGWAByStudentId`(IN pIN_studentId INT)
BEGIN
	
    SELECT grade.gwa FROM student_grade
    INNER JOIN grade ON student_grade.grade_id = grade.grade_id
    
    WHERE student_grade.student_id = pIN_studentId
    
    GROUP BY grade.gwa;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllStudentRemarksByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllStudentRemarksByGradeLevelId`(IN pIN_gradeLevelId INT, IN pIN_schoolYearId INT)
BEGIN
	

    SELECT 
	student_mt.student_id, 
    registration_mt.firstname, registration_mt.middlename, registration_mt.lastname,
    gradelevel_mt.grade_level,
    grade.gwa
    
    FROM schoolyear_student_lt
    
    INNER JOIN student_mt ON student_mt.student_id = schoolyear_student_lt.student_id
    INNER JOIN registration_mt ON registration_mt.registration_id = student_mt.registration_id
    INNER JOIN student_grade ON student_grade.student_id = student_mt.student_id
    INNER JOIN grade ON grade.grade_id = student_grade.grade_id
    INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = schoolyear_student_lt.gradelevel_id
    
    WHERE gradelevel_mt.gradelevel_id = pIN_gradeLevelId
    AND grade.schoolyear_id = pIN_schoolYearId
    AND student_grade.isActive = 1
    
    GROUP BY student_mt.student_id, 
    registration_mt.firstname, registration_mt.middlename, registration_mt.lastname,
    gradelevel_mt.grade_level,
    grade.gwa;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllStudents` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllStudents`()
BEGIN

SELECT r.*,s.*,a.*,s.student_type AS aStudentType FROM registration_mt r
INNER JOIN admission_mt a ON r.registration_id = a.registration_Id
INNER JOIN student_mt s ON r.registration_id = s.registration_id
LEFT JOIN schoolyear_student_lt sslt ON s.student_id = sslt.student_id
GROUP BY r.registration_id ORDER BY r.lastname;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllStudentsByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllStudentsByGradeLevelId`(IN pIN_gradeLevelId INT)
BEGIN
	
   
    SELECT 
		student_mt.student_id, 
		registration_mt.firstname, registration_mt.middlename, registration_mt.lastname,
		grade.gwa

	FROM schoolyear_student_lt
		
	INNER JOIN student_mt ON student_mt.student_id = schoolyear_student_lt.student_id
	INNER JOIN registration_mt ON registration_mt.registration_id = student_mt.registration_id
	LEFT JOIN student_grade ON student_grade.student_id = student_mt.student_id
	LEFT JOIN grade ON grade.grade_id = student_grade.grade_id
	

	WHERE schoolyear_student_lt.isActive = 1
    AND schoolyear_student_lt.gradelevel_id = pIN_gradeLevelId
    AND schoolyear_student_lt.section_id IS NULL
    
    GROUP BY
    student_mt.student_id, 
	registration_mt.firstname, registration_mt.middlename, registration_mt.lastname,
	grade.gwa;
   
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllStudentsByWildCard` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllStudentsByWildCard`(aKeyword VARCHAR(255))
BEGIN

SELECT r.*,s.*,a.*,s.student_type AS aStudentType,gl.grade_level FROM registration_mt r
INNER JOIN admission_mt a ON r.registration_id = a.registration_Id
INNER JOIN student_mt s ON r.registration_id = s.registration_id
INNER JOIN gradelevel_mt gl ON r.gradelevel_id = gl.gradelevel_id
LEFT JOIN schoolyear_student_lt sslt ON s.student_id = sslt.student_id
WHERE 
s.student_id LIKE CONCAT('%',aKeyword,'%') OR
r.lastname LIKE CONCAT('%',aKeyword,'%') OR
r.firstname LIKE CONCAT('%',aKeyword,'%');

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllStudentSubjectByFacultyId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllStudentSubjectByFacultyId`(IN pIN_facultyId INT)
BEGIN
	
    SELECT subject_mt.subject_id, subject_mt.title
		FROM faculty_schedule
        
		INNER JOIN schedule_mt ON schedule_mt.schedule_id = faculty_schedule.schedule_id
		INNER JOIN user_mt ON user_mt.user_id = faculty_schedule.user_id
		INNER JOIN subject_mt ON subject_mt.subject_id = schedule_mt.subject_id

		WHERE faculty_schedule.user_id = pIN_facultyId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllStudentSubjectBySectionId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllStudentSubjectBySectionId`(IN pIN_sectionId INT)
BEGIN


	SELECT
	subject_mt.subject_id,
	subject_mt.title

    
    FROM faculty_schedule
    
    INNER JOIN schedule_mt ON schedule_mt.schedule_id = faculty_schedule.schedule_id
    INNER JOIN section_student ON section_student.section_id = schedule_mt.section_id
    INNER JOIN subject_mt ON subject_mt.subject_id = schedule_mt.subject_id
    INNER JOIN curriculum_subject_lt ON curriculum_subject_lt.subject_id = subject_mt.subject_id
    INNER JOIN curriculum_mt ON curriculum_mt.curriculum_id = curriculum_subject_lt.curriculum_id
    
    
    WHERE schedule_mt.section_id = pIN_sectionId
    AND curriculum_mt.isActive = 1
    
    GROUP BY 
	subject_mt.subject_id,
	subject_mt.title;

    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSubjectBySectionIdAndSchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSubjectBySectionIdAndSchoolYearId`(aSectionId INT, aSchoolYearId INT)
BEGIN
SELECT 
sched.schedule_id,sched.schedule_day,sched.startTime,sched.endTime,sched.isActive,
fs.date_assigned,
f.faculty_id, f.firstName, f.lastName, f.middleName,
sec.section_id,sec.sectionName,
sbj.subject_id, sbj.title,
r.room_id, r.room_name_or_num,
sy.schoolyear_id, sy.yearFrom,sy.yearTo
FROM schedule_mt sched
LEFT JOIN faculty_schedule fs ON sched.schedule_id = fs.schedule_id
LEFT JOIN faculty_mt f ON fs.faculty_id = f.faculty_id
INNER JOIN section_mt sec ON sched.section_id = sec.section_id
INNER JOIN subject_mt sbj ON sched.subject_id = sbj.subject_id
INNER JOIN room_mt r ON sched.room_id = r.room_id
INNER JOIN schoolyear_mt sy ON sched.schoolyear_id = sy.schoolyear_id
WHERE sched.schoolyear_id = aSchoolYearId AND sched.section_id = aSectionId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSubjectCategoryInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSubjectCategoryInfo`()
BEGIN

SELECT sc.*, scs.* 
FROM subjectcategory_mt sc
LEFT JOIN subjectcategory_subject scs ON sc.subjectcategory_id = scs.subjectcategory_id
GROUP BY sc.subjectcategory_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSubjectCategoryInfoById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSubjectCategoryInfoById`(subjectCtgyId INT)
BEGIN

SELECT sc.*, scs.* 
FROM subjectcategory_mt sc
LEFT JOIN subjectcategory_subject scs ON sc.subjectcategory_id = scs.subjectcategory_id
WHERE sc.subjectcategory_id = subjectCtgyId
GROUP BY sc.subjectcategory_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSubjectCategoryInfoByWildCard` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSubjectCategoryInfoByWildCard`(wildCardChar VARCHAR(255))
BEGIN

SELECT sc.*, scs.* 
FROM subjectcategory_mt sc
INNER JOIN subjectcategory_subject scs ON sc.subjectcategory_id = scs.subjectcategory_id
WHERE sc.subjectcategory_id LIKE CONCAT('%',wildCardChar,'%') OR
sc.subjectcategory_name LIKE CONCAT('%',wildCardChar,'%') 
GROUP BY sc.subjectcategory_id;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSubjectForCurriculum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSubjectForCurriculum`()
BEGIN
	SELECT subject_mt.code, subject_mt.title, subject_mt.description, gradelevel_mt.grade_level
	FROM subject_gradelevel_lt
	INNER JOIN subject_mt
	ON subject_mt.subject_id = subject_gradelevel_lt.subject_id
	INNER JOIN gradelevel_mt
	ON gradelevel_mt.gradelevel_id = subject_gradelevel_lt.gradelevel_id
    ORDER BY gradelevel_mt.grade_level ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSubjects` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSubjects`()
BEGIN

/*
	SELECT subject_gradelevel_lt.subject_id, title, `code`, description, isActive FROM subject_gradelevel_lt
	INNER JOIN subject_mt ON subject_mt.subject_id = subject_gradelevel_lt.subject_id;
    */
    SELECT * FROM subject_mt;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSubjectsByGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSubjectsByGradeLevel`(IN p_gradeLevel INT)
BEGIN
	SELECT title FROM subject_gradelevel_lt
	INNER JOIN subject_mt
	ON subject_mt.subject_id = subject_gradelevel_lt.subject_id
	INNER JOIN gradelevel_mt
	ON gradelevel_mt.gradelevel_id = subject_gradelevel_lt.gradelevel_id
	WHERE gradelevel_mt.grade_level = p_gradeLevel;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSubjectsByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSubjectsByGradeLevelId`(IN pIN_gradeLevelId INT)
BEGIN

	SELECT 
    sglt.subject_id, s.`code`, s.title, s.description, s.isActive,
    g.grade_level
	FROM subject_gradelevel_lt sglt
	INNER JOIN subject_mt s ON s.subject_id = sglt.subject_id
    INNER JOIN gradelevel_mt g ON sglt.gradelevel_id = g.gradelevel_id
	WHERE sglt.gradelevel_id = pIN_gradeLevelId;
		
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSubjectsByStatusAndGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSubjectsByStatusAndGradeLevelId`(
aIsActive INT, aGradeLevelId INT
)
BEGIN

SELECT 
sglt.subject_id, s.`code`, s.title, s.description, s.isActive, 
g.grade_level,sglt.year_created_schoolyear_id,
s.date_created
FROM subject_gradelevel_lt sglt
INNER JOIN subject_mt s ON s.subject_id = sglt.subject_id
INNER JOIN gradelevel_mt g ON sglt.gradelevel_id = g.gradelevel_id
WHERE sglt.gradelevel_id = aGradeLevelId
AND s.isActive = aIsActive;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSubjectsInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSubjectsInfo`()
BEGIN

	SELECT 
    s.subject_id, s.title, s.`code`, s.description, s.isActive, g.grade_level 
    FROM subject_gradelevel_lt sglt
	INNER JOIN subject_mt s ON sglt.subject_id = s.subject_id
    INNER JOIN gradelevel_mt g ON sglt.gradelevel_id = g.gradelevel_id
    ORDER BY g.grade_level ASC;
    

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSubjectsOfCurriculumByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSubjectsOfCurriculumByName`(
	IN pIN_curriculumTitle VARCHAR(150)
)
BEGIN
	
    SELECT subject_mt.code, subject_mt.title, subject_mt.description, gradelevel_mt.grade_level FROM curriculum_subject_lt
		INNER JOIN subject_mt ON subject_mt.subject_id = curriculum_subject_lt.subject_id
		INNER JOIN curriculum_mt ON curriculum_mt.curriculum_id = curriculum_subject_lt.curriculum_id
		INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = curriculum_mt.gradelevel_id
			WHERE curriculum_mt.curriculum_title = pIN_curriculumTitle;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllSummerStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSummerStudent`()
BEGIN
	SELECT
    student_mt.student_id, 
    registration_mt.firstname, registration_mt.middlename, registration_mt.lastname,
    gradelevel_mt.grade_level
    
    FROM schoolyear_student_lt
    
    INNER JOIN student_mt ON student_mt.student_id = schoolyear_student_lt.student_id
    INNER JOIN registration_mt ON registration_mt.registration_id = student_mt.registration_id
    INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = schoolyear_student_lt.gradelevel_id
    
    WHERE schoolyear_student_lt.passed = 0
    AND schoolyear_student_lt.isActive = 1;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllUserInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllUserInfo`()
BEGIN


SELECT u.*,r.* FROM user_mt u
LEFT JOIN user_role ur ON u.user_id = ur.user_id
LEFT JOIN role r ON ur.role_id = r.role_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllUsersInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllUsersInfo`()
BEGIN
	SELECT * FROM users;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getBalanceBreakDownId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getBalanceBreakDownId`(
balancebreakdownName VARCHAR(255),
aStudentId INT,
aSchoolYearId INT
)
BEGIN

SELECT balancebreakdown_id FROM balancebreakdown 
WHERE 
balancebreakdown_name = balancebreakdownName AND 
student_id = aStudentId AND schoolyear_id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getBasicFeeByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getBasicFeeByGradeLevelId`(aGradeLevelId INT)
BEGIN

SELECT f.fee_id, f.fee_name, f.fee_description, fs.fee_amount, 
fc.fee_category, fc.fee_category_id,
gl.*,
sy.*,
fs.*
FROM fee_mt f
INNER JOIN fee_schoolyear_lt fs ON f.fee_id = fs.fee_id
INNER JOIN gradelevel_mt gl ON fs.gradelevel_id = gl.gradelevel_id
INNER JOIN schoolyear_mt sy ON fs.schoolyear_id = sy.schoolyear_id
INNER JOIN fee_category_mt fc ON f.fee_category_id = fc.fee_category_id

WHERE fc.fee_category = 'Basic'
AND fs.gradelevel_id = aGradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getClassListBySchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getClassListBySchoolYearId`(aSchoolYearId INT)
BEGIN

SELECT 
f.lastName AS adviser_lastname,f.firstName AS adviser_firstname,
s.sectionName, ss.student_id, r.lastname,r.firstname,r.middlename,
gl.grade_level
FROM section_mt s 
INNER JOIN section_student ss ON s.section_id = ss.section_id
INNER JOIN student_mt smt ON ss.student_id = smt.student_id
INNER JOIN registration_mt r ON smt.registration_id = r.registration_id
LEFT JOIN section_settings_lt sslt ON s.section_id = sslt.section_id
LEFT JOIN faculty_mt f ON sslt.adviser_id = f.faculty_id
INNER JOIN gradelevel_mt gl ON sslt.gradelevel_id = gl.gradelevel_id
WHERE ss.schoolyear_id = aSchoolYearId;	

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getClassListBySchoolYearIdAndGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getClassListBySchoolYearIdAndGradeLevelId`(aSchoolYearId INT, aGradeLevelId INT)
BEGIN

SELECT 
f.lastName AS adviser_lastname,f.firstName AS adviser_firstname,
s.sectionName, ss.student_id, r.lastname,r.firstname,r.middlename,
gl.grade_level
FROM section_mt s 
INNER JOIN section_student ss ON s.section_id = ss.section_id
INNER JOIN student_mt smt ON ss.student_id = smt.student_id
INNER JOIN registration_mt r ON smt.registration_id = r.registration_id
LEFT JOIN section_settings_lt sslt ON s.section_id = sslt.section_id
LEFT JOIN faculty_mt f ON sslt.adviser_id = f.faculty_id
INNER JOIN gradelevel_mt gl ON sslt.gradelevel_id = gl.gradelevel_id
WHERE ss.schoolyear_id = aSchoolYearId
AND sslt.gradelevel_id = aGradeLevelId;	

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCreatedCurriculumById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCreatedCurriculumById`(IN pIN_curriculumId INT)
BEGIN
	
    SELECT
		subject_mt.subject_id, subject_mt.code, subject_mt.title, curriculum_subject_lt.subject_hours,
        gradelevel_mt.grade_level
			FROM curriculum_subject_lt
            INNER JOIN curriculum_mt ON curriculum_mt.curriculum_id = curriculum_subject_lt.curriculum_id
            INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = curriculum_subject_lt.gradelevel_id
            INNER JOIN subject_mt ON subject_mt.subject_id = curriculum_subject_lt.subject_id
            WHERE curriculum_mt.curriculum_id = pIN_curriculumId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCreatedCurriculumInfoById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCreatedCurriculumInfoById`(IN pIN_curriculumId INT)
BEGIN
	
    SELECT 
		curriculum_mt.curriculum_id,
        curriculum_mt.curriculum_title, curriculum_mt.description,
		subject_mt.code, subject_mt.title,
        gradelevel_mt.grade_level,
        schoolyear_mt.yearFrom, schoolyear_mt.yearTo
			FROM curriculum_subject_lt
            INNER JOIN curriculum_mt ON curriculum_mt.curriculum_id = curriculum_subject_lt.curriculum_id
            INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = curriculum_mt.gradelevel_id
            INNER JOIN subject_mt ON subject_mt.subject_id = curriculum_subject_lt.subject_id
            INNER JOIN schoolyear_mt ON schoolyear_mt.schoolyear_id = curriculum_mt.schoolyear_id
            WHERE curriculum_mt.curriculum_id = pIN_curriculumId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCreatedSectionById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCreatedSectionById`(IN pIN_sectionId INT)
BEGIN
	SELECT section_mt.sectionName,
			gradelevel_mt.grade_level,
				schoolyear_mt.yearFrom, schoolyear_mt.yearTo,
					sectioncategory_mt.grade_range_from, sectioncategory_mt.grade_range_to, sectioncategory_mt.category,
						section_settings_lt.capacity,
							session_mt.title
								FROM section_settings_lt
		INNER JOIN section_mt ON section_mt.section_id = section_settings_lt.section_id
		INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = section_settings_lt.gradelevel_id
		INNER JOIN schoolyear_mt ON schoolyear_mt.schoolyear_id = section_settings_lt.schoolyear_id
        INNER JOIN sectioncategory_mt ON sectioncategory_mt.sectioncategory_id = section_settings_lt.sectioncategory_id
        INNER JOIN session_mt ON session_mt.session_id = section_settings_lt.session_id

		WHERE section_settings_lt.section_id = pIN_sectionId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCreatedSubjectInfoById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCreatedSubjectInfoById`(IN pIN_subjectId INT)
BEGIN
	
    SELECT 
		subject_mt.title, subject_mt.code, subject_mt.description,
        gradelevel_mt.grade_level
			FROM subject_gradelevel_lt
		INNER JOIN subject_mt ON subject_mt.subject_id = subject_gradelevel_lt.subject_id
        INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = subject_gradelevel_lt.gradelevel_id
        WHERE subject_mt.subject_id = pIN_subjectId;
		
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCredentialByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCredentialByGradeLevelId`(aGradeLevelId INT)
BEGIN

SELECT c.*,cr.*,gl.grade_level,sy.yearFrom, sy.yearTo FROM credentials_mt c
INNER JOIN credential_requirements_lt cr ON c.credential_id
INNER JOIN gradelevel_mt gl ON cr.gradelevel_id = gl.gradelevel_id
INNER JOIN schoolyear_mt sy ON cr.schoolyear_id = sy.schoolyear_id

WHERE cr.gradelevel_id = aGradeLevelId 
GROUP BY c.credential_name;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCredentialIdByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCredentialIdByName`(aCredentialName VARCHAR(255))
BEGIN
SELECT credential_id 
FROM credentials_mt
WHERE credential_name = aCredentialName;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCurrentSchoolYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurrentSchoolYear`()
BEGIN
	SELECT * FROM schoolyear_mt WHERE isCurrentSchoolYear = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCurrentSchoolYearFrom` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurrentSchoolYearFrom`()
BEGIN
SELECT yearFrom FROM schoolyear_mt WHERE isCurrentSchoolYear = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCurrentSchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurrentSchoolYearId`()
BEGIN
SELECT schoolyear_id FROM schoolyear_mt WHERE isCurrentSchoolYear = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCurriculumById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurriculumById`(curriculumId INT)
BEGIN

SELECT * FROM curriculum_mt WHERE curriculum_id = curriculumId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCurriculumByWildCard` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurriculumByWildCard`(aWildCardChar VARCHAR(255))
BEGIN

SELECT 
c.*,sy.yearFrom,
(SELECT COUNT(*) FROM curriculum_subject_lt cslt WHERE cslt.curriculum_id = c.curriculum_id)
AS subjectCount
FROM curriculum_mt c 
INNER JOIN schoolyear_mt sy ON c.schoolyear_id = sy.schoolyear_id
WHERE c.curriculum_id LIKE CONCAT('%',aWildCardChar,'%') OR
c.curriculum_title LIKE CONCAT('%',aWildCardChar,'%') OR 
sy.yearFrom LIKE CONCAT('%',aWildCardChar,'%');

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCurriculumIdByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurriculumIdByName`(curriculumName VARCHAR(255))
BEGIN

SELECT curriculum_id FROM curriculum_mt WHERE curriculum_title = curriculumName;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCurriculumInfoOf` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurriculumInfoOf`(IN p_curriculumId INT)
BEGIN

SELECT 
    c.*,
    es.educationstage,
    chd.dateAdded,
    gl.`level`,
    sy.yearFrom,
    sy.yearTo
    
    FROM curriculum 					c
    INNER JOIN gradelevel 				gl 	ON c.gradeLevelId = gl.id
    INNER JOIN curriculum_schoolyears 	csy ON c.id = csy.curriculumId
    INNER JOIN schoolyear 				sy 	ON csy.schoolYearId = sy.id
    INNER JOIN curriculum_hd 			chd ON c.id = chd.curriculumId
    INNER JOIN educationalstage			es	ON c.educationalstage_id = es.id
    
    WHERE c.id = p_curriculumId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCurriculumNameGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurriculumNameGradeLevel`(aEducationalStageId int)
BEGIN
	SELECT g.`level` as gradelevel
    FROM educationalstage_gradelevel esg 
    INNER JOIN gradelevel g ON esg.gradelevel_id = g.id
    WHERE esg.curriculumname_id = aEducationStageId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCurriculumNameId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurriculumNameId`(aCurriculumName VARCHAR(50))
BEGIN
	SELECT cn.id FROM curriculumname cn WHERE cn.curriculum_name = aCurriculumName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCurriculumNames` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurriculumNames`()
BEGIN
	SELECT educationstage FROM educationalstage;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCurriculumSubjects` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurriculumSubjects`(IN p_curriculumId INT)
BEGIN
	SELECT 
    s.`code`,
    s.`name`,
    s.units,
    s.description,
    gl.`level`
    
    FROM 		subjects	 			s
    INNER JOIN 	curriculum_subjects 	cs 		ON s.id = cs.subjectId
    INNER JOIN 	subjects_gradelevel		sgl 	ON cs.subjectId = sgl.subjectId
    INNER JOIN	gradelevel				gl		ON sgl.gradeLevelId = gl.id
    
    
    WHERE cs.curriculumId = p_curriculumId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCurriculumSubjectsById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurriculumSubjectsById`(curriculumId INT)
BEGIN

SELECT s.*,cslt.subject_hours,sglt.*,g.grade_level
FROM subject_mt s
INNER JOIN curriculum_subject_lt cslt ON s.subject_id = cslt.subject_id
INNER JOIN subject_gradelevel_lt sglt ON s.subject_id = sglt.subject_id
INNER JOIN gradelevel_mt g ON sglt.gradelevel_id = g.gradelevel_id
WHERE cslt.curriculum_id = curriculumId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCurriculumYearStartEndByGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurriculumYearStartEndByGradeLevel`(IN pIN_gradeLevel INT)
BEGIN
	
    SELECT schoolyear_mt.yearFrom, schoolyear_mt.yearTo FROM curriculum_subject_lt
		INNER JOIN curriculum_mt ON curriculum_mt.curriculum_id = curriculum_subject_lt.curriculum_id
		INNER JOIN schoolyear_mt ON curriculum_mt.schoolyear_id = schoolyear_mt.schoolyear_id
		INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = curriculum_mt.gradelevel_id
			WHERE gradelevel_mt.grade_level = pIN_gradeLevel;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getDashboardPermissionByRoleId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDashboardPermissionByRoleId`(aRoleId INT)
BEGIN
SELECT r.role_id, r.role,dbp.*
FROM dashboardpermission dbp
INNER JOIN role_permission rp ON dbp.dashboardpermission_id = rp.dashboardpermission_id
INNER JOIN role r ON rp.role_id = r.role_id
WHERE rp.role_id = aRoleId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getDiscountById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDiscountById`(aDiscountId INT)
BEGIN

SELECT * FROM discount_mt WHERE discount_id = aDiscountId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getDiscountDescription` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDiscountDescription`(aDiscountName VARCHAR(100))
BEGIN

	SELECT description FROM discount WHERE discountType = aDiscountName;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getDiscountId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDiscountId`(aDiscountName VARCHAR(100))
BEGIN
	SELECT discount_id FROM discount WHERE discountType = aDiscountName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getDiscountIdByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDiscountIdByName`(aDiscountName VARCHAR(255))
BEGIN
SELECT discount_id FROM discount_mt WHERE discount_name = aDiscountName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getDiscountNames` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDiscountNames`()
BEGIN
SELECT discountType FROM discount;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getDiscountPercentage` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDiscountPercentage`(aDiscountName VARCHAR(50))
BEGIN
	SELECT percentage FROM discount WHERE discountType = aDiscountName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getDisountDescription` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDisountDescription`(aDiscountName VARCHAR(100))
BEGIN

	SELECT description FROM discount WHERE discountType = aDiscountName;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getDownpaymentFeeByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDownpaymentFeeByGradeLevelId`(aGradeLevelId INT)
BEGIN

SELECT f.fee_id, f.fee_name, f.fee_description, fs.fee_amount, 
fc.fee_category, fc.fee_category_id,
gl.*,
sy.*,
fs.*
FROM fee_mt f
INNER JOIN fee_schoolyear_lt fs ON f.fee_id = fs.fee_id
INNER JOIN gradelevel_mt gl ON fs.gradelevel_id = gl.gradelevel_id
INNER JOIN schoolyear_mt sy ON fs.schoolyear_id = sy.schoolyear_id
INNER JOIN fee_category_mt fc ON f.fee_category_id = fc.fee_category_id

WHERE fc.fee_category = 'Downpayment'
AND fs.gradelevel_id = aGradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getEachCurriculum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEachCurriculum`(IN pIN_yearFrom INT, IN pIN_search VARCHAR(250))
BEGIN
	SELECT schoolyear_mt.yearFrom, schoolyear_mt.yearTo, gradelevel_mt.grade_level, curriculum_mt.description, curriculum_mt.date_created FROM curriculum_mt
	INNER JOIN schoolyear_mt ON schoolyear_mt.schoolyear_id = curriculum_mt.schoolyear_id
	INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = curriculum_mt.gradelevel_id
    WHERE yearFrom = pIN_yearFrom AND description LIKE CONCAT ('%',  pIN_search, '%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getEachSubjectByGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEachSubjectByGradeLevel`(IN p_subjTitle VARCHAR(250))
BEGIN   
    SELECT subject_mt.title, subject_mt.code, subject_mt.description, gradelevel_mt.grade_level,
    subject_mt.subject_id, gradelevel_mt.gradelevel_id
	FROM subject_gradelevel_lt
	INNER JOIN subject_mt 
	ON subject_mt.subject_id = subject_gradelevel_lt.subject_id
	INNER JOIN gradelevel_mt 
	ON gradelevel_mt.gradelevel_id = subject_gradelevel_lt.gradelevel_id
	WHERE subject_mt.title = p_subjTitle;
    
	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getEachSubjectByGradeLevelForCurriculum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEachSubjectByGradeLevelForCurriculum`(IN pIN_gradeLevel INT)
BEGIN
	SELECT subject_mt.code, subject_mt.title, subject_mt.description, gradelevel_mt.grade_level
	FROM subject_gradelevel_lt
	INNER JOIN subject_mt
	ON subject_mt.subject_id = subject_gradelevel_lt.subject_id
	INNER JOIN gradelevel_mt
	ON gradelevel_mt.gradelevel_id = subject_gradelevel_lt.gradelevel_id
    WHERE gradelevel_mt.grade_level = pIN_gradeLevel;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getEachSubjectByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEachSubjectByGradeLevelId`(IN pIN_gradeLevelId INT)
BEGIN
	SELECT subject_mt.subject_id, subject_mt.code, subject_mt.title, gradelevel_mt.grade_level
	FROM subject_gradelevel_lt
	INNER JOIN subject_mt
	ON subject_mt.subject_id = subject_gradelevel_lt.subject_id
	INNER JOIN gradelevel_mt
	ON gradelevel_mt.gradelevel_id = subject_gradelevel_lt.gradelevel_id
    WHERE subject_gradelevel_lt.gradelevel_id = pIN_gradeLevelId
    AND subject_mt.isAdded IS NULL;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getEnrollmentScheduleBySchoolYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEnrollmentScheduleBySchoolYear`(IN aSchoolYearId INT)
BEGIN
	SELECT 
    e.enrollment_id, 
    e.opening_date, 
    e.closing_date, 
    e.date_created,
    e.schoolyear_id, 
    sy.yearFrom, 
    sy.yearTo,
    sy.start_date,
    sy.end_date,
    sy.isActive,
    sy.isCurrentSchoolYear
    FROM enrollment_mt e
    INNER JOIN schoolyear_mt sy ON e.schoolyear_id = sy.schoolyear_id
    WHERE sy.schoolyear_id = aSchoolYearId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFaculty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFaculty`()
BEGIN

SELECT f.*,fs.*,s.* FROM faculty_mt f
INNER JOIN faculty_specialization fs ON f.faculty_id = fs.faculty_id
INNER JOIN specialization s ON fs.specialization_id = s.specialization_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFacultyAndSpecialization` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFacultyAndSpecialization`()
BEGIN

SELECT f.*,fs.*,s.* FROM faculty_mt f
INNER JOIN faculty_specialization fs ON f.faculty_id = fs.faculty_id
INNER JOIN specialization s ON fs.specialization_id = s.specialization_id
GROUP BY fs.faculty_id
ORDER BY f.lastName;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFacultyById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFacultyById`(aFacultyId INT)
BEGIN

SELECT * FROM faculty_mt WHERE faculty_id = aFacultyId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFacultyByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFacultyByName`(IN pIN_name VARCHAR(150))
BEGIN

SELECT faculty_id, lastName, firstName, middleName, contactNo, email, status 
	FROM faculty_mt WHERE lastName LIKE CONCAT (pIN_name, "%") OR firstName LIKE CONCAT (pIN_name, "%") OR middleName LIKE CONCAT (pIN_name, "%");

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFacultyBySpecializationID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFacultyBySpecializationID`(
f_id INT(11)


)
BEGIN


SELECT f.*,fs.*,s.* FROM faculty_mt f
INNER JOIN faculty_specialization fs ON f.faculty_id = fs.faculty_id
INNER JOIN specialization s ON  fs.specialization_id = s.specialization_id 
WHERE f.faculty_id = f_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFacultyByUserId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFacultyByUserId`(
aUserId INT
)
BEGIN

SELECT * FROM user_faculty uf
LEFT JOIN faculty_mt f ON uf.faculty_id = f.faculty_id
WHERE user_id = aUserId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFacultyId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFacultyId`(
IN pIN_facultyName VARCHAR(150)
)
BEGIN

SELECT faculty_id FROM faculty_mt 
	WHERE CONCAT(firstName, ' ', middleName, '. ', lastName) = 
	pIN_facultyName;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getfacultyIdByEmployeeNo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getfacultyIdByEmployeeNo`(p_facultyEmployeeNo INT)
BEGIN
	SELECT id FROM faculty  
    WHERE employee_id = p_facultyEmployeeNo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFacultyIdByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFacultyIdByName`(
aLastName VARCHAR(255), 
aFirstName VARCHAR(255),
aMiddleName VARCHAR(255)
)
BEGIN

SELECT faculty_id FROM faculty_mt WHERE
lastName = TRIM(aLastName) AND
firstName = TRIM(aFirstName) AND 
middleName = TRIM(aMiddleName);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFacultyIdByUserId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFacultyIdByUserId`(pUserId INT)
BEGIN

SELECT faculty_id FROM user_faculty 
WHERE user_id = pUserId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFacultyInfoById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFacultyInfoById`(IN pIN_facultyId INT)
BEGIN

SELECT lastName, firstName, middleName,
	contactNo, email, status FROM faculty_mt WHERE faculty_mt.faculty_id = pIN_facultyId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeeCategoryById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeeCategoryById`(IN aFeeCategoryId INT)
BEGIN
	SELECT * FROM fee_category_mt WHERE fee_category_id = aFeeCategoryId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeeCategoryByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeeCategoryByName`(aFeeCategoryName VARCHAR(255))
BEGIN

SELECT * FROM fee_category_mt WHERE fee_category = aFeeCategoryName;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeeCategoryId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeeCategoryId`(IN aFeeCategory VARCHAR(255))
BEGIN
	SELECT fee_category_id FROM fee_category_mt WHERE fee_category = aFeeCategory;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeeGradeLevelAssignment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeeGradeLevelAssignment`(aFeeId INT)
BEGIN

SELECT g.* FROM 
fee_schoolyear_lt fslt
INNER JOIN gradelevel_mt g ON fslt.gradelevel_id = g.gradelevel_id
INNER JOIN fee_mt f ON fslt.fee_id = f.fee_id
WHERE f.fee_id = aFeeId
GROUP BY g.grade_level;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeeGradeLevelAssignmentAndAmountById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeeGradeLevelAssignmentAndAmountById`(aFeeId INT)
BEGIN

SELECT g.grade_level, fslt.fee_amount FROM fee_schoolyear_lt fslt
INNER JOIN gradelevel_mt g ON fslt.gradelevel_id = g.gradelevel_id
INNER JOIN fee_mt f ON fslt.fee_id = f.fee_id
WHERE fslt.fee_id = aFeeId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeeId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeeId`(IN aFeeName VARCHAR(255))
BEGIN
	SELECT fee_id FROM fee_mt WHERE fee_name = aFeeName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeeIdByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeeIdByName`(IN aFeeName VARCHAR(255))
BEGIN
	SELECT fee_id FROM fee_mt WHERE fee_name = aFeeName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeeInfoById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeeInfoById`(aFeeId INT)
BEGIN

SELECT 
f1.*, f2.*,
gl.*,
f3.*,
sy.*

FROM fee_mt f1 
INNER JOIN fee_schoolyear_lt f2 ON f1.fee_id = f2.fee_id
INNER JOIN fee_category_mt f3 ON f1.fee_category_id = f3.fee_category_id
INNER JOIN gradelevel_mt gl ON f2.gradelevel_id = gl.gradelevel_id
INNER JOIN schoolyear_mt sy 
WHERE f1.fee_id = aFeeId
GROUP BY f1.fee_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeeInfoByWildcard` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeeInfoByWildcard`(aWildcardChar VARCHAR(255))
BEGIN

SELECT 
f1.*, f2.*,
gl.*,
f3.*,
sy.*

FROM fee_mt f1 
INNER JOIN fee_schoolyear_lt f2 ON f1.fee_id = f2.fee_id
INNER JOIN fee_category_mt f3 ON f1.fee_category_id = f3.fee_category_id
INNER JOIN gradelevel_mt gl ON f2.gradelevel_id = gl.gradelevel_id
INNER JOIN schoolyear_mt sy 
WHERE 
f1.fee_name LIKE CONCAT('%',aWildcardChar,'%') 
GROUP BY f1.fee_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFees` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFees`()
BEGIN

	SELECT
    f.title,f.amount,f.description,ft.feetype,gl.`level`
    FROM fee f 
    INNER JOIN feetype 			ft ON f.feetype_id 		= ft.feetype_id
    INNER JOIN fee_gradelevel 	fg ON f.fee_id 			= fg.fee_id
    INNER JOIN gradelevel 		gl ON fg.gradelevel_id 	= gl.gradelevel_id;
      
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeesByCategory` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeesByCategory`(IN aFeeCategory VARCHAR(255))
BEGIN

SELECT
f1.*, f2.*,
gl.*,
f3.*

FROM fee_mt f1 
INNER JOIN fee_schoolyear_lt f2 ON f1.fee_id = f2.fee_id
INNER JOIN fee_category_mt f3 ON f1.fee_category_id = f3.fee_category_id
INNER JOIN gradelevel_mt gl ON f2.gradelevel_id = gl.gradelevel_id

WHERE f3.fee_category = aFeeCategory;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeesByFeeType` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeesByFeeType`(aFeeTypeId INT)
BEGIN

	SELECT
    f.title,f.amount,f.description,ft.feetype,gl.`level`
    FROM fee f 
    INNER JOIN feetype 			ft ON f.feetype_id 		= ft.feetype_id
    INNER JOIN fee_gradelevel 	fg ON f.fee_id 			= fg.fee_id
    INNER JOIN gradelevel 		gl ON fg.gradelevel_id 	= gl.gradelevel_id
    
    WHERE f.feetype_id = aFeeTypeId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeesByGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeesByGradeLevel`(aGradeLevel INT)
BEGIN

SELECT
f1.*, f2.*,
gl.*,
f3.*

FROM fee_mt f1 
INNER JOIN fee_schoolyear_lt f2 ON f1.fee_id = f2.fee_id
INNER JOIN fee_category_mt f3 ON f1.fee_category_id = f3.fee_category_id
INNER JOIN gradelevel_mt gl ON f2.gradelevel_id = gl.gradelevel_id

WHERE gl.grade_level = aGradeLevel;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeesByGradeLevelAndCategory` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeesByGradeLevelAndCategory`(aGradeLevel INT, aFeeCategory VARCHAR(255))
BEGIN

SELECT
f1.*, f2.*,
gl.*,
f3.*,
sy.*

FROM fee_mt f1 
INNER JOIN fee_schoolyear_lt f2 ON f1.fee_id = f2.fee_id
INNER JOIN fee_category_mt f3 ON f1.fee_category_id = f3.fee_category_id
INNER JOIN gradelevel_mt gl ON f2.gradelevel_id = gl.gradelevel_id
INNER JOIN schoolyear_mt sy ON f2.schoolyear_id = sy.schoolyear_id

WHERE f3.fee_category = aFeeCategory
AND gl.grade_level = aGradeLevel;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeesByGradeLevelAndFeeType` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeesByGradeLevelAndFeeType`(aGradeLevelId INT, aFeeTypeId INT)
BEGIN

	SELECT
    f.title,f.amount,f.description,ft.feetype,gl.`level`
    FROM fee f 
    INNER JOIN feetype 			ft ON f.feetype_id 		= ft.feetype_id
    INNER JOIN fee_gradelevel 	fg ON f.fee_id 			= fg.fee_id
    INNER JOIN gradelevel 		gl ON fg.gradelevel_id 	= gl.gradelevel_id
    
    WHERE fg.gradelevel_id = aGradeLevelId
    AND f.feetype_id = aFeeTypeId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeesByGradeLevelAndType` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeesByGradeLevelAndType`(aGradeLevelId INT, aFeeTypeId INT)
BEGIN

	SELECT
    f.title,f.amount,f.description,ft.feetype,gl.`level`
    FROM fee f 
    INNER JOIN feetype 			ft ON f.feetype_id 		= ft.feetype_id
    INNER JOIN fee_gradelevel 	fg ON f.fee_id 			= fg.fee_id
    INNER JOIN gradelevel 		gl ON fg.gradelevel_id 	= gl.gradelevel_id
    
    WHERE fg.gradelevel_id = aGradeLevelId
    AND f.feetype_id = aFeeTypeId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeesByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeesByGradeLevelId`(gradelevelId INT)
BEGIN

SELECT 
f1.*, f2.*,
gl.*,
f3.*,
sy.*

FROM fee_mt f1 
INNER JOIN fee_schoolyear_lt f2 ON f1.fee_id = f2.fee_id
INNER JOIN fee_category_mt f3 ON f1.fee_category_id = f3.fee_category_id
INNER JOIN gradelevel_mt gl ON f2.gradelevel_id = gl.gradelevel_id
INNER JOIN schoolyear_mt sy
WHERE f2.gradelevel_id = gradeLevelId AND f1.isActive = 1

GROUP BY f1.fee_id
;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeeTypeId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeeTypeId`(aFeeType VARCHAR(50))
BEGIN
	SELECT ft.id FROM feetype ft WHERE ft.feetype = aFeeType;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getFeeTypes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFeeTypes`()
BEGIN
	SELECT * FROM feetype;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getGradeLevelById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getGradeLevelById`(aGradeLevelId INT)
BEGIN

SELECT * FROM gradelevel_mt WHERE gradelevel_id = aGradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getGradeLevelId`(IN aGradeLevel INT)
BEGIN
	SELECT gradelevel_id FROM gradeLevel_mt WHERE `grade_level` = aGradeLevel; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getGradeLevelOfSectionId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getGradeLevelOfSectionId`(IN pIN_sectionId INT)
BEGIN
	
    SELECT gradelevel_mt.grade_level FROM schoolyear_student_lt
	INNER JOIN gradelevel_mt ON gradelevel_mt.gradelevel_id = schoolyear_student_lt.gradelevel_id
	WHERE schoolyear_student_lt.section_id = pIN_sectionId
	AND schoolyear_student_lt.isActive = 1
	GROUP BY schoolyear_student_lt.gradelevel_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getGradeLevelsAssignedToCredentialById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getGradeLevelsAssignedToCredentialById`(aCredentialId INT)
BEGIN

SELECT gl.grade_level,gl.gradelevel_id FROM credentials_mt c
INNER JOIN credential_requirements_lt cr ON c.credential_id
INNER JOIN gradelevel_mt gl ON cr.gradelevel_id = gl.gradelevel_id
INNER JOIN schoolyear_mt sy ON cr.schoolyear_id = sy.schoolyear_id

WHERE cr.credential_id = aCredentialId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getHolidayIdByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getHolidayIdByName`(aHolidayName VARCHAR(255))
BEGIN

SELECT holiday_id FROM holiday_mt WHERE holiday_name = aHolidayName;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getHolidays` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getHolidays`()
BEGIN

SELECT * FROM holiday_mt;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getIdBySessionName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getIdBySessionName`(aSessionName VARCHAR(255))
BEGIN

SELECT session_id FROM session_mt WHERE title = aSessionName;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getNextAvailableORNOforPaymentBySchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getNextAvailableORNOforPaymentBySchoolYearId`(aSchoolYearId INT)
BEGIN

SELECT MIN(or_no) AS ORNO FROM or_no_mt WHERE is_used = 0 AND schoolyear_Id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getOrIdByOrNo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getOrIdByOrNo`(pInOrNo INT)
BEGIN
SELECT or_no_id FROM or_no_mt WHERE or_no = pInOrNo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getParticularsByOrNo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getParticularsByOrNo`(pInOrNo INT)
BEGIN

SELECT 
s.student_id, s.student_no,t.or_no_attached,
b.balancebreakdown_id AS particularId,
b.balancebreakdown_name AS particular,tb.amount_paid AS amountPaid FROM transaction_balancebreakdown tb
INNER JOIN balancebreakdown b ON tb.balancebreakdown_id = b.balancebreakdown_id
INNER JOIN transaction_mt t ON tb.transaction_id = t.transaction_id
INNER JOIN student_mt s ON t.student_id = s.student_id
INNER JOIN admission_mt a ON s.admission_id = a.admission_id
WHERE t.or_no_attached = pInOrNo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getPaymentPeriodDeadline` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPaymentPeriodDeadline`(aPaymentTermId INT, aPeriodId INT, aSchoolYearId INT)
BEGIN

SELECT p.period_id, p.period_code, p.description, pd.deadline
FROM paymentterm_mt pt
INNER JOIN paymentterm_period pp ON pt.paymentterm_id = pp.paymentterm_id
INNER JOIN period p ON pp.period_id = p.period_id
INNER JOIN paymentterm_deadline pd ON p.period_id = pd.period_id
WHERE pd.paymentterm_id = aPaymentTermId 
AND pd.schoolyear_id = aSchoolYearId
AND pd.period_id = aPeriodId
GROUP BY period_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getPaymentTermById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPaymentTermById`(IN aPaymentTermId INT)
BEGIN
	
    SELECT 
pt.paymentterm_id, pt.paymentterm, pt.isActive, pt.divisor,
pp.penalty_id, pp.penalty_amount
 FROM paymentterm_mt pt
LEFT JOIN paymentterm_penalty pp ON pt.paymentterm_id = pp.paymentterm_id

WHERE pt.paymentterm_id = aPaymentTermId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getPaymentTermByPaymentTermId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPaymentTermByPaymentTermId`(aPaymentTermId INT)
BEGIN

SELECT pt.*,pp.penalty_id, pp.schoolyear_id,pp.penalty_amount,pp.isActive AS isPenaltyActive, pp.date_added 
FROM paymentterm_mt pt
LEFT JOIN paymentterm_penalty pp ON pt.paymentterm_id = pp.paymentterm_id

 WHERE pt.paymentterm_id = aPaymentTermId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getPaymentTermIdByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPaymentTermIdByName`(aPaymentTerm VARCHAR(255))
BEGIN
SELECT paymentterm_id FROM paymentterm_mt
WHERE paymentterm_name = aPaymentTerm;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getPaymentTermPenalty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPaymentTermPenalty`()
BEGIN

SELECT * FROM paymentterm_penalty;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getPaymentTermPeriodsByPaymentTermId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPaymentTermPeriodsByPaymentTermId`(
aPaymentTermId INT
)
BEGIN

SELECT ptmt.paymentterm_id, ptmt.paymentterm_name,
ptp.period_id AS ptp_period_id, ptpay.period_id AS ptpay_period_id,
p.period_id ,p.period_code,p.period_name,ptpay.paymentdeadline
FROM paymentterm_mt ptmt 
LEFT JOIN paymentterm_period ptp ON ptmt.paymentterm_id = ptp.paymentterm_id
LEFT JOIN period p ON ptp.period_id = p.period_id
LEFT JOIN paymentterm_period_paymentdeadline ptpay ON ptp.period_id = ptpay.period_id
WHERE ptmt.paymentterm_id = aPaymentTermId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getPenaltyInformationBySchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPenaltyInformationBySchoolYearId`(aSchoolYearId INT)
BEGIN

SELECT ptp.*,sy.*, pt.* FROM paymentterm_penalty ptp
INNER JOIN schoolyear_mt sy ON ptp.schoolyear_id = sy.schoolyear_id
INNER JOIN paymentterm_mt pt ON ptp.paymentterm_id = pt.paymentterm_id
WHERE ptp.schoolyear_id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getPeriodIdByDescription` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPeriodIdByDescription`(aDescription TEXT)
BEGIN

SELECT period_id FROM period WHERE
description = trim(lower(aDescription));

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getRecommendedGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRecommendedGradeLevel`(aStudentId INT)
BEGIN

DECLARE aRecommendedGradeLevel INT;

SELECT 

CASE 
WHEN sslt.passed = 0
THEN gl.grade_level
WHEN sslt.passed = 1
THEN gl.grade_level+1
END AS aRecommendedGradeLevel INTO aRecommendedGradeLevel
FROM schoolyear_student_lt sslt
INNER JOIN gradelevel_mt gl ON sslt.gradelevel_id = gl.gradelevel_id
WHERE sslt.student_id = aStudentId 
ORDER BY gl.grade_level DESC LIMIT 1;

SELECT aRecommendedGradeLevel;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getRegistrationIdByStudentId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRegistrationIdByStudentId`(aStudentId INT)
BEGIN

SELECT r.registration_id AS aRegistrationId
FROM registration_mt r
INNER JOIN student_mt s 
ON r.registration_id = s.registration_id
WHERE 
s.student_id = aStudentId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getRegistrationInfoById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRegistrationInfoById`(IN registrationId INT)
BEGIN

SELECT r.*, 
CASE 
WHEN a.isComplete IS NULL THEN 'No' 
WHEN a.isComplete = 0 THEN 'No'
WHEN a.isComplete = 1 THEN 'Yes' END AS isAdmissionComplete
FROM registration_mt r 
LEFT JOIN admission_mt a ON r.registration_id = a.registration_id
WHERE 
r.registration_id = registrationId;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getReportCardByStudentId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getReportCardByStudentId`(IN pIN_studentId INT)
BEGIN

	SELECT subject_mt.title,
       MAX(IF(g.gradingperiod_id = 7000, g.grade, "")) AS first,
       MAX(IF(g.gradingperiod_id = 7001, g.grade, "")) AS second,
       MAX(IF(g.gradingperiod_id = 7002, g.grade, "")) AS third,
       MAX(IF(g.gradingperiod_id = 7003, g.grade, "")) AS fourth,
       g.final, g.gwa
       
	FROM faculty_schedule

	INNER JOIN schedule_mt ON schedule_mt.schedule_id = faculty_schedule.schedule_id
    INNER JOIN section_student ON section_student.section_id = schedule_mt.section_id
    INNER JOIN subject_mt ON subject_mt.subject_id = schedule_mt.subject_id
    INNER JOIN section_settings_lt ON section_settings_lt.section_id = section_student.section_id
	INNER JOIN curriculum_subject_lt ON curriculum_subject_lt.subject_id = subject_mt.subject_id
    INNER JOIN curriculum_mt ON curriculum_mt.curriculum_id = curriculum_subject_lt.curriculum_id
    LEFT JOIN student_grade AS sg ON sg.student_id = section_student.student_id
    LEFT JOIN grade AS g ON g.grade_id = sg.grade_id
    
    WHERE section_student.student_id = pIN_studentId
    
    GROUP BY subject_mt.title, g.final, g.gwa;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getRoleByUserId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRoleByUserId`(aUserId INT)
BEGIN

SELECT r.* FROM role r
INNER JOIN user_role ur ON r.role_id = ur.role_id
WHERE ur.user_id = aUserId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getRoleIdByRoleName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRoleIdByRoleName`(aRoleName VARCHAR(255))
BEGIN

SELECT role_id FROM role WHERE `role` = aRoleName;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getRoomID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRoomID`(
	p_roomName VARCHAR(45),
    P_buildingName VARCHAR(45),
    p_capacity VARCHAR(45)
)
BEGIN
	SELECT r.room_id FROM room_mt r
    WHERE r.room_name_or_num = p_roomName
    AND r.bldg_name_or_num = p_buildingName
    AND r.capacity = p_capacity;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getRoomIdByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRoomIdByName`(aRoomName VARCHAR(255))
BEGIN

SELECT room_id FROM room_mt WHERE 
room_name_or_num = aRoomName;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getRooms` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRooms`()
BEGIN
	SELECT * FROM room_mt;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getRoomsInfoByID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRoomsInfoByID`(
	p_room_id INT(11)
)
BEGIN
	SELECT * FROM room_mt WHERE room_id = p_room_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getScheduleByFacultyIdAndSchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getScheduleByFacultyIdAndSchoolYearId`(aFacultyId INT, aSchoolYearId INT)
BEGIN

SELECT f.faculty_id,f.lastName, f.firstName, f.middleName,
s.schedule_id,s.schedule_day,s.startTime,s.endTime,
r.room_name_or_num,
sec.sectionName,
sbj.title,
sy.schoolyear_id

FROM faculty_mt f 
INNER JOIN faculty_schedule fs ON f.faculty_id = fs.faculty_id
INNER JOIN schedule_mt s ON fs.schedule_id = s.schedule_id
INNER JOIN room_mt r ON s.room_id = r.room_id
INNER JOIN section_mt sec ON s.section_id = sec.section_id
INNER JOIN subject_mt sbj ON s.subject_id = sbj.subject_id
INNER JOIN schoolyear_mt sy ON s.schoolyear_id = sy.schoolyear_id

WHERE s.schoolyear_id = aSchoolYearId AND
fs.faculty_id = aFacultyId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getScheduleBySectionId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getScheduleBySectionId`(aSectionId INT)
BEGIN

SELECT s.schedule_day,s.startTime,s.endTime,sbj.title,sbj.`code`,r.room_name_or_num FROM schedule_mt s 
INNER JOIN section_mt smt ON s.section_id = smt.section_id
INNER JOIN subject_mt sbj ON s.subject_id = sbj.subject_id
INNER JOIN room_mt r ON s.room_id = r.room_id
WHERE smt.section_id = aSectionId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getScheduleBySubjectId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getScheduleBySubjectId`(aSubjectId INT)
BEGIN

SELECT s.* FROM schedule_mt WHERE subject_id = aSubjectId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSchedulesByDaySchoolYearAndStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSchedulesByDaySchoolYearAndStatus`(
aDay VARCHAR(1), aSchoolYearId INT, aStatus INT
)
BEGIN

SELECT 
sched.schedule_id,
sched.schedule_day, sched.startTime, sched.endTime, 
sched.schoolyear_id, sy.yearFrom, sy.yearTo, sy.isCurrentSchoolYear, sy.isActive,
sched.subject_id, subj.title, subj.`code`, subj.isActive, 
sched.section_id, sec.sectionName, sec.isActive, 
sched.room_id, r.room_name_or_num, r.bldg_name_or_num, r.capacity, r.notes, r.`status`,
sched.gradelevel_id, gl.grade_level, gl.isActive, 
sched.faculty_id, f.lastName, f.firstName, f.middleName, f.contactNo, f.email, f.`status`,
sched.schedule_session,sched.isActive AS schedule_status
FROM schedule_mt sched
LEFT JOIN schoolyear_mt sy ON sched.schoolyear_id = sy.schoolyear_id
LEFT JOIN subject_mt subj ON sched.subject_id = subj.subject_id
LEFT JOIN section_mt sec ON sched.section_id = sec.section_id
LEFT JOIN room_mt r ON sched.room_id = r.room_id
LEFT JOIN gradelevel_mt gl ON sched.gradelevel_id = gl.gradelevel_id
LEFT JOIN faculty_mt f ON sched.faculty_id = f.faculty_id

WHERE
sched.schedule_day = aDay 
AND
sched.schoolyear_id = aSchoolYearId AND sched.isActive = aStatus;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSchedulesByGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSchedulesByGradeLevel`(aGradeLevelId INT)
BEGIN
SELECT 
    cs.startTime, cs.endTime, d.days,
    r.*,s.`name` AS subjectName,
    CONCAT(sy.yearFrom,'-',sy.yearTo) AS schoolYear,
    sec.sectionName,
    gl.`level` AS gradeLevel
    
    FROM classschedule cs
    INNER JOIN classschedule_hd cshd ON cs.id = cshd.classschedule_id
    INNER JOIN classschedule_section css ON cs.id = css.classschedule_id
    INNER JOIN daysofweek d ON cs.dayOfWeek_id = d.id
    INNER JOIN room r ON cs.room_id = r.id
    INNER JOIN `subjects` s ON cs.subject_id = s.id
    INNER JOIN gradelevel gl ON css.gradelevel_id = gl.id
    INNER JOIN section sec ON css.section_id = sec.id
    INNER JOIN schoolyear sy ON css.schoolyear_id = sy.id
    
    WHERE css.gradelevel_id = aGradeLevelId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSchedulesByWildCardSchoolYearIdAndStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSchedulesByWildCardSchoolYearIdAndStatus`(
aWildCardChar VARCHAR(255), 
aSchoolYearId INT, 
aStatus INT
)
BEGIN

SELECT 
sched.schedule_id,
sched.schedule_day, sched.startTime, sched.endTime, 
sched.schoolyear_id, sy.yearFrom, sy.yearTo, sy.isCurrentSchoolYear, sy.isActive,
sched.subject_id, subj.title, subj.`code`, subj.isActive, 
sched.section_id, sec.sectionName, sec.isActive, 
sched.room_id, r.room_name_or_num, r.bldg_name_or_num, r.capacity, r.notes, r.`status`,
sched.gradelevel_id, gl.grade_level, gl.isActive, 
sched.faculty_id, f.lastName, f.firstName, f.middleName, f.contactNo, f.email, f.`status`,
sched.schedule_session,sched.isActive AS schedule_status
FROM schedule_mt sched
LEFT JOIN schoolyear_mt sy ON sched.schoolyear_id = sy.schoolyear_id
LEFT JOIN subject_mt subj ON sched.subject_id = subj.subject_id
LEFT JOIN section_mt sec ON sched.section_id = sec.section_id
LEFT JOIN room_mt r ON sched.room_id = r.room_id
LEFT JOIN gradelevel_mt gl ON sched.gradelevel_id = gl.gradelevel_id
LEFT JOIN faculty_mt f ON sched.faculty_id = f.faculty_id

WHERE
sched.schedule_day LIKE CONCAT('%',aWildCardChar,'%') OR
sec.sectionName LIKE CONCAT('%',aWildCardChar,'%') OR 
subj.title LIKE CONCAT('%',aWildCardChar,'%') OR
subj.`code` LIKE CONCAT('%',aWildCardChar,'%') OR 
gl.grade_level LIKE CONCAT('%',aWildCardChar,'%') OR
f.lastName LIKE CONCAT('%',aWildCardChar,'%') OR
f.firstName LIKE CONCAT('%',aWildCardChar,'%') OR
f.middleName LIKE CONCAT('%',aWildCardChar,'%')
AND
sched.schoolyear_id = aSchoolYearId AND sched.isActive = aStatus;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSchoolFeesSum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSchoolFeesSum`(aGradeLevelId INT)
BEGIN

SELECT SUM(fslt.fee_amount) AS sumOfFees
FROM fee_schoolyear_lt fslt
INNER JOIN fee_mt fmt ON fslt.fee_id = fmt.fee_id 
WHERE fmt.fee_name <> 'Downpayment' AND
fslt.gradelevel_id = aGradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSchoolYearById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSchoolYearById`(schoolYearId INT)
BEGIN

SELECT sy.*,
(SELECT start_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 1) AS Q1Start,
(SELECT end_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 1) AS Q1End ,
(SELECT grading_due_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 1) AS Q1GradingDueDate ,
(SELECT start_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 2) AS Q2Start ,
(SELECT end_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 2) AS Q2End ,
(SELECT grading_due_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 2) AS Q2GradingDueDate ,
(SELECT start_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 3) AS Q3Start ,
(SELECT end_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 3) AS Q3End,
(SELECT grading_due_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 3) AS Q3GradingDueDate ,
(SELECT start_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 4) AS Q4Start ,
(SELECT end_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 4) AS Q4End,
(SELECT grading_due_date FROM schoolyear_quarter_lt WHERE schoolyear_id = sy.schoolyear_id AND quarter_no = 4) AS Q4GradingDueDate      
FROM
schoolyear_mt sy
INNER JOIN schoolyear_quarter_lt syq ON sy.schoolyear_id = syq.schoolyear_id
WHERE sy.schoolyear_id = schoolYearId
GROUP BY sy.schoolyear_id ORDER BY sy.yearFrom ASC;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSchoolYearId`(IN aYearFrom INT, aYearTo INT)
BEGIN
	SELECT schoolyear_id FROM schoolyear_mt 
    WHERE 	yearFrom = aYearFrom  AND
			yearTo = aYearTo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSchoolYearIdByYearFrom` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSchoolYearIdByYearFrom`(IN aSchoolYearFrom INT)
BEGIN
	SELECT schoolyear_id FROM schoolyear_mt WHERE yearFrom = aSchoolYearFrom;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSchoolYearsWithPenalty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSchoolYearsWithPenalty`()
BEGIN

SELECT sy.* FROM paymentterm_penalty ptp
INNER JOIN schoolyear_mt sy ON ptp.schoolyear_id = sy.schoolyear_id
GROUP BY yearFrom, ptp.schoolyear_id ASC;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionAverageBySectionId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionAverageBySectionId`(IN pIN_sectionId INT)
BEGIN 

	SELECT requiredAverage FROM section_settings_lt
	WHERE section_settings_lt.section_id = pIN_sectionId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionByGradeLevelId`(aGradeLevelId INT)
BEGIN

	SELECT s.sectionName
    FROM section s
    INNER JOIN section_gradelevel sg ON s.section_id = sg.sectionId
    INNER JOIN gradelevel g ON sg.gradelevelId = g.gradelevel_id
    WHERE sg.gradelevelId = aGradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionById`(sectionId INT)
BEGIN

SELECT s.*,sy.yearFrom,g.grade_level,sslt.`session`,sslt.capacity,
f.faculty_id,f.lastName,f.firstName,f.middleName
FROM section_mt s
INNER JOIN section_settings_lt sslt ON s.section_id = sslt.section_id
INNER JOIN faculty_mt f ON sslt.adviser_id = f.faculty_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id
INNER JOIN gradelevel_mt g ON sslt.gradelevel_id = g.gradelevel_id
WHERE s.section_id = sectionId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionByStudentId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionByStudentId`(aStudentId INT)
BEGIN

SELECT s.* FROM section_mt s
INNER JOIN section_student ss ON s.section_id = ss.section_id
WHERE student_id = aStudentId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionCapacity` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionCapacity`(IN pIN_sectionName VARCHAR(150))
BEGIN
	SELECT capacity FROM section_settings_lt 
    INNER JOIN section_mt ON section_mt.section_id = section_settings_lt.section_id
    WHERE section_mt.sectionName = pIN_sectionName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionId`(aSectionName VARCHAR(50))
BEGIN
	SELECT s.section_id FROM section_mt s WHERE s.sectionName = aSectionName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionIdByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionIdByName`(IN pIN_sectionName VARCHAR(150))
BEGIN
	
    SELECT section_id FROM section_mt WHERE sectionName = pIN_sectionName;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionsByGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionsByGradeLevel`(aGradeLevelId INT)
BEGIN

SELECT 
s.section_id,
s.sectionName,
s.isActive,
sslt.session_id,
ss.title,
sslt.capacity,
sslt.schoolyear_id,
sy.yearFrom,
sy.yearTo,
sslt.gradelevel_id,
gl.grade_level 
FROM section_mt s
INNER JOIN schoolyear_section_lt sslt ON s.section_id = sslt.section_id
INNER JOIN session_mt ss ON sslt.session_id = ss.session_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id
INNER JOIN gradelevel_mt gl ON sslt.gradelevel_id = gl.gradelevel_id
WHERE sslt.gradelevel_id = aGradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionsByGradeLevelNo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionsByGradeLevelNo`(gradeLevelNo INT)
BEGIN

SELECT s.*,sy.yearFrom,g.grade_level,sslt.`session`,sslt.capacity,
f.faculty_id,f.lastName,f.firstName,f.middleName
FROM section_mt s
INNER JOIN section_settings_lt sslt ON s.section_id = sslt.section_id
INNER JOIN faculty_mt f ON sslt.adviser_id = f.faculty_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id
INNER JOIN gradelevel_mt g ON sslt.gradelevel_id = g.gradelevel_id
WHERE g.grade_level = gradeLevelNo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionsByGradeLevelNoAndSchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionsByGradeLevelNoAndSchoolYearId`(gradeLevelNo INT, aSchoolYearId INT)
BEGIN

SELECT s.*,sy.yearFrom,g.grade_level,sslt.`session`,sslt.capacity,
f.faculty_id,f.lastName,f.firstName,f.middleName
FROM section_mt s
INNER JOIN section_settings_lt sslt ON s.section_id = sslt.section_id
INNER JOIN faculty_mt f ON sslt.adviser_id = f.faculty_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id
INNER JOIN gradelevel_mt g ON sslt.gradelevel_id = g.gradelevel_id
WHERE g.grade_level = gradeLevelNo AND sslt.schoolyear_id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionsBySchoolYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionsBySchoolYear`(aSchoolYearId INT)
BEGIN

SELECT 
s.section_id,
s.sectionName,
s.isActive,
sslt.session_id,
ss.title,
sslt.capacity,
sslt.schoolyear_id,
sy.yearFrom,
sy.yearTo,
sslt.gradelevel_id,
gl.grade_level 
FROM section_mt s
INNER JOIN schoolyear_section_lt sslt ON s.section_id = sslt.section_id
INNER JOIN session_mt ss ON sslt.session_id = ss.session_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id
INNER JOIN gradelevel_mt gl ON sslt.gradelevel_id = gl.gradelevel_id
WHERE sslt.schoolyear_id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionsBySchoolYearAndGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionsBySchoolYearAndGradeLevel`(aSchoolYearId INT, aGradeLevelId INT)
BEGIN

SELECT 
s.section_id,
s.sectionName,
s.isActive,
sslt.session_id,
ss.title,
sslt.capacity,
sslt.schoolyear_id,
sy.yearFrom,
sy.yearTo,
sslt.gradelevel_id,
gl.grade_level 
FROM section_mt s
INNER JOIN schoolyear_section_lt sslt ON s.section_id = sslt.section_id
INNER JOIN session_mt ss ON sslt.session_id = ss.session_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id
INNER JOIN gradelevel_mt gl ON sslt.gradelevel_id = gl.gradelevel_id
WHERE 
sslt.schoolyear_id = aSchoolYearId
AND
sslt.gradelevel_id = aGradeLevelId ;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionsByWildCard` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionsByWildCard`(wildCardChar VARCHAR(255))
BEGIN

SELECT s.*,sy.yearFrom,g.grade_level,sslt.`session`,sslt.capacity,
f.faculty_id,f.lastName,f.firstName,f.middleName
FROM section_mt s
INNER JOIN section_settings_lt sslt ON s.section_id = sslt.section_id
INNER JOIN faculty_mt f ON sslt.adviser_id = f.faculty_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id
INNER JOIN gradelevel_mt g ON sslt.gradelevel_id = g.gradelevel_id
WHERE 
s.section_id LIKE CONCAT('%',wildCardChar,'%') OR
s.sectionName LIKE CONCAT('%',wildCardChar,'%') OR 
sy.yearFrom = wildCardChar OR 
sslt.`session` = wildCardChar;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionSchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionSchoolYearId`(IN pIN_sectionName VARCHAR(150))
BEGIN
	
    SELECT section_settings_lt.schoolyear_id FROM section_mt
		INNER JOIN section_settings_lt ON section_settings_lt.section_id = section_mt.section_id
			WHERE section_mt.sectionName = pIN_sectionName;
    

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionsHandledByFacultyUsingFacultyIdAndSyId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionsHandledByFacultyUsingFacultyIdAndSyId`(
aFacultyId INT, aSchoolYearId INT
)
BEGIN

SELECT sslt.*,g.*, smt.section_id,s.sectionName, s.isActive,s.date_created FROM 
schedule_mt smt LEFT JOIN section_mt s ON smt.section_id = s.section_id
LEFT JOIN section_settings_lt sslt ON s.section_id = sslt.section_id 
LEFT JOIN gradelevel_mt g ON sslt.gradelevel_id = g.gradelevel_id

WHERE smt.faculty_id = aFacultyId AND smt.schoolyear_id = aSchoolYearId
GROUP BY smt.section_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionStudents` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionStudents`(aSectionId VARCHAR(255), aSchoolYearId INT)
BEGIN
	SELECT std.*
    from
    section_student ss 
    INNER JOIN section s ON ss.section_id = s.section_id
    INNER JOIN students std ON ss.student_id = std.student_id
    INNER JOIN schoolyear sy ON ss.schoolyear_id = sy.id
    
    WHERE ss.section_id = aSectionId
    AND   ss.schoolyear_id = aSchoolYearId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionStudentsBySectionIdAndSchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionStudentsBySectionIdAndSchoolYearId`(aSectionId INT, aSchoolYearId INT)
BEGIN

SELECT 
s.*,smt.section_id, r.*,
smt.sectionName,
ss.schoolyear_id,
s.student_type as finalStudentType, 
g.grade_level as currentGradeLevel 
FROM student_mt s
INNER JOIN schoolyear_student_lt sslt ON s.student_id = sslt.student_id
INNER JOIN gradelevel_mt g ON sslt.gradelevel_id = g.gradelevel_id 
INNER JOIN admission_mt a ON s.admission_id = a.admission_id
INNER JOIN registration_mt r ON a.registration_id = r.registration_id
INNER JOIN section_student ss ON s.student_id = ss.student_id
INNER JOIN section_mt smt ON ss.section_id = smt.section_id
WHERE ss.section_id = aSectionId 
AND ss.schoolyear_id = aSchoolYearId 
AND sslt.isActiveGradeLevelAndSchoolYear = 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionsWithNoAssignedScheduleBySchoolYearIdGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionsWithNoAssignedScheduleBySchoolYearIdGradeLevelId`(
aStatus INT, aSchoolYearId INT, aGradeLevelId INT
)
BEGIN

SELECT s.*,sslt.`session` FROM section_mt s
INNER JOIN section_settings_lt sslt ON s.section_id = sslt.section_id
WHERE s.section_id 
NOT IN 
(SELECT smt.section_id FROM schedule_mt smt WHERE smt.schoolyear_id = aSchoolYearId)
AND s.isActive = aStatus AND sslt.schoolyear_id = aSchoolYearId AND sslt.gradelevel_id = aGradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSectionsWithNoAssignedScheduleByStatusAndSchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSectionsWithNoAssignedScheduleByStatusAndSchoolYearId`(
aIsActive INT(1), aSchoolYearId INT
)
BEGIN

SELECT s.*,sslt.`session` FROM section_mt s
INNER JOIN section_settings_lt sslt ON s.section_id = sslt.section_id
WHERE s.section_id 
NOT IN 
(SELECT smt.section_id FROM schedule_mt smt WHERE smt.schoolyear_id = aSchoolYearId)
AND s.isActive = aIsActive 
AND sslt.schoolyear_id = aSchoolYearId; 

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSessionId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSessionId`(aSessionType VARCHAR(11))
BEGIN
	SELECT id FROM `session` WHERE title = aSessionType;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSessionIdBySectionId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSessionIdBySectionId`(IN pIN_sectionId INT)
BEGIN

	SELECT session_mt.session_id
	FROM section_settings_lt
	INNER JOIN session_mt ON session_mt.session_id = section_settings_lt.session_id
	WHERE section_settings_lt.section_id = pIN_sectionId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSessions` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSessions`()
BEGIN

SELECT title FROM session_mt;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSpecializationById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSpecializationById`(
	IN s_id int
)
BEGIN
	SELECT * FROM specialization WHERE specialization_id = s_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSpecializationId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSpecializationId`(
	IN p_title VARCHAR(45)
 )
BEGIN

SELECT S.specialization_id FROM specialization S
WHERE specialization_title = p_title;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSpecializationIdByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSpecializationIdByName`(aSpecializationName VARCHAR(255))
BEGIN

SELECT * FROM specialization WHERE specialization_title = aSpecializationName;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStudentByStudentId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentByStudentId`()
BEGIN

SELECT 
r.*,a.admission_id,
a.isComplete AS isAdmissionComplete,
s.student_id,s.student_no,s.isActive AS isStudentActive,s.student_type AS finalStudentType,
g.grade_level AS currentGradeLevel
FROM registration_mt r
LEFT JOIN admission_mt a ON r.registration_id = a.registration_id
LEFT JOIN student_mt s ON a.admission_id = s.admission_id
LEFT JOIN schoolyear_student_lt ss ON s.student_id = ss.student_id
LEFT JOIN gradelevel_mt g ON ss.gradelevel_id = g.gradelevel_id

WHERE s.student_no = aStudentNo 
AND ss.isActiveGradeLevelAndSchoolYear = 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStudentByStudentNo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentByStudentNo`(aStudentNo INT)
BEGIN

SELECT 
r.*,a.admission_id,
a.isComplete AS isAdmissionComplete,
s.student_id,s.student_no,s.isActive AS isStudentActive,s.student_type AS finalStudentType,
g.grade_level AS currentGradeLevel
FROM registration_mt r
LEFT JOIN admission_mt a ON r.registration_id = a.registration_id
LEFT JOIN student_mt s ON a.admission_id = s.admission_id
LEFT JOIN schoolyear_student_lt ss ON s.student_id = ss.student_id
LEFT JOIN gradelevel_mt g ON ss.gradelevel_id = g.gradelevel_id

WHERE s.student_no = aStudentNo 
AND ss.isActiveGradeLevelAndSchoolYear = 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSubjectCategoryAssignedSubjectsById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSubjectCategoryAssignedSubjectsById`(aSubjectCategoryId INT)
BEGIN

SELECT scs.subjectcategory_id, s.*
FROM subject_mt s 
INNER JOIN subjectcategory_subject scs ON s.subject_id = scs.subject_id
WHERE scs.subjectcategory_id = aSubjectCategoryId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSubjectId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSubjectId`(IN p_subjectCode VARCHAR(20))
BEGIN
	SELECT s.subject_id FROM subjects s
    WHERE s.`code` = p_subjectCode;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSubjectIdByCode` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSubjectIdByCode`(IN p_subjectCode VARCHAR(20))
BEGIN
	SELECT s.subject_id FROM subject_mt s
    WHERE s.`code` = p_subjectCode;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSubjectIdByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSubjectIdByName`(IN aSubjectName VARCHAR(255))
BEGIN
SELECT s.subject_id FROM subject_mt s WHERE 
title = aSubjectName;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSubjectInfoById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSubjectInfoById`(aSubjectId INT)
BEGIN

SELECT 
    s.subject_id, s.title, s.`code`, s.description, s.isActive, g.grade_level 
    FROM subject_gradelevel_lt sglt
	INNER JOIN subject_mt s ON sglt.subject_id = s.subject_id
    INNER JOIN gradelevel_mt g ON sglt.gradelevel_id = g.gradelevel_id
    WHERE s.subject_id = aSubjectId
    ORDER BY g.grade_level ASC;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSubjectInfoByWildCard` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSubjectInfoByWildCard`(aWildCardChar VARCHAR(255))
BEGIN

   SELECT
	s.subject_id, s.title, s.`code`, s.description, s.isActive, g.grade_level 
    FROM subject_gradelevel_lt sglt
	INNER JOIN subject_mt s ON sglt.subject_id = s.subject_id
    INNER JOIN gradelevel_mt g ON sglt.gradelevel_id = g.gradelevel_id
    WHERE 
    s.title LIKE CONCAT('%',aWildCardChar,'%') OR
    s.subject_id LIKE CONCAT('%',aWildCardChar,'%') OR 
    s.`code` LIKE CONCAT('%',aWildCardChar,'%')
    ORDER BY g.grade_level ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSubjectsByGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSubjectsByGradeLevel`(IN p_gradeLevelId INT)
BEGIN

SELECT 
s.`code`, 
s.`name`, 
s.units, 
s.description,
gl.`level` 
 
FROM 		subjects 				s 
INNER JOIN 	subjects_gradelevel 	sgl 	ON s.subjects_id = sgl.subjectId
INNER JOIN	gradelevel 				gl	 	ON sgl.gradeLevelId = gl.gradelevel_id

WHERE sgl.gradeLevelId = p_gradeLevelId;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getTransactionInfoByOrNo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getTransactionInfoByOrNo`(pInOrNo INT)
BEGIN

SELECT
t.student_id,
t.amount_received, t.amount_charged, 
(t.amount_received - t.amount_charged) AS change_amount, date_charged,t.or_no_attached,
o.schoolyear_id, sy.yearFrom, sy.yearTo
FROM transaction_mt t 
INNER JOIN or_no_mt o ON t.or_no_attached = o.or_no
LEFT JOIN schoolyear_mt sy ON o.schoolyear_id = sy.schoolyear_id
WHERE t.or_no_attached = pInOrNo
GROUP BY t.or_no_attached;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getTuitionByStudentIdAndSchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getTuitionByStudentIdAndSchoolYearId`(aStudentId INT, aSchoolYearId INT)
BEGIN
SELECT 
bb.student_id, bb.schoolyear_id,bb.balancebreakdown_id,
bb.balancebreakdown_name,bb.balancebreakdown_amount, bb.category,bb.due_date,
tb.amount_paid,

CASE WHEN 
(SELECT SUM(ibb.balancebreakdown_amount) FROM balancebreakdown ibb WHERE ibb.balancebreakdown_id = bb.balancebreakdown_id) -
(SELECT SUM(itb.amount_paid) FROM transaction_balancebreakdown itb WHERE itb.balancebreakdown_id = bb.balancebreakdown_id) 
IS NULL THEN (SELECT SUM(ibb.balancebreakdown_amount) FROM balancebreakdown ibb WHERE ibb.balancebreakdown_id = bb.balancebreakdown_id)
ELSE (SELECT SUM(ibb.balancebreakdown_amount) FROM balancebreakdown ibb WHERE ibb.balancebreakdown_id = bb.balancebreakdown_id) -
(SELECT SUM(itb.amount_paid) FROM transaction_balancebreakdown itb WHERE itb.balancebreakdown_id = bb.balancebreakdown_id)
END AS balance,

CASE WHEN
(SELECT SUM(ibb.balancebreakdown_amount) FROM balancebreakdown ibb WHERE ibb.balancebreakdown_id = bb.balancebreakdown_id) -
(SELECT SUM(itb.amount_paid) FROM transaction_balancebreakdown itb WHERE itb.balancebreakdown_id = bb.balancebreakdown_id)
 = 0 THEN 1 
 WHEN (SELECT SUM(ibb.balancebreakdown_amount) FROM balancebreakdown ibb WHERE ibb.balancebreakdown_id = bb.balancebreakdown_id) -
(SELECT SUM(itb.amount_paid) FROM transaction_balancebreakdown itb WHERE itb.balancebreakdown_id = bb.balancebreakdown_id)
IS NULL THEN 0 END AS isPaid
,

CASE WHEN bb.due_date < DATE(NOW()) THEN 1 ELSE 0 END AS hasPenalty,
CASE WHEN DATE(NOW()) > bb.due_date THEN 1 ELSE 0 END AS isPastDueDate,

CASE WHEN 
(SELECT SUM(itb.amount_paid) FROM transaction_balancebreakdown itb WHERE itb.balancebreakdown_id = bb.balancebreakdown_id)
IS null THEN 0.00 ELSE 
(SELECT SUM(itb.amount_paid) FROM transaction_balancebreakdown itb WHERE itb.balancebreakdown_id = bb.balancebreakdown_id)
END AS totalPaid

FROM balancebreakdown bb 
LEFT JOIN transaction_balancebreakdown tb ON bb.balancebreakdown_id = bb.balancebreakdown_id
LEFT JOIN transaction_mt t ON tb.transaction_id = t.transaction_id
WHERE bb.student_id = aStudentId and bb.schoolyear_id = aSchoolYearId

GROUP BY bb.balancebreakdown_id;

 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getTuitionPaymentTermByStudentIdAndSchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getTuitionPaymentTermByStudentIdAndSchoolYearId`(
aStudentId INT, aSchoolYearId INT
)
BEGIN

SELECT p.paymentterm_id,p.paymentterm_name, p.isPaymentTermActive, p.divisor FROM balancebreakdown bb 
INNER JOIN paymentterm_mt p ON bb.paymentterm_id = p.paymentterm_id
WHERE bb.student_id = aStudentId AND schoolyear_id = aSchoolYearId
group by p.paymentterm_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getTuitionTotalPaidAndRemainingBalance` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getTuitionTotalPaidAndRemainingBalance`(
aStudentId INT, aSchoolYearId INT
)
BEGIN

SELECT SUM(b.balancebreakdown_amount) AS totalFees, 

CASE WHEN SUM(t.amount_charged) IS NULL THEN 0.00 
ELSE SUM(t.amount_charged) END AS totalPaid,

CASE WHEN
SUM(b.balancebreakdown_amount) - SUM(t.amount_charged) IS NULL THEN SUM(b.balancebreakdown_amount)
ELSE SUM(b.balancebreakdown_amount) - SUM(t.amount_charged) END AS remainingBalance

FROM balancebreakdown b 
LEFT JOIN transaction_balancebreakdown tb ON b.balancebreakdown_id = tb.balancebreakdown_id
LEFT JOIN transaction_mt t ON tb.transaction_id = t.transaction_id
WHERE b.student_id = aStudentId AND b.schoolyear_id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getUserById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserById`(aUserId INT)
BEGIN

SELECT * FROM user_mt WHERE user_id = aUserId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getUserCompleteName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserCompleteName`(aUserName VARCHAR(20))
BEGIN
 SELECT CONCAT(u.firstname,' ',u.lastname) AS completeName
 FROM user_mt u WHERE u.username = aUserName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getUserId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserId`(IN p_userName VARCHAR(10))
BEGIN
	SELECT id FROM user_mt WHERE username = p_userName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getUserIdByUserName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserIdByUserName`(aUserName VARCHAR(255))
BEGIN
SELECT user_id FROM user_mt WHERE username = aUserName;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getUserLastLogin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserLastLogin`(IN p_username varchar(50))
BEGIN
	SELECT lastLoginDate FROM users WHERE username = p_username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getUsernameByLastName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUsernameByLastName`(IN p_lastName varchar(50))
BEGIN
	select username from users where lastname = lower(p_lastname);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `hasTuitionRecord` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `hasTuitionRecord`(aStudentNo INT, aSchoolYearId INT)
BEGIN

SELECT CASE WHEN COUNT(*) <= 0
THEN FALSE 
ELSE TRUE 
END AS hasTuition
FROM balancebreakdown bb
INNER JOIN student_mt s ON bb.student_id = s.student_id
WHERE s.student_no = aStudentNo
AND bb.schoolyear_id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `isGradeLevelActive` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `isGradeLevelActive`(IN aGradeLevel INT)
BEGIN
	SELECT isActive FROM gradelevel_mt
    WHERE grade_level = aGradeLevel;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `isUserActive` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `isUserActive`(IN p_username varchar(50), OUT p_boolIsActive INT)
BEGIN

	SELECT isActive INTO p_boolIsActive
    FROM users
    WHERE username = lower(p_username);
    
    SELECT p_boolIsActive;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `isUserLocked` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `isUserLocked`(IN p_username varchar(20), OUT p_boolIsLocked SMALLINT)
BEGIN
	SELECT isLocked INTO p_boolIsLocked
    FROM users 
    WHERE username = lower(p_username);
    
    SELECT p_boolIsLocked;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `loadFacultySpecialization` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadFacultySpecialization`(IN pIN_facultyId INT)
BEGIN

SELECT subjectcategory_mt.subjectcategory_id, subjectcategory_mt.subjectcategory_name, subjectcategory_mt.description, subjectcategory_mt.isActive FROM faculty_specialization
	INNER JOIN subjectcategory_mt ON subjectcategory_mt.subjectcategory_id = faculty_specialization.specialization_id
	INNER JOIN faculty_mt ON faculty_mt.faculty_id = faculty_specialization.faculty_id
	WHERE faculty_mt.faculty_id = pIN_facultyId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `markOrNoAsUsed` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `markOrNoAsUsed`(pInOrNo INT)
BEGIN

UPDATE or_no_mt SET is_used = 1 WHERE or_no = pInOrNo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `promoteStudentById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `promoteStudentById`(
IN pIN_schoolyearId INT,
IN pIN_studentId INT,
IN pIN_gradeLevelId INT,
IN pIN_setIsPassed BOOLEAN
)
BEGIN
 
 	
    START TRANSACTION;
    
    IF (pIN_setIsPassed = TRUE) THEN
    
		UPDATE schoolyear_student_lt 
		SET passed = 1, isActive = 0
		WHERE schoolyear_id = pIN_schoolyearId
		AND student_id = pIN_studentId
		AND gradelevel_id = pIN_gradeLevelId;
        
        UPDATE section_student
        SET isActive = 0
        WHERE schoolyear_id = pIN_schoolyearId
        AND student_id = pIN_studentId;
		
        UPDATE student_grade
        SET isActive = 0
        WHERE student_id = pIN_studentId;
        
		INSERT INTO schoolyear_student_lt (schoolyear_id, student_id, gradelevel_id, passed, isActive)
		VALUES (pIN_schoolyearId, pIN_studentId, pIN_gradeLevelId + 1, null, true);
    
    ELSE
		
        UPDATE schoolyear_student_lt 
		SET passed = 0, isActive = 1
		WHERE schoolyear_id = pIN_schoolyearId
		AND student_id = pIN_studentId
		AND gradelevel_id = pIN_gradeLevelId;
        
    END IF;
    
	
    
	COMMIT;
 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrationExists` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrationExists`(aStudentId INT)
BEGIN

SELECT 
CASE WHEN COUNT(*) > 0 THEN TRUE
WHEN COUNT(*) <= 0 THEN FALSE
END AS registrationExists

FROM student_mt 
WHERE student_id = aStudentId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `removeAllSubjectCategoryAssignedSubjects` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `removeAllSubjectCategoryAssignedSubjects`(subjectCategoryId INT)
BEGIN

DELETE FROM subjectcategory_subject 
WHERE subjectcategory_id = subjectCategoryId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `removeCredentialById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `removeCredentialById`(aCredentialId INT)
BEGIN

DECLARE EXIT HANDLER FOR sqlexception
BEGIN
	ROLLBACK;
	RESIGNAL;
END;

START TRANSACTION;

DELETE FROM credential_requirements_lt WHERE credential_id >= aCredentialId;
DELETE FROM credentials_received_lt WHERE credential_id >= aCredentialId;
DELETE FROM credentials_mt WHERE credential_id >= aCredentialId;

COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `removeCurriculumSubjectsById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `removeCurriculumSubjectsById`(curriculumId INT)
BEGIN

DELETE FROM curriculum_subject_lt
WHERE curriculum_id = curriculumId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `removeStudentsFromSectionBySectionIdandSchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `removeStudentsFromSectionBySectionIdandSchoolYearId`(
aSectionId INT, aSchoolYearId INT
)
BEGIN

DELETE FROM section_student WHERE section_id = aSectionId AND 
schoolyear_id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sampleStoredProc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sampleStoredProc`()
BEGIN

-- SELECT * FROM
-- SELECT * FROM
-- SELECT * FROM
-- SELECT * FROM
-- SELECT * FROM
-- SELECT * FROM
-- SELECT * FROM-- SELECT * FROM
-- SELECT * FROM-- SELECT * FROM-- SELECT * FROM-- SELECT * FROM-- SELECT * FROM 

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sectionExists` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sectionExists`(aSectionName VARCHAR(255))
BEGIN

DECLARE countOfRecord INT;
DECLARE sectionExists BOOLEAN;

SELECT COUNT(*) INTO countOfRecord FROM section_mt WHERE 
sectionName = TRIM(aSectionName);

IF countOfRecord > 1
THEN SELECT TRUE INTO sectionExists;
ELSE SELECT FALSE INTO sectionExists;
END IF;

SELECT sectionExists;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sectionhasSchedule` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sectionhasSchedule`(aSectionId INT, aSchoolYearId INT)
BEGIN

DECLARE recordCount INT;

SELECT COUNT(*) INTO recordCount
FROM schedule_mt WHERE section_id = aSectionId
AND schoolyear_id = aSchoolYearId;

SELECT recordCount;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `setAdmissionGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `setAdmissionGradeLevel`(aGradeLevelId INT, aRegistrationId INT)
BEGIN

UPDATE registration_mt r 
SET r.gradelevel_id = aGradeLevelId 
WHERE r.registration_id = aRegistrationId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `setAllStudentsInactive` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `setAllStudentsInactive`()
BEGIN

DECLARE EXIT HANDLER FOR sqlexception
	BEGIN
		ROLLBACK;
		RESIGNAL;
	END;

START TRANSACTION;

 
IF (  SELECT COUNT(sy.schoolyear_id) 
		FROM schoolyear_mt sy 
		WHERE CURDATE() >= sy.start_date AND 
		CURDATE() <= sy.end_date) = 0 
THEN 
		SELECT 'CURDATE() is not within any schoolyear'; 
        IF(SELECT COUNT(s.schoolyear_id)
			FROM schoolyear_mt s
			WHERE CURDATE() > s.end_date) > 0
		THEN
			UPDATE enrollment_student_lt SET isEarlyEnrollment = 0;
			UPDATE student_mt SET isActive = 0;
            SELECT 'CURDATE() greater than s.end_date';
		END IF;
		 
        IF  (SELECT COUNT(s.schoolyear_id)
			 FROM schoolyear_mt s
			 WHERE CURDATE() < s.start_date) > 0
        THEN 
			UPDATE student_mt SET isActive = 0;
            SELECT 'CURDATE() less than s.start_date';
		END IF;
    
END IF;


COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `setCurrentSchoolYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `setCurrentSchoolYear`()
BEGIN

DECLARE aCurDateSyId INT;

DECLARE EXIT HANDLER FOR sqlexception
	BEGIN
		ROLLBACK;
		RESIGNAL;
	END;

START TRANSACTION;
	
    
	SELECT schoolyear_id INTO aCurDateSyId FROM schoolyear_mt
    WHERE curdate() >= start_date AND curdate() <= end_date;
    
    IF aCurDateSyId IS NOT NULL 
    THEN
		UPDATE schoolyear_mt SET isCurrentSchoolYear = 0 
        WHERE schoolyear_id != aCurDateSyId;
        
        UPDATE schoolyear_mt SET isActive = 0 
        WHERE schoolyear_id != aCurDateSyId; 
			
		UPDATE schoolyear_mt SET isCurrentSchoolYear = 1
		WHERE schoolyear_id = aCurDateSyId;
	ELSEIF aCurDateSyId IS NULL
    THEN
		SELECT 'CURRENT DATE is NOT part of any schoolyear';
        UPDATE schoolyear_mt SET isCurrentSchoolYear = 0;
	END IF;
    
COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `setPaymentTermDownPayment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `setPaymentTermDownPayment`(aPaymentTermId INT, aDownPaymentAmount DECIMAL, aSchoolYearId INT)
BEGIN
	DECLARE myPaymentTermDownPaymentId INT;
	DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
        RESIGNAL;
    END;

	START transaction;
	INSERT INTO paymentterm_downpayment(paymentterm_id, downpayment)
	VALUES(aPaymentTermId, aDownPaymentAmount);
    SELECT LAST_INSERT_ID() INTO myPaymentTermDownPaymentId;
    
    INSERT INTO paymentterm_downpayment_schoolyear(paymentterm_downpayment_id, schoolyear_id)
    VALUES(myPaymentTermDownPaymentId, aSchoolYearId);
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spUtil_add_default_admin_user` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spUtil_add_default_admin_user`()
BEGIN

DECLARE aUserId INT;

DECLARE EXIT HANDLER FOR sqlexception
BEGIN
	rollback;
    resignal;
    SELECT 'Failed to add default admin user';
END;

START TRANSACTION;

	INSERT INTO user_mt(username, `password`, lastname, firstname, middlename, addedBy)
	VALUES('admin','admin','Default','Admin','Login','DB Administrator');
	SELECT last_insert_id() INTO aUserId;
	INSERT INTO user_role(user_id, role_id)
	VALUES(aUserId, 1);

COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spUtil_add_subjects` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spUtil_add_subjects`(
aCode VARCHAR(255),
aTitle varchar(255), 
aDescription VARCHAR(255),
aGradeLevelId INT
)
BEGIN

DECLARE aSubjectId INT;
    
    DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
        RESIGNAL;
    END;

START TRANSACTION;

INSERT INTO `enrollmentdb`.`subject_mt`
(
`code`,
`title`,
`description`)
VALUES
(aCode,
aTitle,
aDescription
);

SELECT last_insert_id() INTO aSubjectId;

INSERT INTO subject_gradelevel_lt(subject_id,gradelevel_id)
VALUES(aSubjectId, aGradeLevelId); 

COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spUtil_deactivate_all_students` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spUtil_deactivate_all_students`()
BEGIN

UPDATE student_mt SET isActive = 0 WHERE
isActive = 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spUtil_generate_rooms` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spUtil_generate_rooms`()
BEGIN

DECLARE roomNo INT DEFAULT 300;

WHILE roomNo <= 350 DO
	INSERT INTO room_mt(room_name_or_num, bldg_name_or_num, capacity)
    VALUES(roomNo, CONCAT('Building ',' ',roomNo),30);
    SET roomNo = roomNo + 1;
	END WHILE;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spUtil_wipeout_allstudent_record` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spUtil_wipeout_allstudent_record`()
BEGIN

DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
        SELECT 'Error encountered';
        RESIGNAL;
    END;
    
START TRANSACTION;
DELETE FROM student_grade WHERE student_id >= 1;
DELETE FROM admission_mt WHERE admission_id >= 1;
DELETE FROM credentials_received_lt WHERE credential_id >= 1;
DELETE FROM enrollment_student_lt WHERE enrollment_id >= 1;

DELETE FROM schoolyear_student_lt WHERE student_id >= 1;
-- Tuition Fee and Payment --
DELETE FROM balance_breakdown_fee WHERE balance_breakdown_fee_id >= 1;
DELETE FROM tuition_fee WHERE balance_breakdown_fee_id >= 1;
DELETE FROM student_discount_lt WHERE student_id >= 1;
DELETE FROM student_paymentterm_lt WHERE student_id >= 1;
DELETE FROM transaction_mt WHERE transaction_id >= 1;
DELETE FROM payment WHERE payment_id >= 1;
DELETE FROM transaction_payment_lt WHERE payment_id >= 1;
-- end of Tuition Fee and Payment

DELETE FROM transferee_grade WHERE student_id >= 1;
DELETE FROM transferee_student WHERE student_id >= 1;
DELETE FROM student_fee WHERE student_id >= 1;
DELETE FROM student_mt WHERE student_id >= 1;
DELETE FROM registration_mt WHERE registration_id >= 1;
DELETE FROM schoolyear_student_lt WHERE student_id >= 1;
DELETE FROM section_student WHERE student_id >= 1;
DELETE FROM student_address_lt WHERE student_id >= 1;
DELETE FROM student_fee WHERE student_id >= 1;
DELETE FROM student_grade WHERE student_id >= 1;
DELETE FROM student_promotion WHERE student_id >= 1;
DELETE FROM student_summer WHERE student_id >= 1;
DELETE FROM transferee_grade WHERE student_id >= 1;
DELETE FROM transferee_student WHERE student_id >= 1;

COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spUtil_wipeout_all_faculty_record` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spUtil_wipeout_all_faculty_record`()
BEGIN

DECLARE EXIT HANDLER FOR sqlexception
BEGIN
	ROLLBACK;
    RESIGNAL;
END;

START TRANSACTION;
DELETE FROM section_settings_lt WHERE adviser_id >= 1;
DELETE FROM faculty_schedule WHERE faculty_id >= 1;
DELETE FROM faculty_specialization WHERE faculty_id >= 1;
DELETE FROM faculty_mt WHERE faculty_id >= 1;

COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spUtil_wipeout_all_payment_and_tuition_record` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spUtil_wipeout_all_payment_and_tuition_record`()
BEGIN

DECLARE EXIT HANDLER FOR sqlexception
BEGIN
	ROLLBACK;
    RESIGNAL;
END;

start transaction;

DELETE FROM balance_breakdown_fee WHERE balance_breakdown_fee_id >= 1;
DELETE FROM tuition_fee WHERE balance_breakdown_fee_id >= 1;
DELETE FROM student_discount_lt WHERE student_id >= 1;
DELETE FROM student_paymentterm_lt WHERE student_id >= 1;
DELETE FROM transaction_mt WHERE transaction_id >= 1;
DELETE FROM payment WHERE payment_id >= 1;
DELETE FROM transaction_payment_lt WHERE payment_id >= 1;

COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spUtil_wipeout_all_room_record` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spUtil_wipeout_all_room_record`()
BEGIN

DELETE FROM room_mt WHERE room_id >= 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spUtil_wipeout_all_schedule_record` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spUtil_wipeout_all_schedule_record`()
BEGIN

DELETE FROM schedule_mt WHERE schedule_id >= 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spUtil_wipeout_all_subjects` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spUtil_wipeout_all_subjects`()
BEGIN

DECLARE EXIT HANDLER FOR sqlexception
BEGIN
	RESIGNAL;
    ROLLBACK;
END;

START TRANSACTION;

DELETE FROM subject_gradelevel_lt WHERE subject_id >= 1;
DELETE FROM curriculum_subject_lt WHERE subject_id >= 1;
DELETE FROM grade WHERE subject_id >= 1;
DELETE FROM subject_mt WHERE subject_id >= 1;

COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spUtil_wipeout_all_users` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spUtil_wipeout_all_users`()
BEGIN

DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
        SELECT 'Error encountered';
        RESIGNAL;
    END;
    
    START TRANSACTION;
    DELETE FROM user_faculty WHERE faculty_id >= 1;
    DELETE FROM user_role WHERE user_id >= 1;
	DELETE FROM user_mt WHERE user_id >= 1;
    
    COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `studentExist` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `studentExist`(aStudentNo INT)
BEGIN

SELECT
CASE  
WHEN COUNT(*) = 1 THEN 1 
WHEN COUNT(*) = 0 THEN 0 END AS exist 
FROM student_mt WHERE student_no = aStudentNo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `subjectCategoryNameExists` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `subjectCategoryNameExists`(subjectCategoryName VARCHAR(255))
BEGIN

SELECT COUNT(*) AS rowCount FROM subjectcategory_mt WHERE subjectcategory_name = subjectCategoryName;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateAdmissionStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateAdmissionStatus`(aStatus INT, aRegistrationId INT)
BEGIN
	UPDATE registration r SET r.isAdmissionComplete = aStatus
    WHERE r.id = aRegistrationId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateCreatedCurriculumById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCreatedCurriculumById`(
	IN pIN_curriculumId INT,
    IN pIN_subjectId INT,
    IN pIN_gradeLevelId INT,
    IN pIN_schoolYearId INT,
    IN pIN_curriculumTitle VARCHAR(150),
    IN pIN_curriculumDescription VARCHAR(150)
)
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
    BEGIN
		ROLLBACK;
			SELECT "Failed updating Curriculum with Subjects";
        RESIGNAL;
    END;
    
    #DELETE FROM curriculum_subject_lt WHERE curriculum_id = pIN_curriculumId;
    
    START TRANSACTION;

    UPDATE curriculum_mt
    SET gradelevel_id = pIN_gradeLevelId, schoolyear_id = pIN_schoolYearId,
    curriculum_title = pIN_curriculumTitle, description = pIN_curriculumDescription
    
    WHERE curriculum_mt.curriculum_id = pIN_curriculumId;

    INSERT INTO curriculum_subject_lt (curriculum_id, subject_id) 
    VALUES (pIN_curriculumId, pIN_subjectId);
    
    COMMIT;
    
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateCreatedSubjectById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCreatedSubjectById`(
	IN pIN_subjectId INT,
    IN pIN_gradeLevelId INT,
    IN pIN_subjectCode VARCHAR(150),
    IN pIN_subjectTitle VARCHAR(150),
    IN pIN_subjectDescription VARCHAR(150)
)
BEGIN
	
    UPDATE subject_gradelevel_lt AS sglt
    INNER JOIN subject_mt AS smt ON smt.subject_id = sglt.subject_id
    INNER JOIN gradelevel_mt  AS glmt ON glmt.gradelevel_id = sglt.gradelevel_id
    
		SET smt.code = pIN_subjectCode, smt.title = pIN_subjectTitle, smt.description = pIN_subjectDescription,
        sglt.gradelevel_id = pIN_gradeLevelId
        
        WHERE smt.subject_id = pIN_subjectId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateCurriculumById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCurriculumById`(
	IN pIN_curriculumId INT,
    IN pIN_schoolYearId INT,
    IN pIN_curriculumTitle VARCHAR(150),
    IN pIN_curriculumDescription VARCHAR(150)
)
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
    BEGIN
		ROLLBACK;
			SELECT "Failed updating Curriculum";
        RESIGNAL;
    END;

    UPDATE curriculum_mt
    SET schoolyear_id = pIN_schoolYearId,
    curriculum_title = pIN_curriculumTitle, description = pIN_curriculumDescription
    
    WHERE curriculum_mt.curriculum_id = pIN_curriculumId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateCurriculumDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCurriculumDetails`(aEducationalStageId INT,p_curriculumDesc VARCHAR(100),
p_gradeLevelId INT, p_curriculumId INT, p_schoolYearId INT,p_editedByUserId INT)
BEGIN

DECLARE EXIT HANDLER FOR sqlexception
BEGIN
	ROLLBACK;
    SELECT 'Error occured' AS Message;
    RESIGNAL;
END;

START TRANSACTION;

UPDATE curriculum c
			SET 	c.educationalstage_id = aEducationalStageId, 
					c.description 	= p_curriculumDesc,
					c.gradeLevelId 	= p_gradeLevelId 
			WHERE 	c.id 			= p_curriculumId;
            
UPDATE curriculum_schoolyears cs
			SET		cs.schoolYearId = p_schoolYearId
            WHERE	cs.curriculumId = p_curriculumId;
            
UPDATE curriculum_hd SET editedBy_UserId 	= p_editedByUserId,
						 dateLastEdited 	= NOW()
			WHERE curriculumId = p_curriculumId;
            
COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateCurriculumInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCurriculumInfo`(
curriculumId INT,
schoolYearId INT,
curriculumTitle VARCHAR(255),
curriculumDescription TEXT,
curriculumStatus INT
)
BEGIN

UPDATE curriculum_mt 
SET 
schoolyear_id = schoolYearId,
curriculum_title = curriculumTitle, 
description = curriculumDescription, 
isActive = curriculumStatus
WHERE curriculum_id = curriculumId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateCurriculumSubjects` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCurriculumSubjects`(
curriculumId INT, 
subjectId INT, 
subjectHours DECIMAL
)
BEGIN

INSERT INTO 
curriculum_subject_lt (curriculum_id,subject_id,subject_hours)
VALUES(curriculumId,subjectId,subjectHours);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateDiscount` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateDiscount`(
aDiscountName VARCHAR(255),
aPercentage INT,
aDescription TEXT,
aDiscountId INT
)
BEGIN

UPDATE discount_mt 
SET discount_name = aDiscountName,
percentage = aPercentage,
description = aDescription
WHERE discount_id = aDiscountId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateFaculty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateFaculty`(
IN pIN_facultyId INT, IN pIN_lastName VARCHAR(150), IN pIN_firstName VARCHAR(150), IN pIN_middleName VARCHAR(50),
IN pIN_contact VARCHAR(255), IN pIN_email VARCHAR(255), IN pIN_status INT
)
BEGIN

	UPDATE faculty_mt 
	SET faculty_mt.lastName = pIN_lastName, faculty_mt.firstName = pIN_firstName, faculty_mt.middleName = pIN_middleName,
	faculty_mt.contactNo = pIN_contact, faculty_mt.email = pIN_email, faculty_mt.status = pIN_status
	WHERE faculty_mt.faculty_id = pIN_facultyId;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateFee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateFee`(
aFeeId INT,
aFeeName VARCHAR(255),
aFeeDescription VARCHAR(255),
aFeeCategoryId INT,
aIsActive INT(1)
)
BEGIN

UPDATE fee_mt 
SET 
fee_name = aFeeName, 
fee_description = aFeeDescription,
fee_category_id = aFeeCategoryId,
isActive = aIsActive
WHERE fee_id = aFeeId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateRegistration` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateRegistration`(
aStudentType VARCHAR(255),
aStudentLastName VARCHAR(255),
aStudentFirstName VARCHAR(255),
aStudentMiddleName VARCHAR(255),
aDOB DATE,
aPOB VARCHAR(255),
aNationality VARCHAR(255),
aReligion VARCHAR(255),
aGender INT,
aFatherFirstName VARCHAR(255),
aFatherMiddleName VARCHAR(255),
aFatherLastName VARCHAR(255),
aFatherOccupation VARCHAR(255),
aFatherOfficePhoneNo VARCHAR(255),
aFatherMobileNo VARCHAR(255),
aIsFatherContactInCaseEmergency BIT(1),
aMotherFirstName VARCHAR(255),
aMotherMiddleName VARCHAR(255),
aMotherLastName VARCHAR(255),
aMotherOccupation VARCHAR(255),
aMotherOfficePhoneNo VARCHAR(255),
aMotherMobileNo VARCHAR(255),
aIsMotherContactInCaseEmergency BIT(1),
aGuardianLastName VARCHAR(255),
aGuardianFirstName VARCHAR(255),
aGuardianMiddleName VARCHAR(255),
aGuardianOccupation VARCHAR(255),
aGuardianMobileNo VARCHAR(255),
aGuardianRelationToStudent VARCHAR(255),
aIsGuardianContactInCaseEmergency BIT(1),
aSchoolLastAttended VARCHAR(255),
aSchoolLastAttendedAddress VARCHAR(255),
aRoomOrHouseNo VARCHAR(255),
aStreet VARCHAR(255),
aBrgyOrSubd VARCHAR(255),
aCity VARCHAR(255),
aRegion VARCHAR(255),
aGradeLevelNo INT,
aSchoolYearYearFrom INT,
aRegistrationId INT
)
BEGIN

UPDATE registration_mt 
SET
student_type = aStudentType, 
lastname = aStudentLastName, 
firstname = aStudentFirstName, 
middlename = aStudentMiddleName, 
dob = aDOB, 
pob = aPOB, 
nationality = aNationality, 
religion = aReligion, 
gender = aGender, 
father_firstname = aFatherFirstName, 
father_middlename = aFatherMiddleName, 
father_lastname = aFatherLastName, 
father_occupation = aFatherOccupation, 
father_officephone_no = aFatherOfficePhoneNo, 
father_mobile_no = aFatherMobileNo, 
isFatherContactInCaseEmergency = aIsFatherContactInCaseEmergency, 
mother_firstname = aMotherFirstName, 
mother_middlename = aMotherMiddleName, 
mother_lastname = aMotherLastName, 
mother_occupation = aMotherOccupation, 
mother_officephone_no = aMotherOfficePhoneNo, 
mother_mobile_no = aMotherMobileNo, 
isMotherContactInCaseEmergency = aIsMotherContactInCaseEmergency, 
guardian_lastname = aGuardianLastName, 
guardian_firstname = aGuardianFirstName, 
guardian_middlename = aGuardianMiddleName, 
guardian_occupation = aGuardianOccupation,
guardian_mobile_no = aGuardianMobileNo, 
guardian_relation_to_student = aGuardianRelationToStudent, 
isGuardianContactInCaseEmergency = aIsGuardianContactInCaseEmergency, 
school_last_attended = aSchoolLastAttended, 
school_last_attended_address = aSchoolLastAttendedAddress, 
room_or_house_no = aRoomOrHouseNo, 
street = aStreet, 
brgy_or_subd = aBrgyOrSubd, 
city = aCity, 
region = aRegion,
gradelevel_no = aGradeLevelNo,
schoolyear_yearfrom = aSchoolYearYearFrom

WHERE registration_id = aRegistrationId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateRegistrationDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateRegistrationDetails`(
p_studentType VARCHAR(20), 
p_lastName VARCHAR(100), 
p_firstName VARCHAR(100), 
p_middleName VARCHAR(100), 
p_dateOfBirth DATE, 
p_placeOfBirth VARCHAR(100),
p_nationality VARCHAR(50), 
p_religion VARCHAR(50), 
p_gender INT, 
p_father_firstName VARCHAR(100),
p_father_middleName VARCHAR(100), 
p_father_lastName VARCHAR(100), 
p_father_occupation VARCHAR(100), 
p_father_officePhoneNo VARCHAR(100), 
p_mother_firstName VARCHAR(100), 
p_mother_middleName VARCHAR(100), 
p_mother_lastName VARCHAR(100), 
p_mother_occupation VARCHAR(100), 
p_mother_officePhoneNo VARCHAR(20), 
p_father_mobileNo VARCHAR(20), 
p_mother_mobileNo VARCHAR(20), 
p_guardian_lastName VARCHAR(100), 
p_guardian_firstName VARCHAR(100), 
p_guardian_middleName VARCHAR(100), 
p_guardian_occupation VARCHAR(100), 
p_guardian_officePhoneNo VARCHAR(50), 
p_guardian_mobileNo VARCHAR(50), 
p_guardian_relationToStudent VARCHAR(50), p_isFatherContactInCaseEmergency INT, 
p_isMotherContactInCaseEmergency INT, 
p_isGuardianContactInCaseEmergency INT, 
p_schoolyear_id INT, 
p_gradelevel_id INT,
p_schoolLastAttended VARCHAR(100),
p_schoolAddress VARCHAR(100),
p_lastEditedByUserId INT,
p_roomOrHouseNo VARCHAR(100),
p_street VARCHAR(100),
p_brgyOrSubd VARCHAR(100),
p_city VARCHAR(100),
p_province VARCHAR(100),
p_hasBirthCertificate BIT(1),
p_hasBaptismalCertificate BIT(1),
p_hasMedicalCertificate BIT(1),
p_hasIdPicture BIT(1),
p_hasReportCard BIT(1),
p_hasCertificateOfGoodMoral BIT(1),
p_paymentTermId INT,
p_registrationId INT)
BEGIN

	DECLARE var_registrationId INT;
	DECLARE EXIT HANDLER FOR sqlexception
	BEGIN
		ROLLBACK;
		RESIGNAL;
	END;
    
    START TRANSACTION;
    
    UPDATE registration
    
    SET 
    studentType = p_studentType, 
    lastName = p_lastName, 
    firstName = p_firstName, 
    middleName = p_middleName, 
    dateOfBirth = p_dateOfBirth, 
    placeOfBirth = p_placeOfBirth, 
    nationality = p_nationality, 
    religion = p_religion, 
    gender = p_gender, 
    father_firstName = p_father_firstName, 
    father_middleName = p_father_middleName, 
    father_lastName = p_father_lastName, 
    father_occupation = p_father_occupation, 
    father_officePhoneNo = p_father_officePhoneNo, 
    mother_firstName = p_mother_firstName, 
    mother_middleName = p_mother_middleName, 
    mother_lastName = p_mother_lastName, 
    mother_occupation = p_mother_occupation, 
    mother_officePhoneNo = p_mother_officePhoneNo, 
    father_mobileNo = p_father_mobileNo, 
    mother_mobileNo = p_mother_mobileNo, 
    guardian_lastName = p_guardian_lastName, 
    guardian_firstName = p_guardian_firstName, 
    guardian_middleName = p_guardian_middleName, 
    guardian_occupation = p_guardian_occupation, 
    guardian_officePhoneNo = p_guardian_officePhoneNo, 
    guardian_mobileNo = p_guardian_mobileNo, 
    guardian_relationToStudent = p_guardian_relationToStudent, 
    isFatherContactInCaseEmergency = p_isFatherContactInCaseEmergency, 
    isMotherContactInCaseEmergency = p_isMotherContactInCaseEmergency, 
    isGuardianContactInCaseEmergency = p_isGuardianContactInCaseEmergency, 
    schoolyear_id = p_schoolyear_id, 
    gradelevel_id = p_gradelevel_id,
    schoolLastAttended = p_schoolLastAttended,
    schoolAddress = p_schoolAddress,
    room_or_houseNo = p_roomOrHouseNo,
    street = p_street,
    brgy_subd = p_brgyOrSubd,
    city = p_city,
    province = p_province,
    paymentterm_id = p_paymentTermId
    
    WHERE id = p_registrationId;
    
    UPDATE registration_credentialspresented
    SET hasBirthCertificate = p_hasBirthCertificate, 
    hasBaptismalCertificate = p_hasBaptismalCertificate, 
    hasMedicalCertificate = p_hasMedicalCertificate, 
    hasIdPicture = p_hasIdPicture, 
    hasReportCard = p_hasReportCard, 
    hasCertificateOfGoodMoral = p_hasCertificateOfGoodMoral
    WHERE registration_id = p_registrationId;
    
    
    UPDATE registration_hd SET lastEditedBy_UserId = p_lastEditedByUserId, dateLastEdited = NOW()
    WHERE registration_id = p_registrationId;
    
    COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateRooms` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateRooms`(
	p_room_id INT(11),
    p_roomName VARCHAR(45),
    p_buildingName VARCHAR(45),
    p_capacity VARCHAR(45),
    p_status INT,
    p_description TEXT
)
BEGIN

	UPDATE	room_mt SET 
    room_name_or_num = p_roomName, 
    bldg_name_or_num = p_buildingname,
    capacity = p_capacity,
    `status` = p_status,
    notes = p_description
    WHERE room_id = p_room_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSchoolYearStudentById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSchoolYearStudentById`(IN pIN_studentId INT)
BEGIN
	
    UPDATE schoolyear_student_lt
		
	SET 
		section_id = pIN_sectionId,
        adviser_id = pIN_adviser_id        
	WHERE student_id = pIN_studentId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSection` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSection`(
aSectionId INT, 
aSectionName VARCHAR(255),
aSectionStatus INT)
BEGIN

UPDATE section_mt SET 
sectionName = aSectionName,
isActive = aSectionStatus
WHERE section_id = aSectionId;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSectionById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSectionById`(
IN pIN_gradeLevelId INT, 
IN pIN_sessionId INT,
IN pIN_sectionId INT,
IN pIN_sectionName VARCHAR(150),
IN pIN_studentId INT,
IN pIN_schoolyearId INT,
IN pIN_isChanged BOOLEAN)
BEGIN
	
    START TRANSACTION;
    
    IF(pIN_isChanged = TRUE) THEN
		
        INSERT INTO section_student (section_id, student_id, schoolyear_id)
        VALUES (pIN_sectionId, pIN_studentId, pIN_schoolyearId);
        
		########################################################
        
        UPDATE schoolyear_student_lt
		
        SET 
			section_id = pIN_sectionId
                
        WHERE student_id = pIN_studentId;
        
        ##################################
        
        UPDATE section_settings_lt
        INNER JOIN section_mt ON section_mt.section_id = section_settings_lt.section_id
        
        SET 
			schoolyear_id = pIN_schoolyearId,
			gradelevel_id = pIN_gradeLevelId,
			section_mt.sectionName = pIN_sectionName,
            session_id = pIN_sessionId
            
        WHERE section_settings_lt.section_id = pIN_sectionId;
        
    ELSE
    
		UPDATE section_settings_lt 
		SET gradelevel_id = pIN_gradeLevelId,
		session_id = pIN_sessionId;
        
        UPDATE schoolyear_student_lt
        SET section_id = pIN_sectionId
        WHERE student_id = pIN_studentId;
    
    END IF;
    
	
    
    
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSectionName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSectionName`(IN pIN_sectionId INT, IN pIN_sectionName VARCHAR(150))
BEGIN
	
    UPDATE section_mt SET sectionName = pIN_sectionName
    WHERE section_id = pIN_sectionId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSectionSettings` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSectionSettings`(
aSectionId INT, 
aSchoolYearId INT,
aGradeLevelId INT,
aSession VARCHAR(2),
aFacultyId INT,
aCapacity INT
)
BEGIN

UPDATE section_settings_lt SET
schoolyear_id = aSchoolYearId,
gradelevel_id = aGradeLevelId,
`session` = aSession,
adviser_id = aFacultyId,
capacity = aCapacity
WHERE section_id = aSectionId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSectionSettingsById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSectionSettingsById`(
IN pIN_schoolyearId INT,
IN pIN_gradeLevelId INT, 
IN pIN_sessionId INT,
IN pIN_adviserId INT,
IN pIN_sectionId INT
)
BEGIN
	
	UPDATE section_settings_lt
	   
	SET 
		schoolyear_id = pIN_schoolyearId,
		gradelevel_id = pIN_gradeLevelId,
		session_id = pIN_sessionId,
		adviser_id = pIN_adviserId
        
	WHERE section_settings_lt.section_id = pIN_sectionId;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSectionStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSectionStudent`()
BEGIN
	
	INSERT INTO section_student (section_id, student_id, schoolyear_id)
	VALUES (pIN_sectionId, pIN_studentId, pIN_schoolyearId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSpecialization` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSpecialization`(
	IN id INT,
    IN p_title VARCHAR(45),
	IN p_description TEXT
)
BEGIN
	UPDATE specialization set specialization_title = p_title, 
     description = p_description WHERE specialization_id = id; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSubject` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSubject`(
aSubjectId INT, aSubjectCode VARCHAR(255),
aSubjectName VARCHAR(255), aSubjectDescription VARCHAR(255),
aSubjectStatus INT)
BEGIN

UPDATE subject_mt 
SET `code` = aSubjectCode, title = aSubjectName,
description = aSubjectDescription, isActive = aSubjectStatus  
WHERE subject_id = aSubjectId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSubjectCategoryInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSubjectCategoryInfo`(
categoryId INT, 
categoryName VARCHAR(255), 
categoryStatus INT(1), 
categoryDescription TEXT
)
BEGIN

UPDATE subjectcategory_mt SET 
subjectcategory_name = categoryName, 
isActive = categoryStatus, 
description = categoryDescription
WHERE subjectcategory_id = categoryId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSubjectGradeLevelAssignment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSubjectGradeLevelAssignment`(aSubjectId INT, aGradeLevelId INT)
BEGIN

UPDATE subject_gradelevel_lt 
SET gradelevel_id = aGradeLevelId
WHERE subject_id = aSubjectId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUser`(aUserId INT, aUserName VARCHAR(20), aPassword VARCHAR(255))
BEGIN

UPDATE user_mt SET 
username = aUserName,
`password` = aPassword
WHERE user_id = aUserId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-13 13:47:29
