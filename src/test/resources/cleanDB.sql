-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: sample
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sample_test`
--

DROP TABLE IF EXISTS `sample_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sample_test` (
                               `word_count` int DEFAULT NULL,
                               `length` int DEFAULT NULL,
                               `wpm` int DEFAULT NULL,
                               `title` varchar(255) DEFAULT NULL,
                               `session_date` datetime DEFAULT NULL,
                               `user_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sample_test`
--

LOCK TABLES `sample_test` WRITE;
/*!40000 ALTER TABLE `sample_test` DISABLE KEYS */;
INSERT INTO `sample_test` VALUES (50,5,10,'Test','2024-02-14 05:37:20',NULL),(500,25,20,'Test2','2024-02-19 11:13:31',NULL);
/*!40000 ALTER TABLE `sample_test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session_test`
--

DROP TABLE IF EXISTS `session_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `session_test` (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `title` varchar(100) DEFAULT NULL,
                                `word_count` int DEFAULT NULL,
                                `length` int DEFAULT NULL,
                                `wpm` int DEFAULT NULL,
                                `session_date` datetime DEFAULT NULL,
                                `user_id` int DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `sessions_date_time_uindex` (`session_date`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session_test`
--

LOCK TABLES `session_test` WRITE;
/*!40000 ALTER TABLE `session_test` DISABLE KEYS */;
INSERT INTO `session_test` VALUES (1,'Test',44,5,9,'2024-02-12 15:03:45',2),(2,'Test2',500,25,20,'2024-02-14 15:04:27',3),(3,'NovelSession',2000,60,34,'2024-02-19 15:05:39',1);
/*!40000 ALTER TABLE `session_test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `first_name` varchar(25) DEFAULT NULL,
                        `last_name` varchar(30) DEFAULT NULL,
                        `user_name` varchar(15) DEFAULT NULL,
                        `password` varchar(30) DEFAULT NULL,
                        `date_of_birth` date DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `users_user_name_uindex` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Joe','Coyne','jcoyne','supersecret1','1964-03-31'),(2,'Barney','Curry','bcurry','supersecret3','1947-11-11'),(3,'Karen','Mack','kmack','supersecret4','1986-07-08'),(4,'Dianne','Klein','dklein','supersecret5','1991-01-22'),(5,'Dawn','Tillman','dtillman','supersecret6','1979-08-30');
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

-- Dump completed on 2024-02-19 15:12:27
