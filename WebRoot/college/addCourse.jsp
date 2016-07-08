<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>添加/编辑课程</title>
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
            	<form id="defaultForm" class="form-horizontal" method="post" action="college/addCourse.action">
            		<div class="form-group">
            			<label for="name" class="col-sm-2 control-label">课程名称</label>
			            <div class="col-sm-10">
			            	<input type="text" class="form-control" id="name" name="name">
			            </div>
            		</div>
		            <div class="form-group">
            			<label for="type" class="col-sm-2 control-label">课程类型</label>
			            <div class="col-sm-10">
						 	<select name="type" class="form-control input-sm">
						 		<option id="0" value="0"> </option>
						    	<option id="1" value="1">人文社科类</option>
						    	<option id="2" value="2">公共艺术类</option>
						    	<option id="3" value="3">科学技术类</option>
						    	<option id="4" value="4">文学艺术类</option>
						    </select>
						 </div>
            		</div>
            		<div class="form-group">
            			<label for="teacher" class="col-sm-2 control-label">授课老师</label>
			            <div class="col-sm-10">
			            	<input type="text" class="form-control" id="teacher" name="teacher">
			            </div>
            		</div>
            		<div class="form-group">
            			<label for="time" class="col-sm-2 control-label">上课时间</label>
			           	<div class="col-sm-10">
						 	<input type="text" class="form-control" id="time" name="time"
						 		placeholder="格式同周四第6,7节{第1-16周}，若有多个时间段用`;`隔开" >
						 </div>
            		</div>
            		<div class="form-group">
            			<label for="institute" class="col-sm-2 control-label">开课学院</label>
			            <div class="col-sm-10">
			            	<input type="text" class="form-control" id="institute" name="institute">
			            </div>
            		</div>
            		<div class="form-group">
            			<label for="place" class="col-sm-2 control-label">上课校区</label>
			            <div class="col-sm-10">
			            	<input type="text" class="form-control" id="place" name="place"
			            	placeholder="下沙/桐乡" >
			            </div>
            		</div>
            		<div class="form-group">
            			<label for="score" class="col-sm-2 control-label">学&emsp;&emsp;分</label>
			            <div class="col-sm-10">
			            	<input type="text" class="form-control" id="score" name="score">
			            </div>
            		</div>
            		<div class="form-group">
            			<label for="num" class="col-sm-2 control-label">容&emsp;&emsp;量</label>
			            <div class="col-sm-10">
			            	<input type="text" class="form-control" id="num" name="num">
			            </div>
            		</div>
            		<div class="form-group">
            			<label for="remark" class="col-sm-2 control-label">备&emsp;&emsp;注</label>
			            <div class="col-sm-10">
			            	<input type="text" class="form-control" id="remark" name="remark">
			            </div>
            		</div>
					<div style="color: red;">${info} </div>
	                <div class="form-group">
	                	<div class="col-sm-offset-2 col-sm-9">
	                    	<button type="submit" class="btn btn-default" >添加/编辑课程</button>
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
		var id = ${param.id };
		if(id!=null && id != "")
			getCourse(id);
		
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
	            name: {
	                validators: {
	                    notEmpty: {
	                        message: '课程名不能为空'
	                    },
	                }
	            },
	            teacher: {
	                validators: {
	                    notEmpty: {
	                        message: '授课老师不能为空'
	                    }
	                }
	                
	            },
	            time: {
	                validators: {
	                    notEmpty: {
	                        message: '上课时间不能为空'
	                    }
	                }
	            },
	            institute: {
	                validators: {
	                    notEmpty: {
	                        message: '开课学院不能为空'
	                    }
	                }
	            },
	            place: {
	                validators: {
	                    notEmpty: {
	                        message: '上课校区不能为空'
	                    }
	                }
	            },
	            score: {
	                validators: {
		                notEmpty: {
		                        message: '学分不能为空'
		                },
	                    regexp: {
	                        regexp: /^[0-4]\.[0,5]$/,
	                        message: '请输入有效学分值，为不超过4.5的一位小数'
	                    }
	                }
	                
	            },
	            num: {
	                validators: {
		                notEmpty: {
		                        message: '容量不能为空'
		                },
	                    regexp: {
	                        regexp: /[0-9]/,
	                        message: '只能由数字组成'
	                    }
	                }
	            },
	        }
	    });
	});
</script>  

</html>
