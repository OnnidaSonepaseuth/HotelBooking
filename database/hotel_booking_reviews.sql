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
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) DEFAULT NULL,
  `review_text` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (3,'donny','air yen laiy',5,'2026-05-30 08:24:53'),(4,'xang','dd',4,'2026-06-02 02:56:57'),(5,'John','Very good hotel',5,'2026-06-02 05:02:33'),(6,'Alice','Nice room and clean',4,'2026-06-02 05:02:33'),(7,'Tom','Good service',5,'2026-06-02 05:02:33'),(8,'Jerry','Location is excellent',4,'2026-06-02 05:02:33'),(9,'Rose','Friendly staff',5,'2026-06-02 05:02:33'),(10,'Anna','Room was comfortable',4,'2026-06-02 05:02:33'),(11,'Mike','Breakfast was great',5,'2026-06-02 05:02:33'),(12,'Sara','Worth the price',4,'2026-06-02 05:02:33'),(13,'David','Will come again',5,'2026-06-02 05:02:33'),(14,'Lucy','Amazing experience',5,'2026-06-02 05:02:33'),(15,'John Smith','Excellent hotel and friendly staff.',5,'2026-06-03 06:15:30'),(16,'David Lee','Clean room and good location.',4,'2026-06-03 06:15:30'),(17,'Sarah Wilson','Amazing experience, highly recommended.',5,'2026-06-03 06:15:30'),(18,'Michael Brown','Good service and comfortable room.',4,'2026-06-03 06:15:30'),(19,'Emily Davis','Nice hotel but breakfast could be better.',3,'2026-06-03 06:15:30'),(20,'Daniel White','Very clean and modern rooms.',5,'2026-06-03 06:15:30'),(21,'Jessica Miller','Helpful staff and easy booking process.',4,'2026-06-03 06:15:30'),(22,'Robert Taylor','Great value for money.',4,'2026-06-03 06:15:30'),(23,'Lisa Anderson','Wonderful stay with family.',5,'2026-06-03 06:15:30'),(24,'Kevin Thomas','Everything was perfect.',5,'2026-06-03 06:15:30');
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
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
