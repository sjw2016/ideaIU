package cn.service;

import cn.pojo.Userinfo;
import cn.util.Page;

import java.util.List;

public interface UserService {
    /**
     * 查询
     * @param ui Userinfo对象 包含用户id
     * @return Userinfo对象
     */
    Userinfo sellogin(Userinfo ui);
    /**
     * 查询
     * @param ui Userinfo对象 包含用户名，state来区分
     * @param currentPageNumber 当前页数
     * @return Userinfo对象集合
     */
    List<Userinfo> sele(Userinfo ui, int currentPageNumber, Page p);

    /**
     * 修改
     * @param ui Userinfo对象 包含判断这个人是谁和要修改的内容
     * @return
     */
    String  updat(Userinfo ui);
}
