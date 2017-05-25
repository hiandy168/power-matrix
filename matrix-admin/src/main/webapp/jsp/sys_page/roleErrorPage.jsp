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
		                <h1>Update in Progress</h1>
		
		                <h3>Please come back again soon as we're working on the issue now.</h3>
		
		                <p>Sorry this site is temporarily unavailable while an essential software update is being performed.
		                    <br/>Please try again in an hour or less when the update should be complete.</p>
		                <br/>
		                <button class="stdbtn btn_black" onclick="history.back()">Go Back to Previous Page</button>
		                &nbsp;
		                <button onclick="location.href='dashboard.html'" class="stdbtn btn_orange">Go Back to Dashboard</button>
		            </div>
		            <!--errorcontent-->
		        </div>
		        <!--errorwrapper-->
		    </div>
        </div>
    </div>

</body>
</html>










