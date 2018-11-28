package cn.contrller;

import cn.pojo.Userinfo;
import cn.service.LoginService;
import cn.service.impl.LoginServiceimpl;
import cn.service.impl.Show;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Contrller {

    @RequestMapping("/asd")
    public ModelAndView sdf(Userinfo u){
       /* ApplicationContext ac = new ClassPathXmlApplicationContext("application-mybatis.xml");
        LoginServiceimpl lsi = (LoginServiceimpl) ac.getBean("lsi");*/
       LoginServiceimpl lsi = new LoginServiceimpl();
        System.out.println(u.getUsername() + u.getUserpwd());
        u = lsi.selelogin(u);
        ModelAndView m = new ModelAndView();
        m.addObject("ssss",u);
        m.setViewName("show");
        return m;
    }
}
