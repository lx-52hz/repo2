package com.chinasoft.mapper;

import com.chinasoft.domain.User;

import java.util.List;

public interface IUserMapper {

    /**
     * 查询所有用户列表
     * @return
     */
    List<User> findAll();


    /**
     * 添加用户信息
     * @param user
     */
    void addUser(User user);


    /**
     * 删除用户信息
     * @param id
     */
    void delUser(Integer id);

    /**
     * 修改用户信息
     * @param user
     */
    void updUser(User user);


    List<User> findUserByName(String userName);


    List<User> findUserByCondition(String userName,String gender);
}
