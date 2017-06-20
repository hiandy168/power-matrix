package com.matrix.pojo.model;

import java.util.List;

/**
 * @descriptions 题目
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2017年3月11日 下午2:28:46
 * @version 1.0.1
 */
public class Question {
	private String code; // 题目在题库中的编号
	private Integer num ; // 题号
	private Integer score; // 分值 
	private String type; // 题型：T0001：单选题；T002：多选题；T003：填空题；T004：判断题；T005：问答题
	private String content; // 题目
	private Boolean picture; // 是否为复杂公式的图片类型题目
	private String url; // 如果picture=true，则为图片类型的题目，则此字段代表该图片的服务器地址
	private List<Option> options; // 选择题的选项  
	private Answer answer; // 该题目的正确答案 
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Boolean getPicture() {
		return picture;
	}
	public void setPicture(Boolean picture) {
		this.picture = picture;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
}
