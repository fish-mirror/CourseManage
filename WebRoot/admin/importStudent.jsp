<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>批量导入学生用户</title>
	<!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <!--你自己的样式文件 -->
    <link href="css/index.css" rel="stylesheet" />
  </head>
  
  <body>
  <%@ include file="/admin/nav.jspf" %>
   <div class="container">
    <div class="container-fluid">
        <div class="row">
            <!--二级导航-->
            <%@ include file="/admin/sub_nav.jspf" %>

            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> 
      			<form action="admin/importInfo.action"  method="post" enctype="multipart/form-data"> 
       				<input id="lefile" type="file" style="display:none" /> 
      				<h2>批量录入学生信息（请上传xls文件）</h2> 
       				<div class="modal-body">
				    	<input type="file" name="xls" id="xls"  value="选择文件" />  
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<input type="submit" class="btn btn-primary" value="上传">
					</div>
      			</form> 
			</div> 
        </div>
    </div>
  </body>
  <!-- 如果要使用Bootstrap的js插件，必须先调入jQuery --> 
<script src="js/jquery.min.js"></script> 
<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　--> 
<script src="js/bootstrap.min.js"></script>
<script src="js/data.js"></script>  
<script>
	window.onload = initPage;
	
	//初始化界面
	function initPage(){
		navStyle();
	}
</script>  

</html>
