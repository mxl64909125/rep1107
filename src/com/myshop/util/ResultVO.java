package com.myshop.util;
/**
 * 返回给前端的数据信息
 * @author Admin
 *
 * @param <T>
 */
public class ResultVO<Z> {
	private int code;//状态码， 0：正确，1：错误
	private Z data; // 数据信息
	private String msg;//提示信息
	
	public ResultVO() {
	}
	
	public ResultVO(int code, Z data, String msg) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	public ResultVO(int code, Z data) {
		
		this.code = code;
		this.data = data;
		
	}
	
	public ResultVO(int code, String msg) {
			this.code = code;
			this.msg = msg;
		
	}
	// =========================================================
	
	// {"code":0,"data":xxx}
	public static <T> ResultVO success(T data){
		return new ResultVO(0,data);
	}
	// {"code":0,"msg":"xxx"}
	public static ResultVO success(String msg){
		return new ResultVO(0,msg);
	}
	
	// {"code":0,"msg":"xxx","data":xxx}
	public static ResultVO success(Object data,String msg){
		return new ResultVO(0,data,msg);
	}
	
	public static ResultVO fail(String msg){
		return new ResultVO(1,msg);
	}
	
	
	// ===========================================================
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Z getData() {
		return data;
	}
	public void setData(Z data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
