package com.fbn.checkin.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@RefreshScope
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class CheckinApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckinApiGatewayApplication.class, args);
	}
	
	//@Bean
	public CheckinApiGatewayCustomZuulFilter customFilter(){
		System.out.println("Custom filter invoked .....");
		return new CheckinApiGatewayCustomZuulFilter();
		
	}
}
