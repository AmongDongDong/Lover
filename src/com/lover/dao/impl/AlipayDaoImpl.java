package com.lover.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.lover.dao.AlipayDao;
import com.lover.util.DataBaseUtil;

public class AlipayDaoImpl implements AlipayDao{

	@Override
	public void updateGrade(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement pre = null;
		ResultSet rs =null;
		int password = 0;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "UPDATE u_basic SET grade=1 WHERE user_id = "+id;
			pre = conn.createStatement();
			
			pre.execute(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn,  pre, rs);
		}
	}
	public static void main(String[] args) {
		new AlipayDaoImpl().updateGrade("16000000");
	}


}
