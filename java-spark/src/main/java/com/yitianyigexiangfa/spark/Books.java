package com.yitianyigexiangfa.spark;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.delete;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Books {
	
	
	private static Map<String, Book> books = new HashMap<String, Book>();
	public static void main(String[] args) {
		final Random random = new Random();
		
		post("/books", (req,res) -> {
			String author = req.queryParams("author");
			String title = req.queryParams("title");
			Book book = new Book(author, title);
			
			int id = random.nextInt(Integer.MAX_VALUE);
			books.put(String.valueOf(id), book);
			res.status(201);
			return id;
		});
		
		get("/books/:id", (req,res) -> {
			Book book = books.get(req.params(":id"));
			if (book != null){
				return "Title: " + book.getTitle() + ",Author:" + book.getAuthor();
			}else{
				res.status(404);
				return "Book not found";
			}
		});
		
		put("/books/:id",(req,res) -> {
			String id = req.params(":id");
			Book book = books.get(id);
			if (book != null){
				String newAuthor = req.queryParams("author");
				String newTitle = req.queryParams("title");
				if (newAuthor != null){
					book.setAuthor(newAuthor);
				}
				if (newTitle != null){
					book.setTitle(newTitle);
				}
				return "Book with id '" + id + "' updated";
			}else{
				res.status(404);
				return "Book not found";
			}
		});
		
		delete("/books/:id", (req,res) -> {
			String id = req.params(":id");
			Book book = books.remove(id);
			if (book != null){
				return "Book with id '" + id + "' deleted";
			} else {
				res.status(404);
				return "Book not found"; 
			}
		});
		
		get("/books", (req,res) -> {
			String ids = "";
			for (String id : books.keySet()) {
				ids += id + " ";
			}
			return ids;
		});
	}
}
