package com.lover.service.impl;

import java.util.ArrayList;

import com.lover.dao.FirstDao;
import com.lover.dao.impl.FirstDaoImpl;
import com.lover.entity.Attention;
import com.lover.entity.Basic;
import com.lover.entity.Browse;
import com.lover.entity.Dynamic;
import com.lover.service.FirstService;

public class FirstServiceimpl implements FirstService{
	FirstDao fd = new FirstDaoImpl();

	@Override
	public boolean queryVip(String id) {
		// TODO Auto-generated method stub
		return fd.queryVip(id);
	}

	@Override
	public Basic queryUser(String id) {
		// TODO Auto-generated method stub
		return fd.queryUser(id);
	}

	@Override
	public ArrayList<Basic> queryAllUser() {
		// TODO Auto-generated method stub
		return fd.queryAllUser();
	}

	@Override
	public ArrayList<Dynamic> queryAllDynamic(String id) {
		// TODO Auto-generated method stub
		return fd.queryAllDynamic(id);
	}

	@Override
	public ArrayList<Dynamic> queryOneDynamic(String id) {
		// TODO Auto-generated method stub
		return fd.queryOneDynamic(id);
	}

	@Override
	public ArrayList<Basic> queryOtherUser(String id) {
		// TODO Auto-generated method stub
		return fd.queryOtherUser(id);
	}

	@Override
	public ArrayList<Browse> queryWhoSeeMe(String id) {
		// TODO Auto-generated method stub
		return fd.queryWhoSeeMe(id);
	}

	@Override
	public ArrayList<Attention> queryMyAttention(String id) {
		// TODO Auto-generated method stub
		return fd.queryMyAttention(id);
	}

	@Override
	public int releaseTrends(String speak, String photo, String userId) {
		// TODO Auto-generated method stub
		return fd.releaseTrends(speak, photo, userId);
	}

	@Override
	public boolean isFocus(String deId, String selfID) {
		// TODO Auto-generated method stub
		return fd.isFocus(deId, selfID);
	}

	@Override
	public void insertFocus(String deId, String selfId) {
		// TODO Auto-generated method stub
		fd.insertFocus(deId, selfId);
	}

	@Override
	public void deleteFocus(String deId, String selfId) {
		// TODO Auto-generated method stub
		fd.deleteFocus(deId, selfId);
	}

	@Override
	public void insertBrowse(String selfId, String deId) {
		// TODO Auto-generated method stub
		fd.insertBrowse(selfId, deId);
	}
	

}
