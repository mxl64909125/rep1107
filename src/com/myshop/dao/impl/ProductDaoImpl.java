package com.myshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myshop.dao.ProductDao;
import com.myshop.entity.Product;
import com.myshop.entity.Type;
import com.myshop.util.BaseDao;
import com.myshop.util.DateUtils;

public class ProductDaoImpl implements ProductDao{

	@Override
	public List<Product> findByPtid(int ptid) {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product where ptid = ?";
		ResultSet rs = BaseDao.query(sql, new Object[]{ptid});
		try {
			while(rs.next()){
				Product pro = new Product();
				pro.setPid(rs.getInt("pid"));
				pro.setPcount(rs.getInt("pcount"));
				pro.setPcreateTime(rs.getString("pcreateTime"));
				pro.setPendTime(rs.getString("pendTime"));
				pro.setPcontent(rs.getString("pcontent"));
				pro.setPimg(rs.getString("pimg"));
				pro.setPname(rs.getString("pname"));
				pro.setPrice(rs.getDouble("price"));
				pro.setPstatus(rs.getInt("pstatus"));
				pro.setPtid(rs.getInt("ptid"));
				
				list.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close();
		}
		return list;
	}

	@Override
	public List<Product> findByPage(int page, int size) {
		List<Product> list = new ArrayList<Product>();
		String sql = "select p.*,t.tname as typeName from product p inner join type t on p.ptid = t.tid limit ?,?";
		ResultSet rs = BaseDao.query(sql, new Object[]{(page-1)*size,size});
		try {
			while(rs.next()){
				Product pro = new Product();
				pro.setPid(rs.getInt("pid"));
				pro.setPcount(rs.getInt("pcount"));
				pro.setPcreateTime(rs.getString("pcreateTime"));
				pro.setPendTime(rs.getString("pendTime"));
				pro.setPcontent(rs.getString("pcontent"));
				pro.setPimg(rs.getString("pimg"));
				pro.setPname(rs.getString("pname"));
				pro.setPrice(rs.getDouble("price"));
				pro.setPstatus(rs.getInt("pstatus"));
				pro.setPtid(rs.getInt("ptid"));
				pro.setTypeName(rs.getString("typeName"));
				list.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close();
		}
		return list;
	}

	@Override
	public int count() {
		int result = 0;
		String sql = "select count(*) from product";
		ResultSet rs = BaseDao.query(sql, null);
		try {
			while(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close();
		}
		return result;
	}

	@Override
	public Product get(int pid) {
		Product pro = null;
		String sql = "select * from product where pid = ?";
		ResultSet rs = BaseDao.query(sql, new Object[]{pid});
		try {
			while(rs.next()){
				pro = new Product();
				pro.setPid(rs.getInt("pid"));
				pro.setPcount(rs.getInt("pcount"));
				pro.setPcreateTime(rs.getString("pcreateTime"));
				pro.setPendTime(rs.getString("pendTime"));
				pro.setPcontent(rs.getString("pcontent"));
				pro.setPimg(rs.getString("pimg"));
				pro.setPname(rs.getString("pname"));
				pro.setPrice(rs.getDouble("price"));
				pro.setPstatus(rs.getInt("pstatus"));
				pro.setPtid(rs.getInt("ptid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close();
		}
		return pro;
	}

	@Override
	public int save(Product pro) {
		String sql = "insert into product(pname,ptid,price,pcount,pcontent,pimg,pstatus,pcreateTime,pendTime)" +
				" values(?,?,?,?,?,?,?,?,?)";
		return BaseDao.update(sql, new Object[]{
				pro.getPname(),
				pro.getPtid(),
				pro.getPrice(),
				pro.getPcount(),
				pro.getPcontent(),
				pro.getPimg(),
				pro.getPstatus(),
				pro.getPcreateTime(),
				pro.getPendTime()
		});
	}

	@Override
	public int update(Product pro) {
		
		String sql = "update product set pname =? ,ptid =?,price = ?, pcount =?,pcontent = ?,pimg = ?,pstatus = ?,pendTime=? where pid = ?";
		return BaseDao.update(sql, new Object[]{
				pro.getPname(),
				pro.getPtid(),
				pro.getPrice(),
				pro.getPcount(),
				pro.getPcontent(),
				pro.getPimg(),
				pro.getPstatus(),
				pro.getPendTime(),
				pro.getPid()
		});
	}

	@Override
	public int updateStatus(int pid, int status) {
		String sql = "update product set pstatus = ?,pendTime=? where pid = ?";
		return BaseDao.update(sql, new Object[]{
				status,
				DateUtils.getCurrDate(),
				pid
		});
	}


}
