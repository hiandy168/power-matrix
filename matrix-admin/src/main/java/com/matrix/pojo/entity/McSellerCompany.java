package com.matrix.pojo.entity;

import java.util.Date;

public class McSellerCompany {
    private Integer id;
    private String mcCompanyName;
    private Integer flag;
    private Date createTime;
    private Date updateTime;
    private Integer createUserId;
    private Integer updateUserId;
    private String remark;
    private Integer symbiosis;  // 合作关系
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMcCompanyName() {
		return mcCompanyName;
	}
	public void setMcCompanyName(String mcCompanyName) {
		this.mcCompanyName = mcCompanyName;
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
	public Integer getSymbiosis() {
		return symbiosis;
	}
	public void setSymbiosis(Integer symbiosis) {
		this.symbiosis = symbiosis;
	}

    
    
}