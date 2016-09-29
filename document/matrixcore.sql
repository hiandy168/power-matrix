/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.28 : Database - matrixcore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`matrixcore` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `matrixcore`;

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'zid',
  `company_name` varchar(50) DEFAULT NULL COMMENT '商户名称',
  `flag` int(6) DEFAULT NULL COMMENT '是否删除 1否 2是',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125017 DEFAULT CHARSET=utf8;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` varchar(50) NOT NULL,
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(20) DEFAULT NULL COMMENT '角色描述',
  `flag` int(6) DEFAULT '1' COMMENT '是否删除 1否 2是',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_user_id` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user_id` int(11) DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `role_function` */

DROP TABLE IF EXISTS `role_function`;

CREATE TABLE `role_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'zid',
  `role_id` int(11) DEFAULT NULL COMMENT 'role表主键',
  `sys_function_id` int(11) DEFAULT NULL COMMENT 'sys_function表主键',
  `flag` int(6) DEFAULT NULL COMMENT '是否删除 1否 2是',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `sys_function` */

DROP TABLE IF EXISTS `sys_function`;

CREATE TABLE `sys_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'zid',
  `company_id` int(11) NOT NULL DEFAULT '1' COMMENT '1为惠家有|还有其他商户|company表主键|据此过滤权限树',
  `name` varchar(20) NOT NULL COMMENT '功能名称 导航栏与菜单栏所显示的名称',
  `parent_id` varchar(12) NOT NULL COMMENT '父节点。root为0 其下为:商户->导航栏->一级菜单栏->二级菜单栏->页面按钮',
  `seqnum` int(6) NOT NULL COMMENT '顺序码 同一层次显示顺序：导航栏 一级菜单栏 二级菜单栏 对应的显示顺序',
  `nav_type` int(6) NOT NULL COMMENT '1 横向导航栏|2 为菜单栏|3 页面按钮|4 内部跳转页面',
  `style_class` varchar(20) DEFAULT NULL COMMENT '此项针对一级菜单栏 如：inbox   <a href="#example" class="inbox">开发者快速入门</a>',
  `style_key` varchar(20) DEFAULT NULL COMMENT '此项针对一级菜单栏 如：example  <ul id="example">',
  `func_url` varchar(255) DEFAULT NULL COMMENT '此项针对二级菜单栏 如：example/pageFormExample.do',
  `flag` int(6) DEFAULT '1' COMMENT '是否删除 1否 2是 3新加(数据库不会有此状态，只在页面新增节点时做判断用)',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'zid',
  `company_id` int(11) DEFAULT NULL COMMENT '1为惠家有|还有其他商户|company表主键',
  `user_name` varchar(25) DEFAULT '' COMMENT '用户姓名',
  `password` varchar(25) DEFAULT '' COMMENT '密码',
  `id_number` varchar(20) DEFAULT '' COMMENT '身份证号',
  `sex` int(6) DEFAULT '2' COMMENT '性别 1：男 2：女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `email` int(20) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `api_code_UNIQUE` (`password`)
) ENGINE=InnoDB AUTO_INCREMENT=1966 DEFAULT CHARSET=utf8 COMMENT='API表格';

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'zid',
  `user_id` int(11) DEFAULT NULL COMMENT 'user_info 表 主键',
  `role_id` int(11) DEFAULT NULL COMMENT 'role表主键',
  `flag` int(6) DEFAULT NULL COMMENT '是否删除 1否 2是',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
