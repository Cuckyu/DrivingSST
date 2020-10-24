package com.shine.dsst.service;

import com.shine.dsst.bean.TestpaperSubject;

public interface TestPaperSubjectService {
	public boolean addAnswer(TestpaperSubject tps);
	public String getAnswer(TestpaperSubject tps);
	public void updateAnswer(TestpaperSubject ts);
}
