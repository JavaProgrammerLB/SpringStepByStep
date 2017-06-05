package com.yitianyigexiangfa.mapper;

import java.util.List;

import com.yitianyigexiangfa.domain.User;

public interface UserMapper {
	
	public int insertUser(User user) throws Exception;
	
	public int deleteUser(int id) throws Exception;
	
	public User updateUser(User user) throws Exception;
	
	public User selectUserById(int id) throws Exception;
	
	public List<User> selectAllUsers() throws Exception;
}
