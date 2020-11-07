package com.myshop.entity;
/**
 * 商品类型表
 * @author Admin
 *
 */
public class Type {
	/**类型编号*/
	private int tid;
	/**类型名称*/
	private String tname;
	/**上级编号*/
	private int tpid;
	/**上级类别名称（冗余）*/
	private String parName;
	
	public String getParName() {
		return parName;
	}
	public void setParName(String parName) {
		this.parName = parName;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTpid() {
		return tpid;
	}
	public void setTpid(int tpid) {
		this.tpid = tpid;
	}
	
}
