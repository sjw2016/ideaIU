package cn.test;

import cn.pojo.Userinfo;
import cn.service.UserinfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserinfoService o = (UserinfoService) as.getBean("us");
        Userinfo u = o.se(1);
        System.out.println( u.getUsername() + u.getPassword());
}
}
