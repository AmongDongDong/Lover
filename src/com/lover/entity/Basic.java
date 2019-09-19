package com.lover.entity;
/**
 * 用户基本资料表
 */
import java.util.Date;

public class Basic {
	private int userid;//用户id
	private int workid;//工作生活id
	private int coupleid;//择偶id
	private int hobbyid;//兴趣爱好id
	private int detailid;//详细资料id
	private String answer;//密保答案
	private String question;//密保问题
	private String password;//密码
	private String loving;//恋爱状态
	private String head;//头像
	private Date overdue;//过期时间
	private int grade; //VIP等级
	private String salary;//月收入
	private String address;//工作地区
	private String sheng;
	private String shi;
	private String xian;
	private String phone;//手机
	private int height;//身高
	private String education;//学历
	private String marry;//婚姻状态
	private Date birthday;//出生年月
	private String sex;//性别
	private String nickname;//昵称
	public Basic(int userid, int workid, int coupleid, int hobbyid, int detailid, String answer, String question,
			String password, String loving, String head, Date overdue, int grade, String salary, String address,
			String phone, int height, String education, String marry, Date birthday, String sex, String nickname) {
		super();
		this.userid = userid;
		this.workid = workid;
		this.coupleid = coupleid;
		this.hobbyid = hobbyid;
		this.detailid = detailid;
		this.answer = answer;
		this.question = question;
		this.password = password;
		this.loving = loving;
		this.head = head;
		this.overdue = overdue;
		this.grade = grade;
		this.salary = salary;
		this.address = address;
		this.phone = phone;
		this.height = height;
		this.education = education;
		this.marry = marry;
		this.birthday = birthday;
		this.sex = sex;
		this.nickname = nickname;
	}
	public Basic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Basic(int userid, String sex, Date birthday, String marry, String education, String nickname,
			String phone, String address, String salary, int height,String head) {
		this.userid = userid;
		this.salary = salary;
		this.address = address;
		this.phone = phone;
		this.height = height;
		this.education = education;
		this.marry = marry;
		this.birthday = birthday;
		this.sex = sex;
		this.nickname = nickname;
		this.head = head;
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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getWorkid() {
		return workid;
	}
	public void setWorkid(int workid) {
		this.workid = workid;
	}
	public int getCoupleid() {
		return coupleid;
	}
	public void setCoupleid(int coupleid) {
		this.coupleid = coupleid;
	}
	public int getHobbyid() {
		return hobbyid;
	}
	public void setHobbyid(int hobbyid) {
		this.hobbyid = hobbyid;
	}
	public int getDetailid() {
		return detailid;
	}
	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoving() {
		return loving;
	}
	public void setLoving(String loving) {
		this.loving = loving;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public Date getOverdue() {
		return overdue;
	}
	public void setOverdue(Date overdue) {
		this.overdue = overdue;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Basic [userid=" + userid + ", workid=" + workid + ", coupleid=" + coupleid + ", hobbyid=" + hobbyid
				+ ", detailid=" + detailid + ", answer=" + answer + ", question=" + question + ", password=" + password
				+ ", loving=" + loving + ", head=" + head + ", overdue=" + overdue + ", grade=" + grade + ", salary="
				+ salary + ", address=" + address + ", phone=" + phone + ", height=" + height + ", education="
				+ education + ", marry=" + marry + ", birthday=" + birthday + ", sex=" + sex + ", nickname=" + nickname
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + coupleid;
		result = prime * result + detailid;
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + grade;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		result = prime * result + height;
		result = prime * result + hobbyid;
		result = prime * result + ((loving == null) ? 0 : loving.hashCode());
		result = prime * result + ((marry == null) ? 0 : marry.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((overdue == null) ? 0 : overdue.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + userid;
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
		Basic other = (Basic) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (coupleid != other.coupleid)
			return false;
		if (detailid != other.detailid)
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (grade != other.grade)
			return false;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		if (height != other.height)
			return false;
		if (hobbyid != other.hobbyid)
			return false;
		if (loving == null) {
			if (other.loving != null)
				return false;
		} else if (!loving.equals(other.loving))
			return false;
		if (marry == null) {
			if (other.marry != null)
				return false;
		} else if (!marry.equals(other.marry))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (overdue == null) {
			if (other.overdue != null)
				return false;
		} else if (!overdue.equals(other.overdue))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (userid != other.userid)
			return false;
		if (workid != other.workid)
			return false;
		return true;
	}
	
	
}

