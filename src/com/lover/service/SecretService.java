package com.lover.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.User;

import com.lover.entity.Basic;
import com.lover.entity.Couple;
import com.lover.entity.Detail;
import com.lover.entity.Hobby;
import com.lover.entity.Worklife;

public interface SecretService {

	/**
	 * 通过用户名手机号查找用户密保问题
	 * @param name
	 * @return
	 */
	public String findQuestion(String phone);
	/**
	 * 通过用户名手机号匹配用户密保答案
	 * @param phone
	 * @return
	 */
	public String getAnswer(String phone);
	/**
	 * 修改密码
	 * @param password1
	 * @param phone 
	 */
	public void updatePassword(String password1, String id);
	/**
	 * 通过手机找用户id
	 * @param phone
	 * @return
	 */
	public String getId(String phone);
}
