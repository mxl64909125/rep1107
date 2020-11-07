package com.myshop.entity;
/**
 * 订单类
 * @author Admin
 *
 */
public class Order {
	/**订单编号*/
	private int oid;
	/**所属用户*/
	private int uid;
	/**订单生成时间*/
	private String ocreateTime;
	/**订单状态：(0-已支付，1-已发货，2-已完成)*/
	private int ostatus;
	/**订单总金额*/
	private double total;
	/**订单最后一次修改时间*/
	private String oendTime;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getOcreateTime() {
		return ocreateTime;
	}
	public void setOcreateTime(String ocreateTime) {
		this.ocreateTime = ocreateTime;
	}
	public int getOstatus() {
		return ostatus;
	}
	public void setOstatus(int ostatus) {
		this.ostatus = ostatus;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getOendTime() {
		return oendTime;
	}
	public void setOendTime(String oendTime) {
		this.oendTime = oendTime;
	}
	
}
