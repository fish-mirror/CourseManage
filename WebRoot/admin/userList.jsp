<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>查看用户信息</title>
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
            	<ul id="select_list" class="nav nav-pills"> 
          			<li id="stu" class="active"><a href="javascript:;" onclick="getUserList(null,2,20,1)">学生用户</a></li> 
			        <li id="col" ><a href="javascript:;" onclick="getUserList(null,1,20,1)">院系用户</a></li> 
				    <div style="float:right">
			            <form class="navbar-left navbar-form" > 
			                <input id="partId" type="text" class="form-control list-search" placeholder="搜索用户名" /> 
			                <input type="button" class="btn" value="搜索学生用户名" onclick="getUserList(document.getElementById('partId').value,2,20,1)" />
			            </form> 
		            </div>
         		</ul> 
		        <div class="table-responsive"> 
          			<table class="table table-striped" > 
           				<thead> 
				            <tr> 
					            <th>用户名</th> 
					            <th>账户类型</th> 
					            <th>操作</th>
				            </tr> 
           				</thead> 
           				<tbody id="table"> 
		           		
						</tbody> 
	          		</table> 
	         	</div> 
	         	<!-- 页码 -->
         	
		        <div class="table-bottom"> 
			    	<ul id="pageDiv" class="pagination">
					</ul>
		        </div> 
            </div>
        </div>
    </div>
  </body>
<!--   如果要使用Bootstrap的js插件，必须先调入jQuery  -->
<script src="js/jquery.min.js"></script> 
<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　  -->
<script src="js/bootstrap.min.js"></script>
<script src="js/data.js"></script>  
<script>
	window.onload = initPage;
	
	//初始化界面
	function initPage(){
		navStyle();
		getUserList(null,2,20,1);
	}
</script>  

</html>
