<%@ include file="/inc/resource.inc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="/inc/head.jsp"%>
	<script type="text/javascript" src="${js}/system/ajax-form.js"></script>
	<script src="${js}/blockUI/jquery.blockUI.js" type="text/javascript"></script>
	<script type="text/javascript" src="${js}/system/sysUserRoleFunction.js"></script>
	<style type="text/css">
	</style>
</head>

<body class="withvernav">

	<div class="bodywrapper">
		<%@ include file="/inc/top.jsp"%>
		<%@ include file="/inc/left.jsp"%>

		<div class="centercontent tables">
			<!--这个跳转页面的功能及跳转路径等等-->
			<div class="pageheader notab">
				<h1 class="pagetitle">系统角色列表页面</h1>
				<span class="pagedesc"> 本页面用于系统管理员来创建系统中的角色。 </span> <span
					style="display: none">jsp/syssetting/role/sysMcRoleList.jsp</span>
			</div>

			<div id="contentwrapper" class="contentwrapper">

				<%-- table-form 这个id分页使用 --%>
				<div id="table-form" class="dataTables_wrapper">
					<div class="contenttitle2">
						<p style="margin: 0px">
							<label>权限名称：</label> 
							<span class="field"> 
								<input id="role-name" type="text" name="roleName" class="form-search" />
							</span>  
							<a onclick="toUserAddPage()" class="btn btn_orange btn_home radius50" style="float: right; cursor: pointer; margin-left: 10px"> 
								<span> 添 加 </span>
							</a> 
							<a onclick="searchReset()" class="btn btn_orange btn_search radius50" style="float: right; cursor: pointer; margin-left: 10px"> 
								<span> 重 置 </span>
							</a> 
							<a onclick="searchUser()" class="btn btn_orange btn_search radius50" style="float: right; cursor: pointer; margin-left: 20px"> 
								<span> 查 询 </span>
							</a>
						</p>
					</div>

					<div id="dyntable2_length" class="dataTables_length dialog-show-count">
						<label> 当前显示 
							<select id="select-page-size" size="1" name="dyntable2_length" onchange="aForm.formPaging('1')">
								<option value="10">10</option>
								<option value="25">25</option>
								<option value="50">50</option>
								<option value="100">100</option>
							</select> 条记录
						</label>
					</div>

					<table id="dyntable2" cellpadding="0" cellspacing="0" border="0" class="stdtable">
						<thead>
							<tr>
								<th class="head1">权限名称</th> 
								<th class="head1">权限描述</th> 
								<th class="head1">创建时间</th>
								<th class="head1 " width="100px">操作</th>
							</tr>
						</thead>

						<tbody id="ajax-tbody-user-list" class="page-list">
							<%-- 等待填充 --%>
						</tbody>
					</table>

				</div>
			</div>

		</div>


	</div>

</body>
</html>

<script type="text/javascript">
	$(function() {
		var type_ = 'post';
		var url_ = '${basePath}sysrole/sys_role_list.do';
		var data_ = null; // 可以为null，后台会进行默认处理
		var obj = JSON.parse(ajaxs.sendAjax(type_, url_, data_));
		aForm.launch(url_, 'table-form', obj).init().drawForm(loadTable);
	});

	// 回调函数
	function loadTable(url_) {
		if (url_ == undefined) { // 首次加载表单
			draw(aForm.jsonObj);
			return;
		}
		// 这种情况是响应上一页或下一页的触发事件
		var type_ = 'post';
		var data_ = {
			roleName : $("#role-name").val() 
		}
		var obj = JSON.parse(ajaxs.sendAjax(type_, url_, data_));
		aForm.launch(url_, 'table-form', obj).init();
		draw(obj);
	}

	// 画表格
	function draw(obj) {
		$('#ajax-tbody-user-list tr').remove();
		var html_ = '';
		var list = obj.data.list;
		if (list.length > 0) {
			for (var i = 0; i < list.length; i++) {
				html_ += '<tr>' + '<td align="center" width="200px">' + list[i].roleName + '</td>'
						+ '<td>' + list[i].roleDesc + '</td>'
						+ '<td align="center" width="200px">' + list[i].createTime + '</td>'
						+ '<td width="200px" align="center">'
						+ '<a href="javascript:void(0)" roleId="' + list[i].id + '" onclick="showTreeInDialog(this)" title="分配系统功能到这个角色中"  style="cursor: pointer;">分配功能</a>| ' 
						+ '<a href="${basePath}sysrole/show_role_edit_page.do?id=' + list[i].id + '" title="修改"  style="cursor: pointer;">修改</a>| '
						+ '<a onclick="deleteOne(\'' + list[i].id + '\')" title="删除"  style="cursor: pointer;">删除</a>'
						+ '</td></tr>'
			}
		}else{
			html_ = '<tr><td colspan="11" style="text-align: center;">' + obj.msg + '</td></tr>';
		}

		$('#ajax-tbody-user-list').append(html_);
	}
	
	// 前往添加用户界面 
	function toUserAddPage(){
		window.location.href = "${basePath}sysrole/show_role_add_page.do";
	}
	
	// 在弹框中展示树形组件 
	function showTreeInDialog(obj){
		var roleId = $(obj).attr("roleId");  
		// TODO 展示弹框代码  
	}

	function deleteOne(id_) {
		jConfirm('您确定要删除这条记录吗？', '系统提示', function(flag) {
			if (flag) {
				var type_ = 'post';
				var url_ = '${basePath}sysrole/delete_role.do';
				var data_ = {
					id : id_
				};
				var obj = JSON.parse(ajaxs.sendAjax(type_, url_, data_));
				if (obj.status == 'success') {
					var currentPageNumber = $(".paginate_active").html(); // 定位到当前分页的页码，然后重新加载数据
					aForm.formPaging(currentPageNumber);
				} else {
				}
				jAlert(obj.msg, '系统提示');
			}
		});
	}

	//搜索
	function searchUser() {
		aForm.formPaging(0);
	}

	// 重置查询条件
	function searchReset() {
		$("#role-name").val(""); 
		aForm.formPaging(0);
	}
	
</script>


























