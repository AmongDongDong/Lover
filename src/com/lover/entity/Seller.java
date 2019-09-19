package com.lover.entity;
/**
 * 商家信息
 * @author 胡倩玲
 *
 */
public class Seller {
	private int sid;//商家id
	private String sname;//商家名称
	private String summary;//商家简介
	private String saddress;//商家地址
	private String spicture;//商家图片
	private String sdate;//服务时间
	private String sphone;//注册电话
	private String spassword;//商家密码
	private String squestion;//密保问题
	private String sanswer;//密保答案
	private String status;//审核状态
	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seller(int sid, String sname, String summary, String saddress, String spicture, String sdate, String sphone,
			String spassword, String squestion, String sanswer, String status) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.summary = summary;
		this.saddress = saddress;
		this.spicture = spicture;
		this.sdate = sdate;
		this.sphone = sphone;
		this.spassword = spassword;
		this.squestion = squestion;
		this.sanswer = sanswer;
		this.status = status;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getSpicture() {
		return spicture;
	}
	public void setSpicture(String spicture) {
		this.spicture = spicture;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getSquestion() {
		return squestion;
	}
	public void setSquestion(String squestion) {
		this.squestion = squestion;
	}
	public String getSanswer() {
		return sanswer;
	}
	public void setSanswer(String sanswer) {
		this.sanswer = sanswer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Seller [sid=" + sid + ", sname=" + sname + ", summary=" + summary + ", saddress=" + saddress
				+ ", spicture=" + spicture + ", sdate=" + sdate + ", sphone=" + sphone + ", spassword=" + spassword
				+ ", squestion=" + squestion + ", sanswer=" + sanswer + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((saddress == null) ? 0 : saddress.hashCode());
		result = prime * result + ((sanswer == null) ? 0 : sanswer.hashCode());
		result = prime * result + ((sdate == null) ? 0 : sdate.hashCode());
		result = prime * result + sid;
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + ((spassword == null) ? 0 : spassword.hashCode());
		result = prime * result + ((sphone == null) ? 0 : sphone.hashCode());
		result = prime * result + ((spicture == null) ? 0 : spicture.hashCode());
		result = prime * result + ((squestion == null) ? 0 : squestion.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
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
		Seller other = (Seller) obj;
		if (saddress == null) {
			if (other.saddress != null)
				return false;
		} else if (!saddress.equals(other.saddress))
			return false;
		if (sanswer == null) {
			if (other.sanswer != null)
				return false;
		} else if (!sanswer.equals(other.sanswer))
			return false;
		if (sdate == null) {
			if (other.sdate != null)
				return false;
		} else if (!sdate.equals(other.sdate))
			return false;
		if (sid != other.sid)
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (spassword == null) {
			if (other.spassword != null)
				return false;
		} else if (!spassword.equals(other.spassword))
			return false;
		if (sphone == null) {
			if (other.sphone != null)
				return false;
		} else if (!sphone.equals(other.sphone))
			return false;
		if (spicture == null) {
			if (other.spicture != null)
				return false;
		} else if (!spicture.equals(other.spicture))
			return false;
		if (squestion == null) {
			if (other.squestion != null)
				return false;
		} else if (!squestion.equals(other.squestion))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		return true;
	}
	
	
}
