/*
Navicat MySQL Data Transfer

Source Server         : d
Source Server Version : 80200
Source Host           : localhost:3306
Source Database       : efps_system

Target Server Type    : MYSQL
Target Server Version : 80200
File Encoding         : 65001

Date: 2025-04-19 16:19:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int NOT NULL AUTO_INCREMENT,
  `e_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `e_username` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `e_password` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `e_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `e_gender` int DEFAULT NULL,
  `e_age` int DEFAULT NULL,
  `e_phone` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `e_avatarpath` varchar(255) DEFAULT NULL,
  `e_createtime` datetime(6) DEFAULT NULL,
  `e_updatetime` datetime(6) DEFAULT NULL,
  `e_isEnabled` int DEFAULT '0',
  `e_Deptid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `e_username` (`e_username`),
  UNIQUE KEY `e_id` (`e_id`),
  KEY `e_name` (`e_name`) USING BTREE,
  KEY `e_Deptid` (`e_Deptid`),
  CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`e_Deptid`) REFERENCES `dept` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=335 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('330', '5201314', '222', '$2a$10$hur4Q0640ZBb3fDmcnULge1hF3n2xDLovI.sOjn9cFfaQN9cUFI5W', '任卫国', '1', '22', '1888888888', 'https://efps-sys.oss-cn-hangzhou.aliyuncs.com/e64d5874-18ea-49b5-8c02-e882b334b9d1.jpg', '2025-01-10 17:08:44.000000', '2025-02-10 21:00:59.279000', '1', '46');
INSERT INTO `emp` VALUES ('331', '999521', '123', '$2a$10$JfQnBtJ.AwdDisKhg8gUUuvJTc4rSG.f03xaD7QHJif354tJUR5XW', '小美', '0', '21', '100000000', 'https://efps-sys.oss-cn-hangzhou.aliyuncs.com/d9408693-8e2a-4bd1-8374-e6a4f09f6503.png', '2025-02-10 21:02:15.000000', '2025-02-10 21:08:16.994000', '1', '46');
INSERT INTO `emp` VALUES ('332', '9898989', '456', '$2a$10$7IErJsybvIBqud4ecb3VnurzZvRDLuQtONRpeNK/OQ.7jwOe9UZdG', '小鹏', '1', '23', '6666666', 'https://efps-sys.oss-cn-hangzhou.aliyuncs.com/4fefc170-edd6-4558-aa69-98c5a76aded5.jpeg', '2025-02-10 21:06:04.000000', '2025-02-10 21:08:23.555000', '1', '47');
INSERT INTO `emp` VALUES ('333', '55665566', '789', '$2a$10$sgyJFPZV9OP61deqMlOYAORE4cWKuPSoPGYjlsxIbIeOw3o3j/bR.', '小升', '1', '23', '111222333', 'https://efps-sys.oss-cn-hangzhou.aliyuncs.com/e7913b12-1a9e-44bd-b2fb-4a7140d47130.jpg', '2025-02-10 21:06:47.000000', '2025-02-10 21:08:28.590000', '1', '48');
INSERT INTO `emp` VALUES ('334', '147258369', '000', '$2a$10$l6BdZ6bXW3ayvZuNmuJ98OMOuJIkc1FnxA6YaKhxLEK1jedLT8T5C', '小旗', '1', '23', '77778888', 'https://efps-sys.oss-cn-hangzhou.aliyuncs.com/a9604a17-98b0-4e7e-a119-c5dbe50e71e4.jpg', '2025-02-10 21:07:33.000000', '2025-02-10 21:08:33.069000', '1', '53');
