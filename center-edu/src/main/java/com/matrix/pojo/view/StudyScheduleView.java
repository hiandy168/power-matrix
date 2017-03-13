package com.matrix.pojo.view;

import com.matrix.pojo.entity.TStudySchedule;

public class StudyScheduleView extends TStudySchedule{
	private String lessonName;  // 课程名称
	private String typeCode;
	private String intro;
	
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
