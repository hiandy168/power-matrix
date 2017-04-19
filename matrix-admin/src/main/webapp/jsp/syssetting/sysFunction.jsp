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
 	<script type="text/javascript" src="${js}/system/ajax-form.js"></script>
 	<script src="${js}/blockUI/jquery.blockUI.js" type="text/javascript"></script>
 	
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
        .tree-table-right{
            border: solid #78CE07 2px;
            height: 100%;
            width: 40%;
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
        
        /**
         * @描述: 关闭BlockUI弹框
         * @作者: Yangcl
         * @时间: 2016-08-19 : 15-20-56
         */
        function closeDialog(){
            $.unblockUI();
        }
        
        /**
         * @描述: 打开dialog insert BlockUI弹框     
         * @作者: Yangcl
         * @时间: 2016-08-19 : 15-20-56
         */
        function openDialogRole(){
        	 $("#dialog-title")[0].innerText="创建角色";
        	 $("#submit-btn button").remove();
        	 $("#submit-btn").append('<button class="stdbtn btn_orange " style="width: 60px;margin-top:10px" onclick="tfunc.addMcRole()"> 提 交 </button>');
        	 tfunc.showDialog();
        }
        

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
                        <a href="#user-role" onclick="tfunc.distributeUserRole()">系统角色创建</a>
                    </li>
                    <li>
                        <a href="#user-role-func" onclick="tfunc.distributeUserRole()">用户权限分配</a>
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
                        <h3>
                        	<a herf="javascript:void(0)" onclick="openDialogRole()" class="a-btn" title="角色列表在弹出框中">【创建角色】</a>
                        </h3> 
                    </div>
                    <div class="stdform" >
                        <div class="tree-left">
							<div>
								<ul id="user-role-tree" class="ztree"></ul>
							</div>
                        </div>

                        <div class="tree-table-right"  style="padding:5px">
                            <div id="contentwrapper" class="">
				                <div id="table-form" class="dataTables_wrapper" >
				                    <div class="contenttitle2" style="margin-top: 5px;margin-bottom: 8px;">
				                        <p style="margin: 0px">
				                            <label style="width:65px">角色名称：</label>
											<span>
												<input id="role-name" type="text" name="roleName"  class="form-search"/>
											</span>   
				                            <a onclick="searchReset()" class="btn btn_orange btn_search radius50" style="float:right; cursor: pointer; margin-left: 10px">
				                                <span> 重 置 </span>
				                            </a>
				                            <a onclick="searchUser()" class="btn btn_orange btn_search radius50" style="float:right; cursor: pointer;margin-left: 20px">
				                                <span> 查 询 </span>
				                            </a>
				                        </p>
				                    </div>
				
				                    <div id="dyntable2_length" class="dataTables_length">
				                        当前显示10 条记录<input type="hidden" id="select-page-size" value="1"/>
				                    </div> 
				
				                    <table id="dyntable2" cellpadding="0" cellspacing="0" border="0" class="stdtable">
				                        <thead>
				                            <tr>
				                                <th class="head0" style="width:20px">
				                                    查看
				                                </th> 
				                                <th class="head0 ">角色名称</th>
				                                <th class="head0 ">角色描述</th> 
				                                <th class="head0 " width="50px">操作</th>
				                            </tr>
				                        </thead> 
				
				                        <tbody id="ajax-tbody-role">
				                            <%-- 等待填充 --%>
				                        </tbody>
				                    </table>
				                    
				                </div>
            				</div>
            
                        </div>
                    </div>
                </div>
                
                
                <div id="user-role-func" class="subcontent" style="display: none;padding:5px" >
                    <div class="contenttitle2">
                        <h3>
                        	TODOOOOOOOOO
                        </h3> 
                    </div>
                    <div class="stdform" >
                        <div class="tree-left">
							<div>
								<!-- <ul id="" class="ztree"></ul> -->
							</div>
                        </div>

                        <div class="tree-right"  style="padding:5px">
                            <!-- <form id=""  action="#"></form> -->
                        </div>
                    </div>
                </div>
            </div>


        </div>


    </div>

</body>
</html>

<%-- 弹窗分页 --%>
<div id="role-create-div" style="display: none;width: 508px;height: 230px">
    <p class="dialog-title">
        <a href="#" onclick="closeDialog()" class="dialog-close"></a>
        <span id="dialog-title">
        	<!-- 创建角色 -->
        </span>
    </p>

    <div id="dialog-content-wrapper" class="contentwrapper" style="padding-top:5px">
        <div id="dialog-table-form" class="dataTables_wrapper" >
			<form id="user-role-edit"  action="javascript:void(0)">
                <table >
					<tbody>
              			<tr>
              				<td style="width: 60px; margin-bottom: 10px;">角色名称：</td>
              				<td><input type="text"  name="roleName" class="smallinput " placeholder="角色名称" style="width: 190px; margin-bottom: 10px;"></td>
              			</tr>
               			<tr>
               				<td style="width:60px;  vertical-align : middle; ">角色描述：</td>
               				<td><textarea cols="80" id="role-desc" rows="5" maxlength="250" name="roleDesc" class="longinput " placeholder="角色描述"  ></textarea></td>
               			</tr>
               			<tr> 
               				<td colspan="2"><input type="hidden" id="ids" name="ids" value=""></td>
               			</tr>
               			<tr> 
               				<td id="submit-btn" colspan="2">
               					<!-- <button class="stdbtn btn_orange " style="width: 60px;margin-top:10px" onclick="tfunc.addMcRole()"> 提 交 </button> -->
              				</td>
               			</tr>
					</tbody>
				</table>            	
             </form>
        </div>
    </div>

</div>








