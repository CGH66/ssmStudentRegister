package com.cgh.studentregister.pojo;

import javax.persistence.*;

@Entity(name = "stu_dormitor")
public class StudentDormitoryOrm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "room_name")
    private String room_name;
    @Column(name = "room_number")
    private String room_number;
    @Column(name = "stu_id")
    private String stu_id;

    @Override
    public String toString() {
        return "StudentDormitoryOrm{" +
                "id=" + id +
                ", room_name='" + room_name + '\'' +
                ", room_number='" + room_number + '\'' +
                ", stu_id='" + stu_id + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }
}
