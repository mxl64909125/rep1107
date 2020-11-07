package com.myshop.service;

import java.util.List;

import com.myshop.entity.Type;
import com.myshop.util.ResultVO;

/**
 * 类别业务层接口
 * @author Admin
 *
 */
public interface TypeService {
	
	List<Type> findAll(); 
	
	boolean findByTname(String tname);
	/**
	 * 一级目录
	 * @return
	 */
	List<Type> findAllFirstLevel();
	/**
	 * 二级目录
	 * @param tid
	 * @return
	 */
	List<Type> findSecondType(int tid);
	
	boolean save(Type type);
	/**
	 * 删除类别业务
	 * @param tid
	 * @return
	 */
	ResultVO<String> del(int tid);
}
