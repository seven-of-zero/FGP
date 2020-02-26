package com.soz.controller;


import com.soz.pojo.User;
import com.soz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/perfect")
public class PerfectController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addDetail{name}")
    public String addDetail(@PathVariable("name") String name, Model model, HttpSession session){
        System.out.println(name);
        session.setAttribute("name",name);
        model.addAttribute("name",name);
        return "photo";
    }

    @RequestMapping("/showPhoto")
    @ResponseBody
    public String showPhoto(HttpSession session){
        String  name = (String)session.getAttribute("name");
        String picture = userService.showPhoto(name);
        return picture;
    }

}
