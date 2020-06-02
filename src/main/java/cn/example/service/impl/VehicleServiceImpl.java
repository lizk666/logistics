package cn.example.service.impl;

import cn.example.dao.VehicleDao;
import cn.example.domain.Page;
import cn.example.domain.PageBean;
import cn.example.domain.User;
import cn.example.domain.Vehicle;
import cn.example.exception.SysException;
import cn.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 车辆的业务层实现类
 */
@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleDao vehicleDao;
    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicleDao.saveVehicle(vehicle);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        vehicleDao.updateVehicle(vehicle);
    }

    @Override
    public void deleteVehicle(Integer id) {
        vehicleDao.deleteVehicle(id);
    }

    @Override
    public Vehicle findById(Integer id) {
        return vehicleDao.findById(id);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleDao.findAll();
    }

    @Override
    public Vehicle findByName(String carnumber) {
        Vehicle vehicle = null;
        List<Vehicle> vehicles = vehicleDao.findByCarnumber(carnumber);
        if (vehicles.size() > 1) {
            throw new RuntimeException("数据不唯一,数据有误");
        }
        if(vehicles.size()==1){
            //查询到唯一车牌号
            vehicle = vehicles.get(0);
        }
        return vehicle;
    }

    @Override
    public int findTotalCounts() {
        return vehicleDao.findTotalCounts();
    }

    @Override
    public List<Vehicle> findByServiceId(Integer serviceid) {
        return vehicleDao.findByServiceId(serviceid);
    }

    @Override
    public PageBean<Vehicle> findVehicleByPage(PageBean pageBean) {
        int currentPage = pageBean.getCurrentPage();
        int rows = pageBean.getRows();
        if(currentPage < 1){
            currentPage=1;
        }
        //创建空的pageBean对象
        PageBean<Vehicle> pageBean1 = new PageBean<Vehicle>();
        pageBean1.setCurrentPage(currentPage);
        pageBean1.setRows(rows);

        //调用userDao查询总记录数
        int totalCount = vehicleDao.findTotalCounts();
        pageBean1.setTotalCount(totalCount);

        //计算总页数
        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pageBean1.setTotalPage(totalPage);
        if(currentPage>totalPage){
            currentPage = totalPage;
            pageBean1.setCurrentPage(currentPage);
        }
        //调用userDao查询每页list
        int start = (currentPage-1)*rows;
        Page page = new Page();
        page.setStart(start);
        page.setRows(rows);
        List<Vehicle> list = vehicleDao.findVehicleList(page);
        pageBean1.setList(list);
        return pageBean1;
    }
}
