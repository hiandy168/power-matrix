package com.matrix.pojo.view;

import java.util.Date;

import com.matrix.pojo.entity.TLesson;

public class LessonView extends TLesson{
	
	private String scheduleCode;
	private Integer length;  // t_study_schedule 表的length  
	private String classesCode; // t_study_schedule 表的class_code   
	private String startTime;

	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getScheduleCode() {
		return scheduleCode;
	}
	public void setScheduleCode(String scheduleCode) {
		this.scheduleCode = scheduleCode;
	}
	public String getClassesCode() {
		return classesCode;
	}
	public void setClassesCode(String classesCode) {
		this.classesCode = classesCode;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
}
