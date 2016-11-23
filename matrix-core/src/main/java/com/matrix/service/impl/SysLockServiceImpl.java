package com.matrix.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.ISysLockDao;
import com.matrix.map.MObjMap;
import com.matrix.pojo.entity.SysLock;
import com.matrix.service.ISysLockService;


@Service("lockService")
public class SysLockServiceImpl extends BaseServiceImpl<SysLock, Integer> implements ISysLockService {
	@Resource
	private ISysLockDao lockDao;

	@Override
	public String addLock(String keycode, Integer timeoutSecond, String uuid) {
		MObjMap<String, Object> param = new MObjMap<String, Object>();
		param.put("somekey", keycode);
		param.put("keysplit", ",");
		param.put("timeoutsecond", timeoutSecond);
		param.put("lockflag", "1");
		param.put("uuid", uuid);
		return lockDao.addLock(param);
	}
	
	@Override
	public String unLock(String uuid) {
		MObjMap<String, Object> param = new MObjMap<String, Object>();
		param.put("somekey", "");
		param.put("keysplit", ",");
		param.put("timeoutsecond", new Integer(0));
		param.put("lockflag", "2");
		param.put("uuid", uuid);
		return lockDao.addLock(param);
	}
}
