-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hotel_booking
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_username` (`username`),
  UNIQUE KEY `uk_username` (`username`),
  UNIQUE KEY `uk_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'test','$2a$10$RVAQrpauDeyXtPhNh7GD7.s/kc3h6AO4FeOhUYUOb0p34CLK.yiy2','user','tset@gmail.com'),(3,'adminSuper','$2a$10$pAYbT3iGKqsw8Jd5KA5Tfei/JgTHar8SFsseUn2vHbm3SBcNoca0.','superadmin','admin@gmail.com'),(4,'admin1','$2a$10$SpAybT3GKqsw8Jd5KA5Tfei/JgTHar8SFsseUn2vHbm3SBcNoca0.','admin','admin1@gmail.com'),(5,'admin2','$2a$10$SpAybT3GKqsw8Jd5KA5Tfei/JgTHar8SFsseUn2vHbm3SBcNoca0.','admin','admin2@gmail.com'),(6,'admin3','$2a$10$SpAybT3GKqsw8Jd5KA5Tfei/JgTHar8SFsseUn2vHbm3SBcNoca0.','admin','admin3@gmail.com'),(7,'user1','$2a$10$SpAybT3GKqsw8Jd5KA5Tfei/JgTHar8SFsseUn2vHbm3SBcNoca0.','user','user1@gmail.com'),(8,'user2','$2a$10$SpAybT3GKqsw8Jd5KA5Tfei/JgTHar8SFsseUn2vHbm3SBcNoca0.','user','user2@gmail.com'),(9,'user3','$2a$10$SpAybT3GKqsw8Jd5KA5Tfei/JgTHar8SFsseUn2vHbm3SBcNoca0.','user','user3@gmail.com'),(10,'user4','$2a$10$SpAybT3GKqsw8Jd5KA5Tfei/JgTHar8SFsseUn2vHbm3SBcNoca0.','user','user4@gmail.com'),(11,'user5','$2a$10$SpAybT3GKqsw8Jd5KA5Tfei/JgTHar8SFsseUn2vHbm3SBcNoca0.','user','user5@gmail.com'),(12,'user6','$2a$10$SpAybT3GKqsw8Jd5KA5Tfei/JgTHar8SFsseUn2vHbm3SBcNoca0.','user','user6@gmail.com'),(13,'user7','$2a$10$SpAybT3GKqsw8Jd5KA5Tfei/JgTHar8SFsseUn2vHbm3SBcNoca0.','user','user7@gmail.com'),(14,'user8','$2a$10$SpAybT3GKqsw8Jd5KA5Tfei/JgTHar8SFsseUn2vHbm3SBcNoca0.','user','user8@gmail.com'),(15,'user9','$2a$10$SpAybT3GKqsw8Jd5KA5Tfei/JgTHar8SFsseUn2vHbm3SBcNoca0.','user','user9@gmail.com'),(16,'user10','$2a$10$SpAybT3GKqsw8Jd5KA5Tfei/JgTHar8SFsseUn2vHbm3SBcNoca0.','user','user10@gmail.com'),(17,'Xang','$2a$10$XehVE56Wi3pgoSlr2qNgSecIBM0quVEEl8pXTFEDOxCR04mKlPu9q','user','Xangkham@gmail.com'),(18,'Seuth','$2a$10$j1AEUMEqlOexttNLgMCu..0WfyclT9G5ulTDjG/BhtjC6qR5z150.','admin',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-03 14:05:27
