package com.yitianyigexiangfa.springin28minutes.di.xmlcontext;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yitianyigexiangfa.springin28minutes.di.xmlcontext.service.HiService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/XMLContext.xml"})
public class DIWithXmlContext {
	
	@Autowired
	@Qualifier(value = "goodMorningServiceImpl")
	HiService service;
	
	@Autowired
	@Qualifier(value = "goodNightServiceImpl")
	HiService service2;
	
	@Test
	public void xmlContextTestGoodMornintComponent(){
		assertEquals("Good Morning", service.sayHi());
	}
	
	@Test
	public void xmlContextTestsGoodNightComponent(){
		assertEquals("Good Night", service2.sayHi());
	}
	
}
