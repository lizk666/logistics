package cn.example.service;

import cn.example.domain.PageBean;
import cn.example.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * 用户的业务层接口
 */
public interface UserService {
    /**
     * 添加用户
     */
    public void saveUser(User user);

    /**
     * 修改用户
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据用户id删除用户
     * @param id
     */
    public void deleteUser(Integer id);

    /**
     * 通过id查询一个用户
     * @param id
     * @return
     */
    public User findById(Integer id);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();
    /**
     * 通过用户名查询用户
     * @return
     */
    public User findByEmail(String email);
    /**
     * 查询总记录数
     */
    public int findTotalCounts();

    /**
     * 通过分页查询数据
     */
    PageBean<User> findUserByPage(PageBean pageBean);
}
