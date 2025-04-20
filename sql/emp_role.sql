/*
Navicat MySQL Data Transfer

Source Server         : d
Source Server Version : 80200
Source Host           : localhost:3306
Source Database       : efps_system

Target Server Type    : MYSQL
Target Server Version : 80200
File Encoding         : 65001

Date: 2025-04-19 16:19:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for emp_role
-- ----------------------------
DROP TABLE IF EXISTS `emp_role`;
CREATE TABLE `emp_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `e_id` int DEFAULT NULL,
  `r_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `r_id` (`r_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `e_id` FOREIGN KEY (`e_id`) REFERENCES `emp` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `r_id` FOREIGN KEY (`r_id`) REFERENCES `role` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of emp_role
-- ----------------------------
INSERT INTO `emp_role` VALUES ('43', '330', '1');
INSERT INTO `emp_role` VALUES ('44', '331', '2');
INSERT INTO `emp_role` VALUES ('45', '332', '3');
INSERT INTO `emp_role` VALUES ('46', '333', '4');
INSERT INTO `emp_role` VALUES ('47', '334', '5');
