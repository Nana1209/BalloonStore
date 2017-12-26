package com.balloon.biz.manger;

import java.util.List;

import com.balloon.entity.MangerInfo_balloon;

/**
 * 管理员类DAO接口
 * 
 * @author cfy
 *
 */

public interface MangerDAO_balloon {
	public int addManger(String mangerName, String password , String storeName);// 新增管理员

	public int deleteManger(int idTodel);// 根据ID删除管理员,店铺删除之后调用此函数
	
	public int deleteManger(String nameTodel);//根据名称删除管理员
	public int deleteMangerByStore(String store) ;
	public int updateManger(int idToUpdate, String mangerName, String password);// 更新编号为ID的管理员信息
	//此函数已经完成了店铺中mangerName的更新
    public int updateManger(String oldName,String newName,String password);//更新姓名为oldName的管理员信息
	//此函数已经完成了店铺中mangerName的更新
	public String getNameByID(int mangerID);//根据id返回对应的管理员姓名
	
	public int getIdByName(String mangerName);//根据管理员名字获取管理员id
	
	public String getStoreName(int mangerId);//根据管理员id获取店铺名字
	
	public String getStoreName(String mangerName);//根据管理员名字获取店铺名字
	
	public int getLoginID(String mangerName, String password);// 根据用户名和密码查找对应管理员ID，若未找到返回0

	public int getCount();// 获取表中元素的个数（管理员个数）

	public List<MangerInfo_balloon> getMangerList();

	public MangerInfo_balloon getinfoByID(int idTofind);// 根据ID来查看管理员的详细信息

	public String getPassword(String mangerName);// 查找用户名是否存在，存在返回密码，不存在返回null
}
