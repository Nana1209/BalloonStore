package com.balloon.biz.member;

import com.balloon.util.DB.DBHelper;

import java.sql.*;

/**
 * Created by xinna on 2017/7/11.
 */
public class MemberDao_balloon extends DBHelper{
    String psw = null;
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    Statement stat=null;
    //DBHelper db = new DBHelper();
    
    /**
     * 根据用户名查找密码
     * @param memberName
     * @return
     */
    public String findPwdByName(String memberName){
        con=getConnection();
        String sql="select * from memberInfo where memberName=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, memberName);
            rs = ps.executeQuery();
            if(rs==null){
                return null;
            }
            if(rs.next()){
                psw=rs.getString("pwd");
            }else{
                psw=null;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
           Close();
        }
        return psw;

    }

    /**
     * 增加用户。若已存在返回0，添加成功返回1
     * @param memberName
     * @param password
     * @return
     */
    public int addMember(String memberName, String password) {
		
		int temp = 0;
		String sql = "select * from memberInfo where memberName=?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberName);
			rs = ps.executeQuery();
			while (rs.next()) {
				temp = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}

		if (temp == 1) {
			return 0;
		} else {
			sql = "insert into memberInfo (memberName,pwd)values(?,?)";
			con = getConnection();
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, memberName);
				ps.setString(2, password);
				temp = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				Close();
			}
			return temp;
		}
	}
    
    /**
     * 删除用户，删除成功返回1
     * @param memberName
     * @return
     */
    public int deleteMember(String memberName) {
		int temp = 0;
		con = getConnection();
		String sql = "delete from memberInfo where memberName=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memberName);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}
    
    /**
     * 根据用户名查找用户是否存在（1为存在）
     * @param memberName
     * @return
     */
    public int hasMember(String memberName){
    	int temp = 0;
		con = getConnection();
		String sql = "select *from memberInfo where memberName=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memberName);
			rs = ps.executeQuery();
			while (rs.next()) {
				temp = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
    }
    
	public int getID(String memberName) {
		// TODO 自动生成的方法存根
		int loginId = 0;
		con = getConnection();
		String sql = "select * from memberInfo where memberName=? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memberName);
			rs = ps.executeQuery();
			while (rs.next()) {
				loginId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return loginId;
	}
}
