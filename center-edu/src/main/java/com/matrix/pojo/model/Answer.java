package com.matrix.pojo.model;

import java.util.Map;
import java.util.TreeMap;

import com.alibaba.fastjson.JSONObject;

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
	// key 答案的序号，value 答案 
	private Map<String , String> map = new TreeMap<String, String>();
	
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
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	public static void main(String[] args) {
		Answer a = new Answer();
		a.setCode("Q76831253356799");
		a.setCount(1);
		a.getMap().put("1", "A");
		a.getMap().put("2", "D");
		String json = JSONObject.toJSONString(a);
		System.out.println(json); 
	}
}

























