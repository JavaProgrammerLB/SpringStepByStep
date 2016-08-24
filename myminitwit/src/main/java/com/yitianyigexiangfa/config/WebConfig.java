package com.yitianyigexiangfa.config;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.SparkBase.staticFileLocation;



import java.util.HashMap;
import java.util.List;
import java.util.Map;



import spark.ModelAndView;
import spark.Request;


import spark.template.freemarker.FreeMarkerEngine;

import com.yitianyigexiangfa.model.Message;
import com.yitianyigexiangfa.model.User;
import com.yitianyigexiangfa.service.impl.MiniTwitService;

public class WebConfig {
	private static  final String USER_SESSION_ID = "user";
	private MiniTwitService service;
	
	public WebConfig(MiniTwitService service) {
		this.service = service;
		staticFileLocation("/public");
		setupRoutes();
	}
	
	private void setupRoutes(){
		/*
		 * Shows a users timeline or if no user is logged in,
		 * it will redirect to the public timeline.
		 * This timeline shows the user's messages as well
		 * as all the  message of followed users. 
		 */
		get("/", (req, res) -> {
			User user = getAuthenticatedUser(req);
			Map<String, Object> map = new HashMap<>();
			map.put("pageTitle", "Timeline");
			map.put("user", user);
			List<Message> messages = service.getUserFullTimelineMessages(user);
			map.put("messages", messages);
			return new ModelAndView(map, "timeline.ftl");
		}, new FreeMarkerEngine());
		before("/", (req, res) -> {
			User user = getAuthenticatedUser(req);
			if(user == null){
				res.redirect("/public");
				halt();
			}
		});
		
		/*
		 * Displays the latest messages of all users.
		 */
		get("/public", (req, res) -> {
			User user = getAuthenticatedUser(req);
			Map<String, Object> map = new HashMap<>();
			map.put("pageTitle", "Public Timeline");
			map.put("user", user);
			List<Message> messages = service.getPublicTimelineMessages();
			map.put("messages", messages);
			return new ModelAndView(map, "timeline.ftl");
		}, new FreeMarkerEngine());
		
		/*
		 * Displays a user's tweets. 
		 */
		get("/t/:username", (req, res) -> {
			String username = req.params(":username");
			User profileUser = service.getUserbyUsername(username);
			User authUser = getAuthenticatedUser(req);
			boolean followed = false;
			if(authUser != null){
				followed = service.isUserFollower(authUser, profileUser);
			}
			List<Message> messages = service.getUserTimelineMessages(profileUser);
			Map<String, Object> map = new HashMap<>();
			map.put("pageTitle", username + "'s Timeline");
			map.put("user", authUser);
			map.put("profileUser", profileUser);
			map.put("followed", followed);
			map.put("messages", messages);
			return new ModelAndView(map, "timeline.ftl");
		}, new FreeMarkerEngine());
		/*
		 * Checks if the user exists 
		 */
		before("/t/:username", (req, res) -> {
			String username = req.params(":username");
			User profileUser = service.getUserbyUsername(username);
			if(profileUser == null) {
				halt(404, "User not Found");
			}
		});
		
		/*
		 * Adds the current user as follower of the given user 
		 */
		get("/t/:username/follow", (req, res) -> {
			String username = req.params(":username");
			User profileUser = service.getUserbyUsername(username);
			User authUser = getAuthenticatedUser(req);
			
			service.followUser(authUser, profileUser);
			res.redirect("/t/" + username);
			return null;
		});
		/*
		 * Checks if the user is authenticated and the user to follow exists
		 */
		before("/t/:username/follow", (req, res) -> {
			String username = req.params(":username");
			User authUser = getAuthenticatedUser(req);
			User profileUser = service.getUserbyUsername(username);
			if(authUser == null) {
				res.redirect("/login");
				halt();
			} else if(profileUser == null) {
				halt(404, "User not Found");
			}
		});
		
		/*
		 * Removes the current user as follower of the given user.
		 */
		get("/t/:username/unfollow", (req, res) -> {
			String username = req.params(":username");
			User profileUser = service.getUserbyUsername(username);
			User authUser = getAuthenticatedUser(req);
			service.unfollowUser(authUser, profileUser);
			res.redirect("/t/" + username);
			return null;
		});
	}
	
	private void addAuthenticatedUser(Request request, User u){
		request.session().attribute(USER_SESSION_ID, u);
	}
	
	private void removeAuthenticatedUser(Request request) {
		request.session().removeAttribute(USER_SESSION_ID);
	}
	
	private User getAuthenticatedUser(Request request){
		return request.session().attribute(USER_SESSION_ID);
	}
}
