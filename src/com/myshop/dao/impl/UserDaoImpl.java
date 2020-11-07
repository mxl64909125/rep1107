package com.myshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myshop.dao.UserDao;
import com.myshop.entity.Users;
import com.myshop.util.BaseDao;
import com.myshop.util.MD5Utils;
/**
 * 用户数据访问层实现类
 * @author Admin
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public Users get(String uaccount, String upwd) {
		String sql = "select * from users where uaccount=? and upwd = ? and urole=1 and ustatus =0";
		ResultSet rs = BaseDao.query(sql, new Object[]{uaccount,MD5Utils.getMd5(upwd)});
		Users user = null;
		try {
			if(rs.next()){
				user  = new Users();
				user.setUaccount(rs.getString("uaccount"));
				user.setUaddress(rs.getString("uaddress"));
				user.setUbirthday(rs.getString("ubirthday"));
				user.setUcard(rs.getString("ucard"));
				user.setUcreateTime(rs.getString("ucreateTime"));
				user.setUemail(rs.getString("uemail"));
				user.setUendTime(rs.getString("uendTime"));
				user.setUid(rs.getInt("uid"));
				user.setUimg(rs.getString("uimg"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
				user.setUrole(rs.getInt("urole"));
				user.setUstatus(rs.getInt("ustatus"));
			}
		} catch (SQLException e) {
			System.out.println("-----UserDao.get(String uaccount, String upwd)----login fail!");
			e.printStackTrace();
		}finally{
			BaseDao.close();
		}
		return user;
	}

	@Override
	public List<Users> findByPage(int page, int size) {
		List<Users> list = new ArrayList<Users>();
		String sql = "select * from users limit ?,?";
		ResultSet rs = BaseDao.query(sql, new Object[]{(page-1)*size,size});
		
		try {
			while(rs.next()){
				Users user = new Users();
				user.setUaccount(rs.getString("uaccount"));
				user.setUaddress(rs.getString("uaddress"));
				user.setUbirthday(rs.getString("ubirthday"));
				user.setUcard(rs.getString("ucard"));
				user.setUcreateTime(rs.getString("ucreateTime"));
				user.setUemail(rs.getString("uemail"));
				user.setUendTime(rs.getString("uendTime"));
				user.setUid(rs.getInt("uid"));
				user.setUimg(rs.getString("uimg"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
				user.setUrole(rs.getInt("urole"));
				user.setUstatus(rs.getInt("ustatus"));
				
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println("-----UserDao.findByPage(int page, int size)----error!");
			e.printStackTrace();
		}finally{
			BaseDao.close();
		}
		return list;
	}

	@Override
	public int count() {
		String sql = "select count(*) from users";
		ResultSet rs = BaseDao.query(sql, null);
		int result = 0;
		try {
			if(rs.next()){
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
	public int updatePwd(int uid) {
		String sql = "update users set upwd = ? where uid =?";
		return BaseDao.update(sql, new Object[]{"000000",uid});
	}

	@Override
	public int updateStatus(int uid,int status) {
		String sql = "update users set ustatus = ? where uid =?";
		return BaseDao.update(sql, new Object[]{status,uid});
	}

}
