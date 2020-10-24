package com.shine.dsst.bean;

import java.util.ArrayList;
import java.util.List;

public class TestPaper {
	private Integer id;
	private String tpsn;
	private User user;
	private List<Subject> choices = new ArrayList<>();
	private List<Subject> judges = new ArrayList<>();
	private Integer choices_num;
	private Integer judges_num;
	

	public TestPaper() {
		super();
	}

	public TestPaper(Integer id, String tpsn, User user) {
		super();
		this.id = id;
		this.tpsn = tpsn;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getJudges_num() {
		return judges_num;
	}
	public String getTpsn() {
		return tpsn;
	}

	public void setTpsn(String tpsn) {
		this.tpsn = tpsn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Subject> getChoices() {
		return choices;
	}

	public void setChoices(List<Subject> choices) {
		this.choices = choices;
	}

	public List<Subject> getJudges() {
		return judges;
	}

	public void setJudges(List<Subject> judges) {
		this.judges = judges;
	}

	public Integer getChoices_num() {
		return choices_num;
	}

	public void setChoices_num(Integer choices_num) {
		this.choices_num = choices_num;
	}

	public Integer array() {
		return judges_num;
	}

	public void setJudges_num(Integer judges_num) {
		this.judges_num = judges_num;
	}

	@Override
	public String toString() {
		return "TestPaper [id=" + id + ", tpsn=" + tpsn + ", user=" + user + "]";
	}

}