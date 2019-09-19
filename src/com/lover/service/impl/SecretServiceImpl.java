package com.lover.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.User;

import com.lover.dao.SecretDao;
import com.lover.dao.UserDao;
import com.lover.dao.impl.SecretDaoImpl;
import com.lover.dao.impl.UserDaoImpl;
import com.lover.entity.Basic;
import com.lover.entity.Couple;
import com.lover.entity.Detail;
import com.lover.entity.Hobby;
import com.lover.entity.Worklife;
import com.lover.service.SecretService;
import com.lover.service.UserService;

public class SecretServiceImpl implements SecretService{
	SecretDao dao = new SecretDaoImpl();
	
	
	@Override
	public String findQuestion(String phone) {
		
		return dao.findQuestion(phone);
	}
	@Override
	public String getAnswer(String phone) {
		
		return dao.getAnswer(phone);
	}
	@Override
	public void updatePassword(String password1,String id) {
		dao.UpdatePwd(password1,id);
		
	}
	@Override
	public String getId(String phone) {
		return dao.getId(phone);
	}

}
