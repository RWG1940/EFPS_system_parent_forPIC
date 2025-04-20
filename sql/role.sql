/*
Navicat MySQL Data Transfer

Source Server         : d
Source Server Version : 80200
Source Host           : localhost:3306
Source Database       : efps_system

Target Server Type    : MYSQL
Target Server Version : 80200
File Encoding         : 65001

Date: 2025-04-19 16:19:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `r_id` int NOT NULL AUTO_INCREMENT,
  `r_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `r_info` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'super_admin', '超级管理员');
INSERT INTO `role` VALUES ('2', 'admin', '管理员');
INSERT INTO `role` VALUES ('3', 'area', '区域管制席');
INSERT INTO `role` VALUES ('4', 'tower', '塔台管制席');
INSERT INTO `role` VALUES ('5', 'release', '放行地面管制席');
