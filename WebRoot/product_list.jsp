<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>商品列表</title>
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
			<h3 class="box-title">商品列表</h3>
		</div>

		<div class="box-body">

			<!-- 数据表格 -->
			<div class="table-box">
				<!--数据列表-->
				<table id="dataList"
					class="table table-bordered table-striped ">
					<thead>
						<tr>
							<th class="" style="padding-right:0px"><input id="selall"
								type="checkbox" class="icheckbox_square-blue"></th>
							<th class="sorting_asc">商品ID</th>
							<th class="sorting">商品名称</th>
							<th class="sorting">类别</th>
							<th class="sorting">单价</th>
							<th class="sorting">库存</th>
							<th class="sorting">状态</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${proPage.list}" var="pro"
							varStatus="proStatus">
						<tr>
							<td><input type="checkbox"></td>
							<td>${proStatus.count }</td>
							<td>
							<a href="productServlet?oper=select&pid=${pro.pid }">
								<img src="upload/${pro.pimg}" width="40px" height="40px"/>${pro.pname }
							</a>
							</td>
							<td>${pro.typeName}</td>
							<td>${pro.price}￥</td>
							<td>${pro.pcount }件</td>
							<td>
								<c:if test="${pro.pstatus == 2 }">
									<span class="text-danger">【热卖】</span>
								</c:if>
								<c:if test="${pro.pstatus == 1 }">
									<span class="text-success">【上架】</span>
								</c:if>
								<c:if test="${pro.pstatus == 0 }">
									<span class="text-warning">【下架】</span>
								</c:if>
							</td>
							<td>
							<!-- 下架 -->
						      <c:if test="${pro.pstatus == 0 }">
						      	<input type="button" class="btn btn-info" value="上架" onclick="updateStatus(${pro.pid},1)"/>
						      </c:if>
						      <!-- 上架 -->
						      <c:if test="${pro.pstatus == 1 }">
						      	<input type="button" class="btn btn-warning" value="热卖" onclick="updateStatus(${pro.pid},2)"/>
						      	<input type="button" class="btn btn-danger" value="下架" onclick="updateStatus(${pro.pid},0)"/>
						      </c:if>
						      <!-- 热卖 -->
						      <c:if test="${pro.pstatus == 2 }">
						      	<input type="button" class="btn btn-danger" value="下架" onclick="updateStatus(${pro.pid},0)"/>
						      </c:if>
							</td>
						</tr>
					</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="9" align="right"><c:if
									test="${proPage.currNo > 1}">
									<a href="productServlet?oper=list&page=1" class="btn btn-default"
										title="首页"><i class="fa fa-file-o"></i> 首页</a>
									<a href="productServlet?oper=list&page=${proPage.currNo-1 }"
										class="btn btn-default" title="上一页"><i
										class="fa fa-trash-o"></i> 上一页</a>
								</c:if> <c:if test="${proPage.currNo < proPage.totalPage}">
									<a href="productServlet?oper=list&page=${proPage.currNo+1 }"
										class="btn btn-default" title="下一页"><i
										class="fa fa-check"></i> 下一页</a>
									<a href="productServlet?oper=list&page=${proPage.totalPage }"
										class="btn btn-default" title="末页"><i class="fa fa-check"></i>
										末页</a>
								</c:if></td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		<!-- /.box-body -->
	</div>
<script type="text/javascript">
	function updateStatus(pid,status){
			location.href = "productServlet?oper=updateStatus&pid="+pid+"&status="+status;
	}
</script>
</body>

</html>