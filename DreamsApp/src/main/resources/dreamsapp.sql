-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.29 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for dreamsapp
CREATE DATABASE IF NOT EXISTS `dreamsapp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dreamsapp`;

-- Dumping structure for table dreamsapp.notes
CREATE TABLE IF NOT EXISTS `notes` (
  `id` bigint NOT NULL,
  `body` varchar(255) NOT NULL,
  `person_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjq86w4e4wa2d1hb0lutsqfwmp` (`person_id`),
  CONSTRAINT `FKjq86w4e4wa2d1hb0lutsqfwmp` FOREIGN KEY (`person_id`) REFERENCES `persons` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table dreamsapp.notes: ~2 rows (approximately)
INSERT INTO `notes` (`id`, `body`, `person_id`) VALUES
	(1, 'Dream', 1),
	(2, 'Traum', 1);

-- Dumping structure for table dreamsapp.notes_seq
CREATE TABLE IF NOT EXISTS `notes_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table dreamsapp.notes_seq: ~1 rows (approximately)
INSERT INTO `notes_seq` (`next_val`) VALUES
	(1);

-- Dumping structure for table dreamsapp.persons
CREATE TABLE IF NOT EXISTS `persons` (
  `id` bigint NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table dreamsapp.persons: ~3 rows (approximately)
INSERT INTO `persons` (`id`, `first_name`, `last_name`) VALUES
	(1, 'Danylo', 'Stalmakov'),
	(2, 'John', 'Doe'),
	(3, 'Clone', 'Smith');

-- Dumping structure for table dreamsapp.persons_seq
CREATE TABLE IF NOT EXISTS `persons_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table dreamsapp.persons_seq: ~1 rows (approximately)
INSERT INTO `persons_seq` (`next_val`) VALUES
	(101);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
