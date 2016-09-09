package com.yitianyigexiangfa.spark;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.port;
import static spark.Spark.halt;

public class App {
	
	public static void main(String[] args){
		
		port(8078);
		
		get("/hello", (req, res) -> "Hello World");
		
		post("/hello", (req,res) -> "Hello World: " + req.body());
		
		get("/private", (req,res) -> {
			res.status(401);
			return "Go Away!!!";
		});
		
		get("/user/:name", (req,res) -> {
			return "Select user: " + req.params(":name");
		});
		
		get("/news/:section",(req,res) -> {
			res.type("text/xml");
			return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><news>" + req.params("section") + "</news>";
		});
		
		get("/protected", (req,res) -> {
			halt(403, "I don't think so!!!");
			return null;
		});
		
		get("/redirect", (req,res) -> {
			res.redirect("/news/world");
			return null;
		});
		
		get("/", (req,res) -> "root");
	}
}
