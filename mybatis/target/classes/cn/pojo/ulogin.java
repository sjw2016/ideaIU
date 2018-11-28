package cn.pojo;

public class ulogin {
    private Integer id;
    private String uname;
    private Integer usex;
    private String upwd;
    private userinfo us;

    public userinfo getUs() {
        return us;
    }

    public void setUs(userinfo us) {
        this.us = us;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnamme() {
        return uname;
    }

    public void setUnamme(String unamme) {
        this.uname = unamme;
    }

    public Integer getUsex() {
        return usex;
    }

    public void setUsex(Integer usex) {
        this.usex = usex;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
