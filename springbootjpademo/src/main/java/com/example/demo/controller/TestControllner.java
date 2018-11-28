package com.example.demo.controller;

import com.example.demo.pojo.Userinfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class TestControllner {
    @Autowired
    private UserService u;
    //查全部
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public List<Userinfo> allSite(){
        return u.allSite();
    }
    //增加，修改
    @RequestMapping(value = "/inse", method = RequestMethod.POST)
    public Userinfo inse(Userinfo us){
        return u.inse(us);
    }
    //查几行
    @RequestMapping(value = "/num", method = RequestMethod.POST)
    public long num(){
        return u.num();
    }
    //删除
    @RequestMapping(value = "/dele", method = RequestMethod.POST)
    public void dele(Userinfo us){
        u.dele(us);
    }
    //分页
    @RequestMapping(value = "/page")
    public List<Userinfo> getSitesBySuid(Integer state,Integer index,Integer pagesize){
        Pageable pageable = new PageRequest(index,pagesize);
        return u.getSitesBySuid(state,pageable);
    }
    //分页
    @RequestMapping(value = "/fen", method = RequestMethod.POST)
    public Page<Userinfo> fen(Integer index, Integer pagesize){
        Pageable pageable = new PageRequest(index,pagesize);
        return u.fen(pageable);
    }

}
