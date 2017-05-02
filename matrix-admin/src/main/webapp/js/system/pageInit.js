
/**
 * pageInit对象用于整个页面绘制和初始化的过程
 * 使用sessionStorage，当用户关闭浏览器或点击退出按钮则失效。
 */
var pageInit = {

		page:null,
		
		init:function(obj){
			this.page = obj;
			pageInit.drawNavList(obj);
			pageInit.drawMenuList(obj);
		},
		
		/**
		 * 初始化导航栏，在top.jsp中
		 * @param obj
		 */
		drawNavList:function(obj){
			
		},
		
		/**
		 * 初始化菜单栏，在left.jsp中
		 * @param obj
		 */
		drawMenuList:function(obj){
			
		}
	 
		

}


