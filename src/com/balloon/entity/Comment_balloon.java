package com.balloon.entity;

/**
 * 评论类
 * 
 * @author cfy
 *
 */
public class Comment_balloon {
	private String comDetail;// 评论内容
	private int userID;// 评论用户的ID
	private int goodID;// 被评论的商品的ID

	public String getComDetail() {
		return comDetail;
	}

	public void setComDetail(String comDetail) {
		this.comDetail = comDetail;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getGoodID() {
		return goodID;
	}

	public void setGoodID(int goodID) {
		this.goodID = goodID;
	}

	public Comment_balloon() {

	}
}
