


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
        		return;
        	}
        	localStorage.pageJson = object.data;
            window.location.href='manager/page_manager_index.do';
        }else{
            alert(object.msg);
        }
    },

    /**
     * 退出相关类
     */
    logout:function(){
    	localStorage.pageJson = "";
    },

    /**
     * 记住密码 TODO 可以用Js的方式保存密码
     */
    keepPassword:function(){

    }


}


