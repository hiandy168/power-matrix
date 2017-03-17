package com.matrix.pojo.entity;

import java.util.Date;

import com.matrix.pojo.EduBaseEntity;

public class TStudent extends EduBaseEntity {
	private String code;
	private String name;
	private Integer sex;
	private String classesCode;
	private String headPic;

	/**
	 * 签到时间
	 */
	private String signTime;

	private String scheduleCode;

	private Integer flagEvaluate;

	public Integer getFlagEvaluate() {
		return flagEvaluate;
	}

	public void setFlagEvaluate(Integer flagEvaluate) {
		this.flagEvaluate = flagEvaluate;
	}

	public String getScheduleCode() {
		return scheduleCode;
	}

	public void setScheduleCode(String scheduleCode) {
		this.scheduleCode = scheduleCode;
	}

	public String getSignTime() {
		return signTime;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getClassesCode() {
		return classesCode;
	}

	public void setClassesCode(String classesCode) {
		this.classesCode = classesCode;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

}