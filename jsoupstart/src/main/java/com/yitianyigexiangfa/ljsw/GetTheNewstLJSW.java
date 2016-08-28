package com.yitianyigexiangfa.ljsw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetTheNewstLJSW {
	
	private int newestNo;
	private static List noList = new ArrayList<String>();
	
	public static void main(String[] args) {
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
						System.out.println(i + "-------");
						//System.out.println(link);
						Element aTage = link.select("a[title]").get(0);
						String title = aTage.attr("title");
						System.out.println(title);
						// Get the No.
						int pos = title.indexOf("No.");
						System.out.println(pos);
						String no = title.substring(pos);
						System.out.println(no);
						noList.add(no);
					}
					noList.sort(null);
					System.out.println(noList);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
