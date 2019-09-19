package com.lover.service;

import com.lover.entity.Basic;

public interface LoginService {
	public String getPassword(String phone);//根据电话号码获取密码
	public int getUserId(String phone);//根据电话号码获取用户ID
	public void addUser(Basic b);//添加用户到数据库
}
