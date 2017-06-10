package com.yitianyigexiangfa.mybatis.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yitianyigexiangfa.mybatis.domain.User;
import com.yitianyigexiangfa.mybatis.mapper.UserMapper;
import com.yitianyigexiangfa.mybatis.util.DatabaseUtil;
public class UserService {

	private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	public static void main(String[] args) {
		insertUser(new User("hello", "w", 233.0));
	}
	
	private static void insertUser(User user){
		SqlSession session = DatabaseUtil.getSession();
		UserMapper userMaper = session.getMapper(UserMapper.class);
		try {
			userMaper.insertUser(user);
			logger.info(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

}
