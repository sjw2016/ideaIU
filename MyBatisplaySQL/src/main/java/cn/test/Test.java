package cn.test;

import cn.dao.uloginDao;
import cn.pojo.ulogin;
import cn.pojo.userinfo;
import cn.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class Test {
    public static void main(String[] args){
        SqlSession ss = MyBatisUtil.getSqlSession();
        uloginDao mapp = ss.getMapper(uloginDao.class);
      /*  userinfo us = new userinfo();
        us.setUsername("aa");
        us.setPhone("2343423");
        System.out.println(mapp.usi(us).get(0).getUl().get(0).getUsex());*/
      ulogin ul = new ulogin();
      ul.setUnamme("sjw");
      ul.setUpwd("sjw");
      ul.setUsex(1);
      ul.setId(6);
      System.out.println(mapp.up(ul) > 0 ? "修改成功":"修改失败");
      ss.commit();
      ss.close();
    }
}
