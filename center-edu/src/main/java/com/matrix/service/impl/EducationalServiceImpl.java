package com.matrix.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.base.BaseClass;
import com.matrix.dao.ITClassesDao;
import com.matrix.dao.ITLessonDao;
import com.matrix.dao.ITLessonQrcodeDao;
import com.matrix.dao.ITLessonSignDao;
import com.matrix.dao.ITStudentDao;
import com.matrix.dao.ITTeacherDao;
import com.matrix.dao.ITUserDao;
import com.matrix.pojo.dto.RegisteDto;
import com.matrix.pojo.entity.TClasses;
import com.matrix.pojo.entity.TLesson;
import com.matrix.pojo.entity.TLessonQrcode;
import com.matrix.pojo.entity.TLessonSign;
import com.matrix.pojo.entity.TStudent;
import com.matrix.pojo.entity.TTeacher;
import com.matrix.pojo.entity.TUser;
import com.matrix.pojo.view.LessonView;
import com.matrix.pojo.view.SignListView;
import com.matrix.service.IEducationalService;
import com.matrix.util.UuidUtil;
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
	@Resource
	private ITUserDao userDao;
	@Resource
	private ITClassesDao classesDao;
	
	

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
	public JSONObject startLesson(String tcode, String lcode , HttpServletRequest request) {
		JSONObject result = new JSONObject();
		TLessonQrcode e =  new TLessonQrcode();
		e.setUuid(UuidUtil.uid());  
		e.setTeacherCode(tcode);
		e.setLessonCode(lcode);
		e.setCreateTime(new Date()); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
		String date = sdf.format(new Date());
		String fname = tcode + "@" + lcode;
		String path = "qrcode" +File.separator + fname + "," + date + ".jpg";
		String realPath = request.getServletContext().getRealPath("/") + File.separator + path;  // 获取tomcat真实部署路径 
		
		try {
			QrcodeUtil.getInstance().drawPic("学生签到@" + fname, realPath, 500, 500); 
			e.setQrcodeUrl(path);
			lessonQrcodeDao.insertSelective(e);
			result.put("status", true);
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" + path;
			e.setQrcodeUrl(url);  // 设置真是浏览器路径并发送到前端
			result.put("data", e);  
			result.put("teacher", teacherDao.findEntityByCode(tcode));
			result.put("lesson", lessonDao.findEntityByCode(lcode)); 
		} catch (Exception e2) {
			result.put("status", false);
		}
		return result;
	}

	
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
	public JSONObject studentSign(String scode, String lcode) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		
		TLessonSign e = new TLessonSign();
		e.setUuid(UuidUtil.uid());
		e.setStudentCode(scode);
		e.setLessonCode(lcode);
		e.setCreateTime(new Date());
		try {
			lessonSignDao.insertSelective(e);
			result.put("status", true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}

	public JSONObject login(TUser entity) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		 
		try {
			TUser e = userDao.login(entity);
			if(e != null){
				result.put("status", true);
				result.put("data", e); 
				result.put("msg", "登陆成功");  
			}else{
				result.put("msg", "用户名或密码错误");  
			}
		} catch (Exception ex) {
			ex.printStackTrace(); 
			result.put("msg", "服务器查询异常"); 
		}
		
		
		return result;
	}

	public JSONObject registe(RegisteDto e) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		if(StringUtils.isAnyBlank(e.getEmail(),e.getUsername(),e.getPassword(),e.getType())){
			result.put("msg", "关键信息不可为空");
			return result;
		}
		if(!e.getPassword().equals(e.getConfirm())){
			result.put("msg", "两次密码输入不一致!");
			return result;
		}
		String code = "";
		TUser u =  new TUser();
		u.setUuid(UuidUtil.uid()); 
		u.setUsername(e.getUsername());
		u.setPassword(e.getPassword());
		u.setType(e.getType()); 
		u.setEmail(e.getEmail());
		u.setCreateUser("registe");
		u.setCreateTime(new Date());
		try {
			if(e.getType().equals("T0001")){  // 教师注册
				code = "T" +System.currentTimeMillis();
				TTeacher t = new TTeacher();
				t.setUuid(UuidUtil.uid());
				t.setName(e.getRealName()); 
				t.setCode(code); 
				t.setSex(e.getSex()); 
				t.setCreateUser("registe");
				t.setCreateTime(new Date()); 
				teacherDao.insertSelective(t);
			}else{// 学生注册  
				code = "S" +System.currentTimeMillis(); 
				TStudent s = new TStudent();
				s.setUuid(UuidUtil.uid());
				s.setCode(code);
				s.setName(e.getRealName());
				s.setHeadPic("http://image-family.huijiayou.cn/cfiles/staticfiles/upload/2993e/b1db66d6b4a74c95816c495e12d858e8.jpg");
				s.setCreateUser("registe");
				SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				s.setCreateTime(sdf.format(new Date()));
				sutdentDao.insertSelective(s);
			}
			u.setCode(code);
			userDao.insertSelective(u);
			result.put("status", true);
			result.put("msg", "注册成功!"); 
		} catch (Exception ex) { 
			ex.printStackTrace();
			result.put("msg", "服务器异常,请再次尝试"); 
		}
		return result;
	}

	/**
	 * @description: 查询指定老师下的课程列表
	 * 
	 * @param e
	 * @author Yangcl 
	 * @date 2017年3月10日 下午5:07:43 
	 * @version 1.0.0.1
	 */
	public JSONObject lessonList(TTeacher e) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		try {
			List<TLesson> list = lessonDao.findLessonListByTcode(e.getCode());
			if(list != null && list.size() > 0){
				result.put("status", true);
				result.put("list", list);
			}else{
				result.put("msg", "您暂时没有课程列表");
			}
		} catch (Exception ex) { 
			ex.printStackTrace();
			result.put("msg", "服务器异常");
		}
		
		return result;
	}

	@Override
	public JSONObject signLessonList(TTeacher e) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		List<LessonView> list_ = new ArrayList<>();
		try {
			List<TLesson> list = lessonDao.findLessonListByTcode(e.getCode());
			if(list != null && list.size() > 0){
				result.put("status", true);
				List<TClasses> clalist = classesDao.findAllClasses();
				for(TLesson le : list){
					LessonView v = new LessonView();
					v.setEntity(le); 
					if(StringUtils.isBlank(le.getClassesCode())){
						list_.add(v);
						continue;
					}
					String[] arr = le.getClassesCode().split(",");
					if(arr.length != 0){
						for(int i = 0 ; i < arr.length ; i ++){
							for(TClasses cls : clalist){
								if(arr[i].equals(cls.getCode())){
									v.getClaList().add(cls);
								}
							}
						}
					} 
					list_.add(v);
				}
				
				result.put("list", list_);
			}else{
				result.put("msg", "您暂时没有课程列表");
			}
		} catch (Exception ex) { 
			ex.printStackTrace();
			result.put("msg", "服务器异常");
		}
		
		return result;
	}
	
	
}


































