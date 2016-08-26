package com.yitianyigexiangfa.minitwit.di.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yitianyigexiangfa.minitwit.di.dao.MessageDao;
import com.yitianyigexiangfa.minitwit.di.dao.UserDao;
import com.yitianyigexiangfa.minitwit.di.model.Message;
import com.yitianyigexiangfa.minitwit.di.model.User;

@Service
public class MiniTwitService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MessageDao messageDao;
	
	public List<Message> getUserTimelinemessages(User user){
		return messageDao.getUserTimelineMessage(user);
	}
}
