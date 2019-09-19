package com.lover.service.impl;

import com.lover.dao.AlipayDao;
import com.lover.dao.impl.AlipayDaoImpl;
import com.lover.service.AlipayService;

public class AlipayServiceImpl implements AlipayService{
	
	AlipayDao ad = new AlipayDaoImpl();
	@Override
	public void updateGrade(String id) {
		// TODO Auto-generated method stub
		ad.updateGrade(id);
	}

	
}
