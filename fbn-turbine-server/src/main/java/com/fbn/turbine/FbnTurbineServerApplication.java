package com.fbn.turbine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@EnableHystrixDashboard
@SpringBootApplication

public class FbnTurbineServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FbnTurbineServerApplication.class, args);
	}
}
