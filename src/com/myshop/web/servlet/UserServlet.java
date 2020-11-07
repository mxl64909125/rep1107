package com.myshop.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myshop.entity.Users;
import com.myshop.service.UserService;
import com.myshop.service.impl.UserServiceImpl;
import com.myshop.util.PageUtils;

/**
 * 用户请求控制器
 * @author Admin
 *
 */
public class UserServlet extends HttpServlet{

	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oper = request.getParameter("oper");
		if("login".equals(oper)){
			//登录处理
			login(request,response);
		}else if("list".equals(oper)){
			//查询所有
			list(request,response);
		}else if("disable".equals(oper)){
			//禁用用户
			disable(request,response);
		}else if("enable".equals(oper)){
			//启用用户
			enable(request,response);
		}else if("reset".equals(oper)){
			//重置用户
			reset(request,response);
		}
		
	}
	/**
	 * 重置密码
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void reset(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		boolean f = userService.updatePwd(uid);
		response.sendRedirect("userServlet?oper=list");
		
	}
	/**
	 * 启用用户
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void enable(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		userService.updateStatus(uid, 0);
		response.sendRedirect("userServlet?oper=list");
		
	}
	/**
	 * 禁用用户
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void disable(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		userService.updateStatus(uid, 1);
		response.sendRedirect("userServlet?oper=list");
		
	}
	/**
	 * 用户信息分页
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		int pageno = page==null?1:Integer.parseInt(page);
		PageUtils pu = userService.findByPage(pageno);
		request.setAttribute("userPage", pu);
		request.getRequestDispatcher("user_list.jsp").forward(request, response);
		
	}

	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uaccount = request.getParameter("uaccount");
		String upwd = request.getParameter("upwd");
		Users user = userService.get(uaccount, upwd);
		HttpSession session = request.getSession();
		if(user ==null){
			session.setAttribute("loginError", "用户名或密码错误!");
			response.sendRedirect("login.jsp");
		}else{
			session.setAttribute("loginUser", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}
	
}
