<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>选修课课程列表</title>
	<!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <!--你自己的样式文件 -->
    <link href="css/index.css" rel="stylesheet" />
  </head>
  
  <body>
  <%@ include file="/student/nav.jspf" %>
   <div class="container">
    <div class="container-fluid">
        <div class="row">
            <!--二级导航-->
            <%@ include file="/student/sub_nav.jspf" %>

            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            	<ul id="select_list" class="nav nav-pills"> 
         			<!-- 课程类型 -->
         			<li id="class_list" class="dropdown"><a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">课程类型<b class="caret"></b></a> 
			            <ul id="class-menu" class="dropdown-menu"> 
			            	<li><a href="javascript:;" onclick="listCourse2(0,null,null,null);"></a></li>
			            	<li><a href="javascript:;" onclick="listCourse2(1,'1',null,null);">人文社科类</a></li>
			            	<li><a href="javascript:;" onclick="listCourse2(1,'2',null,null);">公共艺术类</a></li>
			            	<li><a href="javascript:;" onclick="listCourse2(1,'3',null,null);">科学技术类</a></li>
			            	<li><a href="javascript:;" onclick="listCourse2(1,'4',null,null);">文学艺术类</a></li>
			            </ul>
          			</li> 
          			
          			<!-- 开课学院 -->
         			<li id="class_list" class="dropdown"><a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">开课学院<b class="caret"></b></a> 
			            <ul id="class-menu" class="dropdown-menu"> 
			            	<li><a href="javascript:;" onclick="listCourse2(2,'新媒体学院',null,null);">新媒体学院</a></li>
			            	<li><a href="javascript:;" onclick="listCourse2(2,'动画学院',null,null);">动画学院</a></li>
			            	<li><a href="javascript:;" onclick="listCourse2(2,'播音主持艺术学院',null,null);">播音主持艺术学院</a></li>
			            	<li><a href="javascript:;" onclick="listCourse2(2,'国际文化传播学院',null,null);">国际文化传播学院</a></li>
			            	<li><a href="javascript:;" onclick="listCourse2(2,'大学体育教学部',null,null);">大学体育教学部</a></li>
			            	<li><a href="javascript:;" onclick="listCourse2(2,'公共艺术教研室',null,null);">公共艺术教研室</a></li>
			            </ul>
          			</li> 
          			<li><a id="item"></a></li>
					<div style="float:right">
			            <form class="navbar-left navbar-form" > 
			                <input id="cname" type="text" class="form-control list-search" placeholder="搜索课程名" /> 
			                <input type="button" class="btn" value="搜索" onclick="listCourse2(5,document.getElementById('cname').value,null,null)" />
			            </form> 
		            </div>
         		</ul> 
		        <div class="table-responsive"> 
          			<table class="table table-striped" > 
           				<thead> 
				            <tr> 
					            <th width="15%">课程名</th> 
					            <th>教师</th> 
					            <th width="15%">上课时间</th>
					            <th>学分</th>
					            <th>容量</th>
					            <th>余量</th>
					            <th>课程类型</th>
					            <th>校区</th>
					            <th>开课学院</th>
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
		listCourse2(0,"",null,null);
	}
</script>  

</html>
