/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.28 : Database - matrixcore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `sys_error` */

CREATE TABLE `sys_error` (
  `zid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` char(32) DEFAULT '',
  `error_code` varchar(450) DEFAULT '' COMMENT '错误编号',
  `error_type` varchar(450) DEFAULT '' COMMENT '错误类型',
  `error_level` varchar(450) DEFAULT '' COMMENT '错误级别',
  `error_source` varchar(450) DEFAULT '' COMMENT '错误源',
  `error_info` longtext COMMENT '错误内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`zid`)
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8 COMMENT='错误信息表';

/*Data for the table `sys_error` */

insert  into `sys_error`(`zid`,`uid`,`error_code`,`error_type`,`error_level`,`error_source`,`error_info`,`create_time`) values (158,'783f615144654f028eb3ce8eb0ecb543','sCode','sErrorType','20','sErrorSource','setErrorInfo #########askdfjielznnvf asdlkffjie asdli adsfw asdfoaisdf asdflaiefd asdf  asdfeadsdf','2016-06-21 22:36:40'),(159,'d79a307b31e64d7984a5f63200c8b3d6','sCode','sErrorType','20','sErrorSource','setErrorInfo #########TestException','2016-06-22 21:35:28');

/*Table structure for table `sys_exectimer` */

CREATE TABLE `sys_exectimer` (
  `zid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` char(32) DEFAULT '',
  `exec_code` varchar(45) DEFAULT '' COMMENT '执行流水号',
  `exec_type` varchar(45) DEFAULT '' COMMENT '执行类型 1LD支付 2LD同步订单  3跨境通同步订单',
  `exec_info` varchar(1000) DEFAULT '' COMMENT '执行内容',
  `create_time` char(19) DEFAULT '' COMMENT '创建时间',
  `begin_time` char(19) DEFAULT '' COMMENT '开始执行时间',
  `end_time` char(19) DEFAULT '' COMMENT '执行完成时间',
  `exec_time` char(19) DEFAULT '' COMMENT '预计执行时间',
  `flag_success` int(11) DEFAULT '0' COMMENT '是否成功',
  `remark` longtext COMMENT '处理备注',
  `exec_number` int(11) DEFAULT '0' COMMENT '执行次数',
  PRIMARY KEY (`zid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时执行表';

/*Data for the table `sys_exectimer` */

/*Table structure for table `sys_job` */

CREATE TABLE `sys_job` (
  `zid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` char(32) DEFAULT '',
  `job_title` varchar(450) DEFAULT '' COMMENT '任务名称',
  `job_class` varchar(450) DEFAULT '' COMMENT '任务类名称',
  `job_triger` varchar(450) DEFAULT '' COMMENT '定时周期',
  `run_group_did` varchar(45) DEFAULT '' COMMENT '运行组',
  `flag_enable` int(11) DEFAULT '1' COMMENT '是否可用',
  `job_remark` varchar(450) DEFAULT '' COMMENT '备注',
  `begin_time` datetime DEFAULT NULL COMMENT '开始执行时间',
  `flag_parallel` int(11) DEFAULT '1' COMMENT '是否允许并行启动',
  `max_exec_time` int(11) DEFAULT '0' COMMENT '最长执行秒数',
  `end_time` datetime DEFAULT NULL COMMENT '结束执行时间',
  `set_extend` varchar(450) DEFAULT '' COMMENT '扩展设置',
  `next_time` datetime DEFAULT NULL COMMENT '下一次执行时间',
  PRIMARY KEY (`zid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='定时任务列表';

/*Data for the table `sys_job` */

insert  into `sys_job`(`zid`,`uid`,`job_title`,`job_class`,`job_triger`,`run_group_did`,`flag_enable`,`job_remark`,`begin_time`,`flag_parallel`,`max_exec_time`,`end_time`,`set_extend`,`next_time`) values (1,'ba3cb5b2a5a645a8bb4644df42db8881','定时任务测试类','com.matrix.quartz.job.JobForTestOne','2 * * * * ?','matrix-quartz-test',1,'','2016-11-28 17:13:02',1,0,'2016-11-28 17:13:02','','2016-11-28 17:14:02'),(2,'ba3cb5b2a5a645a8bb4644df42db8882','定时任务测试类','com.matrix.quartz.job.JobForTestTwo','2 * * * * ?','matrix-quartz-test',1,'','2016-11-28 17:13:02',1,0,'2016-11-28 17:13:02','','2016-11-28 17:14:02'),(3,'ba3cb5b2a5a645a8bb4644df42db8883','定时任务测试类','com.matrix.quartz.job.JobForTestThree','2 * * * * ?','matrix-quartz-test',1,'','2016-11-28 17:13:02',1,0,'2016-11-28 17:13:02','','2016-11-28 17:14:02');

/*Table structure for table `sys_job_exectimer` */

CREATE TABLE `sys_job_exectimer` (
  `zid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` char(32) DEFAULT '',
  `exec_code` varchar(45) DEFAULT '' COMMENT '执行流水号',
  `exec_type` varchar(45) DEFAULT '' COMMENT '执行类型 1 2 3跨境通同步订单(所属哪个商户的定时任务)',
  `exec_info` varchar(1000) DEFAULT '' COMMENT '执行内容',
  `begin_time` datetime DEFAULT NULL COMMENT '开始执行时间',
  `end_time` datetime DEFAULT NULL COMMENT '执行完成时间',
  `exec_time` datetime DEFAULT NULL COMMENT '预计执行时间',
  `flag_success` int(11) DEFAULT '0' COMMENT '是否成功',
  `remark` longtext COMMENT '处理备注',
  `exec_number` int(11) DEFAULT '0' COMMENT '执行次数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`zid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时执行表';

/*Data for the table `sys_job_exectimer` */

/*Table structure for table `sys_lock` */

CREATE TABLE `sys_lock` (
  `zid` int(8) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `uid` varchar(32) NOT NULL COMMENT 'UUID',
  `keyid` varchar(32) DEFAULT NULL COMMENT 'key流水号',
  `keycode` varchar(50) NOT NULL COMMENT '锁号',
  `creator` varchar(40) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updator` varchar(40) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`zid`),
  UNIQUE KEY `key_code_unique` (`keycode`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `sys_lock` */

insert  into `sys_lock`(`zid`,`uid`,`keyid`,`keycode`,`creator`,`create_time`,`updator`,`update_time`) values (43,'dc9685e8b54a11e6bec300ffcd92a041','3a506eb51db44aaba4be6593557999ea','JobForTestOne',NULL,'2016-11-28 17:13:02',NULL,NULL),(44,'dc9724d7b54a11e6bec300ffcd92a041','fcd3a7c9558b4bd9bae30c908423e84b','JobForTestTwo',NULL,'2016-11-28 17:13:02',NULL,NULL),(45,'dc97a359b54a11e6bec300ffcd92a041','9cf40dc4547a433f9a232f99b814cc27','JobForTestThree',NULL,'2016-11-28 17:13:02',NULL,NULL);

/*Table structure for table `sys_webcode` */

CREATE TABLE `sys_webcode` (
  `zid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` char(32) DEFAULT '',
  `code_start` varchar(100) DEFAULT '' COMMENT '编码起始',
  `date_apply` char(6) DEFAULT '' COMMENT '日期参数',
  `min_number` int(11) DEFAULT '100000' COMMENT '最小数字',
  `now_number` int(11) DEFAULT '100000' COMMENT '当前数字',
  `code_note` varchar(45) DEFAULT '' COMMENT '备注',
  `flag_date` int(11) DEFAULT '1' COMMENT '是否日期列',
  PRIMARY KEY (`zid`),
  UNIQUE KEY `code_start_UNIQUE` (`code_start`)
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8 COMMENT='系统编码表';

/*Data for the table `sys_webcode` */

insert  into `sys_webcode`(`zid`,`uid`,`code_start`,`date_apply`,`min_number`,`now_number`,`code_note`,`flag_date`) values (14,'75e615befb4a11e2ac71000c298b20fc','test','160419',100000,100002,'',1),(15,'77eaacbcfb5411e2ac71000c298b20fc','FS','130802',100000,100007,'',1),(16,'cbd34e62fb5711e2ac71000c298b20fc','FF','140414',100000,100013,'',1),(299,'d0e691ee37bc11e68984b8ee655812b8','fairy-','160621',100000,100030,'',1),(300,'f516a4106acc11e69f56b8ee655812b8','KCRL','160826',100000,100002,'',1);

/* Procedure structure for procedure `proc_get_unique_code` */

DELIMITER $$

/*!50003 CREATE DEFINER=`qhsy`@`%` PROCEDURE `proc_get_unique_code`(in p_code_start varchar(100))
begin
declare p_date CHAR(6);
declare p_now CHAR(6);
declare p_return varchar(30);
declare p_nowno int;
set p_now=DATE_FORMAT(NOW(), '%y%m%d') ;
set p_date=IFNULL((select a.date_apply from sys_webcode a where  a.code_start=p_code_start),'');
IF(p_date='')
THEN 
	INSERT INTO `sys_webcode`
	(
	`uid`,
	`code_start`,
	`date_apply`,
	`min_number`,
	`now_number`)
	VALUES
	(
		REPLACE(UUID(),'-',''),
		p_code_start,
		p_now,
		100000,
		100000
	);
	set p_date=p_now;
end if;
 IF(p_date!=p_now) then
	
	if LENGTH(p_date)!=6 then
		set p_now='';
	else
		update sys_webcode set now_number=min_number,date_apply=p_now where code_start=p_code_start and flag_date=1;
	end if;
end if;
start transaction; 
set p_return=(select now_number from sys_webcode zwwc  where zwwc.code_start=p_code_start for update);
set p_return=p_return+1;
update sys_webcode set now_number=p_return where code_start=p_code_start;
commit;
select CONCAT(p_code_start,p_now,p_return) as webcode;
end */$$
DELIMITER ;

/* Procedure structure for procedure `proc_lock_or_unlock_somekey` */

DELIMITER $$

/*!50003 CREATE DEFINER=`qhsy`@`%` PROCEDURE `proc_lock_or_unlock_somekey`(in somekey VARCHAR(1000),in keysplit VARCHAR(2),in timeoutsecond INT,in lockflag INT,in UUID VARCHAR(50))
BEGIN
	
	DECLARE i int DEFAULT 0;
	DECLARE lockid VARCHAR(32) DEFAULT '';
	DECLARE currentTime VARCHAR(50) DEFAULT '';
	DECLARE lockCurrentKey VARCHAR(50) DEFAULT '';
	DECLARE lockzid INT DEFAULT 0; 
	DECLARE outFlag INT DEFAULT 2;
	
	 
	DECLARE t_error int default 0; 
	 
	DECLARE continue handler for sqlexception set t_error=1; 
	SET outFlag=2;
	
	IF lockflag =1 THEN
				
				 
				SET currentTime=CONCAT(current_timestamp,'');
				
				
				
				
				DELETE FROM sys_lock where keycode=somekey and (UNIX_TIMESTAMP(currentTime) - UNIX_TIMESTAMP(create_time))>timeoutsecond;
				SELECT zid INTO lockzid from sys_lock where keycode=somekey;
					IF FOUND_ROWS()<=0 THEN
						
							
								INSERT INTO sys_lock (uid,keycode,keyid,create_time)
									SELECT REPLACE(UUID(),'-',''),somekey,UUID,currentTime ;
								IF ROW_COUNT()<=0 THEN
									
									set outFlag=2;
								ELSE
									
									SET outFlag=1;
								END IF;
					ELSE
						SET UUID=lockid;
						SET outFlag=2;
					END IF;
		
	
	ELSE 
			IF lockflag =2 THEN
				
				
				START TRANSACTION;
				
				 DELETE FROM sys_lock where keyid=UUID;
				
				IF t_error=1 THEN 
					SET UUID='';
					SET outFlag=2;
					ROLLBACK;
				ELSE
					SET UUID='';
					SET outFlag=1;
					COMMIT;			
				END IF;	
			ELSE
				SET UUID='';
				SET outFlag=2;
			END IF;
	END IF;
	SELECT outFlag;
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
