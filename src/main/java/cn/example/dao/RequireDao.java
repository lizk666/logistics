package cn.example.dao;

import cn.example.domain.Page;
import cn.example.domain.Require;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 需求点的持久层接口
 */
@Repository
public interface RequireDao {
    /**
     * 添加需求点信息
     */
    @Insert("insert into requirepoint values(#{id},#{requirename},#{requirelongitude},#{requirelatitude},#{requirecapacity},#{serviceid},#{satisfy})")
    public void saveRequire(Require require);

    /**
     * 修改需求点信息
     * @param require
     */
    @Update("update requirepoint set requirename=#{requirename},requirelongitude=#{requirelongitude},requirelatitude=#{requirelatitude},requirecapacity=#{requirecapacity},serviceid=#{serviceid},satisfy=#{satisfy} where id=#{id}")
    public void updateRequire(Require require);

    /**
     * 根据需求点id删除需求点信息
     * @param id
     */
    @Delete("delete from requirepoint where id=#{id}")
    public void deleteRequire(Integer id);

    /**
     * 通过id查询一个需求点
     * @param id
     * @return
     */
    @Select("select * from requirepoint where id=#{id}")
    public Require findById(Integer id);

    /**
     * 查询所有需求点
     * @return
     */
    @Select("select * from requirepoint")
    public List<Require> findAll();

    /**
     * 通过外键查询所有需求点
     * @return
     */
    @Select("select * from requirepoint where serviceid = #{serviceid}")
    public List<Require> findByServiceid(Integer serviceid);

    /**
     * 通过名称查询需求点
     * @return
     */
    @Select("select * from requirepoint where requirename=#{requirename}")
    public List<Require> findByRequireName(String requirename);


    /**
     * 查询页面总记录数
     * @return
     * @param condition
     */
    @Select("select count(id) from requirepoint")
    int findTotalCounts();

    /**
     * 查询分页数据
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    @Select("select * from requirepoint limit #{start},#{rows}")
    List<Require> findRequireList(Page page);
}
