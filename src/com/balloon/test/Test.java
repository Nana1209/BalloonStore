package com.balloon.test;

import com.balloon.biz.member.MemberDao_balloon;
import com.balloon.role.Role_Balloon;
import com.balloon.role.ext.Boss_balloon;
import com.balloon.role.ext.Manger_balloon;
import com.balloon.role.ext.Member_balloon;
import com.balloon.menu.*;
public class Test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		// MangerDAO_balloon manger = new MangerDAOImpl_balloon();
		// System.out.println(manger.getPassword("管理员1"));
		//ReginDAO_balloon reginDAO_balloon = new ReginDAOImpl_balloon();
		//reginDAO_balloon.addRegin("美妆");
		//System.out.println(reginDAO_balloon.getID("美妆"));
		//System.out.println(reginDAO_balloon.getReginCount());
		//System.out.println(reginDAO_balloon.getReginName(4));
		//List<GoodRegin_balloon> goodRegin_balloons = null;
		//goodRegin_balloons = reginDAO_balloon.getReginList();
		//System.out.println(goodRegin_balloons.size());
		//reginDAO_balloon.updateByID(1, "百货");
		//reginDAO_balloon.updateByName("百货", "杂货");
		//MemberDao_balloon memDao=new MemberDao_balloon();
		//Role_Balloon role=new Member_balloon();
		//((Member_balloon) role).memberLogin();
		//((Member_balloon) role).memberSignIn();
		//Role_Balloon role1=new Manger_balloon();
		//Role_Balloon role2=new Boss_balloon();
		//((Manger_balloon)role1).mangerLogin();
		//((Boss_balloon)role2).addManger();
		//((Boss_balloon)role2).delManger();
		Menu_balloon menu=new Menu_balloon();
		
		menu.mainMenu();
		System.exit(0);
	}
}
