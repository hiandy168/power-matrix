package com.matrix.pojo.cache;

import java.util.ArrayList;
import java.util.List;

import com.matrix.pojo.entity.McRoleFunction;
import com.matrix.pojo.entity.McSysFunction;

public class McUserRoleCache {
	private Integer mcUserId; 
	private List<McSysFunction> msfList = new ArrayList<McSysFunction>();
	
	public Integer getMcUserId() {
		return mcUserId;
	}
	public void setMcUserId(Integer mcUserId) {
		this.mcUserId = mcUserId;
	}
	public List<McSysFunction> getMsfList() {
		return msfList;
	}
	public void setMsfList(List<McSysFunction> msfList) {
		this.msfList = msfList;
	}
}
