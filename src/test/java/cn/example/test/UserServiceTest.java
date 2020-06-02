package cn.example.test;

import cn.example.domain.PageBean;
import cn.example.domain.User;
import cn.example.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户业务层测试类
 */
public class UserServiceTest {
    /**
     * 测试添加
     */
    @Test
    public void testSave(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        User user = new User();
        user.setName("张三丰");
        user.setPassword("123123");
        user.setAge(36);
        userService.saveUser(user);
    }
    /**
     * 测试修改
     */
    @Test
    public void testUpdate(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        User user = new User();
        user.setId(77);
        user.setName("张三丰");
        user.setPassword("123123");
        user.setAge(40);
        userService.updateUser(user);
    }
    /**
     * 测试删除
     */
    @Test
    public void testDelete(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        userService.deleteUser(72);
    }
    /**
     * 测试查询一个
     */
    @Test
    public void testFindById(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        User user = userService.findById(76);
        System.out.println(user);
    }
    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    /**
     * 测试根据email查询
     */
    @Test
    public void testFindByEmail(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        User user = userService.findByEmail("489273196@qq.com");
        System.out.println(user);
    }
    /**
     * 测试查询总记录数
     */
    @Test
    public void testFindTotalCounts(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        int totalCounts = userService.findTotalCounts();
        System.out.println(totalCounts);
        //测试分页数据
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setCurrentPage(3);
        pageBean.setRows(5);
        userService.findUserByPage(pageBean);
    }
}
