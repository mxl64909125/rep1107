package com.myshop.util;

import java.util.List;

/**
 * 分页工具类
 * @author Admin
 *
 */
public class PageUtils {
	private int currNo;//当前页码
	private int pageSize = 10;
	private int totalPage;//需要计算
	private int totalCount;
	private List list;
	public int getCurrNo() {
		return currNo;
	}
	public void setCurrNo(int currNo) {
		this.currNo = currNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		totalPage = totalCount%pageSize==0? totalCount/pageSize:totalCount/pageSize+1;
		return totalPage;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
}
