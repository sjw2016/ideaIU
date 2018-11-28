package com.example.demo.dao;

import com.example.demo.pojo.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserinfoDao {
    List<Userinfo> getall();
}
