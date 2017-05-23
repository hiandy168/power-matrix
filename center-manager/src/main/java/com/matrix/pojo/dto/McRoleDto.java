package com.matrix.pojo.dto;

import com.matrix.pojo.entity.McRole;

public class McRoleDto extends McRole{
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
