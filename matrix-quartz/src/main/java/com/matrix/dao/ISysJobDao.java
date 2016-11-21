package com.matrix.dao;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.SysJob;

public interface ISysJobDao extends IBaseDao<SysJob, Integer> {
	
	public Integer updateSelectiveByUuid(SysJob entity);
	
}