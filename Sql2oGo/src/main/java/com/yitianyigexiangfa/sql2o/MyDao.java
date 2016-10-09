package com.yitianyigexiangfa.sql2o;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.yitianyigexiangfa.sql2o.bean.User;

public class MyDao {

	private Sql2o sql2o;
	
	public MyDao() {
		this.sql2o = new Sql2o("jdbc:mysql://localhost:3306/schema","username","pass");
	}
	
	public static void main(String[] args) {
		MyDao m = new MyDao();
		List<User>users = m.getAllUsers();
		for (User user : users) {
			System.out.println(user.getUser_id() + " " + user.getUsername() + " " + user.getEmail() + " " + user.getPw());
		}
	}
	
	public List<User> getAllUsers(){
		String sql = "SELECT user_id, username, email, pw FROM user";
		try(Connection con = sql2o.open()){
			return con.createQuery(sql).executeAndFetch(User.class);
		}
	}
}
