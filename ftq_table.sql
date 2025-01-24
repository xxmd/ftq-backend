/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 9.0.1 : Database - ftq
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ftq` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `ftq`;

/*Table structure for table `activation_code` */

DROP TABLE IF EXISTS `activation_code`;

CREATE TABLE `activation_code` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` enum('CREATED','EXPORTED','ACTIVATED') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `subscription_id` int NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `export_time` timestamp NULL DEFAULT NULL,
  `activate_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `device_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1688 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `activation_code` */

insert  into `activation_code`(`id`,`content`,`status`,`subscription_id`,`create_time`,`export_time`,`activate_time`,`update_time`,`device_id`) values 
(1682,'69d9de4e-8e49-4cca-97d6-17a6f32c99a9','ACTIVATED',1,'2025-01-24 11:01:07',NULL,'2025-01-24 11:22:04','2025-01-24 11:22:04',13),
(1683,'e3a1fbc8-6fa8-45b2-b8d9-bc2f7d8534a0','CREATED',1,'2025-01-24 11:01:07',NULL,NULL,'2025-01-24 11:01:07',NULL),
(1684,'3dbc3d54-77e5-4ee4-acf8-277301211707','ACTIVATED',2,'2025-01-24 11:01:11',NULL,'2025-01-24 11:10:43','2025-01-24 11:10:44',13),
(1685,'d133f6c4-c033-4011-82de-b3fec5b3cf90','ACTIVATED',2,'2025-01-24 11:01:11',NULL,'2025-01-24 11:30:21','2025-01-24 11:30:21',13),
(1686,'e772dcc1-2f54-4ff4-a811-c0f88265f232','ACTIVATED',3,'2025-01-24 11:01:14',NULL,'2025-01-24 14:48:43','2025-01-24 14:48:43',14),
(1687,'eff682b0-b5e0-4967-8450-802926c82e13','ACTIVATED',3,'2025-01-24 11:01:14',NULL,'2025-01-24 14:45:53','2025-01-24 14:45:53',14);

/*Table structure for table `device` */

DROP TABLE IF EXISTS `device`;

CREATE TABLE `device` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `android_id` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `api_level` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `device` */

insert  into `device`(`id`,`create_time`,`update_time`,`android_id`,`model`,`manufacturer`,`api_level`) values 
(13,'2025-01-24 11:10:44','2025-01-24 11:10:44','e8d9ca3922d3ec1b','23113RKC6C','Xiaomi',34),
(14,'2025-01-24 14:45:53','2025-01-24 14:45:53','0aeaaf53164d8e36','Pixel 3','Google',31);

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `hibernate_sequence` */

/*Table structure for table `platform` */

DROP TABLE IF EXISTS `platform`;

CREATE TABLE `platform` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `icon_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `package_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `platform` */

insert  into `platform`(`id`,`name`,`icon_url`,`create_time`,`update_time`,`package_name`) values 
(1,'淘宝','https://wms-file-bucket.oss-cn-hangzhou.aliyuncs.com/taobao.png','2025-01-24 10:45:10','2025-01-24 10:46:11','com.taobao.taobao'),
(2,'天猫','https://wms-file-bucket.oss-cn-hangzhou.aliyuncs.com/tianmao.png','2025-01-24 10:45:40','2025-01-24 10:46:12','com.tmall.wireless'),
(3,'拼多多','https://wms-file-bucket.oss-cn-hangzhou.aliyuncs.com/pdd.png','2025-01-24 10:46:04','2025-01-24 10:46:14','com.xunmeng.pinduoduo');

/*Table structure for table `sku` */

DROP TABLE IF EXISTS `sku`;

CREATE TABLE `sku` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `platform_id` int NOT NULL,
  `subscription_id` int NOT NULL,
  `link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `sku` */

insert  into `sku`(`id`,`platform_id`,`subscription_id`,`link`,`create_time`,`update_time`) values 
(1,1,1,'https://h5.m.taobao.com/awp/core/detail.htm?ft=t&id=839486347389','2025-01-24 10:52:00','2025-01-24 10:52:00'),
(2,1,2,'https://h5.m.taobao.com/awp/core/detail.htm?ft=t&id=839563706096','2025-01-24 10:52:16','2025-01-24 10:52:16'),
(3,1,3,'https://h5.m.taobao.com/awp/core/detail.htm?ft=t&id=839488439011','2025-01-24 10:52:34','2025-01-24 10:52:34'),
(4,3,3,'https://mobile.yangkeduo.com/goods2.html?goods_id=699030868292','2025-01-24 10:53:32','2025-01-24 10:53:32');

/*Table structure for table `subscription` */

DROP TABLE IF EXISTS `subscription`;

CREATE TABLE `subscription` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `activation_days` int NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `subscription` */

insert  into `subscription`(`id`,`name`,`price`,`activation_days`,`create_time`,`update_time`) values 
(1,'包天套餐',1.00,1,'2025-01-24 10:47:38','2025-01-24 10:47:38'),
(2,'包月套餐',10.00,30,'2025-01-24 10:47:49','2025-01-24 10:47:49'),
(3,'包年套餐',50.00,365,'2025-01-24 10:48:00','2025-01-24 10:48:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
