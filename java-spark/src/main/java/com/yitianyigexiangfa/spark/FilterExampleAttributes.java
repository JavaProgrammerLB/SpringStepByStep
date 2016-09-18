package com.yitianyigexiangfa.spark;

import static spark.Spark.*;

public class FilterExampleAttributes {

	public static void main(String[] args) {
		
		port(8076);
		
		get("/hi", (req,res) -> {
			req.attribute("foo", "bar2");
			return null;
		});
		
		after("/hi", (req, res) -> {
			for(String attr: req.attributes()){
				System.out.println("attr: " + attr);
			}
		});
		
		after("/hi", (req, res) -> {
			Object foo = req.attribute("foo");
			res.body(asXml("foo", foo));
		});
		
	}
	private static String asXml(String name, Object value){
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><" + name + ">" + value + "</" + name + ">";
	}

}
   