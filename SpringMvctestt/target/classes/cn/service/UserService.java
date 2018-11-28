package cn.service;

import cn.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    List<Userinfo> selse(Userinfo u);

    List<Userinfo> selpag(Userinfo u, int startingLine, int countpage);

    /**
     * 修改
     * @param u
     * @return
     */
    String upda(Userinfo u);

}
