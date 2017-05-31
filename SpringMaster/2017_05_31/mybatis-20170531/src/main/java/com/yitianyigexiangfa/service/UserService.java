package com.yitianyigexiangfa.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yitianyigexiangfa.bean.User;
import com.yitianyigexiangfa.mapper.UserMapper;
import com.yitianyigexiangfa.tools.DBTools;

public class UserService {
//	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public static void main(String[] args) {
		insertUser();
	}
	
    /**
     * 新增用户
     */
    private static boolean  insertUser(){
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User("test01", "123456", 7000.0);
        try {
            int index=mapper.insertUser(user);
            boolean bool=index>0?true:false;
//            logger.error("新增用户user对象:{},操作状态:{}",new Object[]{user,bool});
            System.out.println("hello world");
             session.commit();
             return bool;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return false;
        }finally{
            session.close();
        }
    }
    
    
    /**
     * 删除用户
     * @param id 用户ID
     */
    private static boolean deleteUser(int id){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            int index=mapper.deleteUser(id); 
            boolean bool=index>0?true:false;
//            logger.debug("根据用户id:{},操作状态{}",new Object[]{id,bool});
            System.out.println("hello world");
            session.commit(); 
            return bool;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback(); 
            return false;
        }finally{
            session.close();
        }
    }
    
    
    /**
     * 根据id查询用户
     * @param id
     */
    private static void selectUserById(int id){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
        User user= mapper.selectUserById(id);
//        logger.debug("根据用户Id:{},查询用户信息:{}",new Object[]{id,user});
        System.out.println("hello world");
        session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally{
            session.close();
        }
    }
    
    /**
     * 查询所有的用户
     */
    private static void selectAllUser(){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
        List<User> user=mapper.selectAllUser();
//        logger.debug("获取所用的用户:{}",user);
        System.out.println("hello world");
        session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally{
            session.close();
        }
    }
}
