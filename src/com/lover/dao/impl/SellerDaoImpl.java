package com.lover.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.lover.dao.SellerDao;
import com.lover.entity.Basic;
import com.lover.entity.Blind;
import com.lover.entity.Seller;
import com.lover.util.DataBaseUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class SellerDaoImpl implements SellerDao {

	/**
	 * 商家登录时根据用户名匹配密码
	 */
	@Override
	public String getPwd(String name1) {
		Connection conn = null;
		Statement pre = null;
		ResultSet rs = null;
		String password = "";
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT s_password FROM s_seller WHERE seller_name ='" + name1 + "'";
			rs = pre.executeQuery(sql);
			if (rs.next()) {
				password = rs.getString("s_password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}

		return password;
	}

	/**
	 * 商家登录时根据用户名得到id
	 */
	@Override
	public String getId(String name2) {
		Connection conn = null;
		Statement pre = null;
		ResultSet rs = null;
		String id = "";
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT seller_id FROM s_seller WHERE seller_name ='" + name2 + "'";
			rs = pre.executeQuery(sql);
			if (rs.next()) {
				id = rs.getString("seller_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}

		return id;
	}

	
	/**
	 * 插入商家数据
	 */
	@Override
	public void insertSeller(String name, String summary, String address, String servicetime, String phone,
			String password, String question, String answer) {
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "INSERT INTO s_seller(seller_name,summary,s_address,s_date,s_phone,s_password,s_question,s_answer,s_status) VALUES(?,?,?,?,?,?,?,?,?)";
			pre = conn.prepareStatement(sql);
			pre.setString(1, name);
			pre.setString(2, summary);
			pre.setString(3, address);
			pre.setString(4, servicetime);
			pre.setString(5, phone);
			pre.setString(6, password);
			pre.setString(7, question);
			pre.setString(8, answer);
			pre.setString(9, "待审核");
			pre.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}

	}

	/**
	 * 根据id查询用户的所有信息
	 */
	@Override
	public Basic selectCouple(String id) {
		Connection conn = null;
		Statement pre = null;
		ResultSet rs = null;
		Basic ba = null;
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT sex,birthdy,marry,education,grade,phone,head,address,salary,question,answer,PASSWORD,nick_name FROM u_basic WHERE user_id ="
					+ id;
			rs = pre.executeQuery(sql);
			if (rs.next()) {
				ba = new Basic(new Integer(id), 0, 0, 0, 0, rs.getString("answer"), rs.getString("question"),
						rs.getString("password"), null, rs.getString("head"), null, rs.getInt("grade"),
						rs.getString("salary"), rs.getString("address"), rs.getString("phone"), 0,
						rs.getString("education"), rs.getString("marry"), rs.getDate("birthdy"), rs.getString("sex"),
						rs.getString("nick_name"));
				return ba;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}

		return null;

	}
	/*public static void main(String[] args) {
		SellerDaoImpl s = new SellerDaoImpl();
		Basic b = s.selectCouple("111");
		System.out.println(b);
	}*/

	/**
	 * 查询商家数据
	 * 
	 * @return
	 * @throws SQLException
	 */
	@Override
	public Seller selectSellerData(String id) {
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "SELECT seller_name,summary,s_address,s_date,s_phone,"
					+ "s_password,s_question,s_answer FROM s_seller WHERE seller_id="+id;
			psta = conn.prepareStatement(sql);
			rs = psta.executeQuery();

			//ArrayList<Seller> arry = new ArrayList<>();
			if (rs.next()) {
				String name = rs.getString("seller_name");
				String summary = rs.getString("summary");
				String address = rs.getString("s_address");
				String servicetime = rs.getString("s_date");
				String phone = rs.getString("s_phone");
				String password = rs.getString("s_password");
				String question = rs.getString("s_question");
				String answer = rs.getString("s_answer");
				Seller s = new Seller(0, name, summary, address, null, servicetime, phone, password, question, answer,
						null);
				return s;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, psta, rs);
		}
		return null;
	}

	/**
	 * 查询配对表的所有信息
	 */
	@Override
	public ArrayList<Blind> selectBlind(String sellerID, String success, String waiting) {
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "SELECT blind_id,man_id,woman_id,seller_id,count,blind,fail FROM c_blind WHERE (blind = '"+success+"' OR blind = '"+waiting+"' ) AND seller_id = "+sellerID;
			psta = conn.prepareStatement(sql);
			rs = psta.executeQuery();

			ArrayList<Blind> arry = new ArrayList<>();
			while (rs.next()) {
				int blindId = rs.getInt("blind_id");
				int manId = rs.getInt("man_id");
				int womanId = rs.getInt("woman_id");
				int sellerId = rs.getInt("seller_id");
				int count = rs.getInt("count");
				String blind = rs.getString("blind");
				int fail = rs.getInt("fail");
				Blind b = new Blind(blindId, manId, womanId, count, sellerId, blind, fail);
				arry.add(b);
			}
			return arry;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, psta, rs);
		}
		return null;
	}

	/**
	 * 修改商家的基本信息
	 */
	@Override
	public void updateSellerData(String id, String summary, String address, String servicetime,
			String phone) {
		
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "UPDATE s_seller SET summary=?,s_address=?,s_date=?,s_phone=? WHERE seller_id="+id;
			pre = conn.prepareStatement(sql);
			pre.setString(1, summary);
			pre.setString(2, address);
			pre.setString(3, servicetime);
			pre.setString(4, phone);

			pre.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, null);
		}

	}

	/**
	 * 修改相亲配对表的牵手状态
	 */
	@Override
	public void changeStatus(String id,String blind) {
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "UPDATE c_blind SET blind=? WHERE blind_id="+id;
			pre = conn.prepareStatement(sql);
			pre.setString(1, blind);

			pre.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, null);
		}
		
	}


	@Override
	public void changFail(String id, String blind, int fail) {
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "UPDATE c_blind SET blind=?,fail=? WHERE blind_id="+id;
			pre = conn.prepareStatement(sql);
			pre.setString(1, blind);
			pre.setInt(2, fail);

			pre.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, null);
		}
		
	}

	@Override
	public String getStatus(String name2) {
		Connection conn = null;
		Statement pre = null;
		ResultSet rs = null;
		String id = "";
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT s_status FROM s_seller WHERE seller_name ='" + name2 + "'";
			rs = pre.executeQuery(sql);
			if (rs.next()) {
				id = rs.getString("s_status");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}

		return id;
	}

	/**
	 * 修改相亲表的basic表状态
	 */
	@Override
	public void alterUserStatus(String manId,String womanId, String success) {
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "UPDATE u_basic SET loving=? WHERE user_id=" + manId + " OR user_id=" + womanId ;
			pre = conn.prepareStatement(sql);
			pre.setString(1, success);

			pre.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, null);
		}
	}

	@Override
	public String getManId(String bindId) {
		Connection conn = null;
		Statement pre = null;   
		ResultSet rs = null;
		String manid = null;
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT man_id FROM c_blind WHERE blind_id=" + bindId;
			rs = pre.executeQuery(sql);
			if (rs.next()) {
				manid = rs.getString("man_id")+"";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}

		return manid;
	}

	@Override
	public String getWomanId(String bindId) {
		Connection conn = null;
		Statement pre = null;
		ResultSet rs = null;
		String womanid = null;
		try {
			conn = DataBaseUtil.getConnection();
			pre = conn.createStatement();
			String sql = "SELECT woman_id FROM c_blind WHERE blind_id="+bindId;
			rs = pre.executeQuery(sql);
			if (rs.next()) {
				womanid = rs.getString("woman_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}

		return womanid;
	}

	public static void main(String[] args) {
		System.out.println(new SellerDaoImpl().getManId("20000029"));
		System.out.println(new SellerDaoImpl().getWomanId("20000029"));
	}

}
