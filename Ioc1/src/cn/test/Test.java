package cn.test;

import cn.dao.UserinfoS;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserinfoS us = (UserinfoS) as.getBean("s");
        System.out.println(us.see());
    }
}
