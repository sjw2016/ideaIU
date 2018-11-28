package com.example.demo;

import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    /**
     * 队列
     * @return
     */
    @Bean
    public Queue hehe(){
        return new Queue("queue");//队列名
    }

    /**
     * 交换机
     * @return
     */
    //订阅模式
    @Bean
    public FanoutExchange haha(){
        return new FanoutExchange("fanoutExchange");
    }

    //路由模式
    @Bean
    public DirectExchange hahaha(){
        return new DirectExchange("directExchange");
    }

    //主题模式
    @Bean
    public TopicExchange hahahaha(){
        return new TopicExchange("topicExchange");
    }

    /**
     * 绑定交换机和队列
     * ----默认形参的名字为队列(交换机)的名字
     */
    @Bean
    public Binding xixi(Queue hehe1, FanoutExchange haha){
        return BindingBuilder.bind(hehe1).to(haha);
    }

    @Bean
    public Binding xixixi(Queue hehe2, DirectExchange hahaha){
        return BindingBuilder.bind(hehe2).to(hahaha).with("routingkeytest");
    }


    @Bean
    public Binding xixixixi(Queue hehe3, TopicExchange hahahaha){
        return BindingBuilder.bind(hehe3).to(hahahaha).with("topic.#");//#表示模糊匹配所有
    }
}
