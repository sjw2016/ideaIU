package cn.service;

import cn.dao.UserinfoDao;
import cn.pojo.Userinfo;
import cn.util.Page;
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

    Page p = new Page();
    @Override
    public List<Userinfo> selser(Userinfo u, int index, int pagesize) {
        p.setTotalcount(ui.selrows());//总条目数
        p.setTotalPages(p.getTotalcount()/pagesize);//总页数
        p.setIndex(index);
        List<Userinfo> lis = ui.sele(u,(index-1)*pagesize, pagesize);
        return lis;
    }

    public List<Userinfo> page(int x, Userinfo u){
        if (x == 1)
            p.setIndex(p.getIndex()-1);
        else
            p.setIndex(p.getIndex()+1);
        return  selser(u,p.getIndex(),3);
    }
}
