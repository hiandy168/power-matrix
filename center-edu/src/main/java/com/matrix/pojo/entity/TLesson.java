package com.matrix.pojo.entity;

import java.util.Date;

import com.matrix.pojo.EduBaseEntity;

public class TLesson  extends EduBaseEntity{
    private String lessonName;  // 课程名称
    private String code;
    private String typeCode;
    private String intro;
    private String imgUrl;
    
//    private String teacherCode;
//    private String classesCode;
//    private Date startTime;
//    private Integer length;
    
	public String getLessonName() {
		return lessonName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
}