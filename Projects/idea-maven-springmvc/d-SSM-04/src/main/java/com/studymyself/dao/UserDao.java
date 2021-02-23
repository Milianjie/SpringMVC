package com.studymyself.dao;

import com.studymyself.entity.User;

import java.util.List;

public interface UserDao {

    public int insertUser(User user);
    public List<User> selectAll();
    public User selectByLoginName(String loginName);

}
