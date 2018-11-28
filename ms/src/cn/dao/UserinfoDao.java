package cn.dao;

import cn.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserinfoDao {
    List<Userinfo> sel(Userinfo us);
    int inst(Userinfo us);
    int upda(Userinfo us);
    int del(Userinfo us);
    List<Userinfo> selPaging(@Param("us") Userinfo us, @Param("ss") int startSubscript,@Param("r") int rows);
}
