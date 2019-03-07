package com.pjb.springbootpublicremark.dao;

import java.util.List;

import com.pjb.springbootpublicremark.bean.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

    /**
     * 根据查询条件查询用户列表
     * @param user 查询条件
     * @return 用户列表
     */
    List<User> select(User user);
    
    /**
     * 新增
     * @return 影响行数：如果用户名已存在，影响行数为0，新增成功，影响行数为1
     */
    int insert(User user);
    
    /**
     * 根据主键获取用户实体
     * @param id 主键
     * @return 用户实体
     */
    User selectById(Long id);
    
    /**
     * 修改
     * @return 影响行数：如用户名将修改成与其他用户的用户名相同，影响行数为0，修改成功，影响行数为1
     */
    int update(User user);
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 影响行数
     */
    int delete(Long id);
}