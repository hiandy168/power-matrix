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
        </script>
	<div id="left-menu">
		<%-- nav 类代表导航栏 无任何样式应用|每个导航栏对应的菜单显示与否由id来决定--%>
        <div id="f-menu-1" class="vernav2 iconmenu nav" style="display: none">
            <ul class="nav-bar-ul"> 
                <!-- 此处应放入到系统维护导航栏中-->
                 <li class="current">
                    <a href="#example" class="inbox">开发者快速入门</a>
                    <span class="arrow"></span>
                    <ul id="example">
                    	<li id="li-4">
                        	<a href="${basePath}example/addInfoPage.do">添加信息示例</a>
                        </li>
                        
                        <li id="li-5">
                        	<a href="${basePath}example/ajaxFormExample.do">Ajax 分页示例</a>
                        </li>
                        
                        <li id="li-6">
                        	<a href="${basePath}example/ajaxFormDialogExample.do">Ajax 分页+弹出窗体分页 示例</a>
                        </li>

                        <li id="li-7">
                        	<a href="${basePath}example/alertExample.do">自定义 alert confirm note 示例</a>
                        </li>
                        
                        <li id="li-8">
                        	<a href="${basePath}example/example_a.do">实际样本-A</a>
                        </li>
                        
                        <li id="li-9">
                        	<a href="${basePath}example/example_b.do">实际样本-B</a>
                        </li>
                    </ul>
                </li>

                <!-- 此处应放入到系统维护导航栏中-->
                <!-- <li class="current">
                    <a href="#platform-user" class="inbox">平台用户指南</a>
                    <span class="arrow"></span>
                    <ul id="platform-user">
                        <li id="li-9">
                            <a href="">使用规则</a>
                        </li> 
                    </ul>
                </li> -->

            </ul>
            <a class="togglemenu"></a>
            <br />
            <br />
        </div>


        <%-- 切换导航栏的时候 这里的菜单来应该默认打开 从而配合【Plus】按钮进行菜单的全部打开或者全部收起--%>
        <div id="f-menu-2" class="vernav2 iconmenu nav" style="display: none">
	        <ul class="nav-bar-ul"> 
		 		<li class="current">
	                 <a href="#platform-user" class="inbox">平台用户指南</a>
	                 <span class="arrow"></span>
	                 <ul id="platform-user">
	                     <li id="li-9">
	                         <a href="">使用规则</a>
	                     </li> 
	                 </ul>
	             </li>
	        </ul>
        	<a class="togglemenu"></a>
        	<br />
        	<br />
        </div>

        <div id="nav-bar-3" class="vernav2 iconmenu nav" style="display: none">

        </div>

        <div id="nav-bar-4" class="vernav2 iconmenu nav" style="display: none">

        </div>
	</div>















