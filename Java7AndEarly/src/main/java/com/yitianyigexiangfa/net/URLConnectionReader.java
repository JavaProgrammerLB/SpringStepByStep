package com.yitianyigexiangfa.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {

	public URLConnectionReader() {
	}

	public static void main(String[] args) throws Exception{
		URL oracle = new URL("http://www.qq.com");
		URLConnection uc = oracle.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		in.close();
	}

}
