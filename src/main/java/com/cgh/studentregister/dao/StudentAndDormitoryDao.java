package com.cgh.studentregister.dao;

import com.cgh.studentregister.pojo.StudentAndDormitory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentAndDormitoryDao {
    @Select("select r.*,d.room_name,d.room_number FROM stu_registered r,stu_dormitory d" +
            " where r.stu_id=d.stu_id ORDER BY r.id LIMIT #{startSize},#{Size}")
    public List<StudentAndDormitory> getStudentAndDormitory(@Param("startSize")Integer startSIze,@Param("Size") int Size);
    @Select("select r.*,d.room_name,d.room_number FROM stu_registered r,stu_dormitory d" +
            " where r.stu_id=d.stu_id and r.stu_id=#{stu_id}")
    public StudentAndDormitory getStudentAndDormitoryById(String stu_id);
}
