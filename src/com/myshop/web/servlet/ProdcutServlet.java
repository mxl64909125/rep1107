package com.myshop.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.myshop.entity.Product;
import com.myshop.entity.Type;
import com.myshop.service.ProductService;
import com.myshop.service.TypeService;
import com.myshop.service.impl.ProductServiceImpl;
import com.myshop.service.impl.TypeServiceImpl;
import com.myshop.util.PageUtils;

/**
 * 商品模块处理请求处理器
 * 
 * @author Admin
 * 
 */
public class ProdcutServlet extends HttpServlet {

	private ProductService proService = new ProductServiceImpl();

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String oper = request.getParameter("oper");
		if ("list".equals(oper)) {
			// 商品列表
			list(request, response);
		} else if ("save".equals(oper)) {
			// 保存商品
			save(request, response);
		}else if ("toAdd".equals(oper)) {
			// 进入商品添加操作
			toAdd(request, response);
		}else if ("select".equals(oper)) {
			// 查看单个商品
			select(request, response);
		}else if ("update".equals(oper)) {
			// 更新商品
			update(request, response);
		}else if ("updateStatus".equals(oper)) {
			// 更新商品状态
			updateStatus(request, response);
		}
	}
	
	private void updateStatus(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		int status = Integer.parseInt(request.getParameter("status"));
		boolean f = proService.updateStatus(pid,status);
		if(f){
			response.sendRedirect("productServlet?oper=list");
		}else{
			response.sendRedirect("productServlet?oper=select&pid="+pid);
		}
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String path = request.getSession().getServletContext()
				.getRealPath("/upload/");
		// 1. 判断form是否支持文件上传
		if (ServletFileUpload.isMultipartContent(request)) {
			// 2. 解析request
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(factory);
			try {
				List<FileItem> items = sfu.parseRequest(request);
				//查询单个商品信息
				int pid = 0;
				for(int i = 0; i < items.size(); i++){
					FileItem item = items.get(i);
					if (item.isFormField()) {
						String name = item.getFieldName();
					
						if (name.equals("pid")) { //获取商品名称
							pid =Integer.parseInt(item.getString("UTF-8"));
						}
					}
				}
				Product pro = proService.get(pid);
				
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
					// 普通字段
					if (item.isFormField()) {
						String name = item.getFieldName();
					
						if (name.equals("pname")) { //获取商品名称
							String pname = item.getString("UTF-8");
							pro.setPname(pname);
						} else if (name.equals("ptid")) { //商品类别
							int ptid =Integer.parseInt(item.getString("UTF-8"));
							pro.setPtid(ptid);
						} else if (name.equals("price")) { //商品单价
							double price =Double.parseDouble(item.getString("UTF-8"));
							pro.setPrice(price);
						} else if (name.equals("pcount")) { //商品库存
							int pcount = Integer.parseInt(item.getString("UTF-8"));
							pro.setPcount(pcount);
						}else if (name.equals("pcontent")) { //商品描述
							String  pcontent = item.getString("UTF-8");
							pro.setPcontent(pcontent);
						}
					} else {
						// 文件字段
						String filePath = item.getName();
						if (filePath != null && !filePath.equals("")) {
							// 使用UUID保证文件名称唯一
							String suffix = filePath.substring(filePath.lastIndexOf("."));
							String fileName = UUID.randomUUID().toString() + suffix;
							File target = new File(path, fileName);
							try {
								item.write(target);
								pro.setPimg(fileName);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
				boolean f = proService.update(pro);
				if(f){
					response.sendRedirect("productServlet?oper=list");
				}else{
					response.sendRedirect("productServlet?oper=select&pid="+pid);
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		} else {
			throw new RuntimeException("表单不支持文件上传!");
		}
	}

	private void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询单个商品信息
		int pid = Integer.parseInt(request.getParameter("pid"));
		Product pro = proService.get(pid);
		request.setAttribute("pro", pro);
		TypeService ts = new TypeServiceImpl();
		//查询所有的一级目录
		List<Type> list = ts.findAllFirstLevel();
		request.setAttribute("firstLevel", list);
		request.getRequestDispatcher("product_update.jsp").forward(request, response);
		
	}

	private void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TypeService ts = new TypeServiceImpl();
		//查询所有的一级目录
		List<Type> list = ts.findAllFirstLevel();
		request.setAttribute("firstLevel", list);
		request.getRequestDispatcher("product_add.jsp").forward(request, response);
	}

	/***
	 * 保存商品
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取服务器保存上传文件的目录信息
		String path = request.getSession().getServletContext()
				.getRealPath("/upload/");
		Product pro = new Product();
		// 1. 判断form是否支持文件上传
		if (ServletFileUpload.isMultipartContent(request)) {
			// 2. 解析request
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(factory);
			try {
				List<FileItem> items = sfu.parseRequest(request);
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
					// 普通字段
					if (item.isFormField()) {
						String name = item.getFieldName();
					
						if (name.equals("pname")) { //获取商品名称
							String pname = item.getString("UTF-8");
							pro.setPname(pname);
						} else if (name.equals("ptid")) { //商品类别
							int ptid =Integer.parseInt(item.getString("UTF-8"));
							pro.setPtid(ptid);
						} else if (name.equals("price")) { //商品单价
							double price =Double.parseDouble(item.getString("UTF-8"));
							pro.setPrice(price);
						} else if (name.equals("pcount")) { //商品库存
							int pcount = Integer.parseInt(item.getString("UTF-8"));
							pro.setPcount(pcount);
						}else if (name.equals("pcontent")) { //商品描述
							String  pcontent = item.getString("UTF-8");
							pro.setPcontent(pcontent);
						}
					} else {
						// 文件字段
						String filePath = item.getName();
						if (filePath != null && !filePath.equals("")) {
							// 使用UUID保证文件名称唯一
							String suffix = filePath.substring(filePath.lastIndexOf("."));
							String fileName = UUID.randomUUID().toString() + suffix;
							File target = new File(path, fileName);
							try {
								item.write(target);
								pro.setPimg(fileName);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
				boolean f = proService.save(pro);
				if(f){
					response.sendRedirect("productServlet?oper=list");
				}else{
					response.sendRedirect("product_add.jsp");
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		} else {
			throw new RuntimeException("表单不支持文件上传!");
		}

	}

	/**
	 * 商品分页列表
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		int pageno = page == null ? 1 : Integer.parseInt(page);
		PageUtils pu = proService.findByPage(pageno);
		request.setAttribute("proPage", pu);
		request.getRequestDispatcher("product_list.jsp").forward(request,
				response);

	}
}
