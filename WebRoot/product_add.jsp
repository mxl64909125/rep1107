<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'type_add.jsp' starting page</title>
    <title>商品添加</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="css/style.css">
	<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="plugins/bootstrap/js/bootstrap.min.js"></script>
  </head>
  <body class="hold-transition skin-red sidebar-mini"  >
   <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">添加商品</h3>
        </div>
	  <form class="form-horizontal" id="proForm" action="productServlet?oper=save"
	   method="post" enctype="multipart/form-data">
		  <div class="form-group">
		    <label for="firstname" class="col-sm-2 control-label">商品名称</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control"  placeholder="请输入商品名称" id="pname" name="pname">
		       <span class="text-danger" >*</span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="lastname" class="col-sm-2 control-label">所属类别</label>
		    <div class="col-sm-4">
		       <select name="parLevel" class="form-inline input-md" id="parLevel">
		       		<option value="">一级类别</option>
			     	<c:forEach items="${firstLevel}" var="type" >
			     		<option value="${type.tid }">${type.tname }</option>
			     	</c:forEach>
			    </select>
			    <select name="ptid" class="form-inline input-md" id="ptid">
			   		<option value="">二级类别</option>
			    </select>
			    <span class="text-danger" >*</span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="firstname" class="col-sm-2 control-label">商品单价</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control"  placeholder="请输入商品单价" id="price" name="price">
		       <span class="text-danger" >*</span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="firstname" class="col-sm-2 control-label">商品库存</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control"  placeholder="请输入商品库存数量" id="pcount" name="pcount">
		       <span class="text-danger" >*</span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="firstname" class="col-sm-2 control-label">商品图片</label>
		    <div class="col-sm-4">
		      <input type="file"  id="pimg" name="pimg">
		       <span class="text-danger" >*</span>
		    </div>
		  </div>
		  
		  <div class="form-group" id="parLevelDiv">
		    <label for="lastname" class="col-sm-2 control-label">商品描述</label>
		    <div class="col-sm-4">
		      	<textarea rows="5" cols="50" name="pcontent"  id="pcontent"></textarea>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <input type="submit" class="btn btn-success" value="保存" id="submitBtn"/>
			  <input type="reset" class="btn btn-default" value="重置"/>
		    </div>
		  </div>
		</form>
	</div>
	
	<script type="text/javascript">
	
		$(function(){
			//表单验证
			$("#proForm").submit(function(){
				if($("#pname").val().trim()==""){
					alert("商品名称不能为空!");
					return false;
				}
				if($("#ptid").val().trim()==""){
					alert("商品类别不能为空!");
					return false;
				}
				if($("#price").val().trim()==""){
					alert("商品单价不能为空!");
					return false;
				}
				if($("#pcount").val().trim()==""){
					alert("商品库存不能为空!");
					return false;
				}
				if($("#pimg").val().trim()==""){
					alert("商品图片没有选择!");
					return false;
				}
				if($("#pcontent").val().trim()==""){
					alert("商品描述不能为空");
					return false;
				}
				
				return true;
			});
			
			
			//商品类别的级联操作
			$("#parLevel").change(function(){
				//获取一级目录
				var tid =$("#parLevel").val();
				//清空二级目录
				$("#ptid").empty();
				if(tid != ""){
					$.ajax({
	    				"url":"typeServlet?oper=selectSecondLevel", //请求地址
	    				"type":"POST",//请求方式
	    				"data":{"tid":tid},
	    				"dataType":"json",//返回值类型
	    				"success":function(data){ //回调
	    					$.each(data,function(i,o){
	    						$("#ptid").append("<option value='"+o.tid+"'>"+o.tname+"</option>");
	    					});
	    					
	    				}
	    			});  
				}
			});
		})
	</script>
  </body>
</html>
