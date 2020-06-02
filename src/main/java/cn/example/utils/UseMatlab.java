package cn.example.utils;

import cn.example.domain.Require;
import cn.example.domain.RouteInfo;
import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import main.Route;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UseMatlab {
    public static void main(String[] args) throws Exception {
        Route route = new Route();
        List<Double> vehicleList = new ArrayList<>();
        vehicleList.add(80d);
        vehicleList.add(80d);
        vehicleList.add(80d);
        vehicleList.add(20d);

        List<Double> centerList = new ArrayList<>();
        centerList.add(108.969337);
        centerList.add(34.27604800);

        UseMatlab useMatlab = new UseMatlab();
        Double[] vehicle = useMatlab.listToArray(vehicleList);
        Double[] centerPosition = useMatlab.listToArray(centerList);
        //第三个参数
        List<Require> requireList = new ArrayList<Require>();
        Require require = new Require();
        Require require2 = new Require();
        require.setRequirelongitude(108.92594);
        require2.setRequirelongitude(108.92594);
        require.setRequirelatitude(34.334733);
        require2.setRequirelatitude(34.334733);
        require.setRequirecapacity(6.0);
        require2.setRequirecapacity(6.0);
        require.setSatisfy(0.8);
        require2.setSatisfy(0.8);
        requireList.add(require);
        requireList.add(require2);

        Double[][] doubles = useMatlab.listToTwoArray(requireList);

        Double[][] all_info_data={
                {108.977123000000,34.1851090000000,23.0,0.196595250000000},
                {109.018560000000,34.2653690000000,20.0,0.840717256000000},
                {109.035267000000,34.2728500000000,2.0,0.254282179000000},
                {109.019305000000,34.2753060000000,5.0,0.751267059000000},
                {108.953716000000,34.3361000000000,22.0,0.351659507000000},
                {108.943133000000,34.3470740000000,23.0,0.337122644000000},
                {108.925940000000,34.3347330000000,6.0,0.934010684000000},
                {108.920901000000,34.3377210000000,14.0,0.568823661000000},
                {108.919831000000,34.3359900000000,15.0,0.129906208000000},
                {108.953611000000,34.2874410000000,6.0,0.473288849000000},
                {108.875444000000,34.3302570000000,23.0,0.530797553000000},
                {108.831797000000,34.3400150000000,12.0,0.0539501190000000},
                {108.937911000000,34.2865010000000,3.0,0.917193664000000},
                {108.795216000000,34.3318550000000,14.0,0.0758542900000000},
                {108.869859000000,34.3066150000000,2.0,0.567821641000000}};

        //调用MATLAB函数，得到java Object数组
        Object[] main = route.main(1,vehicle, centerPosition, all_info_data);
        List routeInfoList = useMatlab.getRouteInfoList(main);
//        System.out.println(routeInfoList.get(2));

        route.dispose();
    }
    public List<RouteInfo> remindMMArrayToList(MWArray remindInfo){
        List<RouteInfo> remindList = new ArrayList<>();
        int requireNumber = remindInfo.numberOfElements()/4;
        for(int i=1;i<=requireNumber;i++){
            Double longitude = (Double)remindInfo.get(i);
            Double latitude = (Double)remindInfo.get(i+1*requireNumber);
            Double require = (Double)remindInfo.get(i+2*requireNumber);
            Double satisfy = (Double)remindInfo.get(i+3*requireNumber);
            RouteInfo routeInfo = new RouteInfo();
            routeInfo.setLongitude(longitude);
            routeInfo.setLatitude(latitude);
            routeInfo.setRequire(require);
            routeInfo.setSatisfy(satisfy);
            remindList.add(routeInfo);
        }
        return remindList;
    }

    /**
     * 传入调用matlab函数返回的java Object 数组
     * @return
     */
    public List getRouteInfoList(Object[] main){
        List listInfo = new ArrayList();
        List listRouteInfo = new ArrayList();
        MWStructArray mwStructArray =(MWStructArray)main[0];
        //剩余车辆信息
        MWArray vehicleArray = mwStructArray.getField("vehicle",1);
        List<Double> vehicle = mwArrayToDouble(vehicleArray);
        //添加车辆信息
        listInfo.add(vehicle);
        //剩余需求点信息
        List<RouteInfo> remindInfos = new ArrayList<>();
        MWArray remind_all_info = mwStructArray.getField("remind_all_info",1);
        if(!remind_all_info.isEmpty()){
            remindInfos = remindMMArrayToList(remind_all_info);
            listInfo.add(remindInfos);
        }else {
            listInfo.add(remindInfos);
        }
        //路径信息
        MWStructArray tsp = (MWStructArray) mwStructArray.getField("tsp",1);
        //tsp.numberOfElements()表示一共有几条最优路径
        for (int i = 1; i <= tsp.numberOfElements(); i++) {
            //获取信息，tsp结构体中的信息，数据类型为Matlab中的数据类型
            MWArray best_route = tsp.getField("best_route", i);
            MWArray route_info = tsp.getField("route_info", i);
            //封装成java可用的最优路径信息
            List<RouteInfo> bestRouteInfo = getRouteInfo(best_route, route_info);
            listRouteInfo.add(bestRouteInfo);
        }
        //添加最优路线信息
        listInfo.add(listRouteInfo);
        return listInfo;
    }


    /**
     * 将调用matlab函数以后，返回的结果进行处理为java中的数据格式
     * @param best
     * @param route_info
     * @return
     */
    public List<RouteInfo> getRouteInfo(MWArray best, MWArray route_info){
        List<Integer> list = mwArrayToInt(best);
        //最优路径
        List<RouteInfo> routeInfoList = new ArrayList<>();
        int requireNumber = route_info.numberOfElements()/4;
        for (int i : list) {
            Double longitude = (Double)route_info.get(i);
            Double latitude = (Double)route_info.get(i+1*requireNumber);
            Double require = (Double)route_info.get(i+2*requireNumber);
            Double satisfy = (Double)route_info.get(i+3*requireNumber);
            RouteInfo routeInfo = new RouteInfo();
            routeInfo.setLongitude(longitude);
            routeInfo.setLatitude(latitude);
            routeInfo.setRequire(require);
            routeInfo.setSatisfy(satisfy);
            routeInfoList.add(routeInfo);

        }
        return routeInfoList;
    }

    /**
     * 调用matlab函数，返回mwArray数组，将该数组转为java中的list集合返回
     * 将mwArray数组转为java中的int类型的list集合返回
     * @param best
     * @return
     */
    public List<Integer> mwArrayToInt(MWArray best){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= best.numberOfElements() ; i++) {
            Double dindex = (Double)best.get(i);
            int din = dindex.intValue();
            list.add(din);
        }
        return list;
    }
    /**
     * 调用matlab函数，返回mwArray数组，将该数组转为java中的list集合返回
     * 将mwArray数组转为java中的int类型的list集合返回
     * @param best
     * @return
     */
    public List<Double> mwArrayToDouble(MWArray returnInfo){
        List<Double> list = new ArrayList<>();
        for (int i = 1; i < returnInfo.numberOfElements() ; i++) {
            Double dindex = (Double)returnInfo.get(i);
            list.add(dindex);
        }
        return list;
    }

    /**
     * 调用matlab所需的参数之一,主要是车辆信息，和中心点信息
     * 将需要传入的列表集合转为matlab所需的数组
     * @param myList
     * @param <T>
     * @return
     */
    public <T>Double[] listToArray(List<T> myList){
        int a = myList.size();
        Double[] returnDouble = new Double[a];
        for (int i = 0; i < a; i++) {
            returnDouble[i] = (Double) myList.get(i);
        }
        return returnDouble;
    }

    /**
     * 调用matlab所需的参数之一，主要是需求点信息
     * 将传入的list集合中的部分数据封装为所需的二维数组
     * @param myList
     * @return
     */
    public Double[][] listToTwoArray(List<Require>myList){
        int a = myList.size();
        Double[][] returnTwoArray = new Double[a][4];
        for (int i = 0; i < myList.size(); i++) {
            Require require = myList.get(i);

            returnTwoArray[i][0] = require.getRequirelongitude();
            returnTwoArray[i][1] = require.getRequirelatitude();
            returnTwoArray[i][2] = require.getRequirecapacity();
            returnTwoArray[i][3] = require.getSatisfy();
        }
        return returnTwoArray;
    }


}
