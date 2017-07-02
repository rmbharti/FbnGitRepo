package com.fbn.booking.apigateway;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingApiGateWayController {
	
	@RequestMapping("/")
	String greet(HttpServletRequest req){
		return "Hello -- Search API GATEWAY";
	}

}
