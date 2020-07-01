package com.cgh.studentregister.service;

import com.cgh.studentregister.dao.AdmissionStudentDaoOrm;
import com.cgh.studentregister.dao.RegisterStudentDaoOrm;
import com.cgh.studentregister.dao.StudentDormityDaoOrm;
import com.cgh.studentregister.pojo.AdmissionStudentOrm;
import com.cgh.studentregister.pojo.RegisterStudentOrm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class registerService {
    @Autowired
    private StudentDormityDaoOrm studentDormityDaoOrm;
    @Autowired
    private AdmissionStudentDaoOrm admissionStudentDaoOrm;
    @Autowired
    private RegisterStudentDaoOrm registerStudentDaoOrm;
    public int registerCheck(String stu_id){
        //是否已注册
        RegisterStudentOrm registerStudentOrm=registerStudentDaoOrm.SelectStudentById(stu_id);
        if(registerStudentOrm!=null){
            return 1;
        }
        //获取录取学生
        AdmissionStudentOrm admissionStudentOrm=admissionStudentDaoOrm.selectAdmissionStudentById(stu_id);
        String stu_major = admissionStudentOrm.getStu_admission();
        String stu_name= admissionStudentOrm.getStu_name();
        String stu_gender= admissionStudentOrm.getStu_gender();
        //生成学号 年份2位+码2位+报到人数3wei
        //年份
        Calendar cal = Calendar.getInstance();
        String first = (Integer.toString(cal.get(Calendar.YEAR))).substring(2, 4);
        String third="";
        String value="";//宿舍号
        //专业码
        String second=getMajorCode(stu_major);
        //报到人数
        int  personRegisterNum=registerStudentDaoOrm.countStudentByMajor(stu_major)+1;
        if( personRegisterNum<10){
            third="00"+Integer.toString( personRegisterNum);
        }else if((personRegisterNum>10)&&((personRegisterNum<100))){
              third="0"+Integer.toString( personRegisterNum);
        }else if( personRegisterNum>100){
             third=Integer.toString( personRegisterNum);
        }
        String stu_num=first.concat(second).concat(third);
        // 班级
        int num=(personRegisterNum/50)+1;
        String stu_class=Integer.toString(num);
        //插入注册表
        registerStudentDaoOrm.insertIntoRegister(stu_name,stu_gender,stu_class,stu_major,stu_num,stu_id);
        // 宿舍号
        for (int i = 1; i > -1; i++) {
            if (i < 10) {
                value = "00" + String.valueOf(i);
            } else if ((i >= 10) && (i < 100)) {
                value = "0" + String.valueOf(i);
            }
            int maxPeople =studentDormityDaoOrm.studentGetRoom(value);
            if (maxPeople < 4) {
                break;
            } else {
                continue;
            }

        }
        //插入宿舍表
        studentDormityDaoOrm.insertIntoDormitory(stu_id,value);
        return 2;

    }
    public String getMajorCode(String stu_major){
        if(stu_major.equals("计算机科学与技术")){
            return "01";
        }else if(stu_major.equals("物联网")){
            return "02";
        }else {
            return "03";
        }
    }
}
