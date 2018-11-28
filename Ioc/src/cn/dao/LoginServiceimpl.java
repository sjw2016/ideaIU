package cn.dao;

public class LoginServiceimpl implements LoginService {
    private LoginDao ld;
    private int ss;

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }

    public LoginDao getLd() {
        return ld;
    }

    public void setLd(LoginDao ld) {
        this.ld = ld;
    }

    @Override
    public int login() {
        return ld.log()+ss;
    }
}
