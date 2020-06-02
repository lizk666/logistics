package cn.example.service;

import cn.example.domain.PageBean;
import cn.example.domain.Require;
import cn.example.domain.Supply;

import java.util.List;

/**
 * 需求点的业务层接口
 */
public interface RequireService {
    /**
     * 添加需求点
     */
    public void saveRequire(Require require);

    /**
     * 修改需求点
     * @param supply
     */
    public void updateRequire(Require require);

    /**
     * 根据id删除需求点
     * @param id
     */
    public void deleteRequire(Integer id);

    /**
     * 通过id查询一个需求点
     * @param id
     * @return
     */
    public Require findById(Integer id);
    /**
     * 通过外键serviceid查询需求点
     * @param serviceid
     * @return
     */
    public List<Require> findByServiceid(Integer serviceid);

    /**
     * 查询所有需求点
     * @return
     */
    public List<Require> findAll();
    /**
     * 通过需求点名查询需求点
     * @return
     */
    public Require findByName(String requirename);
    /**
     * 查询总记录数
     */
    public int findTotalCounts();

    /**
     * 通过分页查询数据
     */
    PageBean<Require> findRequireByPage(PageBean pageBean);
}
