-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: phmavwhnl    Database: hnlmnl-prd_db
-- ------------------------------------------------------
-- Server version	5.7.19

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
-- Table structure for table `tbl_soho_icon_download`
--

DROP TABLE IF EXISTS `tbl_soho_icon_download`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_soho_icon_download` (
  `downloadId` int(11) NOT NULL AUTO_INCREMENT,
  `downloadDateTime` varchar(50) NOT NULL,
  `emailAddress` varchar(50) NOT NULL,
  `productId` int(11) NOT NULL,
  `iconId` int(11) NOT NULL,
  PRIMARY KEY (`downloadId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_soho_icon_download`
--

LOCK TABLES `tbl_soho_icon_download` WRITE;
/*!40000 ALTER TABLE `tbl_soho_icon_download` DISABLE KEYS */;
INSERT INTO `tbl_soho_icon_download` VALUES (1,'20170703152251','JamesAllen.Tadique@infor.com',33,8),(2,'20170703152815','Larry.Amisola@infor.com',12,1),(3,'20170704132544','JamesAllen.Tadique@infor.com',43,13),(4,'20170719123836','JamesAllen.Tadique@infor.com',33,1),(5,'20170719124012','JamesAllen.Tadique@infor.com',34,1),(6,'20170719124044','JamesAllen.Tadique@infor.com',9,1),(7,'20170719124112','JamesAllen.Tadique@infor.com',39,1),(8,'20170719124216','JamesAllen.Tadique@infor.com',40,1),(9,'20170719124247','JamesAllen.Tadique@infor.com',16,1),(10,'20170808112331','Larry.Amisola@infor.com',17,18),(11,'20170810101700','JamesAllen.Tadique@infor.com',17,1),(12,'20170810101802','JamesAllen.Tadique@infor.com',17,1),(13,'20170810102044','JamesAllen.Tadique@infor.com',2,1),(14,'20170810111518','JamesAllen.Tadique@infor.com',9,1),(15,'20170816104344','JamesAllen.Tadique@infor.com',17,1),(16,'20170816104445','JamesAllen.Tadique@infor.com',1,1),(17,'20170816132858','JamesAllen.Tadique@infor.com',2,1),(18,'20170816133123','Larry.Amisola@infor.com',6,108),(19,'20170816152020','JamesAllen.Tadique@infor.com',5,1),(20,'20170816152151','Larry.Amisola@infor.com',19,167),(21,'20170816152456','Larry.Amisola@infor.com',39,168),(22,'20170817075434','JamesAllen.Tadique@infor.com',1,167),(23,'20170822104111','JamesAllen.Tadique@infor.com',4,1);
/*!40000 ALTER TABLE `tbl_soho_icon_download` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-19  7:59:34
