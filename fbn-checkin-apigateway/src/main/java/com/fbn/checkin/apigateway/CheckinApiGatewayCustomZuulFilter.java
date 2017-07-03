package com.fbn.checkin.apigateway;

import com.netflix.zuul.ZuulFilter;

public class CheckinApiGatewayCustomZuulFilter extends ZuulFilter {

	@Override
	public Object run() {
		System.out.println("Run...");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		System.out.println("should filter ...");
		return false;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		System.out.println("filter order filter ...");
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		System.out.println("filter type ...");
		return null;
	}

}
