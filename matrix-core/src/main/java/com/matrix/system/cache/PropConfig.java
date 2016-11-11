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

		// 开始读取配置
		{
			MStringMap mStringMap = loadProperties.loadMap(tempPath);

			for (String s : mStringMap.getKeys()) {
				this.addElement(s, mStringMap.get(s));
			}
		}

		// 开始扫描扩展自定义的设置
		{
			String sCustom = sysWorkDir.getCustomPath(TopConst.CONST_TOP_CUSTOM_CONFIG_PATH);
			getLogger().logInfo(0, "scan custom config " + sCustom + "");

			MStringMap mCustomMap = loadProperties.loadMap(sCustom);

			if (mCustomMap.size() == 0) {
				getLogger().logWarn(0, "scan custom config  not exist");
			} else {
				for (String s : mCustomMap.getKeys()) {
					this.addElement(s, mCustomMap.get(s));
				}
			}
		}

		// 开始加载最后本地配置项
		{
			String sLocal = sysWorkDir.getLocalConfigPath();
			getLogger().logInfo(0, "scan local config " + sLocal + "");
			MStringMap mCustomMap = loadProperties.loadMap(sLocal);
			for (String s : mCustomMap.getKeys()) {
				this.addElement(s, mCustomMap.get(s));
			}
		}
	}


	@Override
	public String getOneSetCatch(String k) {
		return null;
	}
}




























