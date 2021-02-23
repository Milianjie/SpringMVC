package com.studymyself.service;

import com.studymyself.entity.User;

import java.util.List;

public interface UserService {

    public int addUser(User user);
    public List<User> queryAll();
    public User queryByLoginName(String loginName);
}
