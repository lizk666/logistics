package cn.example.service.impl;

import cn.example.dao.UserDao;
import cn.example.domain.Page;
import cn.example.domain.PageBean;
import cn.example.domain.User;
import cn.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByEmail(String email) {
        User user = null;
        List<User> users = userDao.findByEmail(email);
        if(users.size()>1){
            //数据不唯一，系统错误
            throw new RuntimeException("数据库有误，数据不唯一");
        }
        if(users.size()==1){
            user = users.get(0);
        }
        return user;
    }

    @Override
    public int findTotalCounts() {
        return userDao.findTotalCounts();
    }

    /**
     * 分页参数
     * @return
     */
    @Override
    public PageBean<User> findUserByPage(PageBean pageBean) {
        int currentPage = pageBean.getCurrentPage();
        int rows = pageBean.getRows();
        if(currentPage < 1){
            currentPage=1;
        }
        //创建空的pageBean对象
        PageBean<User> pageBean1 = new PageBean<User>();
        pageBean1.setCurrentPage(currentPage);
        pageBean1.setRows(rows);
        //调用userDao查询总记录数
        int totalCount = userDao.findTotalCounts();
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
        List<User> list = userDao.findUserList(page);
        pageBean1.setList(list);
        return pageBean1;
    }
}
