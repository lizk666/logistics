package cn.example.controller;

import cn.example.domain.Require;
import cn.example.domain.Supply;
import cn.example.domain.Vehicle;
import cn.example.service.RequireService;
import cn.example.service.SupplyService;
import cn.example.service.VehicleService;
import cn.example.utils.Transfer;
import cn.example.utils.UseMatlab;
import main.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于处理地图显示的web层
 */
@Controller
@RequestMapping("/map")
@SessionAttributes(value = {"routeInfoList1"})
public class MapController {
    @Autowired
    private SupplyService supplyService;
    @Autowired
    private RequireService requireService;
    @Autowired
    private VehicleService vehicleService;
    UseMatlab useMatlab = new UseMatlab();
    @RequestMapping("/showPoint")
    public String showSupplyAndRequire(Model model) throws Exception{
        List<Supply> supplyList = supplyService.findAll();
        model.addAttribute("supplyList",supplyList);
        List<Require> requireList = requireService.findAll();
        model.addAttribute("requireList" , requireList);

        List<Double> centerPosition = Transfer.getCenterPosition(supplyList.get(0));//中心点信息
        List<Vehicle> vehicleList = vehicleService.findByServiceId(15);//车辆信息
        List<Double> vehicleCapacity = Transfer.getVehicleCapacity(vehicleList);//车容量
        List<Require> requires = requireService.findByServiceid(15);;//需求点信息

        //调用matlab函数
        Route route = new Route();
        Object[] main = route.main(1, useMatlab.listToArray(vehicleCapacity), useMatlab.listToArray(centerPosition), useMatlab.listToTwoArray(requires));
        List routeInfoList = useMatlab.getRouteInfoList(main);
        model.addAttribute("routeInfoList1",routeInfoList);
        return "index";
    }
    @RequestMapping("/showVRP")
    public void showVRP(Model model, int index, HttpServletRequest request,HttpServletResponse response) throws Exception{
        List<Supply> supplyList = supplyService.findAll();
        List<Double> centerPosition = new ArrayList<>();//中心点信息
        List<Vehicle> vehicleList = new ArrayList<>();//车辆信息
        List<Double> vehicleCapacity = new ArrayList<>();//车容量
        List<Require> requires = new ArrayList<>();//需求点信息
        if(index==1){
            centerPosition= Transfer.getCenterPosition(supplyList.get(0));
            vehicleList = vehicleService.findByServiceId(15);
            vehicleCapacity = Transfer.getVehicleCapacity(vehicleList);
            requires = requireService.findByServiceid(15);
        }else if(index==2){
            centerPosition = Transfer.getCenterPosition(supplyList.get(1));
            vehicleList = vehicleService.findByServiceId(16);
            vehicleCapacity = Transfer.getVehicleCapacity(vehicleList);
            requires = requireService.findByServiceid(16);
        }else if(index==3){
            centerPosition = Transfer.getCenterPosition(supplyList.get(2));
            vehicleList = vehicleService.findByServiceId(17);
            vehicleCapacity = Transfer.getVehicleCapacity(vehicleList);
            requires = requireService.findByServiceid(17);
        }
        //调用matlab函数
        Route route = new Route();
        Object[] main = route.main(1, useMatlab.listToArray(vehicleCapacity), useMatlab.listToArray(centerPosition), useMatlab.listToTwoArray(requires));
        List routeInfoList = useMatlab.getRouteInfoList(main);
        model.addAttribute("routeInfoList1",routeInfoList);
        response.sendRedirect(request.getContextPath()+"/map/showPoint");
        return;
    }
}
