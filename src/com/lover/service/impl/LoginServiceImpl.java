package com.lover.service.impl;

import com.lover.dao.LoginDao;
import com.lover.dao.impl.LoginDaoImpl;
import com.lover.entity.Basic;
import com.lover.service.LoginService;

public class LoginServiceImpl implements LoginService{
	LoginDao ld = new LoginDaoImpl();

	@Override
	public String getPassword(String phone) {
		return ld.getPassword(phone);
	}

	@Override
	public int getUserId(String phone) {
		// TODO Auto-generated method stub
		return ld.getUserId(phone);
	}

	@Override
	public void addUser(Basic b) {
		// TODO Auto-generated method stub
		ld.addUser(b);
	}

}
