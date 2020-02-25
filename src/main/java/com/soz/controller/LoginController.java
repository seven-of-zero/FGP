package com.soz.controller;

import com.soz.pojo.User;
import com.soz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpSession session,Model model){
        String msg = (String)session.getAttribute("msg");
        System.out.println(msg);
        model.addAttribute("msg",msg);
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession();
        String name = request.getParameter("uname");
        String password = request.getParameter("upwd");
        String msg = "";
        User test = userService.checkLogin(name);
        boolean check;
        if (test!=null){
            if (test.getPassword().equals(password)){
                check = true;
            }else {
                check = false;
            }
        }else {
            session.setAttribute("msg", "用户不存在！");
            return "redirect:/login/login";
        }
        if (check){
            session.setAttribute("name",name);
            session.setAttribute("password",password);
            session.setAttribute("picture",test.getPicture());
            session.setAttribute("authority",test.getAuthority());
            return "redirect:/";
        }else{
            session.setAttribute("msg", "密码不正确！");
            return "redirect:/login/login";
        }

    }

}
