package com.balloon.entity;

/**
 * 订单类
 * 
 * @author cfy
 *
 */
public class Order_balloon {
	private int id;// 订单的ID
	private int goodID;// 商品ID
	private float paySum;// 应付金额
	private int orderUserID;// 下订单的用户ID
	private String tel;//用户的练习方式
	private String address;// 收货地址
	private int state;// 收货状态

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderUserID() {
		return orderUserID;
	}

	public void setOrderUserID(int orderUserID) {
		this.orderUserID = orderUserID;
	}

	public int getGoodID() {
		return goodID;
	}

	public void setGoodID(int goodID) {
		this.goodID = goodID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public float getPaySum() {
		return paySum;
	}

	public void setPaySum(float paySum) {
		this.paySum = paySum;
	}
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	public Order_balloon() {

	}
}
