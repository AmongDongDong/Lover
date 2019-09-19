package com.lover.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lover.dao.SecretDao;
import com.lover.dao.UserDao;
import com.lover.entity.Basic;
import com.lover.entity.Couple;
import com.lover.entity.Detail;
import com.lover.entity.Hobby;
import com.lover.entity.Worklife;
import com.lover.util.DataBaseUtil;

public class SecretDaoImpl implements SecretDao {


	@Override
	public String findQuestion(String phone) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		String question = "";
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "SELECT question FROM u_basic WHERE phone="+phone;
			stat = conn.createStatement();

			rs = stat.executeQuery(sql);
			while (rs.next()) {
				question = rs.getString("question");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, stat, rs);
		}
		return question;
	}

	@Override
	public String getAnswer(String phone) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		String answer = "";
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "SELECT answer FROM u_basic WHERE phone="+phone;
			stat = conn.createStatement();

			rs = stat.executeQuery(sql);
			while (rs.next()) {
				answer = rs.getString("answer");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, stat, rs);
		}
		return answer;
	}

	@Override
	public void UpdatePwd(String password1,String id) {
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "update u_basic set password=? where user_id=" + id;
			pre = conn.prepareStatement(sql);
			pre.setString(1, password1);
			pre.executeUpdate();
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}
		
	}

	@Override
	public String getId(String phone) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		String id = "";
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "SELECT user_id FROM u_basic WHERE phone="+phone;
			stat = conn.createStatement();

			rs = stat.executeQuery(sql);
			while (rs.next()) {
				id = rs.getString("user_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, stat, rs);
		}
		return id;
	}
	
}
