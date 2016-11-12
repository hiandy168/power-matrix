package com.matrix.system.cache;

import com.matrix.cache.RootCache;
import com.matrix.map.MStringMap;
import com.matrix.util.IoUtil;

/**
 * alias TopConfig
 * 初始化加载配置
 * @author HJY 
 */
public class PropConfig extends RootCache<String, String> {

	public final static PropConfig Instance = new PropConfig();

	public synchronized void refresh() {
		SysWorkDir sysWorkDir = new SysWorkDir();
		String tempPath = sysWorkDir.getTempDir(TopConst.CONST_TOP_CUSTOM_CONFIG_PATH);
		getLogger().logInfo(0, "开始同步并刷新项目配置文件： " + tempPath);
		IoUtil ioHelper = new IoUtil();
		ioHelper.copyResources("classpath*:META-INF/matrix/config/*.properties" , tempPath , "/matrix/config/");
		
		LoadProperties loadProperties = new LoadProperties();
		{	// 开始读取配置
			MStringMap mStringMap = loadProperties.loadMap(tempPath);
			for (String s : mStringMap.getKeys()) {
				this.addElement(s, mStringMap.get(s));
			}
		}

		{	// 开始扫描扩展自定义的设置
			String customConfig = sysWorkDir.getCustomPath(TopConst.CONST_TOP_CUSTOM_CONFIG_PATH);
			getLogger().logInfo(0, " 开始扫描扩展自定义缓存设置：" + customConfig + "");
			MStringMap customMap = loadProperties.loadMap(customConfig);
			if (customMap.size() == 0) {
				getLogger().logWarn(0, "不存在自定义缓存");
			} else {
				for (String s : customMap.getKeys()) {
					this.addElement(s, customMap.get(s));
				}
			}
		}
		
		{	// 开始加载最后本地配置项
			String localConfig = sysWorkDir.getLocalConfigPath();
			getLogger().logInfo(0, "开始加载最后本地配置项： " + localConfig + "");
			MStringMap customMap = loadProperties.loadMap(localConfig);
			for (String s : customMap.getKeys()) {
				this.addElement(s, customMap.get(s));
			}
		}
	}


	/**
	 * @descriptions 默认返回空 
	 * 
	 * @date 2016年11月12日 下午6:15:53
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	@Override
	public String getOneSetCatch(String k) {
		return null;
	}
}




























