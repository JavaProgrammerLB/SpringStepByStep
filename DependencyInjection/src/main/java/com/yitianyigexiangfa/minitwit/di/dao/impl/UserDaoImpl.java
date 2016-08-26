package com.yitianyigexiangfa.minitwit.di.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yitianyigexiangfa.minitwit.di.dao.UserDao;
import com.yitianyigexiangfa.minitwit.di.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private NamedParameterJdbcTemplate template;
	
	@Autowired
	public UserDaoImpl(DataSource ds) {
		template = new NamedParameterJdbcTemplate(ds);
	}
	
	public void insertFollower(User follower, User followee) {
		// Dao code here
	}

	public void deleteFollower(User follower, User followee) {
		// code here
	}

}
