package com.shine.dsst.utils;

import java.util.List;

import com.shine.dsst.bean.Subject;

public class TestPaperSubjectUpOrDown {
	private List<Subject> subjects;
	public TestPaperSubjectUpOrDown() {
		
	}
	public TestPaperSubjectUpOrDown(List<Subject> subjects) {
		super();
		this.subjects = subjects;
	}
	
	public Subject getSubjectUp(int index){
		return subjects.get(index - 1);
	}
	public Subject getSubjectDown(int index){
		return subjects.get(index + 1);
	}
	

}
