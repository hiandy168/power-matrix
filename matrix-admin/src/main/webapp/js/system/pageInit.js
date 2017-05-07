
/**
 * pageInit对象用于整个页面绘制和初始化的过程
 * 使用sessionStorage，当用户关闭浏览器或点击退出按钮则失效。
 */
var pageInit = {

	page:null,

	init:function(obj){
		pageInit.pageInit(obj);
		pageInit.drawNavList(this.page);
		pageInit.drawMenuList(this.page);
	},

	pageInit:function(obj){
		var narr = new Array();
		var arr = obj.msfList; // 保存导航信息
		for(var i = 0 ; i < arr.length ; i ++){
			var nav = new Object();
			nav.seqnum = null;  // 排序信息
			nav.data = null;  // 导航栏详细信息
			nav.fmenus = new Array; // 一级菜单栏列表
			if(arr[i].navType == 1){
				nav.seqnum = arr[i].seqnum;
				nav.data = arr[i];
				var id = arr[i].id;
				// 开始查找 一级菜单栏
				for(var f = 0 ; f < arr.length ; f ++){
					if(arr[f].parentId == id){
						var fmenu = new Object();
						fmenu.seqnum = arr[f].seqnum;  // 排序信息
						fmenu.data = arr[f];  //  一级菜单栏详细信息
						var fid = arr[f].id;  // 一级菜单栏id
						fmenu.smenus = new Array();      // 二级菜单栏列表
						for(var s = 0 ; s < arr.length ; s ++){
							if(arr[s].parentId == fid){
								var smenu = new Object();
								smenu.seqnum = arr[s].seqnum;  // 排序信息
								smenu.data = arr[s];   //  二级菜单栏详细信息
								var sid = arr[s].id; // 二级菜单栏id
								smenu.btns = new Array();  // 二级菜单栏下的按钮集合
								for(var b = 0 ; b < arr.length ; b ++){
									if(arr[b].parentId == sid){
										var btn = new Object();
										btn.seqnum = arr[b].seqnum;
										btn.data = arr[b];
										smenu.btns.push(btn);
									}
								}
								fmenu.smenus.push(smenu);
							}
						}
						nav.fmenus.push(fmenu);
					}
				}
				narr.push(nav);
			}
		}

		this.page = narr;
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


