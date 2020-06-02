package cn.example.service;

import cn.example.domain.PageBean;
import cn.example.domain.User;
import cn.example.domain.Vehicle;

import java.util.List;

/**
 * 用户的业务层接口
 */
public interface VehicleService {
    /**
     * 添加车辆
     */
    public void saveVehicle(Vehicle vehicle);

    /**
     * 修改车辆
     * @param vehicle
     */
    public void updateVehicle(Vehicle vehicle);

    /**
     * 根据id删除车辆
     * @param id
     */
    public void deleteVehicle(Integer id);

    /**
     * 通过id查询一个车辆
     * @param id
     * @return
     */
    public Vehicle findById(Integer id);

    /**
     * 查询所有车辆
     * @return
     */
    public List<Vehicle> findAll();
    /**
     * 通过用户名查询车辆
     * @return
     */
    public Vehicle findByName(String carnumber);
    /**
     * 查询总记录数
     */
    public int findTotalCounts();

    /**
     * 通过外键查询
     * @param serviceid
     * @return
     */
    public List<Vehicle> findByServiceId(Integer serviceid);

    /**
     * 通过分页查询数据
     */
    PageBean<Vehicle> findVehicleByPage(PageBean pageBean);
}
