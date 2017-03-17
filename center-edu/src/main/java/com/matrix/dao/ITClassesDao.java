package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TClasses;

public interface ITClassesDao extends IBaseDao<TClasses, Integer> {
	public List<TClasses> findAllClasses();

	/**
	 * 
	 * 方法: findClassesByCodes <br>
	 * 描述: 根据班级编码集合查询班级信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月17日 上午9:01:47
	 * 
	 * @param codes
	 * @return
	 */
	List<TClasses> findClassesByCodes(List<String> codes);
}
