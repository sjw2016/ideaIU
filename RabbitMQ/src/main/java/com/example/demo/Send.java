package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Send {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * param1:交换机的名字
     * param2:路由键的名字
     * param3:要发送的消息
     *
     * 三个模式都有路由键(routingkey),订阅模式的routingkey为"",表示匹配所有routingkey
     */
    @RequestMapping("/hehe")
    public void send(){
        amqpTemplate.convertAndSend("topicExchange","topic.kafggdfkaka", "消息");
    }

}
