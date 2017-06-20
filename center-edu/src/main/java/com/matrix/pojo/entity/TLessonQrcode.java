package com.matrix.pojo.entity;

import java.util.Date;

import com.matrix.pojo.EduBaseEntity;

public class TLessonQrcode  extends EduBaseEntity{
	private String scheduleCode;
//	private String teacherCode;
//	private String lessonCode;
	private String qrcodeUrl;
	
	
	public String getScheduleCode() {
		return scheduleCode;
	}
	public void setScheduleCode(String scheduleCode) {
		this.scheduleCode = scheduleCode;
	}
	public String getQrcodeUrl() {
		return qrcodeUrl;
	}
	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}
	
}
