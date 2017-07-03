package com.fbn.search;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import com.fbn.search.entity.Fares;
import com.fbn.search.entity.Flight;
import com.fbn.search.entity.Inventory;
import com.fbn.search.repository.FlightRepository;
@EnableDiscoveryClient
@SpringBootApplication
@RefreshScope
public class FbnSearchApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(FbnSearchApplication.class);
	
	@Autowired
	private FlightRepository flightRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FbnSearchApplication.class, args);
	}
	private static int invoked=0;
	@Override
	public void run(String... strings) throws Exception {
		invoked++;
		if(invoked>1)return;
		List<Flight> flights = new ArrayList<>();
		flights.add(new Flight("BF100", "SEA","SFO","22-JAN-16",new Fares("100", "USD"),new Inventory(100)));
		flights.add(new Flight("BF101", "NYC","SFO","22-JAN-16",new Fares("101", "USD"),new Inventory(100)));
		flights.add(new Flight("BF105", "NYC","SFO","22-JAN-16",new Fares("105", "USD"),new Inventory(100)));
		flights.add(new Flight("BF106", "NYC","SFO","22-JAN-16",new Fares("106", "USD"),new Inventory(100)));
		flights.add(new Flight("BF102", "CHI","SFO","22-JAN-16",new Fares("102", "USD"),new Inventory(100)));
		flights.add(new Flight("BF103", "HOU","SFO","22-JAN-16",new Fares("103", "USD"),new Inventory(100)));
		flights.add(new Flight("BF104", "LAX","SFO","22-JAN-16",new Fares("104", "USD"),new Inventory(100)));
	    
		flightRepository.save(flights);
		
		logger.info("Looking to load flights...");
		for (Flight flight : flightRepository.findByOriginAndDestinationAndFlightDate("SEA", "SFO", "22-JAN-16")) {
	        logger.info(flight.toString());
	    }
	}
	 
}
