package com.snow.www.cache.ehcache;

import org.junit.Test;

import net.sf.ehcache.CacheManager;

public class EhcacheTest {

	@Test
	public void test1(){
		BaseCache ehCacheImpl = EhCacheImpl.getInstance();
		
        
        ehCacheImpl.put("test", "1");
        System.out.println(ehCacheImpl.get("test"));
	}
}
