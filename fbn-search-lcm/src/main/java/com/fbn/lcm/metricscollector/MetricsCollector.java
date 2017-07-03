package com.fbn.lcm.metricscollector;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fbn.lcm.decisionengine.DecisionEngine;

@Component
public class MetricsCollector{
	@Autowired
	DiscoveryClient eurekaClient;
	
	@Autowired
	DecisionEngine decisionEngine;
	
	@Autowired
 	private RestTemplate restTemplate;
	
	public void start(){
		
		//This code get list of all instances for particular id
		eurekaClient.getServices().forEach(service -> {		
		
			eurekaClient.getInstances(service).forEach(instance -> {
				Map metrics=null;
			
				System.out.println("\t Getting metrices --- "+ service +" ----http://" + instance.getHost() + ":" + instance.getPort());
				
				String uri="http://raman:" + instance.getPort() + "/metrics";
				try{
					 metrics = restTemplate.getForObject(service,Map.class);
				}catch(Exception e){
					
					System.out.println("Error occurred --"+uri + "\n "+e);
				}
				
				decisionEngine.execute(service, metrics);
				
			
						
			});
			
		});
		
		
		/*while(true){ 
			eurekaClient.getServices().forEach(service -> {		
				System.out.println("printing service "+ service);
				Map metrics = restTemplate.getForObject("http://"+service+"/metrics",Map.class);
				decisionEngine.execute(service, metrics);
			});	
		}*/		
	}
}

@Configuration
class AppConfiguration {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}