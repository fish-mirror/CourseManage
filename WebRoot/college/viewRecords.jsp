<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>查看选课名单</title>
	<!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <!--你自己的样式文件 -->
    <link href="css/index.css" rel="stylesheet" />
  </head>
  
  <body>
  <%@ include file="/college/nav.jspf" %>
   <div class="container">
    <div class="container-fluid">
        <div class="row">
            <!--二级导航-->
            <%@ include file="/college/sub_nav.jspf" %>

            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <div class="table-responsive"> 
          			<table class="table table-striped" > 
           				<thead> 
				            <tr> 
					            <th>学号</th> 
					            <th>姓名</th> 
					            <th>班级</th>
					            <th>联系方式</th>
				            </tr> 
           				</thead> 
           				<tbody id="table"> 
	           				<s:if test="list!=null">
								<s:iterator value="list">
									<tr> 
							            <td><s:property value="id"/></th> 
							            <td><s:property value="name"/></th> 
							            <td><s:property value="classname"/></th>
							            <td><s:property value="tel"/></th>
						            </tr> 
						         </s:iterator>
						    </s:if>
						</tbody> 
	          		</table> 
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
	}
</script>  

</html>
