package com.yitianyigexiangfa;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParseADocFromString {

	public static void main(String[] args) {
		String html = "<html><head><title>First parse</title></head>"
				+ "<body><p>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(html);
		System.out.println(doc.title());
		System.out.println(doc.body());
		pr(doc.title());
	}
	
	public static void pr(String s){
		System.out.println(s);
	}

}
