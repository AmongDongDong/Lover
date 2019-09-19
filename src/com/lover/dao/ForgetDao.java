package com.lover.dao;
/**
 * 忘记密码的Dao层
 * @author Administrator
 *
 */
public interface ForgetDao {
	public void updatePassword(String phone , String password);//根据电话号码修改密码
}
