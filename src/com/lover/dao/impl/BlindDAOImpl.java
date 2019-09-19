package com.lover.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lover.dao.BlindDAO;
import com.lover.entity.Blind;
import com.lover.util.*;

public class BlindDAOImpl implements BlindDAO{
	/**
	 * 查询所有相亲信息
	 * @return 所有的相亲信息
	 */
	@Override
	public ArrayList<Blind> findAllBlind() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1.获取数据库连接
			conn = DataBaseUtil.getConnection();
			//2.获取PreparedStatement
			String sql = "SELECT BLIND_ID,MAN_ID,WOMAN_ID,COUNT,SELLER_ID,BLIND,FAIL FROM C_BLIND";
			//SELECT blind_id,man_id,woman_id,COUNT,blind,fail FROM c_blind;
			pstmt = conn.prepareStatement(sql);
			//3.获取结果集
			rs = pstmt.executeQuery();
			//4.将获取的结果存入ArrayList
			ArrayList<Blind> list = new ArrayList<Blind>();
			while(rs.next()){
				int blind_id = rs.getInt("BLIND_ID");
				int man_id = rs.getInt("MAN_ID");
				int woman_id = rs.getInt("WOMAN_ID");
				int count = rs.getInt("COUNT");
				int seller_id = rs.getInt("SELLER_ID");
				String blind = rs.getString("BLIND");
				int fail = rs.getInt("FAIL");
				Blind bd = new Blind(blind_id, man_id, woman_id, count, seller_id, blind, fail);
				list.add(bd);
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
	 * 根据相亲订单ID修改相亲订单状态
	 * @param blind_id 相亲订单ID
	 * @param blind 订单状态
	 */
	@Override
	public void upDateBlind(int blind_id, String blind) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1.获取数据库连接
			conn = DataBaseUtil.getConnection();
			//2.获取PreparedStatement
			String sql = "UPDATE c_blind SET blind = '"+blind+"' WHERE blind_id = "+blind_id+"";
			pstmt = conn.prepareStatement(sql);
			//3.获取结果集
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5.关闭资源
			DataBaseUtil.close(conn, pstmt,rs);
		}
		
	}
	/**
	 * 根据相亲订单ID查询相亲订单信息
	 * @param blind_id 相亲订单ID
	 * @return 相亲订单信息
	 */
	@Override
	public Blind findBlindByID(int blind_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1.获取数据库连接
			conn = DataBaseUtil.getConnection();
			//2.获取PreparedStatement
			String sql = "SELECT BLIND_ID,MAN_ID,WOMAN_ID,COUNT,SELLER_ID,BLIND,FAIL FROM C_BLIND WHERE BLIND_ID = "+blind_id+"";
			//SELECT blind_id,man_id,woman_id,COUNT,blind,fail FROM c_blind;
			pstmt = conn.prepareStatement(sql);
			//3.获取结果集
			rs = pstmt.executeQuery();
			//4.将获取的结果存入ArrayList
			while(rs.next()){
				int man_id = rs.getInt("MAN_ID");
				int woman_id = rs.getInt("WOMAN_ID");
				int count = rs.getInt("COUNT");
				int seller_id = rs.getInt("SELLER_ID");
				String blind = rs.getString("BLIND");
				int fail = rs.getInt("FAIL");
				Blind bd = new Blind(blind_id, man_id, woman_id, count, seller_id, blind, fail);
				return bd;
			}
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
	 * 根据相亲订单ID修改相亲失败量级
	 * @param blind_id blind_id 相亲订单ID
	 * @param fail 相亲失败量级
	 */
	@Override
	public void upDateBlindFail(int blind_id, int fail) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//1.获取数据库连接
			conn = DataBaseUtil.getConnection();
			//2.获取PreparedStatement
			String sql = "UPDATE c_blind SET fail = "+fail+" WHERE blind_id = "+blind_id+"";
			pstmt = conn.prepareStatement(sql);
			//3.获取结果集
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5.关闭资源
			DataBaseUtil.close(conn, pstmt,rs);
		}
	}
	
	//直接查询出相亲追踪页面三个表需要信息的SQL语句
//	SELECT t3.blind_id,t3.man_head,t3.man_name,t3.man_phone,t3.woman_head,t3.woman_name,t3.woman_phone,t4.seller_name,t3.blind FROM 
//	(SELECT t1.blind_id,t1.man_head,t1.man_name,t1.man_phone,t2.woman_head,t2.woman_name,t2.woman_phone,t1.blind FROM 
//	(SELECT c.blind_id,u.head man_head,u.nick_name man_name,u.phone man_phone,c.blind FROM u_basic u JOIN (SELECT blind_id,man_id,blind FROM c_blind) c ON u.user_id = c.man_id) t1 JOIN 
//	(SELECT c.blind_id,u.head woman_head,u.nick_name woman_name,u.phone woman_phone FROM u_basic u JOIN (SELECT blind_id,woman_id FROM c_blind) c ON u.user_id = c.woman_id) t2 ON t1.blind_id = t2.blind_id) t3 JOIN
//	(SELECT c.blind_id,c.seller_id,s.seller_name FROM s_seller s RIGHT JOIN (SELECT blind_id,seller_id FROM c_blind) c ON c.seller_id = s.seller_id) t4 ON t3.blind_id = t4.blind_id
	
	//测试
//	public static void main(String[] args) {
//		BlindDAOImpl bdi = new BlindDAOImpl();
////		ArrayList<Blind> bd = bdi.findAllBlind();
////		System.out.println(bd);
////		bdi.upDateBlind(20000000, "待通知");
////		System.out.println(bdi.findBlindByID(20000000));
//	}

}
