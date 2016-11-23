package com.matrix.helper;

import com.matrix.support.LogSupport;

public class LogHelper {
	/**
	 * @descriptions 添加日志
	 *
	 * @param sType
	 * @param sInfo
	 * @return
	 * @date 2016年11月23日 下午9:13:33
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public static boolean addLogString(String sType, String sInfo) {
		return LogSupport.getInstance().addLog(sType, sInfo);
	}

	/**
	 * @descriptions  添加日志
	 *
	 * @param sType
	 * @param oInfo
	 * @date 2016年11月23日 下午9:13:18
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public static boolean addLog(String sType, Object oInfo) {
		return LogSupport.getInstance().addLog(sType, JsonHelper.toJson(oInfo));
	}

}
