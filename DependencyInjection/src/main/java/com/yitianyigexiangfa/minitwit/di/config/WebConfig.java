package com.yitianyigexiangfa.minitwit.di.config;

import com.yitianyigexiangfa.minitwit.di.service.MiniTwitService;

public class WebConfig {
	private MiniTwitService service;
	
	public WebConfig(MiniTwitService service) {
		this.service = service;
		// code here
	}
}
