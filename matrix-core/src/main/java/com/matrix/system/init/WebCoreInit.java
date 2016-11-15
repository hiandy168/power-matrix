package com.matrix.system.init;

import org.apache.commons.lang.StringUtils;

import com.matrix.cache.CacheDefine;
import com.matrix.system.cache.TopConst;

/**
 * @descriptions matrix-core 初始化类
 * @alias InitZapcom
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2016年11月15日 下午9:41:57
 * @version 1.0.1
 */
public class WebCoreInit extends RootInit {

	public boolean onInit() {
		return initVersion();
	}

	/**
	 * @descriptions 初始化版本号
	 *
	 * @return
	 * @date 2016年11月15日 下午9:42:48
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public boolean initVersion() {
		TopConst.CONST_CURRENT_MODEL = getConfig("webcore.model");
		String version = getConfig("webcore.version");
		String custVersion = getConfig("webcore.version_" + TopConst.CONST_CURRENT_MODEL);
		if (StringUtils.isNotBlank(custVersion)) {
			version = custVersion;
		}
		TopConst.CONST_CURRENT_VERSION = version;
		TopConst.CONST_LOG_TYPE = getConfig("webcore.log_type");   // 统一日志的操作类型
		TopConst.CONST_LOG_ADDRESS = getConfig("webcore.log_address");  // 统一日志的传送地址
		return true;

	}

	@Override
	public boolean onDestory() {
		// 清除所有缓存
		new CacheDefine().removeAllCache();
		return true;
	}

}



















