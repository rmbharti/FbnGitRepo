package com.fbn.checkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fbn.checkin.entity.CheckInRecord;
import com.fbn.checkin.repository.CheckinRepository;

@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class FbnCheckinApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(FbnCheckinApplication.class);

	@Autowired
	CheckinRepository repository;
	

	public static void main(String[] args) {
		SpringApplication.run(FbnCheckinApplication.class, args);
	}
	private static int invoked=0;
	@Override
	public void run(String... strings) throws Exception {
		
		invoked++;
		if(invoked>1)return;
		
		CheckInRecord record = new CheckInRecord("Franc", "Gean","28A",new Date(),"BF101","22-JAN-16",1);
		 
 		CheckInRecord result  = repository.save(record);
		logger.info("checked in successfully ..." + result);
		
		
		
		logger.info("Looking to load checkedIn record..."); 
	    logger.info("Result: " + repository.findOne(result.getId()));
 
	    
	}
}
