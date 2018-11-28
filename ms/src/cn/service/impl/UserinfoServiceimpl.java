package cn.service.impl;

import cn.dao.UserinfoDao;
import cn.pojo.Userinfo;
import cn.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("us")
public class UserinfoServiceimpl implements UserinfoService {

    @Autowired
    private UserinfoDao ui;

    public UserinfoDao getUi() {
        return ui;
    }

    public void setUi(UserinfoDao ui) {
        this.ui = ui;
    }

    @Override
    public List<Userinfo> sel(Userinfo us) {
        List<Userinfo> lis = ui.sel(us);
        return lis;
    }

    @Override
    public String inst(Userinfo us) {
        String text = null;
        if (us.getUsername() != null && us.getPassword() != null && us.getPhone() != null){
            int count = ui.inst(us);
            if (count == 0){
                text = "添加失败";
            }else if (count == 1){
                text = "添加成功";
            }
        }else{
            text = "输入信息不完整";
        }
        return text;
    }

    @Override
    public String upda(Userinfo us) {
        String text = null;
        if (us.getId() != null){
            int count = ui.upda(us);
            if (count == 0){
                text = "修改失败";
            }else if (count == 1){
                text = "修改成功";
            }
        }else{
            text = "输入信息不完整";
        }
        return text;
    }

    @Override
    public String del(Userinfo us) {
        String text = null;
        if (us.getId() != null){
            int count = ui.del(us);
            if (count == 0){
                text = "删除失败";
            }else if (count == 1){
                text = "删除成功";
            }
        }else{
            text = "输入信息不完整";
        }
        return text;
    }

    @Transactional("")
    @Override
    public List<Userinfo> selPaging(Userinfo us, int numberOfPages, int rows) {
        List<Userinfo> lis = ui.selPaging(us, (numberOfPages-1)*rows, rows);
        return lis;
    }
}
