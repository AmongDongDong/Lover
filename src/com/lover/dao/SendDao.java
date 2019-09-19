package com.lover.dao;
/**
 * 发送消息所需要的dao
 * @author Administrator
 *
 */

import com.lover.entity.Blind;

public interface SendDao {
	public boolean existBlind(String manid , String womanid);//根据男女id判断是否存在该信息
	public Blind queryBlind(String manid , String womanid);//根据男女id查询该信息
	public void insertMessage(int sendid , int receiveid , String content );//插入一条留言数据
	public void addCount(String id);//根据id增加blind表中的count
	public void updateBlind(String id,String blind);//根据id增加blind表中的count
	public void insertBlind(int manid , int womanid);//向blind表中插入一条新数据
}
