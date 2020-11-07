package com.myshop.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 进行数据操作的工具类
 * @author Admin
 *
 */
public class BaseDao {
	private static String url ;
	private static String username ;
	private static String password ;
	private static String driverClassName ;
	
	private static Connection con = null;
	private static PreparedStatement st = null;
	private static ResultSet rs = null;
	
	static{
		try {
			Properties p = new Properties();
			InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
			p.load(is);
			url = p.getProperty("url");
			driverClassName = p.getProperty("driver");
			username = p.getProperty("uname");
			password = p.getProperty("pwd");
			Class.forName(driverClassName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection  getConnection(){
		try {
			 con = DriverManager.getConnection(url, username, password);
			//jndi:Context  java:comp/env/
//			Context c = new InitialContext();
//			DataSource ds = (DataSource)c.lookup("java:comp/env/jdbc/shop");
//			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * 通用的查询方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public static ResultSet query(String sql,Object[] params){
		try {
			st = getConnection().prepareStatement(sql);
			//判断有参数，对?进行赋值
			if(params != null && params.length>0){
				for(int i=0;i<params.length;i++){
					st.setObject(i+1, params[i]);
				}
			}
			rs = st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * 通用的增删该的方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int update(String sql,Object[] params){
		int result = 0;
		try {
			st = getConnection().prepareStatement(sql);
			//判断有参数，对?进行赋值
			if(params != null && params.length>0){
				for(int i=0;i<params.length;i++){
					st.setObject(i+1, params[i]);
				}
			}
			
			result = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return result;
	}
	
	/**
	 * 释放资源
	 */
	public static void close(){
		
		try {
			if(rs!=null){
				rs.close();
			}
			if(st !=null){
				st.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
