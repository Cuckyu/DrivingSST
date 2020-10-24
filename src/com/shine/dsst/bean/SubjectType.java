package com.shine.dsst.bean;

public class SubjectType {
	private Integer stid;
	private String stname;

	public SubjectType() {
		super();
	}

	public SubjectType(Integer stid, String stname) {
		super();
		this.stid = stid;
		this.stname = stname;
	}

	public Integer getStid() {
		return stid;
	}

	public void setStid(Integer stid) {
		this.stid = stid;
	}

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	@Override
	public String toString() {
		return "SubjectType [stid=" + stid + ", stname=" + stname + "]";
	}

}
