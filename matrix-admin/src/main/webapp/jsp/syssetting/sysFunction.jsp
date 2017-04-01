<%@ include file="/inc/resource.inc" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="/inc/head.jsp" %>
	
	<link rel="stylesheet" href="${css}/ztree/zTreeStyle.css" type="text/css" />
	
	<%-- <script type="text/javascript" src="${js}/jquery-1.10.2.js"></script> --%>
    <script type="text/javascript" src="${js}/utils/ajaxs.js"></script>
    
	<script type="text/javascript" src="${js}/ztree/jquery.ztree.all.js"></script>
    <script type="text/javascript" src="${js}/system/sys_function.js"></script>

    <style type="text/css">
        .tree-left{
            border: solid #FB9337 2px;
            height: 100%;
            width: 30%; 
            float: left;
        }
        .tree-right{
            border: solid #78CE07 2px;
            height: 100%;
            width: 30%;
            margin-right: 400px;
            float: right;
            position:relative;
        }
        .right-padding{
            padding-top: 10px;
            padding-bottom: 10px;
        }
        .right-size{
            height: 25px;
            width: 200px;
        }
        .a-btn{
        	cursor: pointer;
        	color:#FB9337; 
        }
        .a-btn:hover {
        	color: red;
       	}
    </style>

    <script type="text/javascript">

        $(document).ready(function(){
        	tfunc.sysTreeOperation(); 
        });  
        
        

    </script>
</head>

<body class="withvernav">

    <div class="bodywrapper">
		<%@ include file="/inc/roleTop.jsp" %> 
		<%@ include file="/inc/roleLeft.jsp" %>

        <div class="centercontent">

            <div class="pageheader">
                <h1 class="pagetitle" style="color:#ff0000;">简要说明</h1>
                <span class="pagedesc">
                    【导航月菜单树】同层节点之间可以进行拖动来调整其先后顺序 
                </span>

                <ul class="hornav">
                    <li class="current">
                        <a href="#nav-menu" onclick="tfunc.sysTreeOperation()">导航与菜单树</a>
                    </li>
                    <li>
                        <a href="#user-role" onclick="tfunc.distributeUserRole()">系统权限分配</a>
                    </li>
                </ul>
            </div>

            <div id="contentwrapper" class="contentwrapper">
                <div id="nav-menu" class="subcontent">
                    <div class="contenttitle2">
                        <h3>功能等级层次码 root=0 导航栏=1 一级菜单栏=2 二级菜单栏=3</h3>
                    </div>
                    <div class="stdform" >
                        <div class="tree-left">
							<div>
								<ul id="sys-tree" class="ztree"></ul>
							</div>
                        </div>

                        <div class="tree-right"  style="padding:5px">
                            <form id="tree-node-edit"  action="#">

                            </form>
                        </div>
                    </div>
                </div>

                <div id="user-role" class="subcontent" style="display: none;padding:5px" >
                    <div class="contenttitle2">
                        <h3>勾选用户对应权限 | <a herf="javascript:void(0)" onclick="" class="a-btn" title="在弹框中勾选用户">【选择用户】</a></h3> 
                    </div>
                    <div class="stdform" >
                        <div class="tree-left">
							<div>
								<ul id="user-role-tree" class="ztree"></ul>
							</div>
                        </div>

                        <div class="tree-right"  style="padding:5px">
                            <form id="user-role-edit"  action="#">

                            </form>
                        </div>
                    </div>
                </div>
            </div>


        </div>


    </div>

</body>
</html>










