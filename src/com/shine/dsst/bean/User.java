package com.shine.dsst.bean;

public class User {
	private Integer uid;
	private String username;
	private String password;
	private String name;
	private String sex;
	private String phone;
	private String idcard;
	private Integer tid;
	private String grade;
	private UserType userType;

	public User() {
		super();
	}

	public User(Integer uid, String username, String password, String name, String sex, String phone, String idcard,
			  UserType userType) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.idcard = idcard;
		
		this.grade = grade;
		this.userType = userType;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", sex=" + sex
				+ ", phone=" + phone + ", idcard=" + idcard + ", tid=" + tid + ", grade=" + grade + ", userType=" + userType
				+ "]";
	}

}
