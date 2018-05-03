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
-- Table structure for table `tbl_soho_icon_tag`
--

DROP TABLE IF EXISTS `tbl_soho_icon_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_soho_icon_tag` (
  `tagId` int(11) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(50) NOT NULL,
  `iconId` int(11) NOT NULL,
  PRIMARY KEY (`tagId`)
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_soho_icon_tag`
--

LOCK TABLES `tbl_soho_icon_tag` WRITE;
/*!40000 ALTER TABLE `tbl_soho_icon_tag` DISABLE KEYS */;
INSERT INTO `tbl_soho_icon_tag` VALUES (1,'add',1),(2,'attach',2),(3,'audio',3),(4,'calendar',4),(5,'bookmark-filled',5),(6,'bookmark-outlined',6),(7,'bottom-align',7),(8,'bullet-list',8),(9,'camera',9),(10,'cancel',10),(11,'caps-lock-indicator',11),(12,'cart',12),(13,'check',13),(14,'check-box',14),(15,'clock',15),(16,'close',16),(17,'collapse',17),(18,'collapse-context-app-tray',18),(19,'columns',19),(20,'compose',20),(21,'contract',21),(22,'copy',22),(23,'cut',23),(24,'distribute-horiz',24),(25,'document',25),(26,'down-arrow',26),(27,'download',27),(28,'drill-down',28),(29,'dropdown',29),(30,'duplicate',30),(31,'edit',31),(32,'expand',32),(33,'expand-context-app-tray',33),(34,'export',34),(35,'export-spreadsheet',35),(36,'filter',36),(37,'first-page',37),(38,'folder',38),(39,'fullview',39),(40,'grid',40),(41,'grid-layout',41),(42,'heart-filled',42),(43,'heart-outlined',43),(44,'home',44),(45,'horiz-center-align',45),(46,'import',46),(47,'insert-image',47),(48,'inventory',48),(49,'last-page',49),(50,'launch',50),(51,'left-align',51),(52,'left-arrow',52),(53,'link',53),(54,'list',54),(55,'load',55),(56,'locked',56),(57,'mail',57),(58,'map-pin',58),(59,'maximize',59),(60,'menu',60),(61,'mingle-share',61),(62,'minimize',62),(63,'minus',63),(64,'more',64),(65,'new-document',65),(66,'next-page',66),(67,'no-audio',67),(68,'notes',68),(69,'notification',69),(70,'number-list',70),(71,'open-folder',71),(72,'paste',72),(73,'previous-page',73),(74,'print',74),(75,'redo',75),(76,'refresh',76),(77,'reset',77),(78,'responsive-app-switcher',78),(79,'right-align',79),(80,'right-arrow',80),(81,'roles',81),(82,'save',82),(83,'search',83),(84,'search-category-filter',84),(85,'search-folder',85),(86,'search-list',86),(87,'secondary-menu-collapse-minus',87),(88,'secondary-menu-expand-plus',88),(89,'send',89),(90,'settings',90),(91,'sort-down',91),(92,'sort-up',92),(93,'star',93),(94,'star-half-filled',94),(95,'star-outlined',95),(96,'tack',96),(97,'timer',97),(98,'top-align',98),(99,'trash',99),(100,'undo',100),(101,'unlocked',101),(102,'up-arrow',102),(103,'upload',103),(104,'url',104),(105,'user',105),(106,'user-profile',106),(107,'vertical-middle-align',107),(108,'alert',108),(109,'confirmed',109),(110,'dirty',110),(111,'error',111),(112,'info',112),(113,'in-progress',113),(114,'new',114),(115,'contains',115),(116,'date-calendar',116),(117,'does-not-equal',117),(118,'doesnt-contain',118),(119,'either-selected-or-not-selected',119),(120,'equals',120),(121,'greater-or-equal-to',121),(122,'greater-than',122),(123,'in-between',123),(124,'is-empty',124),(125,'is-not-empty',125),(126,'less-or-equal-to',126),(127,'less-than',127),(128,'not-selected',128),(129,'selected',129),(130,'sort-a-to-z',130),(131,'sort-z-to-a',131),(132,'audio',132),(133,'avi',133),(134,'bmp',134),(135,'chart',135),(136,'closed-folder',136),(137,'csv',137),(138,'document',138),(139,'document-2',139),(140,'excel',140),(141,'expenses',141),(142,'gif',142),(143,'htm',143),(144,'image',144),(145,'jpg',145),(146,'link',146),(147,'mail',147),(148,'mp3',148),(149,'mpp',149),(150,'msg',150),(151,'open-folder',151),(152,'pdf',152),(153,'png',153),(154,'ppt',154),(155,'prj',155),(156,'psd',156),(157,'pub',157),(158,'rar',158),(159,'text',159),(160,'tif',160),(161,'video',161),(162,'vis',162),(163,'word',163),(164,'xls',164),(165,'xml',165),(166,'zip',166),(167,'infor-chat',167),(168,'mobile-asset',168),(169,'locally-cloud-services',169),(170,'customer-lifecycle',170),(171,'inspector',171),(172,'alert',172),(173,'confirmed',173),(174,'error',174),(175,'info',175),(176,'1',176),(177,'5',177),(178,'8',178),(179,'12',179),(180,'new',1),(181,'create',1);
/*!40000 ALTER TABLE `tbl_soho_icon_tag` ENABLE KEYS */;
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
