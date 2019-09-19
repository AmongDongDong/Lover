package com.lover.dao;

import com.lover.entity.Basic;

public interface LoginDao {
	public String getPassword(String phone);//根据电话号码获取密码
	public int getUserId(String phone);//根据电话号码获取用户ID
	public void addUser(Basic b);//添加用户到数据库
	public int insertDetail();//插入一条空的detail数据，并返回detail主键
	public int insertHobby();//插入一条空的Hobby数据，并返回Hobby主键
	public int insertWork();//插入一条空的Work数据，并返回Work主键
	public int insertCouple();//插入一条空的Couple数据，并返回Couple主键
}
