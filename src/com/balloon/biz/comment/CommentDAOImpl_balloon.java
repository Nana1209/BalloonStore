package com.balloon.biz.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.balloon.entity.Comment_balloon;
import com.balloon.util.DB.DBHelper;
/**
 * 评论DAO接口实现类
 * @author cfy
 *
 */
public class CommentDAOImpl_balloon extends DBHelper implements CommentDAO_balloon {
	Connection con = null;
	ResultSet res = null;
	PreparedStatement ps = null;
	Statement stat = null;

	/**
	 * 添加评论 
	 * return 是否添加成功 
	 * 成功返回1，不成功返回0
	 */
	@Override
	public int addComment(int goodID, int userID, String comDetail) {
		// TODO 自动生成的方法存根
		int temp = 0;
		String sql = "insert into comment (goodID,userID,comDetail)values(?,?,?)";
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodID);
			ps.setInt(2, userID);
			ps.setString(3, comDetail);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}

	/**
	 * 根据商品id删除评论
	 * return 是否删除成功
	 *  成功返回1，不成功返回0
	 */
	@Override
	public int delByGoodID(int goodID) {
		int temp = 0;
		con = getConnection();
		String sql = "delete from comment where goodID=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodID);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}

	/**
	 * 根据用户id删除评论 
	 * return 是否删除成功 
	 * 成功返回1，不成功返回0
	 */
	@Override
	public int delByUserID(int userID) {
		// TODO 自动生成的方法存根
		int temp = 0;
		con = getConnection();
		String sql = "delete from comment where userID=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userID);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}

	/**
	 * 根据商品id和用户id删除评论 
	 * return 是否删除成功 
	 * 成功返回1，不成功返回0
	 */
	@Override
	public int delOne(int goodID, int userID) {
		// TODO 自动生成的方法存根
		int temp = 0;
		con = getConnection();
		String sql = "delete from comment where goodID=? and userID=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodID);
			ps.setInt(2, userID);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}

	/**
	 * 获取用户发表评论数目 
	 * 传入用户id 
	 * return 是否添加成功 
	 * 成功返回1，不成功返回0
	 */
	@Override
	public int getCountByuserID(int userID) {
		// TODO 自动生成的方法存根
		int temp = 0;
		con = getConnection();
		String sql = "select * from comment where userID=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userID);
			res = ps.executeQuery();
			while (res.next()) {
				temp++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}

	/**
	 * 获取商品对应评论数目 
	 * 传入商品id 
	 * return 是否添加成功 
	 * 成功返回1，不成功返回0
	 */
	@Override
	public int getCountBygoodID(int goodID) {
		// TODO 自动生成的方法存根
		int temp = 0;
		con = getConnection();
		String sql = "select * from comment where goodID=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodID);
			res = ps.executeQuery();
			while (res.next()) {
				temp++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return temp;
	}
	
	/**
	 * 获取某用户发表的评论的list
	 * 传入用户id 
	 * return list 查找成功
	 * return null 查找失败
	 */
	@Override
	public List<Comment_balloon> getGoodlistByuserID(int userID) {
		// TODO 自动生成的方法存根
		List<Comment_balloon>comment_balloons = new ArrayList<Comment_balloon>();
		con = getConnection();
		String sql = "select * from comment where userID=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userID);
			res = ps.executeQuery();
			while (res.next()) {
				Comment_balloon comment_balloon = new Comment_balloon();
				comment_balloon.setGoodID(res.getInt("goodID"));
				comment_balloon.setUserID(res.getInt("userID"));
				comment_balloon.setComDetail(res.getString("comDetail"));
				comment_balloons.add(comment_balloon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return comment_balloons;
	}
	
	/**
	 * 获取某商品评论的list
	 * 传入商品id 
	 * return list 查找成功
	 * return null 查找失败
	 */
	@Override
	public List<Comment_balloon> getGoodlistBygoodID(int goodID) {
		// TODO 自动生成的方法存根
		List<Comment_balloon>comment_balloons = new ArrayList<Comment_balloon>();
		con = getConnection();
		String sql = "select * from comment where goodID=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodID);
			res = ps.executeQuery();
			while (res.next()) {
				Comment_balloon comment_balloon = new Comment_balloon();
				comment_balloon.setGoodID(res.getInt("goodID"));
				comment_balloon.setUserID(res.getInt("userID"));
				comment_balloon.setComDetail(res.getString("comDetail"));
				comment_balloons.add(comment_balloon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return comment_balloons;
	}

	/**
	 * 用户是否评论某个商品
	 * 传入商品id和用户id
	 * return 0 用户没有评论
	 * return 1 用户已经评论
	 */
	@Override
	public int whetherComment(int goodID, int userID) {
		// TODO 自动生成的方法存根
		int temp =0;
		con = getConnection();
		String sql = "select * from comment where goodID=? and userID=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, goodID);
			ps.setInt(2, userID);
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
	 * 商品被删除后商品id变为0
	 * return 1 修改成功
	 * return 0 修改失败
	 */
	@Override
	public int actionTodelGood(int goodID) {
		int temp =0;
		con = getConnection();
		String sql = "update comment set goodID =0 where goodID=" +goodID;
		try {
			ps = con.prepareStatement(sql);
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
	 * 用户被删除后用户id变为0
	 * return 1 修改成功
	 * return 0 修改失败
	 */
	@Override
	public int actionTodelMember(int userID) {
	// TODO 自动生成的方法存根
		int temp = 0;
		con = getConnection();
		String sql = "update comment set userID=0 where userID=" +userID;
		try {
			ps = con.prepareStatement(sql);
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

}
