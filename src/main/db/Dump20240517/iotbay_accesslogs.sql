-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: iotbay
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `accesslogs`
--

DROP TABLE IF EXISTS `accesslogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accesslogs` (
  `user_id` int NOT NULL,
  `date_accessed` timestamp NOT NULL,
  `activity_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`date_accessed`),
  CONSTRAINT `advertisers_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accesslogs`
--

LOCK TABLES `accesslogs` WRITE;
/*!40000 ALTER TABLE `accesslogs` DISABLE KEYS */;
INSERT INTO `accesslogs` VALUES (1,'2024-05-01 09:30:08','Successful Login'),(1,'2024-05-01 09:40:57','Failed Login'),(1,'2024-05-01 09:41:29','Failed Login'),(1,'2024-05-01 10:19:41','Successful Login'),(1,'2024-05-01 10:21:50','Successful Login'),(1,'2024-05-01 10:22:04','Successful Login'),(1,'2024-05-01 10:22:16','Successful Login'),(1,'2024-05-01 10:23:20','Successful Login'),(1,'2024-05-01 10:24:33','Failed Login'),(1,'2024-05-01 10:24:38','Successful Login'),(1,'2024-05-01 10:27:21','Successful Login'),(1,'2024-05-01 10:33:34','Successful Login'),(1,'2024-05-01 10:34:07','Successful Login'),(1,'2024-05-01 10:34:13','Successful Login'),(1,'2024-05-01 10:41:48','Successful Login'),(1,'2024-05-01 10:43:47','Successful Login'),(1,'2024-05-08 07:19:45','Failed Login'),(1,'2024-05-08 07:19:57','Successful Login'),(1,'2024-05-08 10:23:56','Successful Login'),(1,'2024-05-08 10:26:44','Successful Login'),(1,'2024-05-08 10:30:06','Successful Login'),(1,'2024-05-08 10:31:03','Successful Login'),(1,'2024-05-08 10:35:28','Successful Login'),(1,'2024-05-08 10:37:58','Successful Login'),(1,'2024-05-08 10:42:00','Failed Login'),(1,'2024-05-08 10:42:05','Successful Login'),(1,'2024-05-08 10:43:19','Successful Login'),(1,'2024-05-08 10:50:02','Successful Login'),(1,'2024-05-08 11:12:16','Successful Login'),(1,'2024-05-08 11:18:00','Successful Login'),(1,'2024-05-08 11:20:17','Successful Login'),(1,'2024-05-08 11:20:29','Successful Login'),(1,'2024-05-08 11:20:45','Successful Login'),(1,'2024-05-08 11:27:09','Successful Login'),(1,'2024-05-08 11:27:38','Successful Login'),(1,'2024-05-08 11:28:28','Successful Login'),(1,'2024-05-08 11:34:04','Successful Login'),(1,'2024-05-08 11:35:07','Successful Login'),(1,'2024-05-08 11:36:57','Successful Login'),(1,'2024-05-08 11:41:20','Successful Login'),(1,'2024-05-08 11:46:57','Successful Login'),(1,'2024-05-08 11:47:10','Successful Login'),(1,'2024-05-08 11:51:17','Successful Login'),(1,'2024-05-08 12:04:01','Successful Login'),(1,'2024-05-08 12:04:35','Successful Login'),(1,'2024-05-08 12:06:19','Successful Login'),(1,'2024-05-08 12:10:41','Successful Login'),(1,'2024-05-08 12:13:23','Successful Login'),(1,'2024-05-08 12:14:04','Successful Login'),(1,'2024-05-08 12:28:16','Failed Login'),(1,'2024-05-08 13:31:44','Successful Login'),(1,'2024-05-08 13:34:06','Successful Login'),(1,'2024-05-08 13:36:13','Failed Login'),(1,'2024-05-08 13:36:19','Successful Login'),(1,'2024-05-08 13:36:55','Successful Login'),(1,'2024-05-08 13:37:34','Successful Login'),(1,'2024-05-08 13:47:17','Successful Login'),(1,'2024-05-08 13:49:57','Successful Login'),(1,'2024-05-08 13:50:06','Failed Login'),(1,'2024-05-08 13:50:11','Successful Login'),(1,'2024-05-09 18:22:47','Successful Login'),(1,'2024-05-09 18:26:03','Successful Login'),(1,'2024-05-09 18:27:18','Successful Login'),(1,'2024-05-09 18:27:19','Successful Logout'),(1,'2024-05-09 19:07:37','Successful Login'),(1,'2024-05-09 19:16:46','Successful Login'),(1,'2024-05-10 06:44:20','Successful Login'),(1,'2024-05-10 06:45:41','Successful Login'),(1,'2024-05-10 06:46:29','Successful Logout'),(1,'2024-05-10 06:48:33','Successful Login'),(1,'2024-05-10 06:50:03','Failed Login'),(1,'2024-05-10 06:50:08','Successful Login'),(1,'2024-05-10 13:56:07','Successful Login'),(1,'2024-05-10 14:18:37','Successful Login'),(1,'2024-05-10 14:20:03','Successful Login'),(1,'2024-05-10 14:27:33','Successful Login'),(1,'2024-05-10 14:28:50','Successful Login'),(1,'2024-05-10 14:29:50','Successful Login'),(1,'2024-05-10 14:32:20','Successful Login'),(1,'2024-05-10 14:35:47','Successful Login'),(1,'2024-05-10 14:46:56','Successful Login'),(1,'2024-05-10 14:48:14','Successful Login'),(1,'2024-05-10 14:48:51','Successful Logout'),(1,'2024-05-10 15:24:12','Successful Login'),(1,'2024-05-10 15:29:50','Successful Login'),(1,'2024-05-10 15:40:46','Successful Login'),(1,'2024-05-10 15:43:13','Successful Login'),(1,'2024-05-10 15:48:30','Successful Login'),(1,'2024-05-10 15:50:47','Successful Login'),(1,'2024-05-10 15:53:25','Successful Login'),(1,'2024-05-10 16:15:57','Successful Login'),(1,'2024-05-10 16:19:04','Successful Login'),(1,'2024-05-10 16:20:39','Successful Login'),(1,'2024-05-10 16:23:19','Successful Login'),(1,'2024-05-10 16:35:11','Successful Login'),(1,'2024-05-10 16:38:01','Successful Login'),(1,'2024-05-10 16:42:39','Successful Login'),(1,'2024-05-10 16:48:37','Successful Login'),(1,'2024-05-10 16:50:43','Successful Login'),(1,'2024-05-11 00:00:17','Successful Login'),(1,'2024-05-11 00:13:58','Successful Login'),(1,'2024-05-11 00:32:47','Successful Login'),(1,'2024-05-11 00:40:04','Successful Login'),(1,'2024-05-11 00:46:46','Successful Login'),(1,'2024-05-11 00:54:05','Successful Login'),(1,'2024-05-11 00:56:55','Failed Login'),(1,'2024-05-11 00:56:59','Successful Login'),(1,'2024-05-11 00:57:06','Successful Login'),(1,'2024-05-11 09:51:37','Successful Login'),(1,'2024-05-11 09:55:09','Failed Login'),(1,'2024-05-11 09:55:13','Successful Login'),(1,'2024-05-11 09:56:03','Successful Login'),(1,'2024-05-11 10:28:40','Successful Login'),(1,'2024-05-11 10:30:12','Successful Login'),(1,'2024-05-11 11:14:48','Successful Login'),(1,'2024-05-11 11:17:00','Successful Login'),(1,'2024-05-11 11:19:05','Successful Login'),(1,'2024-05-11 12:11:06','Successful Login'),(1,'2024-05-11 12:11:34','Successful Logout'),(1,'2024-05-11 14:46:40','Successful Login'),(1,'2024-05-11 14:48:48','Successful Login'),(1,'2024-05-11 16:13:38','Successful Login'),(1,'2024-05-11 16:14:18','Successful Login'),(1,'2024-05-11 16:22:21','Successful Login'),(1,'2024-05-11 16:25:01','Successful Login'),(1,'2024-05-11 16:28:02','Successful Login'),(1,'2024-05-11 16:35:14','Successful Login'),(1,'2024-05-11 16:37:37','Successful Login'),(1,'2024-05-12 01:47:16','Successful Login'),(1,'2024-05-12 01:54:46','Successful Login'),(1,'2024-05-12 01:55:48','Successful Login'),(1,'2024-05-12 02:00:21','Successful Login'),(1,'2024-05-12 02:05:06','Successful Login'),(1,'2024-05-12 02:06:33','Successful Login'),(1,'2024-05-12 02:14:10','Successful Login'),(1,'2024-05-12 02:16:00','Successful Login'),(1,'2024-05-12 02:16:51','Successful Login'),(1,'2024-05-12 02:39:03','Successful Login'),(1,'2024-05-12 02:42:20','Successful Login'),(1,'2024-05-12 02:59:21','Successful Login'),(1,'2024-05-12 03:01:38','Successful Login'),(1,'2024-05-12 03:03:59','Successful Login'),(1,'2024-05-12 03:07:11','Successful Login'),(1,'2024-05-12 03:20:29','Successful Login'),(1,'2024-05-12 03:22:57','Successful Login'),(1,'2024-05-12 03:25:29','Successful Login'),(1,'2024-05-12 03:26:39','Successful Login'),(1,'2024-05-12 03:29:31','Successful Login'),(1,'2024-05-12 03:30:49','Successful Login'),(1,'2024-05-12 03:43:53','Successful Login'),(1,'2024-05-12 03:45:11','Successful Login'),(1,'2024-05-12 03:47:54','Successful Login'),(1,'2024-05-12 03:53:34','Successful Login'),(1,'2024-05-12 03:55:00','Successful Login'),(1,'2024-05-12 04:34:43','Successful Login'),(1,'2024-05-12 04:35:54','Successful Login'),(1,'2024-05-12 04:36:46','Successful Login'),(1,'2024-05-12 04:38:21','Successful Login'),(1,'2024-05-12 04:41:25','Successful Login'),(1,'2024-05-12 04:55:36','Successful Login'),(1,'2024-05-12 04:56:48','Successful Login'),(1,'2024-05-12 04:57:42','Successful Login'),(1,'2024-05-12 04:58:26','Successful Logout'),(1,'2024-05-12 05:10:11','Failed Login'),(1,'2024-05-12 05:10:25','Successful Login'),(1,'2024-05-12 06:23:14','Successful Login'),(1,'2024-05-12 06:26:31','Successful Login'),(1,'2024-05-12 06:36:26','Successful Login'),(1,'2024-05-12 06:39:09','Successful Login'),(1,'2024-05-12 06:43:52','Successful Login'),(1,'2024-05-12 06:46:12','Successful Login'),(1,'2024-05-12 06:56:17','Successful Login'),(1,'2024-05-12 06:57:23','Successful Login'),(1,'2024-05-12 07:01:38','Successful Login'),(1,'2024-05-12 07:04:40','Successful Login'),(1,'2024-05-12 07:07:44','Successful Login'),(1,'2024-05-12 07:13:21','Successful Login'),(1,'2024-05-12 07:16:24','Successful Login'),(1,'2024-05-12 09:54:51','Successful Login'),(1,'2024-05-12 10:29:58','Successful Login'),(1,'2024-05-12 10:31:06','Successful Login'),(1,'2024-05-13 08:51:35','Successful Login'),(1,'2024-05-13 08:51:38','Successful Logout'),(1,'2024-05-13 08:51:45','Failed Login'),(1,'2024-05-13 08:51:51','Successful Login'),(1,'2024-05-13 09:00:26','Successful Login'),(1,'2024-05-13 09:09:08','Successful Login'),(1,'2024-05-13 09:16:54','Successful Login'),(1,'2024-05-13 09:22:01','Successful Login'),(1,'2024-05-13 09:22:55','Successful Login'),(1,'2024-05-13 09:27:15','Successful Login'),(1,'2024-05-13 10:00:10','Successful Login'),(1,'2024-05-13 10:05:18','Successful Login'),(1,'2024-05-13 10:07:46','Successful Login'),(1,'2024-05-13 10:14:02','Successful Logout'),(1,'2024-05-13 10:14:09','Successful Login'),(1,'2024-05-13 10:16:59','Successful Login'),(1,'2024-05-13 10:21:26','Successful Login'),(1,'2024-05-13 10:23:27','Successful Login'),(1,'2024-05-13 10:24:49','Successful Login'),(1,'2024-05-13 10:27:31','Successful Login'),(1,'2024-05-13 10:33:48','Successful Login'),(1,'2024-05-13 10:35:17','Successful Logout'),(1,'2024-05-13 10:35:23','Successful Login'),(1,'2024-05-13 10:43:24','Successful Login'),(1,'2024-05-13 10:44:46','Successful Login'),(1,'2024-05-13 10:49:11','Successful Login'),(1,'2024-05-13 10:53:43','Successful Login'),(1,'2024-05-13 13:43:15','Successful Login'),(1,'2024-05-13 13:50:57','Successful Login'),(1,'2024-05-13 13:55:41','Successful Login'),(1,'2024-05-13 13:55:51','Successful Logout'),(1,'2024-05-13 14:01:03','Successful Login'),(1,'2024-05-13 14:04:46','Successful Login'),(1,'2024-05-13 14:10:04','Successful Login'),(1,'2024-05-13 14:10:42','Successful Logout'),(1,'2024-05-14 00:52:10','Successful Login'),(1,'2024-05-14 01:00:54','Successful Login'),(1,'2024-05-14 01:02:37','Successful Login'),(1,'2024-05-14 01:02:40','Successful Logout'),(1,'2024-05-14 01:02:45','Successful Login'),(1,'2024-05-14 01:02:49','Successful Logout'),(1,'2024-05-14 01:02:58','Successful Login'),(1,'2024-05-14 01:04:36','Successful Login'),(1,'2024-05-14 01:32:16','Successful Login'),(1,'2024-05-14 04:01:00','Successful Login'),(1,'2024-05-14 04:06:39','Successful Login'),(1,'2024-05-14 05:50:25','Successful Login'),(1,'2024-05-14 06:12:16','Successful Login'),(1,'2024-05-14 09:09:31','Successful Login'),(1,'2024-05-14 09:53:07','Successful Login'),(1,'2024-05-14 09:59:42','Successful Login'),(1,'2024-05-14 09:59:43','Successful Logout'),(1,'2024-05-14 09:59:58','Successful Login'),(1,'2024-05-14 10:01:08','Successful Logout'),(1,'2024-05-14 10:06:09','Successful Login'),(1,'2024-05-14 10:06:12','Successful Logout'),(1,'2024-05-14 10:55:11','Successful Logout'),(1,'2024-05-14 10:55:51','Successful Logout'),(1,'2024-05-14 10:58:40','Successful Logout'),(1,'2024-05-14 11:06:08','Successful Login'),(1,'2024-05-14 11:06:29','Successful Login'),(1,'2024-05-14 11:12:15','Successful Login'),(1,'2024-05-14 11:13:59','Successful Login'),(1,'2024-05-14 11:14:07','Successful Logout'),(1,'2024-05-14 11:14:35','Successful Login'),(1,'2024-05-14 11:16:16','Successful Login'),(1,'2024-05-14 11:23:21','Successful Login'),(1,'2024-05-14 11:25:25','Successful Login'),(1,'2024-05-14 11:27:40','Failed Login'),(1,'2024-05-14 11:27:45','Successful Login'),(1,'2024-05-14 11:36:13','Failed Login'),(1,'2024-05-14 11:36:17','Successful Login'),(1,'2024-05-14 11:37:55','Successful Login'),(1,'2024-05-14 11:38:06','Successful Logout'),(1,'2024-05-14 11:39:12','Successful Login'),(1,'2024-05-14 11:41:44','Successful Login'),(1,'2024-05-14 11:43:28','Successful Logout'),(1,'2024-05-14 11:48:28','Successful Login'),(1,'2024-05-14 12:20:47','Successful Login'),(1,'2024-05-14 12:30:10','Successful Login'),(1,'2024-05-14 12:32:25','Successful Login'),(1,'2024-05-14 12:33:56','Successful Login'),(1,'2024-05-14 12:36:26','Successful Login'),(1,'2024-05-14 12:38:35','Successful Login'),(1,'2024-05-14 12:38:37','Successful Logout'),(1,'2024-05-14 12:38:41','Successful Login'),(1,'2024-05-14 12:38:52','Successful Logout'),(1,'2024-05-14 12:42:30','Successful Login'),(1,'2024-05-14 12:42:34','Successful Logout'),(1,'2024-05-14 12:43:07','Failed Login'),(1,'2024-05-14 12:43:13','Successful Login'),(1,'2024-05-14 12:43:58','Successful Logout'),(1,'2024-05-14 12:45:39','Successful Login'),(1,'2024-05-14 12:46:06','Successful Login'),(2,'2024-05-12 04:32:27','Successful Login'),(2,'2024-05-12 04:32:45','Successful Logout'),(2,'2024-05-12 04:58:39','Successful Login'),(2,'2024-05-12 04:59:52','Successful Logout'),(2,'2024-05-12 06:12:47','Successful Login'),(2,'2024-05-12 06:13:43','Successful Login'),(2,'2024-05-12 06:14:00','Successful Login'),(2,'2024-05-12 06:14:24','Successful Login'),(2,'2024-05-12 06:15:29','Successful Login'),(2,'2024-05-12 06:16:57','Successful Logout'),(5,'2024-05-01 09:42:42','Account Created'),(5,'2024-05-01 09:42:50','Successful Login'),(5,'2024-05-01 10:17:47','Failed Login'),(5,'2024-05-01 10:17:53','Successful Login'),(5,'2024-05-10 14:49:05','Successful Login'),(5,'2024-05-10 16:29:42','Successful Login'),(5,'2024-05-10 16:38:45','Failed Login'),(5,'2024-05-10 16:38:52','Successful Login'),(5,'2024-05-10 16:42:25','Successful Logout'),(5,'2024-05-10 16:47:35','Successful Login'),(5,'2024-05-10 16:47:51','Successful Logout'),(5,'2024-05-10 16:47:58','Failed Login'),(5,'2024-05-10 16:48:04','Successful Login'),(5,'2024-05-10 16:48:31','Successful Logout'),(5,'2024-05-11 00:09:16','Successful Login'),(5,'2024-05-11 00:10:46','Successful Login'),(5,'2024-05-11 00:13:31','Successful Login'),(5,'2024-05-11 00:17:03','Successful Login'),(5,'2024-05-11 00:41:17','Failed Login'),(5,'2024-05-11 00:41:24','Failed Login'),(5,'2024-05-11 00:41:28','Successful Login'),(5,'2024-05-11 00:42:24','Successful Login'),(5,'2024-05-11 00:42:46','Successful Login'),(5,'2024-05-11 00:43:18','Successful Login'),(5,'2024-05-11 00:43:42','Successful Login'),(5,'2024-05-11 00:48:40','Successful Login'),(5,'2024-05-11 00:58:15','Successful Login'),(5,'2024-05-11 00:58:40','Successful Login'),(5,'2024-05-11 10:31:05','Successful Login'),(5,'2024-05-11 10:34:28','Failed Login'),(5,'2024-05-11 10:34:38','Successful Login'),(5,'2024-05-12 03:01:14','Successful Login'),(5,'2024-05-12 03:01:31','Successful Logout'),(5,'2024-05-12 04:29:44','Failed Login'),(5,'2024-05-12 04:29:53','Failed Login'),(5,'2024-05-12 04:29:57','Successful Login'),(5,'2024-05-12 06:26:25','Failed Login'),(6,'2024-05-01 10:46:43','Account Created'),(6,'2024-05-01 10:46:54','Successful Login'),(40,'2024-05-15 05:40:11','Account Created'),(40,'2024-05-15 05:40:16','Successful Login'),(40,'2024-05-15 05:40:22','Successful Logout'),(40,'2024-05-15 05:40:49','Successful Login'),(40,'2024-05-15 05:41:52','Successful Logout'),(40,'2024-05-15 06:09:03','Successful Login'),(40,'2024-05-15 06:18:36','Successful Login'),(40,'2024-05-15 06:29:58','Successful Login'),(40,'2024-05-15 06:37:21','Successful Login'),(40,'2024-05-15 06:43:24','Successful Login'),(40,'2024-05-15 06:46:05','Successful Login'),(40,'2024-05-15 06:48:05','Successful Login'),(40,'2024-05-15 07:09:52','Successful Login'),(40,'2024-05-15 07:12:34','Successful Login'),(40,'2024-05-15 07:18:47','Successful Login'),(40,'2024-05-15 07:19:11','Successful Logout'),(40,'2024-05-15 07:19:57','Successful Login'),(40,'2024-05-15 07:36:02','Successful Login'),(40,'2024-05-15 07:43:04','Successful Login'),(40,'2024-05-15 07:56:23','Successful Login'),(40,'2024-05-15 09:08:49','Successful Login'),(40,'2024-05-15 23:52:02','Successful Login'),(40,'2024-05-16 13:34:49','Successful Login'),(40,'2024-05-16 13:36:09','Successful Logout'),(40,'2024-05-16 13:44:37','Successful Login'),(40,'2024-05-16 13:54:23','Successful Login'),(40,'2024-05-16 14:00:02','Successful Login'),(40,'2024-05-16 14:26:33','Successful Login'),(40,'2024-05-16 14:30:34','Successful Login'),(40,'2024-05-16 14:45:26','Successful Login'),(40,'2024-05-16 14:47:44','Successful Logout'),(40,'2024-05-16 15:07:16','Successful Login'),(40,'2024-05-16 15:14:45','Successful Login'),(40,'2024-05-16 15:18:48','Successful Login'),(40,'2024-05-16 15:39:19','Successful Login'),(40,'2024-05-16 15:45:06','Successful Login'),(40,'2024-05-17 08:53:31','Successful Login'),(40,'2024-05-17 08:58:35','Failed Login'),(40,'2024-05-17 09:02:14','Successful Login'),(40,'2024-05-17 09:04:12','Successful Login'),(40,'2024-05-17 09:05:32','Successful Login'),(40,'2024-05-17 09:08:12','Successful Login'),(40,'2024-05-17 09:11:18','Successful Login'),(40,'2024-05-17 09:24:01','Successful Login'),(40,'2024-05-17 09:39:30','Successful Login'),(40,'2024-05-17 09:41:06','Successful Login'),(40,'2024-05-17 09:42:08','Successful Login'),(40,'2024-05-17 11:05:27','Successful Login'),(40,'2024-05-17 11:06:52','Successful Login'),(40,'2024-05-17 11:43:22','Successful Logout'),(40,'2024-05-17 11:43:56','Successful Login'),(40,'2024-05-17 11:49:03','Successful Logout'),(40,'2024-05-17 11:49:22','Successful Login'),(40,'2024-05-17 11:50:16','Successful Login'),(40,'2024-05-17 11:51:42','Successful Login'),(40,'2024-05-17 11:55:39','Successful Login'),(40,'2024-05-17 11:58:51','Successful Login'),(40,'2024-05-17 12:01:05','Successful Login'),(40,'2024-05-17 12:02:59','Successful Login'),(40,'2024-05-17 12:06:01','Failed Login'),(40,'2024-05-17 12:06:05','Successful Login'),(40,'2024-05-17 12:06:53','Successful Login'),(40,'2024-05-17 12:09:24','Successful Login'),(40,'2024-05-17 12:12:45','Successful Login'),(40,'2024-05-17 12:14:57','Successful Login'),(40,'2024-05-17 12:19:46','Successful Login'),(40,'2024-05-17 12:21:59','Successful Login'),(40,'2024-05-17 12:27:21','Successful Login'),(40,'2024-05-17 12:28:25','Successful Login'),(42,'2024-05-15 05:42:37','Account Created'),(42,'2024-05-15 05:42:47','Successful Login'),(42,'2024-05-15 06:08:23','Failed Login'),(42,'2024-05-16 15:12:21','Successful Login'),(44,'2024-05-15 07:19:34','Account Created'),(44,'2024-05-16 14:47:51','Failed Login'),(44,'2024-05-16 14:47:57','Successful Login'),(44,'2024-05-16 14:50:03','Successful Login'),(44,'2024-05-17 11:43:51','Failed Login'),(45,'2024-05-16 13:36:30','Account Created'),(46,'2024-05-16 15:20:51','Account Created'),(46,'2024-05-16 15:20:55','Successful Login'),(46,'2024-05-16 15:23:26','Successful Login'),(46,'2024-05-16 15:23:50','Successful Login'),(46,'2024-05-16 15:26:14','Successful Login'),(46,'2024-05-16 15:27:41','Successful Login'),(46,'2024-05-16 15:29:21','Successful Login'),(46,'2024-05-16 15:31:24','Successful Login'),(46,'2024-05-16 15:32:19','Successful Login');
/*!40000 ALTER TABLE `accesslogs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-17 22:31:01
