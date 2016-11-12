package com.matrix.system.cache;

import org.apache.commons.lang.StringUtils;

import com.matrix.helper.FormatHelper;
import com.matrix.map.MStringMap;

/**
 * @description: 访问每一个依赖power-matrix项目的sub module中的配置文件缓存信息
 * @alias TopUp
 * 
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2016年10月18日 下午1:46:37 
 * @version 1.0.0
 */
public class PropVisitor {
	private final static PropInfo topInfo = new PropInfo();
	private final static ConfigMap configMap=new ConfigMap();
	
	/**
	 * @description: 获取META-INF//module//config//config.*.properties文件的某个系统常量定义配置项
	 * 	这是一个主要的应用方法|获取第三方接口地址、用户名、密码等等。
	 * 
	 * @param sKey
	 * @return
	 * @author Yangcl 
	 * @date 2016年10月18日 下午1:52:16 
	 * @version 1.0.0.1
	 */
	public static String getConfig(String sKey) {
		return PropConfig.Instance.getValue(sKey);
	}

	/**
	 * @description: 获取//info//info.*.*.properties文件的某个消息常量定义
	 * 	如：967905004=JMS消息发送成功标题：{0}内容：{1}  | 此方法用于国际化
	 * 	这个配置文件的示例名称：info.seller-adapter.8668.properties|seller-adapter: sub module name | 8668:info message start number
	 * 
	 * @param iInfoCode
	 * @return
	 * @author Yangcl 
	 * @date 2016年10月18日 下午1:55:04 
	 * @version 1.0.0.1
	 */
	public static String getInfo(long iInfoCode) {
		return topInfo.getValue(iInfoCode);
	}
	
	/**
	 * @descriptions 在系统初始化的时候去获取配置的缓存信心|When system init , this function will be used.
	 *
	 * @param key
	 * @date 2016年11月12日 下午6:59:32
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public static MStringMap getConfigMap(String key) {
		return configMap.getValue(key);
	}
	

	/**
	 * @descriptions 格式化日志内容
	 * @alias upLogInfo
	 * 
	 * @param infoCode
	 * @param params
	 * @return
	 * @date 2016年11月12日 下午7:02:41
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public static String getLogInfo(int infoCode, Object... params){
		return (infoCode<1 ? StringUtils.join(params) : FormatHelper.formatString(getInfo(infoCode) , params));
	}
}


















