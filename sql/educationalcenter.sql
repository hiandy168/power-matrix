/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.34 : Database - educationalcenter
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `t_classes` */

CREATE TABLE `t_classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(100) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL COMMENT '班级编码',
  `school_name` varchar(100) DEFAULT NULL COMMENT '学校名称',
  `grade_name` varchar(50) DEFAULT NULL COMMENT '年级名称',
  `class_name` varchar(50) DEFAULT NULL COMMENT '班级名称',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_classes` */

insert  into `t_classes`(`id`,`uuid`,`code`,`school_name`,`grade_name`,`class_name`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,'asdasd','C198797','浙江建工','大学一年级','土木工程专业1501','a','2017-03-07 10:36:08','a','2017-03-07 10:36:11'),(2,'gfdfa','C268676','浙江建工','大学一年级','土木工程专业1502','a','2017-03-07 14:12:52','a','2017-03-07 14:12:55'),(3,'adfadsf','C376765','浙江建工','大学二年级','建筑与土木工程专业1401','a','2017-03-07 14:14:10','a','2017-03-07 14:14:13');

/*Table structure for table `t_exam_answer` */

CREATE TABLE `t_exam_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(100) DEFAULT NULL,
  `paper_code` varchar(50) DEFAULT NULL COMMENT '试卷编号 t_exam_pager表编码',
  `student_code` varchar(50) DEFAULT NULL,
  `answer` longtext COMMENT '学生答题答案',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_exam_answer` */

insert  into `t_exam_answer`(`id`,`uuid`,`paper_code`,`student_code`,`answer`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,'vdeq123acage','P85679870456','S1489072405115','[{\"code\":\"Q76831253356788\",\"count\":1,\"map\":{\"a1\":\"A\"}},{\"code\":\"Q76831253356799\",\"count\":2,\"map\":{\"a1\":\"A\",\"a2\":\"C\"}}]','S1489072405115','2017-03-16 15:58:35',NULL,NULL),(3,'81bc8960df1c43c99c06f787628df859','P1489501441709','S1489072405115','[{\"code\":\"Q76831253356788\",\"count\":1,\"map\":{\"a1\":\"A\"}},{\"code\":\"Q76831253356799\",\"count\":2,\"map\":{\"a1\":\"A\",\"a2\":\"B\"}},{\"code\":\"Q76831253356810\",\"count\":2,\"map\":{\"a1\":\"C\",\"a2\":\"D\"}}]','S1489072405115','2017-03-16 22:05:05',NULL,NULL),(4,'69aacfa35863481485ab3a63d6e54f93','P1489501586547','S1489072405115','[{\"code\":\"Q76831253356788\",\"count\":1,\"map\":{\"a1\":\"D\"}},{\"code\":\"Q76831253356799\",\"count\":2,\"map\":{\"a1\":\"A\",\"a2\":\"D\"}}]','S1489072405115','2017-03-16 22:05:30',NULL,NULL),(5,'8bcbcbd8a8da4938aa12c9f27ce3d74f','P1489736175407','S1489072405115','[{\"code\":\"Q76831253356788\",\"count\":1,\"map\":{\"a1\":\"A\"}},{\"code\":\"Q76831253356799\",\"count\":2,\"map\":{\"a1\":\"A\",\"a2\":\"D\"}},{\"code\":\"Q76831253356810\",\"count\":2,\"map\":{\"a1\":\"A\",\"a2\":\"B\"}}]','S1489072405115','2017-03-17 15:37:33',NULL,NULL),(6,'fe886b4fb3954a8595ed1489ac8cabd2','P1489764613755','S1489072405115','[{\"code\":\"Q76831253356788\",\"count\":1,\"map\":{\"a1\":\"A\"}},{\"code\":\"Q76831253356799\",\"count\":2,\"map\":{\"a1\":\"B\",\"a2\":\"C\"}},{\"code\":\"Q76831253356810\",\"count\":2,\"map\":{\"a1\":\"B\",\"a2\":\"D\"}}]','S1489072405115','2017-03-17 23:37:25',NULL,NULL),(7,'f41fc9c83e76443ea876b31ad2fbb92c','P85679870456','s1','[{\"code\":\"Q76831253356788\",\"count\":1,\"map\":{\"a1\":\"B\"}},{\"code\":\"Q76831253356799\",\"count\":1,\"map\":{\"a1\":\"C\"}}]','s1','2017-03-26 00:51:45',NULL,NULL),(8,'8749c8fd2c754d109f27196c860d8fa5','P1490343284798','s1','[{\"code\":\"Q76831253356788\",\"count\":1,\"map\":{\"a1\":\"B\"}},{\"code\":\"Q76831253356799\",\"count\":1,\"map\":{\"a1\":\"C\"}}]','s1','2017-03-26 00:51:53',NULL,NULL),(9,'0e8c1017d1d74d949b32c3a3ec544222','P1489736175407','s1','[{\"code\":\"Q76831253356788\",\"count\":1,\"map\":{\"a1\":\"B\"}},{\"code\":\"Q76831253356799\",\"count\":1,\"map\":{\"a1\":\"C\"}}]','s1','2017-03-26 00:52:00',NULL,NULL),(10,'1299272fd448415ea0702010f12c0db5','P1490463772995','s1','[{\"code\":\"Q76831253356799\",\"count\":1,\"map\":{\"a1\":\"A\"}},{\"code\":\"Q76831253356810\",\"count\":1,\"map\":{\"a1\":\"A\"}}]','s1','2017-03-26 15:42:25',NULL,NULL);

/*Table structure for table `t_exam_paper` */

CREATE TABLE `t_exam_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '院系编号',
  `uuid` varchar(100) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL COMMENT '试卷编号',
  `schedule_code` varchar(50) DEFAULT NULL COMMENT '排课编号  t_study_schedule 表code',
  `question_code` varchar(50) DEFAULT NULL COMMENT '题目编号',
  `student_code` varchar(50) DEFAULT '0' COMMENT '学生编号 为0时是全班答题,否则是指定的学生考题',
  `score` int(11) DEFAULT '0' COMMENT '测试题目分数',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

/*Data for the table `t_exam_paper` */

insert  into `t_exam_paper`(`id`,`uuid`,`code`,`schedule_code`,`question_code`,`student_code`,`score`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,'2343q12q312244eq324','P85679870456','SS2','Q76831253356788','0',0,'a','2017-03-11 20:57:03',NULL,NULL),(2,'2343q12q312244eq324wer','P85679870456','SS2','Q76831253356799','0',0,'a','2017-03-11 20:57:33',NULL,NULL),(7,'61fcd8307a4d4fc288b2edee50e22f8c','P1489501441709','SS3','Q76831253356788','0',0,'T1489071763988','1970-01-01 08:00:00',NULL,NULL),(8,'922be9cffafb4f12a996bbd375913715','P1489501441709','SS3','Q76831253356799','0',0,'T1489071763988','1970-01-01 08:00:00',NULL,NULL),(9,'1cae6a0ae9404bc6a5f6f62dd9263b36','P1489501441709','SS3','Q76831253356810','0',0,'T1489071763988','1970-01-01 08:00:00',NULL,NULL),(10,'8b2ce06174cf4f09950ed06b1460b57c','P1489501547114','SS3','Q76831253356799','0',0,'T1489071763988','1970-01-01 08:00:00',NULL,NULL),(11,'4710fbbfaad34068b9b9e3e42f24db73','P1489501586547','SS3','Q76831253356788','0',0,'T1489071763988','1970-01-01 08:00:00',NULL,NULL),(12,'21c63660e37f483e88976f52c1d569b5','P1489501586547','SS3','Q76831253356799','0',0,'T1489071763988','1970-01-01 08:00:00',NULL,NULL),(19,'d3ee05da781f49cfb283249240c2d5f0','P1489674999809','SS2','Q76831253356788','0',0,'T1489071763988','2017-03-16 22:36:40',NULL,NULL),(20,'e55e976e671e4777b86e7666c2ca6c91','P1489674999809','SS2','Q76831253356799','0',0,'T1489071763988','2017-03-16 22:36:40',NULL,NULL),(21,'f7c2b59c51c441028b6f154b5a788f91','P1489674999809','SS2','Q76831253356810','0',0,'T1489071763988','2017-03-16 22:36:40',NULL,NULL),(22,'d5992e28ab7049ad89182d9bc2e05d79','P1489736175407','SS2','Q76831253356788','0',0,'T1489071763988','2017-03-17 15:36:15',NULL,NULL),(23,'5577ee9453a94dbfbb5731809d152c8e','P1489736175407','SS2','Q76831253356799','0',0,'T1489071763988','2017-03-17 15:36:15',NULL,NULL),(24,'e27b74fa406c4dd9a7764eeecb2b4bf4','P1489736175407','SS2','Q76831253356810','0',0,'T1489071763988','2017-03-17 15:36:16',NULL,NULL),(25,'125ab7ff45664f40b8bdb6cc1699f0ba','P1489764613755','SS3','Q76831253356788','0',0,'T1489071763988','2017-03-17 23:30:14',NULL,NULL),(26,'050ddb4cf4184a709952d0c9830be3e1','P1489764613755','SS3','Q76831253356799','0',0,'T1489071763988','2017-03-17 23:30:14',NULL,NULL),(27,'a302d793bbfd488c8b308e1daf37eed1','P1489764613755','SS3','Q76831253356810','0',0,'T1489071763988','2017-03-17 23:30:14',NULL,NULL),(28,'e8b6c5ce87244061bea4a63a1c414b3a','P1490343284798','SS2','Q76831253356788','0',0,'T1489071763988','2017-03-24 16:14:45',NULL,NULL),(29,'42ab4fce3f184056986e31e34b900f04','P1490343284798','SS2','Q76831253356799','0',0,'T1489071763988','2017-03-24 16:14:45',NULL,NULL),(30,'6fa127aa047e4da8a057523b8fb171c0','P1490343284798','SS2','Q76831253356810','0',0,'T1489071763988','2017-03-24 16:14:45',NULL,NULL),(31,'1314837605c44fda8437174b1617c97b','P1490428650886','SS3','Q76831253356788','0',0,'T1489071763988','2017-03-25 15:57:31',NULL,NULL),(32,'762554159dd44ce38831124b608c0f1d','P1490428650886','SS3','Q76831253356799','0',0,'T1489071763988','2017-03-25 15:57:31',NULL,NULL),(33,'bd103b3f44cf44718e24ec3d677c52d6','P1490428650886','SS3','Q76831253356810','0',0,'T1489071763988','2017-03-25 15:57:31',NULL,NULL),(34,'c82a768eb3f441efbd86cdf7e1ed9cb0','P1490457329930','SS3','Q76831253356788','0',0,'T1489071763988','2017-03-25 23:55:30',NULL,NULL),(35,'3468b97b976e4a69a06cdb2d5eef9d46','P1490457329930','SS3','Q76831253356799','0',0,'T1489071763988','2017-03-25 23:55:30',NULL,NULL),(36,'bc440f681b4542ba9dabc7d3f550eff0','P1490463760445','SS3','Q76831253356788','0',0,'T1489071763988','2017-03-26 01:42:40',NULL,NULL),(37,'264a1a56906042f2a3939bfe96ac16e6','P1490463760445','SS3','Q76831253356799','0',0,'T1489071763988','2017-03-26 01:42:40',NULL,NULL),(38,'7f8938428c0a49be8acfa8694d47421f','P1490463772995','SS2','Q76831253356799','0',0,'T1489071763988','2017-03-26 01:42:53',NULL,NULL),(39,'62263dfe8adb40ae81e5293ae9ae0fef','P1490463772995','SS2','Q76831253356810','0',0,'T1489071763988','2017-03-26 01:42:53',NULL,NULL),(40,'22b770a0144249de9ef05c4ca3885266','P1490514517435','SS2','Q76831253356788','0',0,'T1489071763988','2017-03-26 15:48:37',NULL,NULL),(41,'981f470a524d466fa69b0c2108447645','P1490514517435','SS2','Q76831253356799','0',0,'T1489071763988','2017-03-26 15:48:37',NULL,NULL);

/*Table structure for table `t_exam_questions` */

CREATE TABLE `t_exam_questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '院系编号',
  `uuid` varchar(100) DEFAULT NULL COMMENT '考题表',
  `code` varchar(50) DEFAULT NULL COMMENT '题目编号',
  `dept_code` varchar(50) DEFAULT NULL COMMENT '院系编号',
  `profession_code` varchar(50) DEFAULT NULL COMMENT '专业编号',
  `lesson_code` varchar(50) DEFAULT NULL COMMENT '课程编号',
  `score` int(11) DEFAULT NULL COMMENT '基础分值',
  `type` varchar(8) DEFAULT 'T0001' COMMENT '题型：T0001：单选题；T002：多选题；T003：填空题；T004：判断题；T005：问答题',
  `content` longtext COMMENT '题目',
  `picture` int(2) DEFAULT '0' COMMENT '是否为复杂公式的图片类型题目|0:文字题目无图片，1:是图片类型题目，2:文字题目有配图',
  `url` varchar(300) DEFAULT NULL COMMENT '如果picture != 0，则为图片类型的题目，则此字段代表该图片的服务器地址',
  `options` varchar(255) DEFAULT NULL COMMENT '选择题的选项',
  `answer` longtext COMMENT '正确答案',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_exam_questions` */

insert  into `t_exam_questions`(`id`,`uuid`,`code`,`dept_code`,`profession_code`,`lesson_code`,`score`,`type`,`content`,`picture`,`url`,`options`,`answer`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,'343','Q76831253356788','1','1','L8293857',20,'T0001','已知集合A={X，X<2} , B={-1，0，1，2，3}，则A与B的交集=',0,'','[{\"tip\":\"A\",\"option\":\"{0,1}\"},{\"tip\":\"B\",\"option\":\"{0,1,2}\"},{\"tip\":\"C\",\"option\":\"{-1,0,1}\"},{\"tip\":\"D\",\"option\":\"{-1,0,1,2}\"}]','{\"code\":\"Q76831253356788\",\"count\":1,\"map\":{\"a1\":\"A\"}}','a','2017-03-11 19:08:33',NULL,NULL),(2,'123','Q76831253356799','1','1','L8293857',10,'T0002','Tommy, run! Be quick! The house is on fire!”the mother shouted, with clearly______in her voice.',0,'','[{\"tip\":\"A\",\"option\":\"anger\"},{\"tip\":\"B\",\"option\":\"rudeness\"},{\"tip\":\"C\",\"option\":\"regret\"},{\"tip\":\"D\",\"option\":\"panic\"}]','{\"code\":\"Q76831253356799\",\"count\":2,\"map\":{\"a1\":\"A\",\"a2\":\"D\"}}','a','2017-03-11 19:34:47',NULL,NULL),(3,'123','Q76831253356810','1','1','L8293857',20,'T0002','已知集合A={X，X<2} , B={-1，0，1，2，3}，则A与B的交集=',0,NULL,'[{\"tip\":\"A\",\"option\":\"qtwer\"},{\"tip\":\"B\",\"option\":\"asdw\"},{\"tip\":\"C\",\"option\":\"jkyuuyt\"},{\"tip\":\"D\",\"option\":\"34aws\"}]','{\"code\":\"Q76831253356799\",\"count\":2,\"map\":{\"a1\":\"A\",\"a2\":\"D\"}}','a','2017-03-16 20:57:31',NULL,NULL);

/*Table structure for table `t_lesson` */

CREATE TABLE `t_lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(50) DEFAULT NULL,
  `lesson_name` varchar(50) DEFAULT NULL COMMENT '课程名称',
  `code` varchar(50) DEFAULT NULL COMMENT '课程编码',
  `type_code` varchar(50) DEFAULT NULL COMMENT '课程类型编码 0必修 1选修',
  `intro` text COMMENT '课程简介',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `img_url` varchar(100) DEFAULT NULL COMMENT '书籍封面',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_lesson` */

insert  into `t_lesson`(`id`,`uuid`,`lesson_name`,`code`,`type_code`,`intro`,`create_user`,`create_time`,`update_user`,`update_time`,`img_url`) values (1,'6627360447bb4b4aaf8982a87ba8e99','高等数学(下)','L8293857','0','指相对于初等数学而言，数学的对象及方法较为繁杂的一部分。\r\n广义地说，初等数学之外的数学都是高等数学，也有将中学较深入的代数、几何以及简单的集合论初步、逻辑初步称为中等数学的，将其作为中小学阶段的初等数学与大学阶段的高等数学的过渡。\r\n通常认为，高等数学是由微积分学，较深入的代数学、几何学以及它们之间的交叉内容所形成的一门基础学科。\r\n主要内容包括：极限、微积分、空间解析几何与向量代数、级数、常微分方程。\r\n工科、理科研究生考试的基础科目。','a','2017-03-12 19:42:27','a','2017-03-12 19:42:32','gao_deng_shu_xue.jpg'),(2,'6627360447bb4b4aaf8982a87ba0368','离散数学(上)','L9970723','0','离散数学(Discrete mathematics)是研究离散量的结构及其相互关系的数学学科，是现代数学的一个重要分支。离散的含义是指不同的连接在一起的元素，主要是研究基于离散量的结构和相互间的关系，其对象一般是有限个或可数个元素。离散数学在各学科领域，特别在计算机科学与技术领域有着广泛的应用，同时离散数学也是计算机专业的许多专业课程，如程序设计语言、数据结构、操作系统、编译技术、人工智能、数据库、算法设计与分析、理论计算机科学基础等必不可少的先行课程。通过离散数学的学习，不但可以掌握处理离散结构的描述工具和方法，为后续课程的学习创造条件，而且可以提高抽象思维和严格的逻辑推理能力，为将来参与创新性的研究和开发工作打下坚实的基础。\r\n随着信息时代的到来，工业革命时代以微积分为代表的连续数学占主流的地位已经发生了变化，离散数学的重要性逐渐被人们认识。离散数学课程所传授的思想和方法，广泛地体现在计算机科学技术及相关专业的诸领域，从科学计算到信息处理，从理论计算机科学到计算机应用技术，从计算机软件到计算机硬件，从人工智能到认知系统，无不与离散数学密切相关。由于数字电子计算机是一个离散结构，它只能处理离散的或离散化了的数量关系， 因此，无论计算机科学本身，还是与计算机科学及其应用密切相关的现代科学研究领域，都面临着如何对离散结构建立相应的数学模型；又如何将已用连续数量关系建立起来的数学模型离散化，从而可由计算机加以处理。\r\n离散数学是传统的逻辑学，集合论（包括函数），数论基础，算法设计，组合分析，离散概率，关系理论，图论与树，抽象代数（包括代数系统，群、环、域等），布尔代数，计算模型（语言与自动机）等汇集起来的一门综合学科。离散数学的应用遍及现代科学技术的诸多领域。','a','2017-03-12 19:44:47','a','2017-03-12 19:44:52','li_san_shu_xue.jpg');

/*Table structure for table `t_lesson_evaluate` */

CREATE TABLE `t_lesson_evaluate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `student_code` varchar(50) DEFAULT NULL COMMENT '学生编码 t_student 表code',
  `schedule_code` varchar(50) DEFAULT NULL COMMENT '排课编码 t_study_schedule 表code',
  `score` int(4) DEFAULT '10' COMMENT '课程评分1-10分，默认10分',
  `content` text COMMENT '评价内容',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_lesson_evaluate` */

insert  into `t_lesson_evaluate`(`id`,`uuid`,`code`,`student_code`,`schedule_code`,`score`,`content`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,'fsad','asdfadf','adsfad','afasdf',10,'adfadf','adf','2017-03-07 10:54:47','asdfasdf','2017-03-07 10:54:52');

/*Table structure for table `t_lesson_faq` */

CREATE TABLE `t_lesson_faq` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(50) NOT NULL COMMENT 'uuid',
  `code` varchar(50) NOT NULL COMMENT '答疑编码',
  `parent_code` varchar(50) DEFAULT '0' COMMENT '父级编码',
  `schedule_code` varchar(50) NOT NULL COMMENT '学习排课编码',
  `content` text COMMENT '答疑内容',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='课程答疑';

/*Data for the table `t_lesson_faq` */

insert  into `t_lesson_faq`(`id`,`uuid`,`code`,`parent_code`,`schedule_code`,`content`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,'8c7f39ba85b64ba18c6cb3f876f79676','LF1489840268503','0','SS2','this is test','s1','2017-03-18 20:31:09','s1','2017-03-18 20:31:09'),(2,'b7571d46c81f479a9708eb1a1dbc0c73','LF1489840322842','0','SS2','this is test','s2','2017-03-18 20:32:03','s2','2017-03-18 20:32:03'),(3,'218bbf0045c2436e9968650c19e9035a','LF1489845189609','LF1489840268503','SS2','this is test answer ok','T1489071763988','2017-03-19 09:00:00','T1489071763988','2017-03-19 09:00:00'),(4,'74981554c4054d2dbc75496173d81bab','LF1489845216216','LF1489840268503','SS2','this is test answer yes','T1489071763988','2017-03-19 19:00:00','T1489071763988','2017-03-19 19:00:00');

/*Table structure for table `t_lesson_qrcode` */

CREATE TABLE `t_lesson_qrcode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(50) DEFAULT NULL,
  `schedule_code` varchar(50) DEFAULT NULL COMMENT '排课编码 t_study_schedule 表code',
  `qrcode_url` varchar(200) DEFAULT NULL COMMENT '二维码保存路径',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=287 DEFAULT CHARSET=utf8;

/*Data for the table `t_lesson_qrcode` */

insert  into `t_lesson_qrcode`(`id`,`uuid`,`schedule_code`,`qrcode_url`,`create_user`,`create_time`,`update_user`,`update_time`) values (209,'815b22292c604b35a9149b1b4dc4b81c','SS2','qrcode\\T1489071763988@SS2,2017-03-15-10-51.jpg',NULL,'2017-03-15 10:51:15',NULL,NULL),(210,'8530d5bb7da344b39b8161bf63e0d762','SS3','qrcode\\T1489071763988@SS3,2017-03-15-10-51.jpg',NULL,'2017-03-15 10:51:48',NULL,NULL),(211,'a331349b5b874902a2802e0c3703a3ec',NULL,'qrcode\\SS3@null,2017-03-15-10-53.jpg',NULL,'2017-03-15 10:53:31',NULL,NULL),(212,'3958eedf2a564842b658e029de5a64e2',NULL,'qrcode\\SS3@null,2017-03-15-10-54.jpg',NULL,'2017-03-15 10:54:04',NULL,NULL),(213,'b909eeeac80e4842917b25f46125632c',NULL,'qrcode\\SS3@null,2017-03-15-10-55.jpg',NULL,'2017-03-15 10:55:19',NULL,NULL),(214,'bd36dc3a3a2a47f3b20aebf63dd5dcb5','SS3','qrcode\\T1489071763988@SS3,2017-03-15-10-55.jpg',NULL,'2017-03-15 10:55:33',NULL,NULL),(215,'ebe8852d3978479da88ad5d7fa47ff8c','SS3','qrcode\\T1489071763988@SS3,2017-03-15-10-55.jpg',NULL,'2017-03-15 10:55:58',NULL,NULL),(216,'c808db9411fe48deb0ce984f99555b64',NULL,'qrcode\\SS3@null,2017-03-15-10-57.jpg',NULL,'2017-03-15 10:57:05',NULL,NULL),(217,'4bb11b6f73084bd9a18627f73af60064','SS3','qrcode\\T1489071763988@SS3,2017-03-15-10-57.jpg',NULL,'2017-03-15 10:57:19',NULL,NULL),(218,'e082fbaa92594213a07f8d0d8223e447','SS3','qrcode\\T1489071763988@SS3,2017-03-15-10-57.jpg',NULL,'2017-03-15 10:57:21',NULL,NULL),(219,'c723d76dd8414e6a832cdafdab965697','SS3','qrcode\\T1489071763988@SS3,2017-03-15-10-57.jpg',NULL,'2017-03-15 10:57:21',NULL,NULL),(220,'4efb12da22044f7499900acc14654372','SS3','qrcode\\T1489071763988@SS3,2017-03-15-10-57.jpg',NULL,'2017-03-15 10:57:22',NULL,NULL),(221,'86ae03cb054f44a588ee49505ac1747c','SS3','qrcode\\T1489071763988@SS3,2017-03-15-10-57.jpg',NULL,'2017-03-15 10:57:22',NULL,NULL),(222,'1a73b26bc15048bcab1f43c7e9aa5936','SS3','qrcode\\T1489071763988@SS3,2017-03-15-10-57.jpg',NULL,'2017-03-15 10:57:23',NULL,NULL),(223,'eef6b623984b4eba84ab9a602cb33564','SS3','qrcode\\T1489071763988@SS3,2017-03-15-10-57.jpg',NULL,'2017-03-15 10:57:23',NULL,NULL),(224,'48eeeac2e70b4e84b45223a10ef22f62','SS3','qrcode\\T1489071763988@SS3,2017-03-15-10-57.jpg',NULL,'2017-03-15 10:57:24',NULL,NULL),(225,'4697c39d89ff4c1f8777c6972207533e',NULL,'qrcode\\SS3@null,2017-03-15-10-57.jpg',NULL,'2017-03-15 10:58:00',NULL,NULL),(226,'f32f523311694e76b9aadfe21255da35',NULL,'qrcode\\SS3@null,2017-03-15-10-58.jpg',NULL,'2017-03-15 10:58:04',NULL,NULL),(227,'cb195fdb22584128927788c23c82d619','SS4','qrcode\\T1489071763988@SS4,2017-03-15-10-58.jpg',NULL,'2017-03-15 10:58:10',NULL,NULL),(228,'47d2a819624243aa81b025e7b3b10d2b','SS2','qrcode\\T1489071763988@SS2,2017-03-15-11-00.jpg',NULL,'2017-03-15 11:00:29',NULL,NULL),(229,'e25852cb3e02478cb130d508f30c0b97','SS3','qrcode\\T1489071763988@SS3,2017-03-15-11-00.jpg',NULL,'2017-03-15 11:00:40',NULL,NULL),(230,'5b45b290ce4a43359f6edff80ee8d7ce','SS3','qrcode\\T1489071763988@SS3,2017-03-15-15-28.jpg',NULL,'2017-03-15 15:28:39',NULL,NULL),(231,'86caaa0d174c44ce808162dcb308d45e','SS3','qrcode\\T1489071763988@SS3,2017-03-15-15-39.jpg',NULL,'2017-03-15 15:39:16',NULL,NULL),(232,'7a980e0080574451948de339ee46d299','SS3','qrcode\\T1489071763988@SS3,2017-03-15-21-44.jpg',NULL,'2017-03-15 21:44:03',NULL,NULL),(233,'1108daf4ad3e4972bd89bdbdd94b8ab8','SS3','qrcode\\T1489071763988@SS3,2017-03-16-22-10.jpg',NULL,'2017-03-16 22:10:30',NULL,NULL),(234,'edeb5a6e0a9241cc8229895d38d585e3','SS2','qrcode\\T1489071763988@SS2,2017-03-16-22-11.jpg',NULL,'2017-03-16 22:11:39',NULL,NULL),(235,'2ee92467f40744efb8c23a19d16bf0ce','SS2','qrcode\\T1489071763988@SS2,2017-03-16-22-28.jpg',NULL,'2017-03-16 22:28:17',NULL,NULL),(236,'b15f321b28fc461cbf727277a36006c0','SS4','qrcode\\T1489071763988@SS4,2017-03-16-22-28.jpg',NULL,'2017-03-16 22:28:21',NULL,NULL),(237,'9a0e8b41040d49f781ea2905a66754cc','SS4','qrcode\\T1489071763988@SS4,2017-03-17-11-54.jpg',NULL,'2017-03-17 11:54:00',NULL,NULL),(238,'dd850661f4194bb68f3cc407dde48e31','SS2','qrcode\\T1489071763988@SS2,2017-03-17-15-33.jpg',NULL,'2017-03-17 15:33:23',NULL,NULL),(239,'ff07c94876394d67a6920a57cd39909b','SS2','qrcode\\T1489071763988@SS2,2017-03-17-15-33.jpg',NULL,'2017-03-17 15:33:26',NULL,NULL),(240,'1969d6f17aa44c8eb8170c2ee7caa234','SS4','qrcode\\T1489071763988@SS4,2017-03-17-15-33.jpg',NULL,'2017-03-17 15:33:53',NULL,NULL),(241,'8480971f024d4e4aab26d3fda1e7d9cc','SS2','qrcode\\T1489071763988@SS2,2017-03-17-23-14.jpg',NULL,'2017-03-17 23:14:38',NULL,NULL),(242,'979d86605a25478080e26bb943078559','SS4','qrcode\\T1489071763988@SS4,2017-03-17-23-14.jpg',NULL,'2017-03-17 23:14:42',NULL,NULL),(243,'8bb855d224bc4b7caac40d99bd2ba84c','SS3','qrcode\\T1489071763988@SS3,2017-03-17-23-14.jpg',NULL,'2017-03-17 23:14:46',NULL,NULL),(244,'64cd81c899db45c7930208f02904f974','L8293857','qrcode\\T1489071763988@L8293857,2017-03-21-08-19.jpg',NULL,'2017-03-21 08:19:37',NULL,NULL),(245,'7831e37d6bce4a93826233fd0404c885','L8293857','qrcode\\T1489071763988@L8293857,2017-03-21-08-20.jpg',NULL,'2017-03-21 08:20:32',NULL,NULL),(246,'cdd7c351e9ae43c7a37a4e49a53fad3d','L8293857','qrcode\\T1489071763988@L8293857,2017-03-21-08-20.jpg',NULL,'2017-03-21 08:20:35',NULL,NULL),(247,'14d3a064aa06478baa906f6792df7c75','SS4','qrcode\\T1489071763988@SS4,2017-03-21-10-36.jpg',NULL,'2017-03-21 10:36:16',NULL,NULL),(248,'717e0ba804b344e09f953aa7050f76a9','SS4','qrcode\\T1489071763988@SS4,2017-03-21-10-36.jpg',NULL,'2017-03-21 10:36:42',NULL,NULL),(249,'c3e38f7fc33f4544bd04fe800e54826d','SS4','qrcode\\T1489071763988@SS4,2017-03-21-10-39.jpg',NULL,'2017-03-21 10:39:23',NULL,NULL),(250,'12dd2f87252a40efb602e60548f30ab2','SS4','qrcode\\T1489071763988@SS4,2017-03-21-10-41.jpg',NULL,'2017-03-21 10:41:28',NULL,NULL),(251,'d4c83acf721a4da99e376cafc5988738','SS2','qrcode\\T1489071763988@SS2,2017-03-21-10-55.jpg',NULL,'2017-03-21 10:55:51',NULL,NULL),(252,'22ba01546bcf4d60bfa39c13f46f171f','SS4','qrcode\\T1489071763988@SS4,2017-03-21-11-03.jpg',NULL,'2017-03-21 11:03:36',NULL,NULL),(253,'287da59ca7294fc19279b83878c58208','L8293857','qrcode\\T1489071763988@L8293857,2017-03-21-11-08.jpg',NULL,'2017-03-21 11:08:14',NULL,NULL),(254,'0e12631dc0554408a3b607bbea9cbda7','SS4','qrcode\\T1489071763988@SS4,2017-03-21-11-10.jpg',NULL,'2017-03-21 11:10:09',NULL,NULL),(255,'bf5889cdea1d4b009309c2120e27fa74','SS4','qrcode\\T1489071763988@SS4,2017-03-21-11-10.jpg',NULL,'2017-03-21 11:10:13',NULL,NULL),(256,'8e2857cb9c724a4ba9fd088bc37b2c54','SS4','qrcode\\T1489071763988@SS4,2017-03-21-11-10.jpg',NULL,'2017-03-21 11:10:17',NULL,NULL),(257,'29db96ab5d3f407181d53e96f786c7f5','SS4','qrcode\\T1489071763988@SS4,2017-03-21-11-10.jpg',NULL,'2017-03-21 11:10:28',NULL,NULL),(258,'ef437153de774ac681f3d96543f6de50','SS2','qrcode\\T1489071763988@SS2,2017-03-21-14-29.jpg',NULL,'2017-03-21 14:29:26',NULL,NULL),(259,'fb3e63979308489a850b7ff086e3016d','SS2','qrcode\\T1489071763988@SS2,2017-03-21-14-34.jpg',NULL,'2017-03-21 14:34:06',NULL,NULL),(260,'de3a77b2aca94d4186b3a51eb9d8b668','SS2','qrcode\\T1489071763988@SS2,2017-03-21-14-53.jpg',NULL,'2017-03-21 14:53:41',NULL,NULL),(261,'aca3a8569ddd4a6b8574f83f36f5b595','SS3','qrcode\\T1489071763988@SS3,2017-03-21-15-27.jpg',NULL,'2017-03-21 15:27:59',NULL,NULL),(262,'34df171fe55046df9dd731494aaff7b7','SS3','qrcode\\T1489071763988@SS3,2017-03-24-16-11.jpg',NULL,'2017-03-24 16:12:00',NULL,NULL),(263,'2345368280974eeaa4e00ee365afba06','SS2','qrcode\\T1489071763988@SS2,2017-03-24-16-12.jpg',NULL,'2017-03-24 16:12:04',NULL,NULL),(264,'7b7169d00b27442da120ae04dc85fa27','SS2','qrcode\\T1489071763988@SS2,2017-03-24-16-12.jpg',NULL,'2017-03-24 16:12:20',NULL,NULL),(265,'201cbb47b05545abbe379208c9ce15b7','SS3','qrcode\\T1489071763988@SS3,2017-03-24-17-01.jpg',NULL,'2017-03-24 17:01:43',NULL,NULL),(266,'3a1a567fc1364006bf402650b8fdc28f','SS3','qrcode\\T1489071763988@SS3,2017-03-24-17-34.jpg',NULL,'2017-03-24 17:34:54',NULL,NULL),(267,'db8ec92910db4127a8c386e24722031c','SS4','qrcode\\T1489071763988@SS4,2017-03-24-17-40.jpg',NULL,'2017-03-24 17:40:12',NULL,NULL),(268,'3c0f17a066c84dbcb8696addb0c5a859','SS4','qrcode\\T1489071763988@SS4,2017-03-25-15-48.jpg',NULL,'2017-03-25 15:48:04',NULL,NULL),(269,'1d652cc6e3c6444c9e75810cfa790348','SS3','qrcode\\T1489071763988@SS3,2017-03-25-15-56.jpg',NULL,'2017-03-25 15:56:37',NULL,NULL),(270,'26c9f2a82dee4934ab9624613e4f3814','SS3','qrcode\\T1489071763988@SS3,2017-03-25-15-59.jpg',NULL,'2017-03-25 15:59:38',NULL,NULL),(271,'02676fcddae5412fb6b64c3a10f6e654','SS3','qrcode\\T1489071763988@SS3,2017-03-25-17-26.jpg',NULL,'2017-03-25 17:26:49',NULL,NULL),(272,'631dd08b57774d99b6c7c6dc11202f5b','SS4','qrcode/T1489071763988@SS4,2017-03-25-23-44.jpg',NULL,'2017-03-25 23:44:44',NULL,NULL),(273,'c669e70e11fb416ca0379233ca336a14','SS3','qrcode/T1489071763988@SS3,2017-03-25-23-52.jpg',NULL,'2017-03-25 23:52:56',NULL,NULL),(274,'55089a381d0c4f0dbf77b4a2dade6b7f','SS2','qrcode/T1489071763988@SS2,2017-03-25-23-52.jpg',NULL,'2017-03-25 23:52:58',NULL,NULL),(275,'9eaac7f3209047e7b1edb4ae5ceb41ad','SS4','qrcode/T1489071763988@SS4,2017-03-25-23-53.jpg',NULL,'2017-03-25 23:53:04',NULL,NULL),(276,'470e813864934fd0b650901b3dbd9798','SS3','qrcode/T1489071763988@SS3,2017-03-25-23-53.jpg',NULL,'2017-03-25 23:53:09',NULL,NULL),(277,'ea2707e9c4854b3f8f58ed9fd9d88b65','SS2','qrcode/T1489071763988@SS2,2017-03-25-23-53.jpg',NULL,'2017-03-25 23:53:12',NULL,NULL),(278,'12060d9d58dc401195cf9047a6d32a3b','SS3','qrcode/T1489071763988@SS3,2017-03-25-23-55.jpg',NULL,'2017-03-25 23:55:51',NULL,NULL),(279,'8bc76e89cf454044a9d4c90c5c413fd8','SS4','qrcode/T1489071763988@SS4,2017-03-26-15-04.jpg',NULL,'2017-03-26 15:04:06',NULL,NULL),(280,'c9ad0707cacc4243bbaa8959761c5a05','SS4','qrcode/T1489071763988@SS4,2017-03-26-15-38.jpg',NULL,'2017-03-26 15:38:26',NULL,NULL),(281,'0fc512776b2b4e258e248ff1cf40adde','SS2','qrcode/T1489071763988@SS2,2017-03-26-15-38.jpg',NULL,'2017-03-26 15:38:37',NULL,NULL),(282,'3f493ebd1c3d4f979a430bef23d9ea68','SS4','qrcode/T1489071763988@SS4,2017-03-26-15-47.jpg',NULL,'2017-03-26 15:47:06',NULL,NULL),(283,'ae13c3c6bb1d4c68802be401f8ef3e69','SS4','qrcode/T1489071763988@SS4,2017-03-26-15-47.jpg',NULL,'2017-03-26 15:47:10',NULL,NULL),(284,'de9582fa2b4c47d5a33f891701a699b2','SS4','qrcode/T1489071763988@SS4,2017-03-27-10-04.jpg',NULL,'2017-03-27 10:04:45',NULL,NULL),(285,'c93ed23ce172444b9561dac06f971f5a','SS4','qrcode/T1489071763988@SS4,2017-03-29-20-58.jpg',NULL,'2017-03-29 20:58:38',NULL,NULL),(286,'11fb068d11a84639844b7289b5c27de2','SS4','qrcode/T1489071763988@SS4,2017-03-29-20-58.jpg',NULL,'2017-03-29 20:58:43',NULL,NULL);

/*Table structure for table `t_lesson_rollcall` */

CREATE TABLE `t_lesson_rollcall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(100) NOT NULL COMMENT 'uuid',
  `code` varchar(50) NOT NULL COMMENT '编码',
  `schedule_code` varchar(50) NOT NULL COMMENT '点名编码',
  `student_code` varchar(50) NOT NULL COMMENT '课程编码',
  `verify_code` varchar(20) NOT NULL COMMENT '验证码',
  `flag_success` int(11) DEFAULT '0' COMMENT '是否点名成功 0 未成功 1 已成功',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '修改人',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `schedule_student` (`schedule_code`,`student_code`) COMMENT '唯一键约束'
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='课程点名';

/*Data for the table `t_lesson_rollcall` */

insert  into `t_lesson_rollcall`(`id`,`uuid`,`code`,`schedule_code`,`student_code`,`verify_code`,`flag_success`,`create_user`,`create_time`,`update_user`,`update_time`) values (7,'c022ae4b95eb4fbd99e98a13bcc2bab5','RC1490463680820','SS2','s1','932',1,'T1489071763988','2017-03-26 01:41:20','s1','2017-03-26 01:41:42'),(8,'5050b2382f724316948fd7dec9e5f801','RC1490792355075','SS2','s8','321',0,'T1489071763988','2017-03-29 20:59:15','T1489071763988','2017-03-29 20:59:15');

/*Table structure for table `t_lesson_sign` */

CREATE TABLE `t_lesson_sign` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(50) DEFAULT NULL,
  `student_code` varchar(50) DEFAULT NULL COMMENT '学生编码',
  `schedule_code` varchar(50) DEFAULT NULL COMMENT '排课编码  t_study_schedule 表code',
  `flag_evaluate` int(11) DEFAULT '0' COMMENT '是否已评价 0 未评价 1 已评价',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `t_lesson_sign` */

insert  into `t_lesson_sign`(`id`,`uuid`,`student_code`,`schedule_code`,`flag_evaluate`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,'b180710c8a324dc6b25d39568352645a','s1','SS2',1,NULL,'2017-03-17 14:25:06','T1489071763988','2017-03-26 01:43:18'),(2,'b180710c8a324dc6b25d39568aaba45a','s2','SS2',0,NULL,'2017-03-05 14:25:04','T1489071763988','2017-03-21 14:19:08'),(3,'b180710c8a324dc6b25d39568a156677','s3','SS2',0,NULL,'2017-03-11 14:25:01','T1489071763988','2017-03-24 16:59:25'),(5,'b180710c8a324dc6b25d39568a15645a','s9','SS2',0,NULL,'2017-03-22 14:24:58',NULL,NULL),(16,'89ac4640b97948e48ceab1a3215ca4db','s8','SS2',0,NULL,'2017-03-17 14:24:55','T1489071763988','2017-03-25 21:36:33'),(17,'b4518ac2f7e443dfa430ba7328a70d1b','S1489072405115','SS3',0,NULL,'2017-03-15 15:35:24','T1489071763988','2017-03-24 16:20:41');

/*Table structure for table `t_lesson_type` */

CREATE TABLE `t_lesson_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL COMMENT '课程类型编码',
  `name` varchar(50) DEFAULT NULL COMMENT '课程类型名称',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_lesson_type` */

insert  into `t_lesson_type`(`id`,`uuid`,`code`,`name`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,'asdf','asdf','安放的数据库里快圣诞节饭俄方','adsf','2017-03-07 11:01:14','adf','2017-03-07 11:01:17');

/*Table structure for table `t_student` */

CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL COMMENT '学生编码',
  `name` varchar(25) DEFAULT NULL COMMENT '学生姓名',
  `sex` int(2) DEFAULT '0' COMMENT '性别 0 男 1 女',
  `classes_code` varchar(50) DEFAULT NULL COMMENT '班级编码',
  `head_pic` varchar(500) DEFAULT NULL COMMENT '学生头像',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

insert  into `t_student`(`id`,`uuid`,`code`,`name`,`sex`,`classes_code`,`head_pic`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,'7127360447bb4b4aaf8982a87ba8ea21','s1','李梦瑶',1,'C198797','7cd96bf1db854121bfa010b9c79017ed.jpg','a','2017-03-07 11:06:45','a','2017-03-07 11:06:49'),(2,'7127360447bb4b4aaf8982a87ba8ea22','s2','胡远',0,'C198797','b1db66d6b4a74c95816c495e12d858e8.jpg','a','2017-03-07 14:05:41','a','2017-03-07 14:05:43'),(3,'7127360447bb4b4aaf8982a87ba8ea23','s3','张娜娜',1,'C198797','6adaa044b921437fa463c4bf8c986f5c.jpg','a','2017-03-07 14:06:16','a','2017-03-07 14:06:21'),(4,'7127360447bb4b4aaf8982a87ba8ea24','s4','徐奥文',0,'C198797','93b055a0682e443994025983fc0c9f32.jpeg','a','2017-03-07 17:13:08','a','2017-03-07 17:13:11'),(5,'7127360447bb4b4aaf8982a87ba8ea25','s5','杨慈生',0,'C198797','be7af95068db478383c0a9f5bc969578.png','a','2017-03-07 17:13:35','a','2017-03-07 17:13:37'),(6,'7127360447bb4b4aaf8982a87ba8ea26','s6','周惜若',1,'C198797','12fe90acf9d34883b0baad827b5b0aa4.png','a','2017-03-07 17:13:54','a','2017-03-07 17:13:56'),(7,'7127360447bb4b4aaf8982a87ba8ea27','s7','付强',0,'C198797','bdb6ae9c35aa4846b855fcc35d520f3d.png','a','2017-03-07 17:14:10','a','2017-03-07 17:14:12'),(8,'7127360447bb4b4aaf8982a87ba8ea28','s8','高广新',0,'C268676','e696e2ca423642a79be44076b64d1f47.png','a','2017-03-07 17:44:54','a','2017-03-07 17:45:06'),(9,'7127360447bb4b4aaf8982a87ba8ea29','s9','高萌萌',1,'C268676','d23fa7f5e6774d3dbe0203b97d0e3c46.png','a','2017-03-07 17:44:56','a','2017-03-07 17:45:08'),(10,'7127360447bb4b4aaf8982a87ba8eaa1','s10','耿蓓',1,'C268676','f6a18bb9b2dc49a0afe2e1d9eaf79a8f.png','a','2017-03-07 17:44:58','a','2017-03-07 17:45:10'),(11,'7127360447bb4b4aaf8982a87ba8eaa2','s11','宫立伟',0,'C268676','73bf5071a1244c59b62fcd911e5b2f16.jpeg','a','2017-03-07 17:45:00','a','2017-03-07 17:45:11'),(12,'7127360447bb4b4aaf8982a87ba8eaa3','s12','郝京晶',1,'C268676','ddb9ee1e868f4122bf9d8a2edc7f215a.png','a','2017-03-07 17:45:01','a','2017-03-07 17:45:13'),(16,'00742cfcb7764b69b50fcea8188f78ea','S1489072405115','杨过',0,'C268676','b1db66d6b4a74c95816c495e12d858e8.jpg','registe','2017-03-09 23:13:25',NULL,NULL),(17,'58e09bb0c0e84a96aa85bdd9ef3e3140','S1489316424221','俞念慈',1,'C198797','b1db66d6b4a74c95816c495e12d858e8.jpg','registe','2017-03-12 19:00:26',NULL,NULL);

/*Table structure for table `t_student_evaluate` */

CREATE TABLE `t_student_evaluate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uuid` varchar(50) NOT NULL COMMENT 'uuid',
  `schedule_code` varchar(50) NOT NULL COMMENT '学习排课编号',
  `student_code` varchar(50) NOT NULL COMMENT '学生编码',
  `score` int(11) DEFAULT NULL COMMENT '评价得分',
  `intro` varchar(500) DEFAULT '' COMMENT '描述',
  `create_user` varchar(50) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='课程学生评价表';

/*Data for the table `t_student_evaluate` */

insert  into `t_student_evaluate`(`id`,`uuid`,`schedule_code`,`student_code`,`score`,`intro`,`create_user`,`create_time`) values (19,'d4432771280a4f86a1f9cde55d0d1582','SS2','s1',1,'','T1489071763988','2017-03-21 14:18:54'),(21,'982dd7d954084160949f5d0b8f0079a4','SS2','s2',1,'','T1489071763988','2017-03-21 14:19:08'),(22,'27731bff73d645a5916492dcbacea2fd','SS3','S1489072405115',5,'dh','T1489071763988','2017-03-24 16:20:41'),(23,'b3f2a105ee524ad9871b525876c0b175','SS2','s3',4,'人','T1489071763988','2017-03-24 16:59:25'),(24,'37ff8f96445a4e09b21d08cb600e874a','','',1,'地方方法','T1489071763988','2017-03-25 21:23:49'),(25,'e21185ae18b14bafa6f0cc90c73eec1b','','',1,'','T1489071763988','2017-03-25 21:25:59'),(26,'e43690287ac64b7ca0f7f1fa9609a805','SS2','s8',4,'测试查看操作','T1489071763988','2017-03-25 21:36:26'),(31,'0bfe9d141dcd4b62a515e162d94e1b83','SS2','s1',5,'','T1489071763988','2017-03-26 01:43:18');

/*Table structure for table `t_study_schedule` */

CREATE TABLE `t_study_schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(50) DEFAULT NULL,
  `schedule_code` varchar(50) DEFAULT NULL COMMENT '学习排课编号(考试,签到,答题表的外键)',
  `lesson_code` varchar(50) DEFAULT NULL COMMENT '课程编码',
  `teacher_code` varchar(50) DEFAULT NULL COMMENT '教师编码',
  `classes_code` varchar(50) DEFAULT NULL COMMENT '班级编码',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `length` int(4) DEFAULT NULL COMMENT '课程时长',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_study_schedule` */

insert  into `t_study_schedule`(`id`,`uuid`,`schedule_code`,`lesson_code`,`teacher_code`,`classes_code`,`start_time`,`length`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,'7127360447bb4b4aaf8982a87ba8eab5','SS2','L8293857','T1489071763988','C198797,C268676','2017-03-12 14:00:00',120,'a','2017-03-07 10:43:52','a','2017-03-07 10:43:56'),(2,'7127360447bb4b4aafac82a87ba8eaa8','SS3','L8293857','T1489071763988','C268676,C376765','2017-03-13 10:43:42',120,'a','2017-03-10 17:15:55','a','2017-03-10 17:15:58'),(3,'7127360447bb4b4aafac82a87ba8eaa9','SS4','L9970723','T1489071763988','C376765','2017-03-14 19:49:17',120,'a','2017-03-12 19:49:25','a','2017-03-12 19:49:31'),(4,'7127360447bb4b4aafac82a87ba8ea10','SS5','SYZ','T1489071763988','C376765','2017-03-17 15:19:58',12,'1','2017-03-17 15:20:01','a','2017-03-17 15:20:05');

/*Table structure for table `t_teacher` */

CREATE TABLE `t_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL COMMENT '教师编码',
  `name` varchar(50) DEFAULT NULL COMMENT '教师姓名',
  `sex` int(2) DEFAULT '0' COMMENT '性别 0 男 1 女',
  `head_pic` varchar(500) DEFAULT '' COMMENT '头像',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_teacher` */

insert  into `t_teacher`(`id`,`uuid`,`code`,`name`,`sex`,`head_pic`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,'05a52a8f717c403081c4d49e76348992','T1489071763988','周唯真',0,'be7af95068db478383c0a9f5bc969578.png','a','2017-03-07 14:09:43','a','2017-03-07 14:09:47'),(2,'478e94df6fcb461c92d2f601578f9f12','T1489071763989','王重阳',0,'','registe','2017-03-09 23:02:47',NULL,NULL),(3,'95f65a5531ab49b597c43e3da256fd8b','T1489242007573','zhang',0,'','registe','2017-03-11 22:20:08',NULL,NULL),(4,'9dec56e191d24c9fa8e88733db19b60f','T1489242282876','zhang',0,'','registe','2017-03-11 22:24:43',NULL,NULL),(5,'a08104ea88e6478da57b28115577c338','T1489242811780','zhang',0,'','registe','2017-03-11 22:33:32',NULL,NULL),(6,'796e31ed412f4304b67586a6f561e6cb','T1489243951890','zhang',0,'','registe','2017-03-11 22:52:32',NULL,NULL),(7,'35014ca20fa04e78b02790e9344aa783','T1489244013447','张晓格',0,'','registe','2017-03-11 22:53:33',NULL,NULL),(8,'8c3def6b22ee4969924eec019655108a','T1490456490964','df',0,'','registe','2017-03-25 23:41:31',NULL,NULL);

/*Table structure for table `t_user` */

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL COMMENT '与t_student和t_teacher表关联的code码',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名，注册的学号|手机号等',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `type` varchar(50) DEFAULT NULL COMMENT '用户类型: T0001老师|S0002学生',
  `email` varchar(50) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`uuid`,`code`,`username`,`password`,`type`,`email`,`create_user`,`create_time`,`update_user`,`update_time`) values (1,'e77a824bad7d4b6c9d6046731a685a0d','s1','456','456','S0002',NULL,'a','2017-03-09 16:51:18','a','2017-03-09 16:51:21'),(2,'05a52a8f717c403081c4d49e76348992','T1489071763988','123','123','T0001',NULL,'a','2017-03-09 16:52:49','a','2017-03-09 16:52:52'),(3,'bdda426db77f4a23aa3531a2c1d8341d','T1489071763989','13511112222','1','T0001','serw@gmail.com','registe','2017-03-09 23:02:42',NULL,NULL),(7,'1d09611bdc694f5590917e6c05bb61ce','S1489072405115','5566778','123','S0002','yangguo@qq.com','registe','2017-03-09 23:13:25',NULL,NULL),(8,'2fbdd2d8479a47e28f3de6e448ae62e2','T1489242007573','123','123123','T0001','stockwyz','registe','2017-03-11 22:20:08',NULL,NULL),(9,'0cc58d233a8f478fa5a1588a5ca20b87','T1489242282876','astwqe','1','T0001','stockwyz','registe','2017-03-11 22:24:43',NULL,NULL),(10,'614c6126596c48548b98aa29cfb2c57f','T1489242811780','456','456456','T0001','stockwyz','registe','2017-03-11 22:33:32',NULL,NULL),(11,'48a9554fb17840e08c396739deb4dbc4','T1489243951890','456456','456456','T0001','stockwyz','registe','2017-03-11 22:52:32',NULL,NULL),(12,'3b5eb240fafc4cd9a9e1f6c460fc3b9b','T1489244013447','电话说','123','T0001','喜欢的话是','registe','2017-03-11 22:53:33',NULL,NULL),(13,'57f629c213ef41a0866afe7c6010f5fd','S1489316424221','俞念慈','1','S0002','1','registe','2017-03-12 19:00:23',NULL,NULL),(14,'396709c0371646c9b6a7739349048ac4','T1490456490964','we','1','T0001','rt','registe','2017-03-25 23:41:31',NULL,NULL);

/*Table structure for table `t_user_login` */

CREATE TABLE `t_user_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(50) DEFAULT NULL,
  `user_code` varchar(50) DEFAULT NULL COMMENT '用户编码',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_login` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
