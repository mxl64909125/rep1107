package com.myshop.dao;

import java.util.List;

import com.myshop.entity.Users;

/**
 * 用户数据访问层接口
 * @author Admin
 *
 */
public interface UserDao {
	/**
	 * 根据账号和密码查询用户
	 * @param uaccount
	 * @param upwd
	 * @return
	 */
	Users get(String uaccount,String upwd);
	/**
	 * 分页查询用户信息
	 * @param page
	 * @param size
	 * @return
	 */
	List<Users> findByPage(int page,int size);
	/**
	 * 查询总记录数
	 * @return
	 */
	int count();
	/**
	 * 重置密码
	 * @param uid
	 * @return
	 */
	int updatePwd(int uid);
	/**
	 * 更改状态
	 * @param uid
	 * @return
	 */
	int updateStatus(int uid,int status);
	
}
