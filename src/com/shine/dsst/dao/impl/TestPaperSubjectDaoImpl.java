package com.shine.dsst.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shine.dsst.bean.TestpaperSubject;
import com.shine.dsst.dao.TestPaperSubjectDao;
import com.shine.dsst.utils.DBUtil;

public class TestPaperSubjectDaoImpl implements TestPaperSubjectDao {
	
	private static TestPaperSubjectDaoImpl tpd = null;
	private TestPaperSubjectDaoImpl() {
		
	}
	public static TestPaperSubjectDaoImpl getInstance() {
		if(tpd==null) {
			return tpd = new TestPaperSubjectDaoImpl();
		}
		return tpd;
	}
	
	@Override
	public boolean addAnswer(TestpaperSubject tps) {
		Connection con = null;
		PreparedStatement ps = null;
		con = DBUtil.getConnection();
		String sql = "insert into testpaper_subject(tpsn,sid,answer) values(?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tps.getTpsn());
			ps.setInt(2, tps.getSubject().getSid());
			ps.setString(3, tps.getAnswer());
			int executeUpdate = ps.executeUpdate();
			if(executeUpdate > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, ps, null);
		}
		return false;
	}
	@Override
	public String getAnswer(TestpaperSubject tps) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		String sql = "select answer from testpaper_subject where tpsn = ? and sid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tps.getTpsn());
			ps.setInt(2, tps.getSubject().getSid());
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString("answer");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, ps, null);
		}
		return null;
	}
	@Override
	public void updateAnswer(TestpaperSubject ts) {
		Connection con = null;
		PreparedStatement ps = null;
		con = DBUtil.getConnection();
		String sql = "update testpaper_subject set answer = ? where tpsn = ? and sid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ts.getAnswer());
			ps.setNString(2, ts.getTpsn());
			ps.setInt(3, ts.getSubject().getSid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, ps, null);
		}
	}
	
}
