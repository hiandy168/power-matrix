package com.matrix.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.matrix.dao.ITLessonDao;
import com.matrix.dao.ITLessonSignDao;
import com.matrix.dao.ITStudentDao;
import com.matrix.dao.ITTeacherDao;
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
	
	
}
