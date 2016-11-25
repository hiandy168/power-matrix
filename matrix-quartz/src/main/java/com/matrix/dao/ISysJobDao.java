package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.dto.SysJobDto;
import com.matrix.pojo.entity.SysJob;

public interface ISysJobDao extends IBaseDao<SysJob, Integer> {
	
	public Integer updateSelectiveByUuid(SysJob entity);

	public List<SysJob> findListByDto(SysJobDto entity); 
	
}