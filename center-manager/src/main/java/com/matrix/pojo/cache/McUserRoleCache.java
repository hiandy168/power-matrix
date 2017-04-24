package com.matrix.pojo.cache;

import java.util.ArrayList;
import java.util.List;

import com.matrix.pojo.entity.McRoleFunction;
import com.matrix.pojo.entity.McSysFunction;

public class McUserRoleCache {
	private Integer mcUserId;
	private Integer mcRoleId;
	private String roleName;
	private String roleDesc;
	private List<McSysFunction> msfList = new ArrayList<McSysFunction>();
	
	public Integer getMcUserId() {
		return mcUserId;
	}
	public void setMcUserId(Integer mcUserId) {
		this.mcUserId = mcUserId;
	}
	public Integer getMcRoleId() {
		return mcRoleId;
	}
	public void setMcRoleId(Integer mcRoleId) {
		this.mcRoleId = mcRoleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public List<McSysFunction> getMsfList() {
		return msfList;
	}
	public void setMsfList(List<McSysFunction> msfList) {
		this.msfList = msfList;
	}
}
