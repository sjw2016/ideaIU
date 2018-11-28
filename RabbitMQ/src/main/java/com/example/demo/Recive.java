package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;


@Component
public class Recive {

    /**
     * 监听
     * @param s
     *///队列名字
    @RabbitListener(queues = "queue")
    public void jiji(String s){
        System.out.println(s);
    }
}
