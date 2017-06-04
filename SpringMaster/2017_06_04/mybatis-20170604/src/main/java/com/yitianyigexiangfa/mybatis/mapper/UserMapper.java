package com.yitianyigexiangfa.mybatis.mapper;

import java.util.List;

import com.yitianyigexiangfa.mybatis.bean.User;

public interface UserMapper {
	
	public int insertUser(User user) throws Exception;
	
	public int deleteUser(int id) throws Exception;
	
	public int updateUser(User user) throws Exception;
	
	public User selectUserById(int id) throws Exception;
	
	public List<User> selectAllUsers() throws Exception;
}
