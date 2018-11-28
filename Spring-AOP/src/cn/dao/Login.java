package cn.dao;

import org.springframework.stereotype.Component;

@Component("ll")
public class Login {
    public String name(){
        System.out.println("被增强方法");
        return "aa";
    }
}
