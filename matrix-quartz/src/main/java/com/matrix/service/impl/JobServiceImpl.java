package com.matrix.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.ISysJobExectimerDao;
import com.matrix.dao.ISysJobDao;
import com.matrix.pojo.dto.SysJobDto;
import com.matrix.pojo.entity.SysJob;
import com.matrix.pojo.entity.SysJobExectimer;
import com.matrix.service.IJobService;


@Service("jobService")
public class JobServiceImpl extends BaseServiceImpl<SysJobExectimer, Integer> implements IJobService {
	@Resource
	private ISysJobExectimerDao jobExectimerDao;
	@Resource
	private ISysJobDao sysJobDao;

	public List<SysJobExectimer> listJobExectimer(SysJobExectimer entity) {
		return jobExectimerDao.findList(entity); 
	}

	public Integer updateJobExectimer(SysJobExectimer entity) {
		return jobExectimerDao.updateSelectiveByExecCode(entity); 
	}

	public Integer updateSysJobByUuid(SysJob entity) {
		return sysJobDao.updateSelectiveByUuid(entity); 
	}

	public List<SysJob> findSysJobList(SysJobDto entity) {
		return sysJobDao.findListByDto(entity);
	}
}



































