package com.balloon.entity;

/**
 * 会员信息类
 * 
 * @author cfy
 *
 */
public class MemberInfo_balloon {
	private int id;// 会员ID
	private String memberName;// 会员名
	private String pwd;// 会员密码
	private int authority;// 权限1

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
}
