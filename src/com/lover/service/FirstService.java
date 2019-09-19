package com.lover.service;

import java.util.ArrayList;

import com.lover.entity.Attention;
import com.lover.entity.Basic;
import com.lover.entity.Browse;
import com.lover.entity.Dynamic;

/**
 * 首页模块用到的功能
 * @author Administrator
 *
 */
public interface FirstService {
	public boolean queryVip(String id);//根据id查找是否为VIP
	public Basic queryUser(String id);//根据id查找相应basic
	public ArrayList<Basic> queryAllUser();//查找所有的用户
	public ArrayList<Dynamic> queryAllDynamic(String id);//查找除id外所有用户的动态
	public ArrayList<Dynamic> queryOneDynamic(String id);//查找指定id的动态
	public ArrayList<Basic> queryOtherUser(String id);//查找除自己外所有的用户
	public ArrayList<Browse> queryWhoSeeMe(String id);//查找谁看了我
	public ArrayList<Attention> queryMyAttention(String id);//查看我的关注
	public int releaseTrends(String speak , String photo , String userId);//发布动态
	public boolean isFocus(String deId , String selfID);//查看自己是否关注了他
	public void insertFocus(String deId,String selfId);//插入一条关注数据;
	public void deleteFocus(String deId,String selfId);//删除一条关注数据;
	public void insertBrowse(String selfId ,String deId);//将自己的id与查看的人的id插入表中

}
