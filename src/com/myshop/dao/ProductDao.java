package com.myshop.dao;

import java.util.List;

import com.myshop.entity.Product;

public interface ProductDao {
	/**
	 * 根据类型找商品
	 * @param ptid
	 * @return
	 */
	List<Product> findByPtid(int ptid);
	/**
	 * 分页查询商品
	 * @param page
	 * @param size
	 * @return
	 */
	List<Product> findByPage(int page,int size);
	/**
	 * 商品数量
	 * @return
	 */
	int count();
	/**
	 * 获取商品
	 * @param pid
	 * @return
	 */
	Product get(int pid);
	/**
	 * 保存商品
	 * @param pro
	 * @return
	 */
	int save(Product pro);
	
	/**
	 * 修改商品
	 * @param pro
	 * @return
	 */
	int update(Product pro);
	/**
	 * 更改商品状态
	 * @param pid
	 * @param status
	 * @return
	 */
	int updateStatus(int pid ,int status);
}
