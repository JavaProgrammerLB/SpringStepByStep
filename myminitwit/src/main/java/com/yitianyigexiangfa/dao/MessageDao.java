package com.yitianyigexiangfa.dao;

import java.util.List;

import com.yitianyigexiangfa.model.Message;
import com.yitianyigexiangfa.model.User;

public interface MessageDao {
	List<Message> getUserTimelineMessage(User user);
	
	List<Message> getUserFullTimelineMessages(User user);
	
	List<Message> getPublicTimelineMessages();
	
	void insertMessage(Message m);
}
