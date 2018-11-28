package com.example.solrdemo.controller;

import com.example.solrdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseBody
    @RequestMapping("/sel")
    public String show(HttpServletRequest request){
        String text = request.getParameter("text");
        System.out.println(1);
        return productService.selDocumentList(text,1,50);
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(){
        return productService.add();
    }

    @ResponseBody
    @RequestMapping("/del")
    public String del(String id){
        return productService.delete(id);
    }

}
