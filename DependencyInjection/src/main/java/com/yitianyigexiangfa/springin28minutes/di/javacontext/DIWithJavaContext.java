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
	
	@Test
	public void javaContextDITest(){
		assertEquals("Good Morning", service.sayHi());
	}
}

@Configuration
@ComponentScan(basePackages="package com.yitianyigexiangfa.springin28minutes.serviceimpl")
class JavaContext{
	
}