package com.shine.dsst.service;

import com.shine.dsst.bean.TestPaper;
import com.shine.dsst.bean.User;

public interface TestPaperService {
	public TestPaper autoTestPaper(User user);
	public int autoScore(TestPaper tp);
}
