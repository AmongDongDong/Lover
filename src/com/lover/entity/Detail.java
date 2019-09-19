package com.lover.entity;
/**
 * 用户详细资料
 * @author 胡倩玲
 *
 */
public class Detail {
	private int detailid;//详细资料id
	private String place;//籍贯
	private String sheng;//省
	private String shi;//市
	private int weight;//体重
	private String body;//体型
	private String star;//星座
	private String hbaby;//有无孩子
	private String wbaby;//是否想要孩子
	private String wmarry;//何时结婚
	private String hearttalk;//内心独白
	public Detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Detail(int detailid, String place, int weight, String body, String star, String hbaby, String wbaby,
			String wmarry, String hearttalk) {
		super();
		this.detailid = detailid;
		this.place = place;
		this.weight = weight;
		this.body = body;
		this.star = star;
		this.hbaby = hbaby;
		this.wbaby = wbaby;
		this.wmarry = wmarry;
		this.hearttalk = hearttalk;
	}
	
	public Detail(String hearttalk,String body,String star) {
		super();
		this.hearttalk = hearttalk;
		this.body = body;
		this.star = star;
	}
	public String getSheng() {
		return sheng;
	}
	public void setSheng(String sheng) {
		this.sheng = sheng;
	}
	public String getShi() {
		return shi;
	}
	public void setShi(String shi) {
		this.shi = shi;
	}
	public int getDetailid() {
		return detailid;
	}
	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getHbaby() {
		return hbaby;
	}
	public void setHbaby(String hbaby) {
		this.hbaby = hbaby;
	}
	public String getWbaby() {
		return wbaby;
	}
	public void setWbaby(String wbaby) {
		this.wbaby = wbaby;
	}
	public String getWmarry() {
		return wmarry;
	}
	public void setWmarry(String wmarry) {
		this.wmarry = wmarry;
	}
	public String getHearttalk() {
		return hearttalk;
	}
	public void setHearttalk(String hearttalk) {
		this.hearttalk = hearttalk;
	}
	@Override
	public String toString() {
		return "Detail [detailid=" + detailid + ", place=" + place + ", weight=" + weight + ", body=" + body + ", star="
				+ star + ", hbaby=" + hbaby + ", wbaby=" + wbaby + ", wmarry=" + wmarry + ", hearttalk=" + hearttalk
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + detailid;
		result = prime * result + ((hbaby == null) ? 0 : hbaby.hashCode());
		result = prime * result + ((hearttalk == null) ? 0 : hearttalk.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((star == null) ? 0 : star.hashCode());
		result = prime * result + ((wbaby == null) ? 0 : wbaby.hashCode());
		result = prime * result + weight;
		result = prime * result + ((wmarry == null) ? 0 : wmarry.hashCode());
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
		Detail other = (Detail) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (detailid != other.detailid)
			return false;
		if (hbaby == null) {
			if (other.hbaby != null)
				return false;
		} else if (!hbaby.equals(other.hbaby))
			return false;
		if (hearttalk == null) {
			if (other.hearttalk != null)
				return false;
		} else if (!hearttalk.equals(other.hearttalk))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (star == null) {
			if (other.star != null)
				return false;
		} else if (!star.equals(other.star))
			return false;
		if (wbaby == null) {
			if (other.wbaby != null)
				return false;
		} else if (!wbaby.equals(other.wbaby))
			return false;
		if (weight != other.weight)
			return false;
		if (wmarry == null) {
			if (other.wmarry != null)
				return false;
		} else if (!wmarry.equals(other.wmarry))
			return false;
		return true;
	}
	
	
}
