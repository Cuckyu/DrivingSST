package com.shine.dsst.service.impl;

import com.shine.dsst.bean.TestpaperSubject;
import com.shine.dsst.dao.TestPaperSubjectDao;
import com.shine.dsst.dao.impl.TestPaperSubjectDaoImpl;
import com.shine.dsst.service.TestPaperSubjectService;

public class TestPaperSubjectServiceImpl implements TestPaperSubjectService	{
	
	private TestPaperSubjectDao ptsd = TestPaperSubjectDaoImpl.getInstance();

	@Override
	public boolean addAnswer(TestpaperSubject tps) {
		return ptsd.addAnswer(tps);
	}

	@Override
	public String getAnswer(TestpaperSubject tps) {
		return ptsd.getAnswer(tps);
	}

	@Override
	public void updateAnswer(TestpaperSubject ts) {
		ptsd.updateAnswer(ts);
	}

	

}
