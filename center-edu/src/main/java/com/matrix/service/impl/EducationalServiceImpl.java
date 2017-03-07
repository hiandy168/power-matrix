package com.matrix.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.dao.ITLessonDao;
import com.matrix.dao.ITLessonSignDao;
import com.matrix.dao.ITStudentDao;
import com.matrix.dao.ITTeacherDao;
import com.matrix.pojo.entity.TStudent;
import com.matrix.pojo.view.SignListView;
import com.matrix.service.IEducationalService;

@Service
public class EducationalServiceImpl implements IEducationalService {

	@Resource
	private ITLessonSignDao lessonSignDao;
	
	@Resource
	private ITTeacherDao teacherDao;
	
	@Resource
	private ITStudentDao sutdentDao;
	
	@Resource 
	private ITLessonDao lessonDao;

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
	public JSONObject findSignList(String tcode, String lcode) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		List<SignListView> list = sutdentDao.findSignList(lcode);
		if(list != null && list.size() > 0){
			result.put("status", true);
			result.put("list", list);
		}
		
		return result;
	}
	
	
}


































