package com.balloon.role.ext;

import java.util.Scanner;

import com.balloon.biz.manger.MangerDAOImpl_balloon;
import com.balloon.biz.manger.MangerDAO_balloon;
import com.balloon.entity.MangerInfo_balloon;
import com.balloon.role.Role_Balloon;

/**
 * 管理员操作管理类
 * 
 * @author cfy
 *
 */
public class Manger_balloon extends Role_Balloon {
	Scanner input = new Scanner(System.in);
	MangerDAO_balloon mag=new MangerDAOImpl_balloon();
	MangerInfo_balloon manger=null;
	public Manger_balloon() {
		// TODO 自动生成的构造函数存根
		this.setUserName("管理员");
		this.setAuthority(2);
	}
	
	/**
	 * 管理员登录
	 */
	public boolean mangerLogin(){
		boolean isSuc=false;
		System.out.print("输入管理员名字：");
		String userName=input.next();
		System.out.print("输入密码");
		String password=input.next();
		//MemberDao_balloon mem=new MemberDao_balloon();
		
		//String realPwd=mem.findPwdByName(userName);
		String realPwd=mag.getPassword(userName);
		if(password.equals(realPwd)){
			System.out.println("来啦，管理员"+userName);
			manger=new MangerInfo_balloon();
			this.setAuthority(2);
			isSuc=true;
		}else if(realPwd==null){
			System.out.println("管理员不存在");
		}
		return isSuc;
	}
	
	/**
	 * 显示本店商品
	 */
	public void showGoods(){
		return;
	}
	
	/**
	 * 新增商品
	 * @return
	 */
	public boolean addGoods(){
		boolean isSuc=false;
		System.out.print("输入新增商品名称：");
		String newGoosName=input.next();
		System.out.print("输入新增商品库存：");
		int newGoosStock=input.nextInt();
		System.out.print("输入新增商品类型(1.服装 2.食品 3.日化 4.电子产品)：");
		int newGoodsType=input.nextInt();
		//
		return isSuc;
	}
	
	/**
	 * 删除（下架）商品
	 * @return
	 */
	public boolean delGoods(){
		boolean isSuc=false;
		System.out.print("输入下架商品ID：");
		int delGoosID=input.nextInt();
		//
		return isSuc;
	}
	
	/**
	 * 商品入库
	 * @return
	 */
	public boolean addGoodsStock(){
		boolean isSuc=false;
		System.out.print("输入入库商品ID：");
		int addGoodsStockID=input.nextInt();
		System.out.print("输入入库商品数量：");
		int addGoodsStockNum=input.nextInt();
		//
		return isSuc;
	}
	
	/**
	 * 商品出库
	 * @return
	 */
	public boolean delGoodsStock(){
		boolean isSuc=false;
		System.out.print("输入出库商品ID：");
		int delGoodsStockID=input.nextInt();
		System.out.print("输入出库商品数量：");
		int delGoodsStockNum=input.nextInt();
		//
		return isSuc;
	}
	
}
