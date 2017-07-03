package com.fbn.search.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fbn.search.component.SearchComponent;
import com.fbn.search.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* refresh scope is available inside spring - could context */



@RefreshScope
@CrossOrigin
@RestController
@RequestMapping("/search")
class SearchRestController {
	
	private static final Logger logger=LoggerFactory.getLogger(SearchRestController.class);
	
	private SearchComponent searchComponent;
	
	// adding instance variable for reading properties from config server
	
	@Value("${originairports.shutdown}")
	private String originAirportShutdownList;
	
	
	@Autowired
	public SearchRestController(SearchComponent searchComponent){
		this.searchComponent = searchComponent;
	}
	
	
	@RequestMapping("/test")
	String greet(HttpServletRequest req){
		return "Hello -- search service instance";
	}

	@RequestMapping(value="/get", method = RequestMethod.POST)
	List<Flight> search(@RequestBody SearchQuery query){
		
		logger.info("Looking to load flights ..........");
		logger.info("Search Query  ......."+query.toString());
		
		logger.info("List of origin airport shutdown state    --" + originAirportShutdownList);
		
		if(Arrays.asList(originAirportShutdownList.split(",")).contains(query.getOrigin())) {
			logger.info("Origin airport is in shutdown state");
			logger.info("Exiting...");
			return new ArrayList<Flight>();
		}
			
		return searchComponent.search(query);
	}
	
	@RequestMapping("/hub")
	String getHub(HttpServletRequest req){
		logger.info("Entering Search Service .....");
		logger.info("Response from search service recieved --SFO");
		return "SFO";
	}
	
 
}
