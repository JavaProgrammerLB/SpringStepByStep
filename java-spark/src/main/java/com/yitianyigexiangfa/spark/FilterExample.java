package com.yitianyigexiangfa.spark;

import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;

public class FilterExample {

	private static Map<String, String> usernamePasswords = new HashMap<String, String>();
	
	public static void main(String[] args) {
		port(8081);
		
		usernamePasswords.put("admin", "admin");
		
		before((req, res) -> {
			String user = req.queryParams("user");
			String password = req.queryParams("password");
			
			String dbPassword = usernamePasswords.get(user);
			if(!(password != null && password.equals(dbPassword))){
				halt(401, "Your are not welcome here!!!");
			}
		});
		
		before((req,res) -> res.header("Foo", "Set by second before filter"));
		
		get("/hello", (req, res) -> "Hello World!");
		
		after("/hello", (req, res) -> res.header("spark", "after by after-filter"));
	}

}
