package com.studymyself.service.impl;

import com.studymyself.dao.UserDao;
import com.studymyself.entity.User;
import com.studymyself.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    //这里不作其他业务只做添加和查询的功能

    @Override
    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public List<User> queryAll() {
        return userDao.selectAll();
    }

    @Override
    public User queryByLoginName(String loginName) {
        return userDao.selectByLoginName(loginName);
    }


}
