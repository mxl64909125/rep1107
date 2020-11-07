package com.myshop.entity;
/**
 * 商品信息表
 * @author Admin
 *
 */
public class Product {
	/**商品编号*/
	private int pid;
	/**商品名称*/
	private String pname;
	/**商品类型编号*/
	private int ptid;
	/**商品类别名称（冗余）*/
	private String typeName;
	/**商品单价*/
	private double price;
	/**商品库存*/
	private int pcount;
	/**商品描述*/
	private String pcontent;
	/**商品图片*/
	private String pimg;
	/**商品状态：（0-下架，1-上架，2-热卖）*/
	private int pstatus;
	/**创建时间*/
	private String pcreateTime;
	/**最后一次修改时间*/
	private String pendTime;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPtid() {
		return ptid;
	}
	public void setPtid(int ptid) {
		this.ptid = ptid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPcount() {
		return pcount;
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public int getPstatus() {
		return pstatus;
	}
	public void setPstatus(int pstatus) {
		this.pstatus = pstatus;
	}
	public String getPcreateTime() {
		return pcreateTime;
	}
	public void setPcreateTime(String pcreateTime) {
		this.pcreateTime = pcreateTime;
	}
	public String getPendTime() {
		return pendTime;
	}
	public void setPendTime(String pendTime) {
		this.pendTime = pendTime;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
