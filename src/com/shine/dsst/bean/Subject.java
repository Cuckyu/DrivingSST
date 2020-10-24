package com.shine.dsst.bean;

public class Subject {
	   private Integer sid;
	   private String stitle;
	   private String optiona;
	   private String optionb;
	   private String optionc;
	   private String optiond;
	   private  String pic;
	   private String answer;
	   private Integer stid;
	   private SubjectType subjectType;

	public Subject() {
		super();
	}

	public Subject(Integer sid, String stitle, String optiona, String optionb, String optionc, String optiond,
			String pic, String answer, SubjectType subjectType) {
		super();
		this.sid = sid;
		this.stitle = stitle;
		this.optiona = optiona;
		this.optionb = optionb;
		this.optionc = optionc;
		this.optiond = optiond;
		this.pic = pic;
		this.answer = answer;
		this.subjectType = subjectType;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getStitle() {
		return stitle;
	}

	public void setStitle(String stitle) {
		this.stitle = stitle;
	}

	public String getOptiona() {
		return optiona;
	}

	public void setOptiona(String optiona) {
		this.optiona = optiona;
	}

	public String getOptionb() {
		return optionb;
	}

	public void setOptionb(String optionb) {
		this.optionb = optionb;
	}

	public String getOptionc() {
		return optionc;
	}

	public void setOptionc(String optionc) {
		this.optionc = optionc;
	}

	public String getOptiond() {
		return optiond;
	}

	public void setOptiond(String optiond) {
		this.optiond = optiond;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public SubjectType getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}

	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	
	@Override
	public String toString() {
		return "Subject [sid=" + sid + ", stitle=" + stitle + ", optiona=" + optiona + ", optionb=" + optionb
				+ ", optionc=" + optionc + ", optiond=" + optiond + ", pic=" + pic + ", answer=" + answer+ ", stid=" + stid
				+ ", subjectType=" + subjectType + "]";
	}

}
