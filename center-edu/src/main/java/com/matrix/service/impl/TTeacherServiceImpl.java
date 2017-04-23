package com.matrix.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseClass;
import com.matrix.dao.ITClassesDao;
import com.matrix.dao.ITLessonFaqDao;
import com.matrix.dao.ITLessonRollcallDao;
import com.matrix.dao.ITLessonSignDao;
import com.matrix.dao.ITStudentDao;
import com.matrix.dao.ITStudentEvaluateDao;
import com.matrix.dao.ITTeacherDao;
import com.matrix.pojo.dto.RollcallDto;
import com.matrix.pojo.entity.TClasses;
import com.matrix.pojo.entity.TLessonFaq;
import com.matrix.pojo.entity.TLessonRollcall;
import com.matrix.pojo.entity.TLessonSign;
import com.matrix.pojo.entity.TStudent;
import com.matrix.pojo.entity.TStudentEvaluate;
import com.matrix.pojo.entity.TTeacher;
import com.matrix.service.ITTeacherService;
import com.matrix.util.DateUtil;
import com.matrix.util.UuidUtil;

/**
 * 
 * 类: ITTeacherService <br>
 * 描述: 教师相关业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月18日 下午7:40:27
 */
@Service
public class TTeacherServiceImpl extends BaseClass implements ITTeacherService {

	@Autowired
	private ITTeacherDao dao;
	@Autowired
	private ITStudentDao studentDao;
	@Autowired
	private ITClassesDao classesDao;

	@Autowired
	private ITStudentEvaluateDao studentEvaluateDao;

	@Autowired
	private ITLessonSignDao lessonSignDao;

	@Autowired
	private ITLessonFaqDao faqDao;

	@Autowired
	private ITLessonRollcallDao rollcallDao;

	@Override
	public JSONObject teacherLessons(String code) {
		JSONObject result = new JSONObject();
		try {
			List<TTeacher> teachers = dao.getLessons(code);
			if (teachers != null && teachers.size() > 0) {
				for (TTeacher t : teachers) {
					if (StringUtils.isNotBlank(t.getClassesCode())) {
						String[] class_codes = t.getClassesCode().split(",");
						List<String> codes = new ArrayList<String>(Arrays.asList(class_codes));
						List<TClasses> classes = classesDao.findClassesByCodes(codes);
						if (classes != null && classes.size() > 0) {
							t.setClassesName(JSONArray.toJSON(classes).toString());
						} else {
							result.put("status", false);
							result.put("msg", "查询课程信息失败");
							break;
						}
					}
				}
				result.put("data", teachers);
			} else {
				result.put("data", "");
			}
			result.put("status", true);
		} catch (Exception e) {
			result.put("status", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}

	@Override
	public JSONObject lessonClassStudents(String scheduleCode) {
		JSONObject result = new JSONObject();
		try {
			List<TStudent> list = studentDao.findStudentSignByScheduleCode(scheduleCode);
			if (list != null && list.size() > 0) {
				result.put("data", list);
			} else {
				result.put("data", "");
			}
			result.put("status", true);
		} catch (Exception e) {
			result.put("status", true);
			result.put("msg", e.getMessage());
		}
		return result;
	}

	@Override
	public JSONObject studentEvaluateByTeacher(TStudentEvaluate entity) {
		JSONObject result = new JSONObject();
		try {
			entity.setUuid(UuidUtil.uid());
			entity.setCreateTime(new Date());
			int flag = studentEvaluateDao.insertSelective(entity);
			if (flag > 0) {
				TLessonSign sign = new TLessonSign();
				sign.setStudentCode(entity.getStudentCode());
				sign.setScheduleCode(entity.getScheduleCode());
				sign.setFlagEvaluate(1);
				sign.setUpdateUser(entity.getCreateUser());
				sign.setUpdateTime(entity.getCreateTime());
				lessonSignDao.updateEvaluate(sign);
				result.put("status", true);
			} else {
				result.put("status", false);
				result.put("msg", "提交评价失败");
			}
		} catch (Exception e) {
			result.put("status", false);
			result.put("msg", "提交评价错误，错误原因:" + e.getMessage());
		}
		return result;
	}

	@Override
	public JSONObject syllabus(String code) {
		JSONObject result = new JSONObject();
		try {
			List<TTeacher> teachers = dao.getSyllabus(code);
			if (teachers != null && teachers.size() > 0) {
				for (TTeacher t : teachers) {
					if (StringUtils.isNotBlank(t.getClassesCode())) {
						String[] class_codes = t.getClassesCode().split(",");
						List<String> codes = new ArrayList<String>(Arrays.asList(class_codes));
						List<TClasses> classes = classesDao.findClassesByCodes(codes);
						if (classes != null && classes.size() > 0) {
							StringBuffer classNames = new StringBuffer();
							for (TClasses c : classes) {
								classNames.append(c.getClassName()).append(",");
							}
							t.setClassesName(classNames.substring(0, classNames.length() - 1));
						} else {
							result.put("status", false);
							result.put("msg", "查询班级信息失败");
							break;
						}
					}
				}
				result.put("data", teachers);
			}
			result.put("status", true);
		} catch (Exception e) {
			result.put("status", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: faq <br>
	 * 
	 * @param teacherCode
	 * @return
	 * @see com.matrix.service.ITTeacherService#faq(java.lang.String)
	 */
	@Override
	public JSONObject faq(String teacherCode) {
		JSONObject result = new JSONObject();
		try {
			List<TLessonFaq> list = faqDao.getFaqForTeacher(teacherCode);
			if (list != null && list.size() > 0) {
				result.put("data", list);
			} else {
				result.put("data", "");
			}
			result.put("status", true);
		} catch (Exception e) {
			result.put("status", false);
			result.put("msg", "查询失败，失败原因:" + e.getMessage());
		}
		return result;

	}

	/**
	 * 
	 * 方法: rollcall <br>
	 * 
	 * @param dto
	 * @return
	 * @see com.matrix.service.ITTeacherService#rollcall(com.matrix.pojo.dto.RollcallDto)
	 */
	@Override
	public JSONObject rollcall(RollcallDto dto) {
		JSONObject result = new JSONObject();
		try {
			String[] studentCodes = dto.getStudentCodes().split(",");
			List<TLessonRollcall> list = new ArrayList<TLessonRollcall>();
			for (int i = 0; i < studentCodes.length; i++) {
				TLessonRollcall entity = new TLessonRollcall();
				entity.setUuid(UuidUtil.uid());
				entity.setCode("RC" + System.currentTimeMillis());
				entity.setScheduleCode(dto.getScheduleCode());
				entity.setVerifyCode(dto.getVerifyCode());
				entity.setStudentCode(studentCodes[i]);
				entity.setCreateUser(dto.getTeacherCode());
				entity.setCreateTime(DateUtil.getSysDateTime());
				list.add(entity);
			}
			rollcallDao.batchInsert(list);
			result.put("status", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", false);
			result.put("msg", "发送失败，失败原因:" + e.getMessage());
		}
		return result;
	}

	@Override
	public JSONObject rollcallCourseStudents(String scheduleCode) {
		JSONObject result = new JSONObject();
		try {
			List<TStudent> list = studentDao.findStudentSignByScheduleCodeForRollcall(scheduleCode);
			if (list != null && list.size() > 0) {
				result.put("data", list);
			} else {
				result.put("data", "");
			}
			result.put("status", true);
		} catch (Exception e) {
			result.put("status", true);
			result.put("msg", e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: getTeacherDetail <br>
	 * 
	 * @param code
	 * @return
	 * @see com.matrix.service.ITTeacherService#getTeacherDetail(java.lang.String)
	 */
	@Override
	public JSONObject getTeacherDetail(String code, HttpServletRequest request) {

		JSONObject result = new JSONObject();
		try {
			TTeacher teacher = dao.getTeacherDetail(code);
			if (teacher != null) {
				// 编写图片访问路径
				String path = "images" + File.separator + "center-edu" + File.separator + "studentHead"
						+ File.separator;
				String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
						+ request.getContextPath() + File.separator + path;
				teacher.setHeadPic(url + teacher.getHeadPic());
				result.put("data", teacher);
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
	 * 方法: getEvaluateDetail <br>
	 * 
	 * @param code
	 * @return
	 * @see com.matrix.service.ITTeacherService#getEvaluateDetail(java.lang.String)
	 */
	@Override
	public JSONObject getEvaluateDetail(Integer id) {
		JSONObject result = new JSONObject();
		try {
			TStudentEvaluate entity = studentEvaluateDao.selectByPrimaryIds(id);
			if (entity != null) {
				result.put("data", entity);
			} else {
				result.put("data", "");
			}
			result.put("status", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", false);
			result.put("msg", "查询评价错误，错误原因：" + e.getMessage());
		}
		return result;
	}

}
