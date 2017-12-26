package com.balloon.biz.store;

import java.util.List;
import com.balloon.entity.Store_balloon;

/**
 * 店铺DAO接口
 * @author cfy
 *
 */
public interface StoreDAO_balloon{
public int addStore(String storeName,String mangerName,int reginID);//添加新店铺
public int delStore(String storeName);//通过店铺名称删除店铺
public int delStore(int storeID);//通过店铺id删除店铺
public int searchByname(String storeName);//查找商店名称是否存在
public int updateStore(String storeName,String newName);//通过商店名称更新商店信息
//（mangerName的更新在mangerDAO中update时已经完成,此处无需考虑）
public int updateStore(int storeID,String newName);//通过商店id更新商店信息
public int getIdByName(String storeName);//根据店铺名字获取店铺id
public String getNameByID(int storeID);//根据店铺id获取店铺名字
public List<Store_balloon> getListByreginID(int reginID);//通过区域id获取某个区域的店铺
public List<Store_balloon> getListByreginName(String reginName);//通过区域名称获取某个区域的店铺
public List<Store_balloon> getAllstore();//获取所有店铺信息
}
