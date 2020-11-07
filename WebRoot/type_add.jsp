<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'type_add.jsp' starting page</title>
    <title>类别添加</title>
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
            <h3 class="box-title">添加分类</h3>
        </div>
	  <form class="form-horizontal" action="typeServlet?oper=save" method="post">
		  <div class="form-group">
		    <label for="firstname" class="col-sm-2 control-label">类别名称</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control"  placeholder="请输入类别名称" id="tname" name="tname">
		       <span class="text-danger" id="checkNameMsg">*</span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="firstname" class="col-sm-2 control-label">类别级别</label>
		    <div class="col-sm-10">
		    	<label class="radio-inline">
		      		<input type="radio" value="" name="typeLevel" checked="checked">一级    
		    	</label>
		    	<label class="radio-inline">
		     		<input type="radio" value="" name="typeLevel">二级
		      	</label>
		    </div>
		  </div>
		  <div class="form-group" id="parLevelDiv">
		    <label for="lastname" class="col-sm-2 control-label">上级类别</label>
		    <div class="col-sm-4">
		       <select name="tpid" class="form-control input-md" id="tpid">
			     	
			    </select>
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
			$("#submitBtn").attr("disabled","disabled");
			//对类别名称进行验证
			$("#tname").blur(function(){
				var tname = $("#tname").val();
    			 $.ajax({
    				"url":"typeServlet?oper=checkName", //请求地址
    				"type":"POST",//请求方式
    				"data":{"tname":tname},
    				"dataType":"json",//返回值类型
    				"success":function(data){ //回调
    					if(data.status=="true"){
    						$("#checkNameMsg").removeClass("text-success").addClass("text-danger").html("*不可用");
    						$("#submitBtn").attr("disabled","disabled");
    					}else{
    						$("#checkNameMsg").removeClass("text-danger").addClass("text-success").html("*可用");
    						$("#submitBtn").removeAttr("disabled");
    					}
    					
    				}
    			});  
			
			});
			
			
			//类别等级切换
			$("#parLevelDiv").hide();
			$("input[name='typeLevel']").click(function(){
				//判断哪一个单选按钮被选中
				if($(this).attr("checked")=="checked"){//一级
					$("#parLevelDiv").hide();
				}else{//二级
					$("#parLevelDiv").show();
					$("#tpid").empty();
					$.ajax({
	    				"url":"typeServlet?oper=selectFirstLevel", //请求地址
	    				"type":"POST",//请求方式
	    				"data":{},
	    				"dataType":"json",//返回值类型
	    				"success":function(data){ //回调
	    					$.each(data,function(i,o){
	    						$("#tpid").append("<option value='"+o.tid+"'>"+o.tname+"</option>");
	    					});
	    					
	    				}
	    			});  
				}
			
			});
		
		})
	</script>
  </body>
</html>
