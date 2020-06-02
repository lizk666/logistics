<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <link rel="stylesheet" href="/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="/plugins/morris/morris.css">
    <link rel="stylesheet" href="/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="/plugins/select2/select2.css">
    <link rel="stylesheet" href="/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
    <link rel="stylesheet" href="/css/require.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <%@include file="header.jsp" %>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <%@include file="sliderbar.jsp" %>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                需求点管理
                <small>全部需求点</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href=<%request.getContextPath();%>"/index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="/require/findAll">需求点管理</a></li>
                <li class="active">需求点列表</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">需求点列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="添加"
                                            onclick='location.href="/require-add.jsp"'><i
                                            class="fa fa-file-o"></i> 添加
                                    </button>
                                    <button type="button" class="btn btn-default" title="删除"
                                            onclick='delSelected()'><i class="fa fa-trash-o"></i> 删除
                                    </button>
                                    <button type="button" class="btn btn-default" title="刷新"
                                            onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm" placeholder="搜索">
                                <span class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </div>
                        <!--工具栏/-->

                        <!--数据列表-->
                        <form action="/require/delSelected" method="post" id="checkform">
                            <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                <tr>
                                    <th class="" style="padding-right:0px;">
                                        <input id="selall" type="checkbox" class="checkstyle">
                                    </th>
                                    <th class="sorting_asc">ID</th>
                                    <th class="sorting">需求点名称</th>
                                    <th class="sorting">需求点经度</th>
                                    <th class="sorting">需求点纬度</th>
                                    <th class="sorting">需求量</th>
                                    <th class="sorting">满意度</th>

                                    <th class="text-center">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pb_require.list}" var="require" varStatus="id">
                                    <tr>
                                        <td><input name="ids" class="checkstyle" value="${require.id}" type="checkbox"></td>
                                        <td>
                                                ${id.index+1}
                                        </td>
                                        <td>${require.requirename}</td>
                                        <td>${require.requirelongitude}</td>
                                        <td>${require.requirelatitude}</td>
                                        <td>${require.requirecapacity}</td>
                                        <td>${require.satisfy}</td>


                                        <td class="text-center">
                                            <button type="button" class="btn bg-olive btn-xs"
                                                    onclick='showUserDetail(${require.id})'>
                                                详情
                                            </button>
                                            <button type="button" class="btn bg-olive btn-xs"
                                                    onclick='updateUser(${require.id})'>修改
                                            </button>
                                            <button type="button" class="btn bg-olive btn-xs"
                                                    onclick='del(${require.id})'>删除
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                        </form>
                    </div>
                </div>
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            总共${pb_require.totalPage}页，共${pb_require.totalCount} 条数据。
                        </div>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <c:if test="${require.currentPage==1}">
                            <li class="disabled">
                                </c:if>
                                <c:if test="${require.currentPage!=1}">
                            <li>
                                </c:if>
                                <a href="/require/findAll?currentPage=${pb_require.currentPage-1}&rows=8">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>

                            <c:forEach begin="1" end="${pb_require.totalPage}" var="i">
                                <c:if test="${pb_require.currentPage==i}">
                                    <li class="active"><a
                                            href="/require/findAll?currentPage=${i}&rows=8">${i}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pb_require.currentPage!=i}">
                                    <li>
                                        <a href="/require/findAll?currentPage=${i}&rows=8">${i}</a>
                                    </li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${pb_require.currentPage==pb_require.totalPage}">
                            <li class="disabled">
                                </c:if>
                                <c:if test="${pb_supply.currentPage!=pb_supply.totalPage}">
                            <li>
                                </c:if>

                                <a href="/require/findAll?currentPage=${pb_require.currentPage+1}&rows=8" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /.box-footer-->


            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <%@include file="footer.jsp" %>
    <!-- 底部导航 /-->

</div>

<script src="/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/plugins/raphael/raphael-min.js"></script>
<script src="/plugins/morris/morris.min.js"></script>
<script src="/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/plugins/knob/jquery.knob.js"></script>
<script src="/plugins/daterangepicker/moment.min.js"></script>
<script src="/plugins/daterangepicker/daterangepicker.js"></script>
<script src="/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="/plugins/fastclick/fastclick.js"></script>
<script src="/plugins/iCheck/icheck.min.js"></script>
<script src="/plugins/adminLTE/js/app.min.js"></script>
<script src="/plugins/treeTable/jquery.treetable.js"></script>
<script src="/plugins/select2/select2.full.min.js"></script>
<script src="/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="/plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="/plugins/ckeditor/ckeditor.js"></script>
<script src="/plugins/input-mask/jquery.inputmask.js"></script>
<script src="/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="/plugins/chartjs/Chart.min.js"></script>
<script src="/plugins/flot/jquery.flot.min.js"></script>
<script src="/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="/plugins/flot/jquery.flot.categories.min.js"></script>
<script src="/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    $(document).ready(function () {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });


    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }


    $(document).ready(function () {

        // 激活导航位置
        setSidebarActive("order-manage");
        // 全选操作
        $("#selall").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
</script>

<script>
    //删除单个车辆
    function del(id) {
        //用户安全提示
        //判断是否有条目被选种
        if (confirm("您真的要删除吗？")) {
            location.href = "${pageContext.request.contextPath}/require/deleteRequire?id=" + id;
        }
    }

    <!--删除选中-->
    function delSelected() {
        //获取表单
        //用户安全提示
        var checkform = document.getElementById("checkform");
        var uids = document.getElementsByName("ids");
        var flag = false;
        for (var i = 0; i < uids.length; i++) {
            //判断是否有条目被选种
            if (uids[i].checked) {
                flag = true;
                break;
            }
        }
        if (flag) {
            if (confirm("您确定要删除吗?")) {
                checkform.submit();
            }
        }


    }

    <!--修改用户-->
    function updateUser(id) {
        location.href = "${pageContext.request.contextPath}/require/updateRequire?id=" + id;
    }
    <!--查看用户详细信息-->
    function showUserDetail(id) {
        location.href = "${pageContext.request.contextPath}/require/requireDetail?id=" + id;
    }
</script>
</body>

</html>

