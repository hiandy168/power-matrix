
    var tfunc = {
        /**
         * function for edit.drag
         * @param treeId
         * @param nodes
         * @param targetNode
         * @returns {boolean}
         */
        dropPrev:function(treeId, nodes, targetNode) {
            console.log("dropPrev");
            return true;
        },
        /**
         * function for edit.drag
         * @param treeId
         * @param nodes
         * @param targetNode
         * @returns {boolean}
         */
        dropNext:function(treeId, nodes, targetNode) {
            console.log("dropNext");
            return true;
        },
        /**
         * function for edit.drag
         * @param treeId
         * @param nodes
         * @param targetNode
         * @returns {boolean}
         */
        dropInner:function(treeId, nodes, targetNode) {
            console.log("dropInner");
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
                        name:"新建结点" + (newCount++)
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
        onDrop:function(event, treeId, treeNodes, targetNode, moveType, isCopy){

            return true;
        },
        onExpand:function(event, treeId, treeNode){

            return true;
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
                    tfunc.menuEdit(event , treeNode);
                    break;
                case 4: // 2级菜单栏 - 此处对应具体页面
                    tfunc.menuEdit(event , treeNode);
                    break;
                case 5: // 页面按钮(添加|删除|修改等)
                    tfunc.btnEdit(event , treeNode);
                    break;
            }
        },
        /**
         * 编辑商户节点      TODO 2016-06-20      需要计算同层所有节点，然后得出顺序码      |  添加是否成功尚未测试
         * @param event
         * @param treeNode
         */
        firstLevelEdit:function(event , treeNode){
            $($("#tree-node-edit")[0].childNodes).remove();

            var html_ = '';
            var type_ = 'post';
            var url_ = 'list_company.do';
            var obj = JSON.parse(ajaxs.sendAjax(type_ , url_ , null));
            if(obj.status == 'success'){
                url_ = 'add_info.do';  // url 重新赋值
                var options = obj.list;
                html_ = '<select name="companyId" class="uniformselect " style="height: 30px; width: 200px;margin-bottom: 10px;">';
                html_ += '<option value="">请选择商户</option>';
                for(var i = 0 ; i < options.length ; i ++){
                    html_ += '<option value="' + options[i].id + '">' + options[i].companyName + '</option>';
                }
                html_ += '</select><br/>';
                html_ += '<input type="text" name="name" class="smallinput " placeholder="功能名称" style="width: 190px; margin-bottom: 10px;">';
                html_ += '<textarea cols="80" rows="5" maxlength="250"  name="remark"  class="longinput "  placeholder="备注信息描述" style="margin-bottom: 10px;"></textarea><br/>';
                html_ += '<input type="hidden" name="parent_id" value="' + treeNode.parentId +'" >';


                var preNode = treeNode.getPreNode();              // TODO 2016-06-20  seqnum  需要计算同层所有节点，然后得出顺序码

                var aa = treeNode.getIndex();
                var ab = treeNode.getNextNode();
                var ac = treeNode.getParentNode();
                var ad = treeNode.getPreNode();

                html_ += '<input type="hidden" name="seqnum" value="' + treeNode.parentId +'" >';



                html_ += '<input type="hidden" name="nav_type"  value="0" >';
                html_ += '<input type="hidden" name="style_class" value="" >';
                html_ += '<input type="hidden" name="style_key" value="" >';
                html_ += '<input type="hidden" name="func_url" value="" >';

                html_ += '<button class="stdbtn btn_orange " onclick="tfunc.addData(\'' + url_ +'\')"> 提 交 </button>'
            }else{
            }


            $("#tree-node-edit").append(html_);
        },
        /**
         * 编辑导航栏
         * @param event
         * @param treeNode
         */
        navEdit:function(event , treeNode){

        },
        /**
         * 编辑菜单栏
         * @param event
         * @param treeNode
         */
        menuEdit:function(event , treeNode){

        },
        /**
         * 编辑一级菜单栏
         * @param event
         * @param treeNode
         */
        fMenuEdit:function(event , treeNode){

        },
        /**
         * 编辑二级菜单栏
         * @param event
         * @param treeNode
         */
        sMenuEdit:function(event , treeNode){

        },
        /**
         * 编辑按钮节点
         * @param event
         * @param treeNode
         */
        btnEdit:function(event ,treeNode){

        },
        /**
         * 添加一个节点到数据库     TODO 2016-06-20
         * @param url_
         */
        addData:function(url_){
            var data_ = $("#tree-node-edit").serializeArray();
            var obj = JSON.parse(ajaxs.sendAjax('post' , url_ , data_));
            var bb = 0;
        }

    }
    
    // 请参阅：zTree_v3-master/api/API_cn.html 和 文件路径: exedit/drag_super.html

    var setting = {
        view: {
            addHoverDom: tfunc.addHoverDom,
            removeHoverDom: tfunc.removeHoverDom,
            selectedMulti: false    // 不允许同时选中多个节点
        },
        edit: {
            drag: {
                autoExpandTrigger: true, // 拖拽时父节点自动展开是否触发 callback.onExpand 事件回调函数
                prev: tfunc.dropPrev, //允许移动到目标节点前面 即可以将同层最后一个节点放到同层的第一个。此处可重写一个方法 dropPrev进行更多操作,
                next: tfunc.dropNext,  // 设置是否允许移动到同层节点的最后一个节点的后面 从而使被移动的节点成为最后一个节点 此处可重写一个方法dropNext
                inner: tfunc.dropInner  // 拖拽到目标节点时 设置是否允许成为目标节点的子节点。TODO 此处必须重写一个方法 dropInner 进行判断，如果是三级节点到二级节点则允许
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
            onClick: tfunc.ztOnClick

        },

        setTrigger:function(){
            var zTree = $.fn.zTree.getZTreeObj("sys-tree");
            zTree.setting.edit.drag.autoExpandTrigger = $("#callbackTrigger").attr("checked");
        }


    };

    var zNodes2 =[
        { id:0, parentId:-1, name:"root：系统功能树 level=0", open:true  },
        { id:1, parentId:0, name:"惠家有 level=1", open:true},
        { id:2, parentId:1, name:"导航栏-1", seqnum:1 },
        { id:3, parentId:2, name:"菜单栏-1 - 1级", open:true},
        { id:4, parentId:3, name:"2级菜单栏- 1"},
        { id:5, parentId:3, name:"2级菜单栏- 2"},
        { id:6, parentId:3, name:"2级菜单栏- 3"},

        { id:7, parentId:1, name:"导航栏-2 level=2", open:true ,  seqnum:2 },
        { id:8, parentId:7, name:"菜单栏-2 - 1级 level=3", open:true , seqnum:1},
        { id:9, parentId:8, name:"2级菜单栏- 1" , seqnum:1},
        { id:10, parentId:8, name:"2级菜单栏- 2 level=4", open:true , seqnum:2},
        { id:21, parentId:10, name:"添加按钮 level=5" , seqnum:1},
        { id:22, parentId:10, name:"删除按钮" , seqnum:2},
        { id:23, parentId:10, name:"修改按钮" , seqnum:3},

        { id:11, parentId:0, name:"合作商户=1", open:true, childOuter:false}, // 禁止子节点移走 2
        { id:12, parentId:11, name:"导航栏-1", open:true},
        { id:13, parentId:12, name:"菜单栏-1 - 1级", open:true},
        { id:14, parentId:13, name:"2级菜单栏- 1"},
        { id:15, parentId:13, name:"2级菜单栏- 2"},
        { id:16, parentId:13, name:"2级菜单栏- 3"},

        { id:17, parentId:11, name:"导航栏-2", open:true},
        { id:18, parentId:17, name:"菜单栏-2 - 1级", open:true},
        { id:19, parentId:18, name:"2级菜单栏- 1"},
        { id:20, parentId:18, name:"2级菜单栏- 2"},

    ];


    /**
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */

    function setTrigger(){
        var zTree = $.fn.zTree.getZTreeObj("sys-tree");
        zTree.setting.edit.drag.autoExpandTrigger = $("#callbackTrigger").attr("checked");
    }








































