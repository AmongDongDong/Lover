package com.lover.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import com.lover.dao.FirstDao;
import com.lover.entity.Attention;
import com.lover.entity.Basic;
import com.lover.entity.Browse;
import com.lover.entity.Dynamic;
import com.lover.entity.Picture;
import com.lover.util.DataBaseUtil;

public class FirstDaoImpl implements FirstDao{

	/**
	 * 查询是否为VIP,返回true：是VIP，返回false：不是VIP
	 */
	@Override
	public boolean queryVip(String id) {
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		int grade = 0;
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT grade FROM u_basic WHERE user_id ="+id;
			rs = pre.executeQuery(sql);
			if(rs.next()) {
				grade = rs.getInt("grade");
				if(grade == 0) {
					return false;
				}else {
					return true;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		
		return false;
	}

	/**
	 * 根据id查找相应basic
	 */
	@Override
	public Basic queryUser(String id) {
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		Basic ba =null;
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT detail_id,hobby_id,couple_id,work_id ,sex,birthdy,marry,education,grade,phone,head,address,salary,question,answer,PASSWORD,nick_name FROM u_basic WHERE user_id ="+id;
			rs = pre.executeQuery(sql);
			if(rs.next()) {
				ba = new Basic(new Integer(id), rs.getInt("detail_id"), rs.getInt("hobby_id"),rs.getInt("couple_id"),rs.getInt("work_id"), rs.getString("answer"), rs.getString("question"), 
						rs.getString("password"), null,rs.getString("head") , null, rs.getInt("grade"),
						rs.getString("salary"), rs.getString("address"), rs.getString("phone"), 0,
						rs.getString("education"), rs.getString("marry"), rs.getDate("birthdy"),
						rs.getString("sex"),rs.getString("nick_name") );
				return ba;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		
		return null;
	}

	/**
	 * 查找所有的用户
	 */
	@Override
	public ArrayList<Basic> queryAllUser() {
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		Basic ba =null;
		ArrayList<Basic> al = new ArrayList<Basic>();
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT  user_id,detail_id,hobby_id,couple_id,work_id ,sex,birthdy,marry,education,grade,phone,head,address,salary,question,answer,PASSWORD,nick_name FROM u_basic ";
			rs = pre.executeQuery(sql);
			while(rs.next()) {
				ba = new Basic(rs.getInt("user_id"), rs.getInt("detail_id"), rs.getInt("hobby_id"),rs.getInt("couple_id"),rs.getInt("work_id"), rs.getString("answer"), rs.getString("question"), 
						rs.getString("password"), null,rs.getString("head") , null, rs.getInt("grade"),
						rs.getString("salary"), rs.getString("address"), rs.getString("phone"), 0,
						rs.getString("education"), rs.getString("marry"), rs.getDate("birthdy"),
						rs.getString("sex"),rs.getString("nick_name") );
				al.add(ba);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		
		return al;
	}


	/**
	 * 查找除自己外所有人的动态
	 */
	@Override
	public ArrayList<Dynamic> queryAllDynamic(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		ArrayList<Dynamic> al = new ArrayList<Dynamic>();
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT dynamic_id , user_id , d_content , date , laud , picture FROM u_dynamic WHERE user_id<>"+id;
			rs = pre.executeQuery(sql);
			while(rs.next()) {
				Dynamic dy = new Dynamic(rs.getInt("dynamic_id"),rs.getInt("user_id"), rs.getString("d_content"),new java.util.Date(new Long(rs.getString("date"))), rs.getInt("laud"),rs.getString("picture"));
				al.add(dy);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		return al;
	}

	/**
	 * 查找指定的id的动态
	 */
	@Override
	public ArrayList<Dynamic> queryOneDynamic(String id) {
		// TODO Auto-generated method stub
				Connection conn = null;
				Statement pre = null;
				ResultSet rs =null;
				ArrayList<Dynamic> al = new ArrayList<Dynamic>();
				try {
					conn = DataBaseUtil.getConnection();
					pre = conn.createStatement();
					String sql = "SELECT dynamic_id , user_id , d_content , date , laud , picture FROM u_dynamic WHERE user_id="+id;
					rs = pre.executeQuery(sql);
					while(rs.next()) {
						Dynamic dy = new Dynamic(rs.getInt("dynamic_id"),rs.getInt("user_id"), 
								rs.getString("d_content"),new java.util.Date(new Long(rs.getString("date"))), rs.getInt("laud"),rs.getString("picture"));
						al.add(dy);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					DataBaseUtil.close(conn,  pre, rs);
				}
				return al;
	}

	/**
	 * 查找除自己外所有的用户
	 */
	@Override
	public ArrayList<Basic> queryOtherUser(String id) {
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		Basic ba =null;
		ArrayList<Basic> al = new ArrayList<Basic>();
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT  user_id, sex,birthdy,marry,education,grade,phone,head,address,salary,question,answer,PASSWORD,nick_name FROM u_basic WHERE user_id<>"+id;
			rs = pre.executeQuery(sql);
			while(rs.next()) {
				ba = new Basic(rs.getInt("user_id"), 0, 0, 0, 0, rs.getString("answer"), rs.getString("question"), 
						rs.getString("password"), null,rs.getString("head") , null, rs.getInt("grade"),
						rs.getString("salary"), rs.getString("address"), rs.getString("phone"), 0,
						rs.getString("education"), rs.getString("marry"), rs.getDate("birthdy"),
						rs.getString("sex"),rs.getString("nick_name") );
				al.add(ba);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		
		return al;
	}

	/**
	 * 查找谁看了我表中的数据
	 */
	@Override
	public ArrayList<Browse> queryWhoSeeMe(String id) {
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		Basic ba =null;
		ArrayList<Browse> al = new ArrayList<Browse>();
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT b_id,browse_date,browse_id FROM u_browse WHERE browsed_id="+id;
			rs = pre.executeQuery(sql);
			while(rs.next()) {
				Browse bse = new Browse(rs.getInt("b_id"), rs.getInt("browse_id"), new Integer(id), rs.getDate("browse_date"));
				al.add(bse);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		
		return al;
	}

	/**
	 * 查找关注表中的数据
	 */
	@Override
	public ArrayList<Attention> queryMyAttention(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		Basic ba =null;
		ArrayList<Attention> al = new ArrayList<Attention>();
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT attention_id,attentioned_id FROM u_attention WHERE attention_id="+id;
			rs = pre.executeQuery(sql);
			while(rs.next()) {
				Attention at = new Attention(rs.getInt("attention_id"), rs.getInt("attentioned_id"));
				al.add(at);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
		
		return al;
	}

	/**
	 * 发布动态 , 返回动态主键
	 */
	@Override
	public int releaseTrends(String speak, String photo, String userId) {
		// TODO Auto-generated method stub
				Connection conn = null;
				PreparedStatement pre = null;
				ResultSet rs =null;
				try {
					conn = DataBaseUtil.getConnection();
					String sql = "insert into u_dynamic(user_id,picture,date,laud,d_content)values(?,?,?,?,?)";
					//知识点，返回数据为主键
					pre = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
					pre.setInt(1,new Integer(userId));
					pre.setString(2, photo);
					pre.setString(3,new Long( new java.util.Date().getTime()).toString());
					pre.setInt(4, 0);
					pre.setString(5, speak);
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
	 * 查看自己是否关注了他
	 */
	@Override
	public boolean isFocus(String deId, String selfID) {
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		int grade = 0;
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT attention_id FROM u_attention WHERE attention_id ="+selfID+" AND attentioned_id="+deId;
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
	 * 插入一条关注数据
	 */
	@Override
	public void insertFocus(String deId, String selfId) {
				Connection conn = null;
				Statement pre = null;
				ResultSet rs =null;
				try {
					conn = DataBaseUtil.getConnection();
					String sql = "insert into u_attention(attention_id , attentioned_id )values("+selfId+","+deId+")";
					//知识点，返回数据为主键
					pre = conn.createStatement();
					pre.executeUpdate(sql);
					
				}catch (Exception e) {
					
				}finally {
					DataBaseUtil.close(conn,  pre, rs);
				}
	}

	@Override
	public void deleteFocus(String deId, String selfId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "delete from u_attention where attention_id="+selfId+" and attentioned_id="+deId;
			//知识点，返回数据为主键
			pre = conn.createStatement();
			pre.executeUpdate(sql);
			
		}catch (Exception e) {
			
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
	}

	/**
	 * 将自己的id与查看的人的id插入表中
	 */
	@Override
	public void insertBrowse(String selfId, String deId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs =null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "insert into u_browse(browse_id , browsed_id ,browse_date )values(?,?,?)";
			//知识点，返回数据为主键
			pre = conn.prepareStatement(sql);
			pre.setInt(1, new Integer(selfId));
			pre.setInt(2, new Integer(deId));
			pre.setDate(3, new Date(new java.util.Date().getTime()));
			pre.execute();
			
		}catch (Exception e) {
			
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
	}
	public static void main(String[] args) {
		new FirstDaoImpl().insertBrowse("16000000","16000004");
	}
	
}
