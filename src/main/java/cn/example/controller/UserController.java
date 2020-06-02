package cn.example.controller;

import cn.example.domain.PageBean;
import cn.example.domain.User;
import cn.example.service.SupplyService;
import cn.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 用户的web层
 */
@Controller
@RequestMapping("/user")
@SessionAttributes({"find_user","pb","password_error_msg","user_error_msg","login-user"})
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 用户登录
     * @return
     */
    @RequestMapping("/login")
    public void  userLogin(User user, SessionStatus status, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        //查询数据库
        User user1 = userService.findByEmail(user.getEmail());
        System.out.println("user1:"+user1);
        if(user1 !=null){
            //查询成功，对比密码
            if(user1.getPassword().equals(user.getPassword())){
                //密码验证通过，跳转到首页
                model.addAttribute("login-user",user1);
                response.sendRedirect(request.getContextPath()+"/map/showPoint");
            }
            else {
                //密码错误，重定向页面
                model.addAttribute("password_error_msg","密码错误");
                model.addAttribute("user_error_msg","");

                response.sendRedirect(request.getContextPath()+"/user-login.jsp");
            }
        }else{
            //用户不存在
            model.addAttribute("user_error_msg","用户名有误");
            model.addAttribute("password_error_msg","");
            response.sendRedirect(request.getContextPath()+"/user-login.jsp");
            return;
        }

    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("findAll11111111111111111111111111")
    public String findAll(Model model){
        //查询所有用户
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "/user-list.jsp";
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public void saveUser(User user,HttpServletRequest request,HttpServletResponse response) throws IOException {
        userService.saveUser(user);
        response.sendRedirect(request.getContextPath()+"/user/findAll");
        return;
    }

    /**
     * 删除单个用户
     */
    @RequestMapping("/deleteUser")
    public void deleteUser(Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException {
        userService.deleteUser(id);
        response.sendRedirect(request.getContextPath()+"/user/findAll");
        return;
    }
    /**
     * 删除选中的用户
     */
    @RequestMapping("/delSelected")
    public void delSelected(String[] ids,HttpServletRequest request,HttpServletResponse response) throws IOException {
        for (String id : ids) {
            userService.deleteUser(Integer.parseInt(id));
        }
        response.sendRedirect(request.getContextPath()+"/user/findAll");
        return;
    }
    /**
     * 回显用户
     */
    @RequestMapping("/updateUser")
    public void updateUser(Integer id,Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //查询用户
        User user = userService.findById(id);
        if(user!=null){
            model.addAttribute("find_user",user);
            response.sendRedirect("/user-update.jsp");
        }
        return;
    }
    /**
     * 用户详情页面
     */
    @RequestMapping("/userDetail")
    public void UserDetail(Integer id,Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //查询用户
        User user = userService.findById(id);
        if(user!=null){
            model.addAttribute("find_user",user);
            response.sendRedirect("/user-detail.jsp");
        }
        return;
    }

    /**
     * 修改用户信息
     * @param user
     */
    @RequestMapping("/update")
    public void updateUsers(User user,HttpServletResponse response,HttpServletRequest request) throws IOException {
        userService.updateUser(user);
        response.sendRedirect("/user/findAll");
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
        PageBean<User> pageBean1 = userService.findUserByPage(pageBean);
        //转发
        model.addAttribute("pb",pageBean1);
//        request.getRequestDispatcher("/user-list.jsp").forward(request,response);
        response.sendRedirect("/user-list.jsp");
        return;
    }
}
