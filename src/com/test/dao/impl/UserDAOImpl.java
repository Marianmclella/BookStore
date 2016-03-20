package com.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.IUserDAO;
import com.test.db.DBUtils;
import com.test.domain.User;

public class UserDAOImpl implements IUserDAO {

	/**
	 * 登陆功能
	 * */
	public boolean login(String account, String password) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from store.user where account=? && password=?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, account);
			preparedStatement.setString(2, password);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release();
		}
		return false;
	}

	/**
	 * 注册功能
	 * */
	public boolean regist(User user) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		try {
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql1 = "insert into store.user (account,password,role) values(?,?,1)";
			preparedStatement = conn.prepareStatement(sql1);
			preparedStatement.setString(1, user.getAccount());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.executeUpdate();
			String sql2 = "insert into store.userinfo (account,name,mail,address,phone,sex) values (?,?,?,?,?,?)";
			preparedStatement2 = conn.prepareStatement(sql2);
			preparedStatement2.setString(1, user.getAccount());
			preparedStatement2.setString(2, user.getName());
			preparedStatement2.setString(3, user.getEmail());
			preparedStatement2.setString(4, user.getAddress());
			preparedStatement2.setLong(5, user.getPhone());
			preparedStatement2.setLong(6, user.getSex());
			preparedStatement2.executeUpdate();
			conn.commit();
			return true;
		} catch (Exception e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtils.release();
		}
		return false;
	}

	/**
	 * 列出所有会员的信息
	 * */
	public List<User> listAllUser() {
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			statement = conn.createStatement();
			String sql = "select * from store.userinfo";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setAccount(rs.getString("account"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("mail"));
				user.setAddress(rs.getString("address"));
				user.setSex(rs.getInt("sex"));
				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release();
		}
		return users;
	}

	public boolean deleteUser(String account) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		try {
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql = "delete form store.user where account=?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, account);
			String sql2 = "delete from store.userinfo where account=?";
			preparedStatement2 = conn.prepareStatement(sql2);
			preparedStatement2.setString(1,account);
			preparedStatement.executeUpdate();
			preparedStatement2.executeUpdate();
			conn.commit();
			return true;
		} catch (Exception e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DBUtils.release();
		}
		return false;
	}

	/**
	 * 提拔成管理员
	 * */
	public boolean setAttendant(String account) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "update store.user set role=1 where account=?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, account);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 贬为普通会员
	 * */
	public boolean setNormalUser(String account) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "update store.user set role=2 where account=?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, account);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改密码
	 * */
	public boolean updatePassword(String account, String newPassword) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "update store.user set password=? where account=?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1,newPassword);
			preparedStatement.setString(2, account);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUserInfo(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
