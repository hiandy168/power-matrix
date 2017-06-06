


var login = {

    /**
     * 登录相关类
     */
    login:function(formId){
        var url_ = 'manager/login.do';
        var data_ = $('#' + formId).serializeArray();
        var object = JSON.parse(ajaxs.sendAjax('post' , url_ , data_));
        if(object.status == 'success'){
        	if(object.data == undefined || object.data == ""){
        		jAlert("未检查到您有任何权限，请联系系统管理员！" , "系统提示" , function(){
        			return;
        		});
        	}else{
        		localStorage.pageJson = object.data;
        		localStorage.userInfo = object.info
        		window.location.href='manager/page_manager_home.do';
        	}
        }else{
        	jAlert(object.msg);
        }
    },

    /**
     * 退出相关类
     */
    logout:function(base){
    	localStorage.clear();
    	var url_ = base + 'manager/logout.do';
        var data_ = null;
        var object = JSON.parse(ajaxs.sendAjax('post' , url_ , data_));
        if(object.status == 'success'){
        	window.location.href=base + "login.jsp";
        }
    },

    /**
     * 记住密码 TODO 可以用Js的方式保存密码
     */
    keepPassword:function(){

    }


}



























