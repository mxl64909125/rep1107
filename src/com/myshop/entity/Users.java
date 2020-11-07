package com.myshop.entity;
/**
 * 用户类
 * @author Admin
 * @version 1.0
 * @time 2020-10-5
 */
public class Users {
	/**用户编号*/
	private int uid;
	/**账号*/
	private String uaccount;
	/**密码*/
	private String upwd;
	/**昵称*/
	private String uname;
	/**邮箱*/
	private String uemail;
	/**身份证号*/
	private String ucard;
	/**地址*/
	private String uaddress;
	/**出生日期*/
	private String ubirthday;
	/**头像*/
	private String uimg;
	/**角色:（0-会员，1-管理员）*/
	private int urole = 0;
	/**（0-正常，1-禁用）*/
	private int ustatus = 0;
	/**创建时间*/
	private String ucreateTime;
	/**最后一次修改时间*/
	private String uendTime;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUaccount() {
		return uaccount;
	}
	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUcard() {
		return ucard;
	}
	public void setUcard(String ucard) {
		this.ucard = ucard;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getUbirthday() {
		return ubirthday;
	}
	public void setUbirthday(String ubirthday) {
		this.ubirthday = ubirthday;
	}
	public String getUimg() {
		return uimg;
	}
	public void setUimg(String uimg) {
		this.uimg = uimg;
	}
	public int getUrole() {
		return urole;
	}
	public void setUrole(int urole) {
		this.urole = urole;
	}
	public int getUstatus() {
		return ustatus;
	}
	public void setUstatus(int ustatus) {
		this.ustatus = ustatus;
	}
	public String getUcreateTime() {
		return ucreateTime;
	}
	public void setUcreateTime(String ucreateTime) {
		this.ucreateTime = ucreateTime;
	}
	public String getUendTime() {
		return uendTime;
	}
	public void setUendTime(String uendTime) {
		this.uendTime = uendTime;
	}
	
	
	
	
}
