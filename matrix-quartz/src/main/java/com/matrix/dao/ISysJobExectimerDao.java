package com.matrix.dao;

import java.util.List;

import com.matrix.base.interfaces.IBaseDao;
import com.matrix.pojo.entity.SysJobExectimer;


public interface ISysJobExectimerDao extends IBaseDao<SysJobExectimer, Integer> {

	/**
	 * @descriptions JobServiceImpl 使用一次
	 * 
	 * @param entity
	 * @return
	 * @date 2016年6月22日下午3:38:32
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public Integer updateSelectiveByExecCode(SysJobExectimer entity);
	
	 
	
	/**
	 * @descriptions KjtOperationsManagerServiceImpl 调用一次
	 *  
	 * @date 2016年8月25日下午1:47:41
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public Integer updateSelectiveByFlag(SysJobExectimer entity);
	
	public Integer updateSelectiveByOrderCode(SysJobExectimer entity);
	
	/**
	 * @description: 根据  exec_type 和 exec_info 来查询一个订单
	 *
	 * @author Yangcl
	 * @date 2016年9月18日 下午5:54:43 
	 * @version 1.0.0.1
	 */
	public List<SysJobExectimer> findByOrderCode(SysJobExectimer entity);
	
	/**
	 * @description: 找到特定商户下等待同步推送的订单
	 *
	 * @author Yangcl
	 * @date 2016年9月20日 下午5:51:20 
	 * @version 1.0.0.1
	 */
	public List<SysJobExectimer> findRsyncOrderList(SysJobExectimer entity);
}


















