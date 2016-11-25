package com.matrix.service;

import com.matrix.base.interfaces.IBaseService;
import com.matrix.pojo.dto.SystemUtil;
import com.matrix.pojo.entity.SysError;

public interface ISystemService extends IBaseService<SystemUtil , Integer>{

	public String addLock(String keycode, Integer timeoutSecond, String uuid);
	
	public String unLock(String uuid);
	
	public String getUniqueCode(String codeStart);
	
	public Integer addSystemError(SysError entity);
}