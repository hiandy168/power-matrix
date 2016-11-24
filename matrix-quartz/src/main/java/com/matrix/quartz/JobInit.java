package com.matrix.quartz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

import com.matrix.annotation.Inject;
import com.matrix.base.interfaces.IBaseJob;
import com.matrix.map.MDataMap;
import com.matrix.pojo.entity.SysJob;
import com.matrix.quartz.model.MJobInfo;
import com.matrix.quartz.support.JobSupport;
import com.matrix.service.IJobService;
import com.matrix.system.init.RootInit;


// properties配置信息核对完成
public class JobInit extends RootInit {
	
	@Inject
	private IJobService jobService;

	public boolean onInit() {
		boolean flag = true;
		
		String rglist = this.getConfig("quartz.rglist");  // 获取配置文件中等待执行的【定时任务组】
		if(StringUtils.isBlank(rglist)){  // 如果项目不需要加载定时任务 - Yangcl
			return true;
		}
		List<String> rglist_ = new ArrayList<String>(Arrays.asList(rglist.split(",")));
		
		SysJob entity = new SysJob();
		entity.setFlagEnable(1);        // 定时任务的执行状态
		entity.setRglist(rglist_); 
		List<SysJob> list = jobService.findSysJobList(entity);
		if(list == null && list.size() == 0){
			return true;
		}
		
		for(SysJob sj : list){
			String jobTriger = sj.getJobTriger();
			// 如果事件定义的时间为空 则系统加载时则执行
			if (StringUtils.isBlank(jobTriger)) {
				try {
					IBaseJob iJob = (IBaseJob) ClassUtils.getClass(sj.getJobClass()).newInstance();
					iJob.doExecute(null);
					getLogger().logInfo(300000004, sj.getJobTitle());  
				} catch (Exception e) {
					flag = false;
					e.printStackTrace();
				}
			}else{
				MJobInfo mJobInfo = new MJobInfo();
				mJobInfo.setJobClass(sj.getJobClass());
				mJobInfo.setJobTriger(sj.getJobTriger());
				mJobInfo.setJobName(sj.getUid());
				if(StringUtils.isNotBlank(sj.getSetExtend())){
					MDataMap mExtendMap = new MDataMap().inUrlParams(sj.getSetExtend());
					if (mExtendMap.containsKey("type_log")) {
						mJobInfo.setExtendTypeLog(Integer.valueOf(mExtendMap.get("type_log")));
					}
					
					// 如果有默认锁定时间 则使用默认锁定时间 否则默认锁定300秒
					if (mExtendMap.containsKey("lock_timer")) {
						mJobInfo.setExtendLockTimer(Integer.valueOf(mExtendMap.get("lock_timer")));
					} else {
						mJobInfo.setExtendLockTimer(300);
					}
				}
				
				JobSupport.getInstance().addJob(mJobInfo);
				getLogger().logInfo(300000005 , sj.getJobTitle() , sj.getJobTriger() );  
			}
		}
		return flag;     
	}
	
	@Override
	public boolean onDestory() {
		// TODO Auto-generated method stub
		return false;
	}

}
