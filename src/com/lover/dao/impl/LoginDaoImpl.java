package com.lover.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.lover.dao.LoginDao;
import com.lover.entity.Basic;
import com.lover.util.DataBaseUtil;
import com.sun.swing.internal.plaf.basic.resources.basic;

public class LoginDaoImpl implements LoginDao{
	
	/**
	 * 根据电话号码返回密码
	 */
	@Override
	public String getPassword(String phone) {
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		String password = "";
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT password FROM u_basic WHERE phone ='"+phone+"'";
			rs = pre.executeQuery(sql);
			if(rs.next()) {
				password = rs.getString("password");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		
		return password;
	}
	
	
	/**
	 * 
	 */
	@Override
	public int getUserId(String phone) {
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		int password = 0;
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT user_id FROM u_basic WHERE phone ='"+phone+"'";
			rs = pre.executeQuery(sql);
			if(rs.next()) {
				password = rs.getInt("user_id");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		
		return password;
	}


	/**
	 * 添加用户
	 */
	@Override
	public void addUser(Basic b) {
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs =null;
		int password = 0;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "INSERT INTO u_basic "
					+ "(sex,birthdy,marry,education,phone,address,"
					+ "salary,question,answer,PASSWORD,head,grade,"
					+ "nick_name,detail_id,hobby_id,couple_id,work_id)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pre = conn.prepareStatement(sql);
			pre.setString(1, b.getSex());
			pre.setDate(2,new Date(b.getBirthday().getTime()));
			pre.setString(3, b.getMarry());
			pre.setString(4, b.getEducation());
			pre.setString(5, b.getPhone());
			pre.setString(6, b.getAddress());
			pre.setString(7, b.getSalary());
			pre.setString(8, b.getQuestion());
			System.out.println(b.getQuestion());
			pre.setString(9, b.getAnswer());
			pre.setString(10, b.getPassword());
			if(b.getSex().equals("男")) {
				pre.setString(11,"boy.jpg");
			}else {
				pre.setString(11, "girl.jpg");
			}
			pre.setInt(12, 0);
			pre.setString(13, "用户"+b.getPhone().substring(6));
			pre.setInt(14, new LoginDaoImpl().insertDetail());
			pre.setInt(15, new LoginDaoImpl().insertHobby());
			pre.setInt(16, new LoginDaoImpl().insertCouple());
			pre.setInt(17, new LoginDaoImpl().insertWork());
			pre.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		
	}


	/**
	 * 插入一条空的detail数据，并返回detail主键
	 */
	@Override
	public int insertDetail() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs =null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "insert into u_detail(place)values(?)";
			//知识点，返回数据为主键
			pre = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pre.setString(1,"");
			pre.executeUpdate();
			//得到主键
			int count = 0;
			rs = pre.getGeneratedKeys();
			if(rs.next()){
				count = rs.getInt(1);
			}
			System.out.println(count);
			return count;
		}catch (Exception e) {
			
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		return 0;
	}


	/**
	 * 插入一条空的Hobby数据，并返回Hobby主键
	 */
	@Override
	public int insertHobby() {
		// TODO Auto-generated method stub
				Connection conn = null;
				PreparedStatement pre = null;
				ResultSet rs =null;
				try {
					conn = DataBaseUtil.getConnection();
					String sql = "insert into u_hobby(greens)values(?)";
					//知识点，返回数据为主键
					pre = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
					pre.setString(1,"");
					pre.executeUpdate();
					//得到主键
					int count = 0;
					rs = pre.getGeneratedKeys();
					if(rs.next()){
						count = rs.getInt(1);
					}
					System.out.println(count);
					return count;
				}catch (Exception e) {
					
				}finally {
					DataBaseUtil.close(conn,  pre, rs);
				}
				return 0;
	}


	/**
	 * 插入一条空的Work数据，并返回Work主键
	 */
	@Override
	public int insertWork() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs =null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "insert into u_work(w_type)values(?)";
			//知识点，返回数据为主键
			pre = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pre.setString(1,"");
			pre.executeUpdate();
			//得到主键
			int count = 0;
			rs = pre.getGeneratedKeys();
			if(rs.next()){
				count = rs.getInt(1);
			}
			System.out.println(count);
			return count;
		}catch (Exception e) {
			
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		return 0;
	}


	/**
	 * 插入一条空的Couple数据，并返回Couple主键
	 */
	@Override
	public int insertCouple() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs =null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "insert into u_couple(c_age)values(?)";
			//知识点，返回数据为主键
			pre = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pre.setString(1,"");
			pre.executeUpdate();
			//得到主键
			int count = 0;
			rs = pre.getGeneratedKeys();
			if(rs.next()){
				count = rs.getInt(1);
			}
			System.out.println(count);
			return count;
		}catch (Exception e) {
			
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		return 0;
	}
	
	
	
	/*
	public static void main(String[] args) {
		LoginDaoImpl u = new LoginDaoImpl();
		System.out.println(u.insertDetail());
	}*/


}
