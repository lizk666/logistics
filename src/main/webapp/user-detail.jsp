<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">


    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- iCheck -->
    <!-- Morris chart -->
    <!-- jvectormap -->
    <!-- Date Picker -->
    <!-- Daterange picker -->
    <!-- Bootstrap time Picker -->
    <!--<link rel="stylesheet" href="./././plugins/timepicker/bootstrap-timepicker.min.css">-->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--数据表格-->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- Bootstrap Color Picker -->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--bootstrap-markdown-->
    <!-- Theme style -->
    <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
    <!-- Ion Slider -->
    <!-- ion slider Nice -->
    <!-- bootstrap slider -->
    <!-- bootstrap-datetimepicker -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="./plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="./plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="./plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="./plugins/morris/morris.css">
    <link rel="stylesheet" href="./plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="./plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="./plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="./plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="./plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="./plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="./plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="./plugins/select2/select2.css">
    <link rel="stylesheet" href="./plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="./plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="./plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="./plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="./plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="./plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="./plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
    <link rel="stylesheet" href="/css/user.css">
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
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
                <small>用户详情</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/WEB-INF/pages/index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">用户管理</a></li>
                <li class="active">用户详情</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row background">

                <!-- right column -->
                <div class="col-md-6 form-center">
                    <!-- Horizontal Form -->
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">用户详情</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form action="/user/findAll" class="form-horizontal" method="post">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>

                                    <div class="col-sm-10">
                                        <input type="text" name="name" class="form-control" value="${pageContext.session.getAttribute('find_user').name}" id="inputEmail3" placeholder="姓名">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputPassword3" class="col-sm-2 control-label">邮箱</label>

                                    <div class="col-sm-10">
                                        <input type="text" name="email" value="${pageContext.session.getAttribute('find_user').email}" class="form-control" placeholder="邮箱">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>

                                    <div class="col-sm-10">
                                        <input type="text" name="password" value="${pageContext.session.getAttribute('find_user').password}" class="form-control" id="inputPassword3"
                                               placeholder="密码">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputPassword3" class="col-sm-2 control-label">性别</label>
                                    <div class="col-sm-10">
                                        <c:if test="${find_user.gender==null}">
                                            <input type="radio" value="男" name="gender"/>男
                                            <input type="radio" value="女" name="gender"/>女
                                        </c:if>
                                        <c:if test="${find_user.gender=='男'}">
                                            <input type="radio" value="男" checked name="gender"/>男
                                            <input type="radio" value="女" name="gender"/>女
                                        </c:if>
                                        <c:if test="${find_user.gender=='女'}">
                                            <input type="radio" value="男" name="gender"/>男
                                            <input type="radio" value="女" checked name="gender"/>女
                                        </c:if>

                                        <div>

                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputPassword3" class="col-sm-2 control-label">年龄</label>

                                    <div class="col-sm-10">
                                        <input type="text" name="age" value="${pageContext.session.getAttribute('find_user').age}" class="form-control" id="inputPassword3" placeholder="年龄">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputPassword3" class="col-sm-2 control-label">QQ</label>

                                    <div class="col-sm-10">
                                        <input type="text" name="qq" value="${pageContext.session.getAttribute('find_user').qq}" class="form-control" id="inputPassword3" placeholder="QQ">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputPassword3" class="col-sm-2 control-label">职位</label>

                                    <div class="col-sm-10">
                                        <input type="text" name="position" value="${pageContext.session.getAttribute('find_user').position}" class="form-control" id="inputPassword3" placeholder="职位">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputPassword3" class="col-sm-2 control-label">家庭地址</label>

                                    <div class="col-sm-10">
                                        <input type="text" name="address" value="${pageContext.session.getAttribute('find_user').address}" class="form-control" id="inputPassword3" placeholder="家庭地址">
                                    </div>
                                </div>

                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-default">返回</button>
                            </div>
                            <!-- /.box-footer -->
                        </form>
                    </div>

                    <!-- /.box -->
                </div>
                <!--/.col (right) -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <%@include file="footer.jsp" %>
    <!-- 底部导航 /-->

</div>


<script src="./plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="./plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="./plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="./plugins/raphael/raphael-min.js"></script>
<script src="./plugins/morris/morris.min.js"></script>
<script src="./plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="./plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="./plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="./plugins/knob/jquery.knob.js"></script>
<script src="./plugins/daterangepicker/moment.min.js"></script>
<script src="./plugins/daterangepicker/daterangepicker.js"></script>
<script src="./plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="./plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="./plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="./plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="./plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="./plugins/fastclick/fastclick.js"></script>
<script src="./plugins/iCheck/icheck.min.js"></script>
<script src="./plugins/adminLTE/js/app.min.js"></script>
<script src="./plugins/treeTable/jquery.treetable.js"></script>
<script src="./plugins/select2/select2.full.min.js"></script>
<script src="./plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="./plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="./plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="./plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="./plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="./plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="./plugins/ckeditor/ckeditor.js"></script>
<script src="./plugins/input-mask/jquery.inputmask.js"></script>
<script src="./plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="./plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="./plugins/datatables/jquery.dataTables.min.js"></script>
<script src="./plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="./plugins/chartjs/Chart.min.js"></script>
<script src="./plugins/flot/jquery.flot.min.js"></script>
<script src="./plugins/flot/jquery.flot.resize.min.js"></script>
<script src="./plugins/flot/jquery.flot.pie.min.js"></script>
<script src="./plugins/flot/jquery.flot.categories.min.js"></script>
<script src="./plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="./plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="./plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="./plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
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


    // 激活导航位置
    setSidebarActive("form-general");
</script>
</body>

</html>
