/*
Navicat MySQL Data Transfer

Source Server         : d
Source Server Version : 80200
Source Host           : localhost:3306
Source Database       : efps_system

Target Server Type    : MYSQL
Target Server Version : 80200
File Encoding         : 65001

Date: 2025-04-19 16:20:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role_routes
-- ----------------------------
DROP TABLE IF EXISTS `role_routes`;
CREATE TABLE `role_routes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `r_id` int NOT NULL,
  `ro_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ro_id` (`ro_id`),
  KEY `r_id` (`r_id`),
  CONSTRAINT `role_routes_ibfk_1` FOREIGN KEY (`ro_id`) REFERENCES `dynamic_routes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_routes_ibfk_2` FOREIGN KEY (`r_id`) REFERENCES `role` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role_routes
-- ----------------------------
INSERT INTO `role_routes` VALUES ('1', '1', '1');
INSERT INTO `role_routes` VALUES ('2', '1', '2');
INSERT INTO `role_routes` VALUES ('3', '1', '3');
INSERT INTO `role_routes` VALUES ('4', '1', '4');
INSERT INTO `role_routes` VALUES ('5', '1', '5');
INSERT INTO `role_routes` VALUES ('6', '1', '6');
INSERT INTO `role_routes` VALUES ('7', '1', '7');
INSERT INTO `role_routes` VALUES ('8', '1', '8');
INSERT INTO `role_routes` VALUES ('9', '1', '9');
INSERT INTO `role_routes` VALUES ('10', '1', '10');
INSERT INTO `role_routes` VALUES ('11', '1', '11');
INSERT INTO `role_routes` VALUES ('12', '1', '12');
INSERT INTO `role_routes` VALUES ('13', '1', '13');
INSERT INTO `role_routes` VALUES ('14', '1', '14');
INSERT INTO `role_routes` VALUES ('15', '1', '15');
INSERT INTO `role_routes` VALUES ('16', '2', '1');
INSERT INTO `role_routes` VALUES ('17', '2', '2');
INSERT INTO `role_routes` VALUES ('18', '2', '3');
INSERT INTO `role_routes` VALUES ('19', '2', '4');
INSERT INTO `role_routes` VALUES ('20', '2', '5');
INSERT INTO `role_routes` VALUES ('21', '2', '6');
INSERT INTO `role_routes` VALUES ('22', '2', '7');
INSERT INTO `role_routes` VALUES ('23', '2', '8');
INSERT INTO `role_routes` VALUES ('24', '2', '9');
INSERT INTO `role_routes` VALUES ('25', '2', '10');
INSERT INTO `role_routes` VALUES ('26', '2', '11');
INSERT INTO `role_routes` VALUES ('27', '2', '12');
INSERT INTO `role_routes` VALUES ('28', '2', '13');
INSERT INTO `role_routes` VALUES ('29', '2', '14');
INSERT INTO `role_routes` VALUES ('30', '2', '15');
INSERT INTO `role_routes` VALUES ('31', '3', '1');
INSERT INTO `role_routes` VALUES ('32', '3', '2');
INSERT INTO `role_routes` VALUES ('33', '3', '3');
INSERT INTO `role_routes` VALUES ('34', '3', '4');
INSERT INTO `role_routes` VALUES ('35', '3', '5');
INSERT INTO `role_routes` VALUES ('36', '3', '6');
INSERT INTO `role_routes` VALUES ('37', '3', '7');
INSERT INTO `role_routes` VALUES ('38', '3', '8');
INSERT INTO `role_routes` VALUES ('39', '3', '9');
INSERT INTO `role_routes` VALUES ('40', '3', '10');
INSERT INTO `role_routes` VALUES ('41', '3', '11');
INSERT INTO `role_routes` VALUES ('42', '3', '12');
INSERT INTO `role_routes` VALUES ('43', '3', '13');
INSERT INTO `role_routes` VALUES ('44', '3', '14');
INSERT INTO `role_routes` VALUES ('45', '3', '15');
INSERT INTO `role_routes` VALUES ('63', '4', '1');
INSERT INTO `role_routes` VALUES ('64', '4', '2');
INSERT INTO `role_routes` VALUES ('65', '4', '3');
INSERT INTO `role_routes` VALUES ('66', '4', '4');
INSERT INTO `role_routes` VALUES ('67', '4', '5');
INSERT INTO `role_routes` VALUES ('68', '4', '6');
INSERT INTO `role_routes` VALUES ('69', '4', '7');
INSERT INTO `role_routes` VALUES ('70', '4', '8');
INSERT INTO `role_routes` VALUES ('71', '4', '9');
INSERT INTO `role_routes` VALUES ('72', '4', '10');
INSERT INTO `role_routes` VALUES ('73', '4', '11');
INSERT INTO `role_routes` VALUES ('74', '4', '12');
INSERT INTO `role_routes` VALUES ('75', '4', '13');
INSERT INTO `role_routes` VALUES ('76', '4', '14');
INSERT INTO `role_routes` VALUES ('77', '4', '15');
INSERT INTO `role_routes` VALUES ('78', '2', '16');
INSERT INTO `role_routes` VALUES ('79', '3', '16');
INSERT INTO `role_routes` VALUES ('80', '2', '234');
INSERT INTO `role_routes` VALUES ('82', '1', '16');
INSERT INTO `role_routes` VALUES ('83', '1', '234');
INSERT INTO `role_routes` VALUES ('84', '5', '1');
INSERT INTO `role_routes` VALUES ('86', '5', '3');
INSERT INTO `role_routes` VALUES ('89', '5', '6');
INSERT INTO `role_routes` VALUES ('97', '5', '14');
INSERT INTO `role_routes` VALUES ('98', '5', '234');
INSERT INTO `role_routes` VALUES ('99', '1', '235');
INSERT INTO `role_routes` VALUES ('100', '1', '236');
