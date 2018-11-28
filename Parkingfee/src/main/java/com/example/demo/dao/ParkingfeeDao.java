package com.example.demo.dao;

import com.example.demo.pojo.Parkingfee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ParkingfeeDao {

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
    List<Parkingfee> selall();

    /**
     * 查
     * @param p
     * @return
     */
    Parkingfee sele(Parkingfee p);

    /**
     * 修改
     * @param p
     * @return
     */
    int upda(Parkingfee p);
}
