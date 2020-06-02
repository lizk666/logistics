<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 导航侧栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>java123</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <!-- search form -->
        <!--<form action="#" method="get" class="sidebar-form">
<div class="input-group">
    <input type="text" name="q" class="form-control" placeholder="搜索...">
    <span class="input-group-btn">
    <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
    </button>
  </span>
</div>
</form>-->
        <!-- /.search form -->


        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="/map/showPoint"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <!-- 菜单 -->


            <li class="treeview">
                <a href="/user/findAll">
                    <i class="fa fa-folder"></i> <span>用户管理</span>
                    <span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
								</span>
                </a>

            </li>

            <li class="treeview">
                <a href="/vehicle/findAll">
                    <i class="fa fa-folder"></i> <span>车辆管理</span>
                    <span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
								</span>
                </a>

            </li>


            <li class="treeview">
                <a href="/supply/findAll">
                    <i class="fa fa-folder"></i> <span>服务点管理</span>
                    <span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
								</span>
                </a>
            </li>


            <li class="treeview">
                <a href="/require/findAll">
                    <i class="fa fa-folder"></i> <span>需求点管理</span>
                    <span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
								</span>
                </a>
            </li>
            <li class="treeview">
                <a href="http://api.map.baidu.com/lbsapi/getpoint/" target="_blank">
                    <i class="fa fa-folder"></i> <span>坐标选取系统</span>
                    <span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
								</span>
                </a>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<!-- 导航侧栏 /-->
