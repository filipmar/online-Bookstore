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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `authors` varchar(65) NOT NULL,
  `publisher` varchar(55) NOT NULL,
  `publicationYear` year(4) NOT NULL,
  `description` mediumtext NOT NULL,
  `genre` varchar(35) NOT NULL,
  `numberInStock` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `pictureURL` varchar(65) DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `title_UNIQUE` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Harry Potter and the Sorcerer\'s Stone','J.K.Rowling','Scholastic Inc.',1998,'Harry\'s magical parents were killed by the evil wizard Voldemort when he was just a baby. Miraculously, he survives with only a lightning-bolt scar as a mysterious reminder. Ten miserable years later, he gets a visit from a genial half-giant named Hagrid ','fiction',0,19.00,'picture/Harry Potter and the Sorcerers Stone.jpg','active'),(2,'The Education of Ivy Blake','Ellen Airgood','Nancy Paulsen Books',2015,'Ivy\'s been happy living with her best friend Prairie Evers\' bustling, adorably oddball family. But now that her mother\'s back, Ivy can\'t pass up the chance to live with her again and try to form a more solid bond...','drama',10,21.99,NULL,'not active'),(3,'Forever for a Yearsss','B.T. Gottfred','Henry Holt & Company, Inc.',2015,'For both Carrie and Trevor, freshman year is a new beginning: Carrie is reinventing herself as Carolina, and Trevor has just moved to town and is entering a new school. They meet on the first day and, despite pressure from friends who are against the relationship, thay fall in love...','romance',7,14.99,'picture/ForeverforaYear.jpg','active'),(4,'Mira\'s Diary: Bombs Over London','Marissa Moss','Creston Books',2014,'Parents need to know that this is the third installment in the Mira\'s Diary series from Marissa Moss, author of the popular Amelia\'s Notebook series. Mira\'s time-traveling adventures continue to teach kids about important events in world history and get them thinking about social-justice issues.','adventure',5,15.49,'picture/mdbombs.jpg','active'),(5,'Pure','Julianna Baggott','Grand Central Publishing',2012,'PURE begins many years after the Detonations -- a series of bombings that destroyed much of the world and caused everyday objects to be fused with people. It\'s in this post-apocalyptic world that 16-year-old Pressia Belze, who can barely remember life before the Detonations...','fiction',4,11.00,'picture/pure.jpg','active'),(6,'Silver In the Blood','Jessica Day George','Bloomsbury Children\'s Books',2015,'Cousins Dacia and Louisa are rich New York society girls sent to Romania to meet their mothers\' family, the Florescus. Once there, they discover that their family members are actually shape-shifters, and that they, too, can transform.','fantasy',3,13.29,'picture/Fantasy.jpg','active'),(7,'Far North','Will Hobbs','William Morrow',1996,'Lectrifying nonstop, realistic action as two teenage boys fight to survive the winter after their plane crashes in Canada\'s Northwest Territories. They ignore good advice and raft through a dangerous, icy river, winding up in a valley with no available food.','adventure',43,3.99,'picture/farNorth.jpg','active'),(8,'Armada','Ernest Cline','Crown Publishing Group',2015,'When high school senior and gamer Zack Lightman spots a UFO outside his window, he thinks he might be hallucinating. But when he\'s recruited later that day by the Earth Defense Alliance to repel an alien invasion, he knows that the threat is all too real.','fantasy',3,14.00,NULL,'active'),(9,'Split Second','Kasie West','HarperTeen',2014,'When Addie goes to spend six weeks with her father outside of the secret Compound where she lives with her mom -- and a whole society of people with special mind powers -- she doesn\'t really know much about Trevor.','fiction',6,12.99,'picture/splitSecond.jpg','active'),(10,'Flora and the Penguin','Molly Idle','Chronicle Books',2014,'Flora goes for a skate on natural outdoor ice, and suddenly a penguin pops out of a watery hole in the ice. She finds the bird a perfect partner for pair skating. They do all their graceful moves in unison until the penguin tries a spin and plunges plunges back through the hole.','for kids',23,2.99,'picture/flora.jpg','active'),(11,'Deadly Design','Debra Dockter','Putnam Juvenile',2015,'Even though they were born two years apart, Connor and Kyle are identical twins, Kyle having been kept frozen as an embryo for a couple of extra years. Everything comes easily to brilliant, handsome, motivated Connor, and Kyle resents him for his good grades, athletic ability, and beautiful girlfriend. ','Fiction',2,9.99,'picture/Deadly Design.jpg','active'),(12,'adas','asda','adada',1997,'adsasdasasd','horor',12,12.00,'picture/do_windows_10-wallpaper-1366x768.jpg','not active'),(15,'Knjiga1','sdasd','publsis',1999,'asdad asdasd ','Autobiografy',1,11.00,'picture/windows_10_2015_yellow_background-wallpaper-1366x768.jpg','not active'),(16,'testKnjiga','autori','testIzdavac',1998,'asdsdddadadasdadad','drama',21,21.00,'picture/binary_windows_10_codes-wallpaper-1366x768.jpg','not active'),(17,'bezSlike','bezSlikeau','bezSlkepu',1909,'asddddadadadadadadasda','crime',2,2.00,NULL,'not active');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-10  0:18:16
