package com.shine.dsst.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.shine.dsst.bean.User;
import com.shine.dsst.bean.UserType;
import com.shine.dsst.dao.UserDao;
import com.shine.dsst.utils.DBUtil;

public class UserDaoImpl implements UserDao {
	private static UserDaoImpl userDaoImpl = null;
	private UserDaoImpl() {
		
	}
	public static UserDaoImpl getInstance() {
		if(userDaoImpl==null) {
			return userDaoImpl = new UserDaoImpl();
		}
		return userDaoImpl;
	}
	/**
	 * 考生登录验证
	 */
	@Override
	public User login(String idcard, String name) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		String sql = "select * from user where idcard = ? and name = ?";
		User user = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, idcard);
			ps.setString(2, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				UserType ut = new UserType();
				ut.setTid(rs.getInt("tid"));
				user = new User(rs.getInt("uid"),rs.getString("username"),rs.getString("password"),rs.getString("name"),rs.getString("sex"),rs.getString("phone"),rs.getString("idcard"),ut);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, ps, rs);
		}
		
		return user;
	}
	/**
	 * 管理员登录验证
	 */
	@Override
	public User adminLogin(String username, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		String sql = "select * from user where username = ? and password = ?";
		User user = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				UserType ut = new UserType();
				ut.setTid(rs.getInt("tid"));
				user = new User(rs.getInt("uid"),rs.getString("username"),rs.getString("password"),rs.getString("name"),rs.getString("sex"),rs.getString("phone"),rs.getString("idcard"),ut);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, ps, rs);
		}
		
		return user;
	}
	private final static String ADDUSER="insert into user(username,password,name,sex,phone,idcard,tid,grade) values(?,?,?,?,?,?,?,?)";

	@Override
	public boolean AddUser(User user) {
		 Connection con=null;
		  PreparedStatement state=null;
		  con=DBUtil.getConnection();
		  boolean flag=false;
		  boolean temp=true;
		  ResultSet res=null;
		  try {
			  String sql="select username from user where username=?";
			  state=con.prepareStatement(sql) ;
			  state.setString(1, user.getUsername());
			  res=state.executeQuery();
			  if(res.next()) {
				  temp=false;
			  }
			  if(temp) {
				  state=con.prepareStatement(ADDUSER);
				  state.setString(1, user.getUsername());
				  state.setString(2, user.getPassword());
				  state.setString(3, user.getName());
					state.setString(4, user.getSex());
					state.setString(5, user.getPhone());
					state.setString(6,user.getIdcard());
					state.setInt(7, user.getUserType().getTid());
					state.setString(8, user.getGrade());
					int row=state.executeUpdate();
					if(row>0) {
						flag=true;
					}
			  }else {
				  System.out.println("该用户名已存在");
			  }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con, state);
		}
		   return flag;
		
	}

	

	private final static String SELECTUNAMEPASSW="select username,password from user where username=? and password=?";
	@Override
	public  User selectUserByUserNameAndPassword(String username, String password) {
		
		Connection con=null;
		PreparedStatement state=null;
		ResultSet res=null;
		con=DBUtil.getConnection();
		User user=null;
		try {
			state=con.prepareStatement(SELECTUNAMEPASSW);
			state.setString(1,username);
			state.setString(2, password);
			res=state.executeQuery();
			if(res.next()) {
				user=new User();
				user.setUid(res.getInt("uid"));
				user.setUsername(res.getString("username"));
				user.setName(res.getString("name"));
				user.setPhone(res.getString("phone"));
				user.setSex(res.getString("sex"));
				user.setIdcard(res.getString("idcard"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	
	private final static String DELETEE="delete from user where uid=?";
    @Override
	public boolean deleteUser(int uid) {
		 Connection con=null;
		    PreparedStatement state=null;
		    boolean flag=false;
			con=DBUtil.getConnection();
			try {
			   state=con.prepareStatement(DELETEE);
	           state.setInt(1, uid);
		     
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

    private final static String SELECTBYSID="select * from user where uid=?";
    @Override
	public User selectUserByuid(int uid) {
	   Connection con=null;
	    PreparedStatement state=null;
	    ResultSet res=null;
	    User user=null;
	   try {
		   con=DBUtil.getConnection();
		   state=con.prepareStatement(SELECTBYSID);
		   state.setInt(1, uid);
		   res=state.executeQuery();
	      if(res.next()) {
	    	 user=new User();
	    	 user.setUid(res.getInt("uid"));
	    	 user.setUsername(res.getString("username"));
	    	 user.setPassword(res.getString("password"));
	    	 user.setName(res.getString("name"));
	    	 user.setSex(res.getString("sex"));
	    	 user.setPhone(res.getString("phone"));
	    	 user.setIdcard(res.getString("idcard"));
	    	 user.setTid(res.getInt("tid"));
	    	 user.setGrade(res.getString("grade"));
	    	}
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {

		 DBUtil.close(con, state, res);  
	   }
	   return user;
	}
    
    
    private final static String UPDATEUSERBYID = "update user set username=?,password=?,name=?,sex=?,phone=?,idcard=?,tid=?,grade=? where uid=?";
    @Override
    public boolean modifyUser(int uid,User user) {
    	Connection conn=null;
    	PreparedStatement stat=null;
    	boolean temp=false;
    	conn = DBUtil.getConnection();
    	try {
    		conn.setAutoCommit(false);
    		stat = conn.prepareStatement(UPDATEUSERBYID);
    		stat.setString(1, user.getUsername());
    		stat.setString(2, user.getPassword());
    		stat.setString(3, user.getName());
    		stat.setString(4, user.getSex());
    		stat.setString(5, user.getPhone());
    		stat.setString(6, user.getIdcard());
    		stat.setInt(7, user.getUserType().getTid());
    		stat.setString(8, user.getGrade());
    		stat.setInt(9, uid);
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

    @Override
    public ArrayList<User> selectAll() {
    	Connection con=null;
        Statement state=null;
        ResultSet res=null;
        ArrayList<User> userList=new ArrayList<>();
        try {
    	   con=DBUtil.getConnection();
    	   String sql="select * from user";		    
    	   state=con.createStatement();
    	   res= state.executeQuery(sql);
          while(res.next()) {
        	  User user=new User();
        	 user.setUid(res.getInt("uid"));
 	    	 user.setUsername(res.getString("username"));
 	    	 user.setPassword(res.getString("password"));
 	    	 user.setName(res.getString("name"));
 	    	 user.setSex(res.getString("sex"));
 	    	 user.setPhone(res.getString("phone"));
 	    	 user.setIdcard(res.getString("idcard"));
 	    	 user.setTid(res.getInt("tid"));
 	    	 user.setGrade(res.getString("grade"));
        	 userList.add(user) ;
          }
       }catch(Exception e) {
    	   e.printStackTrace();
       }finally {

    	 DBUtil.close(con, state, res);  
       }
         return userList;
    	}

    private final static String QUERYUSER = "select * from user where username like ?";
    @Override
    public ArrayList<User> selectUser(String username) {
    		Connection conn=null;
    		PreparedStatement stat=null;
    		ResultSet rs=null;
    		User user=null;
    		ArrayList<User> userList=new ArrayList<>();
    		conn=DBUtil.getConnection();
    		try {
    			stat=conn.prepareStatement(QUERYUSER);
    			stat.setString(1, "%"+username+"%");
    			rs=stat.executeQuery();
    			while(rs.next()) {
    				 user=new User();
    				 user.setUid(rs.getInt("uid"));
    				 user.setUsername(rs.getString("username"));
    	 	    	 user.setPassword(rs.getString("password"));
    	 	    	 user.setName(rs.getString("name"));
    	 	    	 user.setSex(rs.getString("sex"));
    	 	    	 user.setPhone(rs.getString("phone"));
    	 	    	 user.setIdcard(rs.getString("idcard"));
    	 	    	 user.setTid(rs.getInt("tid"));
    	 	    	 user.setGrade(rs.getString("grade"));
    		    	 userList.add(user);
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}finally {
    			DBUtil.close(conn, stat, rs);
    		}
    		return userList;
    	}

}
