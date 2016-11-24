package com.matrix.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.matrix.base.interfaces.IBaseJob;
import com.matrix.helper.LogHelper;
import com.matrix.quartz.model.MJobInfo;
import com.matrix.quartz.model.MLogJob;
import com.matrix.system.cache.TopConst;
import com.matrix.util.DateUtil;

/**
 * @descriptions 根任务 所有任务接口需要调用该基类 
 *
 * @author zht 
 * @date 2016年11月23日 下午10:02:40
 * @version 1.0.1
 */
public abstract class RootJob extends RootJobForLock implements Job, IBaseJob {

	// 这个是备份执行 为了防止新逻辑出错时 直接修改代码 更新继承和这块逻辑就行
	public void back_execute(JobExecutionContext context) throws JobExecutionException {
		try {
			if (context != null && context.getMergedJobDataMap() != null
					&& context.getMergedJobDataMap().containsKey(TopConst.CONST_JOB_START + "status")) {

				MJobInfo mJobInfo = (MJobInfo) context.getMergedJobDataMap().get(TopConst.CONST_JOB_START + "status");

				// 判断如果记日志
				if (mJobInfo.getExtendTypeLog() == 1) {
					MLogJob mLogJob = new MLogJob();
					mLogJob.setNextExecTime(DateUtil.formatDate(context.getNextFireTime()));
					mLogJob.setJobInfo(mJobInfo);
					LogHelper.addLog("run_job", mLogJob);
				}
			}
			doExecute(context);
		} catch (Exception e) {
			getLogger().logError(300000001, this.getClass().getName());
			e.printStackTrace();
		}

	}
}
