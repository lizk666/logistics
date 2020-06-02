package cn.example.service.impl;

import cn.example.dao.RequireDao;
import cn.example.domain.Page;
import cn.example.domain.PageBean;
import cn.example.domain.Require;
import cn.example.domain.Supply;
import cn.example.service.RequireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("requireService")
public class RequireServiceImpl implements RequireService {
    @Autowired
    private RequireDao requireDao;
    @Override
    public void saveRequire(Require require) {
        requireDao.saveRequire(require);
    }

    @Override
    public void updateRequire(Require require) {
        requireDao.updateRequire(require);
    }

    @Override
    public void deleteRequire(Integer id) {
        requireDao.deleteRequire(id);
    }

    @Override
    public Require findById(Integer id) {
        return requireDao.findById(id);
    }

    @Override
    public List<Require> findByServiceid(Integer serviceid) {
        return requireDao.findByServiceid(serviceid);
    }

    @Override
    public List<Require> findAll() {
        return requireDao.findAll();
    }

    @Override
    public Require findByName(String requirename) {
        Require require = null;
        List<Require> requires = requireDao.findByRequireName(requirename);
        if(requires.size()>1){
            throw new RuntimeException("需求点不唯一查询有误");
        }
        if(requires.size()==1){
            require = requires.get(0);
        }
        return require;
    }

    @Override
    public int findTotalCounts() {
        return requireDao.findTotalCounts();
    }

    @Override
    public PageBean<Require> findRequireByPage(PageBean pageBean) {
        int currentPage = pageBean.getCurrentPage();
        int rows = pageBean.getRows();
        if(currentPage < 1){
            currentPage=1;
        }
        //创建空的pageBean对象
        PageBean<Require> pageBean1 = new PageBean<Require>();
        pageBean1.setCurrentPage(currentPage);
        pageBean1.setRows(rows);

        //调用userDao查询总记录数
        int totalCount = requireDao.findTotalCounts();
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
        List<Require> list = requireDao.findRequireList(page);
        pageBean1.setList(list);
        return pageBean1;
    }
}
