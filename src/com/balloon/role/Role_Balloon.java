package com.balloon.role;

import java.util.Scanner;

import com.balloon.biz.manger.MangerDAOImpl_balloon;
import com.balloon.biz.manger.MangerDAO_balloon;
import com.balloon.biz.member.MemberDao_balloon;

/**
 * 角色类 通过用户名密码是否为空和权限的取值确定角色类型
 * 
 * @author cfy
 *
 */
public class Role_Balloon {
	String userName = null;// 用户名类型
	int authority = 0;// 权限 —— 0：游客；1：会员；2：店铺管理员；3：淘宝管理员
	Scanner input = new Scanner(System.in);
	MangerDAO_balloon mag=new MangerDAOImpl_balloon();
	MemberDao_balloon mem=new MemberDao_balloon();
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public Role_Balloon() {
	
	}
	public Role_Balloon(String userName,int authority) {
		this.userName=userName;
		this.authority=authority;
	}
	
	
	
	

	
	
	
	
	
}
