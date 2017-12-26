package com.balloon.biz.regin;

import java.util.List;

import com.balloon.entity.GoodRegin_balloon;

/**
 * 商品区域接口类
 * @author cfy
 * 商品区域只能增加不能减少
 */
public interface ReginDAO_balloon {
  public int addRegin(String reginName);//添加新区
  public int updateByName(String reginName,String newName);//根据名字查找并修改区域名称
  public int updateByID(int reginID,String newName);//根据ID查找并修改区域名称
  public int getID(String reginName);//根据区域名字获取区域id
  public String getReginName(int reginID);//根据区域id获取区域名字
  public int getReginCount();//获取区域总数
  public List<GoodRegin_balloon> getReginList();//获取所有区域信息并保存在泛型集合中
}
