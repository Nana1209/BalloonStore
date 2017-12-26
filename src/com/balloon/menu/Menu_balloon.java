package com.balloon.menu;

import java.util.Scanner;

import com.balloon.role.Role_Balloon;
import com.balloon.role.ext.Boss_balloon;
import com.balloon.role.ext.Manger_balloon;
import com.balloon.role.ext.Member_balloon;
/**
 * 菜单类
 * @author xinna
 *
 */
public class Menu_balloon {
	Scanner input = new Scanner(System.in);
	Role_Balloon role=null;
	
	/**
	 * 主菜单
	 */
	public void mainMenu(){
		boolean isSuc=false;
		int rt=1;
		do{
		System.out.println("======欢迎光临balloon======");
		System.out.println("请选择：");
		System.out.println("1.随便逛逛");
		System.out.println("2.会员登录");
		System.out.println("3.会员注册");
		System.out.println("4.管理员登录");
		System.out.println("5.商场管理员登录");
		int choose=input.nextInt();
		switch(choose){
		case 1:
			//
			this.showGoodsMenu();
			rt=0;
			break;
		case 2:
			role=new Member_balloon();
			isSuc=((Member_balloon)role).memberLogin();
			if(isSuc){
				//进入用户菜单
				this.memMenu();
				rt=0;
			}else{
				rt=this.isreturn();
			}
			break;
		case 3:
			role=new Member_balloon();
			((Member_balloon)role).memberSignIn();
			rt=this.isreturn();
			break;
		case 4:
			role=new Manger_balloon();
			((Manger_balloon)role).mangerLogin();
			if(isSuc){
				//进入管理员菜单
				this.mngMenu();
			}else{
				rt=this.isreturn();
			}
			break;
		case 5:
			
			role=new Boss_balloon();
			isSuc=((Boss_balloon) role).bossLogin();
			if(isSuc){
				//进入boss菜单
				this.bossMenu();
				rt=0;
			}else{
				rt=this.isreturn();
			}
			break;
		default:
			System.out.println("输入错误");
		}
		}while(rt==0);
	
	}
	/**
	 * 返回上一级，返回0为返回上一级
	 * @return
	 */
	public int isreturn(){
		System.out.println("输入0返回上一级");
		int isr=input.nextInt();
		return isr;
	}
	
	public void memMenu(){
		int rmemMenu=1;
		do{
			System.out.println("1.浏览商品");
			System.out.println("2.查看订单");
			System.out.println("3.签收订单");
			System.out.println("0.返回上一级");
			int choose=input.nextInt();
			switch(choose){
			case 0:
				return;
			case 1:
				this.showGoodsMenu();
				rmemMenu=0;
				break;
			case 2:
				//System.out.println(((Member_balloon)role).member.getId());
				rmemMenu=this.isreturn();
				break;
			case 3:
				//
				rmemMenu=this.isreturn();
				break;
			default:
				System.out.println("输入错误");
			}
		}while(rmemMenu==0);
	}
	
	public void bossMenu(){
		int choose=0;
		int rebossM=1;
		do{
			System.out.println("老大今天干点啥？");
			System.out.println("1.新增店铺");
			System.out.println("2.删除店铺");
			System.out.println("3.修改店铺");
			System.out.println("4.查看店铺");
			System.out.println("5.新增管理员");
			System.out.println("6.删除管理员");
			System.out.println("0.返回上一级");
			choose=input.nextInt();
			switch(choose){
			case 1:
				((Boss_balloon) role).addStore();
				rebossM=0;
				break;
			case 2:
				((Boss_balloon) role).deleStore();
				rebossM=0;
				break;
			case 3:
				((Boss_balloon) role).modifyStore();
				rebossM=0;
				break;
			case 4:
				((Boss_balloon) role).showStore();
				rebossM=this.isreturn();
				break;
			case 5:
				((Boss_balloon) role).addManger();
				rebossM=0;
				break;
			case 6:
				((Boss_balloon) role).delManger();
				rebossM=0;
				break;
			case 0:
				return;
			default:
				System.out.println("输入错误");
				rebossM=0;
			}
		}while(rebossM==0);
	}
	
	public void mngMenu(){
		int rMngM=1;
		do{
			System.out.println("1.查看本店商品");
			System.out.println("2.商品入库");
			System.out.println("3.商品出库");
			System.out.println("4.新增商品");
			System.out.println("5.商品下架");
			System.out.println("0.返回上一级");
			System.out.println("请选择：");
			int choose=input.nextInt();
			
			switch (choose){
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 0:
				return;
			default:
				System.out.println("输入错误");
				rMngM=this.isreturn();
			}
		}while(rMngM==0);
	}
	
	public void showGoodsMenu(){
		int rSGM=1;
		do{
			System.out.println("1.根据店铺查看商品");
			System.out.println("2.根据类型查看商品");
			System.out.println("0.返回上一级");
			System.out.print("请选择：");
			int choose=input.nextInt();
			switch(choose){
			case 0:
				return;
			case 1:
				//
				break;
			case 2:
				//
				break;
			default:
				System.out.println("输入错误");
				rSGM=this.isreturn();
			}
		}while(rSGM==0);
	}
}
