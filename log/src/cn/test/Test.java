package cn.test;

import cn.pojo.Userinfo;
import cn.service.UserServiceimpl;
import cn.util.Page;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application-mybatis.xml");
        UserServiceimpl usi = (UserServiceimpl) ac.getBean("usi");
        Userinfo u = new Userinfo();
        Page p = new Page();
        List<Userinfo> lis = usi.selser(u,1,3);
        for (Userinfo uu:lis) {
            System.out.println(uu.getUsername());
        }
        Scanner in = new Scanner(System.in);
        List<Userinfo> li = usi.page(in.nextInt(),u);
        for (Userinfo uu:li) {
            System.out.println(uu.getUsername());
        }

    }
}
