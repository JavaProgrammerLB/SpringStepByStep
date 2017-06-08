package com.yitianyigexiangfa.mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yitianyigexiangfa.mybatis.domain.User;
import com.yitianyigexiangfa.mybatis.mapper.UserMapper;
import com.yitianyigexiangfa.mybatis.util.DatabaseUtil;

public class UserService {
	private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public static void main(String[] args) {
		selectAllUsers();
		insertUser();
		selectAllUsers();
	}

	public static int insertUser() {
		SqlSession session = DatabaseUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int result = 0;
		try {
			User user = new User("liubei", "hello", 1);
			result = mapper.insertUser(user);
			logger.info("新增用户{}，新增用户的执行结果是{}", new Object[]{user, result});
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	public static List<User> selectAllUsers() {
		SqlSession session = DatabaseUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> users = null;
		try {
			users = mapper.selectAllUsers();
			logger.info(users);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

}
