package cn.test;

import cn.dao.Login;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Login l = (Login) ac.getBean("ll");
        System.out.println(l.name());
    }
}
