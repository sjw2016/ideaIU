package cn.dao;

public class UserinfoS implements UserinfoService {
    private Userinfo userinfo;
    private String qq;

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    @Override
    public String see() {
        return userinfo.sele() + qq;
    }
}
