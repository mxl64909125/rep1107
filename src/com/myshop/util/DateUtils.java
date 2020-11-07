package com.myshop.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author Admin
 *
 */
public class DateUtils {
	/**
	 * 获取当前时间（yyyy-MM-dd）
	 * @return
	 */
	public static String getCurrDate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	/**
	 * 获取当前时间（yyyy-MM-dd HH:mm:ss）
	 * @return
	 */
	public static String getCurrDateTime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 获取当前时间
	 * @param pattern 自定义时间格式
	 * @return
	 */
	public static String getCurrDateTime(String pattern){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
}
