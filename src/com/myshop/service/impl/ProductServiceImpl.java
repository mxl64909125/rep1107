package com.myshop.service.impl;

import java.util.Date;

import com.myshop.dao.ProductDao;
import com.myshop.dao.impl.ProductDaoImpl;
import com.myshop.entity.Product;
import com.myshop.service.ProductService;
import com.myshop.util.DateUtils;
import com.myshop.util.PageUtils;
/**
 * 商品业务层实现类
 * @author Admin
 *
 */
public class ProductServiceImpl implements ProductService {

	private ProductDao proDao = new ProductDaoImpl();
	@Override
	public PageUtils findByPage(int page) {
		PageUtils pu = new PageUtils();
		pu.setCurrNo(page);
		pu.setTotalCount(proDao.count());
		pu.setList(proDao.findByPage(page, pu.getPageSize()));
		return pu;
	}
	@Override
	public boolean save(Product pro) {
		//添加商品时，默认商品状态都为“上架”:1
		pro.setPstatus(1);
		//创建时间，默认为当前时间
		pro.setPcreateTime(DateUtils.getCurrDate());
		return proDao.save(pro) > 0;
	}
	@Override
	public Product get(int pid) {
		// TODO Auto-generated method stub
		return proDao.get(pid);
	}
	@Override
	public boolean update(Product pro) {
		pro.setPendTime(DateUtils.getCurrDate());
		return proDao.update(pro) >0;
	}
	@Override
	public boolean updateStatus(int pid, int status) {
		// TODO Auto-generated method stub
		return proDao.updateStatus(pid, status) > 0;
	}

}
