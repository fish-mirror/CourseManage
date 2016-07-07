<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>创建院系用户</title>
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
                <form id="defaultForm" class="form-horizontal" method="post" action="college/coop_manage/addCompany.action">
            		<div class="form-group">
            			<label for="id" class="col-sm-2 control-label">用户名&emsp;</label>
			            <div class="col-sm-10">
			            	<input type="text" class="form-control" id="id" name="id">
			            </div>
            		</div>
		            <div class="form-group">
            			<label for="name" class="col-sm-2 control-label">姓&emsp;&emsp;名</label>
			            <div class="col-sm-10">
			            	<input type="text" class="form-control" id="name" name="name">
			            </div>
            		</div>
            		<div class="form-group">
            			<label for="pwd" class="col-sm-2 control-label">密&emsp;&emsp;码</label>
			            <div class="col-sm-10">
			            	<input type="password" class="form-control" id="pwd" name="pwd">
			            </div>
            		</div>
            		<div class="form-group">
            			<label for="repwd" class="col-sm-2 control-label">确认密码</label>
			            <div class="col-sm-10">
			            	<input type="password" class="form-control" id="repwd" name="repwd">
			            </div>
            		</div>
					<input type="hidden" id="institute" name="institute" value="${sessionScope.institute }">
		            <div style="color: red;">${info} </div>
	                <div class="form-group">
	                	<div class="col-sm-offset-2 col-sm-9">
	                    	<button type="submit" class="btn btn-default" onclick="createCom()">创建企业账号</button>
		                </div>
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
<script src="js/bootstrapValidator.min.js"></script> 
<script src="js/data.js"></script>  
<script>
	window.onload = initPage;
	
	//初始化界面
	function initPage(){
		navStyle();
	}
	$(document).ready(function() {
	    $('#defaultForm').bootstrapValidator({
	        message: 'This value is not valid',
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	            id: {
	                message: '无效用户名',
	                validators: {
	                    notEmpty: {
	                        message: '用户名不能为空'
	                    },
	                    stringLength: {
	                        min: 3,
	                        max: 9,
	                        message: '用户名长度必须在3-9个字符之间'
	                    },
	                    regexp: {
	                        regexp: /^[a-zA-Z0-9_]+$/,
	                        message: '用户名只能由字母、数字和下划线组成'
	                    }
	                }
	            },
	            name: {
	                validators: {
	                    notEmpty: {
	                        message: '姓名不能为空'
	                    }
	                }
	                
	            },
	            pwd: {
	                validators: {
	                    notEmpty: {
	                        message: '密码不能为空'
	                    },
	                    identical: {
	                        field: 'repwd',
	                        message: '两次密码不一致'
	                    }
	                }
	            },
	            repwd: {
	                validators: {
	                    notEmpty: {
	                        message: '确认密码不能为空'
	                    },
	                    identical: {
	                        field: 'pwd',
	                        message: '两次密码不一致'
	                    }
	                }
	            },
	        }
	    });
	});
</script>  

</html>
