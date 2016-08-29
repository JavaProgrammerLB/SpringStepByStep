package com.yitianyigexiangfa.ljsw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetTheNewstLJSW {
		
	public static void main(String[] args) {
		//List<String> noList = new ArrayList<String>();
		Map<String, String> no2url = new HashMap<String, String>();
		try {
			Document doc = Jsoup.connect("http://i.youku.com/u/UNTEzNTY1OTgw").get();
			// Get the video-list block
			Elements elements = doc.getElementsByClass("video-list");
			// Verify the size of elements
			if (elements != null && elements.size() > 0){				
				// Get the only element
				Element fourth = elements.get(0);
				// Get the links in fourth
				Elements links = fourth.getElementsByClass("v-link");
				// Verify the size of these links num
				if (links != null && links.size() > 0){
					// iterator these links
					for (int i = 0; i < links.size(); i ++){
						// get a link
						Element link = links.get(i);
						// get the <a>
						Element aTage = link.select("a[title]").get(0);
						// get the title
						String title = aTage.attr("title");
						System.out.println("title:" + title);
						// get the href
						String href = aTage.attr("href");
						System.out.println("href:" + href);
						// get the position of "No."
						int pos = title.indexOf("No.");
						// get the Number
						String no = title.substring(pos);
						no2url.put(no, href);
					}
					// get all keys：numbers
					List<String> nolist = new ArrayList<String>(no2url.keySet());
					Collections.sort(nolist);
					System.out.println(nolist);
					// the news url
					System.out.println("The newest NO is: " + nolist.get(nolist.size() - 1) +  ". The newest url is:" + no2url.get(nolist.get(nolist.size() - 1)));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
