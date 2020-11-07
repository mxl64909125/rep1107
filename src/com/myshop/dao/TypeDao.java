package com.myshop.dao;

import java.util.List;

import com.myshop.entity.Type;

/**
 * 类别数据访问层接口
 * @author Admin
 *
 */
public interface TypeDao {
	
	List<Type> findAll(); 
	
	boolean findByTname(String tname);
	
	List<Type> findAllFirstLevel();
	
	int save(Type type);
	
	int del(int tid);
	
	List<Type> findBySecondeType(int tid);

}
