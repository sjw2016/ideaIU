package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.Parkingfee;
import com.example.demo.service.impl.Parkingfeeimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ParkingfeeController {
    @Autowired
    private Parkingfeeimpl pfi;

    @RequestMapping(value = "/inse", method = RequestMethod.GET)
    public int inse(Parkingfee pf){
        /*ModelAndView mv = new ModelAndView();
        mv.setViewName("carList");
        pfi.inse(pf);
        //mv.addObject("test", JSON.toJSONString( pfi.inse(pf)));
        return mv;*/
        return pfi.inse(pf);
    }

    @RequestMapping(value = "/selall", method = RequestMethod.GET)
    public String selall(){
        return pfi.selall();
    }

    @RequestMapping(value = "/sele", method = RequestMethod.GET)
    public String sele(Parkingfee p){
        System.out.println(p.getWarehouseno());
        return pfi.sele(p);
    }

    @RequestMapping(value = "/upda", method = RequestMethod.GET)
    public String upda(Parkingfee p){
        return pfi.upda(p);
    }
}
