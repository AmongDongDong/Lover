package com.lover.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import com.lover.dao.SendDao;
import com.lover.entity.Basic;
import com.lover.entity.Blind;
import com.lover.util.DataBaseUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class SendDaoImpl implements SendDao{

	/**
	 * 根据男女id判断是否存在该信息
	 */
	@Override
	public boolean existBlind(String manid, String womanid) {
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		int grade = 0;
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT blind_id FROM c_blind WHERE man_id ="+manid+" AND woman_id="+womanid;
			rs = pre.executeQuery(sql);
			if(rs.next()) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		
		return false;
	}

	/**
	 * 根据男女ID查出整条数据
	 */
	@Override
	public Blind queryBlind(String manid, String womanid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		Blind bl =null;
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT blind_id,man_id,woman_id,count ,seller_id,blind,fail FROM c_blind WHERE man_id ="+manid+" AND woman_id="+womanid;
			rs = pre.executeQuery(sql);
			if(rs.next()) {
				bl = new Blind(rs.getInt("blind_id"), rs.getInt("man_id"),
						rs.getInt("woman_id"), rs.getInt("count"), rs.getInt("seller_id"),
						rs.getString("blind"), rs.getInt("fail"));
				return bl;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		
		return null;
	}
	
	
	/**
	 * 插入一条留言数数据
	 */
	@Override
	public void insertMessage(int sendid, int receiveid, String content) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs =null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "INSERT INTO u_message (message_id,messaged_id,m_content,m_date)VALUES(?,?,?,?)";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, sendid);
			pre.setInt(2, receiveid);
			pre.setString(3, content);
			pre.setString(4, new Long(new Date().getTime()).toString());
			pre.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		
	}
	/**
	 * 根据id增加blind表中的count
	 */
	@Override
	public void addCount(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		int grade = 0;
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "UPDATE  c_blind SET count=(count+1) WHERE blind_id ="+id;
			pre.execute(sql);
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		
	}
	
	
	/**
	 * 根据id修改blind表的状态
	 */
	@Override
	public void updateBlind(String id, String blind) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		int grade = 0;
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "UPDATE  c_blind SET blind='"+blind+"' WHERE blind_id ="+id;
			pre.execute(sql);
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
	}
	public static void main(String[] args) {
		new SendDaoImpl().insertBlind(16000003, 16000000);;
	}

	/**
	 * 增加一条新数据,count=1,状态=待就绪,fail=0
	 */
	@Override
	public void insertBlind(int manid, int womanid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Connection conn = null;
				PreparedStatement pre = null;
				ResultSet rs =null;
				try {
					conn = DataBaseUtil.getConnection();
					String sql = "INSERT INTO c_blind (man_id,woman_id,count,fail,blind)VALUES(?,?,?,?,?)";
					pre = conn.prepareStatement(sql);
					pre.setInt(1, manid);
					pre.setInt(2, womanid);
					pre.setInt(3, 1);
					pre.setInt(4, 0);
					pre.setString(5, "待就绪");
					pre.executeUpdate();
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					DataBaseUtil.close(conn,  pre, rs);
				}
	}

}
