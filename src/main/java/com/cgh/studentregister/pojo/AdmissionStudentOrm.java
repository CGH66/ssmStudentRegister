package com.cgh.studentregister.pojo;

import javax.persistence.*;

@Entity(name = "stu_admission")
public class AdmissionStudentOrm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "stu_name")
    private String stu_name;//姓名
    @Column(name = "stu_gender")
    private String stu_gender;//性别
    @Column(name = "stu_highschool")
    private String stu_highSchool;//毕业高中
    @Column(name = "stu_id")
    private String stu_id;//身份证
    @Column(name = "stu_admission")
    private String stu_admission;
    @Column(name = "stu_imgpath")
    private String stu_imgpath;//头像路径
    public String getStu_imgpath() {
        return stu_imgpath;
    }

    public void setStu_imgpath(String stu_imgpath) {
        this.stu_imgpath = stu_imgpath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_gender() {
        return stu_gender;
    }

    public void setStu_gender(String stu_gender) {
        this.stu_gender = stu_gender;
    }

    public String getStu_highSchool() {
        return stu_highSchool;
    }

    public void setStu_highSchool(String stu_highSchool) {
        this.stu_highSchool = stu_highSchool;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_admission() {
        return stu_admission;
    }

    public void setStu_admission(String stu_admission) {
        this.stu_admission = stu_admission;
    }

    @Override
    public String toString() {
        return "AdmissionStudentOrm{" +
                "id=" + id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_gender='" + stu_gender + '\'' +
                ", stu_highSchool='" + stu_highSchool + '\'' +
                ", stu_id='" + stu_id + '\'' +
                ", stu_admission='" + stu_admission + '\'' +
                ", stu_imgpath='" + stu_imgpath + '\'' +
                '}';
    }
}
