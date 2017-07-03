package com.fbn.checkin.apigateway;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckinApiGatewayController {
	
	@RequestMapping("/")
	String greet(HttpServletRequest req){
		return "Hello -- checkin API GATEWAY";
	}

}
