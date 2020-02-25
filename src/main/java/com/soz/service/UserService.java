package com.soz.service;

import com.soz.pojo.User;

import java.util.List;

public interface UserService {

    public int findName(String name);

    public void add(User user);

    public List<User> findAll(String name);

    public void addPhoto(String url,String name);

    public User checkLogin(String name);

    public String showPhoto(String name);

}
