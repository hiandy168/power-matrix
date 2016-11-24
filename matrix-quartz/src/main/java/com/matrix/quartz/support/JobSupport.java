package com.matrix.quartz.support;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.ClassUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.matrix.base.BaseClass;
import com.matrix.base.interfaces.IBaseJob;
import com.matrix.quartz.model.MJobInfo;
import com.matrix.system.cache.TopConst;


/**
 * @descriptions 为JobInit.java提供定时任务的相关支持|TODO 随着业务的扩大，这个类还可以提供更加
 * 		强大的功能。目前暂时提供7个功能。
 *
 * @author zht 
 * @date 2016年11月24日 下午11:30:29
 * @version 1.0.1
 */
public class JobSupport extends BaseClass {

	private static JobSupport jobSupport = null;

	private Scheduler scheduler = null;

	private int iNumIndex = 0;

	public static JobSupport getInstance() {
		if (jobSupport == null) {
			jobSupport = new JobSupport();
		}
		return jobSupport;
	}

	/**
	 * @descriptions 添加定时任务
	 *
	 * @param sClassName 类名称
	 * @param sTriger 定时表达式 标准quartz结构体
	 * @param sJobName 任务名称 可以为空 为空则自动生成
	 * 
	 * @date 2016年11月24日 下午11:34:34
	 * @version 1.0.0.1
	 */
	public synchronized void addJob(MJobInfo mJobInfo) {
		try {
			if (scheduler == null) {
				SchedulerFactory sf = new StdSchedulerFactory();
				scheduler = sf.getScheduler();
				scheduler.start();
			}
			@SuppressWarnings("unchecked")
			Class<IBaseJob> jClass = ClassUtils.getClass(mJobInfo.getJobClass());
			JobDetail job = JobBuilder.newJob(jClass).withIdentity(mJobInfo.getJobName(), Scheduler.DEFAULT_GROUP).build(); // 设置作业，具体操作在SimpleJob类里

			CronTrigger trigger = (CronTrigger) TriggerBuilder
					.newTrigger()
					.withIdentity("trigger_" + mJobInfo.getJobName(),Scheduler.DEFAULT_GROUP)
					.withSchedule(CronScheduleBuilder.cronSchedule(mJobInfo.getJobTriger())).build(); // 设置触发器

			Set<CronTrigger> sTriggers = new HashSet<CronTrigger>();
			sTriggers.add(trigger);
			job.getJobDataMap().put(TopConst.CONST_JOB_START + "status", mJobInfo);
			scheduler.scheduleJob(job, sTriggers, true); // 设置调度作业
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @descriptions 删除任务
	 *
	 * @param sJobName
	 * @date 2016年11月24日 下午11:37:12
	 * @version 1.0.0.1
	 */
	public boolean deleteJob(String sJobName) {
		try {
			scheduler.deleteJob(JobKey.jobKey(sJobName , Scheduler.DEFAULT_GROUP));
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @descriptions 关闭所有定时器
	 *
	 * @date 2016年11月24日 下午11:37:34
	 * @version 1.0.0.1
	 */
	public boolean shutDown() {
		try {
			if (scheduler != null) {
				scheduler.shutdown();
				// 延迟一秒 静候所有任务停止
				Thread.sleep(1000);
				while (!scheduler.isShutdown()) {
					Thread.sleep(1000);
				}
				scheduler.shutdown(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @descriptions 开始所有任务
	 *
	 * @date 2016年11月24日 下午11:39:00
	 * @version 1.0.0.1
	 */
	public boolean start() {
		try {
			if (scheduler.isShutdown()) {
				scheduler.start();
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	/**
	 * @descriptions 暂停所有任务
	 *
	 * @date 2016年11月24日 下午11:39:00
	 * @version 1.0.0.1
	 */
	public boolean pauseAll() {
		try {
			scheduler.pauseAll();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @descriptions 恢复所有任务
	 *
	 * @date 2016年11月24日 下午11:39:00
	 * @version 1.0.0.1
	 */
	public boolean resumeAll() {
		try {
			scheduler.resumeAll();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @descriptions 重启所有任务
	 *
	 * @date 2016年11月24日 下午11:39:00
	 * @version 1.0.0.1
	 */
	public boolean restart() {
		shutDown();
		return start();
	}

}
























