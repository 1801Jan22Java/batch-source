package com.revature.filters;

import com.netflix.zuul.ZuulFilter;

public class SimplePreFilter extends ZuulFilter {

	@Override
	public Object run() {
		System.out.println("hello from Zuul filter!");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
