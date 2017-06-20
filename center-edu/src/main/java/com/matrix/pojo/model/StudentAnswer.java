package com.matrix.pojo.model;

import java.util.List;

/**
 * @descriptions 学生答案模型
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2017年3月11日 下午5:36:05
 * @version 1.0.1
 */
public class StudentAnswer {
	private String paperCode;
	private String studentCode;
	private List<Answer> list;
	
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
	public List<Answer> getList() {
		return list;
	}
	public void setList(List<Answer> list) {
		this.list = list;
	} 
}
