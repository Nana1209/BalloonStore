package com.balloon.biz.comment;

import java.util.List;

import com.balloon.entity.Comment_balloon;

/**
 * 评论类DAO接口 
 * 用户一旦评论之后不能修改评论内容
 * 允许用户删除自己的某条评论
 * @author cfy
 */
public interface CommentDAO_balloon {
	public int addComment(int goodID, int userID, String comDetail);// 添加评论

	public int delByGoodID(int goodID);// 根据商品ID删除评论，删除该商品的所有评论

	public int delByUserID(int userID);// 根据用户ID删除评论，删除该用户所有的评论
	
	public int actionTodelGood(int goodID);//商品被删除,商品ID变为0
	
	public int actionTodelMember(int userID);//用户被删除,用户ID变为0

	public int delOne(int goodID, int userID);// 根据用户ID和商品ID删除该用户的某条评论

	public int getCountByuserID(int userID);// 获取某个用户共有多少条评论

	public int getCountBygoodID(int goodID);// 获取某个商品共有多少条评论
	
	public int whetherComment(int goodID, int userID);//查看用户是否对某个商品进行了评论

	public List<Comment_balloon> getGoodlistByuserID(int userID);// 获取某用户的所有评论

	public List<Comment_balloon> getGoodlistBygoodID(int goodID);// 获取某商品的所有评论

}
