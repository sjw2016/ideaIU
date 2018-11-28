package cn.service;

import cn.pojo.Userinfo;

public interface LoginService {
    /**
     * 登录
     * @param ui Userinfo对象 包含用户名，手机号和密码
     * @return Userinfo对象
     */
    Userinfo sellogin(Userinfo ui);
}
