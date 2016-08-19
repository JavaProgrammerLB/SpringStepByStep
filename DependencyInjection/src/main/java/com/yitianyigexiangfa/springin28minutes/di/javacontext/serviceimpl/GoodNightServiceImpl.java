package com.yitianyigexiangfa.springin28minutes.di.javacontext.serviceimpl;

import org.springframework.stereotype.Component;

import com.yitianyigexiangfa.springin28minutes.di.javacontext.service.HiService;

@Component
public class GoodNightServiceImpl implements HiService {

	public String sayHi() {
		return "Good night";
	}
	
	

}
