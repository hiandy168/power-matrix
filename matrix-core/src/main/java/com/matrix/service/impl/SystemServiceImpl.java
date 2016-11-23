package com.matrix.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.matrix.base.BaseServiceImpl;
import com.matrix.dao.ISysErrorDao;
import com.matrix.dao.ISysLockDao;
import com.matrix.dao.ISysWebcodeDao;
import com.matrix.map.MObjMap;
import com.matrix.pojo.dto.SystemUtil;
import com.matrix.pojo.entity.SysError;
import com.matrix.service.ISystemService;

@Service("systemService")
public class SystemServiceImpl extends BaseServiceImpl<SystemUtil, Integer> implements ISystemService {
	
	@Resource
	private ISysLockDao sysLockDao;
	@Resource
	private ISysWebcodeDao sysWebcodeDao;  
	@Resource
	private ISysErrorDao sysErrorDao;
	
	public String addLock(String keycode, Integer timeoutSecond, String uuid) {
		MObjMap<String, Object> param = new MObjMap<String, Object>();
		param.put("somekey", keycode);
		param.put("keysplit", ",");
		param.put("timeoutsecond", timeoutSecond);
		param.put("lockflag", "1");
		param.put("uuid", uuid);
		return sysLockDao.addLock(param);
	}

	public String unLock(String uuid) {
		MObjMap<String, Object> param = new MObjMap<String, Object>();
		param.put("somekey", "");
		param.put("keysplit", ",");
		param.put("timeoutsecond", new Integer(0));
		param.put("lockflag", "2");
		param.put("uuid", uuid);
		return sysLockDao.addLock(param);
	}

	public String getUniqueCode(String codeStart) {
		MObjMap<String, Object> param = new MObjMap<String, Object>();
		param.put("code", codeStart);
		return sysWebcodeDao.callUniqueCode(param); 
	}
	
	public Integer addSystemError(SysError entity) {
		return sysErrorDao.insertSelective(entity); 
	}
}



































