package com.lover.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.User;

import com.lover.entity.Basic;
import com.lover.entity.Couple;
import com.lover.entity.Detail;
import com.lover.entity.Hobby;
import com.lover.entity.Worklife;

public interface UserService {
	/**
	 * 更新基本资料
	 * @param id
	 * @param height 
	 * @param salary 
	 * @param address 
	 * @param phone 
	 * @param nickname 
	 * @return
	 * @throws Exception
	 */
	public void updatebasic(int id, String nickname, String phone, String address, String salary, String height) throws Exception;
	/**
	 * 查询并显示基本资料
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Basic selectbasic(int id);
	/**
	 * 查询并显示详细资料
	 * @param id
	 * @return
	 */
	public Detail selectdetail(int id);
	/**
	 * 更新详细资料
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
	public void updatedetail(int id, String place, String weight, String body, String star, String havechild,
			String wantchild, String marry, String hearttalk);
	/**
	 * 查询工作生活并显示
	 * @param id
	 * @return
	 */
	public Worklife selectworklife(int id);
	/**
	 * 更新工作生活资料，将数据传入数据库
	 * @param id
	 * @param type
	 * @param house
	 * @param car
	 * @param smoke
	 * @param drink
	 */
	public void updateworklife(int id, String type, String house, String car, String smoke, String drink);
	/**
	 * 查询择偶条件的资料
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
	 * 查询用户兴趣爱好
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
	 * 用户上传头像
	 * @param userid
	 * @param newName
	 */
	public void updateHead(String userid, String newName);
	/**
	 * 查询所有用户信息
	 * @param count 
	 * @param pageno 
	 * @return
	 */
	public ArrayList<Basic> selectAll(int pageno, int count);
	/**
	 * 条件查询，根据性别，学历，身高，收入
	 * @param sex
	 * @param edu
	 * @param height
	 * @param salary
	 * @param count 
	 * @param pageno 
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
	/**
	 * 
	 * @param sex
	 * @param edu
	 * @param height
	 * @param salary
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Basic> findConditions(String sex, String edu, String height, String salary) throws SQLException;
}
