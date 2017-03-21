package com.matrix.pojo.view;

import java.text.SimpleDateFormat;

import com.matrix.pojo.entity.TStudySchedule;

public class StudyScheduleView extends TStudySchedule{
	private String lessonName;  // 课程名称
	private String typeCode;
	private String intro;
	private String beginTime;
	private String imgUrl;
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getBeginTime() {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd HH:mm");
		return sdf.format(this.getStartTime());
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime; 
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
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
