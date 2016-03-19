package com.test.junit;

import java.util.List;

import org.junit.Test;

import com.test.dao.impl.UserDAOImpl;
import com.test.domain.User;

public class TestUserServiceImpl {
	
	static UserDAOImpl userDAO = new UserDAOImpl();
	
	@Test
	public void testRegist(){
		User user = new User("admin","123","ma","xiaodon",1,8854176,"admin@163.com");
		System.out.println(userDAO.regist(user));
	}
	
	@Test
	public void testLogin(){
		System.out.println(userDAO.login("admin", "123"));
	}
	
	@Test
	public void testListUsers(){
		List<User> users = userDAO.listAllUser();
		for(User user : users){
			System.out.print(user.getId()+"\t");
			System.out.print(user.getAccount()+"\t");
			System.out.print(user.getName()+"\t");
			System.out.print(user.getAddress()+"\t");
			System.out.print(user.getEmail()+"\t");
			System.out.println("");
		}
	}
	
	@Test
	public void testSetAttendant(){
		System.out.println(userDAO.setAttendant("123"));
	}
	
	
	
	
	
	
	
}
