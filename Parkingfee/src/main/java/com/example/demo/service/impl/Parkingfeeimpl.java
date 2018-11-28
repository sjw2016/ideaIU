package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.ParkingfeeDao;
import com.example.demo.pojo.Parkingfee;
import com.example.demo.service.Parkingfeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class Parkingfeeimpl implements Parkingfeeservice {
    @Autowired
    private ParkingfeeDao pfd;

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    String time = df.format(new Date().getTime());// new Date()获取当前系统时间

    public long time(String time){
        //时间转换为时间戳
        Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        //java中时间戳毫秒计/1000 换算为秒
        long unixTimestamp = date.getTime() / 1000;
            return unixTimestamp;
    }

    String text = null;
    @Override
    public int inse(Parkingfee p) {
        if (!p.getWarehouseno().equals("")) {
            p.setState("0");
            p.setStoragetime(time);
        }
        return pfd.inse(p);
    }

    @Override
    public String selall() {
        List<Parkingfee> pf = pfd.selall();
        for (Parkingfee p: pf) {
            if (p.getState().equals("0"))
                p.setState("未离库");
            else
                p.setState("已出库");
        }
        return JSON.toJSONString(pf);
    }

    @Override
    public String sele(Parkingfee p) {
        if (!p.getWarehouseno().equals("")){
            text = JSON.toJSONString(pfd.sele(p));
        }
        else{
            text = "查询失败";
        }
        return text;
    }

    @Override
    public String upda(Parkingfee p) {
        if (!p.getWarehouseno().equals("")){
            p = pfd.sele(p);
            p.setState("1");
            p.setOutagetime(time);
            long s = time(p.getOutagetime()) - time(p.getStoragetime());
            p = getTimeFormatText(s,p);
            if (pfd.upda(p) == 1){
                String t = String.valueOf(s/60) + "分钟";
                p.setDat(t);
                text = JSON.toJSONString(p);
            }else{
                text = "出库失败";
            }
        } else{
            text = "出库失败";
        }
        return text;
    }

    public static Parkingfee getTimeFormatText(Long time, Parkingfee p) {
        if (time == null) {
            return p;
        }
        final long second = 1;// 1秒
        final long minute = 60 * second;// 1分钟
        final long hour = 60 * minute;// 1小时
        final long day = 24 * hour;// 1天
        final long month = 31 * day;// 月
        final long year = 12 * month;// 年

        if (time <= 30*minute) {
            p.setAmountmoney("2.5元");
        }if (time >= 30*minute && time <hour) {
            p.setAmountmoney("5元");
        }if (time >= hour) {
            p.setAmountmoney("10元");
        }if (time >= day){
            p.setAmountmoney("100元");
        }
        return p;
    }
}