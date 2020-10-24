package com.shine.dsst.bean;

public class UserType {
	private Integer tid;
	private String tname;

	public UserType() {
		super();
	}

	public UserType(Integer tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "UserType [tid=" + tid + ", tname=" + tname + "]";
	}

}
