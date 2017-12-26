package com.balloon.biz.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.balloon.biz.regin.ReginDAOImpl_balloon;
import com.balloon.biz.regin.ReginDAO_balloon;
import com.balloon.entity.Store_balloon;
import com.balloon.util.DB.DBHelper;
/**
 * 店铺接口实现类
 * @author cfy
 *
 */
public class StoreDAOImpl_balloon extends DBHelper implements StoreDAO_balloon {
	Connection con = null;
	ResultSet res = null;
	PreparedStatement ps = null;
	Statement stat = null;
	
	/**
	 * 添加新店铺
	 * 输入新店铺的名称和所属区域的id
	 * return 1 添加成功
	 * return 0 添加不成功
	 */
	@Override
	public int addStore(String storeName, String mangerName,int reginID) {
		// TODO 自动生成的方法存根
			int temp = 0;
			String sql = "insert into Store (storeName,mangerName,ReginID)values(?,?,?)";
			con = getConnection();
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, storeName);
				ps.setString(2, mangerName);
				ps.setInt(3, reginID);
				temp = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				Close();
			}
			return temp;
		}

	/**
	 * 删除店铺
	 * 输入店铺名称
	 * return 1 删除成功
	 * return 0 删除失败
	 */
	@Override
	public int delStore(String storeName) {
		// TODO 自动生成的方法存根
		int temp = 0;
		con = getConnection();
		String sql = "delete from Store where storeName=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, storeName);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}

	/**
	 * 删除店铺
	 * 输入店铺id
	 * return 1 删除成功
	 * return 0 删除失败
	 */
	@Override
	public int delStore(int storeID) {
		// TODO 自动生成的方法存根
		int temp = 0;
		con = getConnection();
		String sql = "delete from Store where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, storeID);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}

	/**
	 * 查找店铺名称是否存在
	 * return 1 此名称已经存在
 	 * return 0 该店铺不存在 
	 */
	@Override
	public int searchByname(String storeName) {
		// TODO 自动生成的方法存根
		int temp = 0; 
		con = getConnection();
		String sql = "select * from  Store where storeName=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, storeName);
			res = ps.executeQuery();
			while (res.next()) {
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
	 * 更新店铺信息
	 * 输入旧的店铺名称-新的店铺名称
	 * return 1 更新成功
	 * return 0 更新失败
	 */
	@Override
	public int updateStore(String storeName,String newName) {
		// TODO 自动生成的方法存根
		int temp = 0;
		String sql = "update Store set storeName=? where storeName=?";
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, storeName);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		
	    sql = "update MangerInfo set storeName = ? where storeName=?";
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, storeName);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}

	/**
	 * 输入店铺id
	 * return 店铺名字
	 * return 0  无此店铺 查找失败 
	 */
	@Override
	public String getNameByID(int storeID) {
		// TODO 自动生成的方法存根
		String storeName= null;
		String sql = "select * from Store where id=?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, storeID);
			res = ps.executeQuery();
			while (res.next()) {
			  storeName = res.getString("storeName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
	return storeName;
	}
	
	/**
	 * 更新店铺信息
	 * 输入店铺id-新的店铺名称
	 * return 1 修改成功
	 * return 0 修改不成功
	 */
	@Override
	public int updateStore(int storeID,String newName) {
		// TODO 自动生成的方法存根
		int temp = 0;
	String oldName = getNameByID(storeID);
	String sql = "update MangerInfo set storeName = ? where storeName=?";
	con = getConnection();
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, newName);
		ps.setString(2, oldName);
		temp = ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		Close();
	}
		 sql = "update Store set storeName=? where id=?";
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setInt(2, storeID);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;	
	}

	/**
	 * 输入店铺名
	 * return 店铺id
	 * return 0  无此店铺 查找失败
	 */
	@Override
	public int getIdByName(String storeName) {
		// TODO 自动生成的方法存根
		int storeID = 0;
		String sql = "select * from Store where storeName=?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, storeName);
			res = ps.executeQuery();
			while (res.next()) {
			  storeID = res.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
	return storeID;
	}

	/**
	 * 获取某一区域的店铺
	 * 输入区域id
	 * return 该区域的所有店铺
	 * else return null 
	 */
	@Override
	public List<Store_balloon> getListByreginID(int reginID) {
		// TODO 自动生成的方法存根
		String sql = "select * from Store where ReginID=?";
		List<Store_balloon> store_balloons = new ArrayList<Store_balloon>();
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, reginID);
			res = ps.executeQuery();
			while (res.next()) {
				
				Store_balloon store_balloon = new Store_balloon();
				store_balloon.setId(res.getInt("id"));
				store_balloon.setStoreName(res.getString("storeName"));
				store_balloon.setReginID(res.getInt("ReginID"));
				store_balloons.add(store_balloon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return store_balloons;
	}

	/**
	 * 获取某一区域的id
	 * 输入区域名称
	 * return 该区域的所有店铺
	 * else return null 
	 */
	@Override
	public List<Store_balloon> getListByreginName(String reginName) {
		// TODO 自动生成的方法存根
		int ReginID = 0;
		ReginDAO_balloon reginDAO_balloon = new ReginDAOImpl_balloon();
		ReginID = reginDAO_balloon.getID(reginName);
		String sql = "select * from Store where ReginID=?";
		List<Store_balloon> store_balloons = new ArrayList<Store_balloon>();
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ReginID);
			res = ps.executeQuery();
			while (res.next()) {
				
				Store_balloon store_balloon = new Store_balloon();
				store_balloon.setId(res.getInt("id"));
				store_balloon.setStoreName(res.getString("storeName"));
				store_balloon.setReginID(res.getInt("ReginID"));
				store_balloons.add(store_balloon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return store_balloons;
	}
	/**
	 *获取所有的电铺信息
	 *return 存有所有店铺的list
	 */
	@Override
	public List<Store_balloon> getAllstore() {
		// TODO 自动生成的方法存根
		String sql = "select * from Store";
		List<Store_balloon> store_balloons = new ArrayList<Store_balloon>();
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			while (res.next()) {
				
				Store_balloon store_balloon = new Store_balloon();
				store_balloon.setId(res.getInt("id"));
				store_balloon.setStoreName(res.getString("storeName"));
				store_balloon.setReginID(res.getInt("ReginID"));
				store_balloons.add(store_balloon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return store_balloons;
	}

}
