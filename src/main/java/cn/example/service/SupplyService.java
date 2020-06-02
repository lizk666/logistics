package cn.example.service;

import cn.example.domain.PageBean;
import cn.example.domain.Supply;
import cn.example.domain.Vehicle;

import java.util.List;

/**
 * 服务点的业务层接口
 */
public interface SupplyService {
    /**
     * 添加服务点
     */
    public void saveSupply(Supply supply);

    /**
     * 修改服务点
     * @param supply
     */
    public void updateSupply(Supply supply);

    /**
     * 根据id删除服务点
     * @param id
     */
    public void deleteSupply(Integer id);

    /**
     * 通过id查询一个服务点
     * @param id
     * @return
     */
    public Supply findById(Integer id);

    /**
     * 查询所有服务点
     * @return
     */
    public List<Supply> findAll();
    /**
     * 通过服务点名查询服务点
     * @return
     */
    public Supply findByName(String supplyname);
    /**
     * 查询总记录数
     */
    public int findTotalCounts();

    /**
     * 通过分页查询数据
     */
    PageBean<Supply> findSupplyByPage(PageBean pageBean);
}
