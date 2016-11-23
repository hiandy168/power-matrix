package com.matrix.dao;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.map.MObjMap;
import com.matrix.pojo.entity.SysLock;

public interface ISysLockDao extends IBaseDao<SysLock, Integer> {
	@SuppressWarnings("rawtypes")
	public String addLock(MObjMap param);
}
