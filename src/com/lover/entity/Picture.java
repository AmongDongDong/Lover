package com.lover.entity;
/**
 * 图片信息
 * @author 胡倩玲
 *
 */
public class Picture {
	private int pid;//图片id
	private String picture;//图片
	private int dynamicid;//动态id
	public Picture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Picture(int pid, String picture, int dynamicid) {
		super();
		this.pid = pid;
		this.picture = picture;
		this.dynamicid = dynamicid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getDynamicid() {
		return dynamicid;
	}
	public void setDynamicid(int dynamicid) {
		this.dynamicid = dynamicid;
	}
	@Override
	public String toString() {
		return "Picture [pid=" + pid + ", picture=" + picture + ", dynamicid=" + dynamicid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dynamicid;
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + pid;
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
		Picture other = (Picture) obj;
		if (dynamicid != other.dynamicid)
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (pid != other.pid)
			return false;
		return true;
	}
	
}
