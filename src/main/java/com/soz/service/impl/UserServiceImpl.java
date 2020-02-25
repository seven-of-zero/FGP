package com.soz.service.impl;

import com.soz.dao.UserDao;
import com.soz.pojo.User;
import com.soz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int findName(String name) {
        int count = userDao.findName(name);
        return count;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> findAll(String name) {
        return null;
    }

    @Override
    public void addPhoto(String url, String name) {
        userDao.addPhoto(url,name);
    }

    @Override
    public User checkLogin(String name) {
        User user = userDao.checkLogin(name);
        return user;
    }

    @Override
    public String showPhoto(String name) {
        String picture = userDao.showPhoto(name);
        return picture;
    }
}
