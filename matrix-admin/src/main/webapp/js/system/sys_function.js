
    var tfunc = {
    		
        /**
         * 允许移动到目标节点前面 即可以将同层最后一个节点放到同层的第一个。
         * @param treeId
         * @param nodes
         * @param targetNode
         * @returns {boolean}
         */
        dropPrev:function(treeId, nodes, targetNode) {
            if(nodes[0].parentId == targetNode.parentId){  // 只允许同层节点之间进行拖拽
            	return true;
            }else{
            	return false;
            }
        },
        
        /**
         * 设置是否允许移动到同层节点的最后一个节点的后面 从而使被移动的节点成为最后一个节点
         * @param treeId
         * @param nodes
         * @param targetNode
         * @returns {boolean}
         */
        dropNext:function(treeId, nodes, targetNode) {
            if(nodes[0].parentId == targetNode.parentId){  // 只允许同层节点之间进行拖拽
            	return true;
            }else{
            	return false;
            } 
        },
        
        /**
         *  拖拽到目标节点时 设置是否允许成为目标节点的子节点。
         * @param treeId
         * @param nodes
         * @param targetNode
         * @returns {boolean}
         */
        dropInner:function(treeId, nodes, targetNode) {
//            console.log("dropInner");
            return false;
        },

        /**
         * 如果是root节点 禁止显示删除按钮
         * @param treeId
         * @param treeNode
         * @returns {boolean}
         */
        showRemoveBtn:function(treeId, treeNode){
            if(treeNode.level == 0){
                return false;
            }else{
                return true;
            }
        },

        /**
         * 显示添加按钮 以及添加操作
         * @param treeId
         * @param treeNode
         */
        addHoverDom:function(treeId, treeNode) {
            var newCount = 1;
            var sObj = $("#" + treeNode.tId + "_span");
            if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0)
                return;
            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='添加一个节点' onfocus='this.blur();'></span>";
            sObj.after(addStr);
            var btn = $("#addBtn_"+treeNode.tId);
            if (btn) {
                btn.bind("click", function(){
                    var zTree = $.fn.zTree.getZTreeObj("sys-tree");
                    var new_ = { // 新建一个节点元素
                        id:(100 + newCount),
                        pId:treeNode.id,
                        flag:3,  // 新增节点标记
                        name:"新建结点"  // + (newCount++)
                    };
                    zTree.addNodes(treeNode ,  new_);
                    return false;
                });
            }

        },
        
        /**
         * 移除添加按钮
         * @param treeId
         * @param treeNode
         */
        removeHoverDom:function(treeId, treeNode) {
            $("#addBtn_"+treeNode.tId).unbind().remove();
        },
        
        /**
         * 捕获节点被删除之前的事件
         * @param treeId
         * @param treeNode
         */
        beforeRemove: function(treeId , treeNode){ 
        	var type_ = false;
        	if(confirm("您确定要删除这个节点吗?")){
        		type_ = true;
        	}
        	return type_;	
        },
        
        // 用于捕获删除节点之后的事件回调函数。
        onRemove: function(event, treeId, treeNode){
        	var type_ = 'post';
            var url_ = 'delete_node.do';
            var data_ = {id:treeNode.id};  
            var obj = JSON.parse(ajaxs.sendAjax(type_ , url_ , data_));
            if(obj.status == 'success'){
            	jAlert(obj.msg , '系统提示 ');   
            	return true;
            }else{
            	jAlert(obj.msg , '系统提示 '); 
            	return false;
            }
        }, 

        beforeDrag:function(treeId, treeNodes) {
            // TODO
            return true;
        },
        
        beforeDrop:function(treeId, treeNodes, targetNode, moveType, isCopy){
            return true;
        },
        
        beforeDragOpen:function(treeId, treeNode){

            return true;
        },
        
        onDrag:function(event, treeId, treeNodes){

            return true;
        },
        
        /**
         * 节点拖拽结束后|此处涉及到批量更新操作|同层节点之间的批量更新
         * @returns {Boolean}
         */
        onDrop:function(event, treeId, treeNodes, targetNode, moveType, isCopy){  
        	if(treeNodes[0].name == "新建结点"){
        		return false;
        	}
        	
        	var ustring = ""; // id@seqnum,id@seqnum   准备交给服务器解析处理的字符串
        	var uparr = new Array();			// 保存有效的更新信息
        	var parent = treeNodes[0].getParentNode();
        	var arr = parent.children;
        	if(arr.length > 0){
        		for(var i = 0 ; i < arr.length ; i ++){
        			if(arr[i].name != "新建结点"){
        				uparr.push(arr[i]);
        			}
        		}
        		if(uparr.length != 0){
        			for(var k = 0 ; k < uparr.length ; k ++){
        				var node = uparr[k];
        				var seqnum = parseInt(k) + 1;  // node.getIndex() 会受到新建节点的影响造成seqnum值不准。
        				ustring += node.id + "@" + seqnum + ","  ;
        			}
        			ustring = ustring.substring(0, ustring.length-1); 
//                    var obj = JSON.parse();
                    ajaxs.sendAjax('post' , 'update_tree_nodes.do' , {ustring:ustring})
        		}
        	}
            return true;
        },
        
        onExpand:function(event, treeId, treeNode){

            return true;
        },
        
        /**
         * 捕获 勾选 或 取消勾选 之前的事件回调函数
         */
        beforeCheck : function(treeId, node){  
        	return tfunc.isSellerNodeBeCheck(treeId, node , node.navType == 0);  
        }, 
        
        onCheck : function(event, treeId, treeNode){
        	return true; 
        },
        
        /**
         * 商户节点选择唯一性验证
         * @param node -> treeNode
         * @param isSellerNode 是否为商户节点|true是 false 不是
         */
        isSellerNodeBeCheck : function(treeId , node , isSellerNode){ 
        	var flag = false;
        	if(isSellerNode && node.navType == 0){   // 从商户节点开始选择
        		if($(".seller-node").length != 0){
        			if(node.tId == $(".seller-node")[0].id){  // 如果是选择【已选商户节点】则允许取消选择      checkbox_true_part  checkbox_true_full
        				$("#" + node.tId).removeClass("seller-node");  
        				flag =  true;
        			}else{
        				jAlert("只能选择一个商户节点!" , '系统提示 ');
        				flag =  false; 
        			}
        		}else{
        			$("#" + node.tId).addClass("seller-node");
        			flag =  true;
        		}
        	}else if(!isSellerNode){ // 从子节点开始选择
        		var par = node.getParentNode();  
        		if(par.navType == 0){
        			if($(".seller-node").length == 0){ // 没有被选择的商户节点
        				$("#" + par.tId).addClass("seller-node");
        				flag =  true;
            		}else {
            			if(par.tId != $(".seller-node")[0].id){
                			jAlert("只能选择一个商户节点!" , '系统提示 ');
                			flag =  false; 
                		}else{
                			flag =  true;  
                		}
            		}
        		}else{
        			flag = tfunc.isSellerNodeBeCheck(treeId , par , false); 
        		}
        	} 
        	return flag;
        },
        
        ztOnClick:function(event, treeId, treeNode, clickFlag){
            var level_ = treeNode.level;
            switch(level_){
                case 0: // root节点
                    break;
                case 1: // 商户节点(惠家有等)
                    tfunc.firstLevelEdit(event , treeNode);
                    break;
                case 2: // 导航栏
                    tfunc.navEdit(event , treeNode);
                    break;
                case 3: // 1级菜单栏
                    tfunc.fMenuEdit(event , treeNode);
                    break;
                case 4: // 2级菜单栏 - 此处对应具体页面
                    tfunc.sMenuEdit(event , treeNode);
                    break;
                case 5: // 页面按钮(添加|删除|修改等)|跳转页等等
                    tfunc.subMenuEdit(event , treeNode);
                    break;
            }
        },
        
        /**
         * 编辑商户节点 
         * 
         * @param event
         * @param treeNode
         */
        firstLevelEdit:function(event , treeNode){
            $($("#tree-node-edit")[0].childNodes).remove();
            var type_ = 'post';
            var url_ = ''; 
            if(treeNode.name == "新建结点"){
            	url_ = 'add_tree_node.do';
            	var html_ = '<input type="text" name="name" class="smallinput " placeholder="商户名称" style="width: 190px; margin-bottom: 10px;">';
            	html_ += '<textarea cols="80" rows="5" maxlength="250"  name="remark"  class="longinput "  placeholder="备注信息描述" style="margin-bottom: 10px;"></textarea><br/>';
            	html_ += '<input type="hidden" name="parentId" value="' + treeNode.parentId +'" >';
            	
            	var preNode = treeNode.getPreNode();   // seqnum  需要计算同层所有节点，然后得出顺序码
            	var seqnum_ = 1;
            	if(preNode != null){
            		seqnum_ = preNode.seqnum + 1;
            	} 
            	html_ += '<input type="hidden" name="seqnum" value="' + seqnum_ +'" >';
            	html_ += '<input type="hidden" name="navType"  value="0" >';
            	html_ += '<input type="hidden" name="styleClass" value="" >';
            	html_ += '<input type="hidden" name="styleKey" value="" >';
            	html_ += '<input type="hidden" name="funcUrl" value="" >';  
            	html_ += '<button class="stdbtn btn_orange " onclick="tfunc.addData(\'' + url_ +'\')"> 提 交 </button>'
            }else{
            	url_ = 'edit_tree_node.do';
            	var html_ = '<input type="text" name="name" class="smallinput " style="width: 190px; margin-bottom: 10px;" value="' + treeNode.name + '" >';
            	html_ += '<textarea cols="80" rows="5" maxlength="250"  name="remark"  class="longinput "  placeholder="备注信息描述" style="margin-bottom: 10px;">' + treeNode.remark + '</textarea><br/>';
            	html_ += '<input type="hidden" name="id" value="' + treeNode.id +'" >'; 
            	html_ += '<button class="stdbtn btn_orange " onclick="tfunc.addData(\'' + url_ +'\')"> 提 交 </button>'
            }
            $("#tree-node-edit").append(html_);
        },
        
        /**
         * 导航栏相关操作
         * @param event
         * @param treeNode
         */
        navEdit:function(event , treeNode){
        	$($("#tree-node-edit")[0].childNodes).remove();
            var type_ = 'post';
            var url_ = ''; 
            if(treeNode.name == "新建结点"){
            	url_ = 'add_tree_node.do';
            	var html_ = '<input type="text" name="name" class="smallinput " placeholder="导航栏名称" style="width: 190px; margin-bottom: 10px;">';
            	html_ += '<textarea cols="80" rows="5" maxlength="250"  name="remark"  class="longinput "  placeholder="备注信息描述" style="margin-bottom: 10px;"></textarea><br/>';
            	html_ += '<input type="hidden" name="parentId" value="' + treeNode.parentId +'" >';
            	
            	var preNode = treeNode.getPreNode();   // seqnum  需要计算同层所有节点，然后得出顺序码
            	var seqnum_ = 1;
            	if(preNode != null){
            		seqnum_ = preNode.seqnum + 1;
            	} 
            	html_ += '<input type="hidden" name="seqnum" value="' + seqnum_ +'" >';
            	html_ += '<input type="hidden" name="navType"  value="1" >';
            	html_ += '<input type="hidden" name="styleClass" value="" >';
            	html_ += '<input type="hidden" name="styleKey" value="" >';
            	html_ += '<input type="hidden" name="funcUrl" value="" >';  
            	html_ += '<button class="stdbtn btn_orange " onclick="tfunc.addData(\'' + url_ +'\')"> 提 交 </button>'
            }else{
            	url_ = 'edit_tree_node.do';
            	var html_ = '<input type="text" name="name" class="smallinput " style="width: 190px; margin-bottom: 10px;" value="' + treeNode.name + '" >';
            	html_ += '<textarea cols="80" rows="5" maxlength="250"  name="remark"  class="longinput "  placeholder="备注信息描述" style="margin-bottom: 10px;">' + treeNode.remark + '</textarea><br/>';
            	html_ += '<input type="hidden" name="id" value="' + treeNode.id +'" >'; 
            	html_ += '<button class="stdbtn btn_orange " onclick="tfunc.addData(\'' + url_ +'\')"> 提 交 </button>'
            }
            $("#tree-node-edit").append(html_);
        },
        
        /**
         * 编辑一级菜单栏
         * @param event
         * @param treeNode
         */
        fMenuEdit:function(event , treeNode){
			$($("#tree-node-edit")[0].childNodes).remove();
            var type_ = 'post';
            var url_ = ''; 
            if(treeNode.name == "新建结点"){
            	url_ = 'add_tree_node.do';
            	var html_ = '<input type="text" name="name" class="smallinput " placeholder="一级菜单栏名称" style="width: 190px; margin-bottom: 10px;"><br/>';
            	//html_ += '<input type="text" class="smallinput " placeholder="styleKey" style="width: 190px; margin-bottom: 10px;" name="styleKey" value="" ><br/>';
            	html_ += '<textarea cols="80" rows="5" maxlength="250"  name="remark"  class="longinput "  placeholder="备注信息描述" style="margin-bottom: 10px;"></textarea><br/>';
            	html_ += '<input type="hidden" name="parentId" value="' + treeNode.parentId +'" >';
            	
            	var preNode = treeNode.getPreNode();   // seqnum  需要计算同层所有节点，然后得出顺序码
            	var seqnum_ = 1;
            	if(preNode != null){
            		seqnum_ = preNode.seqnum + 1;
            	} 
            	html_ += '<input type="hidden" name="seqnum" value="' + seqnum_ +'" >';
            	html_ += '<input type="hidden" name="navType"  value="2" >'; 
            	html_ += '<input type="hidden" name="styleClass" value="editor" >'; 
            	html_ += '<input type="hidden" name="styleKey" value="" >'; 
            	html_ += '<input type="hidden" name="funcUrl" value="" >';  
            	html_ += '<button class="stdbtn btn_orange " onclick="tfunc.addData(\'' + url_ +'\')"> 提 交 </button>'
            }else{
            	url_ = 'edit_tree_node.do';
            	var html_ = '<input type="text" name="name" class="smallinput " style="width: 190px; margin-bottom: 10px;" value="' + treeNode.name + '" ><br/>';
            	// html_ += '<input type="text" class="smallinput " placeholder="styleClass" style="width: 190px; margin-bottom: 10px;" name="styleClass" value="' + treeNode.styleClass + '" ><br/>';
            	// html_ += '<input type="text" class="smallinput " placeholder="styleKey" style="width: 190px; margin-bottom: 10px;" name="styleKey" value="' + treeNode.styleKey + '" ><br/>';
            	html_ += '<textarea cols="80" rows="5" maxlength="250"  name="remark"  class="longinput "  placeholder="备注信息描述" style="margin-bottom: 10px;">' + treeNode.remark + '</textarea><br/>';
            	html_ += '<input type="hidden" name="id" value="' + treeNode.id +'" >'; 
            	html_ += '<button class="stdbtn btn_orange " onclick="tfunc.addData(\'' + url_ +'\')"> 提 交 </button>'
            }
            $("#tree-node-edit").append(html_);
        },
        
        /**
         * 编辑二级菜单栏
         * @param event
         * @param treeNode
         */
        sMenuEdit:function(event , treeNode){
        	$($("#tree-node-edit")[0].childNodes).remove();
            var type_ = 'post';
            var url_ = ''; 
            if(treeNode.name == "新建结点"){
            	url_ = 'add_tree_node.do';
            	var html_ = '<input type="text" name="name" class="smallinput " placeholder="二级菜单栏名称" style="width: 190px; margin-bottom: 10px;"><br/>';
            	// html_ += '<input type="text" class="smallinput " placeholder="styleKey" style="width: 190px; margin-bottom: 10px;" name="styleKey" value="" ><br/>';
            	html_ += '<input type="text" class="smallinput " placeholder="跳转地址：exa/example.do" style="width: 190px; margin-bottom: 10px;" name="funcUrl" value="" ><br/>';
            	html_ += '<textarea cols="80" rows="5" maxlength="250"  name="remark"  class="longinput "  placeholder="备注信息描述" style="margin-bottom: 10px;"></textarea><br/>';
            	html_ += '<input type="hidden" name="parentId" value="' + treeNode.parentId +'" >';
            	
            	var preNode = treeNode.getPreNode();   // seqnum  需要计算同层所有节点，然后得出顺序码
            	var seqnum_ = 1;
            	if(preNode != null){
            		seqnum_ = preNode.seqnum + 1;
            	} 
            	html_ += '<input type="hidden" name="seqnum" value="' + seqnum_ +'" >';
            	html_ += '<input type="hidden" name="navType"  value="3" >'; 
            	html_ += '<input type="hidden" name="styleClass" value="" >';
            	html_ += '<input type="hidden" name="styleKey" value="" >'; 
            	html_ += '<button class="stdbtn btn_orange " onclick="tfunc.addData(\'' + url_ +'\')"> 提 交 </button>'
            }else{
            	url_ = 'edit_tree_node.do';
            	var html_ = '<input type="text" name="name" class="smallinput " style="width: 190px; margin-bottom: 10px;" value="' + treeNode.name + '" ><br/>';
            	// html_ += '<input type="text" class="smallinput " placeholder="styleKey" style="width: 190px; margin-bottom: 10px;" name="styleKey" value="' + treeNode.styleKey + '" ><br/>';
            	html_ += '<input type="text" class="smallinput " placeholder="funcUrl" style="width: 190px; margin-bottom: 10px;" name="funcUrl" value="' + treeNode.funcUrl + '" ><br/>'; 
            	
            	html_ += '<textarea cols="80" rows="5" maxlength="250"  name="remark"  class="longinput "  placeholder="备注信息描述" style="margin-bottom: 10px;">' + treeNode.remark + '</textarea><br/>';
            	html_ += '<input type="hidden" name="id" value="' + treeNode.id +'" >'; 
            	html_ += '<button class="stdbtn btn_orange " onclick="tfunc.addData(\'' + url_ +'\')"> 提 交 </button>'
            }
            $("#tree-node-edit").append(html_);
        },
        
        /**
         * 编辑按钮节点|跳转页等内容
         * @param event
         * @param treeNode
         */
        subMenuEdit:function(event ,treeNode){
        	$($("#tree-node-edit")[0].childNodes).remove();
            var type_ = 'post';
            var url_ = ''; 
            if(treeNode.name == "新建结点"){
            	url_ = 'add_tree_node.do';
            	var html_ = '节点名称：<input type="text" name="name" class="smallinput " placeholder="按钮节点|跳转页" style="width: 190px; margin-bottom: 10px;"><br/>';
            	html_ += '节点类型：<select id="navType" name="navType" class="radius3" onchange="tfunc.changeNodeType()" style="margin-left:0px; width:204px;  margin-bottom: 10px;"><option value="4">页面按钮</option><option value="5">内部跳转页面</option></select><br/>';            		
            	html_ += '<div id = "node-type" style="margin-bottom: 10px;">';
            		html_ += '<div style="margin-bottom: 10px;"><input type="radio" name="eleType" value="elementId" style="margin-left:10px" checked> 元素ID | <input type="radio" name="eleType" value="elementClass" style="margin-left:10px"> 元素Class</div>' 
            		html_ += 'id|class：<input type="text" class="smallinput " placeholder="html的id 或 class值" style="width: 190px; margin-bottom: 10px;" name="eleValue" value="" ><br/>';
            	html_ += '</div>';
            	html_ += '<textarea cols="80" rows="5" maxlength="250"  name="remark"  class="longinput "  placeholder="备注信息描述" style="margin-bottom: 10px;"></textarea><br/>';
            	html_ += '<input type="hidden" name="parentId" value="' + treeNode.parentId +'" >';
            	var preNode = treeNode.getPreNode();   // seqnum  需要计算同层所有节点，然后得出顺序码
            	var seqnum_ = 1;
            	if(preNode != null){
            		seqnum_ = preNode.seqnum + 1;
            	} 
            	html_ += '<input type="hidden" name="seqnum" value="' + seqnum_ +'" >';
            	html_ += '<input type="hidden" name="styleClass" value="" >';
            	html_ += '<input type="hidden" name="styleKey" value="" >';   
            	html_ += '<button class="stdbtn btn_orange " onclick="tfunc.addData(\'' + url_ +'\')"> 提 交 </button>'
            }else{
            	url_ = 'edit_tree_node.do';
            	var html_ = '节点名称：<input type="text" name="name" class="smallinput " style="width: 190px; margin-bottom: 10px;" value="' + treeNode.name + '" ><br/>';
            	html_ += '节点类型：<select id="navType" name="navType" class="radius3" onchange="tfunc.changeNodeType()" style="margin-left:0px; width:204px;  margin-bottom: 10px;">'; 
            	if(treeNode.navType == 4){
            		html_ += '<option value="4" selected>页面按钮</option><option value="5">内部跳转页面</option></select><br/>';
            		html_ += '<div id = "node-type" style="margin-bottom: 10px;">';
            		if(treeNode.eleType == "elementId"){
            			html_ += '<div style="margin-bottom: 10px;"><input type="radio" name="eleType" value="elementId" style="margin-left:10px" checked> 元素ID | <input type="radio" name="eleType" value="elementClass" style="margin-left:10px"> 元素Class</div>' 
            		}else{
            			html_ += '<div style="margin-bottom: 10px;"><input type="radio" name="eleType" value="elementId" style="margin-left:10px"> 元素ID | <input type="radio" name="eleType" value="elementClass" style="margin-left:10px" checked> 元素Class</div>' 
            		}
            		html_ += 'id|class：<input type="text" class="smallinput " placeholder="html的id 或 class值" style="width: 190px; margin-bottom: 10px;" name="eleValue" value="' + treeNode.eleValue + '" ><br/>';
	            	html_ += '</div>';
	            	html_ += '<input type="hidden" name="funcUrl" value="" >';  // 更新时，此处置空
            	}else{
            		html_ += '<option value="4">页面按钮</option><option value="5"  selected>内部跳转页面</option></select><br/>';
            		html_ += '<div id = "node-type" style="margin-bottom: 10px;">';
            		html_ += '跳转地址：<input type="text" class="smallinput " placeholder="funcUrl" style="width: 190px; margin-bottom: 10px;" name="funcUrl" value="' + treeNode.funcUrl + '" ><br/>'; 
            		html_ += '</div>';
            		
            		html_ += '<input type="hidden" name="eleType" value="" >';  // 更新时，此处置空
            		html_ += '<input type="hidden" name="eleValue" value="" >';  // 更新时，此处置空 
            	}
            	
            	
            	html_ += '<textarea cols="80" rows="5" maxlength="250"  name="remark"  class="longinput "  placeholder="备注信息描述" style="margin-bottom: 10px;">' + treeNode.remark + '</textarea><br/>';
            	html_ += '<input type="hidden" name="id" value="' + treeNode.id +'" >'; 
            	html_ += '<button class="stdbtn btn_orange " onclick="tfunc.addData(\'' + url_ +'\')"> 提 交 </button>'
            }
            $("#tree-node-edit").append(html_);
        },
        
        /**
         * 添加一个节点到数据库  
         * @param url_
         */
        addData:function(url_){
            var data_ = $("#tree-node-edit").serializeArray();
            var obj = JSON.parse(ajaxs.sendAjax('post' , url_ , data_)); 
            jAlert(obj.msg , '系统提示 ' , tfunc.add_data_call_back(obj));  
        }, 
        add_data_call_back : function(obj){
        	if(obj.status == 'success'){
        		tfunc.sysTreeOperation();
        	}else{
        		
        	}
        },
        
        changeNodeType:function(){ 
        	$("#node-type").empty(); 
        	var val_ = $("#navType").val();
        	$("input[name='funcUrl']").remove();
        	$("input[name='eleType']").remove();
        	$("input[name='eleValue']").remove();
        	var html_ = '';
        	if(val_ == 4){      // 页面按钮
        		html_ = '<div style="margin-bottom: 10px;"><input type="radio" name="eleType" value="elementId" style="margin-left:10px" checked> 元素ID | <input type="radio" name="eleType" value="elementClass" style="margin-left:10px"> 元素Class</div>' 
        		html_ += 'id|class：<input type="text" class="smallinput " placeholder="html的id 或 class值" style="width: 190px; margin-bottom: 10px;" name="eleValue" value="" ><br/>';
        		html_ += '<input type="hidden" name="funcUrl" value="" >';
        		$("#node-type").append(html_); 
        	}else{  // 内部跳转页面 
        		html_ += '<input type="hidden" name="eleType" value="" >';  // 更新时，此处置空
        		html_ += '<input type="hidden" name="eleValue" value="" >';  // 更新时，此处置空 
        		html_ += '跳转地址：<input type="text" class="smallinput " placeholder="exa/example.do" style="width: 190px; margin-bottom: 10px;" name="funcUrl" value="" ><br/>';
        		$("#node-type").append(html_); 
        	}
        },
        
        // 导航与菜单树
        sysTreeOperation: function(){
        	$("#sys-tree li").remove();
        	$($("#tree-node-edit")[0].childNodes).remove();
        	var type_ = 'post';
            var url_ = 'tree_list.do?type=list';
            var data_ = null;  // 可以为null，后台会进行默认处理
            var jsonObj = JSON.parse(ajaxs.sendAjax(type_ , url_ , data_));  
            if(jsonObj.status == 'success'){
                var zNodes = jsonObj.list;
                $.fn.zTree.init($("#sys-tree") , setting_nav , zNodes);
                $("#callbackTrigger").bind("change", {}, setting_nav.setTrigger);
            }
        }, 
        
        // 系统权限分配 - 左侧树
        distributeUserRole: function(){
        	$("#user-role-tree li").remove();
        	var type_ = 'post';
            var url_ = 'tree_list.do?type=role';
            var data_ = null;  // 可以为null，后台会进行默认处理
            var obj = JSON.parse(ajaxs.sendAjax(type_ , url_ , data_));
            if(obj.status == 'success'){
                var zNodes = obj.list;  
                $.fn.zTree.init($("#user-role-tree") , setting_distribution , zNodes);  
                $("#callbackTrigger").bind("change", {}, setting_distribution.setTrigger); 
                // $("#user-role-tree_1_check").css("display", "none");  // 隐藏root节点的复选框  
                $("#user-role-tree_1_check").remove(); // 隐藏root节点的复选框  
            }
        },
        
        /**
         * 系统权限分配 - 右侧已创建的角色列表
         */
        distributeUserRoleList: function(roles){
        	
        },

        /**
         * 开始创建角色
         * 向managercenter.mc_role表、managercenter.mc_role_function表添加数据
         */
        addMcRole:function(){
        	// 开始判断树是否没有被勾选
        	var tree = $.fn.zTree.getZTreeObj("user-role-tree");
        	var checkArray = tree.getChangeCheckedNodes(); // 获取所有被选节点
//        	if(checkArray.length == 0){
//        		jAlert("至少选择一个商户节点!" , '系统提示 ');
//        		return; 
//        	}
        	
        	var ids = ''; 
        	for(var i = 0 ; i < checkArray.length ; i ++){
        		var t = checkArray[i];
        		if(t.navType != -1){
        			ids += t.id + ",";
        		}
        	}
        	ids = ids.substring(0 , ids.length -1);
        	$("#ids").val(ids); 
        	
        	var type_ = 'post';
            var url_ = 'add_mc_role.do';
        	var data_ = $("#user-role-edit").serializeArray();
        	var obj = JSON.parse(ajaxs.sendAjax(type_ , url_ , data_));
            if(obj.status == 'success'){
//            	jAlert("角色添加成功!" , '系统提示 ');
            	alert("角色添加成功!");
            }else{
//            	jAlert(obj.msg , '系统提示 ');
            	alert(obj.msg); 
            }
        }
    };
    
    // 请参阅：zTree_v3-master/api/API_cn.html 和 文件路径: exedit/drag_super.html
    // 导航与菜单树 
    var setting_nav = {
        view: {
            addHoverDom: tfunc.addHoverDom,
            removeHoverDom: tfunc.removeHoverDom,
            selectedMulti: false    // 不允许同时选中多个节点
        },
        edit: {
            drag: {
                autoExpandTrigger: true, // 拖拽时父节点自动展开是否触发 callback.onExpand 事件回调函数
                prev: tfunc.dropPrev, //允许移动到目标节点前面 即可以将同层最后一个节点放到同层的第一个。 
                next: tfunc.dropNext,  // 设置是否允许移动到同层节点的最后一个节点的后面 从而使被移动的节点成为最后一个节点 
                inner: tfunc.dropInner  // 拖拽到目标节点时 设置是否允许成为目标节点的子节点。
            },
            enable: true,  // 设置 zTree 是否处于编辑状态默认false|初始化后需要改变编辑状态请使用 zTreeObj.setEditable() 方法
            showRemoveBtn: tfunc.showRemoveBtn, // 树形控件显示删除按钮
            showRenameBtn: false  // 树形控件显示编辑按钮
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "parentId",
                rootPId: 0
            }
        },
        callback: {
            beforeDrag: tfunc.beforeDrag,         // 捕获节点被拖拽之前的事件回调函数，并且根据返回值确定是否允许开启拖拽操作 |默认值：null
            beforeDrop: tfunc.beforeDrop,         // 捕获节点拖拽操作结束之前的事件回调函数，并且根据返回值确定是否允许此拖拽操作 |默认值：null
            beforeDragOpen: tfunc.beforeDragOpen,  // 获拖拽节点移动到折叠状态的父节点后，即将自动展开该父节点之前的事件回调函数，并且根据返回值确定是否允许自动展开操作 |默认值：null
            onDrag: tfunc.onDrag,                     // 捕获节点被拖拽的事件回调函数 |默认值：null
            onDrop: tfunc.onDrop,                     // 捕获节点拖拽操作结束的事件回调函数 |默认值：null
            onExpand: tfunc.onExpand,           // 捕获节点被展开的事件回调函数 |默认值：null
            onClick: tfunc.ztOnClick,
            beforeRemove: tfunc.beforeRemove,       // 捕获删除之前的数据 
            onRemove:tfunc.onRemove                 // 用于捕获删除节点之后的事件回调函数。   

        },
        setTrigger:function(){
            var zTree = $.fn.zTree.getZTreeObj("sys-tree");
            zTree.setting.edit.drag.autoExpandTrigger = $("#callbackTrigger").attr("checked");
        }
    };

    // 系统权限分配
    var setting_distribution = {
        view: {
            addHoverDom: false,
            removeHoverDom: false,
            selectedMulti: false    // 不允许同时选中多个节点
        },
        check:{
        	enable:true
        }, 
        edit: {
            drag: {
                autoExpandTrigger: true, // 拖拽时父节点自动展开是否触发 callback.onExpand 事件回调函数
                prev: false, //允许移动到目标节点前面 即可以将同层最后一个节点放到同层的第一个。 
                next: false,  // 设置是否允许移动到同层节点的最后一个节点的后面 从而使被移动的节点成为最后一个节点 
                inner: false // 拖拽到目标节点时 设置是否允许成为目标节点的子节点。
            },
            enable: false,  // 设置 zTree 是否处于编辑状态默认false|初始化后需要改变编辑状态请使用 zTreeObj.setEditable() 方法
            showRemoveBtn: false, // 树形控件显示删除按钮
            showRenameBtn: false  // 树形控件显示编辑按钮
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "parentId",
                rootPId: 0
            }
        },
        callback: {
            beforeDrag: false,         // 捕获节点被拖拽之前的事件回调函数，并且根据返回值确定是否允许开启拖拽操作 |默认值：null
            beforeDrop: false,         // 捕获节点拖拽操作结束之前的事件回调函数，并且根据返回值确定是否允许此拖拽操作 |默认值：null
            beforeDragOpen: false,  // 获拖拽节点移动到折叠状态的父节点后，即将自动展开该父节点之前的事件回调函数，并且根据返回值确定是否允许自动展开操作 |默认值：null
            onDrag: false,                     // 捕获节点被拖拽的事件回调函数 |默认值：null
            onDrop: false,                     // 捕获节点拖拽操作结束的事件回调函数 |默认值：null
            onExpand: false,           // 捕获节点被展开的事件回调函数 |默认值：null
            onClick: false,
            beforeRemove: false,       // 捕获删除之前的数据 
            beforeCheck: tfunc.beforeCheck,    // 捕获 勾选 或 取消勾选 之前的事件回调函数
            onCheck : tfunc.onCheck
        },
        setTrigger:function(){
            var zTree = $.fn.zTree.getZTreeObj("user-role-tree");
            zTree.setting.edit.drag.autoExpandTrigger = $("#callbackTrigger").attr("checked");
        }
    };








































