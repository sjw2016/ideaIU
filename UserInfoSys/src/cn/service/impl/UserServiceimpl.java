package cn.service.impl;

import cn.dao.UserinfoDao;
import cn.pojo.Userinfo;
import cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("usi")
public class UserServiceimpl implements UserService {

    @Autowired
    private UserinfoDao ui;

    public UserinfoDao getUi() {
        return ui;
    }

    public void setUi(UserinfoDao ui) {
        this.ui = ui;
    }


    @Override
    public List<Userinfo> selse(Userinfo u) {
        List<Userinfo> lis = ui.selse(u);
        return lis;
    }

    @Override
    public List<Userinfo> selpag(Userinfo u, int startingLine, int countpage) {
        return null;
    }

    @Override
    public String upda(Userinfo us) {
        String text = null;
        int count = ui.upda(us);
        if (count != 0) {
            text = "修改成功";
        }else {
            text = "修改失败";
        }
        return (text);
    }
}
