<%@ include file="/inc/resource.inc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<%@ include file="/inc/head.jsp"%>
<script type="text/javascript" src="${js}/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${js}/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="${js}/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="${js}/plugins/jquery.uniform.js"></script>
<script type="text/javascript" src="${js }/system/usepublic.js"></script>
<script type="text/javascript">
function edit(){
		var obj = JSON.parse(ajaxs.sendAjax("post", "edit.do", $("#editSeller").serialize()));
		if (obj.status == 'success') {
			alert(obj.msg);
		} else {
			alert(obj.msg);
		}
		window.open("index.do","_self");
}
function cancel(){
	window.open("index.do","_self");
}
$(document).ready(function(){
	jQuery('input:checkbox, input:radio, select.uniformselect, input:file').uniform();
	//佣金设置赋值
	var commissions = '${seller.commission}';
	if(commissions){
		commissions = eval("(" + commissions + ")");
		for(var key in commissions){
			var c = commissions[key];
			$("input[name=ucSellerType]").each(function(){
				if(c.type == $(this).val()){
					$(this).parent().addClass("checked");
					$("#"+$(this).val()).val(c.commission);
				}
			});
		}
	}
	//设置验证信息
	jQuery("#editSeller").validate({
		rules: {
			sellerName: "required",
			sellerTelephone: "required",
			priceType: "required"
		},
		messages: {
			sellerName: "请填写商户名称",
			sellerTelephone:"请填写商户联系电话",
			priceType:"请选择商户同步价格类型"
		},
		debug:true,
		submitHandler:function(){
			var commissions = new Array();
			if($("input[name=ucSellerType]").parent(".checked").length>0){
				//读取佣金设置
				$("input[name=ucSellerType]").each(function(){
						if($(this).parent().hasClass("checked")){
							var val = $(this).val();
							var ucSellerCommission = $("#"+val).val();
							if(UsePublic.isNull(ucSellerCommission)){
								alert("请添加佣金设置");
								return false;
							}else if(!UsePublic.isNumber(ucSellerCommission)){
								alert("佣金设置只能是数字");
								return false;
							}else if(parseInt(ucSellerCommission)>100){
								alert("佣金设置不能大于100");
								return false;
							}else{
								var commission = {
										type:$(this).val(),
										commission:ucSellerCommission
								};
								commissions.push(commission);
							}
						}
				});
			}else{
				alert("请添加佣金设置");
				return false;
			}
			if(commissions.length >0 && $("input[name=ucSellerType]").parent(".checked").length ==commissions.length ){
				$("#commission").val(JSON.stringify(commissions));	
				edit();
			}
		}
	});
});
</script>
</head>

<body class="withvernav">
	<div class="bodywrapper">
		<%@ include file="/inc/top.jsp"%>
		<%@ include file="/inc/left.jsp"%>
		<div class="centercontent">
			<div class="pageheader notab">
				<h1 class="pagetitle">商户管理-编辑商户</h1>
			</div>
                    <form id="editSeller" class="stdform" method="post" action="edit.do">
                    	<input type="hidden" id="sellerCode" name="sellerCode" value="${seller.sellerCode }"></input>
                    	<input type="hidden" id="commission" name="commission" value=""></input>
                    	<p>
                        	<label>商户名称</label>
                            <span class="field">
                            	<input maxlength="20" type="text" value="${seller.sellerName }" name="sellerName" id="sellerName" class="smallinput" />
                            </span>
                        </p>
                        <p>
                        	<label>商户描述</label>
                            <span class="field">
                            	<textarea cols="80" rows="5" value="${seller.sellerDescrption }" name="sellerDescrption" class="smallinput" id="sellerDescrption"></textarea>
                            </span> 
                        </p>
                        <p>
                        	<label>联系电话</label>
                            <span class="field">
                            	<input maxlength="20" type="text" value="${seller.sellerTelephone }" name="sellerTelephone" id="sellerTelephone" class="smallinput" />
                            </span>
                        </p>
                        <p>
                        	<label>商家信箱</label>
                            <span class="field">
                            	<input type="text" value="${seller.sellerEmail }" name="sellerEmail" id="sellerEmail" class="smallinput" />
                            </span>
                        </p>
                        <p>
                        	<label>商家状态</label>
                            <span class="field">
                            	 <select name="status" id="status">
                            	 	<option value="">请选择</option>
                            	 	<option <c:if test="${seller.status == 0 }">selected="selected"</c:if> value="0">未开通</option>
                            	 	<option <c:if test="${seller.status == 1 }">selected="selected"</c:if> value="1">已开通</option>
                            	 	<option <c:if test="${seller.status == 2 }">selected="selected"</c:if> value="2">已禁用</option>
                            	 </select>
                            </span>
                        </p>
	                    <p>
	                    	<label>商户同步价格类型</label>
	                        <span class="field">
	                        	<select id="priceType" name="priceType">
	                        		<option value="">请选择</option>
	                        		<option <c:if test="${seller.priceType == 0 }">selected="selected"</c:if> value="0">成本价</option>
	                        		<option <c:if test="${seller.priceType == 1 }">selected="selected"</c:if> value="1">销售价</option>
	                        	</select>
	                        </span>
	                    </p>
	                    <p>
	                    	<label>佣金设置</label>
	                    	<span class="field">
								<input type="checkbox" name="ucSellerType" value="LD" /> LD商品
								<input id="LD" style="width:40px;margin:5px;" class="commission" type="text" name="ucSellerCommission" value=""/>%
								<br />
	                    		<c:forEach var="type" items="${ucSellerType}">
									<input type="checkbox" name="ucSellerType" value="${type.defineCode}" /> ${type.defineName}
									<input id="${type.defineCode }" style="width:40px;margin:5px;" class="commission" type="text" name="ucSellerCommission" value=""/>%
									<br />
	                    		</c:forEach>
	                    	</span>
	                    </p>
	                    <br />
                        <p class="stdformbutton">
                        	<span class="field">
		                       	<button type="submit" style="width: 100px;margin-right: 10px;" class="submit radius2">编辑</button>
		                       	<button type="button" style="width: 100px;margin-left: 10px;" onclick="cancel();" class="stdbtn" >取消</button>
                        	</span>
                        </p>
                    </form>
		</div>
	</div>
</body>