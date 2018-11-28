package com.example.demo.service;

import com.example.demo.pojo.Userinfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
   List<Userinfo> getall();
}
