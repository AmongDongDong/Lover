package com.lover.entity;
/**
 * 浏览历史
 */
import java.util.Date;

public class Browse {
	private int bid;//浏览id
	private int browseid;//浏览人id
	private int browsedid;//被浏览人id
	private Date browsedate;//浏览时间
	public Browse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Browse(int bid, int browseid, int browsedid, Date browsedate) {
		super();
		this.bid = bid;
		this.browseid = browseid;
		this.browsedid = browsedid;
		this.browsedate = browsedate;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getBrowseid() {
		return browseid;
	}
	public void setBrowseid(int browseid) {
		this.browseid = browseid;
	}
	public int getBrowsedid() {
		return browsedid;
	}
	public void setBrowsedid(int browsedid) {
		this.browsedid = browsedid;
	}
	public Date getBrowsedate() {
		return browsedate;
	}
	public void setBrowsedate(Date browsedate) {
		this.browsedate = browsedate;
	}
	@Override
	public String toString() {
		return "Browse [bid=" + bid + ", browseid=" + browseid + ", browsedid=" + browsedid + ", browsedate="
				+ browsedate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bid;
		result = prime * result + ((browsedate == null) ? 0 : browsedate.hashCode());
		result = prime * result + browsedid;
		result = prime * result + browseid;
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
		Browse other = (Browse) obj;
		if (bid != other.bid)
			return false;
		if (browsedate == null) {
			if (other.browsedate != null)
				return false;
		} else if (!browsedate.equals(other.browsedate))
			return false;
		if (browsedid != other.browsedid)
			return false;
		if (browseid != other.browseid)
			return false;
		return true;
	}
	
}
