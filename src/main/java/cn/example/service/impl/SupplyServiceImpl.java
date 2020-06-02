package cn.example.service.impl;

import cn.example.dao.SupplyDao;
import cn.example.domain.Page;
import cn.example.domain.PageBean;
import cn.example.domain.Supply;
import cn.example.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("supplyService")
public class SupplyServiceImpl implements SupplyService {
    @Autowired
    private SupplyDao supplyDao;
    @Override
    public void saveSupply(Supply supply) {
        supplyDao.saveSupply(supply);
    }

    @Override
    public void updateSupply(Supply supply) {
        supplyDao.updateSupply(supply);
    }

    @Override
    public void deleteSupply(Integer id) {
        supplyDao.deleteSupply(id);
    }

    @Override
    public Supply findById(Integer id) {
        return supplyDao.findById(id);
    }

    @Override
    public List<Supply> findAll() {
        return supplyDao.findAll();
    }

    @Override
    public Supply findByName(String supplyname) {
        Supply supply = null;
        List<Supply> supplyList = supplyDao.findBySupplyName(supplyname);
        if(supplyList.size()>1){
            throw new RuntimeException("数据不唯一");
        }
        if(supplyList.size()==1){
            supply = supplyList.get(0);
        }
        return supply;
    }

    @Override
    public int findTotalCounts() {
        return supplyDao.findTotalCounts();
    }

    @Override
    public PageBean<Supply> findSupplyByPage(PageBean pageBean) {
        int currentPage = pageBean.getCurrentPage();
        int rows = pageBean.getRows();
        if(currentPage < 1){
            currentPage=1;
        }
        //创建空的pageBean对象
        PageBean<Supply> pageBean1 = new PageBean<Supply>();
        pageBean1.setCurrentPage(currentPage);
        pageBean1.setRows(rows);

        //调用userDao查询总记录数
        int totalCount = supplyDao.findTotalCounts();
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
        List<Supply> list = supplyDao.findSupplyList(page);
        pageBean1.setList(list);
        return pageBean1;
    }
}
