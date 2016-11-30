
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="sitenav">
        <meta name="author" content="srnpr">
        <title>能量矩阵API开放平台</title>

        <!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

        <link href="../api_pages/css/bootthree/bootstrap.min.css" rel="stylesheet">
        <link href="../api_pages/css/w.css" rel="stylesheet">
        <link href="../api_pages/css/grumble/grumble.min.css" rel="stylesheet">
        
     	<script src="../api_pages/js/jquery-1.10.2.js"></script>
		<script src="../api_pages/js/bootthree/bootstrap.min.js"></script>
		<script src="../api_pages/js/grumble/jquery.grumble.min.js"></script>
        

        <style>
            html,body {
                overflow-x: hidden; /* Prevent scroll on narrow devices */
            }
            footer {
                padding: 30px 0;
            }
            @media screen and (max-width: 767px) {
                .row-offcanvas {
                    position: relative;
                    -webkit-transition: all 0.25s ease-out;
                    -moz-transition: all 0.25s ease-out;
                    transition: all 0.25s ease-out;
                }
                .row-offcanvas-right
                .sidebar-offcanvas {
                    right: -50%; /* 6 columns */
                }
                .row-offcanvas-left
                .sidebar-offcanvas {
                    left: -50%; /* 6 columns */
                }
                .row-offcanvas-right.active {
                    right: 50%; /* 6 columns */
                }
                .row-offcanvas-left.active {
                    left: 50%; /* 6 columns */
                }
                .sidebar-offcanvas {
                    position: absolute;
                    top: 0;
                    width: 50%; /* 6 columns */
                }
            }
        </style>
        <style>
            body {
                font-family: "Microsoft Yahei", Verdana, Simsun, "Segoe UI Light" ;
                word-wrap: break-word;
            }
            .navbar-inverse {
                background-color: #1fa67a;
                border-color: #1fa67a;
                border-radius:0px;
                border:0px;
                border-top: 1px solid #34a782;
                border-bottom: 1px solid #1c9971;
            }
            .navbar-inverse .navbar-brand {
                color: #fff;
            }
            .navbar-inverse .navbar-nav>li>a {
                color: #fff;
            }
            .index_listbox .list-group-item a {
                padding-left: 12px;
            }
            .navbar-inverse .navbar-nav>.active>a,.navbar-inverse .navbar-nav>.active>a:hover,.navbar-inverse .navbar-nav>.active>a:focus
            {
                background-color: #1c9971;
            }
        </style>


        <script>
            function func_open_rumble(s)
            {
                $('#'+s+' span').grumble(
                        {
                            text: '结构描述',
                            angle: 240,
                            distance: 0,
                            showAfter: 300,
                            //type: 'alt-',
                            hideAfter: 3000
                        }
                );
            }
        </script>

    </head>
    <body>
        <div class="navbar  navbar-inverse" role="navigation">
            <div class="container">
                <div class="navbar-header">

                    <a class="navbar-brand" href="?"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;仓颉开放平台</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="?">首页</a></li>
                        <li><a href="?">API文档</a></li>
                        <li><a href="apitest" target="_blank">沙箱测试</a></li>
                        <li><a href="?">SDK下载</a></li>
                        <li><a href="?">技术支持</a></li>
                    </ul>
                </div>
                <!-- /.nav-collapse -->
            </div>
            <!-- /.container -->
        </div>
        <!-- /.navbar -->

        <div class="container">
            <ol class="breadcrumb">
                <li><a href="?">首页</a></li>
                <li class="active">  			测试类目</li>
            </ol>
            <div class="row row-offcanvas row-offcanvas-right">
                <div class="col-xs-3 col-sm-3 sidebar-offcanvas" id="sidebar"
                     role="navigation">
                    <div >
                        <div class="list-group">
                            <a href="?apicode=467701090001" class="list-group-item active">
                                <span class="glyphicon glyphicon-log-out"></span>
                                &nbsp;&nbsp;测试类目
                            </a>
                            <a href="?apicode=467701090002" class="list-group-item">商品相关</a>
                            <a href="?apicode=467701090005" class="list-group-item">系统调用</a>
                        </div>
                    </div>
                </div>
                <!--/span-->
                <div class="col-xs-9 col-sm-9">
                    <a href="#" class="btn btn-warning btn-block">测试类目-API列表</a>
                    <div class="w_h_40"></div>
                    <table class="table">
                        <tr>
                            <td>
                                <span class="label label-danger">
                                    <span class="glyphicon glyphicon-star"></span>
                                    &nbsp;私有&nbsp;&nbsp;
                                </span>
                                &nbsp;&nbsp;
                                <a href="?apicode=4677010900010001" > com_srnpr_zapweb_demo_DemoApiProcess </a>
                                <div class="w_h_10"></div>
                            </td>
                            <td>
                                <a href="?apicode=4677010900010001" >测试API</a>
                            </td>
                        </tr>
                    </table>
                </div>
                <!--/span-->
            </div>
            <!--/row-->
            <hr>
            <footer>
                <p>&copy; Company 2013</p>
            </footer>

        </div>
        <!--/.container-->
    </body>
</html>

