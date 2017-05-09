
/**
 * pageInit对象用于整个页面绘制和初始化的过程
 * 使用sessionStorage，当用户关闭浏览器或点击退出按钮则失效。
 */
var pageInit = {

	page:null,

	init:function(obj){
		pageInit.pageInit(obj);
		// TODO 判断一下是不是已经加载完成了，如果是则没有必要全部重绘，改变显隐状态就可以。
		pageInit.drawNavList();
		pageInit.drawMenuList();

		if(sessionStorage.nav_id != undefined){
			$("#" + sessionStorage.nav_id).addClass("current");
		}else{
			$($("#nav-list li")[0]).addClass("current");  // 登陆进入则默认加载第一个导航
		}
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
	 */
	drawNavList:function(){
		var arr = this.page;
		var html_ = '';
		if(arr.length == 0){
			return;
		}
		for(var i = 0 ; i < arr.length ; i ++){
			html_ += '<li id="nav-' + arr[i].data.id + '" onclick="pageInit.navChange(this)" style="display:block; width:200px">';
				html_ += '<a href="javascript:void(0)">' + arr[i].data.name + '</a>';
			html_ += '</li>';
		}

		$("#nav-list").append(html_);
	},
		
	/**
	 * 初始化菜单栏，在left.jsp中
	 */
	drawMenuList:function(){
		var arr = this.page;
		var html_ = '';
		if(arr.length == 0){
			return;
		}
		var url = "${basePath}"; 
		for(var i = 0 ; i < arr.length ; i ++){
			html_ += '<div id="" class="vernav2 iconmenu nav">';  
			html_ += '';
			html_ += '';
			html_ += '';
			html_ += '';
			html_ += '';
			html_ += '';
			html_ += '';
			html_ += '';
			
			html_ += '';
			html_ += '';html_ += '';
			
			html_ += '';
			html_ += '';
			html_ += '';
			html_ += '';
			
		}
		$("#left-menu").append(html_);
	},

	/**
	 * 导航栏切换
	 * @param obj
	 */
	navChange:function(obj){
		$("#nav-list li").removeClass("current");
		$(obj).addClass("current");
		sessionStorage.nav_id = $(obj)[0].id;

		// TODO 显示和隐藏左侧菜单栏
	}
	
		

}













