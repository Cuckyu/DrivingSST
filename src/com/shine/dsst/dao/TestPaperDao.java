package com.shine.dsst.dao;

import com.shine.dsst.bean.TestPaper;
import com.shine.dsst.bean.User;

public interface TestPaperDao {
	
	public TestPaper autoTestPaper(User user);
	public int autoScore(TestPaper tp);
}
