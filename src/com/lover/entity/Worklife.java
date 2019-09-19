package com.lover.entity;
/**
 * 用户工作生活
 * @author 胡倩玲
 *
 */
public class Worklife {
	private int workid;//工作生活id
	private String type;//职业类别
	private String house;//买房情况
	private String car;//买车情况
	private String smoke;//是否吸烟
	private String drink;//是否喝酒
	public Worklife() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Worklife(int workid, String type, String house, String car, String smoke, String drink) {
		super();
		this.workid = workid;
		this.type = type;
		this.house = house;
		this.car = car;
		this.smoke = smoke;
		this.drink = drink;
	}
	public int getWorkid() {
		return workid;
	}
	public void setWorkid(int workid) {
		this.workid = workid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
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
	@Override
	public String toString() {
		return "Worklife [workid=" + workid + ", type=" + type + ", house=" + house + ", car=" + car + ", smoke="
				+ smoke + ", drink=" + drink + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((drink == null) ? 0 : drink.hashCode());
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + ((smoke == null) ? 0 : smoke.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + workid;
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
		Worklife other = (Worklife) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (drink == null) {
			if (other.drink != null)
				return false;
		} else if (!drink.equals(other.drink))
			return false;
		if (house == null) {
			if (other.house != null)
				return false;
		} else if (!house.equals(other.house))
			return false;
		if (smoke == null) {
			if (other.smoke != null)
				return false;
		} else if (!smoke.equals(other.smoke))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (workid != other.workid)
			return false;
		return true;
	}
	
	
}
