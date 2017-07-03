package com.fbn.search.apigateway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class SearchApiGateWayController {
	
	RestTemplate searchClient = new RestTemplate();

	
	private static final Logger logger=LoggerFactory.getLogger(SearchApiGateWayController.class);
	
	@RequestMapping("/")
	String greet(HttpServletRequest req){
		return "Hello -- Search API GATEWAY";
	}
	
	@HystrixCommand(fallbackMethod="getDefaultHub")
	@RequestMapping("/hubongw")
	String getHub(HttpServletRequest req){
		logger.info("Search Request in APi Gateway for gettting hub, forwarding to search service");
		
		String hub=searchClient.getForObject("http://localhost:8083/search/hub",String.class);

		logger.info("Response from search service recieved ---"+hub);
		return hub;
	}
	
	public String getDefaultHub(){
		
		return "Possibly SFO";
	}
	

}
