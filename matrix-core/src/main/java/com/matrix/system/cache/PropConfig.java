package com.matrix.system.cache;

import com.matrix.cache.RootCache;

/**
 * alias TopConfig
 * 初始化加载配置
 * @author HJY 
 */
public class PropConfig extends RootCache<String, String> {

	public final static PropConfig Instance = new PropConfig();

	public synchronized void refresh() {
		SysWorkDir topDir = new SysWorkDir();
		String sTempConfigString = topDir
				.getTempDir(TopConst.CONST_TOP_CUSTOM_CONFIG_PATH);
		// topDir.upZapDir();
		getLogger().logInfo(0, "refresh " + sTempConfigString);
		IoUtil ioHelper = new IoUtil();
		ioHelper.copyResources(
				"classpath*:META-INF/hjy/config/*.properties",
				sTempConfigString, "/hjy/config/");
		LoadProperties loadProperties = new LoadProperties();

		// 开始读取配置
		{
			MStringMap mStringMap = loadProperties.loadMap(sTempConfigString);

			for (String s : mStringMap.getKeys()) {
				this.inElement(s, mStringMap.get(s));
			}
		}

		// 开始扫描扩展自定义的设置
		{
			String sCustom = topDir
					.getCustomPath(TopConst.CONST_TOP_CUSTOM_CONFIG_PATH);
			getLogger().logInfo(0, "scan custom config " + sCustom + "");

			MStringMap mCustomMap = loadProperties.loadMap(sCustom);

			if (mCustomMap.size() == 0) {
				getLogger().logWarn(0, "scan custom config  not exist");
			} else {
				for (String s : mCustomMap.getKeys()) {
					this.inElement(s, mCustomMap.get(s));
				}
			}
		}

		// 开始加载最后本地配置项
		{
			String sLocal = topDir.getLocalConfigPath();
			getLogger().logInfo(0, "scan local config " + sLocal + "");
			MStringMap mCustomMap = loadProperties.loadMap(sLocal);
			for (String s : mCustomMap.getKeys()) {
				this.inElement(s, mCustomMap.get(s));
			}
		}

		// ConfigObservable.INSTANCE.doUpdate(this);

	}

	@Override
	public String getOne(String k) {
		return null;
	}
}