package com.snow.www.cache.ehcache;

import com.snow.www.config.LocalConfig;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhCacheImpl implements BaseCache {

	private final static String CONFIG_FILE_NAME = "ehcache.xml";
	private final static String CACHE_DEFAULT_NAME = "cacheTest";
	private CacheOption co;
	private static Cache defaultCache;
	private static BaseCache bc = null;
	private static CacheManager cacheManager = null;

	private EhCacheImpl() {
		cacheManager = getCacheManager();
		defaultCache = cacheManager.getCache(CACHE_DEFAULT_NAME);
	}

	public static BaseCache getInstance() {
		if (bc == null) {
			bc = new EhCacheImpl();
		}
		return bc;
	}

	@Override
	public Object getCacheInstance() {
		return cacheManager;
	}

	/**
	 * 获取CacheManager
	 * 
	 * @return
	 */
	private  CacheManager getCacheManager() {
		if (cacheManager != null) {
			return cacheManager;
		}
		String file = getClass().getResourceAsStream("/") + "/" + CONFIG_FILE_NAME;
//		String file = LocalConfig.configPath + "/" + CONFIG_FILE_NAME;
		try {
			cacheManager = CacheManager.create(file);
		} catch (RuntimeException e) {
		}
		return cacheManager;
	}

	@Override
	public void put(String key, Object value) {
		Element element = new Element(this.co.getKeyPrefix() + key, value);
		defaultCache.put(element);
	}

	@Override
	public Object get(String key) {
		Element el = defaultCache.get(this.co.getKeyPrefix() + key);
		if (el != null) {
			return el.getObjectValue();
		} else {
			return null;
		}
	}

	@Override
	public void remove(String key) {
		defaultCache.remove(this.co.getKeyPrefix() + key);
	}

	@Override
	public void clean() {
		defaultCache.removeAll();
	}

	@Override
	public void setOption(CacheOption co) {
		this.co = co;
	}

}
