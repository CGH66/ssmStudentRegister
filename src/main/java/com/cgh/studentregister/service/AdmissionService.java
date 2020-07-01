package com.cgh.studentregister.service;

import com.cgh.studentregister.dao.AdmissionStudentDaoOrm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class AdmissionService {
    @Autowired
    private AdmissionStudentDaoOrm admissionStudentDaoOrm;
    public int fileupload(MultipartFile file,String stu_major){

        if(file.isEmpty()){
            return 3;
        }
        //获得的包含路径需重新处理
        //未检测上传项目里的图会怎样
        String filename=file.getOriginalFilename();
        String suffixName=filename.substring(filename.lastIndexOf("."));
        if(suffixName.equals("jpg")||suffixName.equals("png")){
            return 2;
        }
        System.out.println(filename);
        String realName=filename;
        String FilePath="";
        if(stu_major.equals("计算机科学与技术")) {
            //D:\wenjian\idea\lab\studentregister\src\main\resources\static\img
           FilePath = "D:\\wenjian\\idea\\lab\\studentregister\\src\\main\\resources\\static\\img\\computerSubject\\";
        }else if(stu_major.equals("物联网")){
             FilePath = "D:\\wenjian\\idea\\lab\\studentregister\\src\\main\\resources\\static\\img\\computerInternet\\";
        }else {
            FilePath = "D:\\wenjian\\idea\\lab\\studentregister\\src\\main\\resources\\static\\img\\other\\";
        }
        String path=FilePath+realName;
        File dest=new File(path);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        }catch (Exception e) {e.printStackTrace();
        }
        return 1;
    }
    public void InfoInsert(MultipartFile file,String stu_major,String stu_name,
                          String stu_gender,String stu_id,String stu_highSchool){

        String filename=file.getOriginalFilename();

        admissionStudentDaoOrm.insertAdmissionStudent(stu_name,stu_gender,filename,stu_highSchool,stu_id,stu_major);
    }
}
