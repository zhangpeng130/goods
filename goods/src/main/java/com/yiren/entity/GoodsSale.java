package com.yiren.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品销售记录表
 * 
 * @author peng
 *
 */
public class GoodsSale implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 购买人
	 */
	private String buyer;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 住址
	 */
	private String address;
	/**
	 * 联系方式
	 */
	private String phone;
	/**
	 * 销售员
	 */
	private String seller;
	private BigDecimal price;
	/**
	 * 欠款
	 */
	private BigDecimal debt;
	/**
	 * 还款
	 */
	private BigDecimal repay;
	private String remark;
	private Date buyTime;
	private Date createTime;
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDebt() {
		return debt;
	}

	public void setDebt(BigDecimal debt) {
		this.debt = debt;
	}

	public BigDecimal getRepay() {
		return repay;
	}

	public void setRepay(BigDecimal repay) {
		this.repay = repay;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
