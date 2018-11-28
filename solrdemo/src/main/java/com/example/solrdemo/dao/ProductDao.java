package com.example.solrdemo.dao;

import com.example.solrdemo.pojo.Userinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    /**
     * 查询全部产品
     * @return
     */
    List<Userinfo> selAll();

}
