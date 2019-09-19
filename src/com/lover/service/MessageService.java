package com.lover.service;

import java.util.ArrayList;
import java.util.List;

import com.lover.entity.Message;

/**
 * 留言(消息)service层
 * @author XM
 *
 */
public interface MessageService {
	/**
	 * 查询当前用户留言信息
	 * @return 当前用户留言信息
	 */
	public List<ArrayList<Message>> findMessageByID(int user_id);
	
	/**
	 * 处理用户对管理员相亲通知的回复
	 * @param Blind_id 相亲通知的想亲订单号
	 * @param reply 用户的回复(只有两种1."同意+当前用户ID"2."不同意+当前用户ID")
	 */
	public void replyRoot(int blind_id,String reply);
}
