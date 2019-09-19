package com.lover.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.User;

import com.lover.dao.UserDao;
import com.lover.dao.impl.UserDaoImpl;
import com.lover.entity.Basic;
import com.lover.entity.Couple;
import com.lover.entity.Detail;
import com.lover.entity.Hobby;
import com.lover.entity.Worklife;
import com.lover.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao dao = new UserDaoImpl();
	
	@Override
	public Basic selectbasic(int id){
		Basic b = dao.selectbasic(id); 
		return b;
	}
	@Override
	public Detail selectdetail(int id) {
		Detail d = dao.selectdetail(id);
		return d;
		/*String[] p = d.getPlace().split("/");*/
	}
	@Override
	public void updatebasic(int id, String nickname, String phone, String address, String salary, String height)
			throws Exception {
		int heighta = Integer.valueOf(height);
		dao.updatebasic(id,nickname,phone,address,salary,heighta); 
	}
	@Override
	public void updatedetail(int id, String place, String weight, String body, String star, String havechild,
			String wantchild, String marry, String hearttalk) {
		int weighta = Integer.valueOf(weight);
		dao.updatedetail(id,place,weighta,body,star,havechild,wantchild,marry,hearttalk);
		
	}
	@Override
	public Worklife selectworklife(int id) {
		Worklife w = dao.selectworklife(id);
		return w;
	}
	@Override
	public void updateworklife(int id, String type, String house, String car, String smoke, String drink) {
		dao.updateworklide(id,type,house,car,smoke,drink);
	}
	@Override
	public Couple selectcouple(int id) {
		Couple c = dao.selectcouple(id);
		return c;
	}
	@Override
	public void updatecouple(int id, String age, String height, String salary, String edu, String marry, String body,
			String place, String hchild, String wchild, String smoke, String drink, String photo) {
		dao.updatecouple(id,age,height,salary,edu,marry,body,place,hchild,wchild,smoke,drink,photo);
	}
	@Override
	public Hobby selecthobby(int id) {
		Hobby h = dao.selecthobby(id);
		return h;
	}
	@Override
	public void updatehobby(int id, String greens, String famous, String song, String book, String thing) {
		dao.updatehobby(id,greens,famous,song,book,thing);
	}
	@Override
	public void updateHead(String userid, String newName) {
		int uid = Integer.valueOf(userid);
		dao.updatehead(uid,newName);
	}
	@Override
	public ArrayList<Basic> selectAll(int pageno, int count) {
		ArrayList<Basic> ar = dao.selectAll(pageno,count);
		return ar;
	}
	@Override
	public ArrayList<Basic> findCondition(String sex, String edu, String height, String salary, int pageno, int count) throws SQLException {
		return dao.findCondition(sex,edu,height,salary,pageno,count);
	}
	@Override
	public ArrayList<Basic> findConditions(String sex, String edu, String height, String salary) throws SQLException{
		return dao.findConditions(sex,edu,height,salary);
	}
	@Override
	public Detail queryDetail(int userid) {
		return dao.queryDetail(userid);
	}
	@Override
	public int querycount() {
		
		return dao.querycount();
	}

}
