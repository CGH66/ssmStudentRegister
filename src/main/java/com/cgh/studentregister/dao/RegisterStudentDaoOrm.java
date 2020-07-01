package com.cgh.studentregister.dao;

import com.cgh.studentregister.pojo.AdmissionStudentOrm;
import com.cgh.studentregister.pojo.RegisterStudentOrm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RegisterStudentDaoOrm extends JpaRepository<RegisterStudentOrm, Integer> {
    @Query(value = "SELECT * FROM stu_registered where stu_id=?1", nativeQuery = true)
    public RegisterStudentOrm SelectStudentById(String stu_id);
    @Query(value = "SELECT COUNT(*) FROM stu_registered where stu_major=?1", nativeQuery = true)
    public int countStudentByMajor(String stu_major);
    @Query(value = "SELECT COUNT(id) FROM stu_registered ", nativeQuery = true)
    public int countAllStudent();
    @Modifying
    @Transactional
    @Query(value = "Insert into stu_registered (stu_name,stu_gender,stu_class,stu_major," +
            "stu_num,stu_id) values(?1,?2,?3,?4,?5,?6)", nativeQuery = true)
    public int insertIntoRegister(String stu_name,String stu_gender,String stu_class
            ,String stu_major,String stu_num,String stu_id);
    @Modifying
    @Transactional
    @Query(value = "update stu_registered set stu_class=?1 where stu_id=?2", nativeQuery = true)
    public int UpdateStudent(String stu_class,String stu_id);
}
