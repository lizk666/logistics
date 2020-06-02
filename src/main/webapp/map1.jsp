<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
    </style>
<%--    调用百度api--%>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=3.0&ak=9Geom6UGs6jYIG8XR8C1UdUq5LwIpcAd"></script>
    <title>根据起终点经纬度驾车导航</title>
</head>
<body>
<div id="allmap"></div>
<%--<div id="map1_container"><div id="allmap2"></div></div>--%>
</body>
</html>
<script type="text/javascript">

    // 百度地图API功能(第一张图，展示服务点和需求点)
    //第一张地图
    var map = new BMap.Map("allmap");
    var point1 = new BMap.Point(108.984862,34.232914);
    var point2 = new BMap.Point(108.925258,34.229342);

    map.centerAndZoom(point1, 12);//根据城市名设置地图中心
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
    //自定义地图样式
    map.setMapStyleV2({
        styleId: '37fa600f77be6f5d03b59416400d9186'
    });
    //在地图上显示服务点
    <c:forEach items="${supplyList}" var="supply">
        var point = new BMap.Point(${supply.supplylongitude},${supply.supplylatitude});
        addMarker(point,true,false);
    </c:forEach>
    //在地图上显示需求点
    <c:forEach items="${requireList}" var="require">
    var point = new BMap.Point(${require.requirelongitude},${require.requirelatitude});
    addMarker(point,false,true);
    </c:forEach>

    // 编写自定义函数,创建标注
    function addMarker(point,flag,isIcon){
        var myIcon=null;
        if(isIcon==true){
            myIcon = new BMap.Icon("/img/photo4.jpg", new BMap.Size(10,10));
            var marker = new BMap.Marker(point,{icon:myIcon});
            map.addOverlay(marker);
        }
        else{
            var marker = new BMap.Marker(point,{icon:myIcon});
            map.addOverlay(marker);
            if(flag==true){
                marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
            }
        }
    }

    /**
     * 为多个覆盖点添加信息窗口
     */
    //打开信息
    function openInfo(content,e){
        var p = e.target;
        var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
        var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象
        map.openInfoWindow(infoWindow,point); //开启信息窗口
    }
    //点击覆盖点，处理信息
    function addClickHandler(content,marker){
        marker.addEventListener("click",function(e){
            openInfo(content,e)}
        );
    }


</script>

