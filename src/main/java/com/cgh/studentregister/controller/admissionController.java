package com.cgh.studentregister.controller;

import com.cgh.studentregister.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class admissionController {
    @Autowired
    private AdmissionService admissionService;
    @RequestMapping("/admissionStudent")
    public ModelAndView ToGet(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("admissionStudent");
        return modelAndView;
    }
    @PostMapping("/admissionStudentupload")
    public ModelAndView upload(@RequestParam("stu_name")String stu_name,
                               @RequestParam("stu_gender")String stu_gender,
                               @RequestParam("stu_major")String stu_major,
                               @RequestParam("stu_highschool")String stu_highschool,
                               @RequestParam("stu_id")String stu_id,
                               @RequestParam("file") MultipartFile file
            , HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView=new ModelAndView();
        int i=admissionService.fileupload(file,stu_major);
        if(i==1){
            admissionService.InfoInsert(file,stu_major,stu_name,stu_gender,stu_id,stu_highschool);
        }else if(i==2){
            modelAndView.addObject("msg","请上传jpg或png格式的图片");
            modelAndView.setViewName("admissionStudent");
            return modelAndView;
        }else {
            modelAndView.addObject("msg","文件上传出错");
            modelAndView.setViewName("admissionStudent");
            return modelAndView;
        }
        modelAndView.addObject("msg","录取成功");
        modelAndView.setViewName("admissionStudent");
        return modelAndView;
    }
}
