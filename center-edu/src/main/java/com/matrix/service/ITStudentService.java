package com.matrix.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 类: ITStudentService <br>
 * 描述: 学生相关业务处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月18日 下午7:39:50
 */
public interface ITStudentService {

	/**
	 * 
	 * 方法: syllabus <br>
	 * 描述: 获取学生课程表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月18日 下午7:39:16
	 * 
	 * @return
	 */
	JSONObject syllabus(String code);

	/**
	 * 
	 * 方法: faq <br>
	 * 描述: 答疑列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月18日 下午7:40:57
	 * 
	 * @param teacherCode
	 * @return
	 */
	JSONObject faq(String code);

	/**
	 * 
	 * 方法: faqAnswer <br>
	 * 描述: 获取答疑回答列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月18日 下午9:56:09
	 * 
	 * @param code
	 * @return
	 */
	JSONObject faqAnswer(String code);
}
