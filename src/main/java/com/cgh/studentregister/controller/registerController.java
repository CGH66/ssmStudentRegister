package com.cgh.studentregister.controller;

import com.cgh.studentregister.dao.AdmissionStudentDaoOrm;
import com.cgh.studentregister.dao.RegisterStudentDaoOrm;
import com.cgh.studentregister.dao.StudentAndDormitoryDao;
import com.cgh.studentregister.dao.StudentDormityDaoOrm;
import com.cgh.studentregister.pojo.AdmissionStudentOrm;
import com.cgh.studentregister.pojo.StudentAndDormitory;
import com.cgh.studentregister.service.registerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Contended;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class registerController {
    @Autowired
    private AdmissionStudentDaoOrm admissionStudentDaoOrm;
    @Autowired
    private registerService registerService;
    @Autowired
    private StudentAndDormitoryDao studentAndDormitoryDao;
    @Autowired
    private RegisterStudentDaoOrm registerStudentDaoOrm;
    @Autowired
    private StudentDormityDaoOrm studentDormityDaoOrm;
    //获取录取表中的学生信息
    @RequestMapping(value="/getStudentByName")
    public ModelAndView Check(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model=new ModelAndView();
        String stu_name=request.getParameter("student_name");
        List<AdmissionStudentOrm> admissionStudentOrms=admissionStudentDaoOrm.selectAdmissionStudent(stu_name);
        if(admissionStudentOrms.size()==0){
            model.addObject("msg", "此人非我校新生");
            model.setViewName("registerByname");
            return model;
        }else {
        model.addObject("admissionStudent", admissionStudentOrms);
        model.setViewName("register");
        return model;
        }

    }
    //确认学生信息进行注册
    @RequestMapping(value="/doRegister")
    public ModelAndView  doRegister(HttpServletRequest request, HttpServletResponse response){
        String stu_id=request.getParameter("stu_id");

        int i=registerService.registerCheck(stu_id);
        ModelAndView model=new ModelAndView();
        if(i==1){
            model.addObject("msg","已注册");
            model.setViewName("registerByname");
            return model;
        }else if(i==2){
            model.addObject("msg","注册成功");
            model.setViewName("registerByname");
            return model;
        }
        model.addObject("msg","系统错误");
        model.setViewName("registerByname");
        return model;
    }
    //新生中注册路由
    @RequestMapping(value="/registerByname")
    public String registerStudentByname(){
        return "registerByname";
    }
    //已注册学生信息的显示 分页
    @RequestMapping(value="/registeredStudent")
    public ModelAndView registeredStudent(@RequestParam(defaultValue="1")Integer pageNum){
            ModelAndView model=new ModelAndView();
            //总记录条数
            int total=registerStudentDaoOrm.countAllStudent();
            //总页数
            int pageTotal=(int)Math.ceil((double)total/(double)3);
            Integer pagesize=(pageNum-1)*3;
            List<StudentAndDormitory> studentAndDormitories=studentAndDormitoryDao.getStudentAndDormitory(pagesize,3);
            model.addObject("AllStudentAndDormitory",studentAndDormitories);
            model.addObject("pageTotal",pageTotal);
            model.addObject("pageNum",pageNum);
            model.setViewName("registeredStudent");
            return model;
    }
    //修改学生信息
    @RequestMapping(value="/registerStudentinfoModify")
    public ModelAndView registerStudentinfoModify(HttpServletRequest request){
        ModelAndView model=new ModelAndView();
        String stu_id=request.getParameter("stu_id");
        System.out.println("sss"+stu_id);
        StudentAndDormitory studentAndDormitory=studentAndDormitoryDao.getStudentAndDormitoryById(stu_id);
        model.addObject("student",studentAndDormitory);

        model.setViewName("registerStudentinfoModify");
        return model;
    }
    //将修改的学生信息写入数据库
    @RequestMapping(value="/registeredStudentinfoUpdate")
    public String registeredStudentinfoUpdate(HttpServletRequest request){

        String stu_id=request.getParameter("stu_id");
        String Room_name=request.getParameter("Room_name");
        String Room_num=request.getParameter("Room_num");
        String stu_class=request.getParameter("stu_class");
        registerStudentDaoOrm.UpdateStudent(stu_class,stu_id);
        studentDormityDaoOrm.UpdateDormitory(stu_id,Room_num,Room_name);
        return "redirect:/registeredStudent";

    }
}
