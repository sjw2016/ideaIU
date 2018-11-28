package cn.service.impl;

import cn.dao.UserinfoDao;
import cn.pojo.Userinfo;
import cn.service.UserService;
import cn.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usi")
public class UserServiceimpl implements UserService {
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
        Userinfo u = us.sellogin(ui);
        return u;
    }

    @Override
    public List<Userinfo> sele(Userinfo ui, int currentPageNumber, Page p) {
        List<Userinfo> lis = us.sele(ui, (currentPageNumber - 1) * 3, 3);
        int x = us.selrows();
        if (x % 3 == 0) {
            p.setTotalPages(x / 3);
        } else {
            p.setTotalPages((x / 3) + 1);
        }
        return lis;
    }

    @Override
    public String updat(Userinfo ui) {
        String text = null;
        int count = us.updat(ui);
        if (count != 0) {
            text = "修改成功";
        }else {
            text = "修改失败";
        }
        return (text);
    }
}
