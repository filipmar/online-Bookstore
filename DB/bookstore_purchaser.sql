CREATE DATABASE  IF NOT EXISTS `bookstore` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bookstore`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bookstore
-- ------------------------------------------------------
-- Server version	5.6.24

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
-- Table structure for table `purchaser`
--

DROP TABLE IF EXISTS `purchaser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `adress` varchar(45) NOT NULL,
  `zipCode` int(11) NOT NULL,
  `city` varchar(45) NOT NULL,
  `phoneNumber` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchaser`
--

LOCK TABLES `purchaser` WRITE;
/*!40000 ALTER TABLE `purchaser` DISABLE KEYS */;
INSERT INTO `purchaser` VALUES (8,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(9,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(10,'Petar','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(11,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Novi Sad',652321990,''),(12,'Filip','Marjanovic','Beogradska 33',21000,'Novi Sad',652321990,''),(13,'Filip','Petrovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(14,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Novi Sad',652321990,''),(15,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(16,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(17,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(18,'Filip','Marjanovic','Pariske Komune 6/27',21000,'Novi Sad',652321990,''),(19,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(20,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',12312312,''),(21,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Novi Sad',652321990,''),(22,'Filip','asd','Pariske Komune 6/27',21000,'Novi Sad',652321990,''),(23,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(24,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Novi Sad',652321990,''),(25,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(26,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',12312312,''),(27,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',63433056,''),(28,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Novi Sad',652321990,''),(29,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(30,'Filip','Marjanovic','Pariske Komune 6/27',21000,'Novi Sad',652321990,''),(31,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(32,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(33,'Filip','Marjanovic','Pariske Komune 6/27',21000,'Novi Sad',652321990,''),(34,'Filip','Marjanovic','Beogradska 33',21000,'Vranje',652321990,''),(35,'Petar','Marjanovic','Beogradska 33',21000,'Vranje',12312312,''),(36,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',12312312,''),(37,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',12312312,''),(38,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(39,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(40,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',652321990,''),(41,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Novi Sad',652321990,''),(42,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Vranje',12312312,''),(43,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Novi Sad',652321990,''),(44,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Novi Sad',652321990,''),(45,'Filip','Petrovic','Beogradska 33',21000,'Novi Sad',12312312,''),(46,'Filip','Marjanovic','Pariske Komune 6/27',17500,'Novi Sad',652321990,''),(47,'Filip','Marjanovic','Pariske Komune 6/27',21000,'Novi Sad',12312312,''),(48,'Petar','Petrovic','Pariske Komune 6/27',17500,'Novi Sad',12312312,''),(49,'Petar','Marjanovic','Beogradska 33',17500,'Novi Sad',652321990,''),(50,'Filip','Petrovic','Beogradska 33',17500,'Vranje',652321990,''),(51,'Filip','Marjanovic','Pariske Komune 6/27',21000,'Novi Sad',652321990,''),(52,'Filip','Marjanovic','Beogradska 33',17500,'Vranje',652321990,''),(53,'Petar','Petrovic','Niska 19',21000,'Novi Sad',632229901,''),(54,'Jovan','Gavrilovic','Kajmakcalanska 21',17500,'Vranje',651220011,'jova@gmail.com'),(55,'Velicko','Marjanovic','Pariske Komune 6/27',17500,'Vranje',651220011,'velja@gmail.com'),(56,'Aleksandar','Petrovic','Beogradska 33',17500,'Novi Sad',652321990,'doke12012@hotmail.com'),(57,'Petar','Petrovic','Pariske Komune 6/27',21000,'Novi Sad',652321990,'fica@mail.com');
/*!40000 ALTER TABLE `purchaser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-10  0:18:15
