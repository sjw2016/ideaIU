package service.impl;

import cn.dao.UserinfoDao;
import cn.pojo.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import service.UserinfoService;

import java.util.List;

@Repository("usi")
public class UserinfoServiceimpl implements UserinfoService {
    @Autowired
    private UserinfoDao ud;

    public UserinfoDao getUd() {
        return ud;
    }

    public void setUd(UserinfoDao ud) {
        this.ud = ud;
    }

    @Override
    public List<Userinfo> seles(Userinfo u) {
        return ud.sele(u);
    }
}
