package com.yitianyigexiangfa.spark;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import com.yitianyigexiangfa.spark.freemarker.FreeMarkerTemplateEngine;

public class FreeMarkerExample {

	public FreeMarkerExample() {
	}

	public static void main(String[] args) {
		get("/hello", (req,res) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("message", "Hello FreeMarker World");
			return modelAndView(attributes, "hello.ftl");
		},new FreeMarkerTemplateEngine());
	}

}
