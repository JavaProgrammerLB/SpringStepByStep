package com.yitianyigexiangfa.net;

import java.net.URL;

public class UrlTest {

	public UrlTest() {
	}
	
	public static void main(String[] args) throws Exception{
		URL aUrl = new URL("http://192.168.1.68:80/web/smartpole/overview/statistics.html?projectId=c30d1902dfa641a59ac323aa3d0cc699");
		System.out.println("protocol= " + aUrl.getProtocol());
		System.out.println("authoority=" + aUrl.getAuthority());
		System.out.println("host= " + aUrl.getHost());
		System.out.println("port= " + aUrl.getPort());
		System.out.println("path= " + aUrl.getPath());
		System.out.println("query= " + aUrl.getQuery());
		System.out.println("filename= " + aUrl.getFile());
		System.out.println("ref= " + aUrl.getRef());
	}

}
