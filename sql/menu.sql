/*
Navicat MySQL Data Transfer

Source Server         : d
Source Server Version : 80200
Source Host           : localhost:3306
Source Database       : efps_system

Target Server Type    : MYSQL
Target Server Version : 80200
File Encoding         : 65001

Date: 2025-04-19 16:19:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `m_id` int NOT NULL AUTO_INCREMENT,
  `m_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `m_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `m_sign` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '', '用户个人的基本操作', 'emp');
INSERT INTO `menu` VALUES ('5', '', '超级管理员的基本操作', 'admin');
