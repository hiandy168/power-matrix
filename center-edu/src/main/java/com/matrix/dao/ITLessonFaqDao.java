package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TLessonFaq;

/**
 * 
 * 类: TLessonFaqMapper <br>
 * 描述: 课程答疑数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月18日 下午8:20:49
 */
public interface ITLessonFaqDao extends IBaseDao<TLessonFaq, Integer> {

	/**
	 * 
	 * 方法: getFaqForStudent <br>
	 * 描述: 学生答疑列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月18日 下午9:03:27
	 * 
	 * @param studentCode
	 * @return
	 */
	List<TLessonFaq> getFaqForStudent(String studentCode);

	/**
	 * 
	 * 方法: faqAnswerForStudent <br>
	 * 描述: 查询答疑回答列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月18日 下午9:54:57
	 * 
	 * @param teacherCode
	 * @return
	 */
	List<TLessonFaq> faqAnswerForStudent(String code);

	/**
	 * 
	 * 方法: getFaqForTeacher <br>
	 * 描述: 教师答疑列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月18日 下午9:03:38
	 * 
	 * @param teacherCode
	 * @return
	 */
	List<TLessonFaq> getFaqForTeacher(String teacherCode);
}