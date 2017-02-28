package com.matrix.pojo.entity;

import java.util.Date;

public class McUserRole {
    private Integer id;
    private Integer mcUserId;
    private Integer mcRoleId;
    private Integer flag;
    private Date createTime;
    private Date updateTime;
    private Integer createUserId;
    private Integer updateUserId;
    private String remark;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	public Integer getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}