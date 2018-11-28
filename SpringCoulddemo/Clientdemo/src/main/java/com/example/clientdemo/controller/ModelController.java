/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ModelController
 * Author:   HHHH
 * Date:     2018/11/14 8:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * 　　　　　　　 ┏┓       ┏┓+ +
 * 　　　　　　　┏┛┻━━━━━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　 ┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 █████━█████  ┃+
 * 　　　　　　　┃　　　　　　 ┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　 ┃ + +
 * 　　　　　　　┗━━┓　　　 ┏━┛
 * 　　　　　　　　　┃　　  ┃ + + + +
 * 　　　　　　　　　┃　　　┃　Code is far away from     bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　         神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　 ┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━━━┳┓┏┛ + + + +
 * 　　　　　　　　　 ┃┫┫　 ┃┫┫
 * 　　　　　　　　　 ┗┻┛　 ┗┻┛+ + + + *
 */
package com.example.clientdemo.controller;

import com.example.clientdemo.service.AddService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author HHHH
 * @create 2018/11/14
 * @since 1.0.0
 */
@RestController
public class ModelController {
    @Resource
    private AddService addService;

    @Value("${server.port}")
    String post;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b){
        return addService.add(a,b);
    }
    @RequestMapping(value = "/getString", method = RequestMethod.GET)
    @ResponseBody
    public String info(@RequestParam String name){
        StringBuffer str = new StringBuffer();
        str.append("欢迎：");
        str.append(name);
        str.append("这里是第四个服务");
        str.append("我来自" + post + "端口");
        return str.toString();
    }
}
