package com.fbn.fare.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class FareApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FareApiGatewayApplication.class, args);
	}
	
	//@Bean
	public FareApiGatewayCustomZuulFilter customFilter(){
		System.out.println("Custom filter invoked .....");
		return new FareApiGatewayCustomZuulFilter();
		
	}
}
