package com.matrix.pojo.dto;

public class RollcallDto {

	/**
	 * 学生编码数组
	 */
	private String studentCodes;
	/**
	 * 教师编码
	 */
	private String teacherCode;
	/**
	 * 验证码
	 */
	private String verifyCode;

	private String scheduleCode;

	public String getStudentCodes() {
		return studentCodes;
	}

	public void setStudentCodes(String studentCodes) {
		this.studentCodes = studentCodes;
	}

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getScheduleCode() {
		return scheduleCode;
	}

	public void setScheduleCode(String scheduleCode) {
		this.scheduleCode = scheduleCode;
	}

}
