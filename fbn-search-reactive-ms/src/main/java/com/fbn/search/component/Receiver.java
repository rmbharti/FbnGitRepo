package com.fbn.search.component;

import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@EnableBinding(SearchSink.class)
@Component
public class Receiver {
	
	@Output(SearchSink.InventoryQ)
	@Autowired
	private MessageChannel messageChannel;
	
	SearchComponent searchComponent;
	
	@Autowired
	public Receiver(SearchComponent searchComponent){
		this.searchComponent = searchComponent;
	}
	@Bean
	Queue queue() {
		return new Queue("SearchQ", false);
	}
	
	// THis method is added for reactive stream
	@ServiceActivator(inputChannel = SearchSink.InventoryQ)
	public void accept(Map<String,Object> fare){
		
		String flightNumber=(String)fare.get("FLIGHT_NUMBER");
		String flightDate=(String)fare.get("FLIGHT_DATE");
		int inventory=(int)fare.get("NEW_INVENTORY");
				
		searchComponent.updateInventory(flightNumber,flightDate,inventory);
		
	}
	
	@RabbitListener(queues = "SearchQ")
    public void processMessage(Map<String,Object> fare) {
       System.out.println(fare);
       searchComponent.updateInventory((String)fare.get("FLIGHT_NUMBER"),(String)fare.get("FLIGHT_DATE"),(int)fare.get("NEW_INVENTORY"));
       //call repository and update the fare for the given flight
    }	
}