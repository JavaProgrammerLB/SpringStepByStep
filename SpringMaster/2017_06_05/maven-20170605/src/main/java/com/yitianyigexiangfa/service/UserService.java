package com.yitianyigexiangfa.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yitianyigexiangfa.domain.User;
import com.yitianyigexiangfa.mapper.UserMapper;
import com.yitianyigexiangfa.util.DataBaseUtil;

public class UserService {
	
	static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	public static void main(String[] args) {
		insertUser();
		selectAllUsers();
	}
	
	public static void insertUser(){
		SqlSession session = DataBaseUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			mapper.insertUser(new User("h", "123", 2.2));
			logger.info("hello");
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public static List<User> selectAllUsers(){
		SqlSession session = DataBaseUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> users = null;
		try {
			users = mapper.selectAllUsers();
			logger.info(users);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return users;
	}
	
}
