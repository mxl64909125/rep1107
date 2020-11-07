<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>用户列表</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="plugins/bootstrap/js/bootstrap.min.js"></script>

</head>

<body class="hold-transition skin-red sidebar-mini">
	<!-- .box-body -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">用户列表</h3>
		</div>

		<div class="box-body">

			<!-- 数据表格 -->
			<div class="table-box">

				<!--工具栏-->
				<!--  <div>
             	<button type="button" class="btn btn-default btn-xs">btn-default</button>
             	<button type="button" class="btn btn-primary btn-xs">btn-primary</button> 
             	<button type="button" class="btn btn-success btn-xs">btn-success</button> 
             	<button type="button" class="btn btn-info btn-xs">btn-info</button> 
             	<button type="button" class="btn btn-warning btn-xs">btn-warning</button>  
             	<button type="button" class="btn btn-danger btn-xs">btn-danger</button> 
             </div>	 -->
				<div class="box-tools pull-right">
					<div class="has-feedback">
						名称：<input> 店铺名称： <input>
						<button class="btn btn-default">查询</button>
					</div>
				</div>
				<!--工具栏/-->

				<!--数据列表-->
				<table id="dataList"
					class="table table-bordered table-striped table-hover dataTable">
					<thead>
						<tr>
							<th class="" style="padding-right:0px"><input id="selall"
								type="checkbox" class="icheckbox_square-blue"></th>
							<th class="sorting_asc">用户ID</th>
							<th class="sorting">用户账号</th>
							<th class="sorting">昵称</th>
							<th class="sorting">邮箱</th>
							<th class="sorting">出生日期</th>
							<th class="sorting">角色</th>
							<th class="sorting">状态</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userPage.list}" var="user"
							varStatus="userStatus">
							<tr>
								<td><input type="checkbox">
								</td>
								<td>${userStatus.count}</td>
								<td>${user.uaccount }</td>
								<td>${user.uname }</td>
								<td>${user.uemail }</td>
								<td>${user.ubirthday }</td>
								<td><c:if test="${user.urole == 0}">
										<sapn class="text-success">会员</sapn>
									</c:if> <c:if test="${user.urole == 1}">
										<span class="text-danger">管理员</span>
									</c:if></td>
								<td><c:if test="${user.ustatus == 0}">
										<a class="btn btn-danger btn-xs"
											href="userServlet?oper=disable&uid=${user.uid}">禁用</a>
									</c:if> <c:if test="${user.ustatus == 1}">
										<a class="btn btn-success btn-xs"
											href="userServlet?oper=enable&uid=${user.uid}">启用</a>
									</c:if></td>
								<td class="text-center"><a class="btn btn-warning btn-xs"
									href="userServlet?oper=reset&uid=${user.uid}">重置密码</a></td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="9" align="right"><c:if
									test="${userPage.currNo > 1}">
									<a href="userServlet?oper=list&page=1" class="btn btn-default"
										title="首页"><i class="fa fa-file-o"></i> 首页</a>
									<a href="userServlet?oper=list&page=${userPage.currNo-1 }"
										class="btn btn-default" title="上一页"><i
										class="fa fa-trash-o"></i> 上一页</a>
								</c:if> <c:if test="${userPage.currNo < userPage.totalPage}">
									<a href="userServlet?oper=list&page=${userPage.currNo+1 }"
										class="btn btn-default" title="下一页"><i
										class="fa fa-check"></i> 下一页</a>
									<a href="userServlet?oper=list&page=${userPage.totalPage }"
										class="btn btn-default" title="末页"><i class="fa fa-check"></i>
										末页</a>
								</c:if></td>
						</tr>
					</tfoot>
				</table>
				<!--数据列表/-->
			</div>
			<!-- 数据表格 /-->
		</div>
	</div>
	<!-- /.box-body -->
</body>

</html>