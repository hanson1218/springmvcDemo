package com.snow.www.cache.ehcache;

public interface BaseCache {
	public void put(String key,Object value);      			   //添加对象到缓存中
	
	public Object get(String key);                 				//从缓存中获取对象
	
	public void remove(String key);                				//从缓存中删除对象
	
	public void clean();                           			   //清空缓存
	
	/**
	 * 设置缓存选项
	 * @param co 缓存选项
	 */
	public void setOption(CacheOption co);                      //设置缓存选项

	public Object getCacheInstance();                                  //获取内部缓存实现对象
}
