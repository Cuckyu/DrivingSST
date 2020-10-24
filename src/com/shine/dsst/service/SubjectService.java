package com.shine.dsst.service;

import java.util.ArrayList;

import com.shine.dsst.bean.Subject;

public interface SubjectService {
	   public boolean AddSubject(Subject subject);
	   public boolean removeSubject(int sid);
	   public boolean editorSubject(Subject subject);
	   public Subject querySubjectBysid(int sid);
	   public ArrayList<Subject> queryAll(); 
	   public ArrayList<Subject> querySubject(String stitle);
	   public boolean editeSubjectById(int sid,Subject subject);
}
