package cn.test;

import cn.dao.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public  static void main(String[] args){
        ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
        LoginService l = (LoginService) as.getBean("service");
        System.out.println(l.login());
    }
}
