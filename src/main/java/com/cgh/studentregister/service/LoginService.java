package com.cgh.studentregister.service;

import com.cgh.studentregister.dao.AdmissionStudentDaoOrm;
import com.cgh.studentregister.dao.adminDaoOrm;
import com.cgh.studentregister.pojo.AdminOrm;
import com.cgh.studentregister.pojo.AdmissionStudentOrm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    private adminDaoOrm adminDaoOrm;
public int checkLogin(String name, String password, HttpServletResponse response){


    AdminOrm adminOrms=adminDaoOrm.selectAdmin(name);

    //无此用户
    if(adminOrms==null){
        return 1;
    }
    //登录成功
    if ((adminOrms.getName().toString().equals(name.toString()))
            && (adminOrms.getPassword().toString().equals(password.toString()))) {
        Cookie cookie = new Cookie("admin_name", name);
        cookie.setMaxAge(2 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return 2;
    }//密码错误
    else {
        return 3;
    }

}
}
