package com.fbn.search.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
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

/* refresh scope is available inside spring - could context */

@RefreshScope
@CrossOrigin
@RestController
@RequestMapping("/search")
class SearchRestController {
	
	private static final Logger logger=Logger.getLogger(SearchRestController.class);
	
	private SearchComponent searchComponent;
	
	// adding instance variable for reading properties from config server
	
	@Value("${originairports.shutdown}")
	private String originAirportShutdownList;
	
	
	@Autowired
	public SearchRestController(SearchComponent searchComponent){
		this.searchComponent = searchComponent;
	}
	
	@RequestMapping(value="/get", method = RequestMethod.POST)
	List<Flight> search(@RequestBody SearchQuery query){
		
		logger.info("looking for flights ");
		if(Arrays.asList(originAirportShutdownList.split(",")).contains(query.getOrigin())) {
			
			logger.info("the Origin airport is in shutdown state");
		return new ArrayList<Flight>();
		}
			
				
		System.out.println("Input : "+ query);
		
		
		return searchComponent.search(query);
	}
 
}
