package com.example.demo.service.impl;

import com.example.demo.dao.UserinfoDao;
import com.example.demo.pojo.Userinfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserinfoDao ud;

    @Override
    public List<Userinfo> getall() {
        return ud.getall();
    }
}
