package com.myshop.service;

import java.util.List;

import com.myshop.entity.Users;
import com.myshop.util.PageUtils;

/**
 * 用户业务层接口
 * @author Admin
 *
 */
public interface UserService {
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
	PageUtils findByPage(int page);
	
	/**
	 * 重置密码
	 * @param uid
	 * @return
	 */
	boolean updatePwd(int uid);
	/**
	 * 更改状态
	 * @param uid
	 * @return
	 */
	boolean updateStatus(int uid,int status);
	
}
