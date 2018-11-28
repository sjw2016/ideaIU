package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.Userinfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/demo")
public class TestControllner {
    @Autowired
    private UserService us;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView allSite(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("test", JSON.toJSONString(us.getall()));
        return mv;
    }
}
