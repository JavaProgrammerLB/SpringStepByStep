package com.yitianyigexiangfa.springin28minutes.di.javacontext;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yitianyigexiangfa.springin28minutes.di.javacontext.service.HiService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaContext.class)
public class DIWithJavaContext {
	@Autowired
	@Qualifier(value="goodMorningServiceImpl")
	private HiService service;
	
	@Autowired
	@Qualifier(value="goodNightServiceImpl")
	private HiService service2;
	
	@Test
	public void javaContextDITest4GoodMorningServiceImpl(){
		assertEquals("Good Morning", service.sayHi());
	}
	
	@Test
	public void javaContextDITest4GoodNightServiceImpl(){
		assertEquals("Good Night", service2.sayHi());
	}
}

@Configuration
@ComponentScan(basePackages="com.yitianyigexiangfa.springin28minutes.di.javacontext.serviceimpl")
class JavaContext{
	
}