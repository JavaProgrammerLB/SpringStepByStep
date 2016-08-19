package com.yitianyigexiangfa.junit.helper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {
	
	@BeforeClass
	public static void befocla(){
		System.out.println("before class");
	}
	
	@Test
	public void test(){
		System.out.println("test executed");
	}
	
	@Test
	public void test2(){
		System.out.println("test2 execited");
	}
	
	@Before
	public void before(){
		System.out.println("before ");
	}
	
	@After
	public void after(){
		System.out.println("after here");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("after class code");
	}
}
