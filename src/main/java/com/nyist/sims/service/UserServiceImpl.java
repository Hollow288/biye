package com.nyist.sims.service;

import com.nyist.sims.bean.User;
import com.nyist.sims.bean.User_Role;
import com.nyist.sims.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserServiceImpl implements  UserService{
    @Autowired
    UserMapper userMapper;

    //查找所有的用户
    @Override
    public List<User> getAllUser() {
        List<User> userList = userMapper.getAllUser();
        return userList;
    }

    //添加用户


    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    //根据用户名和密码查找用户

    @Override
    public User getUser(String username, String password) {
        User user = userMapper.getUser(username,password);

        return user;
    }
    //删除用户

    @Override
    public void delete(String uid) {
        userMapper.delete(uid);
    }
    //根据uid查找用户

    @Override
    public User getUserByUid(int uid) {
        User user = userMapper.getUserByUid(uid);
        return user;
    }
    //修改用户信息


    @Override
    public void edit(User user) {
        userMapper.edit(user);
    }

    //根据用户名查找权限

    @Override
    public List<User_Role> getRole(int uid) {
        List<User_Role> roleList = userMapper.getRole(uid);
        return roleList;
    }

    @Override
    public List<String> getPermission(String uid) {
        List<String> permissionlist = userMapper.getPermission(uid);
        return permissionlist;
    }
}
