<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


        <script type="text/javascript">
            $(function(){
                $('.vernav2 > ul > li > ul > li').removeClass("current");
                $("#" + getCookie('liselect')).addClass("current");

                $('.vernav2 > ul > li > ul > li').click("onclick" , function(){
                    clearCookie('liselect');
                    setCookie('liselect' , this.id , '1'); 
                });

            });
            
           function setCookie(cname, cvalue, exdays) {
              var d = new Date();
              d.setTime(d.getTime() + (exdays*24*60*60*1000));
              var expires = "expires="+d.toUTCString();
              document.cookie = cname + "=" + cvalue + "; " + expires + "; path=/";
            }
            
            function getCookie(c_name) {
                if (document.cookie.length > 0) {
                    var c_start = document.cookie.indexOf(c_name + "=");
                    if (c_start != -1) {
                      c_start = c_start + c_name.length + 1;
                      var c_end = document.cookie.indexOf(";", c_start);
                      if (c_end == -1)
                          c_end = document.cookie.length;
                      return unescape(document.cookie.substring(c_start, c_end));
                    }
                }
              return "";
            }

            function clearCookie(name) {
              setCookie(name, "", -1);
            }
            
            function iframeTest(obj){
            	var url = $(obj);  
            	$("#sub-page").attr("src" , "http://localhost:8080/matrix-admin/manager/page_manager_index1.do"); 
            }
        </script>
	<div id="left-menu">
		<%-- nav 类代表导航栏 无任何样式应用|每个导航栏对应的菜单显示与否由id来决定--%>
	</div>















