package com.balloon.role.ext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.balloon.biz.manger.MangerDAOImpl_balloon;
import com.balloon.biz.manger.MangerDAO_balloon;
import com.balloon.biz.store.StoreDAOImpl_balloon;
import com.balloon.biz.store.StoreDAO_balloon;
import com.balloon.entity.Store_balloon;
import com.balloon.role.Role_Balloon;
/**
 * 淘宝管理员类
 * @author xinna
 *
 */
public class Boss_balloon extends Role_Balloon {
	Scanner input = new Scanner(System.in);
	MangerDAO_balloon mag=new MangerDAOImpl_balloon();
	StoreDAO_balloon sto=new StoreDAOImpl_balloon();
	public Boss_balloon() {
		// TODO 自动生成的构造函数存根
		this.setUserName("淘宝管理员");
		//this.setAuthority(3);
	}
	
	public boolean bossLogin(){
		boolean isSuc=false;
		System.out.print("输入姓名：");
		String name=input.next();
		System.out.print("输入密码：");
		String password=input.next();
		if(name.equals("balloon") && password.equals("noollab")){
			this.setAuthority(3);
			isSuc=true;
			System.out.println("老大好！");
		}else{
			System.out.println("登录失败");
			
		}
		return isSuc;
	}
	/**
	 * 添加管理员
	 * @return true(添加成功）
	 */
	public boolean addManger(){
		boolean isSuc=false;
		int hasMng=0;//0为不存在
		int hasStore=1;//1为店铺存在
		String name=null;
		String store=null;
		do{
			System.out.print("输入管理员姓名：");
			name=input.next();
			hasMng=mag.getIdByName(name);
			if(hasMng!=0){
				System.out.println("该管理员已存在");
			}
		}while(hasMng!=0);
		System.out.print("输入管理员密码：");
		String password=input.next();
		do{
			System.out.print("输入所属店铺：");
			store=input.next();
			hasStore=sto.searchByname(store);
			if(hasStore==0){
				System.out.println("该店铺不存在");
			}
		}while(hasStore==1);
		
		if(mag.addManger(name, password,store)==1){
			System.out.println("管理员添加成功");
			isSuc=true;
		}else{
			System.out.println("管理员添加失败");
		}
		return isSuc;
	}
	
	/**
	 * 删除管理员
	 * @return
	 */
	public boolean delManger(){
		boolean isSuc=false;
		System.out.print("输入要删除的管理员名字：");
		String nameTodel=input.next();
		if(0!=mag.deleteManger(nameTodel)){
			System.out.println("管理员删除成功");
		}else{
			System.out.println("管理员删除失败");
		}
		return isSuc;
	}
	
	/**
	 * 添加店铺
	 */
	public void addStore(){
		int has=0;
		int isSuc=0;
		String storeName=null;
		do{
			System.out.print("输入新增店铺名称：");
			storeName=input.next();
			has=sto.searchByname(storeName);
			if(has==1){
				System.out.println("店铺名已占用");
			}
		}while(has==1);
		this.addManger();
		isSuc=sto.addStore(storeName, 0);
		if(isSuc==1){
			System.out.println("店铺添加成功");
		}else{
			System.out.println("店铺添加失败");
		}
		return;
	}
	
	/**
	 * 删除店铺
	 */
	public void deleStore(){
		int has=0;
		int isSuc=0;
		String storeName=null;
		do{
			System.out.print("输入删除店铺名称：");
			storeName=input.next();
			has=sto.searchByname(storeName);
			if(has==0){
				System.out.println("没有该店铺");
			}
		}while(has==0);
		isSuc=sto.delStore(storeName);
		mag.deleteMangerByStore(storeName);
		if(isSuc==1){
			System.out.println("店铺删除成功");
		}else{
			System.out.println("店铺删除失败");
		}
		return;
	}
	
	/**
	 * 修改店铺名称
	 */
	public void modifyStore(){
		int has=0;
		int isSuc=0;
		String storeName=null;
		do{
			System.out.print("输入要修改的店铺名称：");
			storeName=input.next();
			has=sto.searchByname(storeName);
			if(has==0){
				System.out.println("没有该店铺");
			}
		}while(has==0);
		System.out.print("输入新店铺名称：");
		String newName=input.next();
		isSuc=sto.updateStore(storeName, newName);
		if(isSuc==1){
			System.out.println("店铺改名成功");
		}else{
			System.out.println("店铺改名失败");
		}
		return;
	}
	
	public void showStore(){
		List<Store_balloon> stores = new ArrayList<Store_balloon>();
		stores=sto.getAllstore();
		for(int i=0;i<stores.size();i++){
			System.out.println(stores.get(i).getStoreName());
		}
		return;
	}
}
