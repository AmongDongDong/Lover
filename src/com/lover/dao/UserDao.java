package com.lover.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lover.entity.Basic;
import com.lover.entity.Couple;
import com.lover.entity.Detail;
import com.lover.entity.Hobby;
import com.lover.entity.Worklife;

public interface UserDao {
	/**
	 * 进入个人中心，查找用户基本资料并显示
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Basic selectbasic(int id);
	/**
	 * 更新个人资料
	 * @param id
	 * @param heighta 
	 * @param salary 
	 * @param address 
	 * @param phone 
	 * @param nickname 
	 * @return
	 * @throws SQLException 
	 */
	public void updatebasic(int id, String nickname, String phone, String address, String salary, int heighta) throws SQLException;
	/**
	 * 查询个人详细资料
	 * @param id
	 * @return
	 */
	public Detail selectdetail(int id);
	/**
	 * 更新个人详细资料
	 * @param id
	 * @param address
	 * @param weight
	 * @param body
	 * @param star
	 * @param havechild
	 * @param wantchild
	 * @param marry
	 * @param hearttalk
	 */
	public void updatedetail(int id, String place, int weighta, String body, String star, String havechild,
			String wantchild, String marry, String hearttalk);
	/**
	 * 查询工作生活相关信息并显示
	 * @param id
	 * @return
	 */
	public Worklife selectworklife(int id);
	/**
	 * 更新工作生活
	 * @param id
	 * @param type
	 * @param house
	 * @param car
	 * @param smoke
	 * @param drink
	 */
	public void updateworklide(int id, String type, String house, String car, String smoke, String drink);
	/**
	 * 查询择偶条件资料并显示
	 * @param id
	 * @return
	 */
	public Couple selectcouple(int id);
	/**
	 * 更新择偶条件
	 * @param id
	 * @param age
	 * @param height
	 * @param salary
	 * @param edu
	 * @param marry
	 * @param body
	 * @param place
	 * @param hchild
	 * @param wchild
	 * @param smoke
	 * @param drink
	 * @param photo
	 */
	public void updatecouple(int id, String age, String height, String salary, String edu, String marry, String body,
			String place, String hchild, String wchild, String smoke, String drink, String photo);
	/**
	 * 查询兴趣爱好并显示
	 * @param id
	 * @return
	 */
	public Hobby selecthobby(int id);
	/**
	 * 更新兴趣爱好
	 * @param id
	 * @param greens
	 * @param famous
	 * @param song
	 * @param book
	 * @param thing
	 */
	public void updatehobby(int id, String greens, String famous, String song, String book, String thing);
	/**
	 * 修改头像
	 * @param uid
	 * @param newName
	 */
	public void updatehead(int uid, String newName);
	/**
	 * 查询界面查询所有用户的基本资料
	 * @param count 
	 * @param pageno 
	 * @return
	 */
	public ArrayList<Basic> selectAll(int pageno, int count);
	/**
	 * 条件查询，根据性别、学历、身高、月收入
	 * @param sex
	 * @param edu
	 * @param height
	 * @param salary
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Basic> findCondition(String sex, String edu, String height, String salary, int pageno, int count) throws SQLException;
	/**
	 * 条件查询用户，根据detailid查询出内心独白并显示
	 * @param detailid
	 * @return
	 */
	public Detail queryDetail(int userid);
	public int querycount();
	public ArrayList<Basic> findConditions(String sex, String edu, String height, String salary) throws SQLException;

}
