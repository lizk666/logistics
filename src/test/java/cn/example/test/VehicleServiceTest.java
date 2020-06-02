package cn.example.test;

import cn.example.domain.PageBean;
import cn.example.domain.User;
import cn.example.domain.Vehicle;
import cn.example.service.UserService;
import cn.example.service.VehicleService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 用户业务层测试类
 */
public class VehicleServiceTest {
    /**
     * 测试添加
     */
    @Test
    public void testSave(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        VehicleService vehicleService = ac.getBean("vehicleService", VehicleService.class);
        Vehicle vehicle = new Vehicle();
        vehicle.setCarlength(11.2d);
        vehicle.setCarcapacity(33d);
        vehicle.setCarname("东风6号");
        vehicle.setCarnumber("su-1234");
        vehicle.setCarload(1230d);
        vehicle.setDrivername("和尚");
        vehicle.setDriverphone(123456789);
        vehicleService.saveVehicle(vehicle);
    }
    /**
     * 测试修改
     */
    @Test
    public void testUpdate(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        VehicleService vehicleService = ac.getBean("vehicleService", VehicleService.class);
        Vehicle vehicle = new Vehicle();
        vehicle.setCarlength(11.2d);
        vehicle.setCarcapacity(33d);
        vehicle.setCarname("东风6号");
        vehicle.setCarload(1230d);
        vehicle.setDrivername("赵刚");
        vehicle.setDriverphone(123456789);
        vehicle.setId(7);
        vehicleService.updateVehicle(vehicle);
    }
    /**
     * 测试删除
     */
    @Test
    public void testDelete(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        VehicleService vehicleService = ac.getBean("vehicleService", VehicleService.class);
        vehicleService.deleteVehicle(3);
    }
    /**
     * 测试查询一个
     */
    @Test
    public void testFindById(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        VehicleService vehicleService = ac.getBean("vehicleService", VehicleService.class);
        Vehicle vehicle = vehicleService.findById(2);
        System.out.println(vehicle);
    }
    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        VehicleService vehicleService = ac.getBean("vehicleService", VehicleService.class);
        List<Vehicle> vehicles = vehicleService.findAll();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
    /**
     * 测试外键查询
     */
    @Test
    public void testFindByServiceId(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        VehicleService vehicleService = ac.getBean("vehicleService", VehicleService.class);
        List<Vehicle> vehicles = vehicleService.findByServiceId(15);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
    /**
     * 测试根据email查询
     */
    @Test
    public void testFindByCarnumber(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        VehicleService vehicleService = ac.getBean("vehicleService", VehicleService.class);
        Vehicle vehicle = vehicleService.findByName("su-1234");
        System.out.println(vehicle);
    }
    /**
     * 测试更新
     */
    @Test
    public void testUpdateVehicle(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        VehicleService vehicleService = ac.getBean("vehicleService", VehicleService.class);
        Vehicle vehicle = vehicleService.findByName("su-1234");
        System.out.println(vehicle);
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
