package com.myshop.entity;
/**
 * 订单详情表
 * @author Admin
 *
 */
public class Item {
	/**订单条目编号*/
	private int did;
	/**所属订单编号*/
	private int oid;
	/**购买商品编号*/
	private int pid;
	/**购买商品数量*/
	private int pnum;
	/**购买商品小计*/
	private double total;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
