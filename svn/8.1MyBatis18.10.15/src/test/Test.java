package test;

import cn.dao.uloginDao;
import cn.pojo.ulogin;
import cn.pojo.userinfo;
import cn.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class Test {
    public static void main(String[] args){
        SqlSession session = MyBatisUtil.getSqlSession();
        uloginDao mapper = session.getMapper(uloginDao.class);
        ulogin u = new ulogin();
/*增加
        u.setId(4);
		u.setUpwd("sfd");
		u.setUnamme("fsda");
		u.setId(0);
		u.setUsex(1);
		System.out.println(mapper.inter(u));
*/
        //System.out.println(mapper.lis().get(1).getUseruname());//查集合
        //System.out.println(mapper.getcount());//查询
/*修改	u.setId(4);
		u.setUnamme("jklhhjkl");
		u.setUpwd("jkhhjkgu");
		System.out.println(mapper.updat(u));*/
/*删除	u.setId(3);
		System.out.println(mapper.dele(u));*/
        u.setUnamme("qq");
        System.out.println(mapper.ulo(u).getUs().getPhone());
/*一对多        userinfo ui = new userinfo();
        ui.setUsername("aa");
        System.out.println(mapper.usi(ui).get(0).getUl().getUpwd());*/
        session.commit();
        session.close();
    }
}
