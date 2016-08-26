package com.yitianyigexiangfa.minitwit.di.dao;

import com.yitianyigexiangfa.minitwit.di.model.User;

public interface UserDao {
	void insertFollower(User follower, User followee);
	
	void deleteFollower(User follower, User followee);
}
