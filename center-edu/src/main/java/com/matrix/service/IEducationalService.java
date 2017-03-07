package com.matrix.service;

import com.alibaba.fastjson.JSONObject;

public interface IEducationalService {
	/**
	 * @description: 获取签到列表
	 * 
	 * @param tcode teacher code
	 * @param lcode lesson code
	 * @return
	 * @author Yangcl 
	 * @date 2017年3月7日 下午2:01:34 
	 * @version 1.0.0.1
	 */
	public JSONObject findSignList(String tcode , String lcode);
	
	/**
	 * @descriptions 教师开课
	 *
	 * @param tcode teacher code
	 * @param lcode lesson code 
	 * @return
	 * @date 2017年3月7日 下午11:03:14
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public JSONObject startLesson(String tcode , String lcode);
}
