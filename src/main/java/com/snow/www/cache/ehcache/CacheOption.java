package com.snow.www.cache.ehcache;

public class CacheOption {
	//过期时间(单位为秒);  
    private int refreshPeriod;  
    /**
	 * @return the refreshPeriod
	 */
	public int getRefreshPeriod() {
		return refreshPeriod;
	}
	/**
	 * @param refreshPeriod the refreshPeriod to set
	 */
	public void setRefreshPeriod(int refreshPeriod) {
		this.refreshPeriod = refreshPeriod;
	}
	/**
	 * @return the keyPrefix
	 */
	public String getKeyPrefix() {
		return keyPrefix;
	}
	/**
	 * @param keyPrefix the keyPrefix to set
	 */
	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}
	//关键字前缀字符;  
    private String keyPrefix;  
}
