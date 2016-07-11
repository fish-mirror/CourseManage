<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Software caused connection abort: recv failed</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        .bg{
            position:absolute;
            z-index:-1;
        }
        h4,label{color:#434343;}
        .login{
            padding:10px 20px 0px;
            border-color:#bfbfbf;
            border-style:solid;
            border-width:thin;
            border-radius:5px
        }
    </style>
</head>

<body>

<div class="container" style="min-width:800px">
    Software caused connection abort: recv failed
</div>
</body>
</html>