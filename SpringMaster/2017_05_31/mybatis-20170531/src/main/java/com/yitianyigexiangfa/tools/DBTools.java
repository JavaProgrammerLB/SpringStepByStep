package com.yitianyigexiangfa.tools;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBTools {
	
	public static SqlSessionFactory sessionFactory;
	
	static {
		try{
			Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession(){
		return sessionFactory.openSession();
	}
}
