package com.matrix.support;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.matrix.base.BaseClass;
import com.matrix.cache.impl.LogCache;
import com.matrix.helper.FormatHelper;
import com.matrix.map.MDataMap;
import com.matrix.pojo.entity.system.LogInfo;
import com.matrix.system.cache.SysWorkDir;
import com.matrix.system.cache.TopConst;
import com.matrix.util.JsonHelper;
import com.matrix.util.NetUtil;


/**
 * @descriptions 日志支持类，原作者不详。
 *
 * @copy_by Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2016年11月22日 下午10:56:25
 * @version 1.0.1
 */
public class LogSupport extends BaseClass {

	private static LogSupport instance = null;
	private static String serverCode = "";

	public static LogSupport getInstance() {
		if (instance == null) {
			synchronized (LogSupport.class) {
				if (null == instance) {
					instance = new LogSupport();
					serverCode = NetUtil.getLocalIP() + ":" + StringUtils.substringAfterLast(new SysWorkDir().getServerletPath(""), "/");
				}
			}
		}
		return instance;
	}

	private LogCache logCache = new LogCache();

	public LogSupport() {}

	/**
	 * 添加日志
	 * 
	 * @param sType
	 * @param sContent
	 * @return
	 */
	public boolean addLog(String sType, String sContent) {
		boolean bReturn = true;
		if (StringUtils.isNotBlank(TopConst.CONST_LOG_TYPE)) {
			String sUuid = UUID.randomUUID().toString().replace("-", "");
			LogInfo logInfo = new LogInfo();
			logInfo.setUid(sUuid);
			logInfo.setType(sType);
			logInfo.setCreate(FormatHelper.upDateTime());
			logInfo.setInfo(sContent);
			logInfo.setServer(serverCode);
			logCache.inElement(sUuid, logInfo);
		} else {
			getLogger().logDebug(967905006);
			bReturn = false;
		}
		return bReturn;
	}

	/**
	 * 获取并删除定指定数量量的日志内容
	 * 
	 * @return
	 */
	public List<LogInfo> upLogListAndRemove(int iNumber) {
		List<LogInfo> logList = new ArrayList<LogInfo>();
		List<String> listKeys = logCache.getKeys();
		for (int i = 0; i < Math.min(iNumber, listKeys.size()); i++) {
			logList.add(logCache.getValueAndRemove(listKeys.get(i)));
		}
		return logList;
	}

	public boolean sendLogToServer() {
		SendLog sendLog = new SendLog();
		sendLog.setModel(TopConst.CONST_CURRENT_MODEL);
		// 防止出现过大body包 每次最大1000条
		sendLog.setLogs(upLogListAndRemove(1000));
		// TopConst.CONST_LOG_ADDRESS="http://localhost:3000/log/baselog";

		if (sendLog.getLogs() != null && sendLog.getLogs().size() > 0) {
			try {
				WebClientSupport.upPost(TopConst.CONST_LOG_ADDRESS, new MDataMap("api_input", JsonHelper.toJson(sendLog)));
			} catch (Exception e) {
				getLogger().logError(967905007 , e.getMessage());
				e.printStackTrace();
			}
		}
		return true;
	}
}






















