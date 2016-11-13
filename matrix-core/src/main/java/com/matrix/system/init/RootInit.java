package com.matrix.system.init;

import com.matrix.base.BaseClass;
import com.matrix.base.interfaces.IBaseCache;

/**
 * @descriptions 初始化调用类的顶层父类
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2016年11月13日 下午12:10:01
 * @version 1.0.1
 */
public abstract class RootInit extends BaseClass {

	public RootInit() {
		getLogger().logInfo(0, "初始化调用类 : " + this.getClass().getName());
	}
 
	
	/**
	 * @descriptions 初始化缓存
	 *
	 * @param baseCaches
	 * @date 2016年11月13日 下午1:36:27
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public void topInitCache(IBaseCache... baseCaches) {
		for (IBaseCache iCache : baseCaches) {
			iCache.refresh();
		}
	}

	public boolean init() {
		return onInit();
	}

	public boolean destory() {
		return onDestory();
	}
 
	/**
	 * @descriptions 当系统初始化时调用
	 *
	 * @return
	 * @date 2016年11月13日 下午1:39:30
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public abstract boolean onInit();
	
	/**
	 * @descriptions 当容器关闭时调用
	 *
	 * @return
	 * @date 2016年11月13日 下午1:39:46
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public abstract boolean onDestory();

}














