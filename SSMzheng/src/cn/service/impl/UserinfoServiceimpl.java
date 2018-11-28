package cn.service.impl;

import cn.dao.UserinfoDao;
import cn.pojo.Userinfo;
import cn.service.UserinfoService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Repository("usi")
public class UserinfoServiceimpl implements UserinfoService {
    Userinfo u = null;
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

    @Override
    public String seleee() {
        List<Userinfo> lis = ud.sele(u);
        return JSON.toJSONString(lis);
    }

}
