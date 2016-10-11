package com.yitianyigexiangfa.string;

import org.junit.Test;

public class StringTest {

	public StringTest() {
	}
	
	@Test
	public void test(){
		String s1 = "com.yitianyigexiangfa.StringTest";
		getStringAfterLastPoint(s1);
		String s2 = "com.yitianyigexiangfa.ThreadTest";
		getStringAfterLastPoint(s2);
		String s3 = ".com";
		getStringAfterLastPoint(s3);
		String s4 = "com";
		getStringAfterLastPoint(s4);
		String s5 = "";
		getStringAfterLastPoint(s5);
		// 字符串截取
		String s6 = "r5520";
		System.out.println(s6.substring(1));
		
	}
	
	public String getStringAfterLastPoint(String s){
		if(s == null || s.equals("") || s.indexOf(".") == -1)  return null;
		else{
			String[] ss = s.split("\\.");
			if(ss == null || ss.length == 0) return null;
			else{
				int len = ss.length;
				if(len - 1 >= 0 ){					
					System.out.println(ss[len - 1]);
				}else return null;
			}
			return null;
		}
	}
}
