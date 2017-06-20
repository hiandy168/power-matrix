package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.TLessonRollcall;

/**
 * 
 * 类: ITLessonRollcallDao <br>
 * 描述: 课程点名数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月21日 下午3:18:27
 */
public interface ITLessonRollcallDao extends IBaseDao<TLessonRollcall, Integer> {

	/**
	 * 
	 * 方法: batchInsert <br>
	 * 描述: 批量添加
	 * 
	 * @param list
	 * @return
	 * @see com.matrix.base.interfaces.IBaseDao#batchInsert(java.util.List)
	 */
	Integer batchInsert(List<TLessonRollcall> list);

	/**
	 * 
	 * 方法: getRollcallByStudent <br>
	 * 描述: 根据学生编码查询课程点名列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年3月21日 下午6:13:54
	 * 
	 * @param studentCode
	 * @return
	 */
	List<TLessonRollcall> getRollcallByStudent(String studentCode);
}
