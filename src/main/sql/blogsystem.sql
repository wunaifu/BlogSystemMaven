/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.51 : Database - blogsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blogsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blogsystem`;

/*Table structure for table `collect_tab` */

DROP TABLE IF EXISTS `collect_tab`;

CREATE TABLE `collect_tab` (
  `collectId` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `essayId` int(11) DEFAULT NULL COMMENT 'essay表id',
  `collectorId` int(11) DEFAULT NULL COMMENT '收藏者id',
  `collectTime` datetime DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`collectId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `collect_tab` */

insert  into `collect_tab`(`collectId`,`essayId`,`collectorId`,`collectTime`) values (3,1,2,'2017-07-05 20:56:14'),(4,2,2,'2017-07-05 20:56:28'),(5,5,2,'2017-07-05 21:56:12'),(6,6,3,'2017-07-06 00:08:13'),(8,6,1,'2017-07-06 00:55:13'),(9,5,5,'2017-07-06 00:58:26'),(15,1,7,'2017-07-07 08:13:22'),(16,3,7,'2017-07-07 08:15:03'),(17,5,7,'2017-07-07 08:15:33'),(18,14,6,'2017-07-07 08:18:32'),(19,6,6,'2017-07-07 08:19:49'),(20,14,2,'2017-07-07 09:30:06');

/*Table structure for table `discuss_tab` */

DROP TABLE IF EXISTS `discuss_tab`;

CREATE TABLE `discuss_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号,自增长',
  `essayId` int(11) DEFAULT NULL COMMENT '被评论的文章ID',
  `discusserId` int(11) DEFAULT NULL COMMENT '评论者ID',
  `discussContent` text COMMENT '评论内容',
  `discussTime` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `discuss_tab` */

/*Table structure for table `essay_tab` */

DROP TABLE IF EXISTS `essay_tab`;

CREATE TABLE `essay_tab` (
  `essayId` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `userId` int(11) DEFAULT NULL COMMENT '发帖人ID',
  `essayTitle` varchar(60) DEFAULT NULL COMMENT '标题',
  `essayContent` text COMMENT '内容文字',
  `essayImage` varchar(225) DEFAULT NULL COMMENT '图片',
  `sendTime` datetime DEFAULT NULL COMMENT '时间',
  `likesAmount` int(11) DEFAULT '0' COMMENT '点赞数',
  `discussAmount` int(11) DEFAULT '0' COMMENT '评论数',
  `collectAmount` int(11) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`essayId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `essay_tab` */

/*Table structure for table `friends_tab` */

DROP TABLE IF EXISTS `friends_tab`;

CREATE TABLE `friends_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号,自增长',
  `hisId` int(11) DEFAULT NULL COMMENT '被关注的人的Id',
  `myId` int(11) DEFAULT NULL COMMENT '关注人的ID',
  `beizhu` varchar(225) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `friends_tab` */

/*Table structure for table `likes_tab` */

DROP TABLE IF EXISTS `likes_tab`;

CREATE TABLE `likes_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号,自增长',
  `discussId` int(11) DEFAULT NULL COMMENT '被点赞的评论ID',
  `likeserId` int(11) DEFAULT NULL COMMENT '点赞者ID',
  `likesTime` datetime DEFAULT NULL COMMENT '点赞时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `likes_tab` */

/*Table structure for table `user_tab` */

DROP TABLE IF EXISTS `user_tab`;

CREATE TABLE `user_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号,自增长(用户ID)',
  `phone` varchar(225) NOT NULL COMMENT '联系方式(登录账号)',
  `password` varchar(225) DEFAULT NULL COMMENT '密码',
  `name` varchar(225) DEFAULT '未填写' COMMENT '姓名',
  `nickname` varchar(225) DEFAULT '未填写' COMMENT '用户昵称',
  `age` int(11) DEFAULT '0' COMMENT '年龄',
  `gender` varchar(4) DEFAULT '男' COMMENT '性别:0表示男，1表示女',
  `address` varchar(225) DEFAULT '未填写' COMMENT '联系地址',
  `introduction` text COMMENT '个人简介',
  `type` int(11) DEFAULT '0' COMMENT '用户类型（0表示普通用户，1表示管理员）',
  `profession` varchar(225) DEFAULT NULL COMMENT '职业',
  PRIMARY KEY (`id`),
  UNIQUE KEY `phoneunique` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `user_tab` */


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
