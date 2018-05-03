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
-- Table structure for table `tbl_soho_icon`
--

DROP TABLE IF EXISTS `tbl_soho_icon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_soho_icon` (
  `iconId` int(11) NOT NULL AUTO_INCREMENT,
  `iconName` varchar(100) NOT NULL,
  `iconCounter` int(11) NOT NULL DEFAULT '0',
  `iconStatus` varchar(10) NOT NULL DEFAULT 'active',
  `typeId` int(11) NOT NULL,
  PRIMARY KEY (`iconId`)
) ENGINE=InnoDB AUTO_INCREMENT=180 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_soho_icon`
--

LOCK TABLES `tbl_soho_icon` WRITE;
/*!40000 ALTER TABLE `tbl_soho_icon` DISABLE KEYS */;
INSERT INTO `tbl_soho_icon` VALUES (1,'add',16,'active',7),(2,'attach',0,'active',7),(3,'audio',0,'active',7),(4,'calendar',0,'active',7),(5,'bookmark-filled',0,'active',7),(6,'bookmark-outlined',0,'active',7),(7,'bottom-align',0,'active',7),(8,'bullet-list',1,'active',7),(9,'camera',0,'active',7),(10,'cancel',0,'active',7),(11,'caps-lock-indicator',0,'active',7),(12,'cart',0,'active',7),(13,'check',1,'active',7),(14,'check-box',0,'active',7),(15,'clock',0,'active',7),(16,'close',0,'active',7),(17,'collapse',0,'active',7),(18,'collapse-context-app-tray',1,'active',7),(19,'columns',0,'active',7),(20,'compose',0,'active',7),(21,'contract',0,'active',7),(22,'copy',0,'active',7),(23,'cut',0,'active',7),(24,'distribute-horiz',0,'active',7),(25,'document',0,'active',7),(26,'down-arrow',0,'active',7),(27,'download',0,'active',7),(28,'drill-down',0,'active',7),(29,'dropdown',0,'active',7),(30,'duplicate',0,'active',7),(31,'edit',0,'active',7),(32,'expand',0,'active',7),(33,'expand-context-app-tray',0,'active',7),(34,'export',0,'active',7),(35,'export-spreadsheet',0,'active',7),(36,'filter',0,'active',7),(37,'first-page',0,'active',7),(38,'folder',0,'active',7),(39,'fullview',0,'active',7),(40,'grid',0,'active',7),(41,'grid-layout',0,'active',7),(42,'heart-filled',0,'active',7),(43,'heart-outlined',0,'active',7),(44,'home',0,'active',7),(45,'horiz-center-align',0,'active',7),(46,'import',0,'active',7),(47,'insert-image',0,'active',7),(48,'inventory',0,'active',7),(49,'last-page',0,'active',7),(50,'launch',0,'active',7),(51,'left-align',0,'active',7),(52,'left-arrow',0,'active',7),(53,'link',0,'active',7),(54,'list',0,'active',7),(55,'load',0,'active',7),(56,'locked',0,'active',7),(57,'mail',0,'active',7),(58,'map-pin',0,'active',7),(59,'maximize',0,'active',7),(60,'menu',0,'active',7),(61,'mingle-share',0,'active',7),(62,'minimize',0,'active',7),(63,'minus',0,'active',7),(64,'more',0,'active',7),(65,'new-document',0,'active',7),(66,'next-page',0,'active',7),(67,'no-audio',0,'active',7),(68,'notes',0,'active',7),(69,'notification',0,'active',7),(70,'number-list',0,'active',7),(71,'open-folder',0,'active',7),(72,'paste',0,'active',7),(73,'previous-page',0,'active',7),(74,'print',0,'active',7),(75,'redo',0,'active',7),(76,'refresh',0,'active',7),(77,'reset',0,'active',7),(78,'responsive-app-switcher',0,'active',7),(79,'right-align',0,'active',7),(80,'right-arrow',0,'active',7),(81,'roles',0,'active',7),(82,'save',0,'active',7),(83,'search',0,'active',7),(84,'search-category-filter',0,'active',7),(85,'search-folder',0,'active',7),(86,'search-list',0,'active',7),(87,'secondary-menu-collapse-minus',0,'active',7),(88,'secondary-menu-expand-plus',0,'active',7),(89,'send',0,'active',7),(90,'settings',0,'active',7),(91,'sort-down',0,'active',7),(92,'sort-up',0,'active',7),(93,'star',0,'active',7),(94,'star-half-filled',0,'active',7),(95,'star-outlined',0,'active',7),(96,'tack',0,'active',7),(97,'timer',0,'active',7),(98,'top-align',0,'active',7),(99,'trash',0,'active',7),(100,'undo',0,'active',7),(101,'unlocked',0,'active',7),(102,'up-arrow',0,'active',7),(103,'upload',0,'active',7),(104,'url',0,'active',7),(105,'user',0,'active',7),(106,'user-profile',0,'active',7),(107,'vertical-middle-align',0,'active',7),(108,'alert',1,'active',6),(109,'confirmed',0,'active',6),(110,'dirty',0,'active',6),(111,'error',0,'active',6),(112,'info',0,'active',6),(113,'in-progress',0,'active',6),(114,'new',0,'active',6),(115,'contains',0,'active',4),(116,'date-calendar',0,'active',4),(117,'does-not-equal',0,'active',4),(118,'doesnt-contain',0,'active',4),(119,'either-selected-or-not-selected',0,'active',4),(120,'equals',0,'active',4),(121,'greater-or-equal-to',0,'active',4),(122,'greater-than',0,'active',4),(123,'in-between',0,'active',4),(124,'is-empty',0,'active',4),(125,'is-not-empty',0,'active',4),(126,'less-or-equal-to',0,'active',4),(127,'less-than',0,'active',4),(128,'not-selected',0,'active',4),(129,'selected',0,'active',4),(130,'sort-a-to-z',0,'active',4),(131,'sort-z-to-a',0,'active',4),(132,'audio',0,'active',8),(133,'avi',0,'active',8),(134,'bmp',0,'active',8),(135,'chart',0,'active',8),(136,'closed-folder',0,'active',8),(137,'csv',0,'active',8),(138,'document',0,'active',8),(139,'document-2',0,'active',8),(140,'excel',0,'active',8),(141,'expenses',0,'active',8),(142,'gif',0,'active',8),(143,'htm',0,'active',8),(144,'image',0,'active',8),(145,'jpg',0,'active',8),(146,'link',0,'active',8),(147,'mail',0,'active',8),(148,'mp3',0,'active',8),(149,'mpp',0,'active',8),(150,'msg',0,'active',8),(151,'open-folder',0,'active',8),(152,'pdf',0,'active',8),(153,'png',0,'active',8),(154,'ppt',0,'active',8),(155,'prj',0,'active',8),(156,'psd',0,'active',8),(157,'pub',0,'active',8),(158,'rar',0,'active',8),(159,'text',0,'active',8),(160,'tif',0,'active',8),(161,'video',0,'active',8),(162,'vis',0,'active',8),(163,'word',0,'active',8),(164,'xls',0,'active',8),(165,'xml',0,'active',8),(166,'zip',0,'active',8),(167,'infor-chat',2,'active',5),(168,'mobile-asset',1,'active',2),(169,'locally-cloud-services',0,'active',5),(170,'customer-lifecycle',0,'active',2),(171,'inspector',0,'active',2),(172,'alert',0,'active',1),(173,'confirmed',0,'active',1),(174,'error',0,'active',1),(175,'info',0,'active',1),(176,'1',0,'active',3),(177,'5',0,'active',3),(178,'8',0,'active',3),(179,'12',0,'active',3);
/*!40000 ALTER TABLE `tbl_soho_icon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-18 13:07:54
