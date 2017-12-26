package com.balloon.role.ext;

import java.util.Scanner;

import com.balloon.biz.member.MemberDao_balloon;
import com.balloon.entity.MemberInfo_balloon;
import com.balloon.role.Role_Balloon;

/**
 * 会员操作管理类
 * 
 * @author cfy
 *
 */
public class Member_balloon extends Role_Balloon {
	public MemberInfo_balloon member=null;
	Scanner input = new Scanner(System.in);
	MemberDao_balloon mem=new MemberDao_balloon();
	public Member_balloon() {
		this.setUserName("会员");
		this.setAuthority(1);
	}
	
	/**
	 * 用户登录,登录成功返回true
	 */
	public boolean memberLogin(){
		boolean isSucc = false;//是否登录成功
		System.out.print("输入用户名：");
		String userName=input.next();
		System.out.print("输入密码");
		String password=input.next();
		
		//MangerDAO_balloon mag=new MangerDAOImpl_balloon();
		String realPwd=mem.findPwdByName(userName);
		//String realPwd=mag.getPassword(userName);
		if(password.equals(realPwd)){
			System.out.println(userName+"欢迎您");
			this.setAuthority(1);
		
			member=new MemberInfo_balloon();
			member.setAuthority(1);
			member.setMemberName(userName);
			member.setId(mem.getID(userName));
			isSucc=true;
		}else if(realPwd==null){
			System.out.println("用户不存在");
		}else if(!password.equals(realPwd) && realPwd!=null){
			System.out.println("密码输入错误");
		}
		
		return isSucc;
	}
	
	/**
	 * 用户注册
	 */
	public void memberSignIn(){
		boolean hasMember=false;
		String memberName=null;
		do{
			hasMember=false;
			System.out.print("请输入用户名：");
			memberName=input.next();
			if(0!=mem.hasMember(memberName)){
				System.out.println("该用户名已被占用");
				hasMember=true;
			}
					
		}while(hasMember);
		System.out.print("请输入密码：");
		String password=input.next();
		if(1==mem.addMember(memberName, password)){
			System.out.println("注册成功");
		}else{
			System.out.println("注册失败");
		}
			
	}
	
	/**
	 * 用户退出登录
	 */
	public void memberQuit(){
		
	}
	
	/**
	 * 注销账号
	 */
	public void memberDele(){
		
	}
}
