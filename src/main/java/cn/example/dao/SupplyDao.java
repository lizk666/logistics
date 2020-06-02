package cn.example.dao;

import cn.example.domain.Page;
import cn.example.domain.Supply;
import cn.example.domain.Vehicle;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 服务点的持久层的持久层接口
 */
@Repository
public interface SupplyDao {
    /**
     * 添加服务点信息
     */
    @Insert("insert into supply values(#{id},#{supplyname},#{supplylongitude},#{supplylatitude},#{supplycapacity})")
    public void saveSupply(Supply supply);

    /**
     * 修改服务点信息
     * @param supply
     */
    @Update("update supply set supplyname=#{supplyname},supplylongitude=#{supplylongitude},supplylatitude=#{supplylatitude},supplycapacity=#{supplycapacity} where id=#{id}")
    public void updateSupply(Supply supply);

    /**
     * 根据服务点id删除服务点信息
     * @param id
     */
    @Delete("delete from supply where id=#{id}")
    public void deleteSupply(Integer id);

    /**
     * 通过id查询一个服务点
     * @param id
     * @return
     */
    @Select("select * from supply where id=#{id}")
    public Supply findById(Integer id);

    /**
     * 查询所有服务点
     * @return
     */
    @Select("select * from supply")
    public List<Supply> findAll();

    /**
     * 通过名称查询服务点
     * @return
     */
    @Select("select * from supply where supplyname=#{supplyname}")
    public List<Supply> findBySupplyName(String supplyname);


    /**
     * 查询页面总记录数
     * @return
     * @param condition
     */
    @Select("select count(id) from supply")
    int findTotalCounts();

    /**
     * 查询分页数据
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    @Select("select * from supply limit #{start},#{rows}")
    List<Supply> findSupplyList(Page page);
}
