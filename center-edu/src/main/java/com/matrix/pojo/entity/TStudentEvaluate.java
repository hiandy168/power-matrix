package com.matrix.pojo.entity;

import com.matrix.pojo.EduBaseEntity;

/**
 * 
 * 类: TStudentEvaluate <br>
 * 描述: 课程学生评价表 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月17日 下午4:10:56
 */
public class TStudentEvaluate extends EduBaseEntity {

	private String scheduleCode;

	private String studentCode;

	private Integer score;

	private String intro;

	public String getScheduleCode() {
		return scheduleCode;
	}

	public void setScheduleCode(String scheduleCode) {
		this.scheduleCode = scheduleCode;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}