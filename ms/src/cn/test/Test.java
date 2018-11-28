package cn.test;

import cn.pojo.Userinfo;
import cn.service.UserinfoService;
import cn.service.impl.UserinfoServiceimpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        UserinfoServiceimpl us = (UserinfoServiceimpl) ac.getBean("us");
        Userinfo ui = new Userinfo();
        //查询
       /* ui.setId(1);
        List<Userinfo> lis = us.sel(ui);
        for (Userinfo u : lis){
            System.out.println(u.getUsername() + " " + u.getPassword() + " " +u.getSex());
        }*/
       //添加
      /* ui.setId(0);
       ui.setUsername("速度很快");
       ui.setPassword("123456");
       ui.setSex(1);
       ui.setPassword("穷疯核算");
       ui.setHobdy("模块");
       ui.setPhone("119");
       System.out.println(us.inst(ui));*/
       //删除
       /* ui.setId(4);
        System.out.println(us.del(ui));*/
        //修改
       /* ui.setId(5);
        ui.setUsername("速度");
        ui.setPassword("123");
        ui.setSex(1);
        ui.setPassword("核算");
        ui.setHobdy("块");
        ui.setPhone("114");
        System.out.println(us.upda(ui));*/
        //分页查询
        ui.setSex(1);
        List<Userinfo> lis = us.selPaging(ui,3,1);
        for (Userinfo u : lis){
            System.out.println(u.getUsername() + " " + u.getPassword() + " " +u.getSex());
        }
    }
}
