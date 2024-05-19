-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (arm64)
--
-- Host: localhost    Database: iotbay
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `fname` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `phoneno` varchar(12) DEFAULT NULL,
  `isactive` bit(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12283 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (1,'m.lunn54@gmail.com','123','Michael','Lunn','0490000000',_binary ''),(2,'mickeymouse@gmail.com','123','Mickey','Mouse','0400000000',_binary ''),(3,'donaldduck@gmail.com','123','Donald','Duck','0400000000',_binary ''),(5,'pabloescobar@gmail.com','1','Pablo','Escobar','0400000000',_binary ''),(6,'daffyduck@gmail.com','123','Daffy','Duck','0400000000',_binary ''),(39,'jeffbezos@iotbay.com','iotbay','Jeff','Bezos','0412345678',_binary '\0'),(1507,'niktes@mail.com','12345678','Nicola','Tesla','0409908098',_binary '\0'),(8246,'alice.johnson@example.com','password123','Alice','Johnson','0412345678',_binary ''),(8247,'bob.smith@example.com','securepass','Bob','Smith','0412345679',_binary ''),(8248,'charlie.brown@example.com','mypassword','Charlie','Brown','0412345680',_binary '\0'),(8249,'diane.jones@example.com','diane2020','Diane','Jones','0412345681',_binary ''),(8250,'edward.taylor@example.com','edwardpass','Edward','Taylor','0412345682',_binary ''),(8251,'fiona.wilson@example.com','fionapass','Fiona','Wilson','0412345683',_binary '\0'),(8252,'george.moore@example.com','george1234','George','Moore','0412345684',_binary ''),(8253,'hannah.martin@example.com','hannahpass','Hannah','Martin','0412345685',_binary ''),(8254,'ian.lewis@example.com','ianpass','Ian','Lewis','0412345686',_binary '\0'),(8255,'julia.walker@example.com','julia2021','Julia','Walker','0412345687',_binary ''),(8256,'kevin.hall@example.com','kevinpass','Kevin','Hall','0412345688',_binary '\0'),(8257,'laura.king@example.com','laurapass','Laura','King','0412345689',_binary ''),(8258,'michael.scott@example.com','michael123','Michael','Scott','0412345690',_binary ''),(8259,'nancy.young@example.com','nancypass','Nancy','Young','0412345691',_binary '\0'),(8260,'oscar.green@example.com','oscar2022','Oscar','Green','0412345692',_binary ''),(8261,'peter.parker@iotbay.com','spiderpass','Peter','Parker','0412345693',_binary ''),(8262,'mary.jane@iotbay.com','mjpassword','Mary','Jane','0412345694',_binary ''),(8263,'tony.stark@iotbay.com','ironman','Tony','Stark','0412345695',_binary ''),(8264,'bruce.banner@iotbay.com','hulkpass','Bruce','Banner','0412345696',_binary '\0'),(8265,'natasha.romanoff@iotbay.com','blackwidow','Natasha','Romanoff','0412345697',_binary '');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-19 10:43:11
