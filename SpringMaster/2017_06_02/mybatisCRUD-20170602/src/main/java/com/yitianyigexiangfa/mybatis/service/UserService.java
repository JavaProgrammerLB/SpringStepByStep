package com.yitianyigexiangfa.mybatis.service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yitianyigexiangfa.mybatis.bean.User;
import com.yitianyigexiangfa.mybatis.mapper.UserMapper;

public class UserService {
	
	private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public static void main(String[] args) {
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-cfg.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sessionFactory.openSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = new User("ymc", "hru", 2.0);
			int index = mapper.insertUser(user);
			boolean bool = index > 0 ? true : false;
			logger.error("新增加user对象：{}， 操作状态{}", new Object[]{user, bool});
			session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null){
				session.close();
			}
		}
	}
}
