/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : osmessage

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-01-30 17:30:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `buffer1`
-- ----------------------------
DROP TABLE IF EXISTS `buffer1`;
CREATE TABLE `buffer1` (
  `buffer1_id` int(20) NOT NULL AUTO_INCREMENT,
  `Message` varchar(200) NOT NULL,
  `Data` varchar(200) NOT NULL,
  `ContentNum` int(100) DEFAULT NULL,
  `FreeSpaceNum` int(100) DEFAULT NULL,
  PRIMARY KEY (`buffer1_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14426 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buffer1
-- ----------------------------

-- ----------------------------
-- Table structure for `buffer2`
-- ----------------------------
DROP TABLE IF EXISTS `buffer2`;
CREATE TABLE `buffer2` (
  `buffer2_id` int(20) NOT NULL AUTO_INCREMENT,
  `Message` varchar(200) NOT NULL,
  `Data` varchar(200) NOT NULL,
  `ContentNum` int(100) DEFAULT NULL,
  `FreeSpaceNum` int(100) DEFAULT NULL,
  PRIMARY KEY (`buffer2_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8354 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buffer2
-- ----------------------------

-- ----------------------------
-- Table structure for `buffer3`
-- ----------------------------
DROP TABLE IF EXISTS `buffer3`;
CREATE TABLE `buffer3` (
  `buffer3_id` int(20) NOT NULL AUTO_INCREMENT,
  `Message` varchar(200) NOT NULL,
  `Data` varchar(200) NOT NULL,
  `ContentNum` int(100) DEFAULT NULL,
  `FreeSpaceNum` int(100) DEFAULT NULL,
  PRIMARY KEY (`buffer3_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4175 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buffer3
-- ----------------------------

-- ----------------------------
-- Table structure for `param`
-- ----------------------------
DROP TABLE IF EXISTS `param`;
CREATE TABLE `param` (
  `p_id` int(10) NOT NULL AUTO_INCREMENT,
  `buffer1Size` int(20) NOT NULL,
  `buffer2Size` int(20) NOT NULL,
  `buffer3Size` int(20) NOT NULL,
  `putBuffer1Num` int(20) NOT NULL,
  `moveBuffer2Num` int(20) NOT NULL,
  `moveBuffer3Num` int(20) NOT NULL,
  `getBuffer2Num` int(20) NOT NULL,
  `getBuffer3Num` int(20) NOT NULL,
  `putSpeed` int(50) NOT NULL,
  `moveSpeed` int(50) NOT NULL,
  `getSpeed` int(50) NOT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of param
-- ----------------------------
INSERT INTO `param` VALUES ('1', '4', '3', '3', '3', '2', '2', '3', '3', '20', '20', '20');

-- ----------------------------
-- Table structure for `result`
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `rs_id` int(100) NOT NULL AUTO_INCREMENT,
  `Runtime` varchar(200) NOT NULL,
  `BufferDataNum` int(200) NOT NULL,
  `putInBufferNum` int(200) NOT NULL,
  `getOutBufferNum` int(200) NOT NULL,
  `AvgBufferNum` int(100) NOT NULL,
  PRIMARY KEY (`rs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('1', '100057', '4', '34', '30', '1');
