<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>类别列表</title>
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
			<h3 class="box-title">类别列表</h3>
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
							<th class="sorting_asc">类别ID</th>
							<th class="sorting">类别名称</th>
							<th class="sorting">上级类别</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${typeList}" var="type" varStatus="typeStatus">
					<tr>
							<td><input type="checkbox"></td>
							<td>${typeStatus.count}</td>
							<td>${type.tname }</td>
							<td>
								<c:if test="${not empty type.parName }">【${type.parName }】</c:if>
							</td>
							<td><a type="button" href="javascript:void(0);" class="btn btn-danger btn-xs" onclick="del(${type.tid},this)">删除</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- /.box-body -->
	</div>
<script type="text/javascript">
function del(tid,obj){
		if(confirm("确定要删除吗？")){
			$.ajax({
   				"url":"typeServlet?oper=del", //请求地址
   				"type":"POST",//请求方式
   				"data":{"tid":tid},
   				"dataType":"json",//返回值类型
   				"success":function(result){ //回调
   					if(result.data == "true"){
   						$(obj).parent().parent().remove();
   						alert(result.msg);
   					}else{
   						alert(result.msg);
   					}
   				}
		});
	}
}
</script>
</body>

</html>