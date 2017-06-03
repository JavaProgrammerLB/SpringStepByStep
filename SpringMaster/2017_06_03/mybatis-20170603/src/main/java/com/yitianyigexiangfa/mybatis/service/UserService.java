package com.yitianyigexiangfa.mybatis.service;


import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yitianyigexiangfa.mybatis.bean.User;
import com.yitianyigexiangfa.mybatis.mapper.UserMapper;
import com.yitianyigexiangfa.mybatis.util.DatabaseUtil;

public class UserService {

	private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	public static void main(String[] args) {
		User user = new User("zzz", "123", 2222.2);
		insertUser(user);
	}

	public static boolean insertUser(User user){
		SqlSession session = DatabaseUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		boolean b = false;
		try {
			int i = mapper.insertUser(user);
			b = i == 0 ? false : true;
			logger.info("insert user: {}", user);
			session.commit();
			return false;
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return b;
	}
}
