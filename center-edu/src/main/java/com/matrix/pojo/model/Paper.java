package com.matrix.pojo.model;

import java.util.Date;
import java.util.List;

/**
 * @descriptions 试卷数据模型
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2017年3月11日 下午5:25:15
 * @version 1.0.1
 */
public class Paper {
	private String code; // 试卷编号
	private String teacherCode; // 教师编号
	private String lessonCode; // 课程编号
	private Integer totalScore; // 试卷总分
	private List<Question> list;  // 题目集合
	private Date createTime;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTeacherCode() {
		return teacherCode;
	}
	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}
	public String getLessonCode() {
		return lessonCode;
	}
	public void setLessonCode(String lessonCode) {
		this.lessonCode = lessonCode;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	public List<Question> getList() {
		return list;
	}
	public void setList(List<Question> list) {
		this.list = list;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
