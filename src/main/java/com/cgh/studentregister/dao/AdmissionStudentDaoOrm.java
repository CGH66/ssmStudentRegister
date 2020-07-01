package com.cgh.studentregister.dao;

import com.cgh.studentregister.pojo.AdminOrm;
import com.cgh.studentregister.pojo.AdmissionStudentOrm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AdmissionStudentDaoOrm extends JpaRepository<AdmissionStudentOrm, Integer> {
    @Query(value = "SELECT * FROM stu_admission where stu_name=?1", nativeQuery = true)
    public List<AdmissionStudentOrm> selectAdmissionStudent(String stu_name);
    @Query(value = "SELECT * FROM stu_admission where stu_id=?1", nativeQuery = true)
    public AdmissionStudentOrm selectAdmissionStudentById(String stu_id);

    @Modifying
    @Transactional
    @Query(value = "Insert into stu_admission (stu_name, stu_gender, stu_highschool," +
            "stu_id, stu_admission, stu_imgpath) values(?1, ?2, ?4, ?5, ?6, ?3)", nativeQuery = true)
    public int insertAdmissionStudent(String stu_name,String stu_gender,
                                      String stu_imgpath,String stu_highschool,
                                      String stu_id,String stu_admission);

}
