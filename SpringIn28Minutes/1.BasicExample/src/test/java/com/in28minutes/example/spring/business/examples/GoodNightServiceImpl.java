package com.in28minutes.example.spring.business.examples;

import org.springframework.stereotype.Component;

@Component
public class GoodNightServiceImpl implements HiService {
	@Override
	public String sayHi() {
		return "Good Morning";
	}

}
