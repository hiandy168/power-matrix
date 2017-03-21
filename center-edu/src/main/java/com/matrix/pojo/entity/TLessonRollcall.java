package com.matrix.pojo.entity;

/**
 * 
 * 类: TLessonRollcall <br>
 * 描述: 课程点名 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月21日 下午3:17:48
 */
public class TLessonRollcall {

	private Integer id;

	private String uuid;

	private String code;

	private String scheduleCode;

	private String studentCode;

	private String verifyCode;

	private Integer flagSuccess;

	private String createUser;

	private String createTime;

	private String updateUser;

	private String updateTime;

	private String lessonName;

	private String lessonStartTime;

	private String teacherName;

	public String getLessonStartTime() {
		return lessonStartTime;
	}

	public void setLessonStartTime(String lessonStartTime) {
		this.lessonStartTime = lessonStartTime;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

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

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public Integer getFlagSuccess() {
		return flagSuccess;
	}

	public void setFlagSuccess(Integer flagSuccess) {
		this.flagSuccess = flagSuccess;
	}

}