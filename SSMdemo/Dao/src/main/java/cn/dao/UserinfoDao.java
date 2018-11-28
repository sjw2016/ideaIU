package cn.dao;

import cn.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;

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
     * @return Userinfo对象集合
     */
    List<Userinfo> sele( Userinfo ui);

    /**
     * 修改
     * @param ui Userinfo对象 包含判断这个人是谁和要修改的内容
     * @return 受影响行数
     */
    int updat(Userinfo ui);

}

