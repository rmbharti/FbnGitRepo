package com.fbn.fare.apigateway;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FareApiGatewayController {
	
	@RequestMapping("/")
	String greet(HttpServletRequest req){
		return "Hello -- Search API GATEWAY";
	}

}
