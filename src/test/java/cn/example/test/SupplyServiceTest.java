package cn.example.test;

import cn.example.domain.PageBean;
import cn.example.domain.Supply;
import cn.example.domain.User;
import cn.example.domain.Vehicle;
import cn.example.service.SupplyService;
import cn.example.service.UserService;
import cn.example.service.VehicleService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 服务点业务层测试类
 */
public class SupplyServiceTest {
    /**
     * 测试添加
     */
    @Test
    public void testSave(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SupplyService supplyService = ac.getBean("supplyService", SupplyService.class);
        Supply supply = new Supply();
        supply.setSupplyname("浐灞区");
        supply.setSupplylongitude(444.6842d);
        supply.setSupplylatitude(444.8823d);
        supply.setSupplycapacity(4444d);
        supplyService.saveSupply(supply);
    }
    /**
     * 测试修改
     */
    @Test
    public void testUpdate(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SupplyService supplyService = ac.getBean("supplyService", SupplyService.class);
        Supply supply = new Supply();
        supply.setId(2);
        supply.setSupplyname("高陵区");
        supply.setSupplylongitude(444.6842d);
        supply.setSupplylatitude(555.8823d);
        supply.setSupplycapacity(4444d);
        supplyService.updateSupply(supply);
    }
    /**
     * 测试删除
     */
    @Test
    public void testDelete(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SupplyService supplyService = ac.getBean("supplyService", SupplyService.class);
        supplyService.deleteSupply(3);
    }
    /**
     * 测试查询一个
     */
    @Test
    public void testFindById(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SupplyService supplyService = ac.getBean("supplyService", SupplyService.class);
        Supply supply = supplyService.findById(2);
        System.out.println(supply);
    }
    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SupplyService supplyService = ac.getBean("supplyService", SupplyService.class);
        List<Supply> supplies = supplyService.findAll();
        for (Supply supply : supplies) {
            System.out.println(supply);
        }
    }
    /**
     * 测试根据名称查询查询
     */
    @Test
    public void testFindBySupplyname(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SupplyService supplyService = ac.getBean("supplyService", SupplyService.class);
        Supply supply = supplyService.findByName("未央区");
        System.out.println(supply);
    }
    /**
     * 测试分页
     */
    @Test
    public void testUpdateVehicle(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SupplyService supplyService = ac.getBean("supplyService", SupplyService.class);
        PageBean pageBean = new PageBean();
        pageBean.setRows(1);
        pageBean.setCurrentPage(2);
        PageBean<Supply> supplys = supplyService.findSupplyByPage(pageBean);
        for (Supply supply : supplys.getList()) {
            System.out.println(supply);
        }

    }
    /**
     * 测试查询总记录数
     */
    @Test
    public void testFindTotalCounts(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SupplyService supplyService = ac.getBean("supplyService", SupplyService.class);
        int totalCounts = supplyService.findTotalCounts();
        System.out.println(totalCounts);
        //测试分页数据
        PageBean<Supply> pageBean = new PageBean<>();
        pageBean.setCurrentPage(1);
        pageBean.setRows(2);
        supplyService.findSupplyByPage(pageBean);
    }
}
