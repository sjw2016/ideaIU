package cn.controller;

import cn.pojo.userinfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping("/ddd")
    public String sds(){
        return "index";
    }

    @RequestMapping("/ss")
    public ModelAndView asd( userinfo u){
        ModelAndView mav = new ModelAndView();
        System.out.println(u.getName() + u.getPwd() + u.getAge());
        mav.addObject("name","股份大V是");
        mav.setViewName("index");
        return mav;
    }
}
