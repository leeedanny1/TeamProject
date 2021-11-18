-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.6.4-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- jcmarket 데이터베이스 구조 내보내기
DROP DATABASE IF EXISTS `jcmarket`;
CREATE DATABASE IF NOT EXISTS `jcmarket` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `jcmarket`;

-- 테이블 jcmarket.border_dtl 구조 내보내기
DROP TABLE IF EXISTS `border_dtl`;
CREATE TABLE IF NOT EXISTS `border_dtl` (
  `border_code` int(11) NOT NULL,
  `border_content` text DEFAULT NULL,
  `originFileNames` varchar(500) DEFAULT NULL,
  `tempFileNames` varchar(500) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`border_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- 테이블 데이터 jcmarket.border_dtl:~0 rows (대략적) 내보내기
DELETE FROM `border_dtl`;
/*!40000 ALTER TABLE `border_dtl` DISABLE KEYS */;
/*!40000 ALTER TABLE `border_dtl` ENABLE KEYS */;

-- 테이블 jcmarket.border_mst 구조 내보내기
DROP TABLE IF EXISTS `border_mst`;
CREATE TABLE IF NOT EXISTS `border_mst` (
  `border_code` int(11) NOT NULL,
  `border_content` varchar(50) DEFAULT NULL,
  `border_writer` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`border_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- 테이블 데이터 jcmarket.border_mst:~0 rows (대략적) 내보내기
DELETE FROM `border_mst`;
/*!40000 ALTER TABLE `border_mst` DISABLE KEYS */;
/*!40000 ALTER TABLE `border_mst` ENABLE KEYS */;

-- 테이블 jcmarket.notice_dtl 구조 내보내기
DROP TABLE IF EXISTS `notice_dtl`;
CREATE TABLE IF NOT EXISTS `notice_dtl` (
  `notice_code` int(11) NOT NULL,
  `notice_content` text DEFAULT NULL,
  `originFileNames` varchar(500) DEFAULT NULL,
  `tempFileNames` varchar(500) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`notice_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 jcmarket.notice_dtl:~0 rows (대략적) 내보내기
DELETE FROM `notice_dtl`;
/*!40000 ALTER TABLE `notice_dtl` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice_dtl` ENABLE KEYS */;

-- 테이블 jcmarket.notice_mst 구조 내보내기
DROP TABLE IF EXISTS `notice_mst`;
CREATE TABLE IF NOT EXISTS `notice_mst` (
  `notice_code` int(11) NOT NULL,
  `notice_content` varchar(50) DEFAULT NULL,
  `notice_writer` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`notice_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 jcmarket.notice_mst:~0 rows (대략적) 내보내기
DELETE FROM `notice_mst`;
/*!40000 ALTER TABLE `notice_mst` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice_mst` ENABLE KEYS */;

-- 테이블 jcmarket.phonenumber_mst 구조 내보내기
DROP TABLE IF EXISTS `phonenumber_mst`;
CREATE TABLE IF NOT EXISTS `phonenumber_mst` (
  `phone_number` varchar(50) NOT NULL,
  `phone_name` varchar(50) NOT NULL,
  `create_date` date NOT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 jcmarket.phonenumber_mst:~0 rows (대략적) 내보내기
DELETE FROM `phonenumber_mst`;
/*!40000 ALTER TABLE `phonenumber_mst` DISABLE KEYS */;
/*!40000 ALTER TABLE `phonenumber_mst` ENABLE KEYS */;

-- 테이블 jcmarket.product_dtl 구조 내보내기
DROP TABLE IF EXISTS `product_dtl`;
CREATE TABLE IF NOT EXISTS `product_dtl` (
  `product_code` int(11) NOT NULL,
  `product_content` text DEFAULT NULL,
  `originFileNames` varchar(500) DEFAULT NULL,
  `tempFileNames` varchar(500) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`product_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- 테이블 데이터 jcmarket.product_dtl:~0 rows (대략적) 내보내기
DELETE FROM `product_dtl`;
/*!40000 ALTER TABLE `product_dtl` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_dtl` ENABLE KEYS */;

-- 테이블 jcmarket.product_mst 구조 내보내기
DROP TABLE IF EXISTS `product_mst`;
CREATE TABLE IF NOT EXISTS `product_mst` (
  `product_code` int(11) NOT NULL,
  `product_content` varchar(50) DEFAULT NULL,
  `product_writer` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`product_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- 테이블 데이터 jcmarket.product_mst:~0 rows (대략적) 내보내기
DELETE FROM `product_mst`;
/*!40000 ALTER TABLE `product_mst` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_mst` ENABLE KEYS */;

-- 테이블 jcmarket.user_mst 구조 내보내기
DROP TABLE IF EXISTS `user_mst`;
CREATE TABLE IF NOT EXISTS `user_mst` (
  `user_id` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_phone` varchar(50) NOT NULL,
  `user_nickname` varchar(50) NOT NULL,
  `buy_count` int(11) NOT NULL,
  `sell_count` int(11) NOT NULL,
  `role` varchar(30) NOT NULL,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 jcmarket.user_mst:~0 rows (대략적) 내보내기
DELETE FROM `user_mst`;
/*!40000 ALTER TABLE `user_mst` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_mst` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
