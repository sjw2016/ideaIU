package com.example.demo.service;

import com.example.demo.dao.UserinfoDao;
import com.example.demo.pojo.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Userinfo inse(Userinfo ui){
        return userinfoDao.save(ui);
    }

    public long num(){
        return userinfoDao.count();
    }

    public void dele(Userinfo ui){
        userinfoDao.delete(ui);
    }

    public List<Userinfo> getSitesBySuid(Integer state,Pageable pageable){
        return userinfoDao.findByState(state,pageable);
    }

    public Page<Userinfo> fen(Pageable pageable){
        return userinfoDao.findAll(pageable);
    }
}
