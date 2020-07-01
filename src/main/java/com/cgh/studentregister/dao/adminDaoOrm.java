package com.cgh.studentregister.dao;

import com.cgh.studentregister.pojo.AdminOrm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface adminDaoOrm extends JpaRepository<AdminOrm, Integer> {
    @Query(value = "SELECT * FROM admin where name=?1", nativeQuery = true)
    //用户名唯一 不可同名
    public AdminOrm selectAdmin(String name);
}
