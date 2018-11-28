package com.example.demo.service;

import com.example.demo.pojo.Parkingfee;

import java.util.List;

public interface Parkingfeeservice {
    /**
     * 增
     * @param p
     * @return
     */
    int inse(Parkingfee p);

    /**
     * 查所有
     * @return
     */
    String selall();

    /**
     * 查
     * @param p
     * @return
     */
    String sele(Parkingfee p);

    /**
     * 修改
     * @param p
     * @return
     */
    String upda(Parkingfee p);
}
