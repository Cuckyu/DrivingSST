package com.shine.dsst.service.impl;

import com.shine.dsst.bean.TestPaper;
import com.shine.dsst.bean.User;
import com.shine.dsst.dao.TestPaperDao;
import com.shine.dsst.dao.impl.TestPaperDaoImpl;
import com.shine.dsst.service.TestPaperService;

public class TestPaperServiceImpl implements TestPaperService{

	private TestPaperDao tpd = TestPaperDaoImpl.getInstance();
	
	@Override
	public TestPaper autoTestPaper(User user) {
		return tpd.autoTestPaper(user);
	}

	@Override
	public int autoScore(TestPaper tp) {
		return tpd.autoScore(tp);
	}

}
