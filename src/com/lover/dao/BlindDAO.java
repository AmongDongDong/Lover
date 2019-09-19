package com.lover.dao;

import java.util.ArrayList;

import com.lover.entity.Blind;

/**
 * 相亲信息DAO层
 * @author XM
 *
 */
public interface BlindDAO {
	/**
	 * 查询所有相亲信息
	 * @return 所有的相亲信息
	 */
	ArrayList<Blind> findAllBlind();
	
	/**
	 * 根据相亲订单ID修改相亲订单状态
	 * @param blind_id 相亲订单ID
	 * @param blind 订单状态
	 */
	void upDateBlind(int blind_id, String blind);
	
	/**
	 * 根据相亲订单ID查询相亲订单信息
	 * @param blind_id 相亲订单ID
	 * @return 相亲订单信息
	 */
	Blind findBlindByID(int blind_id);
	
	/**
	 * 根据相亲订单ID修改相亲失败量级
	 * @param blind_id blind_id 相亲订单ID
	 * @param fail 相亲失败量级
	 */
	void upDateBlindFail(int blind_id, int fail);

}
