package com.yitianyigexiangfa.minitwit.di.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yitianyigexiangfa.minitwit.di.dao.MessageDao;
import com.yitianyigexiangfa.minitwit.di.model.Message;
import com.yitianyigexiangfa.minitwit.di.model.User;

@Repository
public class MessageDaoImpl implements MessageDao {
	
	private NamedParameterJdbcTemplate template;

	@Autowired
	public MessageDaoImpl(DataSource ds) {
		template = new NamedParameterJdbcTemplate(ds);
	}
	
	public List<Message> getUserTimelineMessage(User user) {
		// code here
		return null;
	}

	public void insertMessage(Message m) {
		// code here
	}

}
