package com.matrix.pojo.entity;

import com.matrix.pojo.EduBaseEntity;

public class TTeacher extends EduBaseEntity {
	private String code;
	private String name;
	private Integer sex;

	/**
	 * 课程名称
	 */
	private String lessonName;
	/**
	 * 课程描述
	 */
	private String intro;
	/**
	 * 开始时间
	 */
	private String startTime;
	/**
	 * 课程参加班级编码
	 */
	private String classesCode;

	/**
	 * 课程参加班级名称
	 */
	private String classesName;

	public String getClassesName() {
		return classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getClassesCode() {
		return classesCode;
	}

	public void setClassesCode(String classesCode) {
		this.classesCode = classesCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

}