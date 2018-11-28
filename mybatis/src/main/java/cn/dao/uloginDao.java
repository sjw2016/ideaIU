package cn.dao;

import cn.pojo.ulogin;
import cn.pojo.userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface uloginDao {
    int getcount();
    List<ulogin> lis();
    int inter(ulogin user);
    int updat(ulogin user);
    int dele(ulogin user);
    ulogin ulo(@Param("hh") ulogin uu);
    List<userinfo> usi(userinfo us);
}
