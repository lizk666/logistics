package cn.example.dao;

import cn.example.domain.Page;
import cn.example.domain.User;
import cn.example.domain.Vehicle;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 车辆的持久层的持久层接口
 */
@Repository
public interface VehicleDao {
    /**
     * 添加车辆信息
     */
    @Insert("insert into vehicle values(#{id},#{carname},#{carcapacity},#{carnumber},#{carload},#{carlength},#{drivername},#{driverphone},#{serviceid},#{isfree})")
    public void saveVehicle(Vehicle vehicle);

    /**
     * 修改车辆信息
     * @param vehicle
     */
    @Update("update vehicle set carname=#{carname},carcapacity=#{carcapacity},carnumber=#{carnumber},carload=#{carload},carlength=#{carlength},drivername=#{drivername},driverphone=#{driverphone},serviceid=#{serviceid},isfree=#{isfree} where id=#{id}")
    public void updateVehicle(Vehicle vehicle);

    /**
     * 根据车辆id删除车辆信息
     * @param id
     */
    @Delete("delete from vehicle where id=#{id}")
    public void deleteVehicle(Integer id);

    /**
     * 通过id查询一个车辆
     * @param id
     * @return
     */
    @Select("select * from vehicle where id=#{id}")
    public Vehicle findById(Integer id);

    /**
     * 查询所有车辆
     * @return
     */
    @Select("select * from vehicle")
    public List<Vehicle> findAll();

    /**
     * 通过车牌号查询车辆
     * @return
     */
    @Select("select * from vehicle where carnumber=#{carnumber}")
    public List<Vehicle> findByCarnumber(String carnumber);
    /**
     * 通过外键查询车辆
     * @return
     */
    @Select("select * from vehicle where serviceid=#{serviceid}")
    public List<Vehicle> findByServiceId(Integer serviceid);


    /**
     * 查询页面总记录数
     * @return
     * @param condition
     */
    @Select("select count(id) from vehicle")
    int findTotalCounts();

    /**
     * 查询分页数据
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    @Select("select * from vehicle limit #{start},#{rows}")
    List<Vehicle> findVehicleList(Page page);
}
