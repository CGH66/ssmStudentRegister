package com.cgh.studentregister.pojo;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.persistence.Column;

public class StudentAndDormitory  {
    private int id;

    private String stu_name;
    private String stu_gender;
    private String stu_class;
    private String stu_major;
    private String stu_id;
    private String stu_num;
    private String room_name;
    private String room_number;

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

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    @Override
    public String toString() {
        return "StudentAndDormitory{" +
                "id=" + id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_gender='" + stu_gender + '\'' +
                ", stu_class='" + stu_class + '\'' +
                ", stu_major='" + stu_major + '\'' +
                ", stu_id='" + stu_id + '\'' +
                ", stu_num='" + stu_num + '\'' +
                ", room_name='" + room_name + '\'' +
                ", room_number='" + room_number + '\'' +
                '}';
    }
}
