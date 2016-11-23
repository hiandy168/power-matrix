package com.matrix.dao;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.map.MObjMap;
import com.matrix.pojo.entity.SysWebcode;

public interface ISysWebcodeDao extends IBaseDao<SysWebcode , Integer> {
	
	@SuppressWarnings("rawtypes")
	public String callUniqueCode(MObjMap param);
	
}


