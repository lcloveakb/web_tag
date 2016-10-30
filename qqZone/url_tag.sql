/*
Navicat MySQL Data Transfer

Source Server         : evm2
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : url

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-10-30 21:41:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for url_tag
-- ----------------------------
DROP TABLE IF EXISTS `url_tag`;
CREATE TABLE `url_tag` (
  `id` int(11) NOT NULL,
  `url` varchar(255) NOT NULL,
  `urlName` varchar(255) NOT NULL,
  `imgName` varchar(255) NOT NULL,
  `userId` int(11) NOT NULL,
  `canDel` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of url_tag
-- ----------------------------
INSERT INTO `url_tag` VALUES ('1', 'https://www.baidu.com/', '百度', '1.jpg', '1', '0');
INSERT INTO `url_tag` VALUES ('2', 'https://github.com/', 'github', '2.jpg', '1', '0');
INSERT INTO `url_tag` VALUES ('3', 'http://weibo.com/login.php', '微博', '3.jpg', '1', '0');
INSERT INTO `url_tag` VALUES ('4', 'http://www.163.com/', '网易', '4.jpg', '1', '0');
INSERT INTO `url_tag` VALUES ('5', 'http://tieba.baidu.com/', '贴吧', '5.jpg', '11', '1');
INSERT INTO `url_tag` VALUES ('6', 'http://image.baidu.com/', '百度图片', '6.jpg', '11', '1');
INSERT INTO `url_tag` VALUES ('7', 'https://baike.baidu.com/', '百科', '7.jpg', '11', '1');
INSERT INTO `url_tag` VALUES ('8', 'http://www.111cn.net/', '一聚教程', '8.jpg', '22', '1');
