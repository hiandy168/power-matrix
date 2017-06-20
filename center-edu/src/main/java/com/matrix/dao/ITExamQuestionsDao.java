package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TExamQuestions;

public interface ITExamQuestionsDao extends IBaseDao<TExamQuestions, Integer> {

	/**
	 * @description: 
	 * 
	 * @param list question codes
	 * @return
	 * @author Yangcl 
	 * @date 2017年3月16日 下午3:02:45 
	 * @version 1.0.0.1
	 */
	List<TExamQuestions> findListByCodes(List<String> list); 

}
