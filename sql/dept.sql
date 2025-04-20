/*
Navicat MySQL Data Transfer

Source Server         : d
Source Server Version : 80200
Source Host           : localhost:3306
Source Database       : efps_system

Target Server Type    : MYSQL
Target Server Version : 80200
File Encoding         : 65001

Date: 2025-04-19 16:18:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int NOT NULL AUTO_INCREMENT,
  `d_total` int NOT NULL,
  `d_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `d_avatarpath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `d_createtime` date DEFAULT NULL,
  `d_updatetime` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `d_name` (`d_name`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('46', '2', '管理部', 'https://efps-sys.oss-cn-hangzhou.aliyuncs.com/c0ed6671-0234-4610-b975-3f5241fce8be.jpg', '2024-08-12', '2025-03-23');
INSERT INTO `dept` VALUES ('47', '1', '区域部', 'https://efps-sys.oss-cn-hangzhou.aliyuncs.com/6102f14d-4050-42c0-81ec-724c06f8ffd0.jpg', null, '2025-03-23');
INSERT INTO `dept` VALUES ('48', '1', '塔台部', 'https://efps-sys.oss-cn-hangzhou.aliyuncs.com/49160997-9dae-43a8-880a-b56c15deb7ae.jpg', null, '2025-03-23');
INSERT INTO `dept` VALUES ('49', '5', '临时部', 'https://efps-sys.oss-cn-hangzhou.aliyuncs.com/7f40cf95-7b92-4890-8f14-71c6ffdad8c2.jpeg', null, '2025-02-10');
INSERT INTO `dept` VALUES ('53', '1', '地面部', 'https://efps-sys.oss-cn-hangzhou.aliyuncs.com/85762c81-e45b-4a7d-9d9a-d495f765f215.jpg', '2024-10-22', '2025-03-23');
