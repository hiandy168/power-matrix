/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.15 : Database - mediacenter
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `mc_article_info` */

CREATE TABLE `mc_article_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT '' COMMENT '文章标题',
  `title_pic` varchar(200) DEFAULT '' COMMENT '标题小图片',
  `source` varchar(20) DEFAULT '惠家有' COMMENT '文章来源：惠家有|新浪新闻|网易新闻等等',
  `author` varchar(20) DEFAULT NULL COMMENT '作者',
  `author_id` varchar(11) DEFAULT NULL COMMENT '作者id',
  `editor` varchar(20) DEFAULT NULL COMMENT '编辑人',
  `editor_id` varchar(11) DEFAULT NULL COMMENT '编辑人id',
  `release_type` char(2) DEFAULT '01' COMMENT '发布状态 01:待发布|02:已发布|03:草稿箱|04:回收站',
  `release_time` datetime DEFAULT NULL COMMENT '发布时间',
  `article_type_id` int(11) DEFAULT NULL COMMENT '文章分类id',
  `reader_count` int(11) DEFAULT '0' COMMENT '阅读数量',
  `thumbs_up_count` int(11) DEFAULT '0' COMMENT '点赞数量',
  `share_count` int(11) DEFAULT '0' COMMENT '分享数量',
  `top_type` char(2) DEFAULT '02' COMMENT '置顶状态 01:置顶 02未置顶',
  `source_link` varchar(450) DEFAULT '' COMMENT '原文链接 如果文章来源是第三方网站',
  `html_content` longtext COMMENT '文章的html文档',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `to_release_source` varchar(2) DEFAULT '03' COMMENT '待发布文章的来源：02已发布撤回的 03草稿箱提交的 04回收站还原的',
  `remark` varchar(40) DEFAULT '' COMMENT '备注|驳回原因等',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `mc_article_info` */

insert  into `mc_article_info`(`id`,`title`,`title_pic`,`source`,`author`,`author_id`,`editor`,`editor_id`,`release_type`,`release_time`,`article_type_id`,`reader_count`,`thumbs_up_count`,`share_count`,`top_type`,`source_link`,`html_content`,`create_time`,`update_time`,`to_release_source`,`remark`) values (1,'1','http://image-family.huijiayou.cn/cfiles/staticfiles/upload/2716b/d3d9daeba5434d6eb7f98d4105ede0ba.jpg','惠家有','1','1','1','1','02','2017-06-16 17:32:55',1,12340,122340,1634,'02','',NULL,'2017-06-16 17:33:01','2017-06-16 17:33:04','03',' '),(2,'2','http://image-family.huijiayou.cn/cfiles/staticfiles/upload/2716b/a7abec07ec314f8a877498ceb01eb3c5.jpg','惠家有','1','1','1','1','02','2017-06-16 17:33:41',1,2310,124,125346,'02','',NULL,'2017-06-16 17:33:48','2017-06-16 17:33:50','03',' '),(3,'3','http://image-family.huijiayou.cn/cfiles/staticfiles/upload/299a5/6a0cef574fdb4645bdb68d325c7db7a7.jpg','惠家有','1','1','1','1','02','2017-06-16 17:34:00',1,64560,34520,126568,'02','',NULL,'2017-06-16 17:34:04','2017-06-16 17:34:07','03',' '),(4,'4','http://image-family.huijiayou.cn/cfiles/staticfiles/upload/29959/44e400d7ae2b4f0eb59022e2f2824fd0.jpg','惠家有','1','1','1','1','02','2017-06-16 17:34:20',1,342510,3520,1234342,'02','',NULL,'2017-06-16 17:34:37','2017-06-16 17:34:39','03',' '),(5,'5','http://image-family.huijiayou.cn/cfiles/staticfiles/upload/29a1a/d2ecce6d745a4774902d33f4b88b335f.jpg','惠家有','2','2','2','2','02','2017-06-16 17:34:59',2,342340,36740,15573,'02','',NULL,'2017-06-16 17:35:04','2017-06-16 17:35:05','03',' '),(6,'6','http://image-family.huijiayou.cn/cfiles/staticfiles/imzoom/29a16/03e354480a344440a539beb76f949536.jpg','惠家有','2','2','2','2','02','2017-06-16 17:35:19',2,754320,1243,86575,'02','',NULL,'2017-06-16 17:35:24','2017-06-16 17:35:26','03',' ');

/*Table structure for table `mc_article_type` */

CREATE TABLE `mc_article_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT '' COMMENT '分类名称',
  `create_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `exta` varchar(20) DEFAULT '' COMMENT '扩展a',
  `extb` varchar(20) DEFAULT '' COMMENT '扩展b',
  `extc` varchar(20) DEFAULT '' COMMENT '扩展c',
  `extd` varchar(20) DEFAULT '' COMMENT '扩展d',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `mc_article_type` */

insert  into `mc_article_type`(`id`,`name`,`create_time`,`create_user_id`,`update_time`,`update_user_id`,`exta`,`extb`,`extc`,`extd`) values (1,'海外购','2017-06-16 16:17:48',1,'2017-06-16 16:17:52',1,'','','',''),(2,'生活电器','2017-06-16 16:22:04',1,'2017-06-16 16:22:16',2,'','','',''),(4,'厨房用品','2017-06-21 15:34:21',1,'2017-06-21 15:34:21',1,'','','',''),(5,'布艺家纺','2017-06-21 15:34:36',1,'2017-06-28 13:53:03',1,'','','',''),(7,'美妆个护','2017-06-21 17:33:08',1,'2017-06-21 17:33:08',1,'','','','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
