package com.test.dao;

import java.util.List;

import com.test.domain.User;

public interface IUserDAO {
	
	/**
	 * 登陆
	 * */
	boolean login(String account,String password);
	
	/**
	 * 注册
	 * */
	boolean regist(User user);
	
	/**
	 * 列出所有会员的信息
	 * */
	List<User> listAllUser();
	
	/**
	 * 删除某个会员
	 * */
	boolean deleteUser(String account);
	
	/**
	 * 设为管理员
	 * */
	boolean setAttendant(String account);
	
	/**
	 * 恢复普通会员
	 * */
	boolean setNormalUser(String account);
	
	/**
	 * 修改密码
	 * */
	boolean updatePassword(String account,String newPassword);
	
	/**
	 * 修改个人信息
	 * */
	boolean updateUserInfo(User user);
}
