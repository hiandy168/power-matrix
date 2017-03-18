package com.matrix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseClass;
import com.matrix.dao.ITLessonFaqDao;
import com.matrix.dao.ITStudentDao;
import com.matrix.pojo.entity.TLessonFaq;
import com.matrix.pojo.entity.TStudent;
import com.matrix.service.ITStudentService;

/**
 * 
 * 类: TStudentServiceImpl <br>
 * 描述: TODO <br>
 * 作者: zhy<br>
 * 时间: 2017年3月18日 下午7:58:07
 */
@Service
public class TStudentServiceImpl extends BaseClass implements ITStudentService {

	@Autowired
	private ITStudentDao dao;
	@Autowired
	private ITLessonFaqDao faqDao;

	/**
	 * 
	 * 方法: syllabus <br>
	 * 
	 * @param code
	 * @return
	 * @see com.matrix.service.ITStudentService#syllabus(java.lang.String)
	 */
	@Override
	public JSONObject syllabus(String code) {
		JSONObject result = new JSONObject();
		try {
			List<TStudent> list = dao.getSyllabus(code);
			result.put("data", list);
			result.put("status", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", false);
			result.put("msg", "查询失败，失败原因:" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: faq <br>
	 * 
	 * @param code
	 * @return
	 * @see com.matrix.service.ITStudentService#faq(java.lang.String)
	 */
	@Override
	public JSONObject faq(String code) {
		JSONObject result = new JSONObject();
		try {
			List<TLessonFaq> list = faqDao.getFaqForStudent(code);
			result.put("data", list);
			result.put("status", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", false);
			result.put("msg", "查询失败，失败原因:" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: faqAnswer <br>
	 * 
	 * @param code
	 * @return
	 * @see com.matrix.service.ITStudentService#faqAnswer(java.lang.String)
	 */
	@Override
	public JSONObject faqAnswer(String code) {
		JSONObject result = new JSONObject();
		try {
			List<TLessonFaq> list = faqDao.faqAnswerForStudent(code);
			result.put("data", list);
			result.put("status", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", false);
			result.put("msg", "查询失败，失败原因:" + e.getMessage());
		}
		return result;
	}

}
