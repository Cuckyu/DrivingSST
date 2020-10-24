package com.shine.dsst.dao;

import java.util.ArrayList;
import java.util.List;

import com.shine.dsst.bean.Subject;

public interface SubjectDao {
	
	public int addSubject(Subject s);
	public int editSubject(Subject s);
	public int delSubject(int sid);
	public Subject selectSubjectById(int sid);
	public List<Subject> selectSubjectByStid(int stid);
    public boolean AddSubject(Subject subject);
    public boolean deleteSubject(int sid);
    public boolean modifySubject(Subject subject);
    public Subject selectSubjectBysid(int sid);
    public ArrayList<Subject> selectAll(); 
    public ArrayList<Subject> selectSubject(String stitle);
    public boolean updateSubjectById(int sid,Subject subject);
}   
