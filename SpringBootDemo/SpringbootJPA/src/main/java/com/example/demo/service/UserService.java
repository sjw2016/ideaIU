package com.example.demo.service;

import com.example.demo.dao.UserinfoDao;
import com.example.demo.pojo.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UserinfoDao userinfoDao;
    public List<Userinfo> allSite(){
        System.out.println(userinfoDao);
        return userinfoDao.findAll();
    }


}
