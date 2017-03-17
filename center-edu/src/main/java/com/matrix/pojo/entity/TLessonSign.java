package com.matrix.pojo.entity;

import com.matrix.pojo.EduBaseEntity;

public class TLessonSign extends EduBaseEntity {
	private String studentCode;
	private String scheduleCode;
	/**
	 * 是否已评价 0 未评价 1 已评价
	 */
	private Integer flagEvaluate;

	public Integer getFlagEvaluate() {
		return flagEvaluate;
	}

	public void setFlagEvaluate(Integer flagEvaluate) {
		this.flagEvaluate = flagEvaluate;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getScheduleCode() {
		return scheduleCode;
	}

	public void setScheduleCode(String scheduleCode) {
		this.scheduleCode = scheduleCode;
	}

}