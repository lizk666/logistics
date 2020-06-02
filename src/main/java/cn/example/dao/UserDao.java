package cn.example.dao;

import cn.example.domain.Page;
import cn.example.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户的持久层接口
 */
@Repository
public interface UserDao {
    /**
     * 添加用户
     */
    @Insert("insert into user values(#{id},#{name},#{email},#{password},#{gender},#{age},#{qq},#{position},#{address})")
    public void saveUser(User user);

    /**
     * 修改用户
     * @param user
     */
    @Update("update user set name=#{name},email=#{email},password=#{password},gender=#{gender},age=#{age},qq=#{qq},position=#{position},address=#{address} where id=#{id}")
    public void updateUser(User user);

    /**
     * 根据用户id删除用户
     * @param id
     */
    @Delete("delete from user where id=#{id}")
    public void deleteUser(Integer id);

    /**
     * 通过id查询一个用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    public User findById(Integer id);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();

    /**
     * 通过email名查询用户
     * @return
     */
    @Select("select * from user where email=#{email}")
    public List<User> findByEmail(String email);


    /**
     * 查询页面总记录数
     * @return
     * @param
     */
    @Select("select count(id) from user")
    int findTotalCounts();

    /**
     * 查询分页数据
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    @Select("select * from user limit #{start},#{rows}")
    List<User> findUserList(Page page);
}
