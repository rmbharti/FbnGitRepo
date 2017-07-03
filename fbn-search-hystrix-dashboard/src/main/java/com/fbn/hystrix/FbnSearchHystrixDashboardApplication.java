package com.fbn.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
@EnableHystrixDashboard
@SpringBootApplication
public class FbnSearchHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(FbnSearchHystrixDashboardApplication.class, args);
	}
}
