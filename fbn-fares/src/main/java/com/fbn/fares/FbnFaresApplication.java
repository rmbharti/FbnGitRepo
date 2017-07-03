package com.fbn.fares;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fbn.fares.entity.Fare;
import com.fbn.fares.repository.FaresRepository;
import com.netflix.appinfo.AmazonInfo;


@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class FbnFaresApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(FbnFaresApplication.class);

	public static int invoked=0;
	@Autowired
	FaresRepository faresRepository;
	
	
	 @Autowired
	 FbnFaresApplication app;
	 
	 
	public static void main(String[] args) {
		SpringApplication.run(FbnFaresApplication.class, args);
	}
	
	//This method is loaded twice which is causing the fare list getting saved twice
	//this is happening due to class is being loaded twice once by main method and another by run method
	//run(FbnFaresApplication.class)
	
	@Override
	public void run(String... strings) throws Exception {
	
		invoked++;
		if(invoked>1)return;
		
		Fare[] fares = {
		new Fare("BF100","22-JAN-16", "101"),
		new Fare("BF101","22-JAN-16", "101"),
		new Fare("BF102","22-JAN-16", "102"),
		new Fare("BF103","22-JAN-16", "103"),
		new Fare("BF104","22-JAN-16", "104"),
		new Fare("BF105","22-JAN-16", "105"),
		new Fare("BF106","22-JAN-16", "106")};
		
		
		List<Fare> list = Arrays.stream(fares).collect(Collectors.toList());

		logger.info("raman Result: before foreach "+list.size());
				
		list.forEach(fare -> faresRepository.save(fare)); 
		faresRepository.findAll();
		logger.info("raman Result: findAll After Saving  "+list.size());
		
		logger.info("before gfd Value invoked  "+invoked);
 		logger.info("executing getfare by flight and date -" + faresRepository.getFareByFlightNumberAndFlightDate("BF101","22-JAN-16"));
 		logger.info("before gfd Value invoked  "+invoked);
	}
	
}



@Configuration
class EurekaConfig { 

	private static final Logger logger = LoggerFactory.getLogger(FbnFaresApplication.class);
	
  @Bean
  public EurekaInstanceConfigBean eurekaInstanceConfigBean() {
	logger.info("Entering EurekaInstanceConfigBean - eurekaInstanceConfigBean() -  Eureka Pre Configuring-3");
		
  	EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(new InetUtils(new InetUtilsProperties()));
		
  	try { 
		    AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
		    
		    config.setDataCenterInfo(info);
		    
		    info.getMetadata().put(AmazonInfo.MetaDataKey.publicHostname.getName(), info.get(AmazonInfo.MetaDataKey.publicIpv4));
		    
		    config.setHostname(info.get(AmazonInfo.MetaDataKey.localHostname));
		    
		    logger.info("hostname" + info.get(AmazonInfo.MetaDataKey.localHostname));
		    logger.info("IP" + info.get(AmazonInfo.MetaDataKey.publicIpv4));
		    
			config.setNonSecurePortEnabled(true);
	        config.setNonSecurePort(0);
	        
	        config.getMetadataMap().put("instanceId",  info.get(AmazonInfo.MetaDataKey.localHostname));
	 
	
  	}catch (Exception e){
  		logger.error(" Error Occured ---"+ e);
  		e.printStackTrace();
  	}
	    return config;
	}		 
}