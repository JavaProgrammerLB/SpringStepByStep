package com.yitianyigexiangfa.mybatis.mapper;

import java.util.List;

import com.yitianyigexiangfa.mybatis.domain.User;

public interface UserMapper {

	public int insertUser(User user) throws Exception;
	
	public int deleteUser(int id) throws Exception;
	
	public int updateUser(User user) throws Exception;
	
	public User getUserById(int id) throws Exception;
	
	public List<User> getAllUsers() throws Exception;
}
