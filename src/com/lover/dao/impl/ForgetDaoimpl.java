package com.lover.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.lover.dao.ForgetDao;
import com.lover.util.DataBaseUtil;

public class ForgetDaoimpl implements ForgetDao{

	/**
	 * 根据电话号码修改密码
	 */
	@Override
	public void updatePassword(String phone , String password) {
		// TODO Auto-generated method stub
				Connection conn = null;
				Statement pre = null;
				ResultSet rs =null;
				try {
					conn = DataBaseUtil.getConnection();
					String sql = "UPDATE u_basic SET password ='"+password+"' WHERE phone = "+phone;
					pre = conn.createStatement();
					
					pre.execute(sql);
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					DataBaseUtil.close(conn,  pre, rs);
				}
	}
	public static void main(String[] args) {
		new ForgetDaoimpl().updatePassword("17673130854", "123456");
	}


}
