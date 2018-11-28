package cn.controller;

import cn.pojo.Userinfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserinfoService;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("test/")
@Controller
public class ControllerTest {
    @Resource(name = "usi")
    private UserinfoService us;

    public UserinfoService getUs() {
        return us;
    }

    public void setUs(UserinfoService us) {
        this.us = us;
    }

    @ResponseBody
    @RequestMapping(value = "sss")
    public List<Userinfo> sdf(@RequestBody Userinfo u){
        System.out.println(us.seles(u).get(4).getUsername());
        return us.seles(u);
    }

    @ResponseBody
    @RequestMapping(value = "ddd")
    public String dsfa(@RequestBody List<Userinfo> uj){
            System.out.println(uj.get(0).getUsername());
        return uj.get(0).getUsername();
    }
}
