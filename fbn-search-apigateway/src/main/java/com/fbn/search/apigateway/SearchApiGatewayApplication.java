package com.fbn.search.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
public class SearchApiGatewayApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SearchApiGatewayApplication.class, args);
	}
	
	//@Bean
	public SearchApiGatewayCustomZuulFilter customFilter(){
		System.out.println("Custom filter invoked .....");
		return new SearchApiGatewayCustomZuulFilter();
		
	}
	
	@Bean
	public AlwaysSampler defaultSampler(){
		
		return new AlwaysSampler();
	}
	 
}
