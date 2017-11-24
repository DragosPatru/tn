package com.tuneride.server.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfiguration {
	@Bean
	public EhCacheCacheManager cacheManager() {
		EhCacheCacheManager cacheManager = new EhCacheCacheManager();
		EhCacheManagerFactoryBean cacheFactory = ehCacheManager();
		cacheManager.setCacheManager(cacheFactory.getObject());
		
		return cacheManager;
	}
	
	@Bean
	public EhCacheManagerFactoryBean ehCacheManager() {
		return new EhCacheManagerFactoryBean(); 
	}
}
