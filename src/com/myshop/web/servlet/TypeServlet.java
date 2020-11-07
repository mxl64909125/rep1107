package com.myshop.web.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.myshop.entity.Type;
import com.myshop.service.TypeService;
import com.myshop.service.impl.TypeServiceImpl;
import com.myshop.util.ResultVO;

public class TypeServlet extends HttpServlet {

	private TypeService ts = new TypeServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oper = request.getParameter("oper");
		if("list".equals(oper)){
			list(request,response);
		}else if("checkName".equals(oper)){
			checkName(request,response);
		}else if("selectFirstLevel".equals(oper)){
			selectFirstLevel(request,response);
		}else if("save".equals(oper)){
			save(request,response);
		}else if("del".equals(oper)){
			del(request,response);
		}else if("selectSecondLevel".equals(oper)){
			selectSecondLevel(request,response);
		}
	}
	/**
	 * 获取二级目录
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void selectSecondLevel(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int tid = Integer.parseInt(request.getParameter("tid"));
		List<Type> list  = ts.findSecondType(tid);
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(list));
		out.flush();
		out.close();
		
	}
	/**
	 * 删除类别
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int tid = Integer.parseInt(request.getParameter("tid"));
		
		ResultVO<String> rv = ts.del(tid);
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(rv));
		out.flush();
		out.close();
		
		
	}
	/**
	 * 保存类别
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取类别名称
		String tname = request.getParameter("tname");
		//获取上级类别编号
		String tpid = request.getParameter("tpid");
		int pid = tpid==null||tpid.equals("")?0:Integer.parseInt(tpid);
		Type type = new Type();
		type.setTname(tname);
		type.setTpid(pid);
		boolean f = ts.save(type);
		if(f){
			//成功
			response.sendRedirect("typeServlet?oper=list");
		}else{
			response.sendRedirect("type_add.jsp");
		}
		
	}
	/**
	 * 检索一级分类
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void selectFirstLevel(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<Type> firstList = ts.findAllFirstLevel();
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(firstList));
		out.flush();
		out.close();
		
	}
	/**
	 * 验证类别名称
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void checkName(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String tname = request.getParameter("tname");
		boolean f = ts.findByTname(tname);
		Map<String,Object> map = new HashMap<String,Object>();
		if(f){
			map.put("status", "true");
		}else{
			map.put("status", "false");
		}
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(map));
		out.flush();
		out.close();
		
	}
	/**
	 * 类别列表
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Type> list = ts.findAll();
		request.setAttribute("typeList", list);
		request.getRequestDispatcher("type_list.jsp").forward(request, response);
	}
}
