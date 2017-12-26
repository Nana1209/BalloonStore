package com.balloon.entity;

/**
 * 
 * @author cfy
 *
 */
public class MangerInfo_balloon {
	private int id;// 管理员ID
	private String mangerName;// 管理员名
	private String pwd;// 管理员密码
	private String storeName;//管理的店铺名称
	private int authority;// 权限2

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMangerName() {
		return mangerName;
	}

	public void setMangerName(String mangerName) {
		this.mangerName = mangerName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public MangerInfo_balloon() {
		this.authority = 2;
	}
}
