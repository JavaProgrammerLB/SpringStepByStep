package com.yitianyigexiangfa.service;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yitianyigexiangfa.bean.User;
import com.yitianyigexiangfa.mapper.UserMapper;

public class UserService {

	public static SqlSessionFactory sessionFactory;
	
	static{
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-cfg.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		insertUser();
	}

	public static SqlSession getSession(){
		return sessionFactory.openSession();
	}
	
	private static boolean insertUser(){
		Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
		SqlSession session = UserService.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User("liubei", "iloveu", 2.1);
		
		try {
			int index = mapper.insertUser(user);
			boolean bool = index > 0 ? true : false;
			logger.error("新增用户user对象：{}，操作状态：{}}", new Object[]{user, bool});
			session.commit();
			return bool;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			return false;
		}finally {
			session.close();
		}
	}
	
}
