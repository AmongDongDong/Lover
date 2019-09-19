package com.lover.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.lover.dao.MessageDAO;
import com.lover.entity.Message;
import com.lover.util.*;

public class MessageDAOImpl implements MessageDAO{
	
	/**
	 * 根据用户ID查询所有收到的留言信息(按时间升序)
	 * @param user_id 用户ID
	 * @return 所有收到的留言信息
	 */
	@Override
	public ArrayList<Message> findMessaged(int user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1.获取数据库连接
			conn = DataBaseUtil.getConnection();
			//2.获取PreparedStatement
			String sql = "SELECT m_id,message_id,messaged_id,m_content,m_date FROM u_message WHERE messaged_id = "+user_id+" ORDER BY m_date";
			pstmt = conn.prepareStatement(sql);
			//3.获取结果集
			rs = pstmt.executeQuery();
			//4.将获取的结果存入ArrayList
			ArrayList<Message> list = new ArrayList<Message>();
			while(rs.next()){
				int m_id = rs.getInt("m_id");
				int message_id = rs.getInt("message_id");
				int messaged_id = rs.getInt("messaged_id");
				String m_content = rs.getString("m_content");
				String m_date = rs.getString("m_date");
				Message m = new Message(m_id, message_id, messaged_id, m_content, m_date);
				list.add(m);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5.关闭资源
			DataBaseUtil.close(conn, pstmt,rs);
		}
		return null;
	}
	
	/**
	 * 根据用户ID查询所有发出的留言信息(按时间升序)
	 * @param user_id 用户ID
	 * @return 所有发出的留言信息
	 */
	@Override
	public ArrayList<Message> findMessage(int user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1.获取数据库连接
			conn = DataBaseUtil.getConnection();
			//2.获取PreparedStatement
			String sql = "SELECT m_id,message_id,messaged_id,m_content,m_date FROM u_message WHERE message_id = "+user_id+" ORDER BY m_date";
			pstmt = conn.prepareStatement(sql);
			//3.获取结果集
			rs = pstmt.executeQuery();
			//4.将获取的结果存入ArrayList
			ArrayList<Message> list = new ArrayList<Message>();
			while(rs.next()){
				int m_id = rs.getInt("m_id");
				int message_id = rs.getInt("message_id");
				int messaged_id = rs.getInt("messaged_id");
				String m_content = rs.getString("m_content");
				String m_date = rs.getString("m_date");
				Message m = new Message(m_id, message_id, messaged_id, m_content, m_date);
				list.add(m);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5.关闭资源
			DataBaseUtil.close(conn, pstmt,rs);
		}
		return null;
	}
	
	/**
	 * 根据两个用户id,查询他们之间的全部留言信息
	 * @param user_id 
	 * @param id
	 * @return 两个用户之间的全部留言信息
	 */
	@Override
	public ArrayList<Message> findAllMsgByID(int user_id, int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1.获取数据库连接
			conn = DataBaseUtil.getConnection();
			//2.获取PreparedStatement
			String sql = "SELECT m_id,message_id,messaged_id,m_content,m_date FROM u_message WHERE (message_id = "+user_id+" AND messaged_id = "+id+") OR (message_id = "+id+" AND messaged_id = "+user_id+") ORDER BY m_date";
			pstmt = conn.prepareStatement(sql);
			//3.获取结果集
			rs = pstmt.executeQuery();
			//4.将获取的结果存入ArrayList
			ArrayList<Message> list = new ArrayList<Message>();
			while(rs.next()){
				int m_id = rs.getInt("m_id");
				int message_id = rs.getInt("message_id");
				int messaged_id = rs.getInt("messaged_id");
				String m_content = rs.getString("m_content");
				String m_date = rs.getString("m_date");
				Message m = new Message(m_id, message_id, messaged_id, m_content, m_date);
				list.add(m);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5.关闭资源
			DataBaseUtil.close(conn, pstmt,rs);
		}
		return null;
	}
	
	//测试
//	public static void main(String[] args) {
//		MessageDAOImpl mdi = new MessageDAOImpl();
////		ArrayList<Message> mlist1 = mdi.findMessaged(16000014);
////		System.out.println(mlist1);
////		ArrayList<Message> mlist2 = mdi.findMessage(16000014);
////		System.out.println(mlist2);
//		System.out.println(mdi.findAllMsgByID(16000014, 16000018));
//	}
}
