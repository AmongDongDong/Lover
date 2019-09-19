package com.lover.service.impl;

import com.lover.dao.ForgetDao;
import com.lover.dao.impl.ForgetDaoimpl;
import com.lover.service.ForgetService;

public class ForgetServiceImpl implements ForgetService{
	ForgetDao fd = new ForgetDaoimpl();
	
	@Override
	public void updatePassword(String phone, String password) {
		// TODO Auto-generated method stub
		fd.updatePassword(phone, password);
	}

	

}
