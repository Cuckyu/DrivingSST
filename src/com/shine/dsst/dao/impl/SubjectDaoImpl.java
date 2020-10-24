package com.shine.dsst.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shine.dsst.bean.Subject;
import com.shine.dsst.bean.SubjectType;
import com.shine.dsst.dao.SubjectDao;
import com.shine.dsst.utils.DBUtil;

public class SubjectDaoImpl implements SubjectDao{
	private static SubjectDaoImpl subjectDaoImpl = null;
	private SubjectDaoImpl() {
		
	}
	public static SubjectDaoImpl getInstance() {
		if(subjectDaoImpl==null) {
			return subjectDaoImpl = new SubjectDaoImpl();
		}
		return subjectDaoImpl;
	}
	@Override
	public int addSubject(Subject s) {
		Connection con = null;
		PreparedStatement ps = null;
		con = DBUtil.getConnection();
		String sql = "insert into subject(stitle,optiona,optionb,optionc,optiond,pic,answer,stid) values(?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, s.getStitle());
			ps.setString(2,s.getOptiona());
			ps.setString(3, s.getOptionb());
			ps.setString(4, s.getOptionc());
			ps.setString(5, s.getOptiond());
			ps.setString(6, s.getPic());
			ps.setString(7,s.getAnswer());
			ps.setInt(8, s.getSubjectType().getStid());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, ps, null);
		}
		return -1;
	
	}

	@Override
	public int editSubject(Subject s) {
		Connection con = null;
		PreparedStatement ps = null;
		con = DBUtil.getConnection();
		String sql = "update subject set stitle=?,optiona=?,optionb=?,optionc=?,optiond=?,pic=?,answer=?,stid=? where sid=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, s.getStitle());
			ps.setString(2,s.getOptiona());
			ps.setString(3, s.getOptionb());
			ps.setString(4, s.getOptionc());
			ps.setString(5, s.getOptiond());
			ps.setString(6, s.getPic());
			ps.setString(7,s.getAnswer());
			ps.setInt(8, s.getSubjectType().getStid());
			ps.setInt(9, s.getSid());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, ps,null);
		}
		return -1;
		
	}

	@Override
	public int delSubject(int sid) {
		Connection con = null;
		PreparedStatement ps = null;
		con = DBUtil.getConnection();
		String sql = "delete from subject where sid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, sid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, ps, null);
		}
		return -1;
	}

	@Override
	public Subject selectSubjectById(int sid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		Subject s = null;
		String sql = "select sid,stitle,optiona,optionb,optionc,optiond,pic,answer,stid from subject where sid = ?";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				s = new Subject();
				s.setSid(sid);
				s.setStitle(rs.getString("stitle"));
				s.setOptiona(rs.getString("optiona"));
				s.setOptionb(rs.getString("optionb"));
				s.setOptionc(rs.getString("optionc"));
				s.setOptiond(rs.getString("optiond"));
				s.setPic(rs.getString("pic"));
				s.setAnswer(rs.getString("answer"));
				SubjectType st = new SubjectType();
				st.setStid(rs.getInt("stid"));
				s.setSubjectType(st);
				return s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, ps, rs);
		}
		
		return s;
	}

	@Override
	public List<Subject> selectSubjectByStid(int stid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		
		List<Subject> Subject_list = null;
		String sql = "select sid,stitle,optiona,optionb,optionc,optiond,pic,answer,stid from subject where stid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, stid);
			rs = ps.executeQuery();
			Subject_list = new ArrayList<>();
			while(rs.next()) {
				Subject s = new Subject();
				s.setSid(rs.getInt("sid"));
				s.setStitle(rs.getString("stitle"));
				s.setOptiona(rs.getString("optiona"));
				s.setOptionb(rs.getString("optionb"));
				s.setOptionc(rs.getString("optionc"));
				s.setOptiond(rs.getString("optiond"));
				s.setPic(rs.getString("pic"));
				s.setAnswer(rs.getString("answer"));
				SubjectType st = new SubjectType();
				st.setStid(rs.getInt("stid"));
				s.setSubjectType(st);
				Subject_list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, ps, rs);
		}
		
		return Subject_list;
	}
	private final static String ADDUSER="insert into subject(stitle,optiona,optionb,optionc,optiond,pic,answer,stid) values(?,?,?,?,?,?,?,?)";
    @Override
	public boolean AddSubject(Subject subject) {
		Connection con=null;
		  PreparedStatement state=null;
		  con=DBUtil.getConnection();
		  boolean flag=false;
		  try {
			  state=con.prepareStatement(ADDUSER);
			  state.setString(1, subject.getStitle());
			  state.setString(2, subject.getOptiona());
			  state.setString(3, subject.getOptionb());
				state.setString(4, subject.getOptionc());
				state.setString(5, subject.getOptiond());
				state.setString(6,subject.getPic());
				state.setString(7, subject.getAnswer());
				state.setInt(8, subject.getSubjectType().getStid());
				int row=state.executeUpdate();
				if(row>0) {
					flag=true;
				}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con, state);
		}
		   return flag;

	}

	
	
	private final static String DELETEE="delete from subject where sid=?";
    @Override
	public boolean deleteSubject(int sid) {
		 Connection con=null;
		    PreparedStatement state=null;
		    boolean flag=false;
			con=DBUtil.getConnection();
			try {
			   state=con.prepareStatement(DELETEE);
	           state.setInt(1, sid);
		     
		       Integer row= state.executeUpdate();
			     if(row!=null) {
			    	 flag=true;
			     }
			}catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
		           DBUtil.close(con, state);  
			 }
		  return flag;
	}

    
    private final static String UPDATEEMP="update subjcet set stitle=?,optiona=?,optionb=?,optionc=?,optiond=?,pic=?,answer=?,stid=? where empno=?";
    @Override
	public boolean modifySubject(Subject subject) {
    	 Connection con=null;
 	    PreparedStatement state=null;
 	    boolean flag=false;
 	    con=DBUtil.getConnection();
 		try {
 			 state=con.prepareStatement(UPDATEEMP);
 			  state.setString(1, subject.getStitle());
			  state.setString(2, subject.getOptiona());
			  state.setString(3, subject.getOptionb());
				state.setString(4, subject.getOptionc());
				state.setString(5, subject.getOptiond());
				state.setString(6,subject.getPic());
				state.setString(7, subject.getAnswer());
				state.setInt(8, subject.getSubjectType().getStid());
 			   Integer row= state.executeUpdate();
 			 if(row!=null) {
 				 flag=true;
 			 }
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}finally {
 	           DBUtil.close(con, state);  
 		 }
 		return flag;
		
	}

    
    private final static String SELECTBYSID="select * from subject where sid=?";
//    private final static String SELECTBYSID="select stitle,optiona,optionb,optionc,optiond,pic,answer,stid from subject where sid=?";
   @Override
	public Subject selectSubjectBysid(int sid) {
	   Connection con=null;
	    PreparedStatement state=null;
	    ResultSet res=null;
	    Subject subject=null;
	   try {
		   con=DBUtil.getConnection();
		   state=con.prepareStatement(SELECTBYSID);
		   state.setInt(1, sid);
		   res=state.executeQuery();
	      if(res.next()) {
	    	 subject=new Subject();
	    	 subject.setSid(res.getInt("sid"));
	    	 subject.setStitle(res.getString("stitle"));
	    	 subject.setOptiona(res.getString("optiona"));
	    	 subject.setOptionb(res.getString("optionb"));
	    	 subject.setOptionc(res.getString("optionc"));
	    	 subject.setOptiond(res.getString("optiond"));
	    	 subject.setAnswer(res.getString("answer"));
	    	 subject.setPic(res.getString("pic"));
	    	 subject.setStid(res.getInt("stid"));
	    	}
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {

		 DBUtil.close(con, state, res);  
	   }
	   
	   return subject;
	}
   
@Override
public ArrayList<Subject> selectAll() {
	Connection con=null;
    Statement state=null;
    ResultSet res=null;
    ArrayList<Subject> subjectList=new ArrayList<>();
    try {
	   con=DBUtil.getConnection();
	   String sql="select * from subject";		    
	   state=con.createStatement();
	   res= state.executeQuery(sql);
      while(res.next()) {
    	  Subject subject=new Subject();
    	  subject.setSid(res.getInt("sid"));
	    	 subject.setStitle(res.getString("stitle"));
	    	 subject.setOptiona(res.getString("optiona"));
	    	 subject.setOptionb(res.getString("optionb"));
	    	 subject.setOptionc(res.getString("optionc"));
	    	 subject.setOptiond(res.getString("optiond"));
	    	 subject.setAnswer(res.getString("answer"));
	    	 subject.setPic(res.getString("pic"));
	    	 subject.setStid(res.getInt("stid"));
    	     subjectList.add(subject) ;
      }
   }catch(Exception e) {
	   e.printStackTrace();
   }finally {

	 DBUtil.close(con, state, res);  
   }
     return subjectList;
	}

private final static String QUERYSUBJECT = "select * from subject where stitle like ?";
@Override
public ArrayList<Subject> selectSubject(String stitle) {
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		Subject subject=null;
		ArrayList<Subject> subjectList=new ArrayList<>();
		conn=DBUtil.getConnection();
		try {
			stat=conn.prepareStatement(QUERYSUBJECT);
			stat.setString(1, "%"+stitle+"%");
			rs=stat.executeQuery();
			while(rs.next()) {
				 subject=new Subject();
		    	 subject.setStitle(rs.getString("stitle"));
		    	 subject.setOptiona(rs.getString("optiona"));
		    	 subject.setOptionb(rs.getString("optionb"));
		    	 subject.setOptionc(rs.getString("optionc"));
		    	 subject.setOptiond(rs.getString("optiond"));
		    	 subject.setAnswer(rs.getString("answer"));
		    	 subject.setPic(rs.getString("pic"));
		    	 subject.setStid(rs.getInt("stid"));
		    	 subjectList.add(subject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stat, rs);
		}
		return subjectList;
	}


private final static String UPDATESUBJECTBYID = "update subject set stitle=?,optiona=?,optionb=?,optionc=?,optiond=?,pic=?,answer=?,stid=? where sid=?";
@Override
public boolean updateSubjectById(int sid,Subject subject) {
	Connection conn=null;
	PreparedStatement stat=null;
	boolean temp=false;
	conn = DBUtil.getConnection();
	try {
		conn.setAutoCommit(false);
		stat = conn.prepareStatement(UPDATESUBJECTBYID);
		stat.setString(1, subject.getStitle());
		stat.setString(2, subject.getOptiona());
		stat.setString(3, subject.getOptionb());
		stat.setString(4, subject.getOptionc());
		stat.setString(5, subject.getOptiond());
		stat.setString(6, subject.getPic());
		stat.setString(7, subject.getAnswer());
		stat.setInt(8, subject.getSubjectType().getStid());
		stat.setInt(9, sid);
		int row = stat.executeUpdate();
		if(row>0) {
			temp=true;
			conn.commit();
		}
	} catch (Exception e) {
		try {
			conn.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		e.printStackTrace();
	}finally {
		DBUtil.close(conn, stat);
	}
	return temp;
}

}
