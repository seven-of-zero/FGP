package com.soz.controller;

import com.soz.pojo.User;
import com.soz.service.UserService;
import com.soz.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/reciveUserName")
    @ResponseBody
    public JsonResult reciveUserName(String name){
        int count = userService.findName(name);
        String msg = "";
        if (count>0){
            msg = "用户名已存在";
        }else {
            msg = "OK";
        }
        return new JsonResult(msg);
    }

    @RequestMapping("/reciveRegister")
    public String reciveRegister(@RequestParam(name = "uname") String name, @RequestParam(name = "upwd") String password, HttpSession session, Model model){
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setPicture("http://127.0.0.1:8080/upload/2020-02-25/2020-02-25-0ab4e5c1-f45c-42fd-ad0b-337f1fad7ff0.jpg");//默认头像
        user.setAuthority("normal");//默认为普通用户
        userService.add(user);
        session.setAttribute("name",name);
        session.setAttribute("password",password);
        session.setAttribute("picture",user.getPicture());
        session.setAttribute("authority",user.getAuthority());
        model.addAttribute("user",user);
        return "next";
    }

}
