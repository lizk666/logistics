function showFirst(point, longitude, latitude,map2) {
//用于存放线路的数组
var routeArray = new Array();
<c:forEach begin="0" end="${routeInfoList1.get(2).size()-1}" var="r">
    //用于存放最优配送配送路径
    var pointArray = new Array();
    var index = 0;
    <c:forEach begin="0" end="${routeInfoList1.get(2).get(r).size()-1}" var="j" step="1" varStatus="status">
        var longitude1 = ${routeInfoList1.get(2).get(r).get(status.index).longitude};
        var latitude1 = ${routeInfoList1.get(2).get(r).get(status.index).latitude};
        if (longitude1 == longitude && latitude1 == latitude) {
        //表示为服务点
        var p1 = new BMap.Point(longitude1, latitude1);
        //添加标注
        addMarker(map2, p1, false, false);
        } else {
        //表示为需求点
        var p2 = new BMap.Point(longitude1, latitude1);
        //添加标注
        addMarker(map2, p2, false, true);
        pointArray[index] = p2;
        index++;
        }
    </c:forEach>
    routeArray[${r}] = pointArray;
</c:forEach>
//为规划的点添加标注
<c:forEach begin="0" end="${routeInfoList1.get(1).size()-1}" var="r" step="1" varStatus="status">
    var longitude2 = ${routeInfoList1.get(1).get(status.index).longitude};
    var latitude2 = ${routeInfoList1.get(1).get(status.index).latitude};
    var p3 = new BMap.Point(longitude2, latitude2);
    // alert("111");
    addMarker(map2, p3, false, false);
</c:forEach>
for (s = 0; s < routeArray.length; s++) {
var driving = new BMap.DrivingRoute(map2, {renderOptions: {map: map2, autoViewport: true}});
driving.search(point, point, {waypoints: routeArray[s]});
}

}
function overLine(pois,map) {
var sy = new BMap.Symbol(BMap_Symbol_SHAPE_BACKWARD_OPEN_ARROW, {
scale: 0.6,//图标缩放大小
strokeColor:'#fff',//设置矢量图标的线填充颜色
strokeWeight: '2',//设置线宽
});
var icons = new BMap.IconSequence(sy, '10', '30');
var polyline =new BMap.Polyline(pois, {
enableEditing: false,//是否启用线编辑，默认为false
enableClicking: true,//是否响应点击事件，默认为true
icons:[icons],
strokeWeight:'8',//折线的宽度，以像素为单位
strokeOpacity: 0.8,//折线的透明度，取值范围0 - 1
strokeColor:"#18a45b" //折线颜色
});
map.addOverlay(polyline);          //增加折线
}

