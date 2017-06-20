package com.matrix.dao;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TLessonSign;

public interface ITLessonSignDao extends IBaseDao<TLessonSign, Integer> {

	/**
	 * 
	 * 方法: updateEvaluate <br>
	 * 描述: 更改评价状态 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 下午6:29:09
	 * 
	 * @param entity
	 * @return
	 */
	int updateEvaluate(TLessonSign entity);
}
