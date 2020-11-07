package com.myshop.service.impl;

import java.util.List;

import com.myshop.dao.ProductDao;
import com.myshop.dao.TypeDao;
import com.myshop.dao.impl.ProductDaoImpl;
import com.myshop.dao.impl.TypeDaoImpl;
import com.myshop.entity.Product;
import com.myshop.entity.Type;
import com.myshop.service.TypeService;
import com.myshop.util.ResultVO;
/**
 * 类别业务访问层实现类
 * @author Admin
 *
 */
public class TypeServiceImpl implements TypeService {
	private TypeDao td = new TypeDaoImpl();
	private ProductDao pd = new ProductDaoImpl();

	@Override
	public List<Type> findAll() {
		return td.findAll();
	}

	@Override
	public boolean findByTname(String tname) {
		return td.findByTname(tname);
	}

	@Override
	public List<Type> findAllFirstLevel() {
		// TODO Auto-generated method stub
		return td.findAllFirstLevel();
	}

	@Override
	public boolean save(Type type) {
		
		return td.save(type)>0;
	}

	@Override
	public ResultVO<String> del(int tid) {
		ResultVO<String> rv = new ResultVO<String>();
		rv.setCode(0);
		
		
		boolean f = true;
		//查询一级下面是否有二级
		List<Type> secondList = td.findBySecondeType(tid);
		if(secondList.size()>0){
			f = false;
			rv.setData("false");
			rv.setMsg("删除失败!该分类下有二级类别!");
		}
		
		//查询二级分类下是否有商品
		List<Product> proList = pd.findByPtid(tid);
		if(proList.size()>0){
			f = false;
			rv.setData("false");
			rv.setMsg("删除失败!该分类下有商品信息!");
		}
		
		if(f){
			td.del(tid);
			//可用删除
			rv.setData("true");
			rv.setMsg("删除成功!");
		}
		
		return rv;
	}

	@Override
	public List<Type> findSecondType(int tid) {
		return td.findBySecondeType(tid);
	}

}
