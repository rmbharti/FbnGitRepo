package com.brownfield.pss.client;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@EnableGlobalMethodSecurity
@SpringBootApplication
public class FbnWebApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(FbnWebApplication.class);

   	RestTemplate searchClient = new RestTemplate();
	
  	 RestTemplate bookingClient = new RestTemplate();
	
   	RestTemplate checkInClient = new RestTemplate();
	
	 RestTemplate restClient= new RestTemplate();
	 
	 @Value("${booking-create-uri}")
	 private String bookingCreateUri;
	 
	 @Value("${checkin-create-uri}")
	 private String checkinCreateUri;
	 
	 @Value("${search-get-uri}")
	 private String searchGetUri;
	 
	 @Value("${booking-get-uri}")
	 private String bookingGetUri;
	 
	 
	
	public static void main(String[] args) {
		SpringApplication.run(FbnWebApplication.class, args);
	}
	
	private static int invoked=0;
	 
	@Override
	public void run(String... strings) throws Exception {
		
		logger.info("Entering FareWebApplication.run()");
		

		//Search for a flight
		SearchQuery searchQuery = new SearchQuery("NYC","SFO","22-JAN-16");
 		//Flight[] flights = searchClient.postForObject("http://search-service/search/get", searchQuery, Flight[].class); 
		
		//Flight[] flights = searchClient.postForObject("http://localhost:8090/search/get", searchQuery, Flight[].class); 
	
 		//commented line above to get uri from config server
 		Flight[] flights=null;

 		logger.info("Searching flights ..."+searchQuery.toString());
 		logger.info("URI ---http://localhost:8083/search/get");
		
		flights = searchClient.postForObject("http://localhost:8083/search/get", searchQuery, Flight[].class); 

		Arrays.asList(flights).forEach(flight -> logger.info(" flight >"+ flight));
  		
		//create a booking only if there are flights.
 		if(flights == null || flights.length == 0){
 			return;
 		}
		Flight flight = flights[0];
		BookingRecord booking = new BookingRecord(flight.getFlightNumber(),flight.getOrigin(),
												  flight.getDestination(), flight.getFlightDate(),null,
												  flight.getFares().getFare());
		Set<Passenger> passengers = new HashSet<Passenger>();
		passengers.add(new Passenger("Gavin","Franc","Male", booking));
		booking.setPassengers(passengers);
		long bookingId =0;
		try { 
			//long bookingId = bookingClient.postForObject("http://book-service/booking/create", booking, long.class); 
			
			// bookingId = bookingClient.postForObject(this.bookingCreateUri, booking, long.class); 
			
			
			 http://localhost:8084/booking/create  
			 logger.info("Creating booking record -- " +this.bookingCreateUri);
			 bookingId = bookingClient.postForObject(this.bookingCreateUri, booking, long.class); 
				
			 logger.info("Booking created "+ bookingId);
		}catch (Exception e){
			logger.error("BOOKING SERVICE NOT AVAILABLE...!!!" + this.bookingCreateUri);
			e.printStackTrace();
		}
		
		//check in passenger
		if(bookingId == 0) return;
		try {
			CheckInRecord checkIn = new CheckInRecord("Franc", "Gavin", "28C", null, "BF101","22-JAN-16", bookingId);
			
			//long checkinId = checkInClient.postForObject("http://localhost:8070/checkin/create", checkIn, long.class); 
			
			logger.info("Creating checkin record ---"+this.checkinCreateUri);
			long checkinId = checkInClient.postForObject(this.checkinCreateUri, checkIn, long.class); 
			logger.info("Checked IN "+ checkinId);
		
		}catch (Exception e){
			logger.error("CHECK IN SERVICE NOT AVAILABLE...!!!"); 
			logger.error(e.getCause().toString());
		}
	}
		 
}