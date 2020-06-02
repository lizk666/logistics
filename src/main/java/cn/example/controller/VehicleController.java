package cn.example.controller;

import cn.example.domain.PageBean;
import cn.example.domain.User;
import cn.example.domain.Vehicle;
import cn.example.service.UserService;
import cn.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 车辆的web层
 */
@Controller
@RequestMapping("/vehicle")
@SessionAttributes({"find_vehicle","pb_vehicle"})
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;


    /**
     * 添加车辆
     * @param vehicle
     * @return
     */
    @RequestMapping("/saveVehicle")
    public void saveUser(Vehicle vehicle,HttpServletRequest request,HttpServletResponse response) throws IOException {
        vehicleService.saveVehicle(vehicle);
        response.sendRedirect(request.getContextPath()+"/vehicle/findAll");
        return;
    }

    /**
     * 删除单个用户
     */
    @RequestMapping("/deleteVehicle")
    public void deleteUser(Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException {
        vehicleService.deleteVehicle(id);
        response.sendRedirect(request.getContextPath()+"/vehicle/findAll");
        return;
    }
    /**
     * 删除选中的用户
     */
    @RequestMapping("/delSelected")
    public void delSelected(String[] ids,HttpServletRequest request,HttpServletResponse response) throws IOException {
        for (String id : ids) {
            vehicleService.deleteVehicle(Integer.parseInt(id));
        }
        response.sendRedirect(request.getContextPath()+"/vehicle/findAll");
        return;
    }
    /**
     * 回显用户
     */
    @RequestMapping("/updateVehicle")
    public void updateUser(Integer id,Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //查询车辆
        Vehicle vehicle = vehicleService.findById(id);
        if(vehicle!=null){
            model.addAttribute("find_vehicle",vehicle);
            response.sendRedirect("/vehicle-update.jsp");
        }
        return;
    }
    /**
     * 车辆详情页面
     */
    @RequestMapping("/vehicleDetail")
    public void UserDetail(Integer id,Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //查询用户
        Vehicle vehicle = vehicleService.findById(id);
        if(vehicle!=null){
            model.addAttribute("find_vehicle",vehicle);
            response.sendRedirect("/vehicle-detail.jsp");
        }
        return;
    }

    /**
     * 修改车辆信息
     * @param vehicle
     */
    @RequestMapping("/update")
    public void updateVehicle(Vehicle vehicle,HttpServletResponse response,HttpServletRequest request) throws IOException {
        System.out.println(vehicle);
        vehicleService.updateVehicle(vehicle);
        response.sendRedirect("/vehicle/findAll");
        return;
    }
    @RequestMapping("/findAll")
    public void findUserByPage(Model model,HttpServletRequest request,HttpServletResponse response,PageBean pageBean) throws ServletException, IOException {
        //获取参数
        int currentPage = pageBean.getCurrentPage();
        System.out.println(currentPage);
        int rows = pageBean.getRows();
        System.out.println(rows);

        if(currentPage == 0 || "".equals(currentPage)){
            pageBean.setCurrentPage(1);
        }
        if(rows == 0 || "".equals(rows)){
            pageBean.setRows(8);
        }
        //调用service方法查询数据
        PageBean<Vehicle> pageBean1 = vehicleService.findVehicleByPage(pageBean);
        //转发
        model.addAttribute("pb_vehicle",pageBean1);
//        request.getRequestDispatcher("/user-list.jsp").forward(request,response);
        response.sendRedirect("/vehicle-list.jsp");
        return;
    }
}
