package com.yitianyigexiangfa.mybatis.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yitianyigexiangfa.mybatis.bean.User;
import com.yitianyigexiangfa.mybatis.mapper.UserMapper;
import com.yitianyigexiangfa.mybatis.util.DataBaseUtil;

public class UserService {

	private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public static void main(String[] args) {
		selectUserById(5);
		deleteUser(1);
		updateUser(5);
		insertUser(new User("testUser", "xxx", 1111));
		selectUsers();
	}

	public static boolean insertUser(User user) {
		SqlSession session = DataBaseUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		boolean bool = false;
		try {
			int index = mapper.insertUser(user);
			bool = index > 0 ? true : false;
			logger.info("新增加user对象：{}， 操作状态{}", new Object[] { user, bool });
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
		return bool;
	}

	public static void deleteUser(int id) {
		SqlSession session = DataBaseUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			mapper.deleteUser(id);
			logger.info("成功删除id为{}的用户", id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}

	public static int updateUser(int id) {
		SqlSession session = DataBaseUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int result = 0;
		try {
			User user = mapper.selectUserById(5);
			if (user != null){
				user.setUsername("liubei2");
				mapper.updateUser(user);
			}
			result = mapper.updateUser(user);
			logger.info("修改了id为{}的用户的数据", id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
		return result;
	}
	
	public static User selectUserById(int id){
		SqlSession session = DataBaseUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		try {
			user = mapper.selectUserById(id);
			logger.info("id为 {} 的用户的信息为：{}", new Object[]{id, user});
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return user;
	}
	
	public static List<User> selectUsers(){
		SqlSession session = DataBaseUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> users = new ArrayList<User>();
		try {
			users = mapper.selectUsers();
			logger.info("获取所有的用户" + users);
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
