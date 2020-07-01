package com.cgh.studentregister.pojo;

import javax.persistence.*;

@Entity(name = "registerStudent")
public class RegisterStudentOrm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "stu_name")
    private String stu_name;
    @Column(name = "stu_gender")
    private String stu_gender;
    @Column(name = "stu_class")
    private String stu_class;
    @Column(name = "stu_major")
    private String stu_major;
    @Column(name = "stu_id")
    private String stu_id;
    @Column(name = "stu_num")
    private String stu_num;

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getStu_class() {
        return stu_class;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }

    public String getStu_major() {
        return stu_major;
    }

    public void setStu_major(String stu_major) {
        this.stu_major = stu_major;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    public String toString() {
        return "RegisterStudentOrm{" +
                "id=" + id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_gender='" + stu_gender + '\'' +
                ", stu_class='" + stu_class + '\'' +
                ", stu_major='" + stu_major + '\'' +
                ", stu_id='" + stu_id + '\'' +
                ", stu_num='" + stu_num + '\'' +
                '}';
    }
}
