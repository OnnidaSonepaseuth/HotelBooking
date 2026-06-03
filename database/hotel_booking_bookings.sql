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
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `check_in` varchar(255) DEFAULT NULL,
  `check_out` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user` (`user_id`),
  KEY `fk_room` (`room_id`),
  CONSTRAINT `fk_room` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (1,2,1,'2026-06-03','2026-06-19','booked'),(22,17,2,'2026-06-12','2026-06-25','booked'),(41,2,1,'2026-06-03','2026-06-19','booked'),(42,3,2,'2026-06-05','2026-06-10','checked_in'),(43,4,3,'2026-06-06','2026-06-12','checked_out'),(44,5,4,'2026-06-08','2026-06-14','booked'),(45,6,5,'2026-06-09','2026-06-15','cancelled'),(46,7,6,'2026-06-10','2026-06-16','booked'),(47,8,7,'2026-06-11','2026-06-17','checked_in'),(48,9,8,'2026-06-12','2026-06-18','booked'),(49,10,9,'2026-06-13','2026-06-19','checked_out'),(50,11,10,'2026-06-14','2026-06-20','booked'),(51,12,11,'2026-06-15','2026-06-21','booked'),(52,13,12,'2026-06-16','2026-06-22','cancelled'),(53,14,13,'2026-06-17','2026-06-23','booked'),(54,15,14,'2026-06-18','2026-06-24','checked_in'),(55,2,1,'2026-06-19','2026-06-25','booked'),(56,3,2,'2026-06-20','2026-06-26','booked'),(57,4,3,'2026-06-21','2026-06-27','checked_out'),(58,5,4,'2026-06-22','2026-06-28','booked'),(59,6,5,'2026-06-23','2026-06-29','cancelled'),(60,7,6,'2026-06-24','2026-06-30','booked'),(61,2,1,'2026-06-03','2026-06-19','booked'),(62,3,2,'2026-06-05','2026-06-10','checked_in'),(63,4,3,'2026-06-06','2026-06-12','checked_out'),(64,5,4,'2026-06-08','2026-06-14','booked'),(65,6,5,'2026-06-09','2026-06-15','cancelled'),(66,7,6,'2026-06-10','2026-06-16','booked'),(67,8,7,'2026-06-11','2026-06-17','checked_in'),(68,9,8,'2026-06-12','2026-06-18','booked'),(69,10,9,'2026-06-13','2026-06-19','checked_out'),(70,11,10,'2026-06-14','2026-06-20','booked'),(71,12,11,'2026-06-15','2026-06-21','booked'),(72,13,12,'2026-06-16','2026-06-22','cancelled'),(73,14,13,'2026-06-17','2026-06-23','booked'),(74,15,14,'2026-06-18','2026-06-24','checked_in'),(75,2,1,'2026-06-19','2026-06-25','booked'),(76,3,2,'2026-06-20','2026-06-26','booked'),(77,4,3,'2026-06-21','2026-06-27','checked_out'),(78,5,4,'2026-06-22','2026-06-28','booked'),(79,6,5,'2026-06-23','2026-06-29','cancelled'),(80,7,6,'2026-06-24','2026-06-30','booked');
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
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
