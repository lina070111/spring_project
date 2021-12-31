package com.spring.project.vo;

public class UserVO {

	private int userseq; 
	private String id; 
	private String password; 
	private String name; 
	private String regdata; 
	private String phone;
	private String grade;
	
	private int point;
	
	public UserVO() {
	}

	public UserVO(int userseq, String id, String password, String name, String regdata, String phone, String grade,
			int point) {
		super();
		this.userseq = userseq;
		this.id = id;
		this.password = password;
		this.name = name;
		this.regdata = regdata;
		this.phone = phone;
		this.grade = grade;
		this.point = point;
	}

	public int getUserseq() {
		return userseq;
	}
	public void setUserseq(int userseq) {
		this.userseq = userseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdata() {
		return regdata;
	}
	public void setRegdata(String regdata) {
		this.regdata = regdata;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "UserVO [userseq=" + userseq + ", id=" + id + ", password=" + password + ", name=" + name + ", regdata="
				+ regdata + ", phone=" + phone + ", grade=" + grade + ", point=" + point + "]";
	}

	
}
