package com.lover.service.impl;

import com.lover.dao.SendDao;
import com.lover.dao.impl.SendDaoImpl;
import com.lover.entity.Blind;
import com.lover.service.SendService;

public class SendServiceImpl implements SendService{
	SendDao sd = new SendDaoImpl();

	@Override
	public boolean existBlind(String manid, String womanid) {
		// TODO Auto-generated method stub
		return sd.existBlind(manid, womanid);
	}

	@Override
	public Blind queryBlind(String manid, String womanid) {
		// TODO Auto-generated method stub
		return sd.queryBlind(manid, womanid);
	}

	@Override
	public void insertMessage(int sendid, int receiveid, String content) {
		// TODO Auto-generated method stub
		sd.insertMessage(sendid, receiveid, content);
	}

	@Override
	public void addCount(String id) {
		// TODO Auto-generated method stub
		sd.addCount(id);
	}

	@Override
	public void updateBlind(String id, String blind) {
		// TODO Auto-generated method stub
		sd.updateBlind(id, blind);
	}

	@Override
	public void insertBlind(int manid, int womanid) {
		// TODO Auto-generated method stub
		sd.insertBlind(manid, womanid);
	}
	
	

}
