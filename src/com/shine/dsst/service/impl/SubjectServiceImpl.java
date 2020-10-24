package com.shine.dsst.service.impl;

import java.util.ArrayList;

import com.shine.dsst.bean.Subject;
import com.shine.dsst.dao.SubjectDao;
import com.shine.dsst.dao.impl.SubjectDaoImpl;
import com.shine.dsst.service.SubjectService;

public class SubjectServiceImpl implements SubjectService{

	private SubjectServiceImpl() {
		
	}
	private static SubjectServiceImpl subjectServiceImpl;
	public static SubjectServiceImpl getSubjectServiceImplInstance() {
		if(subjectServiceImpl==null) {
			subjectServiceImpl=new SubjectServiceImpl();
		}
		return subjectServiceImpl;
	}
	
	private SubjectDao subjectDao=SubjectDaoImpl.getInstance();
	
	
	@Override
	public boolean AddSubject(Subject subject) {
	
		return 	subjectDao.AddSubject(subject);
	}

	@Override
	public boolean removeSubject(int sid) {
		
		return subjectDao.deleteSubject(sid);
	}

	@Override
	public boolean editorSubject(Subject subject) {
		subjectDao.modifySubject(subject);
		return false;
	}

	@Override
	public Subject querySubjectBysid(int sid) {
		
		return subjectDao.selectSubjectBysid(sid);
	}

	@Override
	public ArrayList<Subject> queryAll() {
		
		return subjectDao.selectAll();
		
	}
	@Override
	public ArrayList<Subject> querySubject(String stitle) {
		return subjectDao.selectSubject(stitle);
	}
	
	@Override
	public boolean editeSubjectById(int sid, Subject subject) {
		return subjectDao.updateSubjectById(sid, subject);
	}
	
	public static void main(String[] args) {
		SubjectServiceImpl ssi=new SubjectServiceImpl();
//		SubjectType st=new SubjectType();
//		st.setStid(1);
//		Subject sub=new Subject(null,"ss","sa","sb","sc","sd","url","a",st);
//	    boolean flag=ssi.AddSubject(sub);
//	    System.out.println(flag);
	    
//	    boolean flag1=ssi.removeSubject(3);
//	    System.out.println(flag1);
	    
	    ArrayList<Subject> subs=ssi.queryAll();
	    for(Subject s:subs) {
	    	System.out.println(s);
	    }
	    
	}

}

