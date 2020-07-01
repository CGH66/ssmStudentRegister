package com.cgh.studentregister.controller;

import com.cgh.studentregister.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class loginController {
    @Autowired
    private LoginService loginService;
    //登录页
    @RequestMapping(value = "/login")
    public String toLogin(Model model) {
        return "login";
    }
    //登录验证
    @PostMapping ("/loginCheck")
    public ModelAndView Check(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model=new ModelAndView();
        String name = request.getParameter("admin_name");
        String password = request.getParameter("admin_password");
        int key=loginService.checkLogin(name,password,response);
        if(key==1){
            model.addObject("msg","无此用户");
            model.setViewName("login");
            return model;
        }else if(key==2){
            model.setViewName("registerByname");
            return model;
        }else if(key==3) {
            model.addObject("msg", "账号或密码错误");
            model.setViewName("login");
            return model;

        }
        model.addObject("msg", "系统错误");
        model.setViewName("login");
        return model;

    }
}
