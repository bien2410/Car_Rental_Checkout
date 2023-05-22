CREATE DATABASE  IF NOT EXISTS `rentalcar` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rentalcar`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: rentalcar
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `tblcarrental`
--

DROP TABLE IF EXISTS `tblcarrental`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcarrental` (
  `id` int NOT NULL,
  `dayStart` date NOT NULL,
  `dayEnd` date NOT NULL,
  `price` float NOT NULL,
  `isReturned` int NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `idCar` varchar(45) NOT NULL,
  `idContract` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCar_idx` (`idCar`),
  KEY `idContract_idx` (`idContract`),
  CONSTRAINT `idCar` FOREIGN KEY (`idCar`) REFERENCES `tblcar` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `idContract` FOREIGN KEY (`idContract`) REFERENCES `tblcontract` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcarrental`
--

LOCK TABLES `tblcarrental` WRITE;
/*!40000 ALTER TABLE `tblcarrental` DISABLE KEYS */;
INSERT INTO `tblcarrental` VALUES (1,'2023-05-10','2023-05-13',4000,1,NULL,'XE1','TX2'),(2,'2023-05-10','2023-05-14',7500,0,NULL,'XE2','TX1'),(3,'2023-05-11','2023-05-14',8000,0,NULL,'XE3','TX1');
/*!40000 ALTER TABLE `tblcarrental` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-23  1:33:44
