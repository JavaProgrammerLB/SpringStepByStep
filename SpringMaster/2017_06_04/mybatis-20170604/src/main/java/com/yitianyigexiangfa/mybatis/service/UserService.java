package com.yitianyigexiangfa.mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yitianyigexiangfa.mybatis.bean.User;
import com.yitianyigexiangfa.mybatis.mapper.UserMapper;
import com.yitianyigexiangfa.mybatis.util.DatabaseUtil;

public class UserService {
	
	private final static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	public static void main(String[] args) {
		selectAllUsers();
	}
	
	public static void selectAllUsers(){
		SqlSession session = DatabaseUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			List<User> users = mapper.selectAllUsers();
			logger.info(users);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally{
			session.close();
		}
	}
}
