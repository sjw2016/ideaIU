package cn.service;

import cn.dao.UserinfoDao;
import cn.pojo.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("us")
public class UserinfoService implements UserinfoServiceDao {
    @Autowired
    private UserinfoDao userinfoDao;

    public UserinfoDao getUserinfoDao() {
        return userinfoDao;
    }

    public void setUserinfoDao(UserinfoDao userinfoDao) {
        this.userinfoDao = userinfoDao;
    }

    public Userinfo se(int id) {
        /*ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserinfoDao ud = (UserinfoDao) as.getBean("ud");*/
        Userinfo u = userinfoDao.sele(id);
        return u;
    }
}
