/*
Navicat MySQL Data Transfer

Source Server         : d
Source Server Version : 80200
Source Host           : localhost:3306
Source Database       : efps_system

Target Server Type    : MYSQL
Target Server Version : 80200
File Encoding         : 65001

Date: 2025-04-19 16:19:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for important_msg
-- ----------------------------
DROP TABLE IF EXISTS `important_msg`;
CREATE TABLE `important_msg` (
  `id` int NOT NULL AUTO_INCREMENT,
  `header` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `author` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of important_msg
-- ----------------------------
INSERT INTO `important_msg` VALUES ('16', 'EFPS-SYSTEM使用概要', '指挥控制中的页面受限于用户的角色', '2025-02-11 10:51:42', '2025-02-11 10:51:42', 'RWG', '1');
INSERT INTO `important_msg` VALUES ('17', '添加用户说明', '当创建新用户时管理员或者超级管理员需赋予用户可访问的路由页面', '2025-02-11 10:53:37', '2025-02-11 10:53:37', 'RENWEIGUO', '1');
