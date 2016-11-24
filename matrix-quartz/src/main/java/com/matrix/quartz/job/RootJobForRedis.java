package com.matrix.quartz.job;

import org.quartz.JobExecutionContext;

/**
 * @descriptions 所有Redis缓存类的顶层基类，但现在还没有设计好Redis该如何构建任务模型，故暂时搁置
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2016年11月24日 下午11:20:23
 * @version 1.0.1
 */
public abstract class RootJobForRedis extends RootJob {

	public void doExecute(JobExecutionContext context) {

//		MDataMap map = KvTop.upFactory(EKvTop.Scheduler).hgetAll(
//				getConfig().getExecType());
//
//		for (String sKey : map.keySet()) {
//
//			exec(sKey, map.get(sKey));
//		}
	}

	/**
	 * 单条执行 该方法只用于单个编号调用时处理
	 * 
	 * @param sKey
	 */
	public void exec(String sKey) {
//		exec(sKey,
//				KvTop.upFactory(EKvTop.Scheduler).hget(
//						getConfig().getExecType(), sKey));
	}

	/**
	 * 执行调用
	 * 
	 * @param sKey
	 * @param sValue
	 */
	private void exec(String sKey, String sValue) {

//		// 开始尝试加锁
//		String sLockKey = KvHelper
//				.lockCodes(getConfig().getExecJobLock(), sKey);
//
//		IBaseResult iResult = null;
//
//		// 如果加锁成功 则开始执行
//		if (StringUtils.isNotBlank(sLockKey)) {
//
//			try {
//				iResult = execByInfo(sValue);
//
//			} catch (Exception e) {
//				RootResult rootResult = new RootResult();
//
//				rootResult.setResultCode(969905039);
//				rootResult.setResultMessage(bInfo(969905039));
//				iResult = (IBaseResult) rootResult;
//				e.printStackTrace();
//				rootResult.setResultMessage(rootResult.getResultMessage()
//						+ e.getMessage());
//			}
//
//			// 添加日志
//			LogHelper.addLog("job_for_kv_scheduler", new MDataMap("key", sKey,
//					"value", sValue, "result", GsonHelper.toJson(iResult)));
//
//			// 如果执行不成功 则通知相应处理人
//			if (iResult.getResultCode() != 1) {
//
//				Long lSumNotice = KvTop.upFactory(EKvTop.NoticeSum).incrBy(
//						getConfig().getExecType() + "_" + sKey, 1);
//
//				if (lSumNotice == getConfig().getNoticeOnce()) {
//					String sErrorNotice = bConfig("zapweb.mail_notice").trim();
//					if (StringUtils.isNotBlank(sErrorNotice)) {
//
//						MailSupport.INSTANCE.sendMail(
//								sErrorNotice,
//								bInfo(969912014, getConfig().getExecType()
//										+ sValue), iResult.getResultMessage());
//					}
//				}
//			} else {
//
//				// 如果成功则删除记录
//				KvTop.upFactory(EKvTop.Scheduler).hdel(
//						getConfig().getExecType(), sKey);
//			}
//
//			KvHelper.unLockCodes(sLockKey, sKey);
//
//		}
	}

//	public abstract IBaseResult execByInfo(String sInfo);
//
//	public abstract IKvSchedulerConfig getConfig();

}
