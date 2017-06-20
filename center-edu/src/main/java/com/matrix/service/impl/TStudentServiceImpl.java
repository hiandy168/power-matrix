package com.matrix.service.impl;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseClass;
import com.matrix.dao.ITLessonFaqDao;
import com.matrix.dao.ITLessonRollcallDao;
import com.matrix.dao.ITStudentDao;
import com.matrix.pojo.entity.TLessonFaq;
import com.matrix.pojo.entity.TLessonRollcall;
import com.matrix.pojo.entity.TStudent;
import com.matrix.service.ITStudentService;
import com.matrix.util.DateUtil;

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
	@Autowired
	private ITLessonRollcallDao rollcallDao;

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
			if (list != null && list.size() > 0) {
				result.put("data", list);
			} else {
				result.put("data", "");
			}
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
			if (list != null && list.size() > 0) {
				result.put("data", list);
			} else {
				result.put("data", "");
			}
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
			if (list != null && list.size() > 0) {
				result.put("data", list);
			} else {
				result.put("data", "");
			}
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
	 * 方法: getStudentDetail <br>
	 * 
	 * @param code
	 * @return
	 * @see com.matrix.service.ITStudentService#getStudentDetail(java.lang.String)
	 */
	@Override
	public JSONObject getStudentDetail(String code, HttpServletRequest request) {
		JSONObject result = new JSONObject();
		try {
			TStudent student = dao.getStudentDetail(code);
			if (student != null) {
				// 编写图片访问路径
				String path = "images" + File.separator + "center-edu" + File.separator + "studentHead"
						+ File.separator;
				String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
						+ request.getContextPath() + File.separator + path;
				student.setHeadPic(url + student.getHeadPic());
				result.put("data", student);
			} else {
				result.put("data", "");
			}

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
	 * 方法: getRollcallByStudent <br>
	 * 
	 * @param studentCode
	 * @return
	 * @see com.matrix.service.ITStudentService#getRollcallByStudent(java.lang.String)
	 */
	@Override
	public JSONObject getRollcallByStudent(String studentCode) {
		JSONObject result = new JSONObject();
		try {
			List<TLessonRollcall> students = rollcallDao.getRollcallByStudent(studentCode);
			if (students != null && students.size() > 0) {
				result.put("data", students);
			} else {
				result.put("data", "");
			}
			result.put("status", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", false);
			result.put("msg", "查询失败，失败原因:" + e.getMessage());
		}
		return result;
	}

	@Override
	public JSONObject rollcall(String code, String studentCode) {
		JSONObject result = new JSONObject();
		try {
			TLessonRollcall entity = new TLessonRollcall();
			entity.setCode(code);
			entity.setUpdateUser(studentCode);
			entity.setUpdateTime(DateUtil.getSysDateTime());
			entity.setFlagSuccess(1);
			rollcallDao.updateSelective(entity);
			result.put("status", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", false);
			result.put("msg", "确认点名失败，失败原因:" + e.getMessage());
		}
		return result;
	}

}
