package com.fbn.auth.fb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication

@EnableOAuth2Client
@EnableAuthorizationServer
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
@EnableAsync
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)

@EnableAutoConfiguration()
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	  @Bean
	    public CacheManager cacheManager() {

	        GuavaCacheManager cacheManager = new GuavaCacheManager("unmentionable");

	        return cacheManager;
	    }

	
	
}
