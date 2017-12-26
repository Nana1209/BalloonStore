package com.balloon.entity;

/**
 * 商品类
 * 
 * @author cfy
 *
 */

public class Goods_balloon {
	private int id;// 商品的id
	private int storeID;// 商品所属店铺的id
	private int reginID;//商品所属区域的id
	private String goodName;// 商品名称
	private float goodPrice;// 单品价格
	private int stockNum;// 库存量
	private int salesNum;// 已销售量
	private int praiseNum;// 好评数
	private int badReviewNum;// 差评数

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public float getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(float goodPrice) {
		this.goodPrice = goodPrice;
	}

	public int getStockNum() {
		return stockNum;
	}

	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}

	public int getSalesNum() {
		return salesNum;
	}

	public void setSalesNum(int salesNum) {
		this.salesNum = salesNum;
	}

	public int getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(int praiseNum) {
		this.praiseNum = praiseNum;
	}

	public int getBadReviewNum() {
		return badReviewNum;
	}

	public void setBadReviewNum(int badReviewNum) {
		this.badReviewNum = badReviewNum;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public int getReginID() {
		return reginID;
	}

	public void setReginID(int reginID) {
		this.reginID = reginID;
	}

	
	public Goods_balloon() {
		// TODO 自动生成的构造函数存根
	}
}
