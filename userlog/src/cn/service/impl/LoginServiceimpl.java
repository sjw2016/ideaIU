package cn.service.impl;

import cn.dao.UserinfoDao;
import cn.pojo.Userinfo;
import cn.service.LoginService;
import cn.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Service("ls")
public class LoginServiceimpl implements LoginService {

    @Autowired
    private UserinfoDao us;
    public UserinfoDao getUs() {
        return us;
    }
    public void setUs(UserinfoDao us) {
        this.us = us;
    }


    @Override
    public Userinfo sellogin(Userinfo ui) {
        Userinfo u = null;
        Util util = new Util();
        //if (ui.getUsername() != null && ui.getPassword() != null){}
        if (util.isNumLegal(ui.getUsername())){
            ui.setPhone(ui.getUsername());
            ui.setUsername(null);
            u = us.sellogin(ui);
        }else{
            u = us.sellogin(ui);
        }
        if (u != null){
            return u;
        }else{
            return u;
        }
    }
}
