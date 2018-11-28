package com.example.demo.dao;

import com.example.demo.pojo.Userinfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserinfoDao extends JpaRepository<Userinfo,Integer> {
    public List<Userinfo> findBySuid(Integer suid, Pageable pageable);
}
