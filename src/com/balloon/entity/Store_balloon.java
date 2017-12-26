package com.balloon.entity;

/**
 * 店铺类
 * 
 * @author cfy
 *
 */
public class Store_balloon {
	private int id;// 店铺ID
	private String storeName;// 店铺名称
	private String mangerName;//店铺管理员名字
	private int reginID;// 店铺所属区域ID

	public String getMangerName() {
		return mangerName;
	}

	public void setMangerName(String mangerName) {
		this.mangerName = mangerName;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getReginID() {
		return reginID;
	}

	public void setReginID(int reginID) {
		this.reginID = reginID;
	}

	public Store_balloon() {
		// TODO 自动生成的构造函数存根
	}

}
