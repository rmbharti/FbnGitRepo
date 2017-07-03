package com.fbn.lcm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import com.fbn.lcm.metricscollector.MetricsCollector;
@EnableDiscoveryClient
@SpringBootApplication
@RefreshScope
public class FbnFareLcmApplication implements CommandLineRunner {
	
	@Autowired
	MetricsCollector metricsCollector;
	private static int invoked=0;
	
	public static void main(String[] args) {
	
		SpringApplication.run(FbnFareLcmApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		invoked++;
		if(invoked>1){
			return;
			
		}
		metricsCollector.start();
	}
}