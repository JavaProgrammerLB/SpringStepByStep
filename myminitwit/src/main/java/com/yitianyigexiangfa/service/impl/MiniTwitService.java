package com.yitianyigexiangfa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yitianyigexiangfa.dao.MessageDao;
import com.yitianyigexiangfa.dao.UserDao;
import com.yitianyigexiangfa.model.LoginResult;
import com.yitianyigexiangfa.model.Message;
import com.yitianyigexiangfa.model.User;
import com.yitianyigexiangfa.service.util.PasswordUtil;

@Service
public class MiniTwitService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private MessageDao messageDao;

	public List<Message> getUserFullTimelineMessages(User user) {
		return messageDao.getUserFullTimelineMessages(user);
	}

	public List<Message> getUserTimelineMessages(User user) {
		return messageDao.getUserTimelineMessage(user);
	}

	public List<Message> getPublicTimelineMessages() {
		return messageDao.getPublicTimelineMessages();
	}

	public User getUserbyUsername(String username) {
		return userDao.getUserbyUsername(username);
	}

	public void followUser(User follower, User followee) {
		userDao.insertFollower(follower, followee);
	}

	public void unfollowUser(User follower, User followee) {
		userDao.deleteFollower(follower, followee);
	}

	public boolean isUserFollower(User follower, User followee) {
		return userDao.isUserFollower(follower, followee);
	}

	public void addMessage(Message message) {
		messageDao.insertMessage(message);
	}

	public LoginResult checkUser(User user) {
		LoginResult result = new LoginResult();
		User userFound = userDao.getUserbyUsername(user.getUsername());
		if (userFound == null) {
			result.setError("Invalid username");
		}else if(!PasswordUtil.verifyPassword(user.getPassword(), userFound.getPassword())){
			result.setError("Invalid password");
		}else {
			result.setUser(userFound);
		}
		return result;
	}

	public void registerUser(User user) {
		 user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
		 userDao.registerUser(user);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
}
