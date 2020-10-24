package com.shine.dsst.dao;

import com.shine.dsst.bean.TestpaperSubject;

public interface TestPaperSubjectDao {
	
	public boolean addAnswer(TestpaperSubject tps);
	
	public String getAnswer(TestpaperSubject tps);

	public void updateAnswer(TestpaperSubject ts);

}
