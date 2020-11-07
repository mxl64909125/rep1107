package com.myshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myshop.dao.TypeDao;
import com.myshop.entity.Type;
import com.myshop.util.BaseDao;
/**
 * 类别数据访问层实现类
 * @author Admin
 *
 */
public class TypeDaoImpl implements TypeDao {

	@Override
	public List<Type> findAll() {
		List<Type> list = new ArrayList<Type>();
		String sql = "select t1.tid,t1.tname,t1.tpid,t2.tname parname from type t1 left join type t2 on t1.tpid = t2.tid";
		ResultSet rs = BaseDao.query(sql, null);
		try {
			while(rs.next()){
				Type type = new Type();
				type.setTid(rs.getInt("tid"));
				type.setTname(rs.getString("tname"));
				type.setTpid(rs.getInt("tpid"));
				type.setParName(rs.getString("parname"));
				list.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close();
		}
		return list;
	}

	@Override
	public boolean findByTname(String tname) {
		boolean f = false;
		String sql = "select * from type where tname = ?";
		ResultSet rs = BaseDao.query(sql, new Object[]{tname});
		try {
			if(rs.next()){
				f = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close();
		}
		return f;
	}

	@Override
	public List<Type> findAllFirstLevel() {
		List<Type> list = new ArrayList<Type>();
		String sql = "select * from type where tpid is null";
		ResultSet rs = BaseDao.query(sql, null);
		try {
			while(rs.next()){
				Type type = new Type();
				type.setTid(rs.getInt("tid"));
				type.setTname(rs.getString("tname"));
				type.setTpid(rs.getInt("tpid"));
				list.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close();
		}
		return list;
	}

	@Override
	public int save(Type type) {
		String sql = "insert into type(tname,tpid) values(?,?)";
		return BaseDao.update(sql, new Object[]{type.getTname(),type.getTpid()==0?null:type.getTpid()});
	}

	@Override
	public int del(int tid) {
		String sql = "delete from type where tid = ?";
		return BaseDao.update(sql, new Object[]{tid});
	}

	@Override
	public List<Type> findBySecondeType(int tid) {
		List<Type> list = new ArrayList<Type>();
		String sql = "select * from type where tpid = ?";
		ResultSet rs = BaseDao.query(sql, new Object[]{tid});
		try {
			while(rs.next()){
				Type type = new Type();
				type.setTid(rs.getInt("tid"));
				type.setTname(rs.getString("tname"));
				type.setTpid(rs.getInt("tpid"));
				list.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close();
		}
		return list;
	}

}
