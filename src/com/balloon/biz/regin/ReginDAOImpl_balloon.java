package com.balloon.biz.regin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.balloon.entity.GoodRegin_balloon;
import com.balloon.util.DB.DBHelper;
/**
 *  商品区域接口实现类
 * @author cfy
 *
 */
public class ReginDAOImpl_balloon extends DBHelper implements ReginDAO_balloon {
	Connection con = null;
	ResultSet res = null;
	PreparedStatement ps = null;
	Statement stat = null;
	/**
	 * 添加新区
	 * return 1 添加成功
	 * return 0  添加失败
	 */
	@Override
	public int addRegin(String reginName) {
		// TODO 自动生成的方法存根
		int temp = 0;
		String sql = "insert into goodRegin (reginName)values(?)";
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reginName);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}

	/**
	 * 根据原区名字更新区域名称
	 * 输入原名和新名
	 * return 1 更新成功
	 * return 0 更新失败
	 */
	@Override
	public int updateByName(String reginName, String newName) {
		// TODO 自动生成的方法存根
		int temp =0;
		con = getConnection();
		String sql = "update goodRegin set reginName = ? where reginName =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, reginName);
			int a = ps.executeUpdate();
			if (a ==1) {
				temp = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}

	/**
	 * 根据id更新区域名称
	 * 输入区间id和新名
	 * return 1 更新成功
	 * return 0 更新失败
	 */
	@Override
	public int updateByID(int reginID, String newName) {
		// TODO 自动生成的方法存根
		int temp = 0;
		String sql = "update goodRegin set reginName=? where id=" + reginID;
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,newName);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}

	/*
	 * 通过区域名字获取区域id
	 * 输入区名
	 * return 区域id
	 * return 0 查找失败
	 */
	@Override
	public int getID(String reginName) {
		int reginID = 0;
		con = getConnection();
		String sql = "select * from goodRegin where reginName=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reginName);
			res = ps.executeQuery();
			while (res.next()) {
				reginID = res.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return reginID;
	}

	/**
	 * 通过区域id获取区域名字
	 * 输入区间id
	 * return ReginName 
	 * return null 查找失败
	 */
	@Override
	public String getReginName(int reginID) {
		// TODO 自动生成的方法存根
		String reginName = null;
		con = getConnection();
		String sql = "select * from goodRegin where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, reginID);
			res = ps.executeQuery();
			while (res.next()) {
				reginName = res.getString("reginName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return reginName;
	}

	/**
	 *获取区间个数
	 *return ReginNum 
	 */
	@Override
	public int getReginCount() {
		// TODO 自动生成的方法存根
		String sql = "select count(*) from goodRegin";
		con = getConnection();
		int count = 0;
		try {
			stat = con.createStatement();
			res = stat.executeQuery(sql);
			while (res.next()) {
				count = res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return count;
	}

	/**
	 * 获取区域的list
	 * return ReginList
	 */
	@Override
	public List<GoodRegin_balloon> getReginList() {
		// TODO 自动生成的方法存根
		String sql = "select * from goodRegin";
		List<GoodRegin_balloon> goodRegin_balloons = new ArrayList<GoodRegin_balloon>();
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			while (res.next()) {
				GoodRegin_balloon goodregin = new GoodRegin_balloon();
				goodregin.setId(res.getInt("id"));
				goodregin.setReginName(res.getString("reginName"));
				goodRegin_balloons.add(goodregin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return goodRegin_balloons;
	}

}
