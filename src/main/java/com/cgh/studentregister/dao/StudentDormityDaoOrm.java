package com.cgh.studentregister.dao;

import com.cgh.studentregister.pojo.AdminOrm;
import com.cgh.studentregister.pojo.RegisterStudentOrm;
import com.cgh.studentregister.pojo.StudentDormitoryOrm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentDormityDaoOrm extends JpaRepository<StudentDormitoryOrm, Integer> {
    @Query(value = "SELECT COUNT(*) FROM stu_dormitory where room_number=?1", nativeQuery = true)
    //用户名唯一 不可同名
    public int studentGetRoom(String room_number);
    @Modifying
    @Transactional
    @Query(value = "Insert into stu_dormitory (stu_id,room_number) values(?1,?2)", nativeQuery = true)
    public int insertIntoDormitory(String stu_id,String room_number);
    @Modifying
    @Transactional
    @Query(value = "update stu_dormitory set room_name=?3,room_number=?2 where stu_id=?1", nativeQuery = true)
    public int UpdateDormitory(String stu_id,String room_number,String room_name);

}
