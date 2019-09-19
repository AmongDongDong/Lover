package com.lover.dao;

import java.util.ArrayList;

import com.lover.entity.Message;

/**
 * 留言(消息)DAO层
 * @author XM
 *
 */
public interface MessageDAO {
	/**
	 * 根据用户ID查询所有收到的留言信息(按时间升序)
	 * @param user_id 用户ID
	 * @return 所有收到的留言信息
	 */
	ArrayList<Message> findMessaged(int user_id);
	/**
	 * 根据用户ID查询所有发出的留言信息(按时间升序)
	 * @param user_id 用户ID
	 * @return 所有发出的留言信息
	 */
	ArrayList<Message> findMessage(int user_id);
	
	/**
	 * 根据两个用户id,查询他们之间的全部留言信息
	 * @param user_id 
	 * @param id
	 * @return 两个用户之间的全部留言信息
	 */
	ArrayList<Message> findAllMsgByID(int user_id, int id);

}
