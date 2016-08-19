package com.yitianyigexiangfa.springin28minutes.di.xmlcontext.serviceimpl;

import org.springframework.stereotype.Component;

import com.yitianyigexiangfa.springin28minutes.di.xmlcontext.service.HiService;

@Component
public class GoodMorningServiceImpl implements HiService {

	public String sayHi() {
		return "Good Morning";
	}

}
