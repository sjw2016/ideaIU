package cn.service;

import cn.pojo.Userinfo;

import java.util.List;

public interface UserService {
    List<Userinfo> selser(Userinfo u, int index, int pagesize);
}
