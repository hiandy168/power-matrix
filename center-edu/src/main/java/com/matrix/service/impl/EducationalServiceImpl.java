package com.matrix.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.matrix.base.BaseClass;
import com.matrix.dao.ITClassesDao;
import com.matrix.dao.ITExamAnswerDao;
import com.matrix.dao.ITExamPaperDao;
import com.matrix.dao.ITExamQuestionsDao;
import com.matrix.dao.ITLessonDao;
import com.matrix.dao.ITLessonQrcodeDao;
import com.matrix.dao.ITLessonSignDao;
import com.matrix.dao.ITStudentDao;
import com.matrix.dao.ITStudentEvaluateDao;
import com.matrix.dao.ITStudyScheduleDao;
import com.matrix.dao.ITTeacherDao;
import com.matrix.dao.ITUserDao;
import com.matrix.pojo.dto.ExamPaperDto;
import com.matrix.pojo.dto.RegisteDto;
import com.matrix.pojo.entity.TClasses;
import com.matrix.pojo.entity.TExamAnswer;
import com.matrix.pojo.entity.TExamPaper;
import com.matrix.pojo.entity.TExamQuestions;
import com.matrix.pojo.entity.TLessonQrcode;
import com.matrix.pojo.entity.TLessonSign;
import com.matrix.pojo.entity.TStudent;
import com.matrix.pojo.entity.TStudentEvaluate;
import com.matrix.pojo.entity.TStudySchedule;
import com.matrix.pojo.entity.TTeacher;
import com.matrix.pojo.entity.TUser;
import com.matrix.pojo.view.LessonResponseView;
import com.matrix.pojo.view.LessonView;
import com.matrix.pojo.view.SignListView;
import com.matrix.pojo.view.StudentView;
import com.matrix.pojo.view.StudyScheduleView;
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
	private ITStudentDao studentDao;
	@Resource
	private ITLessonDao lessonDao;
	@Resource
	private ITLessonQrcodeDao lessonQrcodeDao;
	@Resource
	private ITUserDao userDao;
	@Resource
	private ITClassesDao classesDao;
	@Resource
	private ITExamQuestionsDao examQuestionDao;
	@Resource
	private ITStudyScheduleDao studyScheduleDao;
	@Resource
	private ITExamPaperDao examPaperDao;
	@Resource
	private ITExamAnswerDao examAnswerDao;
	@Resource
	private ITStudentEvaluateDao studentEvaluateDao;

	/**
	 * @description: 获取签到列表
	 * 
	 * @param tcode
	 *            teacher code
	 * @param lcode
	 *            lesson code
	 * @return
	 * @author Yangcl
	 * @date 2017年3月7日 下午2:01:34
	 * @version 1.0.0.1
	 */
	public JSONObject findSignList(String scheduleCode) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		List<SignListView> list = studentDao.findSignList(scheduleCode);
		if (list != null && list.size() > 0) {
			result.put("status", true);
			result.put("list", list);
		}

		return result;
	}

	/**
	 * @descriptions 教师开课
	 *
	 * @param tcode
	 *            teacher code
	 * @param scheduleCode
	 *            schedule_code
	 * @return
	 * @date 2017年3月7日 下午11:03:14
	 * @author Yangcl
	 * @version 1.0.0.1
	 */
	public JSONObject startLesson(String tcode, String scheduleCode, HttpServletRequest request) {
		JSONObject result = new JSONObject();
		TLessonQrcode e = new TLessonQrcode();
		e.setUuid(UuidUtil.uid());
		e.setScheduleCode(scheduleCode);
		e.setCreateUser(tcode);
		e.setCreateTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		String date = sdf.format(new Date());
		String fname = tcode + "@" + scheduleCode;
		String path = "qrcode" + File.separator + fname + "," + date + ".jpg";
		String realPath = request.getServletContext().getRealPath("/") + File.separator + path; // 获取tomcat真实部署路径

		try {
			// 学生签到 md5=831e77780188365d3c0e10791ca23826
			QrcodeUtil.getInstance().drawPic("831e77780188365d3c0e10791ca23826@" + fname, realPath, 500, 500);
			e.setQrcodeUrl(path);
			lessonQrcodeDao.insertSelective(e);
			result.put("status", true);
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/" + path;
			e.setQrcodeUrl(url); // 设置真是浏览器路径并发送到前端
			result.put("data", e);
			result.put("teacher", teacherDao.findEntityByCode(tcode));
			// result.put("lesson", lessonDao.findEntityByCode(lcode));
		} catch (Exception e2) {
			result.put("status", false);
		}
		return result;
	}

	/**
	 * @description: 学生签到接口
	 * 
	 * @param scode
	 *            学生编码
	 * @param lcode
	 *            课程编码
	 * @param request
	 * @return
	 * @author Yangcl
	 * @date 2017年3月8日 下午4:47:00
	 * @version 1.0.0.1
	 */
	public JSONObject studentSign(String scode, String scheduleCode) {
		JSONObject result = new JSONObject();
		result.put("status", false);

		TLessonSign e = new TLessonSign();
		e.setUuid(UuidUtil.uid());
		e.setStudentCode(scode);
		e.setScheduleCode(scheduleCode);
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
			if (e != null) {
				result.put("status", true);
				result.put("data", e);
				result.put("msg", "登陆成功");
			} else {
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
		if (StringUtils.isAnyBlank(e.getEmail(), e.getUsername(), e.getPassword(), e.getType())) {
			result.put("msg", "关键信息不可为空");
			return result;
		}
		if (!e.getPassword().equals(e.getConfirm())) {
			result.put("msg", "两次密码输入不一致!");
			return result;
		}
		String code = "";
		TUser u = new TUser();
		u.setUuid(UuidUtil.uid());
		u.setUsername(e.getUsername());
		u.setPassword(e.getPassword());
		u.setType(e.getType());
		u.setEmail(e.getEmail());
		u.setCreateUser("registe");
		u.setCreateTime(new Date());
		try {
			if (e.getType().equals("T0001")) { // 教师注册
				code = "T" + System.currentTimeMillis();
				TTeacher t = new TTeacher();
				t.setUuid(UuidUtil.uid());
				t.setName(e.getRealName());
				t.setCode(code);
				t.setSex(e.getSex());
				t.setCreateUser("registe");
				t.setCreateTime(new Date());
				teacherDao.insertSelective(t);
			} else {// 学生注册
				code = "S" + System.currentTimeMillis();
				TStudent s = new TStudent();
				s.setUuid(UuidUtil.uid());
				s.setCode(code);
				s.setName(e.getRealName());
				s.setHeadPic(
						"http://image-family.huijiayou.cn/cfiles/staticfiles/upload/2993e/b1db66d6b4a74c95816c495e12d858e8.jpg");
				s.setCreateUser("registe");
				s.setSex(e.getSex());
				s.setCreateTime(new Date());
				studentDao.insertSelective(s);
			}
			u.setCode(code);
			userDao.insertSelective(u);

			try {
				TUser user = userDao.login(u);
				if (user != null) {
					result.put("status", true);
					result.put("data", user);
					result.put("msg", "注册成功!");
				} else {
					result.put("msg", "用户名或密码错误");
				}
			} catch (Exception ex) {
				result.put("msg", "服务器查询异常");
			}
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
			List<LessonView> list = lessonDao.findLessonListByTcode(e.getCode());
			result.put("status", true);
			if (list != null && list.size() > 0) {
				result.put("list", list);
			} else {
				result.put("msg", "您暂时没有课程列表");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			result.put("msg", "服务器异常");
		}

		return result;
	}

	@Override
	public JSONObject signLessonList(TTeacher t) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		List<LessonResponseView> list_ = new ArrayList<LessonResponseView>();
		try {
			List<LessonView> list = lessonDao.findClassLessonListByTcode(t.getCode());
			if (list != null && list.size() > 0) {
				result.put("status", true);
				List<TClasses> clalist = classesDao.findAllClasses();
				// key:lesson_code value:classes_code set 集合
				Map<String, Set<String>> map = new HashMap<String, Set<String>>();
				Set<String> set = null;
				for (LessonView v : list) {
					if (map.containsKey(v.getCode())) {
						String[] arr = v.getClassesCode().split(",");
						for (int i = 0; i < arr.length; i++) {
							map.get(v.getCode()).add(arr[i]);
						}
					} else {
						set = new HashSet<>();
						String[] arr = v.getClassesCode().split(",");
						for (int i = 0; i < arr.length; i++) {
							set.add(arr[i]);
						}
						map.put(v.getCode(), set);
					}
				}

				// {L9970723=[C376765],L8293857=[C376765,C268676,C198797]}
				for (String key : map.keySet()) {
					LessonResponseView re = new LessonResponseView();
					for (LessonView v : list) {
						if (v.getCode().equals(key)) {
							re.setEntity(v);
							break;
						}
					}
					Set<String> lcodes = map.get(key);
					for (String lcode : lcodes) {
						for (TClasses tc : clalist) {
							if (tc.getCode().equals(lcode)) {
								re.getClaList().add(tc);
							}
						}
					}
					list_.add(re);

				}
				result.put("list", list_);

			} else {
				result.put("msg", "您暂时没有课程列表");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			result.put("msg", "服务器异常");
		}

		return result;
	}

	/**
	 * @descriptions
	 * 
	 * @param lessonCode
	 * @return
	 * @date 2017年3月11日 下午9:07:01
	 * @author Yangcl
	 * @version 1.0.0.1
	 */
	public JSONObject questionList(String studentCode, String paperCode, String qcodes) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		try {
			String[] arr = qcodes.split("@");
			List<String> param = new ArrayList<String>(Arrays.asList(arr));
			List<TExamQuestions> list = examQuestionDao.findListByCodes(param);
			if (list != null && list.size() > 0) {
				result.put("status", true);
				result.put("list", list);
				// 查找是否已经回答过，如果回答过则返回答案
				result.put("isAnswer", false);
				TExamAnswer a = new TExamAnswer();
				a.setStudentCode(studentCode);
				a.setPaperCode(paperCode);
				TExamAnswer answer = examAnswerDao.findEntityByTpye(a);
				if (answer != null) {
					result.put("isAnswer", true);
					result.put("answer", JSONObject.parseArray(answer.getAnswer()));
				}
			} else {
				result.put("msg", "暂时没有测试题");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			result.put("msg", "服务器异常");
		}

		return result;
	}

	public JSONObject questionListTeacher(String lessonCode) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		try {
			TExamQuestions e = new TExamQuestions();
			e.setLessonCode(lessonCode);
			List<TExamQuestions> list = examQuestionDao.findList(e);
			if (list != null && list.size() > 0) {
				result.put("status", true);
				result.put("list", list);
			} else {
				result.put("msg", "暂时没有该课程的题库列表");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			result.put("msg", "服务器异常");
		}

		return result;
	}

	@Override
	public JSONObject lessonScheduleList(TStudySchedule e) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		if (StringUtils.isAnyBlank(e.getTeacherCode(), e.getLessonCode())) {
			result.put("msg", "关键字段不得为空");
			return result;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 HH点mm分");  // yyyy-MM-dd HH:mm
			List<LessonResponseView> list_ = new ArrayList<LessonResponseView>();
			List<StudyScheduleView> list = studyScheduleDao.findListByType(e);
			if (list != null && list.size() > 0) {
				result.put("status", true);
				List<TClasses> clalist = classesDao.findAllClasses();
				for (StudyScheduleView s : list) {
					LessonResponseView v = new LessonResponseView();
					String[] arr = s.getClassesCode().split(",");
					for (int i = 0; i < arr.length; i++) {
						for (TClasses c : clalist) {
							if (c.getCode().equals(arr[i])) {
								v.getClaList().add(c);
							}
						}
					}
					LessonView lv = new LessonView();
					lv.setCode(s.getLessonCode());
					lv.setScheduleCode(s.getScheduleCode());
					lv.setLessonName(s.getLessonName());
					lv.setTypeCode(s.getTypeCode());
					lv.setIntro(s.getIntro());
					lv.setStartTime(sdf.format(s.getStartTime()));
					v.setEntity(lv);
					list_.add(v);
				}
				String json = JSONObject.toJSONString(list_, SerializerFeature.DisableCircularReferenceDetect);
				result.put("list", JSONObject.parse(json)); // 解决 $ref 问题

			} else {
				result.put("msg", "暂时没有您的排课列表");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			result.put("msg", "服务器异常");
		}

		return result;
	}

	@Override
	public JSONObject examPaperInsert(ExamPaperDto d) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		try {
			String code = "P" + System.currentTimeMillis();
			String scheduleCode = d.getScheduleCode();
			List<String> list = d.getList();
			for (String s : list) {
				TExamPaper e = new TExamPaper();
				e.setUuid(UuidUtil.uid());
				e.setCode(code);
				e.setScheduleCode(scheduleCode);
				e.setQuestionCode(s);
				e.setStudentCode(d.getStudentCode());
				e.setCreateUser(d.getTeacherCode());
				e.setCreateTime(new Date());
				examPaperDao.insertSelective(e);
			}
			result.put("status", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "服务器异常");
		}
		return result;
	}

	// 学生的排课列表
	public JSONObject studentScheduleList(String classesCode) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		try {
			TStudySchedule ss = new TStudySchedule();
			ss.setClassesCode(classesCode);
			List<StudyScheduleView> list_ = studyScheduleDao.findListByType(ss);
			if (list_ != null && list_.size() != 0) {
				result.put("list", list_);
				result.put("status", true);
			} else {
				result.put("msg", "您的排课列表暂时为空");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			result.put("msg", "服务器异常");
		}
		return result;
	}

	/**
	 * @description: 学生在某一节课的试卷列表，一节课可以包含多个课堂测验试卷
	 * 
	 * @param scheduleCode
	 *            t_exam_paper 的 schedule_code
	 * @param response
	 * @return
	 * @author Yangcl
	 * @date 2017年3月16日 上午11:36:56
	 * @version 1.0.0.1
	 */
	public JSONObject studentPaperList(String scheduleCode) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		try {
			Map<String, List<String>> map = new HashMap<String, List<String>>();
			List<TExamPaper> list_ = examPaperDao.findListByScheduleCode(scheduleCode);
			if (list_ != null && list_.size() > 0) {
				for (TExamPaper e : list_) {
					if (map.containsKey(e.getCode())) {
						map.get(e.getCode()).add(e.getQuestionCode());
					} else {
						List<String> l = new ArrayList<>();
						l.add(e.getQuestionCode());
						map.put(e.getCode(), l);
					}
				}
				result.put("map", map);
				result.put("status", true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			result.put("msg", "服务器异常");
		}
		return result;
	}

	/**
	 * @descriptions htm/student/question_list.html 页面向数据库插入数据 t_exam_answer
	 *
	 * @param paperCode
	 * @param studentCode
	 * @param answers
	 * @return
	 * @date 2017年3月16日 下午9:45:58 ITExamAnswerDao examAnswerDao;
	 * @author Yangcl
	 * @version 1.0.0.1
	 */
	public JSONObject studentInsertAnswer(String paperCode, String studentCode, String answers) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		try {
			TExamAnswer e = new TExamAnswer();
			e.setUuid(UuidUtil.uid());
			e.setPaperCode(paperCode);
			e.setStudentCode(studentCode);
			e.setAnswer(answers);
			e.setCreateUser(studentCode);
			e.setCreateTime(new Date());
			examAnswerDao.insertSelective(e);
			result.put("status", true);
		} catch (Exception ex) {
			ex.printStackTrace();
			result.put("msg", "服务器异常");
		}
		return result;
	}

	@Override
	public JSONObject classStudentList(String classCodes) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		List<StudentViewResponse> list_ = new ArrayList<StudentViewResponse>(); // 向页面返回的数据体
		try {
			String[] arr = classCodes.split(",");
			List<String> param = new ArrayList<String>(Arrays.asList(arr));
			List<StudentView> list = studentDao.findListByCodes(param);
			if (list != null && list.size() != 0) {
				// 根据班级名称进行区分 key = class_name value = list
				Map<String, List<StudentView>> map = new TreeMap<String, List<StudentView>>();
				for (StudentView v : list) {
					if (map.containsKey(v.getClassName())) {
						map.get(v.getClassName()).add(v);
					} else {
						List<StudentView> svList = new ArrayList<StudentView>();
						svList.add(v);
						map.put(v.getClassName(), svList);
					}
				}
				for (String key : map.keySet()) {
					StudentViewResponse svr = new StudentViewResponse();
					svr.setClassName(key);
					svr.setList(map.get(key));
					list_.add(svr);
				}
				result.put("data", list_);
				result.put("status", true);
			} else {
				result.put("msg", "这节课暂未关联班级信息");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			result.put("msg", "服务器异常");
		}
		return result;
	}

	/**
	 * @description: 学生在某一节课的试卷列表，一节课可以包含多个课堂测验试卷
	 * 
	 * @param scheduleCode
	 *            t_exam_paper 的 schedule_code
	 * @param response
	 * @return
	 * @author Yangcl
	 * @date 2017年3月16日 上午11:36:56
	 * @version 1.0.0.1
	 */
	public JSONObject inspectStudentPaperList(String scheduleCode, String studentCode) {
		JSONObject result = new JSONObject();
		result.put("status", false);
		Map<String, String> pmap = new HashMap<>();
		pmap.put("scheduleCode", scheduleCode);
		pmap.put("studentCode", studentCode);
		try {
			Map<String, List<String>> map = new HashMap<String, List<String>>();
			List<TExamPaper> list_ = examPaperDao.findListByMap(pmap);
			if (list_ != null && list_.size() > 0) {
				for (TExamPaper e : list_) {
					if (map.containsKey(e.getCode())) {
						map.get(e.getCode()).add(e.getQuestionCode());
					} else {
						List<String> l = new ArrayList<>();
						l.add(e.getQuestionCode());
						map.put(e.getCode(), l);
					}
				}
				result.put("map", map);
				result.put("status", true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			result.put("msg", "服务器异常");
		}
		return result;
	}
}

class StudentViewResponse {
	private String className;
	private List<StudentView> list;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<StudentView> getList() {
		return list;
	}

	public void setList(List<StudentView> list) {
		this.list = list;
	}
}
