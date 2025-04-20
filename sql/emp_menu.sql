/*
Navicat MySQL Data Transfer

Source Server         : d
Source Server Version : 80200
Source Host           : localhost:3306
Source Database       : efps_system

Target Server Type    : MYSQL
Target Server Version : 80200
File Encoding         : 65001

Date: 2025-04-19 16:19:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for emp_menu
-- ----------------------------
DROP TABLE IF EXISTS `emp_menu`;
CREATE TABLE `emp_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `e_id` int NOT NULL,
  `m_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of emp_menu
-- ----------------------------
INSERT INTO `emp_menu` VALUES ('1', '282', '1');
INSERT INTO `emp_menu` VALUES ('2', '282', '5');
INSERT INTO `emp_menu` VALUES ('3', '326', '1');
INSERT INTO `emp_menu` VALUES ('4', '327', '1');
INSERT INTO `emp_menu` VALUES ('5', '328', '1');
INSERT INTO `emp_menu` VALUES ('6', '298', '1');
INSERT INTO `emp_menu` VALUES ('7', '298', '5');
INSERT INTO `emp_menu` VALUES ('8', '329', '1');
INSERT INTO `emp_menu` VALUES ('9', '329', '5');
INSERT INTO `emp_menu` VALUES ('10', '330', '1');
INSERT INTO `emp_menu` VALUES ('11', '330', '5');
INSERT INTO `emp_menu` VALUES ('12', '331', '1');
INSERT INTO `emp_menu` VALUES ('13', '332', '1');
INSERT INTO `emp_menu` VALUES ('14', '333', '1');
INSERT INTO `emp_menu` VALUES ('15', '334', '1');
INSERT INTO `emp_menu` VALUES ('16', '331', '5');
