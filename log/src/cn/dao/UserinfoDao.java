package cn.dao;

import cn.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserinfoDao {
    /**
     * 登录
     * @param ui Userinfo对象 包含用户名，手机号和密码
     * @return Userinfo对象
     */
    Userinfo sellogin(Userinfo ui);

    /**
     * 查询
     * @param ui Userinfo对象 包含用户名，state来区分
     * @param startingLineSubscript 起始行下标
     * @param rows 显示行数
     * @return Userinfo对象集合
     */
    List<Userinfo> sele(@Param("ui") Userinfo ui, @Param("sls") int startingLineSubscript, @Param("r") int rows);

    /**
     * 修改
     * @param ui Userinfo对象 包含判断这个人是谁和要修改的内容
     * @return 受影响行数
     */
    int updat(Userinfo ui);

    /**
     * 查有几行
     * @return
     */
    int selrows();
}

