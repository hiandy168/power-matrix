<%@ include file="/inc/resource.inc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="/inc/head.jsp"%>
	<script type="text/javascript" src="${js}/system/ajax-form.js"></script>
	<script src="${js}/blockUI/jquery.blockUI.js" type="text/javascript"></script>
	<style type="text/css">
		.dialog-table{
			width:100%; 
			border-collapse:separate; 
			border-spacing:10px;  
		}
	</style>
</head>

<body class="withvernav">

	<div class="bodywrapper">
		<%@ include file="/inc/top.jsp"%>
		<%@ include file="/inc/left.jsp"%>

		<div class="centercontent tables">
			<!--这个跳转页面的功能及跳转路径等等-->
			<div class="pageheader notab">
				<h1 class="pagetitle">常用弹层示例</h1>
				<span class="pagedesc"> 本页面用于介绍系统常见的弹出层。 </span>
				<span style="display: none">jsp/example/dialogExample.jsp</span>
			</div>

			<div id="contentwrapper" class="contentwrapper">

				<%-- table-form 这个id分页使用 --%>
				<div id="table-form" class="dataTables_wrapper">
					<div class="contenttitle2">
						<p style="margin: 0px">
							<label>姓名：</label> 
							<span class="field"> 
								<input id="user-name" type="text" name="userName" class="form-search" />
							</span>  
							<a onclick="openAddDialog()" class="btn btn_orange btn_home radius50" style="float: right; cursor: pointer; margin-left: 10px"> 
								<span>添加弹层示例</span>
							</a> 
						</p>
					</div>
				</div>
			</div>

		</div>


	</div>

</body>
</html>

<script type="text/javascript">
	function openAddDialog(){
		var dialogId = 'add-dialog-div';   // 弹窗ID
		$.blockUI({
            showOverlay:true ,
            css:  {
                cursor:'auto',
                left:($(window).width() - $("#" + dialogId).width())/2 + 'px',
                width:$("#" + dialogId).width()+'px',
                top:($(window).height()-$("#" + dialogId).height())/2 + 'px',
                position:'fixed', //居中
                border: '3px solid #FB9337'  // 边界
            },
            message: $('#' + dialogId),
            fadeIn: 500,//淡入时间
            fadeOut: 1000  //淡出时间
        });
	}

	function closeDialog(){
        $.unblockUI();
    }
</script>

<div id="add-dialog-div" class="dialog-page-div" style="display: none;width: 400px;height: 300px">
    <p class="dialog-title">	<!-- dialog-title是必填的一个类，修饰弹窗的头部 -->
        <a href="#" onclick="closeDialog()" class="dialog-close"></a>
        添加用户
    </p>

    <div id="dialog-content-wrapper" class="contentwrapper">
        <div id="dialog-table-form" class="dataTables_wrapper" >
            <form id="dialog-table" >
	            <table class="dialog-table">
	                <tbody>
	                	<tr >
	                		<td style="text-align: right">
	                			用户姓名：
	                		</td>
	                		<td style="text-align: left">
	                			<input type="text" name="" class="dialog-form-input" style="width:200px;"/>
	                		</td>
	                	</tr>
	                	
	                	<tr class="add-dialog">
	                		<td style="text-align: right">
	                			手 机 号：
	                		</td>
	                		<td style="text-align: left">
	                			<input type="text" name="" class="dialog-form-input" style="width:200px;"/>
	                		</td>
	                	</tr>
	                	
	                	<tr>
	                		<td style="text-align: right">
	                			电子邮件：
	                		</td>
	                		<td style="text-align: left">
	                			<input type="text" name="" class="dialog-form-input" style="width:200px;"/>
	                		</td>
	                	</tr>
	                </tbody>
	                <tfoot>
		                <tr>
					      <td colspan="2" style="text-align: right">
					      	<button class="stdbtn btn_orange" style="opacity:1">提 &nbsp&nbsp&nbsp&nbsp&nbsp 交</button>
					      </td> 
					    </tr>
	                </tfoot>
	            </table>
            </form>
        </div>
    </div>

</div>
























