package com.lover.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lover.entity.Basic;
import com.lover.entity.Blind;
import com.lover.entity.Seller;

public interface SellerDao {

	
	public String getPwd(String name1);

	public String getId(String name2);
	
	public String getStatus(String name2);

	public void insertSeller(String name, String summary, String address, String servicetime, String phone,
			String password, String question, String answer);

	public Seller selectSellerData(String id);

	public ArrayList<Blind> selectBlind(String sellerId, String success, String waiting);

	public Basic selectCouple(String id);

	public void updateSellerData(String id, String summary, String address, String servicetime,
			String phone);

	public void changeStatus(String id,String blind);

	public void changFail(String id, String blind, int fail);

	public void alterUserStatus(String manId,String womanId, String success);

	public String getManId(String bindId);

	public String getWomanId(String bindId);


}
