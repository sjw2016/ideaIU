package com.example.demo.controller;

import com.example.demo.pojo.Userinfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class TestControllner {
    @Autowired
    private UserService u;

    @RequestMapping("/user")
    public List<Userinfo> allSite(){
        return u.allSite();
    }
}
