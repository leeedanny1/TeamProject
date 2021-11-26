-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.6.5-MariaDB - mariadb.org binary distribution
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

-- 테이블 jcmarket.notice_comments 구조 내보내기
DROP TABLE IF EXISTS `notice_comments`;
CREATE TABLE IF NOT EXISTS `notice_comments` (
  `notice_code` int(11) NOT NULL,
  `notice_comments_code` int(11) NOT NULL,
  `notice_comments_writer` varchar(50) NOT NULL,
  `notice_comments_content` text NOT NULL,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`notice_comments_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 jcmarket.notice_dtl 구조 내보내기
DROP TABLE IF EXISTS `notice_dtl`;
CREATE TABLE IF NOT EXISTS `notice_dtl` (
  `notice_code` int(11) NOT NULL,
  `notice_content` text NOT NULL,
  `originFileNames` varchar(500) DEFAULT NULL,
  `tempFileNames` varchar(500) DEFAULT NULL,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`notice_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 jcmarket.notice_mst 구조 내보내기
DROP TABLE IF EXISTS `notice_mst`;
CREATE TABLE IF NOT EXISTS `notice_mst` (
  `notice_code` int(11) NOT NULL AUTO_INCREMENT,
  `notice_title` varchar(50) NOT NULL,
  `notice_writer` varchar(50) NOT NULL,
  `notice_count` int(11) NOT NULL,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`notice_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 jcmarket.phonenumber_mst 구조 내보내기
DROP TABLE IF EXISTS `phonenumber_mst`;
CREATE TABLE IF NOT EXISTS `phonenumber_mst` (
  `phone_number` varchar(50) NOT NULL,
  `phone_name` varchar(50) NOT NULL,
  `create_date` date NOT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 jcmarket.product_dtl 구조 내보내기
DROP TABLE IF EXISTS `product_dtl`;
CREATE TABLE IF NOT EXISTS `product_dtl` (
  `item_code` int(11) NOT NULL,
  `item_title` varchar(50) NOT NULL DEFAULT '',
  `item_content` varchar(5000) NOT NULL DEFAULT '',
  `item_stat` varchar(50) NOT NULL DEFAULT '',
  `item_change` varchar(50) NOT NULL DEFAULT '',
  `item_delivery` varchar(50) NOT NULL DEFAULT '',
  `originFileNames` varchar(500) NOT NULL,
  `tempFileNames` varchar(500) NOT NULL,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`item_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 jcmarket.product_mst 구조 내보내기
DROP TABLE IF EXISTS `product_mst`;
CREATE TABLE IF NOT EXISTS `product_mst` (
  `item_code` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(50) NOT NULL,
  `item_writer` varchar(50) NOT NULL,
  `item_price` int(11) NOT NULL DEFAULT 0,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`item_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 jcmarket.user_mst 구조 내보내기
DROP TABLE IF EXISTS `user_mst`;
CREATE TABLE IF NOT EXISTS `user_mst` (
  `user_id` varchar(500) NOT NULL,
  `user_password` varchar(500) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_phone` varchar(50) NOT NULL,
  `user_nickname` varchar(50) NOT NULL,
  `buy_count` int(11) NOT NULL,
  `sell_count` int(11) NOT NULL,
  `role` varchar(30) NOT NULL,
  `provider` varchar(30) DEFAULT NULL,
  `create_date` date NOT NULL,
  `update_date` date NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 내보낼 데이터가 선택되어 있지 않습니다.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
