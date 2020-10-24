package com.shine.dsst.bean;

public class TestpaperSubject {
	private Integer Id;
	private String tpsn;
	private Subject subject;
	private String answer;
	public TestpaperSubject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestpaperSubject(Integer id, String tpsn, Subject subject) {
		super();
		Id = id;
		this.tpsn = tpsn;
		this.subject = subject;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTpsn() {
		return tpsn;
	}

	public void setTpsn(String tpsn) {
		this.tpsn = tpsn;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "TestpaperSubject [Id=" + Id + ", tpsn=" + tpsn + ", subject=" + subject + ", answer=" + answer + "]";
	}

	

}
