package com.shine.dsst.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.shine.dsst.bean.Subject;
import com.shine.dsst.bean.TestPaper;
import com.shine.dsst.bean.User;
import com.shine.dsst.dao.SubjectDao;
import com.shine.dsst.dao.TestPaperDao;
import com.shine.dsst.utils.DBUtil;
import com.shine.dsst.utils.RandomSN;

public class TestPaperDaoImpl implements TestPaperDao{
	
	private SubjectDao sd = SubjectDaoImpl.getInstance();
	private static TestPaperDaoImpl tpd = null;
	private TestPaperDaoImpl() {
		
	}
	public static TestPaperDaoImpl getInstance() {
		if(tpd==null) {
			return tpd = new TestPaperDaoImpl();
		}
		return tpd;
	}
	
	
	
	@Override
	public TestPaper autoTestPaper(User user) {
		List<Subject> allChoices = sd.selectSubjectByStid(1);
		List<Subject> allJudges = sd.selectSubjectByStid(2);
		TestPaper tp = new TestPaper();
		tp.setChoices_num(50);
		tp.setJudges_num(50);
		
		Set<Subject> set_choices = new HashSet<>();
		Set<Subject> set_judges = new HashSet<>();
		
		while(set_choices.size()<tp.getChoices_num()) {
			int index = (int) (Math.random()*allChoices.size());
			set_choices.add(allChoices.get(index));
		}
		
		Collection<Subject> collection_choices = set_choices;
		List<Subject> choices = new ArrayList<>(collection_choices);
		
		while(set_judges.size()<tp.getJudges_num()) {
			int index = (int) (Math.random()*allJudges.size());
			set_judges.add(allJudges.get(index));
		}
		
		Collection<Subject> collection_judges = set_judges;
		List<Subject> judges = new ArrayList<>(collection_judges);
		
		tp.setChoices(choices);
		tp.setJudges(judges);
		tp.setTpsn(RandomSN.getRandomSn());
		tp.setUser(user);
		addTestPaper(tp);
		return tp;
	}
	public void addTestPaper(TestPaper tp) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into testpaper (tpsn,uid) values(?,?)";
		con = DBUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tp.getTpsn());
			ps.setInt(2, tp.getUser().getUid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, ps, null);
		}
		
	}
	@Override
	public int autoScore(TestPaper tp) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql_query = "select count(1) as grade from testpaper_subject ts,subject s where ts.sid = s.sid and ts.answer = s.answer and ts.tpsn = ?";
		String sql_update = "update user set grade = ? where uid = ?";
		con = DBUtil.getConnection();
		int grade = 0;
		try {
			ps = con.prepareStatement(sql_query);
			ps.setString(1, tp.getTpsn());
			rs = ps.executeQuery();
			if(rs.next()) {
				grade = rs.getInt("grade");
			}
			ps = con.prepareStatement(sql_update);
			ps.setInt(1, grade);
			ps.setInt(2, tp.getUser().getUid());
			int executeUpdate = ps.executeUpdate();
			if(executeUpdate > 0) {
				return grade;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return grade;
	}

}
