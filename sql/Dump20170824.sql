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
  `isComplete` bit(1) NOT NULL DEFAULT b'0',
  `completion_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`admission_id`),
  UNIQUE KEY `registration_id_UNIQUE` (`registration_id`),
  CONSTRAINT `fk_admission_mtTABLE_registration_idCOL` FOREIGN KEY (`registration_id`) REFERENCES `registration_mt` (`registration_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7810 DEFAULT CHARSET=latin1 COMMENT='This is a table to be used for new students only.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admission_mt`
--

LOCK TABLES `admission_mt` WRITE;
/*!40000 ALTER TABLE `admission_mt` DISABLE KEYS */;
INSERT INTO `admission_mt` VALUES (7681,7720,'','2017-08-23 07:16:28'),(7682,7721,'','2017-08-23 07:16:28'),(7683,7722,'','2017-08-23 07:16:28'),(7684,7723,'','2017-08-23 07:16:29'),(7685,7724,'','2017-08-23 07:16:29'),(7686,7725,'','2017-08-23 13:19:58'),(7687,7726,'','2017-08-23 13:19:59'),(7688,7727,'','2017-08-23 13:20:00'),(7689,7728,'','2017-08-23 13:20:00'),(7690,7729,'','2017-08-23 13:20:00'),(7691,7730,'','2017-08-23 13:20:01'),(7692,7731,'','2017-08-23 13:20:01'),(7693,7732,'','2017-08-23 13:20:01'),(7694,7733,'','2017-08-23 13:20:02'),(7695,7734,'','2017-08-23 13:20:02'),(7696,7735,'','2017-08-23 14:33:43'),(7697,7736,'','2017-08-23 14:33:43'),(7698,7737,'','2017-08-23 14:33:43'),(7699,7738,'','2017-08-23 14:33:44'),(7700,7739,'','2017-08-23 14:33:44'),(7701,7740,'','2017-08-23 14:33:44'),(7702,7741,'','2017-08-23 14:33:44'),(7703,7742,'','2017-08-23 14:33:45'),(7704,7743,'','2017-08-23 14:57:32'),(7705,7744,'','2017-08-23 14:57:33'),(7706,7745,'','2017-08-23 14:57:33'),(7707,7746,'','2017-08-23 14:57:33'),(7708,7747,'','2017-08-23 14:57:34'),(7709,7748,'','2017-08-23 14:57:35'),(7710,7749,'','2017-08-23 14:57:36'),(7711,7750,'','2017-08-23 14:57:36'),(7712,7751,'','2017-08-23 14:57:37'),(7713,7752,'','2017-08-23 14:57:37'),(7714,7753,'','2017-08-23 16:06:22'),(7715,7754,'','2017-08-23 16:06:31'),(7716,7755,'','2017-08-23 16:06:34'),(7717,7756,'','2017-08-23 16:06:35'),(7718,7757,'','2017-08-23 16:06:36'),(7719,7758,'','2017-08-23 16:06:41'),(7720,7759,'','2017-08-23 16:06:43'),(7721,7760,'','2017-08-23 16:06:44'),(7722,7761,'','2017-08-23 16:06:45'),(7723,7762,'','2017-08-23 16:06:47'),(7724,7763,'','2017-08-23 16:06:51'),(7725,7764,'','2017-08-23 16:06:57'),(7726,7765,'','2017-08-23 16:07:00'),(7727,7766,'','2017-08-23 16:07:04'),(7728,7767,'','2017-08-23 16:07:10'),(7729,7768,'','2017-08-23 16:07:13'),(7730,7769,'','2017-08-23 16:07:25'),(7731,7770,'','2017-08-23 16:07:42'),(7732,7771,'','2017-08-23 16:07:49'),(7733,7772,'','2017-08-23 16:07:52'),(7734,7773,'','2017-08-23 16:07:56'),(7735,7774,'','2017-08-23 16:09:32'),(7736,7775,'','2017-08-23 16:09:35'),(7737,7776,'','2017-08-23 16:09:37'),(7738,7777,'','2017-08-23 16:09:39'),(7739,7778,'','2017-08-23 16:09:42'),(7740,7779,'','2017-08-23 16:09:44'),(7741,7780,'','2017-08-23 16:09:46'),(7742,7781,'','2017-08-23 16:09:50'),(7743,7782,'','2017-08-23 16:09:53'),(7744,7783,'','2017-08-23 16:09:54'),(7745,7784,'','2017-08-23 16:09:56'),(7746,7785,'','2017-08-23 16:09:58'),(7747,7786,'','2017-08-23 16:09:59'),(7748,7787,'','2017-08-23 16:10:00'),(7749,7788,'','2017-08-23 16:10:01'),(7750,7789,'','2017-08-23 16:10:02'),(7751,7790,'','2017-08-23 16:10:03'),(7752,7791,'','2017-08-23 16:10:04'),(7753,7792,'','2017-08-23 16:10:05'),(7754,7793,'','2017-08-23 16:10:06'),(7755,7794,'','2017-08-23 16:10:10'),(7756,7795,'','2017-08-23 16:10:18'),(7757,7796,'','2017-08-23 16:10:24'),(7758,7797,'','2017-08-23 16:10:27'),(7759,7798,'','2017-08-23 16:10:30'),(7760,7799,'','2017-08-23 16:11:33'),(7761,7800,'','2017-08-23 16:11:35'),(7762,7801,'','2017-08-23 16:11:35'),(7763,7802,'','2017-08-23 16:13:47'),(7764,7803,'','2017-08-23 16:13:48'),(7765,7804,'','2017-08-23 16:13:49'),(7766,7805,'','2017-08-23 16:13:50'),(7767,7806,'','2017-08-23 16:13:51'),(7768,7807,'','2017-08-23 16:13:52'),(7769,7808,'','2017-08-23 16:13:52'),(7770,7809,'','2017-08-23 16:13:53'),(7771,7810,'','2017-08-23 16:13:53'),(7772,7811,'','2017-08-23 16:13:54'),(7773,7812,'','2017-08-23 16:13:55'),(7774,7813,'','2017-08-23 16:13:55'),(7775,7814,'','2017-08-23 16:13:56'),(7776,7815,'','2017-08-23 16:13:56'),(7777,7816,'','2017-08-23 16:13:58'),(7778,7817,'','2017-08-23 16:13:58'),(7779,7818,'','2017-08-23 16:13:59'),(7780,7819,'','2017-08-23 16:14:00'),(7781,7820,'','2017-08-23 16:14:00'),(7782,7821,'','2017-08-23 16:14:01'),(7783,7822,'','2017-08-23 16:14:01'),(7784,7823,'','2017-08-23 16:14:02'),(7785,7824,'','2017-08-23 16:14:02'),(7786,7825,'','2017-08-23 16:14:03'),(7787,7826,'','2017-08-23 16:14:05'),(7788,7827,'','2017-08-23 16:14:06'),(7789,7828,'','2017-08-23 16:14:07'),(7790,7829,'','2017-08-23 16:14:07'),(7791,7830,'','2017-08-23 16:14:08'),(7792,7831,'','2017-08-23 16:14:09'),(7793,7832,'','2017-08-23 16:14:09'),(7794,7833,'','2017-08-23 16:14:10'),(7795,7834,'','2017-08-23 16:14:10'),(7796,7835,'','2017-08-23 16:14:11'),(7797,7836,'','2017-08-23 16:14:12'),(7798,7837,'','2017-08-23 16:14:13'),(7799,7838,'','2017-08-23 16:14:14'),(7800,7839,'','2017-08-23 16:14:15'),(7801,7840,'','2017-08-23 16:14:16'),(7802,7841,'','2017-08-23 16:14:16'),(7803,7842,'','2017-08-23 16:14:17'),(7804,7843,'','2017-08-23 16:14:17'),(7805,7844,'','2017-08-23 16:14:18'),(7806,7845,'','2017-08-23 16:14:19'),(7807,7846,'','2017-08-23 16:14:19'),(7808,7847,'','2017-08-23 16:14:20'),(7809,7848,'','2017-08-23 17:02:29');
/*!40000 ALTER TABLE `admission_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `balance_breakdown_fee`
--

DROP TABLE IF EXISTS `balance_breakdown_fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `balance_breakdown_fee` (
  `balance_breakdown_fee_id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `payment_deadline` date DEFAULT NULL,
  PRIMARY KEY (`balance_breakdown_fee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `balance_breakdown_fee`
--

LOCK TABLES `balance_breakdown_fee` WRITE;
/*!40000 ALTER TABLE `balance_breakdown_fee` DISABLE KEYS */;
INSERT INTO `balance_breakdown_fee` VALUES (71,'Downpayment',8000.00,'2017-08-23 07:17:39',NULL),(72,'First Quarter',3805.28,'2017-08-23 07:17:39','2017-06-01'),(73,'Second Quarter',3805.28,'2017-08-23 07:17:39','2017-07-01'),(74,'Third Quarter',3805.28,'2017-08-23 07:17:39','2017-07-01'),(75,'Fourth Quarter',3805.28,'2017-08-23 07:17:39','2017-10-01'),(76,'Downpayment',8000.00,'2017-08-23 16:53:36',NULL),(77,'First Quarter',3805.28,'2017-08-23 16:53:36','2017-06-01'),(78,'Second Quarter',3805.28,'2017-08-23 16:53:36','2017-07-01'),(79,'Third Quarter',3805.28,'2017-08-23 16:53:36','2017-07-01'),(80,'Fourth Quarter',3805.28,'2017-08-23 16:53:36','2017-10-01'),(81,'Downpayment',8000.00,'2017-08-23 16:56:35',NULL),(82,'First Quarter',4310.09,'2017-08-23 16:56:35','2017-06-01'),(83,'Second Quarter',4310.09,'2017-08-23 16:56:35','2017-07-01'),(84,'Third Quarter',4310.09,'2017-08-23 16:56:35','2017-07-01'),(85,'Fourth Quarter',4310.09,'2017-08-23 16:56:35','2017-10-01'),(86,'Cash',22740.36,'2017-08-23 17:03:55',NULL);
/*!40000 ALTER TABLE `balance_breakdown_fee` ENABLE KEYS */;
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
INSERT INTO `credential_requirements_lt` VALUES (18,301,409,'2017-03-24 01:31:07'),(18,302,409,'2017-03-24 01:31:07'),(18,303,409,'2017-03-24 01:31:07'),(18,304,409,'2017-03-24 01:31:08'),(18,305,409,'2017-03-24 01:31:08'),(18,306,409,'2017-03-24 01:31:08'),(18,307,409,'2017-03-24 01:31:08'),(18,308,409,'2017-03-24 01:31:08'),(18,309,409,'2017-03-24 01:31:08'),(18,310,409,'2017-03-24 01:31:08'),(18,311,409,'2017-03-24 01:31:08'),(19,301,409,'2017-03-24 01:32:20'),(19,302,409,'2017-03-24 01:32:20'),(19,303,409,'2017-03-24 01:32:20'),(19,304,409,'2017-03-24 01:32:20'),(19,305,409,'2017-03-24 01:32:20'),(19,306,409,'2017-03-24 01:32:20'),(19,307,409,'2017-03-24 01:32:20'),(19,308,409,'2017-03-24 01:32:20'),(19,309,409,'2017-03-24 01:32:20'),(19,310,409,'2017-03-24 01:32:20'),(19,311,409,'2017-03-24 01:32:20'),(20,301,409,'2017-03-24 01:33:00'),(20,302,409,'2017-03-24 01:33:00'),(20,303,409,'2017-03-24 01:33:00'),(20,304,409,'2017-03-24 01:33:00'),(20,305,409,'2017-03-24 01:33:00'),(20,306,409,'2017-03-24 01:33:00'),(20,307,409,'2017-03-24 01:33:01'),(20,308,409,'2017-03-24 01:33:01'),(20,309,409,'2017-03-24 01:33:01'),(20,310,409,'2017-03-24 01:33:01'),(20,311,409,'2017-03-24 01:33:01'),(21,302,409,'2017-03-24 01:33:35'),(21,303,409,'2017-03-24 01:33:36'),(21,304,409,'2017-03-24 01:33:36'),(21,305,409,'2017-03-24 01:33:36'),(21,306,409,'2017-03-24 01:33:36'),(21,307,409,'2017-03-24 01:33:36'),(21,308,409,'2017-03-24 01:33:36'),(21,309,409,'2017-03-24 01:33:36'),(21,310,409,'2017-03-24 01:33:36'),(21,311,409,'2017-03-24 01:33:36'),(22,308,409,'2017-03-24 01:33:58'),(22,309,409,'2017-03-24 01:33:58'),(22,310,409,'2017-03-24 01:33:59'),(22,311,409,'2017-03-24 01:33:59');
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
  KEY `fk_curriculum_mtTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_curriculum_mtTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COMMENT='Curriculum Master Table to hold all Curriculums.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curriculum_mt`
--

LOCK TABLES `curriculum_mt` WRITE;
/*!40000 ALTER TABLE `curriculum_mt` DISABLE KEYS */;
INSERT INTO `curriculum_mt` VALUES (10,407,'K12','K12','','2017-08-23 14:56:14');
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
  `gradelevel_id` int(11) NOT NULL,
  KEY `fk_curriculum_subject_ltTABLE_curriculum_idCOL_idx` (`curriculum_id`),
  KEY `fk_curriculum_subject_ltTABLE_subject_idCOL_idx` (`subject_id`),
  KEY `fk_curriculum_subject_ltTABLE_gradelevel_idCOL_idx` (`gradelevel_id`),
  CONSTRAINT `fk_curriculum_subject_ltTABLE_curriculum_idCOL` FOREIGN KEY (`curriculum_id`) REFERENCES `curriculum_mt` (`curriculum_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_curriculum_subject_ltTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_curriculum_subject_ltTABLE_subject_idCOL` FOREIGN KEY (`subject_id`) REFERENCES `subject_mt` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curriculum_subject_lt`
--

LOCK TABLES `curriculum_subject_lt` WRITE;
/*!40000 ALTER TABLE `curriculum_subject_lt` DISABLE KEYS */;
INSERT INTO `curriculum_subject_lt` VALUES (10,525,1.00,302),(10,526,1.00,302),(10,527,1.00,302),(10,528,1.00,302),(10,529,1.00,302),(10,530,1.00,302),(10,531,1.00,302),(10,532,1.00,302),(10,533,1.00,302),(10,534,1.00,302),(10,535,1.00,302),(10,536,1.00,302),(10,537,1.00,302);
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
-- Table structure for table `enrollment_mt`
--

DROP TABLE IF EXISTS `enrollment_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enrollment_mt` (
  `enrollment_id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolyear_id` int(11) NOT NULL,
  `opening_date` date NOT NULL COMMENT 'any enrollment date prior to "opening_date" date  value will be considered Early Enrollment',
  `closing_date` date NOT NULL COMMENT 'any enrollment date beyond "closing_date" date  value will be considered Late Enrollment',
  `date_created` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`enrollment_id`),
  UNIQUE KEY `schoolyear_id_UNIQUE` (`schoolyear_id`),
  KEY `fk_enrollment_mtTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_enrollment_mtTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1 COMMENT='This table will store the information of ENROLLMENT SCHEDULE such as when the enrollment OPENS and when the enrollment CLOSES\nEvery enrollment will be associated with a School Year';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollment_mt`
--

LOCK TABLES `enrollment_mt` WRITE;
/*!40000 ALTER TABLE `enrollment_mt` DISABLE KEYS */;
INSERT INTO `enrollment_mt` VALUES (2,407,'2017-05-01','2017-06-30','2017-02-28 14:28:12'),(3,408,'2018-05-01','2018-06-01','2017-02-28 21:25:19'),(4,409,'2016-05-01','2016-05-30','2017-03-06 13:46:02'),(16,425,'2019-01-01','2019-01-31','2017-07-08 10:36:18'),(17,426,'2020-01-01','2020-01-31','2017-08-12 10:40:55');
/*!40000 ALTER TABLE `enrollment_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollment_student_lt`
--

DROP TABLE IF EXISTS `enrollment_student_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enrollment_student_lt` (
  `enrollment_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `date_of_enrollment` datetime NOT NULL,
  `isEarlyEnrollment` bit(1) NOT NULL DEFAULT b'0',
  `isLateEnrollment` bit(1) NOT NULL DEFAULT b'0',
  `withdrawn` bit(1) DEFAULT b'0',
  KEY `fk_enrollment_student_ltTABLE_enrollment_idCOL_idx` (`enrollment_id`),
  KEY `fk_enrollment_student_ltTABLE_student_idCOL_idx` (`student_id`),
  CONSTRAINT `fk_enrollment_student_ltTABLE_enrollment_idCOL` FOREIGN KEY (`enrollment_id`) REFERENCES `enrollment_mt` (`enrollment_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_enrollment_student_ltTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This will contain all students enrollment dates and will determine whether an enrollment is late enrollment or early enrollment';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollment_student_lt`
--

LOCK TABLES `enrollment_student_lt` WRITE;
/*!40000 ALTER TABLE `enrollment_student_lt` DISABLE KEYS */;
INSERT INTO `enrollment_student_lt` VALUES (2,38,'2017-08-23 00:00:00','\0','','\0'),(2,39,'2017-08-23 00:00:00','\0','','\0'),(2,40,'2017-08-23 00:00:00','\0','','\0'),(2,41,'2017-08-23 00:00:00','\0','','\0'),(2,42,'2017-08-23 00:00:00','\0','','\0'),(2,43,'2017-08-23 00:00:00','\0','','\0'),(2,44,'2017-08-23 00:00:00','\0','','\0'),(2,45,'2017-08-23 00:00:00','\0','','\0'),(2,46,'2017-08-23 00:00:00','\0','','\0'),(2,47,'2017-08-23 00:00:00','\0','','\0'),(2,48,'2017-08-23 00:00:00','\0','','\0'),(2,49,'2017-08-23 00:00:00','\0','','\0'),(2,50,'2017-08-23 00:00:00','\0','','\0'),(2,51,'2017-08-23 00:00:00','\0','','\0'),(2,52,'2017-08-23 00:00:00','\0','','\0'),(2,53,'2017-08-23 00:00:00','\0','','\0'),(2,54,'2017-08-23 00:00:00','\0','','\0'),(2,55,'2017-08-23 00:00:00','\0','','\0'),(2,56,'2017-08-23 00:00:00','\0','','\0'),(2,57,'2017-08-23 00:00:00','\0','','\0'),(2,58,'2017-08-23 00:00:00','\0','','\0'),(2,59,'2017-08-23 00:00:00','\0','','\0'),(2,60,'2017-08-23 00:00:00','\0','','\0'),(2,61,'2017-08-23 00:00:00','\0','','\0'),(2,62,'2017-08-23 00:00:00','\0','','\0'),(2,63,'2017-08-23 00:00:00','\0','','\0'),(2,64,'2017-08-23 00:00:00','\0','','\0'),(2,65,'2017-08-23 00:00:00','\0','','\0'),(2,66,'2017-08-23 00:00:00','\0','','\0'),(2,67,'2017-08-23 00:00:00','\0','','\0'),(2,68,'2017-08-23 00:00:00','\0','','\0'),(2,69,'2017-08-23 00:00:00','\0','','\0'),(2,70,'2017-08-23 00:00:00','\0','','\0'),(2,71,'2017-08-23 00:00:00','\0','','\0'),(2,72,'2017-08-23 00:00:00','\0','','\0'),(2,73,'2017-08-23 00:00:00','\0','','\0'),(2,74,'2017-08-23 00:00:00','\0','','\0'),(2,75,'2017-08-23 00:00:00','\0','','\0'),(2,76,'2017-08-23 00:00:00','\0','','\0'),(2,77,'2017-08-23 00:00:00','\0','','\0'),(2,78,'2017-08-23 00:00:00','\0','','\0'),(2,79,'2017-08-23 00:00:00','\0','','\0'),(2,80,'2017-08-23 00:00:00','\0','','\0'),(2,81,'2017-08-23 00:00:00','\0','','\0'),(2,82,'2017-08-23 00:00:00','\0','','\0'),(2,83,'2017-08-23 00:00:00','\0','','\0'),(2,84,'2017-08-23 00:00:00','\0','','\0'),(2,85,'2017-08-23 00:00:00','\0','','\0'),(2,86,'2017-08-23 00:00:00','\0','','\0'),(2,87,'2017-08-23 00:00:00','\0','','\0'),(2,88,'2017-08-23 00:00:00','\0','','\0'),(2,89,'2017-08-23 00:00:00','\0','','\0'),(2,90,'2017-08-23 00:00:00','\0','','\0'),(2,91,'2017-08-23 00:00:00','\0','','\0'),(2,92,'2017-08-23 00:00:00','\0','','\0'),(2,93,'2017-08-23 00:00:00','\0','','\0'),(2,94,'2017-08-23 00:00:00','\0','','\0'),(2,95,'2017-08-23 00:00:00','\0','','\0'),(2,96,'2017-08-23 00:00:00','\0','','\0'),(2,97,'2017-08-23 00:00:00','\0','','\0'),(2,98,'2017-08-23 00:00:00','\0','','\0'),(2,99,'2017-08-23 00:00:00','\0','','\0'),(2,100,'2017-08-23 00:00:00','\0','','\0'),(2,101,'2017-08-23 00:00:00','\0','','\0'),(2,102,'2017-08-23 00:00:00','\0','','\0'),(2,103,'2017-08-23 00:00:00','\0','','\0'),(2,104,'2017-08-23 00:00:00','\0','','\0'),(2,105,'2017-08-23 00:00:00','\0','','\0'),(2,106,'2017-08-23 00:00:00','\0','','\0'),(2,107,'2017-08-23 00:00:00','\0','','\0'),(2,108,'2017-08-23 00:00:00','\0','','\0'),(2,109,'2017-08-23 00:00:00','\0','','\0'),(2,110,'2017-08-23 00:00:00','\0','','\0'),(2,111,'2017-08-23 00:00:00','\0','','\0'),(2,112,'2017-08-23 00:00:00','\0','','\0'),(2,113,'2017-08-23 00:00:00','\0','','\0'),(2,114,'2017-08-23 00:00:00','\0','','\0'),(2,115,'2017-08-23 00:00:00','\0','','\0'),(2,116,'2017-08-23 00:00:00','\0','','\0'),(2,117,'2017-08-23 00:00:00','\0','','\0'),(2,118,'2017-08-23 00:00:00','\0','','\0'),(2,119,'2017-08-23 00:00:00','\0','','\0'),(2,120,'2017-08-23 00:00:00','\0','','\0'),(2,121,'2017-08-23 00:00:00','\0','','\0'),(2,122,'2017-08-23 00:00:00','\0','','\0'),(2,123,'2017-08-23 00:00:00','\0','','\0'),(2,124,'2017-08-23 00:00:00','\0','','\0'),(2,125,'2017-08-23 00:00:00','\0','','\0'),(2,126,'2017-08-23 00:00:00','\0','','\0'),(2,127,'2017-08-23 00:00:00','\0','','\0'),(2,128,'2017-08-23 00:00:00','\0','','\0'),(2,129,'2017-08-23 00:00:00','\0','','\0'),(2,130,'2017-08-23 00:00:00','\0','','\0'),(2,131,'2017-08-23 00:00:00','\0','','\0'),(2,132,'2017-08-23 00:00:00','\0','','\0'),(2,133,'2017-08-23 00:00:00','\0','','\0'),(2,134,'2017-08-23 00:00:00','\0','','\0'),(2,135,'2017-08-23 00:00:00','\0','','\0'),(2,136,'2017-08-23 00:00:00','\0','','\0'),(2,137,'2017-08-23 00:00:00','\0','','\0'),(2,138,'2017-08-23 00:00:00','\0','','\0'),(2,139,'2017-08-23 00:00:00','\0','','\0'),(2,140,'2017-08-23 00:00:00','\0','','\0'),(2,141,'2017-08-23 00:00:00','\0','','\0'),(2,142,'2017-08-23 00:00:00','\0','','\0'),(2,143,'2017-08-23 00:00:00','\0','','\0'),(2,144,'2017-08-23 00:00:00','\0','','\0'),(2,145,'2017-08-23 00:00:00','\0','','\0'),(2,146,'2017-08-23 00:00:00','\0','','\0'),(2,147,'2017-08-23 00:00:00','\0','','\0'),(2,148,'2017-08-23 00:00:00','\0','','\0'),(2,149,'2017-08-23 00:00:00','\0','','\0'),(2,150,'2017-08-23 00:00:00','\0','','\0'),(2,151,'2017-08-23 00:00:00','\0','','\0'),(2,152,'2017-08-23 00:00:00','\0','','\0'),(2,153,'2017-08-23 00:00:00','\0','','\0'),(2,154,'2017-08-23 00:00:00','\0','','\0'),(2,155,'2017-08-23 00:00:00','\0','','\0'),(2,156,'2017-08-23 00:00:00','\0','','\0'),(2,157,'2017-08-23 00:00:00','\0','','\0'),(2,158,'2017-08-23 00:00:00','\0','','\0'),(2,159,'2017-08-23 00:00:00','\0','','\0'),(2,160,'2017-08-23 00:00:00','\0','','\0'),(2,161,'2017-08-23 00:00:00','\0','','\0'),(2,162,'2017-08-23 00:00:00','\0','','\0'),(2,163,'2017-08-23 00:00:00','\0','','\0'),(2,164,'2017-08-23 00:00:00','\0','','\0'),(2,165,'2017-08-23 00:00:00','\0','','\0'),(2,166,'2017-08-23 00:00:00','\0','','\0');
/*!40000 ALTER TABLE `enrollment_student_lt` ENABLE KEYS */;
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
  `employeeId` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `middleName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contact` varchar(45) NOT NULL,
  `status` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`faculty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_mt`
--

LOCK TABLES `faculty_mt` WRITE;
/*!40000 ALTER TABLE `faculty_mt` DISABLE KEYS */;
INSERT INTO `faculty_mt` VALUES (4,'1025','Paul Neo','Napadao','E.','paulneo@gmail.com','09154456789',''),(5,'1026','Ruby','Peralta','E','peralta@gmail.com','0912345678',''),(6,'1027','Romela','Pangan','E.','pangan@yahoo.com','0912345678',''),(7,'1028','Sarah','Ramos','E.','ramos@gmail.com','0912345678',''),(9,'1029','Elenita','Guarin','R.','guarin@comcast.com','0915647897',''),(11,'10111','Alvin','Kutcher','E.','alvin@gmail.com','09153654897',''),(12,'10002','Elmer','Dumo','D','dumo@ymail.com','934245',''),(13,'10003','Cody','Pangilinan','U','cody@gmail.com','9787565',''),(14,'10004','Ella','Sanchez','T','sanchez@yme.com','975433',''),(15,'10005','Leonora','Dela Cruz','M','leon@gmail.com','9267567',''),(16,'10006','Corazon','Guarin','K','cor@ymail.com','98764',''),(17,'10007','Alma','Romarate','A','alma@yahoo.com','65432',''),(18,'10009','John','Antonio','M','john@gmail.com','365432',''),(19,'100010','May','Chavez','C','chavez@se.com','975222',''),(23,'100011','Reuben','Dayao','Y','ben@ymail.com','9123545',''),(24,'100013','Jemma','Abellana','E','abellana@yahoo.com','92145353',''),(25,'100014','Roland','Reyes','D','reyes@gmail.com','9324243',''),(26,'100015','Pinky','Amador','P','pinky@gmail.com','923456',''),(27,'100016','Mary','Vallejos','E','mary@gmail.com','923453',''),(28,'100017','Daisy','Tan','R','tan@ymail.com','945432',''),(29,'100018','Anne','Peralta','E','anne@gmail.com','897',''),(30,'100019','Ludy','Puerto','K','ludy@ymail.com','93442',''),(31,'100020','Chinita','Akot','P','akot@gmail.com','945343',''),(32,'100021','Bo','Sanchez','P','bo@gmail.com','92315',''),(33,'100022','Laura','Cagasab','L','laura@ymail.com','9126432',''),(34,'100023','Lyn','Smith','H','lyn@gmail.com','91245637',''),(35,'100024','Shaye','Lannister','A','shaye@yahoo.com','934266',''),(36,'100025','Sansa','Stark','L','stark@gmail.com','914576','');
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
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_schedule`
--

LOCK TABLES `faculty_schedule` WRITE;
/*!40000 ALTER TABLE `faculty_schedule` DISABLE KEYS */;
INSERT INTO `faculty_schedule` VALUES (1,9,2,'2017-08-21 12:55:06'),(2,4,3,'2017-08-21 12:55:06'),(3,9,4,'2017-08-21 17:41:37'),(4,4,5,'2017-08-21 17:41:38'),(5,6,6,'2017-08-21 17:41:38'),(6,5,7,'2017-08-21 17:41:38'),(7,9,8,'2017-08-21 17:41:39'),(8,4,9,'2017-08-21 17:41:39'),(9,5,10,'2017-08-21 17:41:39'),(10,7,11,'2017-08-21 17:41:39'),(11,24,12,'2017-08-23 06:25:26'),(12,31,13,'2017-08-23 06:25:26'),(13,26,14,'2017-08-23 06:25:26'),(14,26,15,'2017-08-23 06:25:27'),(15,33,16,'2017-08-23 06:25:27'),(16,33,17,'2017-08-23 06:25:27'),(17,31,18,'2017-08-23 06:42:07'),(18,26,19,'2017-08-23 06:42:07'),(19,33,20,'2017-08-23 06:42:08'),(20,15,21,'2017-08-23 06:42:08'),(21,6,22,'2017-08-23 13:03:51'),(22,6,23,'2017-08-23 13:03:51'),(23,13,24,'2017-08-23 13:03:51'),(24,5,25,'2017-08-23 13:03:51'),(25,7,26,'2017-08-23 13:03:51'),(26,25,27,'2017-08-23 15:01:53'),(27,17,28,'2017-08-23 15:01:53'),(28,36,29,'2017-08-23 15:01:53'),(29,36,30,'2017-08-23 15:01:54'),(30,36,31,'2017-08-23 15:01:54'),(31,12,32,'2017-08-23 16:27:10'),(32,24,33,'2017-08-23 16:27:10'),(33,33,34,'2017-08-23 16:27:10'),(34,15,35,'2017-08-23 16:27:10'),(35,15,36,'2017-08-23 16:27:10'),(36,12,37,'2017-08-23 16:27:10'),(37,24,38,'2017-08-23 16:27:10'),(38,33,39,'2017-08-23 16:27:10'),(39,15,40,'2017-08-23 16:27:10'),(40,15,41,'2017-08-23 16:27:10'),(41,12,42,'2017-08-23 16:27:10'),(42,24,43,'2017-08-23 16:27:10'),(43,33,44,'2017-08-23 16:27:10'),(44,31,45,'2017-08-23 16:27:10'),(45,15,46,'2017-08-23 16:27:10'),(46,12,47,'2017-08-23 16:27:10'),(47,24,48,'2017-08-23 16:27:10'),(48,33,49,'2017-08-23 16:27:10'),(49,31,50,'2017-08-23 16:27:10'),(50,15,51,'2017-08-23 16:27:10'),(51,12,52,'2017-08-23 16:27:10'),(52,24,53,'2017-08-23 16:27:10'),(53,33,54,'2017-08-23 16:27:10'),(54,31,55,'2017-08-23 16:27:10'),(55,15,56,'2017-08-23 16:27:10'),(56,31,57,'2017-08-23 16:27:10'),(57,31,58,'2017-08-23 16:27:10'),(58,24,59,'2017-08-23 16:45:50'),(59,31,60,'2017-08-23 16:45:50'),(60,18,61,'2017-08-23 16:45:50'),(61,11,62,'2017-08-23 16:45:50'),(62,26,63,'2017-08-23 16:45:50'),(63,31,64,'2017-08-23 16:45:50'),(64,33,65,'2017-08-23 16:45:50'),(65,26,66,'2017-08-23 16:45:50'),(66,24,67,'2017-08-23 16:45:50'),(67,31,68,'2017-08-23 16:45:50'),(68,18,69,'2017-08-23 16:45:50'),(69,31,70,'2017-08-23 16:45:50'),(70,31,71,'2017-08-23 16:45:51'),(71,18,72,'2017-08-23 16:45:51'),(72,26,73,'2017-08-23 16:45:51'),(73,12,74,'2017-08-23 16:45:51'),(74,16,75,'2017-08-23 16:45:51'),(75,18,76,'2017-08-23 16:45:51'),(76,33,77,'2017-08-23 16:45:51'),(77,23,78,'2017-08-23 16:45:51');
/*!40000 ALTER TABLE `faculty_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_specialization`
--

DROP TABLE IF EXISTS `faculty_specialization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty_specialization` (
  `faculty_id` int(11) NOT NULL,
  `specialization_id` int(11) NOT NULL,
  `date_assigned` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `faculty_specialization_TABLE_facultyId_COL_idx` (`faculty_id`),
  KEY `fk_faculty_specializationTABLE_specialization_idCOL_idx` (`specialization_id`),
  CONSTRAINT `faculty_specialization_TABLE_facultyId_COL` FOREIGN KEY (`faculty_id`) REFERENCES `faculty_mt` (`faculty_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_faculty_specializationTABLE_specialization_idCOL` FOREIGN KEY (`specialization_id`) REFERENCES `specialization` (`specialization_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_specialization`
--

LOCK TABLES `faculty_specialization` WRITE;
/*!40000 ALTER TABLE `faculty_specialization` DISABLE KEYS */;
INSERT INTO `faculty_specialization` VALUES (4,14,'2017-08-19 16:05:56'),(5,17,'2017-08-20 10:57:56'),(6,18,'2017-08-20 11:01:06'),(7,17,'2017-08-20 11:04:10'),(9,20,'2017-08-20 11:16:39'),(9,16,'2017-08-20 11:16:39'),(11,15,'2017-08-22 23:47:46'),(12,20,'2017-08-23 00:05:52'),(13,20,'2017-08-23 00:09:51'),(13,16,'2017-08-23 00:09:51'),(14,20,'2017-08-23 00:10:27'),(14,21,'2017-08-23 00:10:27'),(15,20,'2017-08-23 00:11:00'),(15,15,'2017-08-23 00:11:00'),(16,14,'2017-08-23 00:11:41'),(17,14,'2017-08-23 00:12:05'),(18,14,'2017-08-23 00:12:30'),(19,14,'2017-08-23 00:12:58'),(23,14,'2017-08-23 00:14:38'),(23,17,'2017-08-23 00:14:38'),(24,17,'2017-08-23 00:15:18'),(24,19,'2017-08-23 00:15:18'),(25,19,'2017-08-23 00:15:46'),(26,17,'2017-08-23 00:16:13'),(26,19,'2017-08-23 00:16:13'),(27,18,'2017-08-23 00:16:39'),(28,18,'2017-08-23 00:17:06'),(29,18,'2017-08-23 00:17:32'),(30,18,'2017-08-23 00:18:03'),(31,18,'2017-08-23 00:18:26'),(32,15,'2017-08-23 00:18:52'),(33,15,'2017-08-23 00:19:16'),(34,15,'2017-08-23 00:19:37'),(35,15,'2017-08-23 00:20:03'),(36,15,'2017-08-23 00:20:27');
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
  PRIMARY KEY (`fee_category_id`),
  UNIQUE KEY `feetype_UNIQUE` (`fee_category`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='MASTER table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_category_mt`
--

LOCK TABLES `fee_category_mt` WRITE;
/*!40000 ALTER TABLE `fee_category_mt` DISABLE KEYS */;
INSERT INTO `fee_category_mt` VALUES (1,'Basic'),(4,'Downpayment'),(2,'Miscellaneous'),(3,'Others');
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
  PRIMARY KEY (`fee_id`),
  UNIQUE KEY `fee_name_UNIQUE` (`fee_name`),
  KEY `fk_fee_mtTABLE_fee_category_idCOL_idx` (`fee_category_id`),
  CONSTRAINT `fk_fee_mtTABLE_fee_category_idCOL` FOREIGN KEY (`fee_category_id`) REFERENCES `fee_category_mt` (`fee_category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=latin1 COMMENT='MASTER';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_mt`
--

LOCK TABLES `fee_mt` WRITE;
/*!40000 ALTER TABLE `fee_mt` DISABLE KEYS */;
INSERT INTO `fee_mt` VALUES (100,'Downpayment','Downpayment',4),(101,'Field Trip','Field Trip',2),(102,'Basic','Basic Fee',1),(103,'Sports Fee','Sports Fee',2),(104,'Energy Fee','Energy Fee',2),(105,'Club Fee','Club Fee',2),(106,'Comp Laboratory','Computer Laboratory',2),(107,'Tablet Fee','Tablet Fee',2),(115,'Water Fee','Water Fee',2),(116,'Music Fee','Music Fee',2),(117,'TestFee','TestFee',2),(118,'TestFee2','TestFee2',2),(119,'TestFee4','TestFee4',2),(120,'Leadership Fee','Leadership Training Fee',2),(121,'E-Learning Fee','E-Learning',2);
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
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  KEY `fk_fee_schoolyear_ltTABLE_fee_idCOL_idx` (`fee_id`),
  KEY `fk_fee_schoolyear_ltTABLE_gradelevel_idCOL_idx` (`gradelevel_id`),
  KEY `fk_fee_schoolyear_ltTABLE_year_createdCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_fee_schoolyear_ltTABLE_fee_idCOL` FOREIGN KEY (`fee_id`) REFERENCES `fee_mt` (`fee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fee_schoolyear_ltTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fee_schoolyear_ltTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contains the amounts of fees per gradelevel and whether it is still active.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_schoolyear_lt`
--

LOCK TABLES `fee_schoolyear_lt` WRITE;
/*!40000 ALTER TABLE `fee_schoolyear_lt` DISABLE KEYS */;
INSERT INTO `fee_schoolyear_lt` VALUES (100,8000.00,301,407,''),(100,8000.00,302,407,''),(100,8000.00,303,407,''),(100,8000.00,304,407,''),(100,8000.00,305,407,''),(100,8000.00,306,407,''),(100,8000.00,307,407,''),(100,8000.00,308,407,''),(100,8000.00,309,407,''),(100,8000.00,310,407,''),(100,8000.00,311,407,''),(101,500.00,301,407,''),(101,250.00,302,407,''),(101,350.00,303,407,''),(101,400.00,304,407,''),(101,275.00,305,407,''),(101,500.00,306,407,''),(101,600.00,307,407,''),(101,390.00,308,407,''),(101,755.00,309,407,''),(101,233.00,310,407,''),(101,555.00,311,407,''),(102,10000.00,301,407,''),(102,12500.00,302,407,''),(102,12500.00,303,407,''),(102,12500.00,304,407,''),(102,12500.00,305,407,''),(102,12500.00,306,407,''),(102,12500.00,307,407,''),(102,12500.00,308,407,''),(102,12500.00,309,407,''),(102,12500.00,310,407,''),(102,12500.00,311,407,''),(103,250.00,301,407,''),(103,500.00,302,407,''),(103,500.00,303,407,''),(103,500.00,304,407,''),(103,500.00,305,407,''),(103,500.00,306,407,''),(103,650.00,307,407,''),(103,650.00,308,407,''),(103,650.00,309,407,''),(103,650.00,310,407,''),(103,650.00,311,407,''),(104,1200.00,301,407,''),(104,1200.00,302,407,''),(104,1200.00,303,407,''),(104,1200.00,304,407,''),(104,1200.00,305,407,''),(104,1200.00,306,407,''),(104,1200.00,307,407,''),(104,1200.00,308,407,''),(104,1200.00,309,407,''),(104,1200.00,310,407,''),(104,1200.00,311,407,''),(105,525.36,301,407,''),(105,525.36,302,407,''),(105,525.36,303,407,''),(105,525.36,304,407,''),(105,525.36,305,407,''),(105,525.36,306,407,''),(105,525.36,307,407,''),(105,525.36,308,407,''),(105,525.36,309,407,''),(105,525.36,310,407,''),(105,525.36,311,407,''),(106,3000.00,301,407,''),(106,3000.00,302,407,''),(106,3000.00,303,407,''),(106,3000.00,304,407,''),(106,3000.00,305,407,''),(106,3000.00,306,407,''),(106,3000.00,307,407,''),(106,3000.00,308,407,''),(106,3000.00,309,407,''),(106,3000.00,310,407,''),(106,3000.00,311,407,''),(107,500.00,301,407,''),(107,500.00,302,407,''),(107,500.00,303,407,''),(107,500.00,304,407,''),(107,500.00,305,407,''),(107,500.00,306,407,''),(107,500.00,307,407,''),(107,500.00,308,407,''),(107,500.00,309,407,''),(107,500.00,310,407,''),(107,500.00,311,407,''),(115,856.00,301,407,''),(115,856.00,302,407,''),(115,856.00,303,407,''),(115,856.00,304,407,''),(115,856.00,305,407,''),(115,856.00,306,407,''),(115,856.00,307,407,''),(115,856.00,308,407,''),(115,856.00,309,407,''),(115,856.00,310,407,''),(115,856.00,311,407,''),(116,600.00,301,407,''),(116,600.00,302,407,''),(116,600.00,303,407,''),(116,600.00,304,407,''),(116,600.00,305,407,''),(116,600.00,306,407,''),(116,600.00,307,407,''),(116,600.00,308,407,''),(116,600.00,309,407,''),(116,600.00,310,407,''),(116,600.00,311,407,''),(117,125.00,301,407,''),(117,125.00,302,407,''),(117,125.00,303,407,''),(117,125.00,304,407,''),(117,125.00,305,407,''),(117,125.00,306,407,''),(117,125.00,307,407,''),(117,125.00,308,407,''),(117,125.00,309,407,''),(117,125.00,310,407,''),(117,125.00,311,407,''),(118,135.00,301,407,''),(118,135.00,302,407,''),(118,135.00,303,407,''),(118,135.00,304,407,''),(118,135.00,305,407,''),(118,135.00,306,407,''),(118,135.00,307,407,''),(118,135.00,308,407,''),(118,135.00,309,407,''),(118,135.00,310,407,''),(118,135.00,311,407,''),(119,1249.00,301,407,''),(119,1249.00,302,407,''),(119,1249.00,303,407,''),(119,1249.00,304,407,''),(119,1249.00,305,407,''),(119,1249.00,306,407,''),(119,1249.00,307,407,''),(119,1249.00,308,407,''),(119,1249.00,309,407,''),(119,1249.00,310,407,''),(119,1249.00,311,407,''),(120,800.00,301,407,''),(120,800.00,302,407,''),(120,800.00,303,407,''),(120,800.00,304,407,''),(120,800.00,305,407,''),(120,800.00,306,407,''),(120,800.00,307,407,''),(120,800.00,308,407,''),(120,800.00,309,407,''),(120,800.00,310,407,''),(120,800.00,311,407,''),(121,3000.00,301,407,''),(121,3000.00,302,407,''),(121,3000.00,303,407,''),(121,3000.00,304,407,''),(121,3000.00,305,407,''),(121,3000.00,306,407,''),(121,3000.00,307,407,''),(121,3000.00,308,407,''),(121,3000.00,309,407,''),(121,3000.00,310,407,''),(121,3000.00,311,407,'');
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
  `subject_id` int(11) NOT NULL,
  `grade` decimal(10,2) DEFAULT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `gradingperiod_id` int(11) DEFAULT NULL,
  `date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `final` double DEFAULT NULL,
  `gwa` double DEFAULT NULL,
  `isSubmitted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`grade_id`),
  KEY `fk_gradeTABLE_subject_idCOL_idx` (`subject_id`),
  KEY `fk_gradeTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_gradeTABLE_gradingperiod_idCOL_idx` (`gradingperiod_id`),
  CONSTRAINT `fk_gradeTABLE_gradingperiod_idCOL` FOREIGN KEY (`gradingperiod_id`) REFERENCES `gradingperiod_mt` (`gradingperiod_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_gradeTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_gradeTABLE_subject_idCOL` FOREIGN KEY (`subject_id`) REFERENCES `subject_mt` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,525,91.00,407,7000,'2017-08-23 15:12:16',0,NULL,NULL),(2,525,91.00,407,7000,'2017-08-23 15:24:49',0,NULL,NULL),(3,525,NULL,407,7000,'2017-08-23 15:24:49',0,NULL,NULL),(4,525,NULL,407,7000,'2017-08-23 15:24:49',0,NULL,NULL),(5,525,NULL,407,7000,'2017-08-23 15:24:50',0,NULL,NULL),(6,526,91.00,407,7000,'2017-08-23 15:24:50',0,NULL,NULL),(7,526,NULL,407,7000,'2017-08-23 15:24:50',0,NULL,NULL),(8,526,NULL,407,7000,'2017-08-23 15:24:50',0,NULL,NULL),(9,526,NULL,407,7000,'2017-08-23 15:24:50',0,NULL,NULL),(10,525,87.00,407,7001,'2017-08-23 15:24:51',0,NULL,NULL),(11,525,NULL,407,7001,'2017-08-23 15:24:51',0,NULL,NULL),(12,525,NULL,407,7001,'2017-08-23 15:24:51',0,NULL,NULL),(13,525,NULL,407,7001,'2017-08-23 15:24:51',0,NULL,NULL),(14,526,NULL,407,7001,'2017-08-23 15:24:51',0,NULL,NULL),(15,526,NULL,407,7001,'2017-08-23 15:24:51',0,NULL,NULL),(16,526,NULL,407,7001,'2017-08-23 15:24:51',0,NULL,NULL),(17,526,NULL,407,7001,'2017-08-23 15:24:51',0,NULL,NULL),(18,525,NULL,407,7002,'2017-08-23 15:24:52',0,NULL,NULL),(19,525,NULL,407,7002,'2017-08-23 15:24:52',0,NULL,NULL),(20,525,NULL,407,7002,'2017-08-23 15:24:52',0,NULL,NULL),(21,525,NULL,407,7002,'2017-08-23 15:24:52',0,NULL,NULL),(22,526,NULL,407,7002,'2017-08-23 15:24:52',0,NULL,NULL),(23,526,NULL,407,7002,'2017-08-23 15:24:52',0,NULL,NULL),(24,526,NULL,407,7002,'2017-08-23 15:24:52',0,NULL,NULL),(25,526,NULL,407,7002,'2017-08-23 15:24:52',0,NULL,NULL),(26,525,NULL,407,7003,'2017-08-23 15:24:52',0,NULL,NULL),(27,525,NULL,407,7003,'2017-08-23 15:24:53',0,NULL,NULL),(28,525,NULL,407,7003,'2017-08-23 15:24:53',0,NULL,NULL),(29,525,NULL,407,7003,'2017-08-23 15:24:53',0,NULL,NULL),(30,526,NULL,407,7003,'2017-08-23 15:24:53',0,NULL,NULL),(31,526,NULL,407,7003,'2017-08-23 15:24:53',0,NULL,NULL),(32,526,NULL,407,7003,'2017-08-23 15:24:54',0,NULL,NULL),(33,526,NULL,407,7003,'2017-08-23 15:24:54',0,NULL,NULL);
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
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `balance_breakdown_fee_id` int(11) NOT NULL,
  `amount_tendered` decimal(10,2) NOT NULL,
  `date_of_payment` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`payment_id`),
  KEY `fk_paymentTABLE_balance_breakdown_fee_idCOL_idx` (`balance_breakdown_fee_id`),
  CONSTRAINT `fk_paymentTABLE_balance_breakdown_fee_idCOL` FOREIGN KEY (`balance_breakdown_fee_id`) REFERENCES `balance_breakdown_fee` (`balance_breakdown_fee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentterm_deadline`
--

DROP TABLE IF EXISTS `paymentterm_deadline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentterm_deadline` (
  `payment_deadline_id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolyear_id` int(11) NOT NULL,
  `paymentterm_id` int(11) NOT NULL,
  `period_id` int(11) NOT NULL,
  `deadline` date NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`payment_deadline_id`),
  KEY `fk_payment_deadlineTABLE_paymentterm_idCOL_idx` (`paymentterm_id`),
  KEY `fk_payment_deadlineTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_payment_deadlineTABLE_period_idCOL_idx` (`period_id`),
  CONSTRAINT `fk_payment_deadlineTABLE_paymentterm_idCOL` FOREIGN KEY (`paymentterm_id`) REFERENCES `paymentterm_mt` (`paymentterm_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_payment_deadlineTABLE_period_idCOL` FOREIGN KEY (`period_id`) REFERENCES `period` (`period_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_payment_deadlineTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentterm_deadline`
--

LOCK TABLES `paymentterm_deadline` WRITE;
/*!40000 ALTER TABLE `paymentterm_deadline` DISABLE KEYS */;
INSERT INTO `paymentterm_deadline` VALUES (33,407,4,6,'2017-06-30',''),(34,407,4,5,'2017-12-30',''),(35,407,3,4,'2017-06-01',''),(36,407,3,3,'2017-07-01',''),(37,407,3,2,'2017-07-01',''),(38,407,3,1,'2017-10-01',''),(39,407,5,7,'2017-01-01',''),(40,407,5,8,'2017-02-01',''),(41,407,5,9,'2017-03-01',''),(42,407,5,10,'2017-04-01',''),(43,407,5,11,'2017-05-01',''),(44,407,5,12,'2017-06-01',''),(45,407,5,13,'2017-07-01',''),(46,407,5,14,'2017-08-01',''),(47,407,5,15,'2017-09-01',''),(48,407,5,16,'2017-10-01','');
/*!40000 ALTER TABLE `paymentterm_deadline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentterm_mt`
--

DROP TABLE IF EXISTS `paymentterm_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentterm_mt` (
  `paymentterm_id` int(11) NOT NULL AUTO_INCREMENT,
  `paymentterm` varchar(45) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  `divisor` int(11) NOT NULL,
  PRIMARY KEY (`paymentterm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentterm_mt`
--

LOCK TABLES `paymentterm_mt` WRITE;
/*!40000 ALTER TABLE `paymentterm_mt` DISABLE KEYS */;
INSERT INTO `paymentterm_mt` VALUES (2,'Cash','',1),(3,'Quarterly','',4),(4,'Semestral','',2),(5,'Monthly','',12);
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Stores how much penalty fee is charged for late payments per schoolyear.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentterm_penalty`
--

LOCK TABLES `paymentterm_penalty` WRITE;
/*!40000 ALTER TABLE `paymentterm_penalty` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentterm_period`
--

LOCK TABLES `paymentterm_period` WRITE;
/*!40000 ALTER TABLE `paymentterm_period` DISABLE KEYS */;
INSERT INTO `paymentterm_period` VALUES (1,4,5,'2017-07-13 16:37:54'),(2,4,6,'2017-07-13 16:37:59'),(3,3,4,'2017-07-13 16:38:04'),(4,3,3,'2017-07-13 16:38:09'),(5,3,2,'2017-07-13 16:38:15'),(6,3,1,'2017-07-13 16:38:19'),(7,5,16,'2017-07-13 16:41:46'),(8,5,15,'2017-07-13 16:41:52'),(9,5,14,'2017-07-13 16:41:56'),(10,5,13,'2017-07-13 16:41:59'),(11,5,12,'2017-07-13 16:42:04'),(12,5,11,'2017-07-13 16:42:07'),(13,5,10,'2017-07-13 16:42:11'),(14,5,9,'2017-07-13 16:42:14'),(15,5,8,'2017-07-13 16:42:18'),(16,5,7,'2017-07-13 16:42:22');
/*!40000 ALTER TABLE `paymentterm_period` ENABLE KEYS */;
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
  `description` text NOT NULL,
  PRIMARY KEY (`period_id`),
  UNIQUE KEY `code_UNIQUE` (`period_code`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `period`
--

LOCK TABLES `period` WRITE;
/*!40000 ALTER TABLE `period` DISABLE KEYS */;
INSERT INTO `period` VALUES (1,'FOQ','Fourth Quarter'),(2,'TQ','Third Quarter'),(3,'SQ','Second Quarter'),(4,'FIQ','First Quarter'),(5,'SS','Second Semester'),(6,'FS','First Semester'),(7,'FM','First Month'),(8,'SECMO','Second Month'),(9,'THMO','Third Month'),(10,'FOM','Fourth Month'),(11,'FIM','Fifth Month'),(12,'SIM','Sixth Month'),(13,'SEVMO','Seventh Month'),(14,'EMO','Eighth Month'),(15,'NIMO','Ninth Month'),(16,'TEMO','Tenth Month');
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
  `student_type` varchar(45) NOT NULL,
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
  `guardian_officephone_no` varchar(45) DEFAULT NULL,
  `guardian_mobile_no` varchar(45) DEFAULT NULL,
  `guardian_relation_to_student` varchar(45) DEFAULT NULL,
  `isGuardianContactInCaseEmergency` bit(1) DEFAULT b'0',
  `school_last_attended` varchar(45) DEFAULT NULL,
  `school_last_attended_address` varchar(100) DEFAULT NULL,
  `isDownpaymentPaid` bit(1) DEFAULT b'0',
  `room_or_house_no` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `brgy_or_subd` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `province` varchar(45) DEFAULT NULL,
  `gradelevel_id` int(11) NOT NULL,
  `schoolyear_id` int(11) DEFAULT NULL,
  `date_registered` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `paymentterm_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`registration_id`),
  KEY `fk_registration_mtTABLE_gradelevel_idCOL_idx` (`gradelevel_id`),
  KEY `fk_registration_mtTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_registration_mtTABLE_paymentterm_idCOL_idx` (`paymentterm_id`),
  CONSTRAINT `fk_gradelevel_mtTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_registration_mtTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_registration_mtTABLE_paymentterm_idCOL` FOREIGN KEY (`paymentterm_id`) REFERENCES `paymentterm_mt` (`paymentterm_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_registration_mtTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7849 DEFAULT CHARSET=latin1 COMMENT='Master Table for registration of new students and transferees ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration_mt`
--

LOCK TABLES `registration_mt` WRITE;
/*!40000 ALTER TABLE `registration_mt` DISABLE KEYS */;
INSERT INTO `registration_mt` VALUES (7720,'New','Leis','Myles','Orion','2008-01-10','Dinagat Islands','Gabonese','Taoism','\0','Maude','Skippie','Bronicki','Social Psychologist','202-555-0132','202-555-0145','','Lezlie','Conny','Carty','Cardroom Manager','202-555-0132','202-555-0104','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 07:16:28',3),(7721,'Transferee','Wallander','Frederick','Latia','2010-08-18','Oriental Mindoro','Irish','Taoism','\0','Elmo','Mallorie','Milioli','Cardroom Manager','202-555-0163','202-555-0190','','Arica','Katerina','Russo','Licensed Clinical Mental Health Counselor','202-555-0179','202-555-0190','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 07:16:28',3),(7722,'Transferee','Liss','Shavon','Cathie','2006-03-11','Biliran','SouthKorean','Born again','\0','Mariel','Brinn','Burke','Emcee','202-555-0167','202-555-0114','','Tonja','Morse','Leis','Nursing Service Director','202-555-0131','202-555-0114','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 07:16:28',3),(7723,'New','Amsden','Antionette','Corliss','2007-03-25','Negros Occidental','Mozambican','Catholic','\0','Patricia','Mano','Amadeo','Ambulance Driver-Paramedic','202-555-0175','202-555-0138','','Elma','Roderich','Clear','Drywall Applicator','202-555-0173','202-555-0187','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 07:16:29',3),(7724,'New','Rickles','Jade','Birgit','2009-01-17','Benguet','Chadian','Muslim','\0','Lila','Ruddy','Leis','Piano Professor','202-555-0112','202-555-0150','','Vilma','Indira','Baskey','Statistical Analyst','202-555-0100','202-555-0123','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 07:16:29',3),(7725,'New','Lord','Delcie','Frans','2008-01-18','Camarines Norte','Saudi','Taoism','\0','Shavon','Cathie','Hiles','Social Psychologist','202-555-0184','202-555-0165','\0','Latashia','Astra','Hiles','Busser','202-555-0190','202-555-0145','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 13:19:58',4),(7726,'Transferee','Bertram','Melia','Claire','2009-06-22','Davao del Norte','Armenian','Born again','\0','Serita','Darrick','Glider','Professor of Communication and Writing','202-555-0175','202-555-0112','\0','Jana','Skippie','Naus','Tobacco Buyer','202-555-0169','202-555-0179','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 13:19:59',4),(7727,'New','Brewer','Winford','Brinn','2008-02-26','Guimaras','SolomonIslander','Born again','','Ed','Harriot','Cady','Statistical Analyst','202-555-0145','202-555-0173','','Maudie','Roderich','Wilkin','Tobacco Buyer','202-555-0177','202-555-0153','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 13:19:59',4),(7728,'Transferee','Sparda','Tamekia','Townie','2007-01-16','Aklan','KittianandNevisian','Catholic','\0','Frederick','Bernardo','Glider','Molasses Preparer','202-555-0105','202-555-0138','\0','Marcellus','Jocelyn','Lueders-booth','Tobacco Buyer','202-555-0145','202-555-0184','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 13:20:00',4),(7729,'Transferee','Lueders-booth','Celestine','Crissie','2006-06-13','Palawan','Emirian','Catholic','','Antionette','Frans','Amsden','Social Psychologist','202-555-0148','202 - 555 - 0150','','Vilma','Morse','Verdile','Cardroom Manager','202-555-0148','202-555-0179','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 13:20:00',4),(7730,'New','Arreguin','Sibyl','Scott','2011-04-10','Laguna','Liberian','Catholic','\0','Moses','Simonette','Kasper','Cardroom Manager','202-555-0170','202-555-0114','\0','Maragret','Frans','Prentice','Licensed Clinical Mental Health Counselor','202-555-0114','202-555-0189','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 13:20:01',4),(7731,'New','Korzennik','Carisa','Kendal','2008-07-28','Samar','Bolivian','Protestant','\0','Tamekia','Lindy','Amsden','Licensed Clinical Mental Health Counselor','202-555-0109','202-555-0100','\0','Shauna','Deborah','Markussen','Freight Clerk','202-555-0148','202-555-0112','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 13:20:01',4),(7732,'Transferee','Wallander','Lillian','Harvey','2006-09-27','Agusan del Norte','Gabonese','Protestant','','Tonja','Clem','Glider','Nursing Service Director','202-555-0185','202-555-0175','','Odette','Casey','Polya','Nursing Service Director','202-555-0181','202-555-0139','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 13:20:01',4),(7733,'New','Balshaw','Lezlie','Harvey','2006-02-24','Surigao del Norte','Moroccan','Protestant','','Jeanice','Mano','Mcnicol','Statistical Analyst','202-555-0163','202-555-0152','\0','Lillian','Griffin','Bertram','Freight Clerk','202-555-0165','202-555-0167','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 13:20:02',4),(7734,'New','El-shaarawi','Lila','Aubrey','2010-05-10','Aklan','Maldivan','Muslim','\0','Mariel','Clem','Von mehren','Social Psychologist','202-555-0150','202-555-0153','\0','Tamekia','Loydie','Norato','Line Haul Driver','202-555-0183','202-555-0146','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 13:20:02',4),(7735,'New','Venne','Mariel','Maegan','2009-03-23','Davao del Norte','Slovenian','Born again','','Soon','Thornie','Carty','Ambulance Driver-Paramedic','202-555-0116','202-555-0184','','Macy','Derrik','Teutsch','Custom Wood Stair Builder','202-555-0146','202-555-0162','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 14:33:43',2),(7736,'New','Badulescu','Joanie','Tedi','2010-03-11','Cotabato','EastTimorese','Catholic','\0','Melia','Coralie','Decierdo','Strike Warfare/Missile Systems Officer','202-555-0173','202-555-0184','','Ruth','Michele','Valelly','Ambulance Driver-Paramedic','202-555-0101','202-555-0137','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 14:33:43',2),(7737,'Transferee','Valelly','Ezra','Lindy','2007-01-14','Guimaras','Somali','Born again','','Madeleine','Frans','Lamarche','Chiropractor','202-555-0183','202-555-0195','','Patricia','Claire','Glider','Nursing Service Director','202-555-0135','202-555-0114','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 14:33:43',2),(7738,'New','Upsdell','Carisa','Rogers','2007-05-10','Batanes','Grenadian','Born again','','Johnsie','Efrem','Dernburg','Professor of Communication and Writing','202-555-0152','202-555-0170','','Apolonia','Morse','Kauppi','Ambulance Driver-Paramedic','202-555-0197','202-555-0197','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 14:33:44',2),(7739,'New','Morin','Lila','Tootsie','2011-04-10','Palawan','Slovenian','Born again','\0','Patricia','Tedi','Dernburg','Custom Wood Stair Builder','202 - 555 - 0150','202-555-0186','','Janessa','Cathie','Persky','AIDS Counselor','202-555-0165','202-555-0138','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 14:33:44',2),(7740,'Transferee','Marston','Odette','Barny','2008-10-16','Camarines Sur','Nigerian','Catholic','\0','Stormy','Merrielle','Orfe','Amusement Park Worker','202 - 555 - 0150','202-555-0187','\0','Teddy','Morey','Burke','Strike Warfare/Missile Systems Officer','202-555-0123','202-555-0153','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 14:33:44',2),(7741,'Transferee','Bronicki','Ed','Coralie','2008-04-14','Ilocos Sur','Malagasy','Protestant','\0','Zena','Michele','Fuchs','Tobacco Buyer','202-555-0183','202-555-0186','\0','Janine','Birgit','Pesavento','Multi-operation Forming Machine Setter','202-555-0186','202-555-0190','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 14:33:44',2),(7742,'Transferee','Fonseca','Jeanice','Frans','2011-05-16','Eastern Samar','Albanian','Catholic','','Lila','Tedi','Burke','Nursing Service Director','202-555-0125','202-555-0123','\0','Elma','Indira','Arreguin','Multi-operation Forming Machine Setter','202-555-0101','202-555-0102','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 14:33:45',2),(7743,'Transferee','Decierdo','Arica','Pen','2008-02-22','Sulu','Maltese','Born again','\0','Maudie','Townie','Hiles','Professor of Communication and Writing','202-555-0186','202-555-0112','\0','Marissa','Adaline','Hiles','Freight Clerk','202-555-0162','202-555-0195','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,409,'2017-08-23 14:57:32',2),(7744,'Transferee','Bertram','Ruth','Conny','2008-02-26','Samar','Senegalese','Born again','\0','Stormy','Aurlie','Orfe','Tobacco Buyer','202-555-0162','202-555-0105','','Zena','Aurlie','Still','Custom Wood Stair Builder','202-555-0179','202-555-0148','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,409,'2017-08-23 14:57:33',2),(7745,'Transferee','Norato','Elena','Darrick','2007-03-25','Nueva Ecija','Salvadoran','Protestant','\0','Kanisha','Craggie','Kauppi','Social Psychologist','202-555-0173','202-555-0125','','Mariel','Jessie','Stigler','Amusement Park Worker','202-555-0189','202-555-0114','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,409,'2017-08-23 14:57:33',2),(7746,'New','Ulam','Sibyl','Clim','2009-10-23','Siquijor','Iranian','Born again','\0','Shauna','Charlotta','Teutsch','Lead Abatement Worker','202-555-0187','202-555-0195','\0','Ezra','Riccardo','Persky','Freight Clerk','202-555-0170','202-555-0162','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,409,'2017-08-23 14:57:33',2),(7747,'New','Dernburg','Marissa','Riccardo','2008-10-23','Sorsogon','Jordanian','Born again','\0','Elmo','Aubrey','Korzennik','Custom Wood Stair Builder','202-555-0185','202-555-0145','','Stacee','Efrem','Sparda','Amusement Park Worker','202-555-0146','202-555-0139','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,409,'2017-08-23 14:57:34',2),(7748,'Transferee','Bilodeau','Johnsie','Morse','2008-09-11','Mountain Province','Hungarian','Catholic','','Marcellus','Indira','Lord','Gas Derrick Operator','202-555-0197','202-555-0145','','Winford','Coralie','Wilkin','Voice-Over Artist','202-555-0179','202-555-0169','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,409,'2017-08-23 14:57:35',2),(7749,'Transferee','Signon','Ludivina','Claire','2008-04-16','La Union','Bahamian','Catholic','','Elma','Orion','Deptula','Amusement Park Worker','202-555-0112','202-555-0195','','Winford','Cecile','Giesbrecht','Emcee','202-555-0199','202-555-0145','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,409,'2017-08-23 14:57:36',2),(7750,'New','Scanlan','Lourie','Morse','2010-04-18','Leyte','Welsh','Born again','','Shavon','Brinn','Slosser','Multi-operation Forming Machine Setter','202-555-0189','202-555-0173','','Carlton','Astra','Sparda','Strike Warfare/Missile Systems Officer','202-555-0100','202-555-0186','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,409,'2017-08-23 14:57:36',2),(7751,'Transferee','Sparda','Ronda','Astra','2006-07-18','Zamboanga del Sur','Norwegian','Protestant','','Vilma','Deirdre','Polya','Emcee','202-555-0183','202 - 555 - 0150','','Ed','Jocelyn','Plummer','Nursing Service Director','202-555-0132','202-555-0123','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,409,'2017-08-23 14:57:37',2),(7752,'New','Courval','Joanie','Katerina','2007-09-17','Benguet','CapeVerdean','Protestant','\0','Lillian','Alexio','Hiles','Cardroom Manager','202-555-0102','202-555-0109','','Frederick','Michele','Gurish','Drywall Applicator','202-555-0137','202-555-0145','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,409,'2017-08-23 14:57:37',2),(7753,'New','Ebeling','Carlota','Quinton','2006-05-11','Metro Manila','EquatorialGuinean','Taoism','\0','Lourie','Adaline','Polya','Short Story Writer','202-555-0175','202-555-0145','','Myles','Orion','Kasper','Multi-operation Forming Machine Setter','202-555-0187','202-555-0153','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:06:21',3),(7754,'New','Yaqub','Merissa','Atlanta','2010-11-22','Isabela','Comoran','Taoism','','Elsie','Darrick','Lackner','Nursing Service Director','202-555-0138','202-555-0170','\0','Ronda','Griffin','Hiles','Statistical Analyst','202-555-0123','202-555-0148','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:06:30',3),(7755,'New','Mcnicol','Soon','Millie','2006-11-18','Palawan','Palauan','Muslim','\0','Idalia','Quinton','Bertram','Ambulance Driver-Paramedic','202-555-0161','202-555-0100','\0','Elena','Clem','Norato','Professor of Communication and Writing','202-555-0135','202-555-0110','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:06:33',3),(7756,'New','Leis','Jeanice','Deirdre','2010-10-18','Guimaras','Mexican','Taoism','','Moses','Deirdre','Signon','Multi-operation Forming Machine Setter','202-555-0137','202-555-0104','','Janine','Michele','Valdez','Short Story Writer','202-555-0100','202-555-0123','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:06:35',3),(7757,'Transferee','Tanenbaum','Teddy','Loydie','2010-09-21','Leyte','Ni-Vanuatu','Protestant','\0','Jana','Barny','Morin','Piano Professor','202-555-0186','202-555-0137','\0','Dorothea','Oran','Lackner','Emcee','202-555-0161','202-555-0135','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:06:35',3),(7758,'New','Persky','Leonore','Morey','2011-02-14','Northern Samar','Tanzanian','Muslim','','Marissa','Millie','Lubit','Voice-Over Artist','202-555-0173','202-555-0197','','Stacee','Alexio','Ulam','Amusement Park Worker','202-555-0152','202-555-0186','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:06:37',3),(7759,'New','Balshaw','Winter','Harvey','2010-10-11','Marinduque','Romanian','Catholic','','Macy','Coralie','Glider','Tobacco Buyer','202-555-0186','202-555-0150','','Carlton','Yuma','Wallander','Strike Warfare/Missile Systems Officer','202-555-0138','202-555-0183','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:06:42',3),(7760,'Transferee','Korzennik','Tonja','Roderich','2011-08-15','Batanes','Liberian','Taoism','\0','Stormy','Bernardo','Von mehren','Gas Derrick Operator','202-555-0162','202-555-0138','\0','Stormy','Phyllys','Gurish','Freight Clerk','202-555-0148','202-555-0179','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:06:44',3),(7761,'New','Zarate','Teddy','Cecile','2006-02-26','Cavite','Bruneian','Protestant','','Karrie','Cecile','Hulbert','Professor of Communication and Writing','202-555-0170','202-555-0167','\0','Setsuko','Millie','Lord','Emcee','202-555-0110','202-555-0109','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:06:45',3),(7762,'New','Teutsch','Bridgette','Yuma','2008-07-11','Tarlac','TrinidadianorTobagonian','Born again','\0','Maren','Townie','Hiles','Lead Abatement Worker','202-555-0145','202-555-0199','','Moses','Loydie','Still','Custom Wood Stair Builder','202-555-0184','202-555-0199','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:06:46',3),(7763,'Transferee','Upsdell','Celestine','Clem','2006-07-11','Davao Oriental','Luxembourger','Taoism','','Edith','Conny','Lubit','Line Haul Driver','202-555-0123','202-555-0125','','Rikki','Coralie','Amsden','Short Story Writer','202-555-0179','202-555-0102','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:06:49',3),(7764,'Transferee','Lueders-booth','Alecia','Birgit','2009-11-12','Northern Samar','Motswana','Born again','','Serita','Tootsie','Lamarche','Gas Derrick Operator','202-555-0100','202-555-0179','\0','Frederick','Indira','Sassone','Line Haul Driver','202-555-0185','202-555-0132','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:06:56',3),(7765,'New','Arreguin','Soon','Roderich','2006-07-15','Quezon','Syrian','Catholic','','Apolonia','Mara','Sedcole','Cardroom Manager','202-555-0179','202-555-0105','\0','Maren','Mano','Venne','Statistical Analyst','202-555-0110','202-555-0109','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:06:59',3),(7766,'New','Milioli','Marissa','Riccardo','2010-09-18','Antique','Indonesian','Catholic','\0','Mariel','Clem','Clear','Voice-Over Artist','202-555-0114','202-555-0137','\0','Setsuko','Kendal','Fuchs','Strike Warfare/Missile Systems Officer','202-555-0114','202-555-0116','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:07:04',3),(7767,'New','Bilodeau','Lillian','Conny','2008-05-12','Negros Oriental','Vietnamese','Muslim','\0','Donte','Maegan','Schluter','AIDS Counselor','202-555-0148','202-555-0169','\0','Merissa','Clim','Valelly','Short Story Writer','202-555-0167','202-555-0189','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:07:09',3),(7768,'Transferee','Hulbert','Maren','Merrielle','2008-04-26','Davao del Sur','Nigerian','Born again','\0','Teddy','Ruddy','Hiles','Short Story Writer','202-555-0198','202-555-0195','','Meghan','Asia','Lubit','Freight Clerk','202-555-0145','202-555-0145','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:07:13',3),(7769,'New','Norato','Venetta','Mano','2006-04-26','Surigao del Sur','Icelander','Catholic','','Maragret','Efrem','Gurish','Social Psychologist','202-555-0132','202-555-0131','\0','Janine','Mara','Wallander','Strike Warfare/Missile Systems Officer','202-555-0169','202-555-0195','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:07:18',3),(7770,'Transferee','Teutsch','Elsie','Merrielle','2008-05-25','Zamboanga del Norte','Pakistani','Taoism','','Marshall','Crissie','Slosser','Drywall Applicator','202-555-0189','202-555-0195','\0','Ezra','Darrick','Shanley','Amusement Park Worker','202-555-0195','202-555-0173','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:07:35',3),(7771,'Transferee','Roussinos','Elena','Morey','2011-06-15','Ilocos Norte','Somali','Catholic','','Denna','Clem','Amadeo','Chiropractor','202-555-0195','202-555-0101','\0','Carisa','Charlotta','Gurish','AIDS Counselor','202-555-0183','202-555-0179','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:07:49',3),(7772,'Transferee','Glider','Setsuko','Millie','2008-07-28','Negros Oriental','Cameroonian','Catholic','','Alecia','Mano','Cocuzzo','Emcee','202-555-0173','202-555-0197','','Carlota','Coralie','Schluter','Amusement Park Worker','202-555-0150','202-555-0165','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:07:52',3),(7773,'New','Cady','Arica','Frans','2010-04-20','Compostela Valley','Argentinean','Protestant','','Shauna','Maegan','Roussinos','Chiropractor','202-555-0199','202-555-0102','\0','Brinda','Frans','Upsdell','Multi-operation Forming Machine Setter','202-555-0125','202-555-0190','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,302,407,'2017-08-23 16:07:55',3),(7774,'Transferee','Courval','Donte','Mara','2012-08-19','Pampanga','Colombian','Muslim','','Ebonie','Rogers','Prentice','Line Haul Driver','202-555-0131','202-555-0165','\0','Winter','Florette','Cocuzzo','Custom Wood Stair Builder','202-555-0148','202-555-0150','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:09:30',3),(7775,'Transferee','Bilodeau','Archie','Asia','2012-08-24','Laguna','SouthKorean','Protestant','','Michaela','Frans','Lord','Licensed Clinical Mental Health Counselor','202-555-0195','202-555-0198','\0','Shauna','Atlanta','Tanenbaum','Amusement Park Worker','202-555-0114','202-555-0100','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:09:35',3),(7776,'New','Funcke','Sean','Indira','2012-08-16','Mountain Province','Syrian','Muslim','','Erwin','Katerina','Zarate','Busser','202-555-0181','202-555-0199','\0','Venetta','Tull','Stigler','Freight Clerk','202-555-0109','202-555-0153','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:09:37',3),(7777,'New','Deptula','Mandi','Ransell','2012-01-19','Misamis Oriental','Lithuanian','Born again','\0','Stormy','Adaline','Norato','Chiropractor','202-555-0153','202-555-0181','\0','Teddy','Loydie','Upsdell','Cardroom Manager','202-555-0145','202-555-0183','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:09:39',3),(7778,'New','Orfe','Kaleigh','Morey','2012-08-22','Eastern Samar','Bolivian','Catholic','','Alecia','Adaline','Badulescu','Strike Warfare/Missile Systems Officer','202-555-0138','202-555-0185','','Mandi','Rogers','Bertram','Tobacco Buyer','202 - 555 - 0150','202-555-0199','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:09:41',3),(7779,'New','Liss','Leonore','Clem','2012-03-10','Benguet','Turkish','Catholic','','Mariel','Brinn','Thibodeau','Amusement Park Worker','202-555-0169','202-555-0174','\0','Michaela','Maegan','Prentice','Voice-Over Artist','202-555-0105','202-555-0105','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:09:43',3),(7780,'Transferee','Cady','Serita','Simonette','2012-04-14','Apayao','Bahraini','Born again','','Lynnette','Astra','Brewer','Piano Professor','202-555-0116','202-555-0198','\0','Rikki','Frans','Markussen','Chiropractor','202-555-0152','202-555-0179','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:09:45',3),(7781,'New','Bilodeau','Ebonie','Ransell','2012-04-16','Ilocos Norte','Nepalese','Catholic','\0','Dorothea','Aurlie','Still','Short Story Writer','202-555-0114','202-555-0170','\0','Marcellus','Melantha','Fuchs','Tobacco Buyer','202-555-0100','202-555-0104','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:09:49',3),(7782,'Transferee','Gurish','Setsuko','Charlotta','2012-09-16','Leyte','Tajik','Protestant','','Edith','Harvey','Lachenbruch','Nursing Service Director','202-555-0145','202-555-0167','','Stormy','Michele','Orfe','Strike Warfare/Missile Systems Officer','202-555-0150','202-555-0195','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:09:52',3),(7783,'New','Bronicki','Antionette','Mallorie','2012-09-18','Zamboanga del Norte','Croatian','Muslim','\0','Antionette','Marchall','Deptula','Emcee','202-555-0153','202-555-0153','\0','Michaela','Jocelyn','Trautman','Gas Derrick Operator','202-555-0170','202-555-0132','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:09:54',3),(7784,'New','Slosser','Joanie','Derrik','2012-07-19','Aklan','Polish','Taoism','','Tonja','Frans','Sedcole','Voice-Over Artist','202-555-0195','202-555-0145','','Maudie','Ruddy','Courval','Tobacco Buyer','202-555-0145','202-555-0105','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:09:55',3),(7785,'New','Bronicki','Mandi','Townie','2012-01-14','Sultan Kudarat','Salvadoran','Catholic','','Ai','Kendal','Klipp','Custom Wood Stair Builder','202-555-0116','202-555-0153','\0','Jeanice','Mara','Pesavento','Licensed Clinical Mental Health Counselor','202-555-0195','202-555-0199','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:09:58',3),(7786,'Transferee','Baino','Elma','Birgit','2012-08-17','Lanao del Sur','Irish','Muslim','\0','Marissa','Tull','Carty','Tobacco Buyer','202-555-0125','202-555-0170','\0','Ludivina','Jocelyn','Norato','Custom Wood Stair Builder','202-555-0139','202-555-0148','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:09:59',3),(7787,'New','Baskey','Jana','Scott','2012-06-25','Cagayan','Comoran','Protestant','\0','Ingrid','Audi','Signon','Drywall Applicator','202-555-0114','202-555-0199','\0','Eve','Melantha','Clear','Chiropractor','202-555-0197','202-555-0175','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:10:00',3),(7788,'Transferee','Hiles','Pattie','Aurlie','2012-11-14','Antique','Russian','Born again','','Hae','Tootsie','Teutsch','Short Story Writer','202-555-0179','202-555-0197','\0','Bridgette','Coralie','Decierdo','Ambulance Driver-Paramedic','202-555-0114','202-555-0195','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:10:01',3),(7789,'New','Fuchs','Teddy','Charlotta','2012-04-22','Zambales','Kenyan','Muslim','\0','Tonja','Maegan','Schluter','Tobacco Buyer','202-555-0175','202-555-0190','','Odette','Deborah','Morin','Statistical Analyst','202-555-0105','202-555-0177','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:10:02',3),(7790,'New','Kauppi','Leonel','Melantha','2012-02-14','Nueva Vizcaya','Palauan','Taoism','\0','Celestine','Simonette','Flowers','Gas Derrick Operator','202-555-0153','202-555-0139','\0','Tamekia','Charlotta','Naus','Lead Abatement Worker','202-555-0145','202-555-0161','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:10:03',3),(7791,'Transferee','Markussen','Alecia','Oran','2012-03-24','Camarines Norte','Maldivan','Catholic','','Lynnette','Corliss','Courval','Freight Clerk','202-555-0179','202-555-0189','\0','Kanisha','Craggie','Gurish','Custom Wood Stair Builder','202-555-0183','202-555-0177','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:10:03',3),(7792,'Transferee','Slosser','Sibyl','Asia','2012-04-21','Albay','Nigerien','Muslim','\0','Jesica','Orion','Valelly','Professor of Communication and Writing','202-555-0185','202-555-0101','\0','Carlota','Morley','Deptula','Piano Professor','202-555-0148','202-555-0183','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:10:05',3),(7793,'New','Tanenbaum','Lila','Frans','2012-03-15','Laguna','Australian','Muslim','\0','Apolonia','Claire','Persky','Piano Professor','202-555-0148','202-555-0186','','Dorothea','Mara','Kasper','Cardroom Manager','202-555-0189','202-555-0161','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:10:06',3),(7794,'Transferee','Verdile','Zena','Jessie','2012-07-24','Capiz','Sudanese','Catholic','\0','Carlton','Tedi','Verdile','Nursing Service Director','202-555-0101','202-555-0114','','Shauna','Loydie','Lachenbruch','Strike Warfare/Missile Systems Officer','202-555-0125','202-555-0135','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:10:10',3),(7795,'Transferee','Shanley','Erwin','Barny','2012-10-21','Mountain Province','Ecuadorean','Born again','','Jeanice','Aubrey','Scanlan','Strike Warfare/Missile Systems Officer','202-555-0100','202-555-0167','','Lila','Bernardo','Tanenbaum','Cardroom Manager','202-555-0116','202-555-0189','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:10:14',3),(7796,'New','Naus','Lynnette','Simonette','2012-04-14','Maguindanao','CostaRican','Protestant','\0','Marcellus','Alexio','Deptula','Emcee','202-555-0125','202-555-0187','','Elsie','Tull','Shanley','Statistical Analyst','202-555-0148','202-555-0185','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:10:24',3),(7797,'Transferee','Signon','Soon','Scott','2012-10-28','Pangasinan','Finnish','Protestant','','Janessa','Michele','Schluter','Molasses Preparer','202-555-0135','202-555-0135','','Myles','Maegan','Shanley','Multi-operation Forming Machine Setter','202-555-0132','202-555-0161','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:10:27',3),(7798,'New','Wallander','Carlota','Clem','2012-10-11','Oriental Mindoro','NewZealander','Muslim','\0','Maude','Morse','Stigler','Custom Wood Stair Builder','202-555-0114','202-555-0195','\0','Ezra','Aurlie','Bertram','Piano Professor','202-555-0153','202-555-0173','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,301,409,'2017-08-23 16:10:30',3),(7799,'New','Balshaw','Frederick','Ransell','2005-08-13','Palawan','Sudanese','Catholic','\0','Jana','Mara','Leis','Custom Wood Stair Builder','202-555-0139','202-555-0131','\0','Frederick','Mallorie','Orfe','Drywall Applicator','202-555-0112','202-555-0104','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,311,408,'2017-08-23 16:11:33',3),(7800,'New','Burke','Patricia','Corliss','2005-09-10','Batanes','Malawian','Catholic','\0','Jana','Roderich','Amsden','Multi-operation Forming Machine Setter','202-555-0165','202-555-0199','','Lynnette','Latia','Giesbrecht','Piano Professor','202-555-0198','202-555-0146','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,311,408,'2017-08-23 16:11:34',3),(7801,'New','Wilkin','Kaleigh','Millie','2002-01-25','Northern Samar','Vietnamese','Catholic','','Marissa','Simonette','Flowers','Chiropractor','202-555-0195','202-555-0145','','Vilma','Morey','Marston','Licensed Clinical Mental Health Counselor','202-555-0161','202-555-0152','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,311,408,'2017-08-23 16:11:35',3),(7802,'Transferee','El-shaarawi','Jesica','Adaline','2009-07-28','Laguna','Taiwanese','Born again','\0','Meghan','Simonette','Hiles','Custom Wood Stair Builder','202-555-0169','202-555-0152','','Sibyl','Skippie','Stewart','Short Story Writer','202-555-0195','202-555-0186','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:47',4),(7803,'Transferee','Mccarty','Loyce','Casey','2009-10-22','Capiz','Azerbaijani','Taoism','\0','Pattie','Cthrine','Baskey','Freight Clerk','202-555-0189','202-555-0109','\0','Pearle','Efrem','Bilodeau','Busser','202-555-0135','202-555-0170','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:48',4),(7804,'Transferee','Lackner','Venetta','Katerina','2006-04-16','Masbate','Rwandan','Born again','','Marissa','Charlotta','Amadeo','Custom Wood Stair Builder','202-555-0175','202-555-0145','\0','Archie','Maegan','Lord','Line Haul Driver','202-555-0186','202-555-0102','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:49',4),(7805,'New','Zarate','Winter','Marchall','2008-11-27','Metro Manila','Guinean','Protestant','','Shauna','Rogers','Tanenbaum','Chiropractor','202-555-0173','202-555-0165','','Pattie','Tootsie','Teutsch','Voice-Over Artist','202-555-0189','202-555-0165','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:50',4),(7806,'Transferee','Tanenbaum','Pearle','Adaline','2006-05-24','Bulacan','SierraLeonean','Muslim','\0','Shauna','Orion','Udall','Short Story Writer','202-555-0153','202-555-0152','','Bridgette','Derrik','Pesavento','Gas Derrick Operator','202-555-0101','202-555-0177','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:51',4),(7807,'New','Brake','Ronda','Tootsie','2006-03-26','Benguet','Motswana','Taoism','\0','Latashia','Marchall','Zarate','Tobacco Buyer','202-555-0123','202-555-0125','\0','Winter','Orion','Courval','AIDS Counselor','202-555-0199','202-555-0199','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:52',4),(7808,'Transferee','Fuchs','Edith','Thornie','2010-06-14','Pampanga','I-Kiribati','Catholic','\0','Teddy','Sidonia','Liss','Licensed Clinical Mental Health Counselor','202-555-0198','202-555-0102','','Elma','Casey','Sassone','Professor of Communication and Writing','202-555-0135','202-555-0105','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:52',4),(7809,'New','Thibodeau','Pearle','Astra','2011-03-11','Surigao del Sur','Belizean','Born again','','Celestine','Merrielle','Liss','Licensed Clinical Mental Health Counselor','202-555-0105','202-555-0114','\0','Eve','Jessie','Verdile','Cardroom Manager','202-555-0177','202-555-0132','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:53',4),(7810,'Transferee','Burke','Lilliana','Cecile','2011-01-12','Iloilo','Norwegian','Muslim','','Ai','Quinton','Maddox','Line Haul Driver','202-555-0161','202-555-0187','','Zena','Ruddy','Compton','Emcee','202-555-0100','202-555-0125','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:53',4),(7811,'Transferee','Russo','Ronda','Claire','2006-01-15','Camiguin','Algerian','Born again','\0','Pearle','Mara','Ebeling','Chiropractor','202-555-0125','202-555-0135','\0','Ronda','Crissie','Udall','Voice-Over Artist','202-555-0190','202-555-0163','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:54',4),(7812,'Transferee','Lamarche','Carlton','Astra','2006-03-22','Eastern Samar','Beninese','Muslim','\0','Lila','Darrick','Lueders-booth','Freight Clerk','202-555-0175','202-555-0167','','Antionette','Jocelyn','Roussinos','Voice-Over Artist','202-555-0167','202-555-0101','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:54',4),(7813,'Transferee','Udall','Teddy','Burk','2006-06-25','Aklan','Swedish','Born again','','Carlota','Crissie','Slosser','Nursing Service Director','202-555-0100','202-555-0145','','Ronda','Astra','Rickles','Gas Derrick Operator','202-555-0173','202-555-0169','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:55',4),(7814,'Transferee','Zarate','Melia','Mara','2007-05-27','South Cotabato','Czech','Protestant','\0','Lila','Morse','Milioli','Professor of Communication and Writing','202-555-0105','202-555-0116','','Marshall','Frans','Balshaw','Multi-operation Forming Machine Setter','202-555-0170','202-555-0102','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:56',4),(7815,'Transferee','Mccarty','Donte','Scott','2006-01-21','Guimaras','Nigerian','Muslim','\0','Elena','Craggie','Korzennik','Amusement Park Worker','202-555-0112','202-555-0100','\0','Ed','Michele','Markussen','Freight Clerk','202-555-0150','202-555-0116','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:56',4),(7816,'New','Amadeo','Idalia','Florette','2009-04-23','Ifugao','Hungarian','Protestant','','Elmo','Craggie','Russo','Amusement Park Worker','202-555-0104','202-555-0199','','Mandi','Florette','Baino','Molasses Preparer','202-555-0197','202-555-0185','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:58',4),(7817,'New','Von mehren','Shavon','Craggie','2010-09-13','Misamis Oriental','Seychellois','Born again','\0','Elmo','Cathie','Klipp','AIDS Counselor','202-555-0167','202-555-0186','','Winter','Kendal','Fuchs','Social Psychologist','202-555-0183','202-555-0197','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:58',4),(7818,'Transferee','Plummer','Shavon','Lindy','2007-03-23','Bohol','Barbadian','Catholic','\0','Kanisha','Aubrey','Brewer','Tobacco Buyer','202-555-0173','202-555-0173','','Elsie','Cathie','Markussen','Piano Professor','202-555-0184','202-555-0138','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:13:59',4),(7819,'New','Courval','Erwin','Coralie','2011-08-26','Camarines Norte','Jamaican','Born again','','Stacee','Deirdre','Lueders-booth','Lead Abatement Worker','202-555-0175','202-555-0165','','Elma','Maegan','Rickles','AIDS Counselor','202-555-0123','202-555-0105','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:00',4),(7820,'New','Orfe','Rosa','Skippie','2008-07-14','Aklan','Panamanian','Protestant','\0','Rosa','Tull','Shanley','Piano Professor','202-555-0177','202-555-0150','\0','Marissa','Darrick','Giesbrecht','Strike Warfare/Missile Systems Officer','202-555-0190','202-555-0195','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:00',4),(7821,'Transferee','Cepko','Elsie','Millie','2008-05-17','Quezon','SaintLucian','Taoism','','Serita','Craggie','Sassone','Short Story Writer','202-555-0150','202-555-0179','\0','Madeleine','Astra','Plummer','Molasses Preparer','202-555-0102','202-555-0163','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:01',4),(7822,'Transferee','Balshaw','Ezra','Aubrey','2006-10-25','Nueva Ecija','Omani','Born again','\0','Arica','Indira','Zarate','Licensed Clinical Mental Health Counselor','202-555-0152','202-555-0175','','Carlota','Clim','Mccarty','Amusement Park Worker','202-555-0177','202-555-0175','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:01',4),(7823,'Transferee','Prentice','Eve','Griffin','2009-01-25','Negros Occidental','Mozambican','Catholic','','Eve','Asia','Lord','Tobacco Buyer','202-555-0198','202-555-0190','','Rosa','Derrik','Morin','Busser','202-555-0161','202-555-0125','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:02',4),(7824,'New','Funcke','Lillian','Florette','2009-01-20','Bataan','Tajik','Taoism','','Rona','Casey','Klipp','Busser','202-555-0110','202-555-0100','\0','Maragret','Quinton','Arreguin','Gas Derrick Operator','202-555-0195','202-555-0170','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:02',4),(7825,'New','Lord','Stacee','Coralie','2006-02-18','Capiz','Uruguayan','Taoism','\0','Antionette','Claire','Dernburg','Strike Warfare/Missile Systems Officer','202-555-0123','202-555-0175','\0','Vilma','Quinton','Glider','Short Story Writer','202-555-0187','202-555-0190','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:03',4),(7826,'New','Lueders-booth','Rona','Oran','2009-04-20','Ilocos Sur','CentralAfrican','Catholic','','Pearle','Burk','Dernburg','Custom Wood Stair Builder','202-555-0190','202-555-0177','','Bridgette','Quinton','Compton','Chiropractor','202-555-0195','202-555-0123','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:05',4),(7827,'Transferee','Sparda','Madeleine','Cecile','2008-06-27','Palawan','CostaRican','Catholic','','Winford','Aubrey','Schluter','Gas Derrick Operator','202-555-0148','202-555-0169','\0','Donte','Bernardo','Compton','Busser','202-555-0165','202-555-0131','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:05',4),(7828,'New','Morin','Delcie','Michele','2011-01-27','Ilocos Sur','I-Kiribati','Muslim','\0','Elena','Alexio','Teutsch','Drywall Applicator','202-555-0112','202-555-0139','','Tonja','Pen','Lachenbruch','Nursing Service Director','202-555-0145','202-555-0185','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:07',4),(7829,'Transferee','Balshaw','Maragret','Skippie','2007-06-17','Rizal','Venezuelan','Taoism','','Erwin','Jessie','Zarate','Ambulance Driver-Paramedic','202-555-0138','202-555-0105','','Loyce','Indira','Orfe','Busser','202-555-0190','202-555-0105','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:07',4),(7830,'Transferee','Dernburg','Leonore','Craggie','2008-09-25','Ilocos Sur','Portuguese','Muslim','\0','Ruth','Cecile','Metropolis','Freight Clerk','202-555-0186','202-555-0112','','Shauna','Tedi','Bertram','Amusement Park Worker','202-555-0175','202-555-0145','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:08',4),(7831,'New','Yaqub','Lynnette','Yuma','2010-03-10','Kalinga','Congolese','Catholic','\0','Carlota','Charlotta','Arreguin','Tobacco Buyer','202-555-0153','202-555-0116','\0','Yoshiko','Charlotta','Slosser','Molasses Preparer','202-555-0145','202-555-0183','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:09',4),(7832,'Transferee','Lubit','Lila','Yuma','2010-09-28','Bohol','EquatorialGuinean','Muslim','\0','Carlton','Jessie','Roussinos','Licensed Clinical Mental Health Counselor','202-555-0102','202-555-0179','\0','Margorie','Townie','Giesbrecht','Short Story Writer','202-555-0148','202-555-0125','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:09',4),(7833,'Transferee','Sassone','Pearle','Cecile','2006-10-26','Aklan','Dutchman','Catholic','\0','Shauna','Clim','Teutsch','Short Story Writer','202-555-0132','202-555-0139','\0','Myles','Loydie','Arreguin','Emcee','202-555-0183','202-555-0165','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:10',4),(7834,'Transferee','Brewer','Marcellus','Sidonia','2010-06-28','Negros Occidental','Welsh','Born again','','Ronda','Pen','Naus','Short Story Writer','202-555-0110','202-555-0146','','Zena','Orion','Roussinos','AIDS Counselor','202-555-0174','202-555-0145','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:10',4),(7835,'Transferee','Morin','Sean','Pen','2006-11-25','Lanao del Norte','Indian','Born again','','Maude','Brinn','Tanenbaum','Social Psychologist','202-555-0197','202-555-0132','\0','Eve','Michele','Venne','Freight Clerk','202-555-0175','202-555-0110','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:11',4),(7836,'Transferee','Wallander','Rosa','Scott','2011-01-23','Misamis Oriental','Syrian','Taoism','','Lourie','Sidonia','Schluter','Gas Derrick Operator','202-555-0189','202-555-0183','\0','Joana','Millie','Balshaw','Voice-Over Artist','202-555-0189','202-555-0145','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:12',4),(7837,'Transferee','Rickles','Antionette','Harvey','2009-03-28','Aklan','Angolan','Protestant','\0','Pattie','Barny','Amadeo','Molasses Preparer','202-555-0139','202-555-0100','\0','Setsuko','Rogers','Bertram','Piano Professor','202-555-0146','202-555-0100','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:13',4),(7838,'New','Scanlan','Michaela','Griffin','2011-01-27','Iloilo','Mauritian','Catholic','\0','Joana','Tootsie','Venne','Short Story Writer','202-555-0175','202-555-0102','\0','Pattie','Birgit','Sparda','Multi-operation Forming Machine Setter','202-555-0161','202-555-0138','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:14',4),(7839,'New','Korzennik','Teddy','Jocelyn','2007-09-24','Oriental Mindoro','CapeVerdean','Born again','','Lynnette','Katerina','Slosser','Short Story Writer','202-555-0195','202-555-0105','\0','Rikki','Indira','Brake','AIDS Counselor','202-555-0123','202-555-0100','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:15',4),(7840,'New','Amadeo','Denna','Lindy','2011-04-14','Bataan','Motswana','Taoism','\0','Celestine','Yuma','Roussinos','Licensed Clinical Mental Health Counselor','202-555-0146','202-555-0153','\0','Ludivina','Orion','Lueders-booth','Lead Abatement Worker','202-555-0169','202-555-0185','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:16',4),(7841,'New','Sedcole','Latashia','Oran','2009-08-14','Oriental Mindoro','Singaporean','Protestant','\0','Dorothea','Simonette','Roussinos','Short Story Writer','202-555-0185','202-555-0185','\0','Vilma','Darrick','Lockhart','Lead Abatement Worker','202-555-0183','202-555-0110','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:16',4),(7842,'Transferee','Carty','Antionette','Corliss','2008-09-13','Surigao del Sur','Ugandan','Catholic','\0','Janine','Clem','El-shaarawi','Custom Wood Stair Builder','202-555-0177','202-555-0109','','Mariel','Rogers','Norato','Strike Warfare/Missile Systems Officer','202-555-0187','202-555-0199','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:17',4),(7843,'Transferee','Wilkin','Madeleine','Riccardo','2008-03-20','Negros Occidental','SierraLeonean','Born again','','Jesica','Casey','Lueders-booth','Line Haul Driver','202-555-0125','202-555-0173','\0','Kaleigh','Indira','Balshaw','Chiropractor','202-555-0174','202-555-0165','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:17',4),(7844,'New','Amadeo','Patricia','Yuma','2008-11-11','Misamis Oriental','Filipino','Muslim','','Ezra','Jocelyn','Mcnicol','Piano Professor','202-555-0189','202-555-0123','','Shavon','Simonette','Signon','Gas Derrick Operator','202-555-0179','202-555-0179','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:18',4),(7845,'New','Rickles','Setsuko','Bernardo','2011-03-23','La Union','Greek','Muslim','\0','Johnsie','Marchall','Plummer','Strike Warfare/Missile Systems Officer','202-555-0148','202-555-0199','\0','Elmo','Bernardo','Glider','Voice-Over Artist','202-555-0123','202-555-0145','\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:19',4),(7846,'Transferee','Slosser','Celestine','Michele','2006-02-16','Shariff Kabunsuan','Barbudans','Muslim','','Kaleigh','Orion','Persky','Nursing Service Director','202-555-0139','202-555-0116','','Venetta','Riccardo','Zarate','Licensed Clinical Mental Health Counselor','202-555-0102','202-555-0174','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:19',4),(7847,'Transferee','Glider','Vilma','Morse','2006-01-20','Camiguin','Azerbaijani','Muslim','','Dorothea','Loydie','Courval','Statistical Analyst','202-555-0163','202-555-0123','\0','Ai','Riccardo','Kasper','Lead Abatement Worker','202-555-0195','202-555-0169','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,305,407,'2017-08-23 16:14:20',4),(7848,'New','Fajardo','Jocel','X.','2010-00-01','Manila','American','Catholic','','','','','','','','\0','','','','','','','\0','','','','','','','','\0','','','\0','','','','','',303,407,'2017-08-23 17:02:29',2);
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
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_mt`
--

LOCK TABLES `room_mt` WRITE;
/*!40000 ALTER TABLE `room_mt` DISABLE KEYS */;
INSERT INTO `room_mt` VALUES (15,'300','Building  300',30,'','2017-08-19 15:06:37'),(16,'301','Building  301',30,'','2017-08-19 15:06:37'),(17,'302','Building  302',30,'','2017-08-19 15:06:37'),(18,'303','Building  303',30,'','2017-08-19 15:06:37'),(19,'304','Building  304',30,'','2017-08-19 15:06:37'),(20,'305','Building  305',30,'','2017-08-19 15:06:37'),(21,'306','Building  306',30,'','2017-08-19 15:06:38'),(22,'307','Building  307',30,'','2017-08-19 15:06:38'),(23,'308','Building  308',30,'','2017-08-19 15:06:38'),(24,'309','Building  309',30,'','2017-08-19 15:06:38'),(25,'310','Building  310',30,'','2017-08-19 15:06:38'),(26,'311','Building  311',30,'','2017-08-19 15:06:38'),(27,'312','Building  312',30,'','2017-08-19 15:06:38'),(28,'313','Building  313',30,'','2017-08-19 15:06:38'),(29,'314','Building  314',30,'','2017-08-19 15:06:38'),(30,'315','Building  315',30,'','2017-08-19 15:06:39'),(31,'316','Building  316',30,'','2017-08-19 15:06:39'),(32,'317','Building  317',30,'','2017-08-19 15:06:39'),(33,'318','Building  318',30,'','2017-08-19 15:06:39'),(34,'319','Building  319',30,'','2017-08-19 15:06:39'),(35,'320','Building  320',30,'','2017-08-19 15:06:39'),(36,'321','Building  321',30,'','2017-08-19 15:06:39'),(37,'322','Building  322',30,'','2017-08-19 15:06:39'),(38,'323','Building  323',30,'','2017-08-19 15:06:40'),(39,'324','Building  324',30,'','2017-08-19 15:06:40'),(40,'325','Building  325',30,'','2017-08-19 15:06:40'),(41,'326','Building  326',30,'','2017-08-19 15:06:40'),(42,'327','Building  327',30,'','2017-08-19 15:06:40'),(43,'328','Building  328',30,'','2017-08-19 15:06:40'),(44,'329','Building  329',30,'','2017-08-19 15:06:40'),(45,'330','Building  330',30,'','2017-08-19 15:06:41'),(46,'331','Building  331',30,'','2017-08-19 15:06:41'),(47,'332','Building  332',30,'','2017-08-19 15:06:41'),(48,'333','Building  333',30,'','2017-08-19 15:06:41'),(49,'334','Building  334',30,'','2017-08-19 15:06:41'),(50,'335','Building  335',30,'','2017-08-19 15:06:41'),(51,'336','Building  336',30,'','2017-08-19 15:06:41'),(52,'337','Building  337',30,'','2017-08-19 15:06:41'),(53,'338','Building  338',30,'','2017-08-19 15:06:41'),(54,'339','Building  339',30,'','2017-08-19 15:06:41'),(55,'340','Building  340',30,'','2017-08-19 15:06:42'),(56,'341','Building  341',30,'','2017-08-19 15:06:42'),(57,'342','Building  342',30,'','2017-08-19 15:06:42'),(58,'343','Building  343',30,'','2017-08-19 15:06:42'),(59,'344','Building  344',30,'','2017-08-19 15:06:42'),(60,'345','Building  345',30,'','2017-08-19 15:06:42'),(61,'346','Building  346',30,'','2017-08-19 15:06:42'),(62,'347','Building  347',30,'','2017-08-19 15:06:43'),(63,'348','Building  348',30,'','2017-08-19 15:06:43'),(64,'349','Building  349',30,'','2017-08-19 15:06:43'),(65,'350','Building  350',30,'','2017-08-19 15:06:43');
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
  `schedule_day` varchar(10) NOT NULL COMMENT 'Values to contain are \n\nM, T, W, TH, F, S, SU ',
  `startTime` int(11) NOT NULL,
  `endTime` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `section_id` int(11) DEFAULT NULL,
  `room_id` int(11) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  `gradelevel_id` int(11) NOT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `class_schedule_TABLE_roomId_COL_idx` (`room_id`),
  KEY `fk_class_schedule_TABLE_subjectId_COLUMN_idx` (`subject_id`),
  KEY `fk_scheduleTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_scheduleTABLE_section_idCOL_idx` (`section_id`),
  KEY `fk_scheduleTABLE_gradelevel_idCOL_idx` (`gradelevel_id`),
  CONSTRAINT `fk_scheduleTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_scheduleTABLE_room_idCOL` FOREIGN KEY (`room_id`) REFERENCES `room_mt` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_scheduleTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_scheduleTABLE_section_idCOL` FOREIGN KEY (`section_id`) REFERENCES `section_mt` (`section_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_scheduleTABLE_subject_idCOL` FOREIGN KEY (`subject_id`) REFERENCES `subject_mt` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_mt`
--

LOCK TABLES `schedule_mt` WRITE;
/*!40000 ALTER TABLE `schedule_mt` DISABLE KEYS */;
INSERT INTO `schedule_mt` VALUES (2,'Mon',800,900,407,525,41,15,'',302),(3,'Mon',900,1000,407,526,41,15,'',302),(4,'Mon',700,800,407,538,45,17,'',303),(5,'Mon',800,900,407,539,45,17,'',303),(6,'Mon',900,1000,407,540,45,17,'',303),(7,'Mon',900,1000,407,541,45,17,'',303),(8,'Mon',1100,1200,407,542,45,17,'',303),(9,'Mon',100,200,407,543,45,17,'',303),(10,'Mon',200,300,407,544,45,17,'',303),(11,'Mon',300,400,407,545,45,17,'',303),(12,'Mon',700,800,407,525,38,15,'',302),(13,'Mon',800,900,407,526,38,15,'',302),(14,'Mon',900,1000,407,527,38,15,'',302),(15,'Mon',1000,1100,407,528,38,15,'',302),(16,'Mon',1100,1200,407,529,38,15,'',302),(17,'Mon',1200,1300,407,530,38,15,'',302),(18,'Mon',700,715,407,538,52,15,'',303),(19,'Mon',900,1015,407,539,52,15,'',303),(20,'Mon',1015,1115,407,540,52,15,'',303),(21,'Mon',1115,1215,407,541,52,15,'',303),(22,'Mon',700,800,407,525,35,15,'',302),(23,'Mon',800,900,407,526,35,15,'',302),(24,'Mon',900,1000,407,527,35,15,'',302),(25,'Mon',1000,1100,407,528,35,15,'',302),(26,'Mon',1100,1200,407,529,35,15,'',302),(27,'Mon',700,800,407,525,94,15,'',302),(28,'Mon',800,900,407,526,94,15,'',302),(29,'Mon',900,1000,407,527,94,15,'',302),(30,'Mon',1100,1200,407,528,94,15,'',302),(31,'Mon',1300,1400,407,529,94,15,'',302),(32,'Tue',700,800,407,527,53,15,'',303),(33,'Tue',800,900,407,526,53,15,'',303),(34,'Tue',1000,1100,407,528,53,15,'',303),(35,'Tue',1100,1200,407,525,53,15,'',303),(36,'Tue',1200,1300,407,529,53,15,'',303),(37,'Tue',700,800,407,527,53,15,'',303),(38,'Tue',800,900,407,526,53,15,'',303),(39,'Tue',1000,1100,407,528,53,15,'',303),(40,'Tue',1100,1200,407,525,53,15,'',303),(41,'Tue',1200,1300,407,529,53,15,'',303),(42,'Tue',700,800,407,527,53,15,'',303),(43,'Tue',800,900,407,526,53,15,'',303),(44,'Tue',1000,1100,407,528,53,15,'',303),(45,'Tue',1100,1200,407,525,53,15,'',303),(46,'Tue',1200,1300,407,529,53,15,'',303),(47,'Tue',700,800,407,527,53,15,'',303),(48,'Tue',800,900,407,526,53,15,'',303),(49,'Tue',1000,1100,407,528,53,15,'',303),(50,'Tue',1100,1200,407,525,53,15,'',303),(51,'Tue',1200,1300,407,529,53,15,'',303),(52,'Tue',700,800,407,527,53,15,'',303),(53,'Tue',800,900,407,526,53,15,'',303),(54,'Tue',1000,1100,407,528,53,15,'',303),(55,'Tue',1100,1200,407,525,53,15,'',303),(56,'Tue',1200,1300,407,529,53,15,'',303),(57,'Wed',1200,1300,407,539,53,18,'',303),(58,'Wed',1300,1400,407,540,53,18,'',303),(59,'Mon',700,800,407,539,50,15,'',303),(60,'Mon',800,900,407,540,50,15,'',303),(61,'Mon',900,1000,407,543,50,15,'',303),(62,'Mon',1000,1100,407,549,50,15,'',303),(63,'Tue',700,800,407,549,50,15,'',303),(64,'Tue',800,900,407,550,50,15,'',303),(65,'Tue',900,1000,407,540,50,15,'',303),(66,'Tue',1000,1100,407,548,50,15,'',303),(67,'Wed',700,800,407,549,50,15,'',303),(68,'Wed',800,900,407,547,50,15,'',303),(69,'Wed',900,1000,407,548,50,15,'',303),(70,'Wed',1000,1100,407,541,50,15,'',303),(71,'Thu',700,800,407,538,50,15,'',303),(72,'Thu',800,900,407,548,50,15,'',303),(73,'Thu',900,1000,407,549,50,15,'',303),(74,'Thu',1000,1100,407,541,50,15,'',303),(75,'Fri',700,800,407,549,50,15,'',303),(76,'Fri',800,900,407,550,50,15,'',303),(77,'Fri',900,1000,407,540,50,15,'',303),(78,'Fri',1000,1100,407,541,50,15,'',303);
/*!40000 ALTER TABLE `schedule_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolyear_holiday_lt`
--

DROP TABLE IF EXISTS `schoolyear_holiday_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolyear_holiday_lt` (
  `schoolyear_holiday_id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolyear_id` int(11) NOT NULL,
  `holiday_id` int(11) NOT NULL,
  PRIMARY KEY (`schoolyear_holiday_id`),
  KEY `fk_schoolyear_holiday_ltTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_schoolyear_holiday_ltTABLE_holiday_idCOL_idx` (`holiday_id`),
  CONSTRAINT `fk_schoolyear_holiday_ltTABLE_holiday_idCOL` FOREIGN KEY (`holiday_id`) REFERENCES `holiday_mt` (`holiday_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schoolyear_holiday_ltTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolyear_holiday_lt`
--

LOCK TABLES `schoolyear_holiday_lt` WRITE;
/*!40000 ALTER TABLE `schoolyear_holiday_lt` DISABLE KEYS */;
INSERT INTO `schoolyear_holiday_lt` VALUES (54,425,5),(55,425,6),(56,425,7),(57,425,8),(58,425,9),(59,425,10),(60,425,11),(61,425,12);
/*!40000 ALTER TABLE `schoolyear_holiday_lt` ENABLE KEYS */;
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
  `isCurrentSchoolYear` bit(1) DEFAULT b'0',
  `total_class_hours` int(11) NOT NULL,
  PRIMARY KEY (`schoolyear_id`),
  UNIQUE KEY `yearFrom_UNIQUE` (`yearFrom`),
  UNIQUE KEY `yearTo_UNIQUE` (`yearTo`)
) ENGINE=InnoDB AUTO_INCREMENT=427 DEFAULT CHARSET=latin1 COMMENT='School Year Master Table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolyear_mt`
--

LOCK TABLES `schoolyear_mt` WRITE;
/*!40000 ALTER TABLE `schoolyear_mt` DISABLE KEYS */;
INSERT INTO `schoolyear_mt` VALUES (407,2017,2018,'\0','2017-06-01','2018-03-01','',0),(408,2018,2019,'\0','2018-06-01','2019-03-01','\0',0),(409,2016,2017,'\0','2016-06-01','2017-05-30','\0',0),(425,2019,2020,'\0','2019-01-01','2020-01-01','\0',1325),(426,2020,2021,'\0','2020-01-01','2021-01-01','\0',1000);
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
  `quarter_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `isCurrentQuarter` bit(1) NOT NULL DEFAULT b'0',
  UNIQUE KEY `uc_schoolyear_idCOL_semester_idCOL` (`schoolyear_id`,`quarter_id`),
  KEY `fk_schoolyear_quarter_ltTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_schoolyear_semester_ltTABLE_quarter_idCOL_idx` (`quarter_id`),
  CONSTRAINT `fk_schoolyear_quarter_ltTABLE_quarter_idCOL` FOREIGN KEY (`quarter_id`) REFERENCES `quarter_mt` (`quarter_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schoolyear_quarter_ltTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolyear_quarter_lt`
--

LOCK TABLES `schoolyear_quarter_lt` WRITE;
/*!40000 ALTER TABLE `schoolyear_quarter_lt` DISABLE KEYS */;
INSERT INTO `schoolyear_quarter_lt` VALUES (425,45,'2019-01-01','2019-03-01','\0'),(425,46,'2019-04-01','2019-06-01','\0'),(425,47,'2019-07-01','2019-09-01','\0'),(425,48,'2019-10-01','2020-12-01','\0'),(426,49,'2020-01-01','2020-03-01','\0'),(426,50,'2020-04-01','2020-06-01','\0'),(426,51,'2020-07-01','2020-09-01','\0'),(426,52,'2020-10-01','2021-01-01','\0');
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
  `schoolyear_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `gradelevel_id` int(11) NOT NULL,
  `section_id` int(11) DEFAULT NULL,
  `passed` bit(1) DEFAULT NULL,
  `isActive` bit(1) DEFAULT b'1',
  UNIQUE KEY `uk_schoolyear_IdCOL_student_idCOL_gradelevel_idCOL` (`schoolyear_id`,`student_id`,`gradelevel_id`),
  KEY `fk_schoolyear_student_ltTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_schoolyear_student_ltTABLE_student_idCOL_idx` (`student_id`),
  KEY `fk_schoolyear_student_ltTABLE_gradelevel_idCOL_idx` (`gradelevel_id`),
  CONSTRAINT `fk_schoolyear_student_ltTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schoolyear_student_ltTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schoolyear_student_ltTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolyear_student_lt`
--

LOCK TABLES `schoolyear_student_lt` WRITE;
/*!40000 ALTER TABLE `schoolyear_student_lt` DISABLE KEYS */;
INSERT INTO `schoolyear_student_lt` VALUES (407,38,302,35,NULL,''),(407,39,302,35,NULL,''),(407,40,302,35,NULL,''),(407,41,302,41,NULL,''),(407,42,302,35,NULL,''),(407,43,302,38,NULL,''),(407,44,302,38,NULL,''),(407,45,302,38,NULL,''),(407,46,302,38,NULL,''),(407,47,302,38,NULL,''),(407,48,302,38,NULL,''),(407,49,302,38,NULL,''),(407,50,302,38,NULL,''),(407,51,302,38,NULL,''),(407,52,302,38,NULL,''),(407,53,302,49,NULL,''),(407,54,302,49,NULL,''),(407,55,302,49,NULL,''),(407,56,302,49,NULL,''),(407,57,302,49,NULL,''),(407,58,302,49,NULL,''),(407,59,302,49,NULL,''),(407,60,302,49,NULL,''),(407,61,302,NULL,NULL,''),(407,62,302,NULL,NULL,''),(407,63,302,NULL,NULL,''),(407,64,302,NULL,NULL,''),(407,65,302,NULL,NULL,''),(407,66,302,NULL,NULL,''),(407,67,302,NULL,NULL,''),(407,68,302,NULL,NULL,''),(407,69,302,NULL,NULL,''),(407,70,302,NULL,NULL,''),(407,71,302,NULL,NULL,''),(407,72,302,NULL,NULL,''),(407,73,302,NULL,NULL,''),(407,74,302,NULL,NULL,''),(407,75,302,NULL,NULL,''),(407,76,302,NULL,NULL,''),(407,77,302,NULL,NULL,''),(407,78,302,NULL,NULL,''),(407,79,302,NULL,NULL,''),(407,80,302,NULL,NULL,''),(407,81,302,NULL,NULL,''),(407,82,302,NULL,NULL,''),(407,83,302,NULL,NULL,''),(407,84,302,NULL,NULL,''),(407,85,302,NULL,NULL,''),(407,86,302,NULL,NULL,''),(407,87,302,NULL,NULL,''),(407,88,302,NULL,NULL,''),(407,89,302,NULL,NULL,''),(407,90,302,NULL,NULL,''),(407,91,302,NULL,NULL,''),(407,92,301,NULL,NULL,''),(407,93,301,NULL,NULL,''),(407,94,301,NULL,NULL,''),(407,95,301,NULL,NULL,''),(407,96,301,NULL,NULL,''),(407,97,301,NULL,NULL,''),(407,98,301,NULL,NULL,''),(407,99,301,NULL,NULL,''),(407,100,301,NULL,NULL,''),(407,101,301,NULL,NULL,''),(407,102,301,NULL,NULL,''),(407,103,301,NULL,NULL,''),(407,104,301,NULL,NULL,''),(407,105,301,NULL,NULL,''),(407,106,301,NULL,NULL,''),(407,107,301,NULL,NULL,''),(407,108,301,NULL,NULL,''),(407,109,301,NULL,NULL,''),(407,110,301,NULL,NULL,''),(407,111,301,NULL,NULL,''),(407,112,301,NULL,NULL,''),(407,113,301,NULL,NULL,''),(407,114,301,NULL,NULL,''),(407,115,301,NULL,NULL,''),(407,116,301,NULL,NULL,''),(407,117,311,NULL,NULL,''),(407,118,311,NULL,NULL,''),(407,119,311,NULL,NULL,''),(407,120,305,NULL,NULL,''),(407,121,305,NULL,NULL,''),(407,122,305,NULL,NULL,''),(407,123,305,NULL,NULL,''),(407,124,305,NULL,NULL,''),(407,125,305,NULL,NULL,''),(407,126,305,NULL,NULL,''),(407,127,305,NULL,NULL,''),(407,128,305,NULL,NULL,''),(407,129,305,NULL,NULL,''),(407,130,305,NULL,NULL,''),(407,131,305,NULL,NULL,''),(407,132,305,NULL,NULL,''),(407,133,305,NULL,NULL,''),(407,134,305,NULL,NULL,''),(407,135,305,NULL,NULL,''),(407,136,305,NULL,NULL,''),(407,137,305,NULL,NULL,''),(407,138,305,NULL,NULL,''),(407,139,305,NULL,NULL,''),(407,140,305,NULL,NULL,''),(407,141,305,NULL,NULL,''),(407,142,305,NULL,NULL,''),(407,143,305,NULL,NULL,''),(407,144,305,NULL,NULL,''),(407,145,305,NULL,NULL,''),(407,146,305,NULL,NULL,''),(407,147,305,NULL,NULL,''),(407,148,305,NULL,NULL,''),(407,149,305,NULL,NULL,''),(407,150,305,NULL,NULL,''),(407,151,305,NULL,NULL,''),(407,152,305,NULL,NULL,''),(407,153,305,NULL,NULL,''),(407,154,305,NULL,NULL,''),(407,155,305,NULL,NULL,''),(407,156,305,NULL,NULL,''),(407,157,305,NULL,NULL,''),(407,158,305,NULL,NULL,''),(407,159,305,NULL,NULL,''),(407,160,305,NULL,NULL,''),(407,161,305,NULL,NULL,''),(407,162,305,NULL,NULL,''),(407,163,305,NULL,NULL,''),(407,164,305,NULL,NULL,''),(407,165,305,NULL,NULL,''),(407,166,303,50,NULL,'');
/*!40000 ALTER TABLE `schoolyear_student_lt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolyear_summer_schedule`
--

DROP TABLE IF EXISTS `schoolyear_summer_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolyear_summer_schedule` (
  `schoolyear_summer_schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolyear_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`schoolyear_summer_schedule_id`),
  KEY `fk_schoolyear_summer_scheduleTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_schoolyear_summer_scheduleTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolyear_summer_schedule`
--

LOCK TABLES `schoolyear_summer_schedule` WRITE;
/*!40000 ALTER TABLE `schoolyear_summer_schedule` DISABLE KEYS */;
INSERT INTO `schoolyear_summer_schedule` VALUES (3,425,'2019-07-01','2019-08-01','2017-07-08 10:36:20',''),(4,426,'2020-05-01','2020-06-01','2017-08-12 10:40:56','');
/*!40000 ALTER TABLE `schoolyear_summer_schedule` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=latin1 COMMENT='Master table for storing all sections only. Students sections information will be put on a different table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_mt`
--

LOCK TABLES `section_mt` WRITE;
/*!40000 ALTER TABLE `section_mt` DISABLE KEYS */;
INSERT INTO `section_mt` VALUES (34,'Mars','','2017-07-31 12:05:36'),(35,'Jupiter','','2017-07-31 12:05:36'),(36,'Mercury','','2017-07-31 12:05:36'),(37,'Pluto','','2017-07-31 12:05:36'),(38,'Daisy','','2017-08-01 13:31:55'),(39,'courage','','2017-08-01 19:32:10'),(40,'Hope','','2017-08-01 19:39:03'),(41,'Dell','','2017-08-01 19:42:05'),(43,'Acer','','2017-08-01 19:47:59'),(44,'tessalonaica','','2017-08-04 15:31:11'),(45,'loyalty','','2017-08-04 15:37:55'),(46,'Samsung','','2017-08-15 21:09:55'),(47,'Creative','','2017-08-16 15:33:41'),(48,'Faithful','','2017-08-16 15:52:18'),(49,'Saturn','','2017-08-21 17:45:24'),(50,'Santan','','2017-08-21 17:48:38'),(52,'Gumamela','','2017-08-21 18:10:53'),(53,'Rose','','2017-08-21 18:18:45'),(54,'Faith','','2017-08-21 18:19:33'),(55,'Honesty','','2017-08-21 18:20:11'),(56,'Compassion','','2017-08-21 18:21:55'),(57,'Integrity','','2017-08-21 18:22:21'),(58,'Einstein','','2017-08-21 18:23:31'),(59,'Darwin','','2017-08-21 18:23:40'),(60,'Edison','','2017-08-21 18:24:37'),(61,'Marconi','','2017-08-21 18:25:11'),(62,'Narra','','2017-08-21 18:25:59'),(63,'Mahogany','','2017-08-21 18:26:12'),(64,'Willow','','2017-08-21 18:26:51'),(65,'Oak','','2017-08-21 18:27:18'),(66,'Maple','','2017-08-21 18:27:24'),(67,'Earth','','2017-08-21 18:29:45'),(68,'Fire','','2017-08-21 18:29:59'),(69,'Water','','2017-08-21 18:30:11'),(70,'Gold','','2017-08-21 18:31:33'),(71,'Platinum','','2017-08-21 18:31:46'),(72,'Copper','','2017-08-21 18:31:59'),(73,'Silver','','2017-08-21 18:32:06'),(74,'Diamond','','2017-08-21 18:32:17'),(75,'Alps','','2017-08-21 18:35:52'),(76,'Everest','','2017-08-21 18:36:03'),(77,'Fuji','','2017-08-21 18:36:17'),(78,'Kashmir','','2017-08-21 18:36:52'),(79,'Kilimanjaro','','2017-08-21 18:37:32'),(80,'Evergreen','','2017-08-21 18:39:46'),(81,'Eucalyptus','','2017-08-21 18:40:02'),(82,'Tassel','','2017-08-21 18:41:18'),(83,'Holly','','2017-08-21 18:41:57'),(84,'Treefern','','2017-08-21 18:42:10'),(85,'Autumn','','2017-08-21 18:42:58'),(86,'Summer','','2017-08-21 18:43:11'),(87,'Winter','','2017-08-21 18:43:22'),(88,'Fall','','2017-08-21 18:43:32'),(89,'Tesla','','2017-08-21 18:48:30'),(90,'Galileo','','2017-08-21 18:49:12'),(91,'Pascal','','2017-08-21 18:49:43'),(92,'Hollirith','','2017-08-21 18:50:09'),(93,'Marx','','2017-08-21 18:51:20'),(94,'CAT5E','','2017-08-23 14:58:29');
/*!40000 ALTER TABLE `section_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section_settings_lt`
--

DROP TABLE IF EXISTS `section_settings_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section_settings_lt` (
  `section_settings_id` int(11) NOT NULL AUTO_INCREMENT,
  `section_id` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `gradelevel_id` int(11) NOT NULL,
  `session_id` int(11) NOT NULL COMMENT 'faculty_id COL represents the faculty member assigned as ADVISER for a section',
  `requiredAverage` decimal(10,2) NOT NULL,
  `adviser_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`section_settings_id`),
  KEY `fk_section_settings_ltTABLE_section_idCOL_idx` (`section_id`),
  KEY `fk_section_settings_ltTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_section_settings_ltTABLE_gradelevel_idCOL_idx` (`gradelevel_id`),
  KEY `fk_section_settings_ltTABLE_session_idCOL_idx` (`session_id`),
  KEY `fk_section_settings_ltTABLE_adviser_idCOL_idx` (`adviser_id`),
  CONSTRAINT `fk_section_settings_ltTABLE_adviser_idCOL` FOREIGN KEY (`adviser_id`) REFERENCES `faculty_mt` (`faculty_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_settings_ltTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_settings_ltTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_settings_ltTABLE_section_idCOL` FOREIGN KEY (`section_id`) REFERENCES `section_mt` (`section_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_settings_ltTABLE_session_idCOL` FOREIGN KEY (`session_id`) REFERENCES `session_mt` (`session_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_settings_lt`
--

LOCK TABLES `section_settings_lt` WRITE;
/*!40000 ALTER TABLE `section_settings_lt` DISABLE KEYS */;
INSERT INTO `section_settings_lt` VALUES (4,35,407,302,2,0.00,12),(5,38,407,302,1,85.00,NULL),(6,39,407,305,1,82.00,NULL),(7,40,407,304,1,82.00,NULL),(8,41,407,302,1,99.00,11),(10,44,407,303,2,80.00,NULL),(11,45,407,303,1,90.00,NULL),(12,49,407,302,1,84.00,6),(13,50,407,303,2,80.00,7),(14,50,407,303,2,80.00,7),(15,52,407,303,1,82.00,9),(16,53,407,303,1,82.00,5),(17,54,407,304,2,91.00,NULL),(18,55,407,304,1,80.00,NULL),(19,56,407,304,1,80.00,NULL),(20,57,407,304,1,80.00,NULL),(21,58,407,305,1,82.00,NULL),(22,59,407,305,1,82.00,NULL),(23,60,407,305,1,82.00,NULL),(24,61,407,305,1,82.00,NULL),(25,62,407,306,1,81.00,NULL),(26,63,407,306,1,80.00,NULL),(27,64,407,306,1,80.00,NULL),(28,65,407,306,1,80.00,NULL),(29,66,407,306,1,80.00,NULL),(30,67,407,306,1,80.00,NULL),(31,68,407,306,2,85.00,NULL),(32,69,407,306,2,86.00,NULL),(33,70,407,307,1,86.00,NULL),(34,71,407,307,2,87.00,NULL),(35,72,407,307,1,80.00,NULL),(36,73,407,307,1,80.00,NULL),(37,74,407,307,1,80.00,NULL),(38,75,407,308,1,87.00,NULL),(39,76,407,308,2,82.00,NULL),(40,77,407,308,1,91.00,NULL),(41,78,407,308,1,96.00,NULL),(42,79,407,308,2,92.00,NULL),(43,80,407,309,1,89.00,NULL),(44,81,407,309,2,81.00,NULL),(45,82,407,309,1,83.00,NULL),(46,83,407,309,1,86.00,NULL),(47,84,407,309,1,88.00,NULL),(48,85,407,310,1,77.00,NULL),(49,86,407,310,1,82.00,NULL),(50,87,407,310,2,87.00,NULL),(51,88,407,310,2,82.00,NULL),(52,89,407,310,1,87.00,NULL),(53,90,407,311,1,91.00,NULL),(54,91,407,311,1,85.00,NULL),(55,92,407,311,1,91.00,NULL),(56,93,407,311,1,84.00,NULL),(57,94,407,302,3,0.00,36);
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
  `section_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`section_student_id`),
  KEY `fk_students_sectionTABLE_section_idCOL_idx` (`section_id`),
  KEY `fk_students_sectionTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_section_studentTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_studentTABLE_section_idCOL` FOREIGN KEY (`section_id`) REFERENCES `section_mt` (`section_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_student`
--

LOCK TABLES `section_student` WRITE;
/*!40000 ALTER TABLE `section_student` DISABLE KEYS */;
INSERT INTO `section_student` VALUES (9,41,41,407,''),(14,38,43,407,''),(15,38,44,407,''),(16,38,45,407,''),(17,38,46,407,''),(18,38,47,407,''),(19,38,48,407,''),(20,38,49,407,''),(21,38,50,407,''),(22,38,51,407,''),(23,38,52,407,''),(24,35,38,407,''),(25,35,39,407,''),(26,35,40,407,''),(27,35,42,407,''),(28,49,53,407,''),(29,49,54,407,''),(30,49,55,407,''),(31,49,56,407,''),(32,49,57,407,''),(33,49,58,407,''),(34,49,59,407,''),(35,49,60,407,''),(38,50,166,407,'');
/*!40000 ALTER TABLE `section_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sectioncategory_mt`
--

DROP TABLE IF EXISTS `sectioncategory_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sectioncategory_mt` (
  `sectioncategory_id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(45) NOT NULL,
  `grade_range_from` int(11) NOT NULL,
  `grade_range_to` int(11) NOT NULL,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`sectioncategory_id`),
  UNIQUE KEY `category_UNIQUE` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='table to store grade range value from and to, to classify students';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sectioncategory_mt`
--

LOCK TABLES `sectioncategory_mt` WRITE;
/*!40000 ALTER TABLE `sectioncategory_mt` DISABLE KEYS */;
INSERT INTO `sectioncategory_mt` VALUES (1,'ABC',64,64,'2017-07-15 14:42:35');
/*!40000 ALTER TABLE `sectioncategory_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session_mt`
--

DROP TABLE IF EXISTS `session_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `session_mt` (
  `session_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
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
INSERT INTO `session_mt` VALUES (1,'AM',NULL,NULL),(2,'PM',NULL,NULL),(3,'Default',NULL,NULL);
/*!40000 ALTER TABLE `session_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialization`
--

DROP TABLE IF EXISTS `specialization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specialization` (
  `specialization_id` int(11) NOT NULL AUTO_INCREMENT,
  `specialization_title` varchar(45) NOT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  `description` text NOT NULL,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`specialization_id`),
  UNIQUE KEY `specialization_title_UNIQUE` (`specialization_title`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialization`
--

LOCK TABLES `specialization` WRITE;
/*!40000 ALTER TABLE `specialization` DISABLE KEYS */;
INSERT INTO `specialization` VALUES (14,'English','','English Specialization','2017-07-31 09:16:48'),(15,'Math','','Math Specialization','2017-07-31 09:17:25'),(16,'Foreign Language','','Foreign Language','2017-08-01 19:34:29'),(17,'Sience','','Sience','2017-08-02 17:40:52'),(18,'P.E','','physical Education','2017-08-04 15:21:31'),(19,'Biology','','Bilogy','2017-08-04 15:21:50'),(20,'Filipino','','Filipino','2017-08-04 15:22:13'),(21,'computer','','computer','2017-08-04 15:22:32'),(22,'Physics','','Physics','2018-06-03 17:52:26');
/*!40000 ALTER TABLE `specialization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialization_subject`
--

DROP TABLE IF EXISTS `specialization_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specialization_subject` (
  `specialization_subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `specialization_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `date_assigned` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`specialization_subject_id`),
  KEY `fk_specialization_subjectTABLE_specialization_idCOL_idx` (`specialization_id`),
  KEY `fk_specialization_subjectTABLE_subject_idCOL_idx` (`subject_id`),
  CONSTRAINT `fk_specialization_subjectTABLE_specialization_idCOL` FOREIGN KEY (`specialization_id`) REFERENCES `specialization` (`specialization_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_specialization_subjectTABLE_subject_idCOL` FOREIGN KEY (`subject_id`) REFERENCES `subject_mt` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialization_subject`
--

LOCK TABLES `specialization_subject` WRITE;
/*!40000 ALTER TABLE `specialization_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `specialization_subject` ENABLE KEYS */;
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
INSERT INTO `student_discount_lt` VALUES (41,5,407,'2017-08-23 07:17:39',2019.23),(41,5,407,'2017-08-23 16:53:36',2019.23);
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
  `schoolyear_id` int(11) NOT NULL,
  `date_assigned` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`student_fee_id`),
  KEY `fk_student_feeTABLE_student_id_idx` (`student_id`),
  KEY `fk_student_feeTABLE_fee_idCOL_idx` (`fee_id`),
  CONSTRAINT `fk_student_feeTABLE_fee_idCOL` FOREIGN KEY (`fee_id`) REFERENCES `fee_mt` (`fee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_feeTABLE_student_id` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_fee`
--

LOCK TABLES `student_fee` WRITE;
/*!40000 ALTER TABLE `student_fee` DISABLE KEYS */;
INSERT INTO `student_fee` VALUES (1,166,100,407,'2017-08-23 17:02:58'),(2,166,102,407,'2017-08-23 17:02:58'),(3,166,101,407,'2017-08-23 17:02:58'),(4,166,103,407,'2017-08-23 17:02:58'),(5,166,104,407,'2017-08-23 17:02:59'),(6,166,105,407,'2017-08-23 17:02:59'),(7,166,106,407,'2017-08-23 17:02:59'),(8,166,107,407,'2017-08-23 17:02:59'),(9,166,115,407,'2017-08-23 17:02:59'),(10,166,116,407,'2017-08-23 17:02:59'),(11,166,117,407,'2017-08-23 17:02:59'),(12,166,118,407,'2017-08-23 17:02:59'),(13,166,119,407,'2017-08-23 17:02:59'),(14,166,120,407,'2017-08-23 17:02:59'),(15,166,121,407,'2017-08-23 17:02:59');
/*!40000 ALTER TABLE `student_fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_grade`
--

DROP TABLE IF EXISTS `student_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_grade` (
  `student_grade_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `grade_id` int(11) NOT NULL,
  `date_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `isActive` bit(1) DEFAULT b'1',
  PRIMARY KEY (`student_grade_id`),
  KEY `fk_student_gradeTABLE_student_idCOL_idx` (`student_id`),
  KEY `fk_student_gradeTABLE_grade_idCOL_idx` (`grade_id`),
  CONSTRAINT `fk_student_gradeTABLE_grade_idCOL` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`grade_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_gradeTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_grade`
--

LOCK TABLES `student_grade` WRITE;
/*!40000 ALTER TABLE `student_grade` DISABLE KEYS */;
INSERT INTO `student_grade` VALUES (1,38,1,'2017-08-23 15:12:16',''),(2,38,2,'2017-08-23 15:24:49',''),(3,39,3,'2017-08-23 15:24:49',''),(4,40,4,'2017-08-23 15:24:50',''),(5,42,5,'2017-08-23 15:24:50',''),(6,38,6,'2017-08-23 15:24:50',''),(7,39,7,'2017-08-23 15:24:50',''),(8,40,8,'2017-08-23 15:24:50',''),(9,42,9,'2017-08-23 15:24:51',''),(10,38,10,'2017-08-23 15:24:51',''),(11,39,11,'2017-08-23 15:24:51',''),(12,40,12,'2017-08-23 15:24:51',''),(13,42,13,'2017-08-23 15:24:51',''),(14,38,14,'2017-08-23 15:24:51',''),(15,39,15,'2017-08-23 15:24:51',''),(16,40,16,'2017-08-23 15:24:51',''),(17,42,17,'2017-08-23 15:24:51',''),(18,38,18,'2017-08-23 15:24:52',''),(19,39,19,'2017-08-23 15:24:52',''),(20,40,20,'2017-08-23 15:24:52',''),(21,42,21,'2017-08-23 15:24:52',''),(22,38,22,'2017-08-23 15:24:52',''),(23,39,23,'2017-08-23 15:24:52',''),(24,40,24,'2017-08-23 15:24:52',''),(25,42,25,'2017-08-23 15:24:52',''),(26,38,26,'2017-08-23 15:24:52',''),(27,39,27,'2017-08-23 15:24:53',''),(28,40,28,'2017-08-23 15:24:53',''),(29,42,29,'2017-08-23 15:24:53',''),(30,38,30,'2017-08-23 15:24:53',''),(31,39,31,'2017-08-23 15:24:54',''),(32,40,32,'2017-08-23 15:24:54',''),(33,42,33,'2017-08-23 15:24:54','');
/*!40000 ALTER TABLE `student_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_mt`
--

DROP TABLE IF EXISTS `student_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_mt` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `registration_id` int(11) NOT NULL COMMENT 'registration_id is a foreign key referencing to registration_mt table',
  `entry_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isGraduated` bit(1) NOT NULL DEFAULT b'0' COMMENT 'isGraduate column gets updated with 1 when student graduates',
  `date_graduated` datetime DEFAULT NULL,
  `isActive` bit(1) DEFAULT b'0' COMMENT 'isActive column resets to 0 every after 1 schoolyear.\nThe date depends on the EXACT start date of schoolyear.\n\nAll enrolled students will have isActive status of 1 which mean ENROLLED',
  `student_type` bit(1) DEFAULT b'1' COMMENT 'Default student type of all students is "New" or 1\nAll Students start as New Student then becomes old student after 1 schoolyear. ',
  PRIMARY KEY (`student_id`),
  KEY `fk_student_mtTABLE_registration_idCOL_idx` (`registration_id`),
  CONSTRAINT `fk_student_mtTABLE_registration_idCOL` FOREIGN KEY (`registration_id`) REFERENCES `registration_mt` (`registration_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=latin1 COMMENT='Students Master Table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_mt`
--

LOCK TABLES `student_mt` WRITE;
/*!40000 ALTER TABLE `student_mt` DISABLE KEYS */;
INSERT INTO `student_mt` VALUES (38,7720,'2017-08-23 07:16:28','\0',NULL,'\0',''),(39,7721,'2017-08-23 07:16:28','\0',NULL,'\0',''),(40,7722,'2017-08-23 07:16:28','\0',NULL,'\0',''),(41,7723,'2017-08-23 07:16:29','\0',NULL,'\0',''),(42,7724,'2017-08-23 07:16:29','\0',NULL,'\0',''),(43,7725,'2017-08-23 13:19:58','\0',NULL,'',''),(44,7726,'2017-08-23 13:19:59','\0',NULL,'',''),(45,7727,'2017-08-23 13:20:00','\0',NULL,'',''),(46,7728,'2017-08-23 13:20:00','\0',NULL,'',''),(47,7729,'2017-08-23 13:20:00','\0',NULL,'',''),(48,7730,'2017-08-23 13:20:01','\0',NULL,'',''),(49,7731,'2017-08-23 13:20:01','\0',NULL,'',''),(50,7732,'2017-08-23 13:20:01','\0',NULL,'',''),(51,7733,'2017-08-23 13:20:02','\0',NULL,'',''),(52,7734,'2017-08-23 13:20:02','\0',NULL,'',''),(53,7735,'2017-08-23 14:33:43','\0',NULL,'',''),(54,7736,'2017-08-23 14:33:43','\0',NULL,'',''),(55,7737,'2017-08-23 14:33:43','\0',NULL,'',''),(56,7738,'2017-08-23 14:33:44','\0',NULL,'',''),(57,7739,'2017-08-23 14:33:44','\0',NULL,'',''),(58,7740,'2017-08-23 14:33:44','\0',NULL,'',''),(59,7741,'2017-08-23 14:33:44','\0',NULL,'',''),(60,7742,'2017-08-23 14:33:45','\0',NULL,'',''),(61,7743,'2017-08-23 14:57:32','\0',NULL,'',''),(62,7744,'2017-08-23 14:57:33','\0',NULL,'',''),(63,7745,'2017-08-23 14:57:33','\0',NULL,'',''),(64,7746,'2017-08-23 14:57:33','\0',NULL,'',''),(65,7747,'2017-08-23 14:57:34','\0',NULL,'',''),(66,7748,'2017-08-23 14:57:35','\0',NULL,'',''),(67,7749,'2017-08-23 14:57:36','\0',NULL,'',''),(68,7750,'2017-08-23 14:57:36','\0',NULL,'',''),(69,7751,'2017-08-23 14:57:37','\0',NULL,'',''),(70,7752,'2017-08-23 14:57:37','\0',NULL,'',''),(71,7753,'2017-08-23 16:06:22','\0',NULL,'',''),(72,7754,'2017-08-23 16:06:31','\0',NULL,'',''),(73,7755,'2017-08-23 16:06:34','\0',NULL,'',''),(74,7756,'2017-08-23 16:06:35','\0',NULL,'',''),(75,7757,'2017-08-23 16:06:36','\0',NULL,'',''),(76,7758,'2017-08-23 16:06:41','\0',NULL,'',''),(77,7759,'2017-08-23 16:06:43','\0',NULL,'',''),(78,7760,'2017-08-23 16:06:44','\0',NULL,'',''),(79,7761,'2017-08-23 16:06:45','\0',NULL,'',''),(80,7762,'2017-08-23 16:06:47','\0',NULL,'',''),(81,7763,'2017-08-23 16:06:51','\0',NULL,'',''),(82,7764,'2017-08-23 16:06:57','\0',NULL,'',''),(83,7765,'2017-08-23 16:07:00','\0',NULL,'',''),(84,7766,'2017-08-23 16:07:04','\0',NULL,'',''),(85,7767,'2017-08-23 16:07:10','\0',NULL,'',''),(86,7768,'2017-08-23 16:07:13','\0',NULL,'',''),(87,7769,'2017-08-23 16:07:25','\0',NULL,'',''),(88,7770,'2017-08-23 16:07:45','\0',NULL,'',''),(89,7771,'2017-08-23 16:07:50','\0',NULL,'',''),(90,7772,'2017-08-23 16:07:52','\0',NULL,'',''),(91,7773,'2017-08-23 16:07:57','\0',NULL,'',''),(92,7774,'2017-08-23 16:09:33','\0',NULL,'',''),(93,7775,'2017-08-23 16:09:37','\0',NULL,'',''),(94,7776,'2017-08-23 16:09:37','\0',NULL,'',''),(95,7777,'2017-08-23 16:09:39','\0',NULL,'',''),(96,7778,'2017-08-23 16:09:42','\0',NULL,'',''),(97,7779,'2017-08-23 16:09:44','\0',NULL,'',''),(98,7780,'2017-08-23 16:09:46','\0',NULL,'',''),(99,7781,'2017-08-23 16:09:50','\0',NULL,'',''),(100,7782,'2017-08-23 16:09:53','\0',NULL,'',''),(101,7783,'2017-08-23 16:09:55','\0',NULL,'',''),(102,7784,'2017-08-23 16:09:56','\0',NULL,'',''),(103,7785,'2017-08-23 16:09:58','\0',NULL,'',''),(104,7786,'2017-08-23 16:09:59','\0',NULL,'',''),(105,7787,'2017-08-23 16:10:00','\0',NULL,'',''),(106,7788,'2017-08-23 16:10:01','\0',NULL,'',''),(107,7789,'2017-08-23 16:10:02','\0',NULL,'',''),(108,7790,'2017-08-23 16:10:03','\0',NULL,'',''),(109,7791,'2017-08-23 16:10:04','\0',NULL,'',''),(110,7792,'2017-08-23 16:10:05','\0',NULL,'',''),(111,7793,'2017-08-23 16:10:06','\0',NULL,'',''),(112,7794,'2017-08-23 16:10:10','\0',NULL,'',''),(113,7795,'2017-08-23 16:10:20','\0',NULL,'',''),(114,7796,'2017-08-23 16:10:24','\0',NULL,'',''),(115,7797,'2017-08-23 16:10:28','\0',NULL,'',''),(116,7798,'2017-08-23 16:10:30','\0',NULL,'',''),(117,7799,'2017-08-23 16:11:33','\0',NULL,'',''),(118,7800,'2017-08-23 16:11:35','\0',NULL,'',''),(119,7801,'2017-08-23 16:11:35','\0',NULL,'',''),(120,7802,'2017-08-23 16:13:48','\0',NULL,'',''),(121,7803,'2017-08-23 16:13:48','\0',NULL,'',''),(122,7804,'2017-08-23 16:13:49','\0',NULL,'',''),(123,7805,'2017-08-23 16:13:50','\0',NULL,'',''),(124,7806,'2017-08-23 16:13:51','\0',NULL,'',''),(125,7807,'2017-08-23 16:13:52','\0',NULL,'',''),(126,7808,'2017-08-23 16:13:52','\0',NULL,'',''),(127,7809,'2017-08-23 16:13:53','\0',NULL,'',''),(128,7810,'2017-08-23 16:13:53','\0',NULL,'',''),(129,7811,'2017-08-23 16:13:54','\0',NULL,'',''),(130,7812,'2017-08-23 16:13:55','\0',NULL,'',''),(131,7813,'2017-08-23 16:13:55','\0',NULL,'',''),(132,7814,'2017-08-23 16:13:56','\0',NULL,'',''),(133,7815,'2017-08-23 16:13:56','\0',NULL,'',''),(134,7816,'2017-08-23 16:13:58','\0',NULL,'',''),(135,7817,'2017-08-23 16:13:58','\0',NULL,'',''),(136,7818,'2017-08-23 16:13:59','\0',NULL,'',''),(137,7819,'2017-08-23 16:14:00','\0',NULL,'',''),(138,7820,'2017-08-23 16:14:00','\0',NULL,'',''),(139,7821,'2017-08-23 16:14:01','\0',NULL,'',''),(140,7822,'2017-08-23 16:14:01','\0',NULL,'',''),(141,7823,'2017-08-23 16:14:02','\0',NULL,'',''),(142,7824,'2017-08-23 16:14:02','\0',NULL,'',''),(143,7825,'2017-08-23 16:14:03','\0',NULL,'',''),(144,7826,'2017-08-23 16:14:05','\0',NULL,'',''),(145,7827,'2017-08-23 16:14:06','\0',NULL,'',''),(146,7828,'2017-08-23 16:14:07','\0',NULL,'',''),(147,7829,'2017-08-23 16:14:07','\0',NULL,'',''),(148,7830,'2017-08-23 16:14:08','\0',NULL,'',''),(149,7831,'2017-08-23 16:14:09','\0',NULL,'',''),(150,7832,'2017-08-23 16:14:09','\0',NULL,'',''),(151,7833,'2017-08-23 16:14:10','\0',NULL,'',''),(152,7834,'2017-08-23 16:14:10','\0',NULL,'',''),(153,7835,'2017-08-23 16:14:11','\0',NULL,'',''),(154,7836,'2017-08-23 16:14:12','\0',NULL,'',''),(155,7837,'2017-08-23 16:14:13','\0',NULL,'',''),(156,7838,'2017-08-23 16:14:14','\0',NULL,'',''),(157,7839,'2017-08-23 16:14:15','\0',NULL,'',''),(158,7840,'2017-08-23 16:14:16','\0',NULL,'',''),(159,7841,'2017-08-23 16:14:16','\0',NULL,'',''),(160,7842,'2017-08-23 16:14:17','\0',NULL,'',''),(161,7843,'2017-08-23 16:14:17','\0',NULL,'',''),(162,7844,'2017-08-23 16:14:18','\0',NULL,'',''),(163,7845,'2017-08-23 16:14:19','\0',NULL,'',''),(164,7846,'2017-08-23 16:14:19','\0',NULL,'',''),(165,7847,'2017-08-23 16:14:20','\0',NULL,'',''),(166,7848,'2017-08-23 17:02:58','\0',NULL,'','');
/*!40000 ALTER TABLE `student_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_paymentterm_lt`
--

DROP TABLE IF EXISTS `student_paymentterm_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_paymentterm_lt` (
  `student_id` int(11) NOT NULL,
  `paymentterm_id` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  KEY `fk_student_paymentterm_ltTABLE_student_idCOL_idx` (`student_id`),
  KEY `fk_student_paymentterm_ltTABLE_paymentterm_idCOL_idx` (`paymentterm_id`),
  KEY `fk_student_paymentterm_ltTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  CONSTRAINT `fk_student_paymentterm_ltTABLE_paymentterm_idCOL` FOREIGN KEY (`paymentterm_id`) REFERENCES `paymentterm_mt` (`paymentterm_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_paymentterm_ltTABLE_schoolyear_idCOL` FOREIGN KEY (`schoolyear_id`) REFERENCES `schoolyear_mt` (`schoolyear_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_paymentterm_ltTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_paymentterm_lt`
--

LOCK TABLES `student_paymentterm_lt` WRITE;
/*!40000 ALTER TABLE `student_paymentterm_lt` DISABLE KEYS */;
INSERT INTO `student_paymentterm_lt` VALUES (41,3,407),(41,3,407),(38,3,407),(166,2,407);
/*!40000 ALTER TABLE `student_paymentterm_lt` ENABLE KEYS */;
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
  KEY `fk_subjects_gradelevel_dtTable_subjectId_idx` (`subject_id`),
  KEY `fk_subjects_gradelevel_Table_gradeLevelId_idx` (`gradelevel_id`),
  CONSTRAINT `fk_subject_gradelevelTABLE_gradelevel_idCOL` FOREIGN KEY (`gradelevel_id`) REFERENCES `gradelevel_mt` (`gradelevel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_subject_gradelevelTABLE_subject_idCOL` FOREIGN KEY (`subject_id`) REFERENCES `subject_mt` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_gradelevel_lt`
--

LOCK TABLES `subject_gradelevel_lt` WRITE;
/*!40000 ALTER TABLE `subject_gradelevel_lt` DISABLE KEYS */;
INSERT INTO `subject_gradelevel_lt` VALUES (512,301),(513,301),(514,301),(515,301),(516,301),(517,301),(518,301),(519,301),(520,301),(521,301),(522,301),(523,301),(524,301),(525,302),(526,302),(527,302),(528,302),(529,302),(530,302),(531,302),(532,302),(533,302),(534,302),(535,302),(536,302),(537,302),(538,303),(539,303),(540,303),(541,303),(542,303),(543,303),(544,303),(545,303),(546,303),(547,303),(548,303),(549,303),(550,303),(551,304),(552,304),(553,304),(554,304),(555,304),(556,304),(557,304),(558,304),(559,304),(560,304),(561,304),(562,304),(563,304),(564,305),(565,305),(566,305),(567,305),(568,305),(569,305),(570,305),(571,305),(572,305),(573,305),(574,305),(575,305),(576,305),(577,306),(578,306),(579,306),(580,306),(581,306),(582,306),(583,306),(584,306),(585,306),(586,306),(587,306),(588,306),(589,306),(590,307),(591,307),(592,307),(593,307),(594,307),(595,307),(596,307),(597,307),(598,307),(599,307),(600,307),(601,307),(602,307),(603,308),(604,308),(605,308),(606,308),(607,308),(608,308),(609,308),(610,308),(611,308),(612,308),(613,308),(614,308),(615,308),(616,309),(617,309),(618,309),(619,309),(620,309),(621,309),(622,309),(623,309),(624,309),(625,309),(626,309),(627,309),(628,309),(629,310),(630,310),(631,310),(632,310),(633,310),(634,310),(635,310),(636,310),(637,310),(638,310),(639,310),(640,310),(641,310),(642,311),(643,311),(644,311),(645,311),(646,311),(647,311),(648,311),(649,311),(650,311),(651,311),(652,311),(653,311),(654,311);
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
  `isAdded` bit(1) DEFAULT NULL,
  PRIMARY KEY (`subject_id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=655 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_mt`
--

LOCK TABLES `subject_mt` WRITE;
/*!40000 ALTER TABLE `subject_mt` DISABLE KEYS */;
INSERT INTO `subject_mt` VALUES (512,'KMTHTONGUE','Mother Tongue','Mother Tongue','',NULL),(513,'KFIL','Filipino','Filipino','',NULL),(514,'KENG','English','English','',NULL),(515,'KMATH','Mathematics','Mathematics','',NULL),(516,'KSCI','Science','Science','',NULL),(517,'KAP','Araling Panlipunan','Araling Panlipunan','',NULL),(518,'KESP','Edukasyon sa Pagpapakatao (EsP)','Edukasyon sa Pagpapakatao (EsP)','',NULL),(519,'KMUSIC','Music','Music','',NULL),(520,'KARTS','Arts','Arts','',NULL),(521,'KPE','Physical Education','Physical Education','',NULL),(522,'KHEALTH','Health','Health','',NULL),(523,'KEPP','Edukasyong Pantahanan at Pangkabuhayan (EPP)','Edukasyong Pantahanan at Pangkabuhayan (EPP)','',NULL),(524,'KTLE','Technology and Livelihood Education (TLE)','Technology and Livelihood Education (TLE)','',NULL),(525,'G1MTHTONGUE','Mother Tongue','Mother Tongue','',''),(526,'G1FIL','Filipino','Filipino','',''),(527,'G1ENG','English','English','',''),(528,'G1MATH','Mathematics','Mathematics','',''),(529,'G1SCI','Science','Science','',''),(530,'G1AP','Araling Panlipunan','Araling Panlipunan','',''),(531,'G1ESP','Edukasyon sa Pagpapakatao (EsP)','Edukasyon sa Pagpapakatao (EsP)','',''),(532,'G1MUSIC','Music','Music','',''),(533,'G1ARTS','Arts','Arts','',''),(534,'G1PE','Physical Education','Physical Education','',''),(535,'G1HEALTH','Health','Health','',''),(536,'G1EPP','Edukasyong Pantahanan at Pangkabuhayan (EPP)','Edukasyong Pantahanan at Pangkabuhayan (EPP)','',''),(537,'G1TLE','Technology and Livelihood Education (TLE)','Technology and Livelihood Education (TLE)','',''),(538,'G2MTHTONGUE','Mother Tongue','Mother Tongue','',NULL),(539,'G2FIL','Filipino','Filipino','',NULL),(540,'G2ENG','English','English','',NULL),(541,'G2MATH','Mathematics','Mathematics','',NULL),(542,'G2SCI','Science','Science','',NULL),(543,'G2AP','Araling Panlipunan','Araling Panlipunan','',NULL),(544,'G2ESP','Edukasyon sa Pagpapakatao (EsP)','Edukasyon sa Pagpapakatao (EsP)','',NULL),(545,'G2MUSIC','Music','Music','',NULL),(546,'G2ARTS','Arts','Arts','',NULL),(547,'G2PE','Physical Education','Physical Education','',NULL),(548,'G2HEALTH','Health','Health','',NULL),(549,'G2EPP','Edukasyong Pantahanan at Pangkabuhayan (EPP)','Edukasyong Pantahanan at Pangkabuhayan (EPP)','',NULL),(550,'G2TLE','Technology and Livelihood Education (TLE)','Technology and Livelihood Education (TLE)','',NULL),(551,'G3MTHTONGUE','Mother Tongue','Mother Tongue','',NULL),(552,'G3FIL','Filipino','Filipino','',NULL),(553,'G3ENG','English','English','',NULL),(554,'G3MATH','Mathematics','Mathematics','',NULL),(555,'G3SCI','Science','Science','',NULL),(556,'G3AP','Araling Panlipunan','Araling Panlipunan','',NULL),(557,'G3ESP','Edukasyon sa Pagpapakatao (EsP)','Edukasyon sa Pagpapakatao (EsP)','',NULL),(558,'G3MUSIC','Music','Music','',NULL),(559,'G3ARTS','Arts','Arts','',NULL),(560,'G3PE','Physical Education','Physical Education','',NULL),(561,'G3HEALTH','Health','Health','',NULL),(562,'G3EPP','Edukasyong Pantahanan at Pangkabuhayan (EPP)','Edukasyong Pantahanan at Pangkabuhayan (EPP)','',NULL),(563,'G3TLE','Technology and Livelihood Education (TLE)','Technology and Livelihood Education (TLE)','',NULL),(564,'G4MTHTONGUE','Mother Tongue','Mother Tongue','',NULL),(565,'G4FIL','Filipino','Filipino','',NULL),(566,'G4ENG','English','English','',NULL),(567,'G4MATH','Mathematics','Mathematics','',NULL),(568,'G4SCI','Science','Science','',NULL),(569,'G4AP','Araling Panlipunan','Araling Panlipunan','',NULL),(570,'G4ESP','Edukasyon sa Pagpapakatao (EsP)','Edukasyon sa Pagpapakatao (EsP)','',NULL),(571,'G4MUSIC','Music','Music','',NULL),(572,'G4ARTS','Arts','Arts','',NULL),(573,'G4PE','Physical Education','Physical Education','',NULL),(574,'G4HEALTH','Health','Health','',NULL),(575,'G4EPP','Edukasyong Pantahanan at Pangkabuhayan (EPP)','Edukasyong Pantahanan at Pangkabuhayan (EPP)','',NULL),(576,'G4TLE','Technology and Livelihood Education (TLE)','Technology and Livelihood Education (TLE)','',NULL),(577,'G5MTHTONGUE','Mother Tongue','Mother Tongue','',NULL),(578,'G5FIL','Filipino','Filipino','',NULL),(579,'G5ENG','English','English','',NULL),(580,'G5MATH','Mathematics','Mathematics','',NULL),(581,'G5SCI','Science','Science','',NULL),(582,'G5AP','Araling Panlipunan','Araling Panlipunan','',NULL),(583,'G5ESP','Edukasyon sa Pagpapakatao (EsP)','Edukasyon sa Pagpapakatao (EsP)','',NULL),(584,'G5MUSIC','Music','Music','',NULL),(585,'G5ARTS','Arts','Arts','',NULL),(586,'G5PE','Physical Education','Physical Education','',NULL),(587,'G5HEALTH','Health','Health','',NULL),(588,'G5EPP','Edukasyong Pantahanan at Pangkabuhayan (EPP)','Edukasyong Pantahanan at Pangkabuhayan (EPP)','',NULL),(589,'G5TLE','Technology and Livelihood Education (TLE)','Technology and Livelihood Education (TLE)','',NULL),(590,'G6MTHTONGUE','Mother Tongue','Mother Tongue','',NULL),(591,'G6FIL','Filipino','Filipino','',NULL),(592,'G6ENG','English','English','',NULL),(593,'G6MATH','Mathematics','Mathematics','',NULL),(594,'G6SCI','Science','Science','',NULL),(595,'G6AP','Araling Panlipunan','Araling Panlipunan','',NULL),(596,'G6ESP','Edukasyon sa Pagpapakatao (EsP)','Edukasyon sa Pagpapakatao (EsP)','',NULL),(597,'G6MUSIC','Music','Music','',NULL),(598,'G6ARTS','Arts','Arts','',NULL),(599,'G6PE','Physical Education','Physical Education','',NULL),(600,'G6HEALTH','Health','Health','',NULL),(601,'G6EPP','Edukasyong Pantahanan at Pangkabuhayan (EPP)','Edukasyong Pantahanan at Pangkabuhayan (EPP)','',NULL),(602,'G6TLE','Technology and Livelihood Education (TLE)','Technology and Livelihood Education (TLE)','',NULL),(603,'G7MTHTONGUE','Mother Tongue','Mother Tongue','',NULL),(604,'G7FIL','Filipino','Filipino','',NULL),(605,'G7ENG','English','English','',NULL),(606,'G7MATH','Mathematics','Mathematics','',NULL),(607,'G7SCI','Science','Science','',NULL),(608,'G7AP','Araling Panlipunan','Araling Panlipunan','',NULL),(609,'G7ESP','Edukasyon sa Pagpapakatao (EsP)','Edukasyon sa Pagpapakatao (EsP)','',NULL),(610,'G7MUSIC','Music','Music','',NULL),(611,'G7ARTS','Arts','Arts','',NULL),(612,'G7PE','Physical Education','Physical Education','',NULL),(613,'G7HEALTH','Health','Health','',NULL),(614,'G7EPP','Edukasyong Pantahanan at Pangkabuhayan (EPP)','Edukasyong Pantahanan at Pangkabuhayan (EPP)','',NULL),(615,'G7TLE','Technology and Livelihood Education (TLE)','Technology and Livelihood Education (TLE)','',NULL),(616,'G8MTHTONGUE','Mother Tongue','Mother Tongue','',NULL),(617,'G8FIL','Filipino','Filipino','',NULL),(618,'G8ENG','English','English','',NULL),(619,'G8MATH','Mathematics','Mathematics','',NULL),(620,'G8SCI','Science','Science','',NULL),(621,'G8AP','Araling Panlipunan','Araling Panlipunan','',NULL),(622,'G8ESP','Edukasyon sa Pagpapakatao (EsP)','Edukasyon sa Pagpapakatao (EsP)','',NULL),(623,'G8MUSIC','Music','Music','',NULL),(624,'G8ARTS','Arts','Arts','',NULL),(625,'G8PE','Physical Education','Physical Education','',NULL),(626,'G8HEALTH','Health','Health','',NULL),(627,'G8EPP','Edukasyong Pantahanan at Pangkabuhayan (EPP)','Edukasyong Pantahanan at Pangkabuhayan (EPP)','',NULL),(628,'G8TLE','Technology and Livelihood Education (TLE)','Technology and Livelihood Education (TLE)','',NULL),(629,'G9MTHTONGUE','Mother Tongue','Mother Tongue','',NULL),(630,'G9FIL','Filipino','Filipino','',NULL),(631,'G9ENG','English','English','',NULL),(632,'G9MATH','Mathematics','Mathematics','',NULL),(633,'G9SCI','Science','Science','',NULL),(634,'G9AP','Araling Panlipunan','Araling Panlipunan','',NULL),(635,'G9ESP','Edukasyon sa Pagpapakatao (EsP)','Edukasyon sa Pagpapakatao (EsP)','',NULL),(636,'G9MUSIC','Music','Music','',NULL),(637,'G9ARTS','Arts','Arts','',NULL),(638,'G9PE','Physical Education','Physical Education','',NULL),(639,'G9HEALTH','Health','Health','',NULL),(640,'G9EPP','Edukasyong Pantahanan at Pangkabuhayan (EPP)','Edukasyong Pantahanan at Pangkabuhayan (EPP)','',NULL),(641,'G9TLE','Technology and Livelihood Education (TLE)','Technology and Livelihood Education (TLE)','',NULL),(642,'G10MTHTONGUE','Mother Tongue','Mother Tongue','',NULL),(643,'G10FIL','Filipino','Filipino','',NULL),(644,'G10ENG','English','English','',NULL),(645,'G10MATH','Mathematics','Mathematics','',NULL),(646,'G10SCI','Science','Science','',NULL),(647,'G10AP','Araling Panlipunan','Araling Panlipunan','',NULL),(648,'G10ESP','Edukasyon sa Pagpapakatao (EsP)','Edukasyon sa Pagpapakatao (EsP)','',NULL),(649,'G10MUSIC','Music','Music','',NULL),(650,'G10ARTS','Arts','Arts','',NULL),(651,'G10PE','Physical Education','Physical Education','',NULL),(652,'G10HEALTH','Health','Health','',NULL),(653,'G10EPP','Edukasyong Pantahanan at Pangkabuhayan (EPP)','Edukasyong Pantahanan at Pangkabuhayan (EPP)','',NULL),(654,'G10TLE','Technology and Livelihood Education (TLE)','Technology and Livelihood Education (TLE)','',NULL);
/*!40000 ALTER TABLE `subject_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_mt`
--

DROP TABLE IF EXISTS `transaction_mt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_mt` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `fk_transaction_mtTABLE_student_idCOL_idx` (`student_id`),
  CONSTRAINT `fk_transaction_mtTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_mt`
--

LOCK TABLES `transaction_mt` WRITE;
/*!40000 ALTER TABLE `transaction_mt` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_mt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_payment_lt`
--

DROP TABLE IF EXISTS `transaction_payment_lt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_payment_lt` (
  `transaction_id` int(11) NOT NULL,
  `payment_id` int(11) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `fk_transaction_payment_ltTABLE_payment_idCOL_idx` (`payment_id`),
  CONSTRAINT `fk_transaction_payment_ltTABLE_payment_idCOL` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`payment_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_payment_ltTABLE_transaction_idCOL` FOREIGN KEY (`transaction_id`) REFERENCES `transaction_mt` (`transaction_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_payment_lt`
--

LOCK TABLES `transaction_payment_lt` WRITE;
/*!40000 ALTER TABLE `transaction_payment_lt` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_payment_lt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transferee_grade`
--

DROP TABLE IF EXISTS `transferee_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transferee_grade` (
  `transferee_grade_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `firstquarter_grade` decimal(10,2) DEFAULT NULL,
  `secondquarter_grade` decimal(10,2) DEFAULT NULL,
  `thirdquarter_grade` decimal(10,2) DEFAULT NULL,
  `fourthquarter_grade` decimal(10,2) DEFAULT NULL,
  `gwa` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`transferee_grade_id`),
  KEY `fk_transferee_gradeTABLE_student_idCOL_idx` (`student_id`),
  CONSTRAINT `fk_transferee_gradeTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transferee_grade`
--

LOCK TABLES `transferee_grade` WRITE;
/*!40000 ALTER TABLE `transferee_grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `transferee_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transferee_student`
--

DROP TABLE IF EXISTS `transferee_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transferee_student` (
  `transferee_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`transferee_id`),
  KEY `fk_transferee_studentTABLE_student_idCOL_idx` (`student_id`),
  CONSTRAINT `fk_transferee_studentTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transferee_student`
--

LOCK TABLES `transferee_student` WRITE;
/*!40000 ALTER TABLE `transferee_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `transferee_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuition_fee`
--

DROP TABLE IF EXISTS `tuition_fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tuition_fee` (
  `balance_breakdown_fee_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `schoolyear_id` int(11) NOT NULL,
  `date_assigned` datetime DEFAULT CURRENT_TIMESTAMP,
  KEY `fk_student_feesTABLE_schoolyear_idCOL_idx` (`schoolyear_id`),
  KEY `fk_student_feesTABLE_student_idCOL_idx` (`student_id`),
  KEY `fk_tuition_feeTABLE_balance_breakdown_fee_idCOL_idx` (`balance_breakdown_fee_id`),
  CONSTRAINT `fk_tuition_feeTABLE_student_idCOL` FOREIGN KEY (`student_id`) REFERENCES `student_mt` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuition_fee`
--

LOCK TABLES `tuition_fee` WRITE;
/*!40000 ALTER TABLE `tuition_fee` DISABLE KEYS */;
INSERT INTO `tuition_fee` VALUES (71,41,407,'2017-08-23 07:17:39'),(72,41,407,'2017-08-23 07:17:39'),(73,41,407,'2017-08-23 07:17:39'),(74,41,407,'2017-08-23 07:17:39'),(75,41,407,'2017-08-23 07:17:39'),(76,41,407,'2017-08-23 16:53:36'),(77,41,407,'2017-08-23 16:53:36'),(78,41,407,'2017-08-23 16:53:36'),(79,41,407,'2017-08-23 16:53:36'),(80,41,407,'2017-08-23 16:53:36'),(81,38,407,'2017-08-23 16:56:35'),(82,38,407,'2017-08-23 16:56:35'),(83,38,407,'2017-08-23 16:56:35'),(84,38,407,'2017-08-23 16:56:35'),(85,38,407,'2017-08-23 16:56:35'),(86,166,407,'2017-08-23 17:03:55');
/*!40000 ALTER TABLE `tuition_fee` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_faculty`
--

LOCK TABLES `user_faculty` WRITE;
/*!40000 ALTER TABLE `user_faculty` DISABLE KEYS */;
INSERT INTO `user_faculty` VALUES (3,47,4,'2017-08-19 16:05:57'),(4,48,5,'2017-08-20 10:57:57'),(5,49,6,'2017-08-20 11:01:07'),(6,50,7,'2017-08-20 11:04:10'),(8,52,9,'2017-08-20 11:16:39'),(9,54,11,'2017-08-22 23:47:47'),(10,55,12,'2017-08-23 00:05:52'),(11,56,13,'2017-08-23 00:09:51'),(12,57,14,'2017-08-23 00:10:27'),(13,58,15,'2017-08-23 00:11:01'),(14,59,16,'2017-08-23 00:11:41'),(15,60,17,'2017-08-23 00:12:05'),(16,61,18,'2017-08-23 00:12:31'),(17,62,19,'2017-08-23 00:12:59'),(18,66,23,'2017-08-23 00:14:39'),(19,67,24,'2017-08-23 00:15:19'),(20,68,25,'2017-08-23 00:15:46'),(21,69,26,'2017-08-23 00:16:13'),(22,70,27,'2017-08-23 00:16:39'),(23,71,28,'2017-08-23 00:17:06'),(24,72,29,'2017-08-23 00:17:32'),(25,73,30,'2017-08-23 00:18:03'),(26,74,31,'2017-08-23 00:18:26'),(27,75,32,'2017-08-23 00:18:52'),(28,76,33,'2017-08-23 00:19:16'),(29,77,34,'2017-08-23 00:19:37'),(30,78,35,'2017-08-23 00:20:03'),(31,79,36,'2017-08-23 00:20:27');
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
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1 COMMENT='Users Master Table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_mt`
--

LOCK TABLES `user_mt` WRITE;
/*!40000 ALTER TABLE `user_mt` DISABLE KEYS */;
INSERT INTO `user_mt` VALUES (46,'admin','admin',1,0,'Default','Admin','Login','2017-08-23 17:16:18','2017-08-19 10:13:26','DB Administrator'),(47,'paulneo','facultymember',1,0,'Napadao','Paul Neo','E.','2017-08-19 16:05:57','2017-08-19 16:05:57',''),(48,'ruby','facultymember',1,0,'Peralta','Ruby','E','2017-08-20 10:57:57','2017-08-20 10:57:57',''),(49,'romela','facultymember',1,0,'Pangan','Romela','E.','2017-08-23 15:24:40','2017-08-20 11:01:07',''),(50,'sarah','facultymember',1,0,'Ramos','Sarah','E.','2017-08-23 17:12:38','2017-08-20 11:04:10',''),(52,'elenita','facultymember',1,0,'Guarin','Elenita','R.','2017-08-20 11:16:39','2017-08-20 11:16:39',''),(54,'alvin','facultymember',1,0,'Kutcher','Alvin','E.','2017-08-23 14:31:57','2017-08-22 23:47:47',''),(55,'elmer','facultymember',1,0,'Dumo','Elmer','D','2017-08-23 13:26:01','2017-08-23 00:05:52',''),(56,'cody','facultymember',1,0,'Pangilinan','Cody','U','2017-08-23 00:09:51','2017-08-23 00:09:51',''),(57,'ella','facultymember',1,0,'Sanchez','Ella','T','2017-08-23 00:10:27','2017-08-23 00:10:27',''),(58,'leonora','facultymember',1,0,'Dela Cruz','Leonora','M','2017-08-23 00:11:00','2017-08-23 00:11:00',''),(59,'corazon','facultymember',1,0,'Guarin','Corazon','K','2017-08-23 00:11:41','2017-08-23 00:11:41',''),(60,'alma','facultymember',1,0,'Romarate','Alma','A','2017-08-23 00:12:05','2017-08-23 00:12:05',''),(61,'john','facultymember',1,0,'Antonio','John','M','2017-08-23 00:12:30','2017-08-23 00:12:30',''),(62,'may','facultymember',1,0,'Chavez','May','C','2017-08-23 00:12:59','2017-08-23 00:12:59',''),(66,'reuben','facultymember',1,0,'Dayao','Reuben','Y','2017-08-23 00:14:39','2017-08-23 00:14:39',''),(67,'jemma','facultymember',1,0,'Abellana','Jemma','E','2017-08-23 00:15:18','2017-08-23 00:15:18',''),(68,'roland','facultymember',1,0,'Reyes','Roland','D','2017-08-23 00:15:46','2017-08-23 00:15:46',''),(69,'pinky','facultymember',1,0,'Amador','Pinky','P','2017-08-23 00:16:13','2017-08-23 00:16:13',''),(70,'mary','facultymember',1,0,'Vallejos','Mary','E','2017-08-23 00:16:39','2017-08-23 00:16:39',''),(71,'daisy','facultymember',1,0,'Tan','Daisy','R','2017-08-23 00:17:06','2017-08-23 00:17:06',''),(72,'anne','facultymember',1,0,'Peralta','Anne','E','2017-08-23 00:17:32','2017-08-23 00:17:32',''),(73,'ludy','facultymember',1,0,'Puerto','Ludy','K','2017-08-23 00:18:03','2017-08-23 00:18:03',''),(74,'chinita','facultymember',1,0,'Akot','Chinita','P','2017-08-23 00:18:26','2017-08-23 00:18:26',''),(75,'bo','facultymember',1,0,'Sanchez','Bo','P','2017-08-23 00:18:52','2017-08-23 00:18:52',''),(76,'laura','facultymember',1,0,'Cagasab','Laura','L','2017-08-23 00:19:16','2017-08-23 00:19:16',''),(77,'lyn','facultymember',1,0,'Smith','Lyn','H','2017-08-23 00:19:37','2017-08-23 00:19:37',''),(78,'shaye','facultymember',1,0,'Lannister','Shaye','A','2017-08-23 00:20:03','2017-08-23 00:20:03',''),(79,'sansa','facultymember',1,0,'Stark','Sansa','L','2017-08-23 15:02:19','2017-08-23 00:20:27',''),(80,'paulnapadao','paulpaul',1,0,'Napadao','paul pogi','T','2017-08-23 16:16:22','2017-08-23 16:16:22',''),(81,'123','123456789',1,0,'123','123','123','2017-08-23 16:59:21','2017-08-23 16:55:27','');
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
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (39,46,1),(40,47,4),(41,48,4),(42,49,4),(43,50,4),(45,52,4),(46,54,4),(47,55,4),(48,56,4),(49,57,4),(50,58,4),(51,59,4),(52,60,4),(53,61,4),(54,62,4),(55,66,4),(56,67,4),(57,68,4),(58,69,4),(59,70,4),(60,71,4),(61,72,4),(62,73,4),(63,74,4),(64,75,4),(65,76,4),(66,77,4),(67,78,4),(68,79,4),(69,80,3),(70,81,2);
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `addAdmission`(aRegistrationId INT)
BEGIN

INSERT INTO admission_mt(registration_id)
VALUES(aRegistrationId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addAsStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addAsStudent`(aRegistrationId INT, OUT aStudentId INT)
BEGIN

INSERT INTO student_mt(registration_id)
VALUES(aRegistrationId);

SELECT LAST_INSERT_ID() INTO aStudentId;

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
aDescription TEXT, 
anAmount decimal (10,2), 
aDeadline DATE,
OUT aBalanceBreakDownFeeId INT)
BEGIN

INSERT INTO balance_breakdown_fee
(description, amount,payment_deadline)
VALUES
(aDescription, anAmount,aDeadline);

SELECT LAST_INSERT_ID() INTO aBalanceBreakDownFeeId;

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
	IN p_educationalStageId varchar(100), 
	IN p_description TEXT, 
	IN p_gradeLevelId INT,
    IN p_schoolYearId INT,
    IN p_addedBy_UserId INT,
    IN p_editedBy_UserId INT
    )
BEGIN

	DECLARE var_curriculumId INT;
    
    DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
        SELECT 'Failed to add curriculum';
        RESIGNAL;
    END;
	
	
    
    
    START TRANSACTION;
	
    INSERT INTO curriculum_mt(educationalstage_id, description, gradeLevelId)
    VALUES(p_educationalStageId,p_description,p_gradeLevelId);
    
    
    SELECT LAST_INSERT_ID() INTO var_curriculumId;
    
    
    INSERT INTO curriculum_hd(curriculumId, addedBy_UserId, editedBy_UserId, dateLastEdited)
    VALUES(var_curriculumId,p_addedBy_UserId,p_editedBy_UserId,NOW());
    
    
    INSERT INTO curriculum_schoolyears(curriculumId, schoolYearId)
    VALUES(var_curriculumId,p_schoolYearId);
    
		COMMIT;
        SELECT 'Successfully added curriculum' AS msg; 
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addCurriculumSubject` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addCurriculumSubject`( IN aEducationalStageId INT,IN aGradeLevelId INT, IN aSchoolYearId INT, IN aSubjectId INT,IN aAddedByUserId INT )
BEGIN
	DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
        RESIGNAL;
    END;

	START TRANSACTION;

	INSERT INTO curriculum_subjects(curriculumId,subjectId,addedBy_UserId)
    VALUES
    (
    
		(SELECT c.id FROM curriculum_mt 			c 								
        INNER JOIN curriculum_schoolyears	 	cs 	ON c.id = cs.curriculumId 
        INNER JOIN schoolyear_mt	 				s 	ON cs.schoolYearId = s.id 
        INNER JOIN gradelevel_mt	 				g 	ON c.gradeLevelId = g.gradelevel_id 
		INNER JOIN 	educationalstage			es ON c.educationalstage_id = es.id
            WHERE 
            
            c.educationalstage_id 	 = aEducationalStageId 			AND 
			g.gradelevel_id  = aGradeLevelId 	AND 
			s.id = aSchoolYearId
		),
		
		aSubjectId,aAddedByUserId
    
    );
    
    
		COMMIT;
        
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addCurriculumWithSubjects` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addCurriculumWithSubjects`(OUT pOUT_subjectId INT, IN pIN_subjectCode VARCHAR(250), IN pIN_curriculumId INT)
BEGIN
	START TRANSACTION;
	SELECT subject_id INTO pOUT_subjectId FROM subject_mt WHERE code = pIN_subjectCode;
    
    INSERT INTO curriculum_subject_lt(curriculum_id,subject_id)
    VALUES(pIN_curriculumId, pOUT_subjectId);
    COMMIT;
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
    IN p_contact varchar(45),
    IN p_employeeId varchar(45),
    OUT p_aFacultyID INT
    
)
BEGIN
	INSERT INTO faculty_mt (employeeId,firstName,lastName,middleName,email,contact)
    VALUES(p_employeeId,p_firstName,p_lastName,p_middleName,p_email,p_contact);
    SELECT LAST_INSERT_ID()INTO p_aFacultyId;
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `addFacultyAndSpecialization`(
	IN p_faculty_id INT,
    IN p_specialization_id INT
    
)
BEGIN
	INSERT INTO faculty_specialization(faculty_id,specialization_id)
    VALUES(p_faculty_id,p_specialization_id);

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
/*!50003 DROP PROCEDURE IF EXISTS `addPaymentTermDeadline` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addPaymentTermDeadline`(   aSchoolYearId INT, aPaymentTermId INT, aPeriodId INT, aDeadline DATE)
BEGIN

INSERT INTO paymentterm_deadline(schoolyear_id, paymentterm_id, period_id, deadline)
VALUES(aSchoolYearId, aPaymentTermId, aPeriodId, aDeadline);

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
aGuardianOfficePhoneNo VARCHAR(255),
aGuardianMobileNo VARCHAR(255),
aGuardianRelationToStudent VARCHAR(255),
aIsGuardianContactInCaseEmergency BIT(1),
aSchoolLastAttended VARCHAR(255),
aSchoolLastAttendedAddress VARCHAR(255),
aRoomOrHouseNo VARCHAR(255),
aStreet VARCHAR(255),
aBrgyOrSubd VARCHAR(255),
aCity VARCHAR(255),
aProvince VARCHAR(255),
aGradeLevelId INT,
aSchoolYearId INT,
aPaymentTermId INT,
OUT aRegistrationId INT
)
BEGIN

INSERT INTO registration_mt(
student_type, 
lastname, firstname, middlename, dob, pob, nationality, 
religion, gender, father_firstname, father_middlename, father_lastname, 
father_occupation, father_officephone_no, father_mobile_no, isFatherContactInCaseEmergency, 
mother_firstname, mother_middlename, mother_lastname,mother_occupation, mother_officephone_no, mother_mobile_no, 
isMotherContactInCaseEmergency, guardian_lastname, guardian_firstname, guardian_middlename, 
guardian_occupation, guardian_officephone_no, guardian_mobile_no, guardian_relation_to_student, 
isGuardianContactInCaseEmergency, school_last_attended, school_last_attended_address, 
room_or_house_no, street, brgy_or_subd, city, province, gradelevel_id, schoolyear_id,
paymentterm_id
)

VALUES(aStudentType,aStudentLastName,aStudentFirstName,aStudentMiddleName,aDOB,aPOB,aNationality,
aReligion,aGender,aFatherFirstName,aFatherMiddleName,aFatherLastName,aFatherOccupation,aFatherOfficePhoneNo,aFatherMobileNo,aIsFatherContactInCaseEmergency,
aMotherFirstName,aMotherMiddleName,aMotherLastName,aMotherOccupation,
aMotherOfficePhoneNo,aMotherMobileNo,
aIsMotherContactInCaseEmergency,aGuardianLastName,aGuardianFirstName,aGuardianMiddleName,
aGuardianOccupation,aGuardianOfficePhoneNo,aGuardianMobileNo,aGuardianRelationToStudent,
aIsGuardianContactInCaseEmergency,aSchoolLastAttended,aSchoolLastAttendedAddress,
aRoomOrHouseNo,aStreet,aBrgyOrSubd,aCity,aProvince,aGradeLevelId,aSchoolYearId,
aPaymentTermId
);

SELECT LAST_INSERT_ID() INTO aRegistrationId;


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
    p_capacity Varchar(45) 
)
BEGIN

	INSERT INTO room_mt (room_name_or_num,bldg_name_or_num,capacity)
    VALUES (p_roomName,p_buildingName,p_capacity);

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
aScheduleDay VARCHAR(255), 
aStartTime INT, 
aEndTime INT,
aSchoolYearId INT, 
aSubjectId INT, 
aSectionId INT,
aRoomId INT,
aGradeLevelId INT,
OUT aScheduleId INT)
BEGIN
INSERT INTO schedule_mt (
schedule_day, startTime, endTime, schoolyear_id, subject_id, section_id, room_id,gradelevel_id)
VALUES(aScheduleDay,aStartTime,aEndtime,aSchoolYearId, aSubjectId, aSectionId, aRoomId, aGradeLevelId);

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
IN aYearFrom INT, 
IN aYearTo INT, 
IN aStartDate DATE, 
IN aEndDate DATE,
IN aEnrollmentDateOpen DATE,
IN aEnrollmentDateClosed DATE,
IN aTotalClassHour INT,
OUT outSchoolYearId INT )
BEGIN
	DECLARE aNewSchoolYearId INT;

	DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
        RESIGNAL;
    END;

	START TRANSACTION;
    
    INSERT INTO schoolyear_mt(yearFrom, yearTo, start_date, end_date,total_class_hours)
    VALUES(aYearFrom, aYearTo, aStartDate, aEndDate,aTotalClassHour);
    
    SELECT LAST_INSERT_ID() INTO aNewSchoolYearId;
    SELECT LAST_INSERT_ID() INTO outSchoolYearId;
    
    INSERT INTO enrollment_mt(schoolyear_id, opening_date, closing_date)
    VALUES(aNewSchoolYearId, aEnrollmentDateOpen, aEnrollmentDateClosed);
    
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSchoolYearHoliday` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSchoolYearHoliday`(aSchoolYearId INT, aHolidayId INT)
BEGIN

INSERT INTO schoolyear_holiday_lt(schoolyear_id, holiday_id)
VALUES(aSchoolYearId, aHolidayId);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSchoolYearSummerSchedule` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSchoolYearSummerSchedule`(aSchoolYearId INT, aStartDate DATE, aEndDate DATE)
BEGIN
INSERT INTO schoolyear_summer_schedule
(schoolyear_id,start_date, end_date)VALUES
(aSchoolYearId,aStartDate,aEndDate);

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
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addSection`(aSectionName VARCHAR(255), OUT aSectionId INT)
BEGIN

DECLARE EXIT HANDLER FOR sqlexception
BEGIN
		ROLLBACK;
        RESIGNAL;
END;



START TRANSACTION;

INSERT INTO section_mt(sectionName)
VALUES(aSectionName);

SELECT LAST_INSERT_ID() INTO aSectionId;

COMMIT;

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `addTransaction`(aStudentId INT, OUT aTransactionId INT)
BEGIN
	
    
START TRANSACTION;
	INSERT INTO transaction_mt(student_id)
	VALUES(aStudentId);
    
    SELECT LAST_INSERT_ID() INTO aTransactionId;
    
  

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addTransactionPayment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addTransactionPayment`(aTransactionId INT, aPaymentId INT)
BEGIN

INSERT INTO transaction_payment_lt(transaction_id, payment_id)
VALUES(aTransactionId, aPaymentId);

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
/*!50003 DROP PROCEDURE IF EXISTS `addTuitionFee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addTuitionFee`(IN aBalanceBreakDownFeeId INT, IN aStudentId INT, aSchoolYearId INT)
BEGIN

INSERT INTO tuition_fee (balance_breakdown_fee_id, student_id, schoolyear_id)
VALUES(aBalanceBreakDownFeeId,aStudentId,aSchoolYearId);

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
aPassword VARCHAR(30),
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
/*!50003 DROP PROCEDURE IF EXISTS `createCurriculum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `createCurriculum`(
	IN pIN_schoolYearId INT,
    IN pIN_curriculumTitle VARCHAR(150),
    IN pIN_description VARCHAR(150),
    OUT pOUT_curriculumId INT
)
BEGIN
    
  DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
		ROLLBACK;
			SELECT "Duplicate keys found";
        RESIGNAL;
    END;
    
    
	INSERT INTO curriculum_mt(schoolyear_id, curriculum_title, description, isActive, date_created)
	VALUES(pIN_schoolYearId, pIN_curriculumTitle, pIN_description, TRUE, NOW());
		
	SET pOUT_curriculumId = LAST_INSERT_ID();
    
	SELECT 'Successfully added curriculum' AS msg;

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
    IN pIN_gradeLevelId INT
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
    
	INSERT INTO subject_gradelevel_lt (subject_id, gradelevel_id)
	VALUES (pOUT_subjectId,pIN_gradeLevelId);
			
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
/*!50003 DROP PROCEDURE IF EXISTS `getAdviserSectionByAdviserId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAdviserSectionByAdviserId`(IN pIN_adviserId INT)
BEGIN
	
    SELECT section_mt.sectionName FROM section_settings_lt
    INNER JOIN section_mt ON section_mt.section_id = section_settings_lt.section_id
	WHERE adviser_id = pIN_adviserId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllActiveDiscounts` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllActiveDiscounts`()
BEGIN
	
SELECT * from discount_mt WHERE isActive = 1;

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
/*!50003 DROP PROCEDURE IF EXISTS `getAllActiveStudentsOfCurrentSchoolYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllActiveStudentsOfCurrentSchoolYear`()
BEGIN

SELECT sy.*,r.*,s.*,a.*,
s.student_type AS aStudentType,
s.isActive AS aStudentStatus 
FROM registration_mt r
INNER JOIN admission_mt a ON r.registration_id = a.registration_Id
INNER JOIN student_mt s ON r.registration_id = s.registration_id
LEFT JOIN schoolyear_student_lt sslt ON s.student_id = sslt.student_id
LEFT JOIN schoolyear_mt sy ON sslt.schoolyear_id =  sy.schoolyear_id
WHERE sy.isCurrentSchoolYear = 1 AND 
s.isActive = 1
ORDER BY r.lastname;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllAddedStudentBySectionId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllAddedStudentBySectionId`(IN pIN_gradeLevelId INT, IN pIN_sectionId INT)
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
    AND schoolyear_student_lt.section_id = pIN_sectionId
    
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
/*!50003 DROP PROCEDURE IF EXISTS `getAllClassList` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllClassList`()
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
INNER JOIN gradelevel_mt gl ON sslt.gradelevel_id = gl.gradelevel_id;

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
	
	SELECT 
		curriculum_mt.curriculum_id, curriculum_mt.curriculum_title,
		schoolyear_mt.yearFrom, schoolyear_mt.yearTo, curriculum_mt.description, 
        DATE_FORMAT(curriculum_mt.date_created, "%M %e %Y %h:%i %p") AS date_created, 
        curriculum_mt.isActive
			FROM curriculum_subject_lt
				INNER JOIN curriculum_mt ON curriculum_mt.curriculum_id = curriculum_subject_lt.curriculum_id
				INNER JOIN schoolyear_mt ON schoolyear_mt.schoolyear_id = curriculum_mt.schoolyear_id
                GROUP BY curriculum_mt.curriculum_id;
    
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
	
    SELECT
     faculty_mt.firstName, faculty_mt.middleName, faculty_mt.lastName
	FROM faculty_mt
	LEFT JOIN section_settings_lt ON section_settings_lt.adviser_id = faculty_mt.faculty_id
	WHERE
    section_settings_lt.adviser_id IS NULL;
    
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
f3.*

FROM fee_mt f1 
INNER JOIN fee_schoolyear_lt f2 ON f1.fee_id = f2.fee_id
INNER JOIN fee_category_mt f3 ON f1.fee_category_id = f3.fee_category_id
INNER JOIN gradelevel_mt gl ON f2.gradelevel_id = gl.gradelevel_id;


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
/*!50003 DROP PROCEDURE IF EXISTS `getAllPaymentTermDownPayment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllPaymentTermDownPayment`()
BEGIN
	SELECT pt.paymentterm,ptd.downpayment,
    CONCAT(sy.yearFrom,'-',sy.yearTo) AS schoolyear
    FROM paymentterm pt
    INNER JOIN paymentterm_downpayment ptd ON pt.id = ptd.paymentterm_id
    INNER JOIN paymentterm_downpayment_schoolyear ptdsy ON ptd.id = ptdsy.paymentterm_downpayment_id
    INNER JOIN schoolyear sy ON ptdsy.schoolyear_id = sy.id;
    
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
	SELECT pt.* FROM paymentterm_mt pt;

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
/*!50003 DROP PROCEDURE IF EXISTS `getAllRegistrationInfoBySchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllRegistrationInfoBySchoolYearId`(aSchoolYearId INT)
BEGIN

SELECT r.*,g.*,s.*,a.* FROM registration_mt r
    INNER JOIN gradelevel_mt g ON r.gradelevel_id = g.gradelevel_id
    INNER JOIN schoolyear_mt s ON r.schoolyear_id = s.schoolyear_id
    INNER JOIN admission_mt a ON r.registration_id = a.registration_id
	WHERE r.schoolyear_id = aSchoolYearId;
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllRegistrationInfoByWildCard`(aKeyword VARCHAR(255))
BEGIN
	SELECT r.*,g.*,s.*,a.* 
    FROM registration_mt r
    INNER JOIN gradelevel_mt g ON r.gradelevel_id = g.gradelevel_id
    INNER JOIN schoolyear_mt s ON r.schoolyear_id = s.schoolyear_id
    LEFT JOIN admission_mt a ON r.registration_id = a.registration_id
    WHERE 
    
    r.registration_id LIKE CONCAT('%',aKeyword,'%') OR
    r.lastname LIKE CONCAT('%',aKeyword,'%') OR 
    r.firstname LIKE CONCAT('%',aKeyword,'%')
    
    ORDER BY r.lastname;
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
/*!50003 DROP PROCEDURE IF EXISTS `getAllSchedule` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSchedule`()
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
INNER JOIN schoolyear_mt sy ON sched.schoolyear_id = sy.schoolyear_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllScheduleBySchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllScheduleBySchoolYearId`(aSchoolYearId INT)
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
WHERE sched.schoolyear_id = aSchoolYearId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllScheduleBySubjectIdAndSchoolYearId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllScheduleBySubjectIdAndSchoolYearId`(aSubjectId INT, aSchoolYearId INT)
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
WHERE sched.subject_id = aSubjectId AND sched.schoolyear_id = aSchoolYearId;

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
 SELECT * FROM schoolyear_mt ORDER BY yearFrom;
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
    LEFT JOIN faculty_mt ON faculty_mt.faculty_id = section_settings_lt.adviser_id;
	
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
/*!50003 DROP PROCEDURE IF EXISTS `getAllSubjectInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSubjectInfo`()
BEGIN
	SELECT 
    s.*, 
    gl.`level`, 
    sy.yearFrom,
    sy.yearTo,
    CONCAT(uA.lastname,', ',uA.firstname) AS AddedBy, 
    shd.dateAdded,
    CONCAT(uB.lastname,', ',uB.firstname) AS EditedBy, 
    shd.dateEdited
    
    
    
				
    FROM 		`subject` 				s 								
    INNER JOIN 	subject_hd 			    shd ON s.subject_id = shd.subject_id 
    INNER JOIN 	subject_gradelevel 		sgl ON s.subject_id = sgl.subject_id 
    
    
    INNER JOIN  gradelevel				gl 	ON sgl.gradelevel_id = gl.gradelevel_id
    INNER JOIN 	schoolyear				sy	ON sgl.schoolyear_id = sy.schoolyear_id
    INNER JOIN	user					uA	ON shd.addedBy_UserId = uA.user_id 
    INNER JOIN 	user					uB	ON shd.editedBy_UserId = uB.user_id;
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

	SELECT subject_gradelevel_lt.subject_id, code, title, description, isActive 
		FROM subject_gradelevel_lt
			INNER JOIN subject_mt ON subject_mt.subject_id = subject_gradelevel_lt.subject_id
				WHERE subject_gradelevel_lt.gradelevel_id = pIN_gradeLevelId;
		
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
	SELECT yearFrom, yearTo FROM schoolyear_mt WHERE isCurrentSchoolYear = 1;
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
/*!50003 DROP PROCEDURE IF EXISTS `getCurriculumId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurriculumId`(IN pIN_curriculumName VARCHAR(150))
BEGIN
	SELECT curriculum_id FROM curriculum_mt WHERE curriculum_mt.curriculum_title = pIN_curriculumName;
    
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
/*!50003 DROP PROCEDURE IF EXISTS `getFacultyByID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFacultyByID`(
	IN p_facultyID int(11)
)
BEGIN
	SELECT * FROM faculty_mt WHERE faculty_id = p_facultyID;
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `getFacultyIdByName`(aLastName VARCHAR(255), aFirstName VARCHAR(255), aMiddleName VARCHAR(255))
BEGIN

SELECT faculty_id FROM faculty_mt
WHERE 
lastName = aLastName AND
firstName = aFirstName AND
middleName = aMiddleName;

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
f3.*

FROM fee_mt f1 
INNER JOIN fee_schoolyear_lt f2 ON f1.fee_id = f2.fee_id
INNER JOIN fee_category_mt f3 ON f1.fee_category_id = f3.fee_category_id
INNER JOIN gradelevel_mt gl ON f2.gradelevel_id = gl.gradelevel_id

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

SELECT grade_level FROM gradelevel_mt WHERE gradelevel_id = aGradeLevelId;

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
/*!50003 DROP PROCEDURE IF EXISTS `getLastGradeLevelStudentPassed` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getLastGradeLevelStudentPassed`(aStudentId INT)
BEGIN

SELECT MAX(grade_level) FROM schoolyear_student_lt sslt
INNER JOIN gradelevel_mt gl ON sslt.gradelevel_id = gl.gradelevel_id
WHERE 
student_id = aStudentId AND passed = 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getMiscellaneousByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getMiscellaneousByGradeLevelId`(aGradeLevelId INT)
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

WHERE fc.fee_category = 'Miscellaneous'
AND fs.gradelevel_id = aGradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getMiscellaneousFeesByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getMiscellaneousFeesByGradeLevelId`(aGradeLevelId INT)
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

WHERE fc.fee_category = 'Miscellaneous'
AND fs.gradelevel_id = aGradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getOtherFeesByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getOtherFeesByGradeLevelId`(aGradeLevelId INT)
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

WHERE fc.fee_category = 'Others'
AND fs.gradelevel_id = aGradeLevelId;

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
/*!50003 DROP PROCEDURE IF EXISTS `getPaymentTermId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPaymentTermId`(aPaymentTerm VARCHAR(255))
BEGIN
SELECT paymentterm_id FROM paymentterm_mt
WHERE paymentterm = aPaymentTerm;
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
/*!50003 DROP PROCEDURE IF EXISTS `getPaymentTermPeriodsById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPaymentTermPeriodsById`(aPaymentTermId INT, aSchoolYearId INT)
BEGIN

SELECT p.period_id, p.period_code, p.description, pd.deadline
FROM paymentterm_mt pt
INNER JOIN paymentterm_period pp ON pt.paymentterm_id = pp.paymentterm_id
INNER JOIN period p ON pp.period_id = p.period_id
INNER JOIN paymentterm_deadline pd ON p.period_id = pd.period_id
WHERE pd.paymentterm_id = aPaymentTermId 
AND pd.schoolyear_id = aSchoolYearId
GROUP BY period_id;

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
/*!50003 DROP PROCEDURE IF EXISTS `getPeriodsByPaymentTermId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPeriodsByPaymentTermId`(aPaymentTermId INT, aSchoolYearId INT)
BEGIN

SELECT p.period_id,p.period_code,p.description, pd.deadline FROM paymentterm_deadline pd
INNER JOIN period p ON pd.period_id = p.period_id
INNER JOIN paymentterm_mt pt ON pd.paymentterm_id = pt.paymentterm_id
WHERE pt.paymentterm_id = aPaymentTermId
AND pd.schoolyear_id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getPresentGradeLevelByStudentId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPresentGradeLevelByStudentId`(aStudentId INT)
BEGIN

DECLARE aPresentGradeLevel INT;
DECLARE aRegistrationGradeLevel INT;

SELECT gl.grade_level INTO aRegistrationGradeLevel FROM registration_mt r
LEFT JOIN student_mt s ON r.registration_id = s.registration_id
INNER JOIN gradelevel_mt gl ON r.gradelevel_id = gl.gradelevel_id
WHERE s.student_id = aStudentId;

SELECT 
gl.grade_level
INTO aPresentGradeLevel
FROM schoolyear_student_lt sslt
INNER JOIN gradelevel_mt gl ON sslt.gradelevel_id = gl.gradelevel_id
WHERE sslt.student_id = aStudentId 
ORDER BY gl.grade_level DESC LIMIT 1;


IF aPresentGradeLevel IS NULL
THEN
	SELECT aRegistrationGradeLevel INTO aPresentGradeLevel;
    SELECT aPresentGradeLevel;
ELSE 
	SELECT aPresentGradeLevel;
END IF;

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRegistrationInfoById`(IN aRegistrationId INT)
BEGIN
	SELECT r.*,g.*,s.*,a.* FROM registration_mt r
    INNER JOIN gradelevel_mt g ON r.gradelevel_id = g.gradelevel_id
    INNER JOIN schoolyear_mt s ON r.schoolyear_id = s.schoolyear_id
    LEFT JOIN admission_mt a ON r.registration_id = a.registration_id
    WHERE r.registration_id = aRegistrationId;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getRegistrationPaymentTermByStudentId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRegistrationPaymentTermByStudentId`(aStudentId INT)
BEGIN

SELECT pt.paymentterm FROM paymentterm_mt pt
INNER JOIN registration_mt r ON pt.paymentterm_id = r.paymentterm_id
INNER JOIN student_mt s ON r.registration_id = s.registration_id
WHERE s.student_id = aStudentId;


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
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSchoolYearById`(aSchoolYearId INT)
BEGIN

SELECT * FROM schoolyear_mt WHERE schoolyear_id = aSchoolYearId;

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
/*!50003 DROP PROCEDURE IF EXISTS `getStudentCurrentGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentCurrentGradeLevel`(aStudentId INT)
BEGIN

SELECT 
CASE WHEN 
(
(SELECT COUNT(*) FROM schoolyear_student_lt WHERE student_id = aStudentId) = 1
)
THEN(
SELECT gl.grade_level FROM gradelevel_mt gl
INNER JOIN registration_mt r ON gl.gradelevel_id = r.gradelevel_id 
INNER JOIN student_mt s ON r.registration_id = s.registration_id 
WHERE s.student_id = aStudentId
)

ELSE 
(
SELECT
g.grade_level FROM schoolyear_student_lt sslt
INNER JOIN gradelevel_mt g ON sslt.gradelevel_id = g.gradelevel_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id
WHERE sslt.student_id = aStudentId
ORDER BY (SELECT sy.yearFrom) DESC LIMIT 1 
) 
END AS grade_level;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStudentCurrentGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentCurrentGradeLevelId`(aStudentId INT)
BEGIN

SELECT 
CASE WHEN 
(
(SELECT COUNT(*) FROM schoolyear_student_lt WHERE student_id = aStudentId) = 1
)
THEN(
SELECT gl.gradelevel_id 
FROM gradelevel_mt gl
INNER JOIN registration_mt r ON gl.gradelevel_id = r.gradelevel_id 
INNER JOIN student_mt s ON r.registration_id = s.registration_id 
WHERE s.student_id = aStudentId
)

ELSE 
(
SELECT
g.gradelevel_id 
FROM schoolyear_student_lt sslt
INNER JOIN gradelevel_mt g ON sslt.gradelevel_id = g.gradelevel_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id
WHERE sslt.student_id = aStudentId
ORDER BY (SELECT sy.yearFrom) DESC LIMIT 1 
) 
END AS gradelevel_id;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStudentDiscount` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentDiscount`(aStudentId INT, aSchoolYearId INT)
BEGIN

SELECT d.*,sd.* FROM discount_mt d
INNER JOIN student_discount_lt sd
ON d.discount_id = sd.discount_id
WHERE sd.student_id = aStudentId
AND sd.schoolyear_id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStudentFailedSubjectById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentFailedSubjectById`(IN pIN_studentId INT)
BEGIN
	
    SELECT subject_mt.subject_id, subject_mt.title FROM student_grade
	INNER JOIN grade ON grade.grade_id = student_grade.grade_id
	INNER JOIN subject_mt ON subject_mt.subject_id = grade.subject_id

	WHERE student_grade.student_id = pIN_studentId
	AND grade.final <= 74

	GROUP BY subject_mt.subject_id, subject_mt.title;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStudentGradeByAdviserStudentId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentGradeByAdviserStudentId`(IN pIN_adviserId INT, IN pIN_studentId INT)
BEGIN
    
	SELECT subject_mt.subject_id, subject_mt.title,
       MAX(IF(g.gradingperiod_id = 7000, g.grade, "")) AS first,
       MAX(IF(g.gradingperiod_id = 7001, g.grade, "")) AS second,
       MAX(IF(g.gradingperiod_id = 7002, g.grade, "")) AS third,
       MAX(IF(g.gradingperiod_id = 7003, g.grade, "")) AS fourth,
       g.final
       
	FROM faculty_schedule

	INNER JOIN schedule_mt ON schedule_mt.schedule_id = faculty_schedule.schedule_id
    INNER JOIN section_student ON section_student.section_id = schedule_mt.section_id
    INNER JOIN subject_mt ON subject_mt.subject_id = schedule_mt.subject_id
    INNER JOIN section_settings_lt ON section_settings_lt.section_id = section_student.section_id
	INNER JOIN curriculum_subject_lt ON curriculum_subject_lt.subject_id = subject_mt.subject_id
    INNER JOIN curriculum_mt ON curriculum_mt.curriculum_id = curriculum_subject_lt.curriculum_id
    LEFT JOIN student_grade AS sg ON sg.student_id = section_student.student_id
    LEFT JOIN grade AS g ON g.grade_id = sg.grade_id
    
    WHERE section_settings_lt.adviser_id = pIN_adviserId
    AND section_student.student_id = pIN_studentId
    AND curriculum_mt.isActive = 1
    AND g.isSubmitted = TRUE
    
    GROUP BY subject_mt.subject_id, subject_mt.title, g.final;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStudentGradeByFacultyStudentId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentGradeByFacultyStudentId`(IN pIN_facultyId INT, IN pIN_studentId INT)
BEGIN
    
	SELECT 
		
		smt.subject_id, smt.title,
	   MAX(IF(g.gradingperiod_id = 7000, g.grade, 0)) AS first,
       MAX(IF(g.gradingperiod_id = 7001, g.grade, 0)) AS second,
       MAX(IF(g.gradingperiod_id = 7002, g.grade, 0)) AS third,
       MAX(IF(g.gradingperiod_id = 7003, g.grade, 0)) AS fourth,
       g.final
    
	FROM faculty_schedule

	INNER JOIN schedule_mt ON schedule_mt.schedule_id = faculty_schedule.schedule_id
    INNER JOIN section_student ON section_student.section_id = schedule_mt.section_id
    INNER JOIN student_grade ON student_grade.student_id = section_student.student_id
    INNER JOIN grade g ON g.grade_id = student_grade.grade_id
    INNER JOIN subject_mt smt ON smt.subject_id = schedule_mt.subject_id
	INNER JOIN curriculum_subject_lt ON curriculum_subject_lt.subject_id = smt.subject_id
    INNER JOIN curriculum_mt ON curriculum_mt.curriculum_id = curriculum_subject_lt.curriculum_id
    
    WHERE faculty_schedule.faculty_id = pIN_facultyId
    AND section_student.student_id = pIN_studentId
    AND curriculum_mt.isActive = 1
    
	GROUP BY smt.subject_id, smt.title, g.final;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStudentIdByRegistrationId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentIdByRegistrationId`(aRegistrationId INT)
BEGIN

SELECT student_id FROM student_mt 
WHERE registration_id = aRegistrationId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStudentNameByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentNameByGradeLevelId`(IN pIN_gradeLevelId INT)
BEGIN
	
    SELECT firstname, middlename, lastname FROM registration_mt
    WHERE gradelevel_id = pIN_gradeLevelId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStudentPaymentTerm` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentPaymentTerm`(aStudentId INT, aSchoolYearId INT)
BEGIN

SELECT pt.* FROM paymentterm_mt pt
INNER JOIN student_paymentterm_lt spl 
ON pt.paymentterm_id = spl.paymentterm_id
WHERE spl.student_id = aStudentId
AND spl.schoolyear_id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStudentRecordById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentRecordById`(aStudentId INT)
BEGIN

SELECT 
s.*, r.*,a.*,
sy.schoolyear_id,
sy.yearFrom , sy.yearTo

FROM registration_mt r 
INNER JOIN schoolyear_mt sy ON r.schoolyear_id = sy.schoolyear_id
INNER JOIN gradelevel_mt gl ON r.gradelevel_id = gl.gradelevel_id

INNER JOIN admission_mt a ON r.registration_id = a.registration_id
INNER JOIN student_mt s ON  a.registration_id = s.registration_id

LEFT JOIN schoolyear_student_lt sslt ON s.student_id = sslt.student_id
LEFT JOIN schoolyear_mt sya ON sslt.schoolyear_id = sya.schoolyear_id
LEFT JOIN gradelevel_mt gla ON sslt.gradelevel_id = gla.gradelevel_id

WHERE s.student_id = aStudentId
ORDER BY sya.yearFrom DESC, sya.yearTo DESC, gla.grade_level DESC
LIMIT 1;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStudentsBySchoolYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentsBySchoolYear`(IN aSchoolYearId INT)
BEGIN

SELECT a.admission_id, a.isComplete, a.completion_date,
r.*,s.student_id,s.entry_date,s.isGraduated, s.date_graduated, s.isActive,
gl.grade_level AS gradelevel_enrolled,
sslt.schoolyear_id AS schoolyear_id_enrolled, 
sy.YearFrom AS schoolyear_enrolled_yearfrom,
sy.YearTo AS schoolyear_enrolled_yearto

FROM admission_mt a 
INNER JOIN registration_mt r ON a.registration_id = r.registration_id
INNER JOIN student_mt s ON s.registration_id = r.registration_id
INNER JOIN schoolyear_student_lt sslt ON s.student_id = sslt.student_id
INNER JOIN gradelevel_mt gl ON sslt.gradelevel_id = gl.gradelevel_id
INNER JOIN schoolyear_mt sy ON sslt.schoolyear_id = sy.schoolyear_id 

WHERE 
sslt.schoolyear_id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStudentsBySchoolYearAndStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentsBySchoolYearAndStatus`(IN aSchoolYearId INT, IN aIsActiveStatus INT)
BEGIN

SELECT 
r.*,s.*,a.*

FROM registration_mt r
INNER JOIN admission_mt a ON r.registration_id = a.registration_id
INNER JOIN student_mt s ON a.registration_id = s.registration_id
INNER JOIN gradelevel_mt gl ON r.gradelevel_id = gl.gradelevel_id
INNER JOIN schoolyear_mt sy ON r.schoolyear_id = sy.schoolyear_id

LEFT OUTER JOIN schoolyear_student_lt sslt ON s.student_id = sslt.student_id
LEFT OUTER JOIN gradelevel_mt gla ON sslt.gradelevel_id = gla.gradelevel_id
LEFT OUTER JOIN schoolyear_mt sya ON sslt.schoolyear_id = sya.schoolyear_id

WHERE 
s.isActive = aIsActiveStatus
AND
sslt.schoolyear_id = aSchoolYearId
GROUP BY r.registration_id ;


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
/*!50003 DROP PROCEDURE IF EXISTS `getSumOfFeeByGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSumOfFeeByGradeLevel`(aGradeLevelId INT)
BEGIN
select sum(fee_amount) as sumOfFees from fee_schoolyear_lt WHERE gradelevel_id = aGradeLevelId
AND isActive = 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSumOfFees` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSumOfFees`(aGradeLevelId INT, aSchoolYearId INT)
BEGIN
	SELECT SUM(f.amount) AS sumOFFees FROM
    fee_schoolyear fs INNER JOIN fee f ON fs.fee_id = f.id
    INNER JOIN fee_gradelevel fg ON f.id = fg.fee_id
    WHERE fg.gradelevel_id = aGradeLevelId
    AND fs.schoolyear_id = aSchoolYearId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSumOfMiscellaneousFeesByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSumOfMiscellaneousFeesByGradeLevelId`(aGradeLevelId INT)
BEGIN

SELECT SUM(fee_amount) AS sumOfMiscellaneousFees FROM fee_schoolyear_lt fslt
INNER JOIN fee_mt f ON fslt.fee_id = f.fee_id
INNER JOIN fee_category_mt fct ON f.fee_category_id = fct.fee_category_id
WHERE fct.fee_category = 'Miscellaneous'
AND fslt.gradelevel_id = aGradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSumOfOtherFeesByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSumOfOtherFeesByGradeLevelId`(aGradeLevelId INT)
BEGIN

SELECT SUM(fee_amount) AS sumOfOtherFees FROM fee_schoolyear_lt fslt
INNER JOIN fee_mt f ON fslt.fee_id = f.fee_id
INNER JOIN fee_category_mt fct ON f.fee_category_id = fct.fee_category_id
WHERE fct.fee_category = 'Others'
AND fslt.gradelevel_id = aGradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSumOfTuitionFeesByGradeLevelId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSumOfTuitionFeesByGradeLevelId`(aGradeLevelId INT)
BEGIN

SELECT SUM(fee_amount) AS sumOfTuitionFee FROM fee_schoolyear_lt fslt
INNER JOIN fee_mt f ON fslt.fee_id = f.fee_id
INNER JOIN fee_category_mt fct ON f.fee_category_id = fct.fee_category_id
WHERE fct.fee_category = 'Tuition'
AND fslt.gradelevel_id = aGradeLevelId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getTuitionFee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getTuitionFee`(aStudentId INT, aSchoolYearId INT)
BEGIN

SELECT 
tf.student_id, tf.schoolyear_id,tf.date_assigned,
bbf.*,
sy.*,
s.registration_id,s.entry_date,s.isActive,s.isGraduated,s.student_type,
p.payment_id, p.amount_tendered, p.date_of_payment,

CASE WHEN bbf.amount - sum(p.amount_tendered) >= 0
		THEN bbf.amount - sum(p.amount_tendered)
	 WHEN bbf.amount - sum(p.amount_tendered) < 0
		THEN 0.00
	ELSE bbf.amount
END AS balance,

CASE WHEN bbf.amount - sum(p.amount_tendered) <= 0
		THEN TRUE
	 WHEN bbf.amount - sum(p.amount_tendered) > 0
		THEN FALSE
	ELSE FALSE
END AS isPaid

FROM tuition_fee tf
LEFT JOIN payment p 
ON tf.balance_breakdown_fee_id = p.balance_breakdown_fee_id
INNER JOIN balance_breakdown_fee bbf 
ON tf.balance_breakdown_fee_id = bbf.balance_breakdown_fee_id
INNER JOIN schoolyear_mt sy 
ON tf.schoolyear_id = sy.schoolyear_id
INNER JOIN student_mt s ON tf.student_id = s.student_id
WHERE tf.student_id = aStudentId
AND tf.schoolyear_id = aSchoolYearId
GROUP BY bbf.balance_breakdown_fee_id;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getTuitionFeeSum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getTuitionFeeSum`(aStudentId INT, aSchoolYearId INT)
BEGIN
	SELECT SUM(bbf.amount) AS tuitionFeeSum FROM tuition_fee tf
	INNER JOIN balance_breakdown_fee bbf ON tf.balance_breakdown_fee_id = bbf.balance_breakdown_fee_id
	WHERE student_id = aStudentId AND
	schoolyear_id = aSchoolYearId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getTuitionFeeTotalPaid` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getTuitionFeeTotalPaid`(aStudentId INT, aSchoolYearId INT)
BEGIN

SELECT SUM(p.amount_tendered) AS totalTuitionPaid
FROM payment p
INNER JOIN balance_breakdown_fee bbf 
ON p.balance_breakdown_fee_id = bbf.balance_breakdown_fee_id
INNER JOIN tuition_fee tf 
ON bbf.balance_breakdown_fee_id = tf.balance_breakdown_fee_id
WHERE tf.student_id = aStudentId
AND tf.schoolyear_id = aSchoolYearId; 

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
/*!50003 DROP PROCEDURE IF EXISTS `hasTuitionFeeDiscount` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `hasTuitionFeeDiscount`(aStudentId INT, aSchoolYearId INT)
BEGIN

SELECT 
CASE WHEN COUNT(*) > 0
	THEN TRUE 
    ELSE FALSE
		END AS hasDiscount
FROM student_discount_lt
WHERE student_id = aStudentId
AND schoolyear_id = aSchoolYearId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `isAlreadyEnrolledInCurrentSchoolYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `isAlreadyEnrolledInCurrentSchoolYear`(aStudentId INT, aCurrentSchoolYearId INT)
BEGIN

SELECT * FROM schoolyear_student_lt 
WHERE student_id = aStudentId
AND schoolyear_id = aCurrentSchoolYearId; 

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `isAlreadyStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `isAlreadyStudent`(aLastName VARCHAR(255), aFirstName VARCHAR(255), aMiddleName VARCHAR(255), aDateOfBirth DATE)
BEGIN
	SELECT * FROM students WHERE
    lastName = aLastName AND
    firstName = aFirstName AND
    middleName = aMiddleName AND
    dateOfBirth = aDateOfBirth;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `isDuplicateRegistration` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `isDuplicateRegistration`(p_firstName VARCHAR(255),p_middleName VARCHAR(255), p_lastName VARCHAR(255))
BEGIN

DECLARE recordCount INT;
DECLARE isDuplicate BOOLEAN;

SELECT COUNT(*) INTO recordCount FROM registration_mt WHERE 
lastname = p_lastName AND 
firstname = p_firstName AND 
middlename = p_middleName;

SELECT 
CASE WHEN recordCount > 0
THEN TRUE
ELSE FALSE
END AS isDuplicate;
 
 
 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `isEnrolledInSchoolYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `isEnrolledInSchoolYear`(aStudentId INT, aSchoolYearId INT)
BEGIN
SELECT * from schoolyear_student_lt 
WHERE student_id = aStudentId AND 
schoolyear_id = aSchoolYearId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `isEnrollmentClosedForSchoolYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `isEnrollmentClosedForSchoolYear`(aSchoolYearId INT)
BEGIN

DECLARE aEnrollmentClosingDate DATE;

SELECT e.closing_date INTO aEnrollmentClosingDate 
FROM enrollment_mt e
WHERE e.schoolyear_id = aSchoolYearId;

SELECT IF(CURDATE() > DATE(aEnrollmentClosingDate), 1,0) 
AS is_enrollment_closed ; 

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
/*!50003 DROP PROCEDURE IF EXISTS `isStudentApplicantExists` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `isStudentApplicantExists`(aStudentType VARCHAR(10),aLastName VARCHAR(255),aMiddleName VARCHAR(255), aFirstName VARCHAR(255),aDateOfBirth date)
BEGIN
    SELECT 
    studentType, lastName, firstName, middleName, dateOfBirth
    FROM registration
    
    WHERE studentType = aStudentType AND
		  lastName = aLastName AND
          firstName = aFirstName AND
          middleName = aMiddleName AND
          dateOfBirth = aDateOfBirth     ;
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
/*!50003 DROP PROCEDURE IF EXISTS `payTuitionFee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `payTuitionFee`(aBalanceBreakDownFeeId INT, anAmountTendered DECIMAL(10,2), OUT aPaymentId INT )
BEGIN

INSERT INTO payment(balance_breakdown_fee_id, amount_tendered)
VALUES(aBalanceBreakDownFeeId,anAmountTendered);

SELECT LAST_INSERT_ID() INTO aPaymentId; 

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
/*!50003 DROP PROCEDURE IF EXISTS `studentHasEnrollmentRecord` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `studentHasEnrollmentRecord`(aStudentId INT)
BEGIN

DECLARE recordCount INT;

SELECT count(*) INTO recordCount
FROM schoolyear_student_lt WHERE student_id = aStudentId;

SELECT CASE WHEN recordCount = 0
THEN FALSE
ELSE TRUE 
END AS hasEnrollmentRecord;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `submitStudentGrade` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `submitStudentGrade`(IN pIN_studentId INT, IN pIN_gradingPeriodId INT, IN pIN_subjectId INT)
BEGIN
	UPDATE student_grade
	INNER JOIN grade ON grade.grade_id = student_grade.grade_id

	SET grade.isSubmitted = 1

	WHERE student_grade.student_id = pIN_studentId
	AND grade.gradingperiod_id = pIN_gradingPeriodId
    AND grade.subject_id = pIN_subjectId
    AND grade.grade IS NOT NULL;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `submitStudentGradeGWA` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `submitStudentGradeGWA`(IN pIN_studentId INT, IN pIN_gwa DOUBLE, IN pIN_schoolYearId INT)
BEGIN
	
    UPDATE student_grade
    INNER JOIN grade ON grade.grade_id = student_grade.grade_id
    
    SET grade.gwa = pIN_gwa
    
    WHERE student_grade.student_id = pIN_studentId
    AND grade.schoolyear_id = pIN_schoolYearId;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `tuitionFeeExists` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `tuitionFeeExists`(aStudentId INT, aSchoolYearId INT)
BEGIN
DECLARE rowCount INT;

SELECT COUNT(*) INTO rowCount FROM tuition_fee t 
WHERE student_id = aStudentId
AND schoolyear_id = aSchoolYearId;

IF rowCount > 0 THEN SELECT TRUE AS tuitionFeeExists;
ELSE SELECT FALSE AS tuitionFeeExists;
END IF;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `undoCompleteAdmission` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `undoCompleteAdmission`(aRegistrationId INT)
BEGIN

DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
        RESIGNAL;
    END;

START TRANSACTION;

DELETE FROM student_mt WHERE registration_id = aRegistrationId;
UPDATE admission_mt SET isComplete = 0 where registration_id = aRegistrationId;


COMMIT;

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCurriculumSubjects`(IN p_curriculumId int, IN p_subjectId INT, IN p_editedByUserId INT)
BEGIN

    DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK;
        SELECT 'Error occured' AS Message;
        RESIGNAL;
    END;
	    
    
	START TRANSACTION;
    
		IF NOT EXISTS(SELECT * FROM curriculum_subjects WHERE subjectId = p_subjectId)
        THEN
			INSERT INTO curriculum_subjects
			(curriculumId,subjectId,addedBy_UserId)
				VALUES(p_curriculumId,p_subjectId,p_editedByUserId);
		END IF;
        
        UPDATE curriculum_hd 
			SET editedBy_UserId = p_editedByUserId,
				dateLastEdited = NOW()
			WHERE curriculumId = p_curriculumId ;
    
    
		COMMIT;
        SELECT 'successfully updated' AS result;
        
	
    
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
	IN p_faculty_id int,
	IN p_fname varchar(45),
    IN p_lname varchar(45),
    IN p_mname varchar(45),
    IN p_contact varchar(45),
    IN p_email varchar(45)
    
)
BEGIN
	UPDATE faculty_mt set 
    firstName = p_fname, 
    lastName = p_lname,
    middleName = p_mname,
    contact = p_contact,
    email = p_email
    WHERE faculty_id = p_faculty_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateFinalGradeByStudentId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateFinalGradeByStudentId`(IN pIN_finalGrade INT,IN pIN_studentId INT)
BEGIN
	
    UPDATE student_grade
    INNER JOIN grade ON grade.grade_id = student_grade.grade_id
    
    SET grade.final = pIN_finalGrade
    WHERE student_grade.student_id = pIN_studentId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateGradeByStudentId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateGradeByStudentId`(IN pIN_grade VARCHAR(50),IN pIN_gradingPeriodId INT,IN pIN_studentId INT, IN pIN_subjectId INT)
BEGIN
	
    UPDATE student_grade
    INNER JOIN grade ON grade.grade_id = student_grade.grade_id
    
    SET grade = pIN_grade
    
    WHERE grade.gradingperiod_id = pIN_gradingPeriodId
    AND student_grade.student_id = pIN_studentId
    AND grade.subject_id = pIN_subjectId;
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
    p_status BIT(1)
)
BEGIN

	UPDATE	room_mt SET 
    room_name_or_num = p_roomName, 
    bldg_name_or_num = p_buildingname,
    capacity = p_capacity,
    `status` = p_status
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
/*!50003 DROP PROCEDURE IF EXISTS `updateSubjectAndGradeLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSubjectAndGradeLevel`(OUT pOUT_gradelevel_mt_gradeLevel INT, IN pIN_gradeLevel INT, IN pIN_gradeLevelId INT, IN pIN_subjCode VARCHAR(250), IN pIN_subjTitle VARCHAR(250), IN pIN_subjDescription VARCHAR(250), IN pIN_subjId INT)
BEGIN
	
    START TRANSACTION;
    
    SELECT gradelevel_id INTO pOUT_gradelevel_mt_gradeLevel
    FROM gradelevel_mt WHERE grade_level = pIN_gradeLevel;

    UPDATE subject_gradelevel_lt
	SET subject_gradelevel_lt.gradelevel_id = pOUT_gradelevel_mt_gradeLevel
	WHERE subject_gradelevel_lt.gradelevel_id = pIN_gradeLevelId;
    
    UPDATE subject_mt
    SET code = pIN_subjCode, title = pIN_subjTitle, description = pIN_subjDescription
	WHERE subject_id = pIN_subjId;
    
    COMMIT;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSubjectDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSubjectDetails`(p_subjCode VARCHAR(50), p_subjName VARCHAR(100), p_subjUnits INT,p_subjDesc VARCHAR(150), p_subjId INT, p_subjGradeLevelId INT, p_subjSchoolYearId INT, p_editedByUserId INT)
BEGIN

DECLARE EXIT HANDLER FOR sqlexception
BEGIN
	ROLLBACK;
	RESIGNAL;
    SELECT 'encountered error.\n update failed.' AS msg;
END;

START TRANSACTION;

UPDATE subjects s 
	SET s.`code` 		= p_subjCode,
		s.`name` 		= p_subjName,
        s.units	 		= p_subjUnits,
        s.description 	= p_subjDesc
	WHERE s.id 			= p_subjId;
    
UPDATE subjects_gradelevel sgl
	SET sgl.gradeLevelId	=	p_subjGradeLevelId,
		sgl.schoolYearId	=	p_subjSchoolYearId
	WHERE sgl.subjectId		=	p_subjId;
    
UPDATE subjects_hd	shd
	SET	shd.editedBy_UserId	=	p_editedByUserId,
		shd.dateEdited		=	NOW()
	WHERE shd.subjectId	= p_subjId;


		COMMIT;
        SELECT 'successfully updated' AS result;
        


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSubjectIsAddedById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSubjectIsAddedById`(IN pIN_subjectId INT)
BEGIN
	
    UPDATE subject_mt SET isAdded = NULL
    WHERE subject_mt.subject_id = pIN_subjectId;
    
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

-- Dump completed on 2017-08-24 21:35:57
