package com.matrix.service;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.matrix.pojo.dto.ExamPaperDto;
import com.matrix.pojo.dto.RegisteDto;
import com.matrix.pojo.entity.TStudySchedule;
import com.matrix.pojo.entity.TTeacher;
import com.matrix.pojo.entity.TUser;

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
	public JSONObject findSignList(String scheduleCode);
	
	/**
	 * @descriptions 教师开课
	 *
	 * @param tcode teacher code
	 * @param lcode lesson code 
	 * @date 2017年3月7日 下午11:03:14
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public JSONObject startLesson(String tcode , String scheduleCode , HttpServletRequest request);
	
	/**
	 * @description: 学生签到接口
	 * 
	 * @param scode 学生编码
	 * @param lcode 课程编码 
	 * @param request
	 * @return
	 * @author Yangcl 
	 * @date 2017年3月8日 下午4:47:00 
	 * @version 1.0.0.1
	 */
	public JSONObject studentSign(String scode , String scheduleCode);

	public JSONObject login(TUser entity);

	public JSONObject registe(RegisteDto entity);

	public JSONObject lessonList(TTeacher entity);

	public JSONObject signLessonList(TTeacher entity);

	public JSONObject questionList(String lessonCode);

	public JSONObject lessonScheduleList(TStudySchedule e);

	public JSONObject examPaperInsert(ExamPaperDto d);       
}















