package cn.example.controller;

import cn.example.domain.PageBean;
import cn.example.domain.Supply;
import cn.example.domain.Vehicle;
import cn.example.service.SupplyService;
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

/**
 * 服务点的web层
 */
@Controller
@RequestMapping("/supply")
@SessionAttributes({"find_supply","pb_supply"})
public class SupplyController {
    @Autowired
    private SupplyService supplyService;

    /**
     * 添加服务点
     * @param supply
     * @return
     */
    @RequestMapping("/saveSupply")
    public void saveSupply(Supply supply, HttpServletRequest request, HttpServletResponse response) throws IOException {
        supplyService.saveSupply(supply);
        response.sendRedirect(request.getContextPath()+"/supply/findAll");
        return;
    }

    /**
     * 删除单个服务点
     */
    @RequestMapping("/deleteSupply")
    public void deleteSupply(Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException {
        supplyService.deleteSupply(id);
        response.sendRedirect(request.getContextPath()+"/supply/findAll");
        return;
    }
    /**
     * 删除选中的服务点
     */
    @RequestMapping("/delSelected")
    public void delSelected(String[] ids,HttpServletRequest request,HttpServletResponse response) throws IOException {
        for (String id : ids) {
            supplyService.deleteSupply(Integer.parseInt(id));
        }
        response.sendRedirect(request.getContextPath()+"/supply/findAll");
        return;
    }
    /**
     * 回显用户
     */
    @RequestMapping("/updateSupply")
    public void updateSupply(Integer id,Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //查询服务点
        Supply supply = supplyService.findById(id);
        if(supply!=null){
            model.addAttribute("find_supply",supply);
            response.sendRedirect("/supply-update.jsp");
        }
        return;
    }
    /**
     * 服务点详情页面
     */
    @RequestMapping("/supplyDetail")
    public void SupplyDetail(Integer id,Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //查询用户
        Supply supply = supplyService.findById(id);
        if(supply!=null){
            model.addAttribute("find_supply",supply);
            response.sendRedirect("/supply-detail.jsp");
        }
        return;
    }

    /**
     * 修改服务点信息
     * @param supply
     */
    @RequestMapping("/update")
    public void updateVehicle(Supply supply,HttpServletResponse response,HttpServletRequest request) throws IOException {
        supplyService.updateSupply(supply);
        response.sendRedirect("/supply/findAll");
        return;
    }
    @RequestMapping("/findAll")
    public void findUserByPage(Model model,HttpServletRequest request,HttpServletResponse response,PageBean pageBean) throws ServletException, IOException {
        //获取参数
        int currentPage = pageBean.getCurrentPage();
        int rows = pageBean.getRows();
        System.out.println(rows);

        if(currentPage == 0 || "".equals(currentPage)){
            pageBean.setCurrentPage(1);
        }
        if(rows == 0 || "".equals(rows)){
            pageBean.setRows(8);
        }
        //调用service方法查询数据
        PageBean<Supply> pageBean1 = supplyService.findSupplyByPage(pageBean);
        //转发
        model.addAttribute("pb_supply",pageBean1);
//        request.getRequestDispatcher("/user-list.jsp").forward(request,response);
        response.sendRedirect("/supply-list.jsp");
        return;
    }
}
