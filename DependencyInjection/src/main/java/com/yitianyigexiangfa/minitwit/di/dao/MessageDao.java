package com.yitianyigexiangfa.minitwit.di.dao;

import java.util.List;

import com.yitianyigexiangfa.minitwit.di.model.Message;
import com.yitianyigexiangfa.minitwit.di.model.User;

public interface MessageDao {
	List<Message> getUserTimelineMessage(User user);
	
	void insertMessage(Message m);
}
