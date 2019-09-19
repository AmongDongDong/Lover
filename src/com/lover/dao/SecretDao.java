package com.lover.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lover.entity.Basic;
import com.lover.entity.Couple;
import com.lover.entity.Detail;
import com.lover.entity.Hobby;
import com.lover.entity.Worklife;

public interface SecretDao {
	/*
	 * 根据用户名（手机号）查找密保问题
	 * @param name
	 * @return
	 */
	public String findQuestion(String name);
	/**
	 * 根据用户名（手机号）匹配密保答案
	 * @param phone
	 * @return
	 */
	public String getAnswer(String phone);
	/**
	 * 修改密码
	 * @param password1
	 * @param phone 
	 */
	public void UpdatePwd(String password1, String id);
	/**
	 * 通过手机找用户id
	 * @param phone
	 * @return
	 */
	public String getId(String phone);
}
