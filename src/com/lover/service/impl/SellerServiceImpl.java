package com.lover.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lover.dao.SellerDao;
import com.lover.dao.impl.SellerDaoImpl;
import com.lover.entity.Basic;
import com.lover.entity.Blind;
import com.lover.entity.Seller;
import com.lover.service.SellerService;

public class SellerServiceImpl implements SellerService{
	SellerDao dao = new SellerDaoImpl();

	/**
	 * 根据商家名字得到密码
	 * @throws SQLException 
	 */
	@Override
	public String getPassword(String name){
		String s = dao.getPwd(name);
		if (name!="")
		{
			return s;
		}
		return null;
	}

	/**
	 * 根据商家名称得到id
	 */
	@Override
	public String getId(String name) {
		String s = dao.getId(name);
		return s;
	}

	/**
	 * 注册商家信息
	 */
	@Override
	public void insertSeller(String name, String summary, String address, String servicetime, String phone,
			String password, String question, String answer) {
		dao.insertSeller(name, summary, address, servicetime, phone,
				password, question, answer);
	}

	/**
	 * 查询配对表数据,根据id查找用户 
	 */
	@Override
	public Basic selectCouple(String id) {
		Basic b = dao.selectCouple(id);
		return b;
	}

	/**
	 * 查询商家数据
	 * @throws SQLException 
	 */
	@Override
	public Seller selectSellerData(String  id) {
		Seller s = dao.selectSellerData(id);
		return s;
	}

	/**
	 * 相亲配对表的所有信息
	 */
	@Override
	public ArrayList<Blind> selectBlind(String sellerID, String success, String waiting) {
		ArrayList<Blind> arry = dao.selectBlind(sellerID,success,waiting);
		return arry;
	}

	/**
	 * 修改商家的基本信息
	 */
	@Override
	public void updateSeller(String id, String summary, String address, String servicetime, String phone) {
		
		dao.updateSellerData(id,summary,address,servicetime,phone);
	}

	/**
	 * 修改配对表的牵手状态为成功
	 */
	@Override
	public void changeStatus(String id,String blind) {
		dao.changeStatus(id,blind);
		
	}

	@Override
	public void handFail(String id, String blind, int fail) {
		dao.changFail(id,blind,fail);
		
	}

	@Override
	public String getStatus(String name) {
		// TODO Auto-generated method stub
		String s = dao.getStatus(name);
		if (name!="")
		{
			return s;
		}
		return null;
	}


	@Override
	public void alterUserStatus(String manId,String womanId, String success) {
		dao.alterUserStatus(manId,womanId,success);
		
	}

	@Override
	public String getManId(String bindId) {
		
		return dao.getManId(bindId);
	}
	
	@Override
	public String getWomanId(String bindId) {
		
		return dao.getWomanId(bindId);
	}


}
