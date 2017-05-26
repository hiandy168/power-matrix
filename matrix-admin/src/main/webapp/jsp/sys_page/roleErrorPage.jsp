<%@ include file="/inc/resource.inc" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="/inc/head.jsp" %>
</head>

<body class="withvernav">

    <div class="bodywrapper">
		<%@ include file="/inc/top.jsp" %>
		<%@ include file="/inc/left.jsp" %>

        <div class="centercontent">
		    <div class="contentwrapper padding10">
		        <div class="errorwrapper error403">
		            <div class="errorcontent">
		                <h1>服务访问拒绝</h1>
		
		                <h3>服务器拒绝了您的访问功能，原因如下：</h3>
		
		                <p>
		                	您可能没有这个权限来访问您在浏览器地址栏中直接输入的路径。 如果您想获得这个功能的使用权请联系系统管理员，他会为您分<br/>
		                    配这个权限。权限分配完成后请退出系统并重新登录即可！
	                    </p><br/>
		                <button class="stdbtn btn_black" onclick="history.back()">返回上一页</button>
		                &nbsp;
		                <button onclick="location.href='/matrix-admin/index.jsp'" class="stdbtn btn_orange">回到首页</button>
		            </div>
		            <!--errorcontent-->
		        </div>
		        <!--errorwrapper-->
		    </div>
        </div>
    </div>

</body>
</html>










