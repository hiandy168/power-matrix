package com.matrix.pojo.entity;

import java.util.Date;

public class TLessonSign {
    private Integer id;
    private String uuid;
    private String teacherCode;
    private String studentCode;
    private String lessonCode;
    private Date createTime;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getTeacherCode() {
		return teacherCode;
	}
	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
	public String getLessonCode() {
		return lessonCode;
	}
	public void setLessonCode(String lessonCode) {
		this.lessonCode = lessonCode;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}