package com.yitianyigexiangfa;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LoadADocFromAUrl {

	public static void main(String[] args) {
		// http://i.youku.com/u/UNTEzNTY1OTgw
		try {
//			Document doc = Jsoup.connect("http://jsoup.org").get();
			//Document doc = Jsoup.connect("http://i.youku.com/u/UNTEzNTY1OTgw").get();
			Document doc = Jsoup.connect("https://jsoup.org/cookbook/input/load-document-from-url").get();
			String title = doc.title();
			System.out.println(title);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
