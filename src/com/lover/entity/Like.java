package com.lover.entity;
/**
 * 用户点赞信息
 * @author 胡倩玲
 *
 */
public class Like {
	private int likeid;//点赞id
	private int dynamicid;//动态id
	private int Userid;//点赞人id
	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Like(int likeid, int dynamicid, int userid) {
		super();
		this.likeid = likeid;
		this.dynamicid = dynamicid;
		Userid = userid;
	}
	public int getLikeid() {
		return likeid;
	}
	public void setLikeid(int likeid) {
		this.likeid = likeid;
	}
	public int getDynamicid() {
		return dynamicid;
	}
	public void setDynamicid(int dynamicid) {
		this.dynamicid = dynamicid;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	@Override
	public String toString() {
		return "Like [likeid=" + likeid + ", dynamicid=" + dynamicid + ", Userid=" + Userid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Userid;
		result = prime * result + dynamicid;
		result = prime * result + likeid;
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
		Like other = (Like) obj;
		if (Userid != other.Userid)
			return false;
		if (dynamicid != other.dynamicid)
			return false;
		if (likeid != other.likeid)
			return false;
		return true;
	}
	
}
