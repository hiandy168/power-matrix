package com.matrix.pojo.entity;

import java.util.Date;

import com.matrix.pojo.EduBaseEntity;

public class TLessonEvaluate  extends EduBaseEntity{
    private String code;
    private String studentCode;
    private String scheduleCode;
//    private String lessonCode;
    private Integer score;
    private String content;
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}