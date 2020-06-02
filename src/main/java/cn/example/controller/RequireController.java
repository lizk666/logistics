package cn.example.controller;

import cn.example.domain.PageBean;
import cn.example.domain.Require;
import cn.example.domain.Supply;
import cn.example.service.RequireService;
import cn.example.service.SupplyService;
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
 * 需求点的web层
 */
@Controller
@RequestMapping("/require")
@SessionAttributes({"find_require","pb_require"})
public class RequireController {
    @Autowired
    private RequireService requireService;

    /**
     * 添加需求点
     * @param require
     * @return
     */
    @RequestMapping("/saveRequire")
    public void saveRequire(Require require, HttpServletRequest request, HttpServletResponse response) throws IOException {
        requireService.saveRequire(require);
        response.sendRedirect(request.getContextPath()+"/require/findAll");
        return;
    }

    /**
     * 删除单个需求点
     */
    @RequestMapping("/deleteRequire")
    public void deleteRequire(Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException {
        requireService.deleteRequire(id);
        response.sendRedirect(request.getContextPath()+"/require/findAll");
        return;
    }
    /**
     * 删除选中的需求点
     */
    @RequestMapping("/delSelected")
    public void delSelected(String[] ids,HttpServletRequest request,HttpServletResponse response) throws IOException {
        for (String id : ids) {
            requireService.deleteRequire(Integer.parseInt(id));
        }
        response.sendRedirect(request.getContextPath()+"/require/findAll");
        return;
    }
    /**
     * 回显需求点
     */
    @RequestMapping("/updateRequire")
    public void updateRequire(Integer id,Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //查询需求点
        Require require = requireService.findById(id);
        if(require!=null){
            model.addAttribute("find_require",require);
            response.sendRedirect("/require-update.jsp");
        }
        return;
    }
    /**
     * 需求点详情页面
     */
    @RequestMapping("/requireDetail")
    public void requireDetail(Integer id,Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //查询用户
        Require require = requireService.findById(id);
        if(require!=null){
            model.addAttribute("find_require",require);
            response.sendRedirect("/require-detail.jsp");
        }
        return;
    }

    /**
     * 修改需求点信息
     * @param supply
     */
    @RequestMapping("/update")
    public void updateRequire(Require require,HttpServletResponse response,HttpServletRequest request) throws IOException {
        requireService.updateRequire(require);
        response.sendRedirect("/require/findAll");
        return;
    }
    @RequestMapping("/findAll")
    public void findRequireByPage(Model model,HttpServletRequest request,HttpServletResponse response,PageBean pageBean) throws ServletException, IOException {
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
        PageBean<Require> pageBean1 = requireService.findRequireByPage(pageBean);
        //转发
        model.addAttribute("pb_require",pageBean1);
//        request.getRequestDispatcher("/user-list.jsp").forward(request,response);
        response.sendRedirect("/require-list.jsp");
        return;
    }
}
