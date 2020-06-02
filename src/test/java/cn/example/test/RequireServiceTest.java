package cn.example.test;

import cn.example.domain.PageBean;
import cn.example.domain.Require;
import cn.example.domain.Supply;
import cn.example.service.RequireService;
import cn.example.service.SupplyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 需求点业务层测试类
 */
public class RequireServiceTest {
    /**
     * 测试添加
     */
    @Test
    public void testSave(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        RequireService requireService = ac.getBean("requireService", RequireService.class);
        Require require = new Require();
        require.setRequirename("浐灞区");
        require.setRequirelongitude(444.6842d);
        require.setRequirelatitude(444.8823d);
        require.setRequirecapacity(1234d);
        requireService.saveRequire(require);

    }
    /**
     * 测试修改
     */
    @Test
    public void testUpdate(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        RequireService requireService = ac.getBean("requireService", RequireService.class);
        Require require = new Require();
        require.setId(1);
        require.setRequirename("高陵区");
        require.setRequirelongitude(444.6842d);
        require.setRequirelatitude(444.8823d);
        require.setRequirecapacity(1234d);
        requireService.updateRequire(require);
    }
    /**
     * 测试删除
     */
    @Test
    public void testDelete(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        RequireService requireService = ac.getBean("requireService", RequireService.class);
        requireService.deleteRequire(2);
    }
    /**
     * 测试查询一个
     */
    @Test
    public void testFindById(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        RequireService requireService = ac.getBean("requireService", RequireService.class);
        Require require = requireService.findById(1);
        System.out.println(require);
    }
    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        RequireService requireService = ac.getBean("requireService", RequireService.class);
        List<Require> requireList = requireService.findAll();
        for (Require require : requireList) {
            System.out.println(require);
        }
    }
    /**
     * 测试通过外键查询
     */
    @Test
    public void testFindByServiceid(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        RequireService requireService = ac.getBean("requireService", RequireService.class);
        List<Require> requireList = requireService.findByServiceid(16);
        for (Require require : requireList) {
            System.out.println(require);
        }
    }
    /**
     * 测试根据名称查询查询
     */
    @Test
    public void testFindBySupplyname(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        RequireService requireService = ac.getBean("requireService", RequireService.class);
        Require require = requireService.findByName("高陵区");
        System.out.println(require);
    }
    /**
     * 测试分页
     */
    @Test
    public void testUpdateVehicle(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        RequireService requireService = ac.getBean("requireService", RequireService.class);
        PageBean pageBean = new PageBean();
        pageBean.setRows(1);
        pageBean.setCurrentPage(1);
        PageBean<Require> requires = requireService.findRequireByPage(pageBean);
        for (Require require : requires.getList()) {
            System.out.println(require);
        }

    }
    /**
     * 测试查询总记录数
     */
    @Test
    public void testFindTotalCounts(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        RequireService requireService = ac.getBean("requireService", RequireService.class);
        int totalCounts = requireService.findTotalCounts();
        System.out.println(totalCounts);
        //测试分页数据
        PageBean<Supply> pageBean = new PageBean<>();
        pageBean.setCurrentPage(1);
        pageBean.setRows(2);
        requireService.findRequireByPage(pageBean);
    }
}
