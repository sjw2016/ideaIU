package cn.dao;

import cn.pojo.ulogin;
import cn.pojo.userinfo;

import java.util.List;

public interface uloginDao {
    int getcount();
    List<ulogin> lis();
    int inter(ulogin user);
    int updat(ulogin user);
    int dele(ulogin user);
    ulogin ulo(ulogin uu);
    List<userinfo> usi(userinfo us);
}
