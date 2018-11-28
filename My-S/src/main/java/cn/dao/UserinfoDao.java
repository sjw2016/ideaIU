package cn.dao;

import cn.pojo.Userinfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

public interface UserinfoDao {
    Userinfo sele(int id);
}
