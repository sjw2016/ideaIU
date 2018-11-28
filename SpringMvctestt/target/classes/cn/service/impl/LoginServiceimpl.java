package cn.service.impl;

import cn.dao.UserinfoDao;
import cn.pojo.Userinfo;
import cn.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lsi")
public class LoginServiceimpl implements LoginService {
    @Autowired
    private UserinfoDao ui;

    public UserinfoDao getUi() {
        return ui;
    }

    public void setUi(UserinfoDao ui) {
        this.ui = ui;
    }

    @Override
    public Userinfo selelogin(Userinfo u) {
        Userinfo uf = null;
        //判断输入的东西不为空
        //if(u.getUsername().equals("") && u.getUserpwd().equals("")){
            uf = ui.sellogin(u);
            if (uf != null)
                return uf;
            else
                return uf;
       /* }else {
            return uf;*//*
        }*/
    }
}
