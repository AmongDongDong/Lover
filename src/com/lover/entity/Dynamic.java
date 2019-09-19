package com.lover.entity;

import java.util.Date;

/**
 * 用户动态
 * @author 胡倩玲
 *
 */
public class Dynamic {
	private int dynamicid;//动态id
	private int userid;//用户id
	private String content;//动态内容
	private Date date;//视频
	private int laud;//点赞数量
	private String picture;//图片
	public int getDynamicid() {
		return dynamicid;
	}
	public void setDynamicid(int dynamicid) {
		this.dynamicid = dynamicid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getLaud() {
		return laud;
	}
	public void setLaud(int laud) {
		this.laud = laud;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + dynamicid;
		result = prime * result + laud;
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + userid;
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
		Dynamic other = (Dynamic) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dynamicid != other.dynamicid)
			return false;
		if (laud != other.laud)
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dynamic [dynamicid=" + dynamicid + ", userid=" + userid + ", content=" + content + ", date=" + date
				+ ", laud=" + laud + ", picture=" + picture + "]";
	}
	public Dynamic(int dynamicid, int userid, String content, Date date, int laud, String picture) {
		super();
		this.dynamicid = dynamicid;
		this.userid = userid;
		this.content = content;
		this.date = date;
		this.laud = laud;
		this.picture = picture;
	}
	public Dynamic() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
