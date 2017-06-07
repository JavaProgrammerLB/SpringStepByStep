package com.yitianyigexiangfa.mybatis.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yitianyigexiangfa.mybatis.bean.User;
import com.yitianyigexiangfa.mybatis.mapper.UserMapper;
import com.yitianyigexiangfa.mybatis.util.DatabaseUtil;

public class UserService {

	private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	public static void main(String[] args) {
		insertUser(new User("liubei", "liubei", 1.22));
	}
	
	public static int insertUser(User user){
		SqlSession session = DatabaseUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int result = 0;
		try {
			result = mapper.insertUser(user);
			logger.info("新增用户{}成功，新增结果为：{}，0-失败 1-成功", new Object[]{user, result});
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return result;
	}
}
