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
) ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailskill`
--

LOCK TABLES `detailskill` WRITE;
/*!40000 ALTER TABLE `detailskill` DISABLE KEYS */;
INSERT INTO `detailskill` VALUES (113,'English',73),(114,'Japanese',73),(115,'Quét rác',74),(159,'Rikkei',99),(187,'Danang University of Education (2017-2021)',110),(188,'Thai Phien (High School)',110),(189,'Anime website (Allows watching video on website)',111),(190,'CV website (Allows you to create CVs and view other people\'s CVs)',111),(191,'FPT Software (6/2018 - 8/2018)',112),(192,'Programming: Java, C++',113),(193,'Database: MySQL, NoSQL',113),(194,'Website: HTML, CSS, JS',113),(195,'Other: Spring Framework',113),(196,'Back end developer website with Java.',114),(197,'Improve teamwork skills.',114),(198,'Improve language skills.',114),(199,'Create more website/apps from simple to complex.',114),(200,'English (Limited working proficiency)',115),(201,'Japanese (Limited working proficiency)',115),(202,'Listen to music.',116),(203,'Basketball.',116),(204,'Skateboard.',116);
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likecv`
--

LOCK TABLES `likecv` WRITE;
/*!40000 ALTER TABLE `likecv` DISABLE KEYS */;
INSERT INTO `likecv` VALUES (16,1,43),(21,1,1),(26,51,1),(27,51,51),(28,54,1),(29,40,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (73,'Language','1',1,43),(74,'Exp','1',2,43),(99,'Company','1',1,52),(110,'Education','1',1,1),(111,'Personal projects','1',1,1),(112,'Work experience','1',1,1),(113,'Technical Skill','2',2,1),(114,'Objective','1',2,1),(115,'Languages','1',2,1),(116,'Interests','2',2,1);
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
  `state` tinyint(1) DEFAULT NULL,
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `typecv_ID` int(10) DEFAULT NULL,
  PRIMARY KEY (`user_ID`),
  KEY `typecv_ID` (`typecv_ID`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`typecv_ID`) REFERENCES `typecv` (`typecv_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Trần Minh Thuận','Đà Nẵng','1999-06-12','0775461753','thuantran1269@gmail.com','Student','Learn as much as possible and do my best in order to complete my tasks.','fb.com/thuanbasto','thuan.jpg',1,'thuan','$2a$10$IXVxYXUGOokDx.EUnAT5XuEinNfDT7Y6Vn5iiLi0en46J08leZRsm','ROLE_ADMIN',1,1),(40,'Trần Minh Thắng','Đà Nẵng','1999-06-12','123','thuanhuhu@gmail.com','Information technology','Learn ABC.','fb.com/thuanbasto','thuan1.png',1,'thuan1','$2a$10$3dSQEEj2GVKkhlsIfkgu1OUzER9njwpO9IAYWc2nhadl35pRSd5wK','ROLE_USER',1,1),(43,'Nguyễn Tô Châu','Đà Nẵng','1999-05-01','0344199529','tochau2016@gmail.com','Student','Có làm thì mới có ăn.','fb.com/MeowMeow01051999','tochau113.jpg',0,'tochau113','$2a$10$zHwJEqhEkkk0WQfbY1kCS.mTnnc2DlHMFJKRCYNJ3TaRq0ImtDSq.','ROLE_USER',1,1),(51,'Trần Văn Tâm','Đà Nẵng','1999-06-12','','thuan4@gmail.com','','','','thuan4.png',0,'thuan4','$2a$10$hJmcGpCfSKZDbUbxDOjKlu8wfGYaAwqFh74NQyuaq6taleYiV/qVG','ROLE_USER',1,1),(52,'Loi','Hồ Chí Minh','1999-12-12','','aa@gmail.com','','','','',0,'loi123','$2a$10$Bh0Ai4OgRsNd6YYTDGQ/uuGeY/XZrap0D48f3c0QnpAYSuFJAcZCW','ROLE_USER',1,1),(53,'Nguyễn Anh Tú','Hồ Chí Minh','2010-01-01','','aa@gmail.com','Information technology','','','',0,'anhtuu','$2a$10$6nt4R6NdpmxPO4nvym/WOuqV3pT0YNjLnpe0MTZnzFXry29lxVYLO','ROLE_USER',1,1),(54,'Phạm Công Thành','Hồ Chí Minh','1999-01-01','','aa@gmail.com','Master chef','','','',0,'congthanh','$2a$10$.EMI8ZS9/0NpvzwlKCZmlOt5NnB6zPJwQ31TzsncBpsghaCcjFRtS','ROLE_USER',1,1),(55,'Trần Hà Nam','','1999-01-01','','Nam@gmail.com','','','','',0,'nam123','$2a$10$LL/cRZAxm1I03LotqLVAM.77ERAIdZv52818bMGzHvL1zrja0GA3S','ROLE_USER',1,1),(59,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'thuan123','$2a$10$NsgcCsPUAs7NF/0MtgLOquB2dHoqaA/4/DC3fxUrsSUxZFENOoyAG','ROLE_USER',1,1),(60,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'thuan1234','$2a$10$hze1aTPBNuPx2dgt5y0hwOErQqgzK8Q6QB50DJsFTdHKr8A0N6CX6','ROLE_USER',1,1),(61,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'thuan12345','$2a$10$.4TJSjaFIsYSIXrqMrGv3e2kr0uxUFfbSot68iug7/DMDPlNMhSj6','ROLE_USER',1,1);
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

-- Dump completed on 2020-12-27 12:02:27
