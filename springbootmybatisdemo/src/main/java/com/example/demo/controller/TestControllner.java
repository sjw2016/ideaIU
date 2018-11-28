package com.example.demo.controller;

import com.example.demo.pojo.Userinfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class TestControllner {
    @Autowired
    private UserService us;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<Userinfo> allSite(){
        return us.getall();
    }
}
