package com.yitianyigexiangfa.spark;

import static spark.Spark.*;

public class StaticResources {

	public static void main(String[] args) {
		staticFileLocation("/public");
		
		get("/hello", (req,res)->{
			return "Hello World!";
		});
		
		get("/public", (req,res) ->{
			return "public";
		});
	}

}
