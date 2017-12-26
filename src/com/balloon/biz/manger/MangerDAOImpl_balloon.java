package com.balloon.biz.manger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.balloon.entity.MangerInfo_balloon;
import com.balloon.util.DB.DBHelper;

/**
 * 管理员类DAO接口实现类
 * 
 * @author cfy
 *
 */
public class MangerDAOImpl_balloon extends DBHelper implements MangerDAO_balloon {
	Connection con = null;
	ResultSet res = null;
	PreparedStatement ps = null;
	Statement stat = null;

	/**
	 * 添加管理员 
	 * 输入要添加的用户名和密码 
	 * return 用户名存在，返回0 
	 * return 是否添加成功，成功1，不成功0
	 */
	@Override
	public int addManger(String mangerName, String password,String storeName) {
		// TODO 自动生成的方法存根
		int temp = 0;
		String sql = "select * from MangerInfo where mangerName=?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, mangerName);
			res = ps.executeQuery();
			while (res.next()) {
				temp = 1;//用户名已经被注册
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}

		if (temp == 1) {
			return 0;
		} else {
			sql = "insert into MangerInfo (mangerName,pwd,storeName)values(?,?,?)";
			con = getConnection();
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, mangerName);
				ps.setString(2, password);
				ps.setString(3,storeName);
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
	 * 删除管理员 
	 * 输入要删除的管理员ID 
	 * return 0 删除不成功
	 */
	@Override
	public int deleteManger(int idTodel) {
		int temp = 0;
		con = getConnection();
		String sql = "delete from mangerInfo where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, idTodel);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}
	public int deleteMangerByStore(String store) {
		int temp = 0;
		con = getConnection();
		String sql = "delete from mangerInfo where storeName=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, store);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}

	/**
	 * 删除管理员 
	 * 输入要删除的管理员的名称
	 * return 0
	 */
	@Override
	public int deleteManger(String nameTodel) {
		// TODO 自动生成的方法存根
		int temp = 0;
		con = getConnection();
		String sql = "delete from mangerInfo where mangerName=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,nameTodel);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}
	
	/**
	 * 更新管理员信息 
	 * 输入要更新的管理员ID和新的管理员名称，密码 
	 * return 是否添加成功
	 * 成功1，不成功0
	 */
	@Override
	public int updateManger(int idToupdate, String mangerName, String password) {
		// TODO 自动生成的方法存根
		int temp = 0;
		String oldName = null;
		String sql = "select * from MangerInfo where id=?";
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, idToupdate);
			res = ps.executeQuery();
			if(res.next()) {
				oldName = res.getString("mangerName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		
		sql = "update MangerInfo set mangerName=? ,pwd=? where id=" + idToupdate;
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mangerName);
			ps.setString(2, password);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		
		sql = "update Store set mangerName = ? where mangerName = ?";
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mangerName);
			ps.setString(2, oldName);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}

	/**
	 * 更新管理员信息 
	 * 输入要更新的管理员名字和新的管理员名称，密码 
	 * return 是否添加成功
	 * 成功1，不成功0
	 */
	@Override
	public int updateManger(String oldName, String newName, String password) {
		// TODO 自动生成的方法存根
		int temp = 0;
		String sql = "update MangerInfo set mangerName=? ,pwd=? where mangerName=?";
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, password);
			ps.setString(3, oldName);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		
		sql = "update Store set mangerName = ? where mangerName = ?";
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
		return temp;
	}

	/**
	 * 通过id获取管理员名字
	 * 输入管理员id
	 * return 管理员名字 查找成功
	 * return null 管理员不存在查找失败
	 */
	@Override
	public String getNameByID(int mangerID) {
		// TODO 自动生成的方法存根
		String mangerName = null;
		String sql = "select * from MangerInfo where id=?";
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mangerID);
			res = ps.executeQuery();
			if(res.next()) {
				mangerName = res.getString("mangerName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return mangerName;
	}
	
	/**
	 * 根据姓名和密码查找管理员是否存在 输入用户名和密码 
	 * return 管理员ID 找到符合要求的管理员 
	 * return 0 用户名或密码错误
	 */
	@Override
	public int getLoginID(String mangerName, String password) {
		// TODO 自动生成的方法存根
		int loginId = 0;
		con = getConnection();
		String sql = "select * from MangerInfo where mangerName=? and pwd=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mangerName);
			ps.setString(2, password);
			res = ps.executeQuery();
			while (res.next()) {
				loginId = res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return loginId;
	}

	/**
	 * 查看管理员总数 
	 * return 管理员个数 查询成功 
	 * return 0 查询失败
	 */
	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		String sql = "select count(*) from MangerInfo";
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
	 * 获取所有管理员信息
	 *  return 管理员的List表
	 */
	@Override
	public List<MangerInfo_balloon> getMangerList() {
		// TODO 自动生成的方法存根
		String sql = "select * from MangerInfo";
		List<MangerInfo_balloon> mangerInfo_balloons = new ArrayList<MangerInfo_balloon>();
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();
			while (res.next()) {
				MangerInfo_balloon manger = new MangerInfo_balloon();
				manger.setId(res.getInt("id"));
				manger.setMangerName(res.getString("mangerName"));
				manger.setPwd(res.getString("pwd"));
				mangerInfo_balloons.add(manger);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return mangerInfo_balloons;
	}

	/**
	 * 根据ID获取管理员信息 
	 * return 管理员信息对象 查找成功 
	 * return 0 查找失败
	 */
	@Override
	public MangerInfo_balloon getinfoByID(int idTofind) {
		// TODO 自动生成的方法存根
		MangerInfo_balloon mangerInfo_balloon = null;
		con = getConnection();
		String sql = "select * from MangerInfo where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, idTofind);
			res = ps.executeQuery();
			while (res.next()) {
				mangerInfo_balloon = new MangerInfo_balloon();
				mangerInfo_balloon.setId(idTofind);
				mangerInfo_balloon.setMangerName(res.getString("mangerName"));
				mangerInfo_balloon.setPwd(res.getString("pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return mangerInfo_balloon;
	}

	/**
	 * 管理员登陆过程 
	 * 输入用户名 
	 * return password 用户名存在 
	 * return null 用户名不存在
	 */
	@Override
	public String getPassword(String mangerName) {
		// TODO 自动生成的方法存根
		String password = null;
		con = getConnection();
		String sql = "select * from MangerInfo where mangerName=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mangerName);
			res = ps.executeQuery();
			while (res.next()) {
				password = res.getString(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return password;
	}

	@Override
	public int getIdByName(String mangerName) {
		// TODO 自动生成的方法存根
		int mangerID = 0;
		String sql = "select * from MangerInfo where mangerName=?";
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mangerName);
			res = ps.executeQuery();
			if(res.next()) {
				mangerID = res.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return mangerID;
	}

	@Override
	public String getStoreName(int mangerId) {
		// TODO 自动生成的方法存根
		String storeName = null;
		String sql = "select * from MangerInfo where id=?";
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mangerId);
			res = ps.executeQuery();
			if(res.next()) {
				storeName = res.getString("storeName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return storeName;
	}

	@Override
	public String getStoreName(String mangerName) {
		// TODO 自动生成的方法存根
		String storeName = null;
		String sql = "select * from MangerInfo where mangerName=?";
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mangerName);
			res = ps.executeQuery();
			if(res.next()) {
				storeName = res.getString("storeName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return storeName;
	}

}
