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
        function openDialogPage(){
//            dialogFormClear(dialogFormId)        // TODO 可选：清空上一次遗留的内容
            var type_ = 'post';
            var url_ = '${basePath}example/ajaxPageData.do';
            var data_ = null;
            var obj = JSON.parse(ajaxs.sendAjax(type_ , url_ , data_));
            dForm.launch(url_ , 'dialog-table-form' , obj).init().drawForm(loadDialogTable);

            $.blockUI({
                showOverlay:true ,
                css:  {
                    cursor:'auto',
                    left:($(window).width() - $("#dialog-page-div").width())/2 + 'px',
                    width:$("#dialog-page-div").width()+'px',
                    top:($(window).height()-$("#dialog-page-div").height())/2 + 'px',
                    position:'fixed'	, 	//居中
                    textAlign : 'left',    
                    border: '3px solid #FB9337'  // 边界
                },
                message: $('#dialog-page-div'),
                fadeIn: 500,//淡入时间
                fadeOut: 1000  //淡出时间
            });
        }
        
     	// 回调函数
        function loadDialogTable(url_){
            if(url_ == undefined){ // 首次加载表单
                drawDialog(dForm.jsonObj);
                return;
            }
            // 这种情况是响应上一页或下一页的触发事件
            var type_ = 'post';
            var data_ = null;
            var obj = JSON.parse(ajaxs.sendAjax(type_ , url_ , data_));
            dForm.launch(url_ , 'dialog-table-form' , obj).init();
            drawDialog(obj);
        }

        function drawDialog(obj){
            $('#dialog-ajax-tbody tr').remove();
            var html_ = '';
            var list = obj.data.list;
            if(list.length>0){
	            for(var i = 0 ; i < list.length ; i ++){
	                html_ += '<tr id="tr-d-' + list[i].id + '" class="gradeX">'   // TODO 注意：这里的 tr 的 id 是以 tr-d-****  作为开头的 - Yangcl
	                +'<td align="center"><span class="center"> <input type="checkbox"/> </span></td>'
	                // +'<td width="100px">' + list[i].id + '</td>'
	                +'<td>' + list[i].userName + '</td>'
	                +'<td>' + list[i].mobile + '</td>'
	                +'<td class="center">' + list[i].idNumber + '</td>'
	               // +'<td class="center">' + list[i].email + '</td>'
	                //+'<td width="150px" align="center">'
	                //+'<a onclick="deleteOne(\'' + list[i].id + '\')" title="删除"  style="cursor: pointer;">删除</a> | '
	                //+'<a href="${basePath}example/editInfoPage.do?id=' + list[i].id + '" title="修改"  style="cursor: pointer;">修改</a></td> '
	                +'</tr>'
	            }
            }else{
            	html_='<tr><td colspan="11" style="text-align: center;">'+obj.msg+'</td></tr>';
            }
            $('#dialog-ajax-tbody').append(html_);
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
                        <h3>勾选用户对应权限 | <a herf="javascript:void(0)" onclick="openDialogPage()" class="a-btn" title="在弹框中勾选用户">【选择用户】</a></h3> 
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

<%-- 弹窗分页 --%>
<div id="dialog-page-div" class="dialog-page-div" style="display: none;width: 1000px;height: 700px">
    <p class="dialog-title">
        <a href="#" onclick="closeDialog()" class="dialog-close"></a>
        勾选用户并分配权限
    </p>

    <div id="dialog-content-wrapper" class="contentwrapper" style="padding-top:5px">
    
		<div class="contenttitle2" style="margin-top:5px;margin-bottom:5px">
           <p style="margin: 0px">
				<label>姓名：</label>
				<span class="field">
					<input id="user-name" type="text" name="userName"  class="form-search"/>
				</span>

                <label>手机号：</label>
				<span class="field">
					<input id="mobile" type="text" name="mobile"  class="form-search"/>
				</span>

                <label>性别：</label>
				<span class="field">
					<select id="sex" name="sex" class="form-search">
                         <option value="">请选择---</option>
                         <option value="1">男</option>
                         <option value="2">女</option>
                     </select>
				</span>

                <a onclick="searchReset()" class="btn btn_orange btn_search radius50" style="float:right; cursor: pointer; margin-left: 10px">
                    <span> 重 置 </span>
                </a>
                <a onclick="searchUser()" class="btn btn_orange btn_search radius50" style="float:right; cursor: pointer;margin-left: 20px">
                    <span> 查 询 </span>
                </a>          
           </p>             
        </div>    
    
        <div id="dialog-table-form" class="dataTables_wrapper" >
            <div id="dialog-dyntable" class=" dialog-show-count" >
                <label>
                    当前显示
                    <%-- TODO 注意：dialog-select-page-size 这个ID是写定的，如果没有这个显示条数，则默认显示10条 - Yangcl --%>
                    <select id="dialog-select-page-size" size="1" name="dyntable2_length" onchange="dForm.formPaging('1')">
                        <option value="10">10</option>
                        <%-- TODO 注意：这里最好只给10条，因为悬浮窗体并不会随之变大 onchange()事件也最好不要，但这里作为示例给出 - Yangcl--%>
                    </select>
                    条记录
                </label>
            </div>

            <%-- 以下内容根据你自己的业务需要进行修改--%>
            <table id="dialog-table" cellpadding="0" cellspacing="0" border="0" class="stdtable">
                <colgroup>
                    <col class="con0" style="width: 4%"/>
                    <col class="con1"/>
                    <col class="con0"/>
                    <col class="con1"/>
                    <col class="con0"/>
                </colgroup>
                <thead>
                <tr>
                    <th class="head0 nosort">
                        <input type="checkbox"/>
                    </th>                                                                        
                    <!-- <th class="head0 sorting_asc">ID(升序排序)</th>    -->
                    <th class="head1 sorting_desc"> 姓名(降序排序)</th>  
                    <th class="head0 sorting">手机(s)</th>
                    <th class="head1 sorting">身份证号</th>
                   <!--  <th class="head0 sorting">E-mail</th>
                    <th class="head1 " width="100px">操作</th> -->
                </tr>
                </thead>

                <tbody id="dialog-ajax-tbody">
                <%-- 等待填充 --%>
                </tbody>
            </table>

        </div>
    </div>

</div>








