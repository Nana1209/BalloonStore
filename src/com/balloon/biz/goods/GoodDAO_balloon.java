package com.balloon.biz.goods;

import java.util.List;
import com.balloon.entity.MangerInfo_balloon;

/**
 * 商品类DAO接口
 * 
 * @author cfy
 *
 */
public interface GoodDAO_balloon {
	public int addGood();// 添加一个商品

	public int deleteGood(String goodID);// 新增管理员

	public int deleteManger(int idTodel);// 根据ID删除管理员

	public int updateManger(int idToUpdate, String mangerName, String password);// 更新编号为ID的管理员信息

	public int getLoginID(String mangerName, String password);// 根据用户名和密码查找对应管理员ID，若未找到返回0

	public int getCount();// 获取表中元素的个数（管理员个数）

	public List<MangerInfo_balloon> getMangerList();

	public MangerInfo_balloon getinfoByID(int idTofind);// 根据ID来查看管理员的详细信息
}
