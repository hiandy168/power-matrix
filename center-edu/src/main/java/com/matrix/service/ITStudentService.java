package com.matrix.service;

import javax.servlet.http.HttpServletRequest;

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

	/**
	 * 
	 * 方法: getStudentDetail <br>
	 * 描述: 根据编码查询学生详情 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月21日 下午5:24:06
	 * 
	 * @param code
	 * @return
	 */
	JSONObject getStudentDetail(String code, HttpServletRequest request);

	/**
	 * 
	 * 方法: getRollcallByStudent <br>
	 * 描述: 根据学生编码查询课程点名列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月21日 下午6:13:54
	 * 
	 * @param studentCode
	 * @return
	 */
	JSONObject getRollcallByStudent(String studentCode);

	/**
	 * 
	 * 方法: rollcall <br>
	 * 描述: 确认点名 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月21日 下午6:27:19
	 * 
	 * @param code
	 * @return
	 */
	JSONObject rollcall(String code, String studentCode);
}
