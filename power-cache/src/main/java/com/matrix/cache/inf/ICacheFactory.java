package com.matrix.cache.inf;

public interface ICacheFactory {
	
	public void setCache(String key , String value);
	
	public void deleteCache(String key);
	
	public void updateCache(String key , String value);
	
	public String getCache(String key);
	
	public void batchDeleteCache(String... keys);
	
	public void batchDeleteCache(String keys);
}
