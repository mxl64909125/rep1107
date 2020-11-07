package com.myshop.service.impl;

import com.myshop.dao.UserDao;
import com.myshop.dao.impl.UserDaoImpl;
import com.myshop.entity.Users;
import com.myshop.service.UserService;
import com.myshop.util.PageUtils;
/**
 * 用户业务层实现类
 * @author Admin
 *
 */
public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();

	@Override
	public Users get(String uaccount, String upwd) {
		
		return userDao.get(uaccount, upwd);
	}

	@Override
	public PageUtils findByPage(int page) {
		PageUtils pu = new PageUtils();
		pu.setCurrNo(page);
		pu.setTotalCount(userDao.count());
		pu.setList(userDao.findByPage(page, pu.getPageSize()));
		return pu;
	}

	@Override
	public boolean updatePwd(int uid) {
		int result = userDao.updatePwd(uid);
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStatus(int uid,int status) {
		int result = userDao.updateStatus(uid, status);
		if(result > 0){
			return true;
		}
		return false;
	}


}
