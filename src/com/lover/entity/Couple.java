package com.lover.entity;
/**
 * 用户择偶条件
 * @author 胡倩玲
 *
 */
public class Couple {
	private int coupleid;//择偶id
	private String age;//年龄
	private String height;//身高
	private String salary;//月收入
	private String education;//学历
	private String marry;//婚姻状态
	private String body;//体型
	private String address;//工作地区
	private String sheng;
	private String shi;
	private String xian;
	private String hbaby;//有无孩子
	private String wbaby;//是否想要孩子
	private String smoke;//是否吸烟
	private String drink;//是否喝酒
	private String photo;//有无照片
	public Couple() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Couple(int coupleid, String age, String height, String salary, String education, String marry, String body,
			String address, String hbaby, String wbaby, String smoke, String drink, String photo) {
		super();
		this.coupleid = coupleid;
		this.age = age;
		this.height = height;
		this.salary = salary;
		this.education = education;
		this.marry = marry;
		this.body = body;
		this.address = address;
		this.hbaby = hbaby;
		this.wbaby = wbaby;
		this.smoke = smoke;
		this.drink = drink;
		this.photo = photo;
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
	public String getXian() {
		return xian;
	}
	public void setXian(String xian) {
		this.xian = xian;
	}
	public int getCoupleid() {
		return coupleid;
	}
	public void setCoupleid(int coupleid) {
		this.coupleid = coupleid;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMarry() {
		return marry;
	}
	public void setMarry(String marry) {
		this.marry = marry;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getSmoke() {
		return smoke;
	}
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Couple [coupleid=" + coupleid + ", age=" + age + ", height=" + height + ", salary=" + salary
				+ ", education=" + education + ", marry=" + marry + ", body=" + body + ", address=" + address
				+ ", hbaby=" + hbaby + ", wbaby=" + wbaby + ", smoke=" + smoke + ", drink=" + drink + ", photo=" + photo
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + coupleid;
		result = prime * result + ((drink == null) ? 0 : drink.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((hbaby == null) ? 0 : hbaby.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((marry == null) ? 0 : marry.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((smoke == null) ? 0 : smoke.hashCode());
		result = prime * result + ((wbaby == null) ? 0 : wbaby.hashCode());
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
		Couple other = (Couple) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (coupleid != other.coupleid)
			return false;
		if (drink == null) {
			if (other.drink != null)
				return false;
		} else if (!drink.equals(other.drink))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (hbaby == null) {
			if (other.hbaby != null)
				return false;
		} else if (!hbaby.equals(other.hbaby))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (marry == null) {
			if (other.marry != null)
				return false;
		} else if (!marry.equals(other.marry))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (smoke == null) {
			if (other.smoke != null)
				return false;
		} else if (!smoke.equals(other.smoke))
			return false;
		if (wbaby == null) {
			if (other.wbaby != null)
				return false;
		} else if (!wbaby.equals(other.wbaby))
			return false;
		return true;
	}
	
	
}
