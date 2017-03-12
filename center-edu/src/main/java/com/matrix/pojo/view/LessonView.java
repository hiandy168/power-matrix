package com.matrix.pojo.view;

import com.matrix.pojo.entity.TLesson;

public class LessonView extends TLesson{
	
	private Integer length;  // t_study_schedule 表的length  
	private String classesCode; // t_study_schedule 表的class_code   

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
