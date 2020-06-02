<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" charset="utf-8">
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
    <!--[if lt IE 9]>-->
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="../../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="../../plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="../../plugins/morris/morris.css">
    <link rel="stylesheet" href="../../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="../../plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="../../plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="../../plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="../../plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="../../plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="../../plugins/select2/select2.css">
    <link rel="stylesheet" href="../../plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="../../plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="../../plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="../../plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="../../plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="../../plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="../../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
    <style type="text/css">
        body, html {
            width: 100%;
            height: 100%;
            overflow: hidden;
            margin: 0;
            font-family: "微软雅黑";
        }

        #map1_container {
            width: 40%;
            height: 95%;
            float: left;
            overflow: hidden;
            margin: 0;
        }

        #map2_container {
            width: 60%;
            height: 95%;
            float: right;
            overflow: hidden;
            margin: 0;
        }
        #map3_container {
            width: 50%;
            height: 50%;
            float: right;
            overflow: hidden;
            margin: 0;
        }
        #map4_container {
            width: 50%;
            height: 50%;
            float: right;
            overflow: hidden;
            margin: 0;
        }

        #allmap1 {
            margin: 0 0 3px;
            height: 100%;
        }

        #allmap2 {
            margin: 3px 0 0;
            height: 100%;
        }
        #allmap3 {
            margin: 3px 0 0;
            height: 100%;
        }
        #allmap4 {
            margin: 3px 0 0;
            height: 100%;
        }
    </style>
    <%--    调用百度api--%>
    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=2.0&ak=9Geom6UGs6jYIG8XR8C1UdUq5LwIpcAd"></script>

</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <%@include file="../../header.jsp" %>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <%@include file="../../sliderbar.jsp" %>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <div id="map1_container">
            <div id="allmap1"></div>
        </div>
        <div id="map2_container">
            <div id="allmap2"></div>
        </div>
    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <%@include file="../../footer.jsp" %>
    <!-- 底部导航 /-->

</div>

<!--引入js文件-->
<script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="../../plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="../../plugins/raphael/raphael-min.js"></script>
<script src="../../plugins/morris/morris.min.js"></script>
<script src="../../plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="../../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="../../plugins/knob/jquery.knob.js"></script>
<script src="../../plugins/daterangepicker/moment.min.js"></script>
<script src="../../plugins/daterangepicker/daterangepicker.js"></script>
<script src="../../plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="../../plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="../../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="../../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="../../plugins/fastclick/fastclick.js"></script>
<script src="../../plugins/iCheck/icheck.min.js"></script>
<script src="../../plugins/adminLTE/js/app.min.js"></script>
<script src="../../plugins/treeTable/jquery.treetable.js"></script>
<script src="../../plugins/select2/select2.full.min.js"></script>
<script src="../../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="../../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="../../plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="../../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="../../plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="../../plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="../../plugins/ckeditor/ckeditor.js"></script>
<script src="../../plugins/input-mask/jquery.inputmask.js"></script>
<script src="../../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="../../plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../../plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="../../plugins/chartjs/Chart.min.js"></script>
<script src="../../plugins/flot/jquery.flot.min.js"></script>
<script src="../../plugins/flot/jquery.flot.resize.min.js"></script>
<script src="../../plugins/flot/jquery.flot.pie.min.js"></script>
<script src="../../plugins/flot/jquery.flot.categories.min.js"></script>
<script src="../../plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="../../plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="../../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="../../plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
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
        setSidebarActive("admin-index");
    });
</script>
<%--地图相关--%>
<script type="text/javascript">

    // 百度地图API功能(第一张图，展示服务点和需求点)
    //第一张地图
    var map1 = new BMap.Map("allmap1");
    var point1 = new BMap.Point(108.984862, 34.232914);
    map1.centerAndZoom(point1, 12);//根据城市名设置地图中心
    map1.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放












    //在地图上一显示服务点
    <c:forEach items="${supplyList}" var="supply">
    var point = new BMap.Point(${supply.supplylongitude}, ${supply.supplylatitude});
    var marker = addMarker(map1, point, false, false);
    var content = "服务点名称：${supply.supplyname}  服务点库存量：${supply.supplycapacity}";
    addClickHandler(map1, content, marker);
    </c:forEach>
    //在地图上一显示需求点
    <c:forEach items="${requireList}" var="require">
    var point = new BMap.Point(${require.requirelongitude}, ${require.requirelatitude});
    addMarker(map1, point, false, true);
    </c:forEach>


    //在地图上二显示服务点及其配送行车路径
    function showMap2(e) {
        var p = e.target;
        var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
        var longitude = p.getPosition().lng;
        var latitude = p.getPosition().lat;
        if (longitude ==${supplyList.get(0).supplylongitude}) {
            $("#map2_container div").attr({id:"allmap2"});
            var map2 = new BMap.Map("allmap2");
            var point2 = new BMap.Point(108.984862, 34.232914);
            map2.centerAndZoom(point2, 12);//根据城市名设置地图中心
            map2.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
            $.get("/map/showVRP",{index:1},function (data) {
                showFirst(point, longitude, latitude,map2);
            });
        }else if(longitude ==${supplyList.get(1).supplylongitude}){//第二个服务点
            $("#map2_container div").attr({id:"allmap3"});
            var map3 = new BMap.Map("allmap3");
            var point3 = new BMap.Point(108.984862, 34.232914);
            map3.centerAndZoom(point2, 12);//根据城市名设置地图中心
            map3.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
            $.get("/map/showVRP",{index:2},function (data) {
                showFirst(point, longitude, latitude,map3);
            });
        }else if(longitude ==${supplyList.get(2).supplylongitude}){
            $("#map2_container div").attr({id:"allmap4"});
            var map4 = new BMap.Map("allmap4");
            var point4 = new BMap.Point(108.984862, 34.232914);
            map4.centerAndZoom(point2, 12);//根据城市名设置地图中心
            map4.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
            $.get("/map/showVRP",{index:3},function (data) {
                showFirst(point, longitude, latitude,map4);
            });
        }

        //用于显示第一个点所规划的路线的函数
        <%@include file="show.jsp"%>
    }




    // 编写自定义函数,创建标注
    function addMarker(map, point, flag, isIcon) {
        var myIcon = null;
        if (isIcon == true) {
            myIcon = new BMap.Icon("/img/photo4.jpg", new BMap.Size(20, 20));
            var marker = new BMap.Marker(point, {icon: myIcon});
            map.addOverlay(marker);
            return marker;
        } else {
            var marker = new BMap.Marker(point, {icon: myIcon});
            map.addOverlay(marker);
            if (flag == true) {
                marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
            }
            return marker;
        }
    }

    //用于显示的信息窗口大小
    var opts = {
        width: 250,     // 信息窗口宽度
        height: 80,     // 信息窗口高度
        title: "基本信息", // 信息窗口标题
        enableMessage: true//设置允许信息窗发送短息
    };

    /**
     * 为多个覆盖点添加信息窗口
     */
    //打开信息
    function openInfo(map, content, e) {
        var p = e.target;
        var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
        var infoWindow = new BMap.InfoWindow(content, opts);  // 创建信息窗口对象
        map.openInfoWindow(infoWindow, point); //开启信息窗口
    }

    //点击覆盖点，处理信息
    function addClickHandler(map, content, marker) {
        marker.addEventListener("click", function (e) {
                openInfo(map, content, e);
                showMap2(e);
            }
        );
    }


</script>
</body>

</html>
<!---->


