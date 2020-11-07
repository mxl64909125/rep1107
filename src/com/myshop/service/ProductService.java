package com.myshop.service;

import com.myshop.entity.Product;
import com.myshop.util.PageUtils;

/**
 * 商品业务层接口
 * @author Admin
 *
 */
public interface ProductService {
	/**
	 * 查询指定页面商品信息
	 * @param page
	 * @return
	 */
	PageUtils findByPage(int page);
	/**
	 * 添加商品
	 * @param pro
	 * @return
	 */
	boolean save(Product pro);
	
	Product get(int pid);
	
	boolean update(Product pro);
	boolean updateStatus(int pid, int status);
}
