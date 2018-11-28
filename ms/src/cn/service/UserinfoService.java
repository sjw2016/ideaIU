package cn.service;

import cn.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserinfoService {
    List<Userinfo> sel(Userinfo us);
    String inst(Userinfo us);
    String upda(Userinfo us);
    String del(Userinfo us);

    /**
     * 分页查询
     * @param us 对象
     * @param numberOfPages 当前页数
     * @param rows 显示几行
     * @return 对象集合
     */
    List<Userinfo> selPaging(Userinfo us, int numberOfPages,  int rows);
}
