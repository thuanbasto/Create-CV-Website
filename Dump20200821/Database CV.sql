CREATE DATABASE  IF NOT EXISTS `cv` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cv`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: cv
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `detailskill`
--

DROP TABLE IF EXISTS `detailskill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detailskill` (
  `DetailSkill_ID` int(10) NOT NULL AUTO_INCREMENT,
  `DetailSkill` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Skill_ID` int(10) DEFAULT NULL,
  PRIMARY KEY (`DetailSkill_ID`),
  KEY `detailskill_ibfk_1` (`Skill_ID`),
  CONSTRAINT `detailskill_ibfk_1` FOREIGN KEY (`Skill_ID`) REFERENCES `skill` (`Skill_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailskill`
--

LOCK TABLES `detailskill` WRITE;
/*!40000 ALTER TABLE `detailskill` DISABLE KEYS */;
INSERT INTO `detailskill` VALUES (113,'English',73),(114,'Japanese',73),(115,'Quét rác',74),(135,'Education University (2017-2021)',82),(136,'FPT',82),(137,'Thai Phien',82),(138,'Agoda',82),(139,'ABC',82),(140,'Java',83),(141,'HTML,CSS',83),(142,'Spring MVC',83),(143,'Music',84),(153,'abc',94),(154,'b',94),(155,'b',95),(156,'Su Pham',96),(157,'3',97),(158,'5',98);
/*!40000 ALTER TABLE `detailskill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likecv`
--

DROP TABLE IF EXISTS `likecv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likecv` (
  `like_ID` int(10) NOT NULL AUTO_INCREMENT,
  `from_user_ID` int(10) NOT NULL,
  `to_user_ID` int(10) NOT NULL,
  PRIMARY KEY (`like_ID`),
  KEY `from_user_ID` (`from_user_ID`),
  KEY `to_user_ID` (`to_user_ID`),
  CONSTRAINT `likecv_ibfk_1` FOREIGN KEY (`from_user_ID`) REFERENCES `user` (`user_ID`) ON DELETE CASCADE,
  CONSTRAINT `likecv_ibfk_2` FOREIGN KEY (`to_user_ID`) REFERENCES `user` (`user_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likecv`
--

LOCK TABLES `likecv` WRITE;
/*!40000 ALTER TABLE `likecv` DISABLE KEYS */;
INSERT INTO `likecv` VALUES (16,1,43),(21,1,1),(24,49,49),(25,49,1),(26,51,1),(27,51,51);
/*!40000 ALTER TABLE `likecv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill` (
  `Skill_ID` int(10) NOT NULL AUTO_INCREMENT,
  `SkillName` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TypeDisplay` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `IndexDisplay` int(2) DEFAULT NULL,
  `user_ID` int(10) DEFAULT NULL,
  PRIMARY KEY (`Skill_ID`),
  KEY `skill_FK_idx` (`user_ID`),
  CONSTRAINT `skill_FK` FOREIGN KEY (`user_ID`) REFERENCES `user` (`user_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (73,'Language','1',1,43),(74,'Exp','1',2,43),(82,'Education','1',1,1),(83,'Technical','2',2,1),(84,'Interests','1',2,1),(94,'Technical','1',1,49),(95,'Experience','2',2,49),(96,'School','1',2,49),(97,'12','1',2,49),(98,'4','1',2,49);
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typecv`
--

DROP TABLE IF EXISTS `typecv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typecv` (
  `typecv_ID` int(10) NOT NULL AUTO_INCREMENT,
  `typename` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `descr` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`typecv_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typecv`
--

LOCK TABLES `typecv` WRITE;
/*!40000 ALTER TABLE `typecv` DISABLE KEYS */;
INSERT INTO `typecv` VALUES (1,'Default 1','Default'),(2,'Default 2','Default');
/*!40000 ALTER TABLE `typecv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_ID` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `career` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `maxim` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `facebook` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `imageUrl` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `typecv_ID` int(10) DEFAULT NULL,
  PRIMARY KEY (`user_ID`),
  KEY `typecv_ID` (`typecv_ID`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`typecv_ID`) REFERENCES `typecv` (`typecv_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Trần Minh Thuận','Đà Nẵng','1999-06-12','0775461753','thuantran1269@gmail.com','Student','Learn as much as possible and do my best in order to complete my tasks.','fb.com/thuanbasto','thuan.jpg','thuan','$2a$10$IXVxYXUGOokDx.EUnAT5XuEinNfDT7Y6Vn5iiLi0en46J08leZRsm','ROLE_ADMIN',1,2),(40,'Thuận Đẹp Trai','20 Con Mèo','1999-06-12','0775461753','thuanhuhu@gmail.com','Professor','Learn.','fb.com/thuanbasto',NULL,'thuan1','$2a$10$lLFnqNLeYPwYOuWX3iC9oueP7BOFlVy41hStwTMTuO5nHphogiYXu','ROLE_USER',1,1),(43,'Nguyễn Tô Châu','723 Nguyễn Tất Thành','1999-05-01','0344199529','tochau2016@gmail.com','Student','Có làm thì mới có ăn.','fb.com/MeowMeow01051999','tochau113.jpg','tochau113','$2a$10$zHwJEqhEkkk0WQfbY1kCS.mTnnc2DlHMFJKRCYNJ3TaRq0ImtDSq.','ROLE_USER',1,1),(49,'Trần Văn Tèo','','1999-06-12','','teo@gmail.com','','','','thuan2.png','thuan2','$2a$10$gaqgg4de8P4tc1fWtTvV1.oLS9wWMBibtNFPrO6.YH.uSGjPoehuC','ROLE_USER',1,1),(51,'Trần Văn Tâm','','1999-06-12','','thuan4@gmail.com','','','','thuan4.png','thuan4','$2a$10$hJmcGpCfSKZDbUbxDOjKlu8wfGYaAwqFh74NQyuaq6taleYiV/qVG','ROLE_USER',1,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-09 23:30:58
