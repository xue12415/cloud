/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : cloudbd02

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-06-10 15:00:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptNo` bigint(20) NOT NULL AUTO_INCREMENT,
  `deptName` varchar(60) DEFAULT NULL,
  `db_source` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`deptNo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '开发部', 'cloudbd02');
INSERT INTO `dept` VALUES ('2', '人事部', 'cloudbd02');
INSERT INTO `dept` VALUES ('3', '运维部', 'cloudbd02');
INSERT INTO `dept` VALUES ('4', '市场部', 'cloudbd02');
INSERT INTO `dept` VALUES ('5', '销售部', 'cloudbd02');
INSERT INTO `dept` VALUES ('6', '财务部', 'cloudbd02');
INSERT INTO `dept` VALUES ('7', 'asdf', 'cloudbd02');
