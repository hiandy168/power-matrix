package com.matrix.pojo.entity;

import java.util.Date;

import com.matrix.pojo.EduBaseEntity;

public class TExamAnswer  extends EduBaseEntity{
    private String paperCode;
    private String studentCode;
    private String answer;
	public String getPaperCode() {
		return paperCode;
	}
	public void setPaperCode(String paperCode) {
		this.paperCode = paperCode;
	}
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
