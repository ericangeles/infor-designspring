-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hnlmnl_db
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Table structure for table `tbl_soho_product`
--

DROP TABLE IF EXISTS `tbl_soho_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_soho_product` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(50) NOT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_soho_product`
--

LOCK TABLES `tbl_soho_product` WRITE;
/*!40000 ALTER TABLE `tbl_soho_product` DISABLE KEYS */;
INSERT INTO `tbl_soho_product` VALUES (1,'Infor CloudSuite Aerospace & Defense'),(2,'Infor CloudSuite Automotive'),(3,'Infor CloudSuite Business'),(4,'Infor CloudSuite Corporate'),(5,'Infor CloudSuite Distribution'),(6,'Infor CloudSuite Distribution Enterprise'),(7,'Infor CloudSuite Equipment Rental'),(8,'Infor CloudSuite Facilities Management'),(9,'Infor CloudSuite Fasion'),(10,'Infor CloudSuite Food & Beverage'),(11,'Infor CloudSuite HCM'),(12,'Infor CloudSuite Healthcare'),(13,'Infor CloudSuite Industrial'),(14,'Infor CloudSuite Industrial Machinery'),(15,'Infor CloudSuite Public Sector'),(16,'Infor SunSystems'),(17,'Infor Automotive Exchange'),(18,'Infor CloudSuite Business'),(19,'Infor CloudSuite Financials and Supply Management'),(20,'Infor CloudSuite Industrial'),(21,'Infor CRM'),(22,'Infor Distribution SX.e'),(23,'Infor EAM'),(24,'Infor Factory Track'),(25,'Infor Global Human Resources and Talent Management'),(26,'Infor HR Case Management'),(27,'Infor HR Knowledgebase'),(28,'Infor LN'),(29,'Infor M3'),(30,'Infor Onboarding'),(31,'Infor Public Sector'),(32,'Infor Supplier Exchange'),(33,'Infor BI'),(34,'Infor Business Analytics Manufacturing Foundation'),(35,'Infor d/EPM'),(36,'Infor Landmark Technology'),(37,'Infor M3 Analytics'),(38,'Infor Ming.le'),(39,'Infor Query & Analysis'),(40,'Infor Rhythm for Civics'),(41,'Infor Rhythm for Commerce: B2B'),(42,'Infor Risk & Compliance'),(43,'Infor Mobile Supply Chain Management');
/*!40000 ALTER TABLE `tbl_soho_product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-18 13:07:53
