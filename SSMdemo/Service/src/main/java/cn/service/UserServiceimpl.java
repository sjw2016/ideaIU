package cn.service;

import cn.dao.UserinfoDao;
import cn.pojo.Userinfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usi")
public class UserServiceimpl implements UserService {
    @Autowired
    private UserinfoDao us;

    @Override
    public Userinfo sellogin(Userinfo ui) {
        Userinfo u = us.sellogin(ui);
        return u;
    }

    @Override
    public List<Userinfo> sele(Userinfo ui, Integer Pages) {
        PageHelper.startPage(Pages, 5);
        List<Userinfo> lis = us.sele(ui);
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
