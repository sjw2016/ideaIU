package cn.dao;

import cn.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserinfoDao {
    /**
     * 登录
     * @param u
     * @return
     */
    Userinfo sellogin(Userinfo u);

    /**
     * 修改
     * @param u
     * @return
     */
    int upda(Userinfo u);

    /**
     * 分页查
     * @param u
     * @param startingLine 起始行下标
     * @param countpage 每页显示行数
     * @return
     */
    List<Userinfo> selpag(@Param("u") Userinfo u, @Param("s") int startingLine, @Param("c") int countpage);

    /**
     * 查总共有几行
     * @return
     */
    int selcount();

    /**
     * 查
     * @param u
     * @return
     */
    List<Userinfo> selse(Userinfo u);
}
