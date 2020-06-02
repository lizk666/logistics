package cn.example.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 跳转到具体错误页面的方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //获取到异常对象
        SysException e = null;
        if(ex instanceof SysException){
            e = (SysException)ex;
        }else {
            e = new SysException("系统正在维护,请联系管理员");
        }
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        //存入错误提示信息
        mv.addObject("errorMsg",e.getMessage());
        //跳转的jsp页面
        mv.setViewName("error");
        return mv;
    }
}
