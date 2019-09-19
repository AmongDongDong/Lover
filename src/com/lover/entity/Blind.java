package com.lover.entity;
/**
 * 相亲信息
 * @author XM
 *
 */
public class Blind {
	private int blind_id;//相亲ID
	private int man_id;//男方ID
	private int woman_id;//女方ID
	private int count;//留言条数
	private int seller_id;//商家ID
	private String blind;//相亲状态
	private int fail;//相亲失败量级
	public Blind() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blind(int blind_id, int man_id, int woman_id, int count, int seller_id, String blind, int fail) {
		super();
		this.blind_id = blind_id;
		this.man_id = man_id;
		this.woman_id = woman_id;
		this.count = count;
		this.seller_id = seller_id;
		this.blind = blind;
		this.fail = fail;
	}
	public int getBlind_id() {
		return blind_id;
	}
	public void setBlind_id(int blind_id) {
		this.blind_id = blind_id;
	}
	public int getMan_id() {
		return man_id;
	}
	public void setMan_id(int man_id) {
		this.man_id = man_id;
	}
	public int getWoman_id() {
		return woman_id;
	}
	public void setWoman_id(int woman_id) {
		this.woman_id = woman_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public String getBlind() {
		return blind;
	}
	public void setBlind(String blind) {
		this.blind = blind;
	}
	public int getFail() {
		return fail;
	}
	public void setFail(int fail) {
		this.fail = fail;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blind == null) ? 0 : blind.hashCode());
		result = prime * result + blind_id;
		result = prime * result + count;
		result = prime * result + fail;
		result = prime * result + man_id;
		result = prime * result + seller_id;
		result = prime * result + woman_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blind other = (Blind) obj;
		if (blind == null) {
			if (other.blind != null)
				return false;
		} else if (!blind.equals(other.blind))
			return false;
		if (blind_id != other.blind_id)
			return false;
		if (count != other.count)
			return false;
		if (fail != other.fail)
			return false;
		if (man_id != other.man_id)
			return false;
		if (seller_id != other.seller_id)
			return false;
		if (woman_id != other.woman_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Blind [blind_id=" + blind_id + ", man_id=" + man_id + ", woman_id=" + woman_id + ", count=" + count
				+ ", seller_id=" + seller_id + ", blind=" + blind + ", fail=" + fail + "]";
	}
	
}
