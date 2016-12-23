package com.yitianyigexiangfa.sql2o;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.yitianyigexiangfa.sql2o.bean.User;

public class MyDao {

	private Sql2o sql2o;
	
	public MyDao() {
		this.sql2o = new Sql2o("jdbc:mysql://localhost:3306/schema","user","user");
	}
	
	public static void main(String[] args) {
		MyDao m = new MyDao();
		// 创建一个用户对象 
		User user = new User();
		user.setUsername("user");
		user.setPw("pw");
		user.setEmail("email");
		// 插入一条数据到数据库
		m.add(user);
		List<User>users = m.getAllUsers();
		for (User user2 : users) {
			System.out.println(user2.getUser_id() + " " + user2.getUsername() + " " + user2.getEmail() + " " + user2.getPw());
		}
	}
	
	public List<User> getAllUsers(){
		String sql = "SELECT user_id, username, email, pw FROM user";
		try(Connection con = sql2o.open()){
			return con.createQuery(sql).executeAndFetch(User.class);
		}
	}

	public void add(User user){
		String username = user.getUsername();
		String email = user.getEmail();
		String pw = user.getPw();
		String sql = "INSERT INTO user( username, email, pw) values (:username, :email, :pw)";
		try (Connection con = sql2o.open();){
			con.createQuery(sql).addParameter("username", username).addParameter("email", email).addParameter("pw", pw).executeUpdate();
		}
	}
}
