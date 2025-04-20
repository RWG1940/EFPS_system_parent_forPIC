/*
Navicat MySQL Data Transfer

Source Server         : d
Source Server Version : 80200
Source Host           : localhost:3306
Source Database       : efps_system

Target Server Type    : MYSQL
Target Server Version : 80200
File Encoding         : 65001

Date: 2025-04-19 16:18:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dynamic_routes
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_routes`;
CREATE TABLE `dynamic_routes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parentRouteId` int DEFAULT NULL COMMENT '父路由id',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组件名',
  `icon` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图标',
  `alias` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '别名',
  `state` int DEFAULT NULL COMMENT '“1”启用，“0”禁用',
  `sort` int DEFAULT NULL COMMENT '排序顺序，数字越小越靠前',
  `value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地址值',
  `redirect` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '类型',
  `discription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `createUserId` int DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=237 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of dynamic_routes
-- ----------------------------
INSERT INTO `dynamic_routes` VALUES ('1', '0', 'homePage', 'home', '首页', '1', '0', '/home', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('2', '1', 'flightPlanPage', 'assignment', '飞行计划', '1', '2', 'flight-plan', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('3', '1', '', 'tower-3', '指挥控制', '1', '3', 'command-control', '', 'MENU', '', null);
INSERT INTO `dynamic_routes` VALUES ('4', '3', 'authPage', '', '区域管制', '1', '1', 'areaControl', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('5', '3', 'authPage', '', '塔台管制', '1', '2', 'towerControl', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('6', '3', 'authPage', '', '放行地面合并管制', '1', '3', 'releaseGroundControl', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('7', '1', 'airSpaceTrendsPage', 'cloud', '空域动态', '1', '4', 'airspace-status', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('8', '1', 'aircraftsTrendsPage', 'earth', '航班动态', '1', '5', 'flight-status', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('9', '1', 'noticesPage', 'chat', '公告通知', '1', '6', 'notices', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('10', '1', '', 'control-platform', '系统管理', '1', '7', 'system-manage', '', 'MENU', '', null);
INSERT INTO `dynamic_routes` VALUES ('11', '10', 'userManage', '', '用户管理', '1', '1', 'user-manage', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('12', '10', 'deptManage', '', '部门管理', '1', '2', 'dept-manage', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('13', '10', 'settingsPage', 'setting-1', '系统设置', '1', '3', 'system-settings', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('14', '1', 'dashboard', 'dashboard', '仪表盘', '1', '1', 'dashboard', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('15', '0', 'areaControlPage', '', '区域管制页', '1', '1', '/command-control/areaControl', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('16', '0', 'towerControlPage', '', '塔台管制页', '1', '1', '/command-control/towerControl', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('234', '0', 'releaseGroundControlPage', '', '放行地面合并管制页', '1', '1', '/command-control/releaseGroundControl', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('235', '1', 'airInfoPage', 'system-interface', '航班信息', '1', '1', 'aircrafts-info', '', 'LINK', '', '330');
INSERT INTO `dynamic_routes` VALUES ('236', '0', 'airScreenPage', '', '航班大屏', '1', '999', '/airScreen', '', 'LINK', '', '330');
