/*
Navicat MySQL Data Transfer

Source Server         : d
Source Server Version : 80200
Source Host           : localhost:3306
Source Database       : image_search

Target Server Type    : MYSQL
Target Server Version : 80200
File Encoding         : 65001

Date: 2025-04-21 22:29:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int NOT NULL AUTO_INCREMENT,
  `d_total` int NOT NULL,
  `d_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `d_avatarpath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `d_createtime` date DEFAULT NULL,
  `d_updatetime` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `d_name` (`d_name`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('46', '1', '管理部', '', '2024-08-12', '2025-04-20');
INSERT INTO `dept` VALUES ('49', '1', '临时部', '', null, '2025-04-20');
INSERT INTO `dept` VALUES ('54', '0', '优越', null, '2025-04-19', '2025-04-19');
INSERT INTO `dept` VALUES ('55', '0', '优胜', null, '2025-04-19', '2025-04-19');
INSERT INTO `dept` VALUES ('56', '0', '优幸', null, '2025-04-19', '2025-04-19');

-- ----------------------------
-- Table structure for dynamic_routes
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_routes`;
CREATE TABLE `dynamic_routes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parentRouteId` int DEFAULT NULL COMMENT '父路由id',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组件名',
  `icon` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图标',
  `alias` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '别名',
  `state` int DEFAULT NULL COMMENT '“1”启用，“0”禁用',
  `sort` int DEFAULT NULL COMMENT '排序顺序，数字越小越靠前',
  `value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址值',
  `redirect` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '类型',
  `discription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `createUserId` int DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=240 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of dynamic_routes
-- ----------------------------
INSERT INTO `dynamic_routes` VALUES ('1', '0', 'homePage', 'home', '首页', '1', '0', '/home', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('9', '1', 'noticesPage', 'chat', '公告通知', '1', '6', 'notices', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('10', '1', '', 'control-platform', '系统管理', '1', '7', 'system-manage', '', 'MENU', '', null);
INSERT INTO `dynamic_routes` VALUES ('11', '10', 'userManage', '', '用户管理', '1', '1', 'user-manage', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('12', '10', 'deptManage', '', '部门管理', '1', '2', 'dept-manage', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('13', '10', 'settingsPage', 'setting-1', '系统设置', '1', '3', 'system-settings', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('237', '1', 'picPage', null, '以图搜图', '1', '8', 'pic', null, 'LINK', null, null);
INSERT INTO `dynamic_routes` VALUES ('238', '1', 'picSetPage', null, '图源管理', '1', '9', 'picSet', null, 'LINK', null, null);

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int NOT NULL AUTO_INCREMENT,
  `e_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `e_username` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `e_password` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `e_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `e_gender` int DEFAULT NULL,
  `e_age` int DEFAULT NULL,
  `e_phone` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=338 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('335', '222', '222', '$2a$10$r4DnZ3ke.9nkoccTUJ.Xdu8GFiq2HVB.5wZkYQKuMjB9wroT/f66C', null, null, null, '222', null, '2025-04-19 17:37:41.906000', '2025-04-19 17:37:41.906000', '1', '46');
INSERT INTO `emp` VALUES ('337', '8999', '8999', '$2a$10$4p9/SRbEzUNyGHUpZ8G1o.fTWjJja.QOR1D52fFgXRKB4.ZFkRHsO', null, null, null, '8999', null, '2025-04-20 10:05:34.160000', '2025-04-20 10:05:34.160000', '1', '49');

-- ----------------------------
-- Table structure for emp_menu
-- ----------------------------
DROP TABLE IF EXISTS `emp_menu`;
CREATE TABLE `emp_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `e_id` int NOT NULL,
  `m_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of emp_menu
-- ----------------------------
INSERT INTO `emp_menu` VALUES ('17', '335', '1');
INSERT INTO `emp_menu` VALUES ('18', '335', '5');

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
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of emp_role
-- ----------------------------
INSERT INTO `emp_role` VALUES ('49', '335', '2');
INSERT INTO `emp_role` VALUES ('51', '337', '3');

-- ----------------------------
-- Table structure for important_msg
-- ----------------------------
DROP TABLE IF EXISTS `important_msg`;
CREATE TABLE `important_msg` (
  `id` int NOT NULL AUTO_INCREMENT,
  `header` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `author` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of important_msg
-- ----------------------------
INSERT INTO `important_msg` VALUES ('17', '添加用户说明', '当创建新用户时管理员或者超级管理员需赋予用户可访问的路由页面', '2025-02-11 10:53:37', '2025-02-11 10:53:37', 'RENWEIGUO', '1');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `m_id` int NOT NULL AUTO_INCREMENT,
  `m_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `m_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `m_sign` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '', '用户个人的基本操作', 'emp');
INSERT INTO `menu` VALUES ('5', '', '超级管理员的基本操作', 'admin');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `r_id` int NOT NULL AUTO_INCREMENT,
  `r_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `r_info` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('2', 'admin', '管理员');
INSERT INTO `role` VALUES ('3', 'emp', '普通用户');

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
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of role_routes
-- ----------------------------
INSERT INTO `role_routes` VALUES ('16', '2', '1');
INSERT INTO `role_routes` VALUES ('24', '2', '9');
INSERT INTO `role_routes` VALUES ('25', '2', '10');
INSERT INTO `role_routes` VALUES ('26', '2', '11');
INSERT INTO `role_routes` VALUES ('27', '2', '12');
INSERT INTO `role_routes` VALUES ('28', '2', '13');
INSERT INTO `role_routes` VALUES ('101', '2', '237');
INSERT INTO `role_routes` VALUES ('102', '2', '238');

-- ----------------------------
-- Table structure for youda
-- ----------------------------
DROP TABLE IF EXISTS `youda`;
CREATE TABLE `youda` (
  `milvus_id` text,
  `image_path` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of youda
-- ----------------------------
INSERT INTO `youda` VALUES ('457480463690760861', 'youda\\89d54030-a050-4347-ae8c-c04b8708b390.jpg');

-- ----------------------------
-- Table structure for youding
-- ----------------------------
DROP TABLE IF EXISTS `youding`;
CREATE TABLE `youding` (
  `milvus_id` text,
  `image_path` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of youding
-- ----------------------------
INSERT INTO `youding` VALUES ('457470347698263788', 'youding\\9dededd322f7a6172f9d6d51e7cbde41.jpeg');
INSERT INTO `youding` VALUES ('457470347698263789', 'youding\\a2c4152eec54489d7aaa6e3920d51d11.jpeg');
INSERT INTO `youding` VALUES ('457470347698263790', 'youding\\background.jpg');
INSERT INTO `youding` VALUES ('457470347698263791', 'youding\\bb1ab3377b6b00d06ac7c5382dfd806a.jpg');
INSERT INTO `youding` VALUES ('457470347698263792', 'youding\\c012e44d1339ab917f96b945eed5b2b4.jpeg');

-- ----------------------------
-- Table structure for youyue
-- ----------------------------
DROP TABLE IF EXISTS `youyue`;
CREATE TABLE `youyue` (
  `milvus_id` text,
  `image_path` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of youyue
-- ----------------------------
INSERT INTO `youyue` VALUES ('457470347698263844', 'youyue\\7fcf0880b902012d844ce4adc17438f9.jpg');
INSERT INTO `youyue` VALUES ('457470347698263846', 'youyue\\7a0c4e304832165ab6db96d8c7728e9f.jpeg');
INSERT INTO `youyue` VALUES ('457470347698263848', 'youyue\\9dededd322f7a6172f9d6d51e7cbde41.jpeg');
INSERT INTO `youyue` VALUES ('457470347698263850', 'youyue\\a2c4152eec54489d7aaa6e3920d51d11.jpeg');
INSERT INTO `youyue` VALUES ('457470347698263852', 'youyue\\background.jpg');
INSERT INTO `youyue` VALUES ('457470347698263854', 'youyue\\bb1ab3377b6b00d06ac7c5382dfd806a.jpg');
INSERT INTO `youyue` VALUES ('457470347698263856', 'youyue\\c012e44d1339ab917f96b945eed5b2b4.jpeg');
