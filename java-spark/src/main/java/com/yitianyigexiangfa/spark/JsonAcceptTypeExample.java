package com.yitianyigexiangfa.spark;

import static spark.Spark.*;

public class JsonAcceptTypeExample {

	public static void main(String[] args) {
		get("/hello", "application/json", (req,res)->{
			return "{\"message\": \"Hello World\"}";
		});
	}

}
