package com.fbn.booking.component;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="fares-proxy",url="localhost:8080")
public interface FareServiceProxy {
	
	/** This declaration does not users ribbon client side load balancer 
	@RequestMapping(value="/get",method=RequestMethod.GET)
	Fare getFare(@RequestParam (value="flightNumber") String flightNumber, @RequestParam(value="flightDate") String flightDate);
	 */
	
	
	@RequestMapping(value="/fares/get",method=RequestMethod.GET)
	Fare getFare(@RequestParam (value="flightNumber") String flightNumber, @RequestParam(value="flightDate") String flightDate);
	 


}
