package com.lover.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lover.entity.Basic;
import com.lover.entity.Blind;
import com.lover.entity.Seller;

public interface SellerService {

	/**
	 * 通过用户名得到商家的id
	 * @param pwd
	 * @return
	 */
	 public String getId( String name);

	 /**
	  * 通过商家的用户名匹配密码
	  * @param name
	  * @return
	  * @throws SQLException
	  */
	 public String getPassword(String name) ;
	 /**
	  * 通过商家的用户名获得状态
	  * @param name
	  * @return
	  * @throws SQLException
	  */
	 public String getStatus(String name) ;


	public void insertSeller(String name, String summary, String address, String servicetime, String phone,
			String password, String question, String address2);

	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Basic selectCouple(String id) ;

	public ArrayList<Blind> selectBlind(String sellerID, String success, String waiting) ;

	public Seller selectSellerData(String id);

	public void updateSeller(String id, String summary, String address, String servicetime, String phone);

	public void changeStatus(String id,String blind);

	public void handFail(String id, String string, int i);

	public void alterUserStatus(String manId, String womanId,String string);

	public String getManId(String bindId);

	public String getWomanId(String bindId);


	

}
