package com.fbn.search.component;

import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.fbn.search.FbnSearchApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class Receiver {
	
	private static final Logger logger = LoggerFactory.getLogger(Receiver.class);
	

	
	SearchComponent searchComponent;
	
	@Autowired
	public Receiver(SearchComponent searchComponent){
		this.searchComponent = searchComponent;
	}
	@Bean
	Queue queue() {
		
		logger.info("Search - Receiver-Creating queue ---SearchQ");
		return new Queue("SearchQ", false);
	}
	
	@RabbitListener(queues = "SearchQ")
    public void processMessage(Map<String,Object> fare) {
		
	logger.info("Entering Process Message .....");
	logger.info("Updating inventory for fares ....." + fare.toString());
	
    searchComponent.updateInventory((String)fare.get("FLIGHT_NUMBER"),(String)fare.get("FLIGHT_DATE"),(int)fare.get("NEW_INVENTORY"));
   
    }	
}