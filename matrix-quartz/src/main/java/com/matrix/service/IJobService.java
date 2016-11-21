package com.matrix.service;

import java.util.List;

import com.matrix.base.interfaces.IBaseService;
import com.matrix.pojo.entity.SysJob;
import com.matrix.pojo.entity.SysJobExectimer;

public interface IJobService  extends IBaseService<SysJobExectimer , Integer> {
	
	public List<SysJobExectimer> listJobExectimer(SysJobExectimer entity);
	
	public Integer updateJobExectimer(SysJobExectimer entity);
	
	public Integer updateSysJobByUuid(SysJob entity);
	
	public List<SysJob> findSysJobList(SysJob entity);
}











