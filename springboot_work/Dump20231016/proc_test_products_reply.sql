-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proc_test
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `products_reply`
--

DROP TABLE IF EXISTS `products_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products_reply` (
  `idx_reply` int NOT NULL AUTO_INCREMENT,
  `ref_idx_reply` int DEFAULT NULL,
  `idx_products` int DEFAULT NULL,
  `ref_level` int DEFAULT NULL,
  `content` varchar(50) DEFAULT NULL,
  `path` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idx_reply`),
  KEY `FK_products_reply_products` (`idx_products`) USING BTREE,
  CONSTRAINT `FK_products_reply_products` FOREIGN KEY (`idx_products`) REFERENCES `products` (`idx`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_reply`
--

LOCK TABLES `products_reply` WRITE;
/*!40000 ALTER TABLE `products_reply` DISABLE KEYS */;
INSERT INTO `products_reply` VALUES (66,0,1,1,'파프리카',NULL),(67,0,1,1,'ㅇㅇ',NULL),(68,67,1,2,'ㅇㅇ',NULL),(69,68,1,3,'ㅇㅇ',NULL),(76,0,1,1,'헿',NULL),(80,NULL,NULL,NULL,NULL,'삭제됨 0'),(81,0,18,1,'오',NULL),(82,0,18,1,'아',NULL),(83,0,18,1,'이',NULL),(85,81,18,2,'ㄱㄱ',NULL),(86,85,18,3,'ㅎㅎ',NULL),(87,82,18,2,'ㅇㅋ',NULL),(88,87,18,3,'ㄴㄴ',NULL),(89,83,18,2,'ㄱ',NULL),(91,0,2,1,'10월12일 0940','입력성공'),(92,0,2,1,'웹에서 입력받아도 성공?','입력성공');
/*!40000 ALTER TABLE `products_reply` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-16 11:53:33
