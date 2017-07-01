package com.fbn.eureka.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer

public class FbnEurekaMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FbnEurekaMasterApplication.class, args);
	}
}
