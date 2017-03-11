package com.matrix.pojo.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * @descriptions 每一道题的答案案模型 
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2017年3月11日 下午5:36:30
 * @version 1.0.1
 */
public class Answer {
	private String code ; // 题号
	/**
	 * 答案数量  
	 * 	单选题：1个答案，count = 1
	 * 	多选题：n个答案，count >= 1
	 *     填空题：可能会多余一个空，所以 count >= 1
	 */
	private Integer count; 
	private Map<Integer , String> map = new TreeMap<Integer, String>();
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Map<Integer, String> getMap() {
		return map;
	}
	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}
}
