<%@ include file="/inc/resource.inc" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  <%@ include file="/inc/iframe-head.jsp" %>
  <script type="text/javascript">

       $(function(){
           var type_ = 'post';
           var url_ = '${basePath}media/ajax_article_list.do';
           var data_ = null;  // 可以为null，后台会进行默认处理
           var obj = JSON.parse(ajaxs.sendAjax(type_ , url_ , data_));
           aForm.launch(url_ , 'table-form' , obj).init().drawForm(loadTable);
       });

       // 回调函数
       function loadTable(url_){
           if(url_ == undefined){ // 首次加载表单
               draw(aForm.jsonObj);
               return;
           }
           // 这种情况是响应上一页或下一页的触发事件
           var type_ = 'post';
           var data_ = {
        	   title: $("#title").val(),
               author: $("#author").val(),
               editor: $("#editor").val(),
               articleTypeId: $("#article-type-id").val()
           };
           var obj = JSON.parse(ajaxs.sendAjax(type_ , url_ , data_));
           aForm.launch(url_ , 'table-form' , obj).init();
           draw(obj);
       }

       // 画表格
       function draw(obj){
           $('#ajax-tbody-1 tr').remove();
           var html_ = '';
           var list = obj.data.list;
           if(list.length>0){
            	for(var i = 0 ; i < list.length ; i ++){
	                html_ += '<tr id="tr-' + list[i].id + '" class="gradeX">'
	                +'<td>' + list[i].title + '</td>'
	                +'<td width="60px">' + list[i].titlePic + '</td>'
	                +'<td >' + list[i].source + '</td>'
	                +'<td >' + list[i].author + '</td>'
	                +'<td >' + list[i].createTime + '</td>'
	                +'<td >' + list[i].editor + '</td>'
	                +'<td >' + list[i].releaseTime + '</td>'
	                +'<td >' + list[i].assort + '</td>'
	                +'<td >' 
	                	+'<div>阅读数：' + list[i].readerCount + '</div>'
	                	+'<div>点赞数：' + list[i].thumbsUpCount + '</div>'
	                	+'<div>分享数：' + list[i].sharCount + '</div>'
	                + '</td>' 
	                +'<td width="150px" align="center">'
	                +'<a onclick="deleteOne(\'' + list[i].id + '\')" title="删除"  style="cursor: pointer;">删除</a> | '
	                +'<a href="${basePath}example/edit_info_page.do?id=' + list[i].id + '" title="修改"  style="cursor: pointer;">修改</a> ' 
	                +'</td></tr>'
            	}
           }else{
           		html_='<tr><td colspan="11" style="text-align: center;">'+obj.msg+'</td></tr>';
           }
           $('#ajax-tbody-1').append(html_);
       }

      function deleteOne(id_){
      	jConfirm('您确定要删除这条记录吗？', '系统提示', function(flag) {
           if(flag){
           	var type_ = 'post';
               var url_ = '${basePath}example/ajax_delete_one.do';
               var data_ = {id:id_};
               var obj = JSON.parse(ajaxs.sendAjax(type_ , url_ , data_));
               if(obj.status == 'success'){
                   var currentPageNumber = $(".paginate_active").html();   // 定位到当前分页的页码，然后重新加载数据
                   aForm.formPaging(currentPageNumber);
               }else{
               }
               jAlert(obj.msg, '系统提示');
           }
		});
      }

      //搜索
      function searchUser(){
          aForm.formPaging(0);
      }

      // 重置查询条件
      function searchReset(){
          $(".form-search").val("");
          aForm.formPaging(0);
      }


  </script>

<div class="centercontent tables">
	<!--这个跳转页面的功能及跳转路径等等-->
	<div class="pageheader notab">
		<h1 class="pagetitle">已发布文章列表</h1>
		<span style="display: none">jsp/center-manager/assort/mediaArticleAssortList.jsp</span>
	</div>

	<div id="contentwrapper" class="contentwrapper">

		<%-- table-form 这个id分页使用 --%>
		<div id="table-form" class="dataTables_wrapper">
			<div class="contenttitle2">
				<p style="margin: 0px"> 
					<label>标题：</label> 
					<span class="field"> 
						<input id="title" type="text" name="title" class="form-search" />
					</span> 
					
					<label>作者：</label> 
					<span class="field"> 
						<input id="author" type="text" name="author" class="form-search" />
					</span> 
					
					<label>编辑人：</label> 
					<span class="field"> 
						<input id="editor" type="text" name="editor" class="form-search" />
					</span> 
					
					<label>分类：</label> 
					<span class="field"> 
						<select id="article-type-id" name="articleTypeId" class="form-search">
							<option value="">请选择---</option>
							<option value="1">男</option>
							<option value="2">女</option>
						</select>
					</span> 
					
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
						<th class="head0">标题</th> 
						<th class="head0">标题小图</th> 
						<th class="head0">文章来源</th> 
						<th class="head0">作者</th>
						<th class="head0">创建时间</th>
						<th class="head0">编辑人</th>
						<th class="head0">发布时间(更新时间)</th>
						<th class="head0">分类</th>
						<th class="head0">访问量</th> 
						<th class="head0 " width="100px">操作</th>
					</tr>
				</thead>

				<tbody id="ajax-tbody-1" class="page-list">
					<!--  class="page-list" 标识是页面数据列表 行变色使用 -->
					<%-- 等待填充 --%>
				</tbody>
			</table>

		</div>
	</div>

</div>



























