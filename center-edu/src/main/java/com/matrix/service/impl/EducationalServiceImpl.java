package com.matrix.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseClass;
import com.matrix.dao.ITLessonDao;
import com.matrix.dao.ITLessonQrcodeDao;
import com.matrix.dao.ITLessonSignDao;
import com.matrix.dao.ITStudentDao;
import com.matrix.dao.ITTeacherDao;
import com.matrix.pojo.entity.TLessonQrcode;
import com.matrix.pojo.view.SignListView;
import com.matrix.service.IEducationalService;
import com.matrix.utils.QrcodeUtil;

@Service
public class EducationalServiceImpl extends BaseClass implements IEducationalService {

	@Resource
	private ITLessonSignDao lessonSignDao;
	@Resource
	private ITTeacherDao teacherDao;
	@Resource
	private ITStudentDao sutdentDao;
	@Resource 
	private ITLessonDao lessonDao;
	@Resource
	private ITLessonQrcodeDao lessonQrcodeDao;
	
	

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
	public JSONObject startLesson(String tcode, String lcode) {
		JSONObject result = new JSONObject();
		TLessonQrcode e =  new TLessonQrcode();
		e.setUuid(UUID.randomUUID().toString().replace("-", ""));  
		e.setTeacherCode(tcode);
		e.setLessonCode(lcode);
		e.setCreateTime(new Date()); 
		String fname = tcode + "@" + lcode;
		String path = this.getConfig("center-edu.qrcode_save_path") + fname;
		try {
			QrcodeUtil.getInstance().drawPic(fname, path, 500, 500); 
			e.setQrcodeUrl(path);
			lessonQrcodeDao.insertSelective(e);
			result.put("status", true);
			result.put("data", e);  
		} catch (Exception e2) {
			result.put("status", false);
		}
		return result;
	}
	
	
}


































