package cn.service.impl;

import cn.pojo.Userinfo;
import cn.util.Util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Show {
    ApplicationContext ac = new ClassPathXmlApplicationContext("application-mybatis.xml");
    LoginServiceimpl lsi = (LoginServiceimpl) ac.getBean("lsi");
    UserServiceimpl usi = (UserServiceimpl) ac.getBean("usi");
    Scanner in = new Scanner(System.in);
    Userinfo u = new Userinfo();

    /**
     * 登录
     */
    public void login(){
        System.out.println("欢迎进入客户信息管理系统>>>>> \n 请选择您的操作：1.登录\t2.退出登录");
        int num = in.nextInt();
        if (num == 1){
            System.out.println("请输入用户名：");
            u.setUsername(in.next());
            System.out.println("请输入密码：");
            u.setUserpwd(in.next());
            u = lsi.selelogin(u);
            log(u);
        }else if (num == 2){
            System.out.println("退出系统，欢迎下次使用！");
        }else{
            System.out.println("输入错误，重启系统！");
        }
    }

    /**
     * 登录后
     * @param u
     */
    public void log(Userinfo u){
        if(u == null){
            System.out.println("输入错误，重启系统，重新输入！");
            login();
        }else {
           if(u.getUseradmin() != 1){
               System.out.println(u.getUsername() + "正在登录\n以下是您的个人信息：" + "手机号" + u.getUserphone() + "爱好:" + u.getUserhobby() + "性别:" + u.getSex() + "地址" + u.getUseraddress() +"输入1修改信息，其他返回登录界面");
               if (in.nextInt() != 1)
                   login();
               else
                   updchoose(u);
           }else {
               System.out.println("管理员：" + u.getUsername() + "正在登录");
               List<Userinfo> lis = usi.selse(u);
               for (Userinfo uu:lis) {
                   System.out.println("用户编号：" + uu.getUserid() + "姓名：" + uu.getUsername() +"性别：" + u.getSex());
               }
           }
        }
    }

    /**
     * 选择修信息
     * @param u
     */
    public void updchoose(Userinfo u){
        System.out.println(u.getUsername() + "请选择要修改的信息：" + "1.用户名" + u.getUsername() + "2.密码" + u.getUserpwd() + "3.手机号" + u.getUserphone() + "4.地址：" + u.getUseraddress() + "5.性别:" + u.getSex() +"6.爱好:" + u.getUserhobby());
        upda(in.nextInt(),u);
    }

    public void upda(int count, Userinfo u) {
        switch (count) {
            case 1:
                System.out.println("请输入新用户名（3~6位)");
                //u.setUsername(in.next());
                if (!nameupd(in.next(), u)) {
                    System.out.println("输入错误！");
                    upda(1, u);
                }
                break;
            case 2:
                System.out.println("请输入密码(6~12位)");
                u.setUserpwd(in.next());
                /*if (!pwdupd(in.next(), u)) {
                    System.out.println("输入错误！");
                    upda(2, u);
                }*/
                break;
            case 3:
                System.out.println("请输入新手机号");
               // u.setUserphone(in.next());
                if (phoneupd(in.next(), u)) {
                    System.out.println("输入错误！");
                    upda(3, u);
                }
                break;
            case 4:
                System.out.println("请输入地址");
               // u.setUseraddress(in.next());
                if (!addressupd(in.next(), u)) {
                    System.out.println("输入错误！");
                    upda(4, u);
                }
                break;
            case 5:
                System.out.println("请输入新性别");
               // u.setSex(in.next());
                if (!sexupd(in.next(), u)) {
                    System.out.println("输入错误！");
                    upda(5, u);
                }
                break;
            case 6:
                System.out.println("请输入爱好");
               // u.setUserhobby(in.next());
                if (!hobbyupd(in.next(), u)) {
                    System.out.println("输入错误！");
                    upda(6, u);
                }
                break;
            default:
                System.out.println("输入错误，请重新输入：");
                int num = in.nextInt();
                upda(num, u);
        }

            System.out.println(usi.upda(u) + "请重新登录查看");
            login();

    }
    /**
     * 修改手机号
     *
     * @param phone
     * @param u
     * @return
     */
    public boolean phoneupd(String phone, Userinfo u) {
        Util util = new Util();
        boolean flag = util.isNumLegal(phone);
        if (flag && !phone.equals(u.getUserphone())) {
            u.setUserphone(phone);
            flag = false;
        }
        return flag;
    }

    /**
     * 修改用户名
     * @param name
     * @param u
     * @return
     */
    public boolean nameupd(String name, Userinfo u) {
        if (name.length() < 7 && name.length() > 2 && !name.equals(u.getUsername())) {
            u.setUsername(name);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改密码
     *
     * @param pwd
     * @param u
     * @return
     */
    public boolean pwdupd(String pwd, Userinfo u) {
        if (pwd.length() < 13 && pwd.length() > 5) {
            u.setUserpwd(pwd);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改性别
     *
     * @param sex
     * @param u
     * @return
     */
    public boolean sexupd(String sex, Userinfo u) {
        if (sex.equals("男") || sex.equals("女")){
            u.setSex(sex);
            return true;
        }
        else{
            return false;
        }

    }


    /**
     * 修改地址
     * @param add
     * @param u
     * @return
     */
    public boolean addressupd(String add, Userinfo u) {
        if (!add.equals(null)){
            u.setUseraddress(add);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 修改爱好
     * @param hobb
     * @param u
     * @return
     */
    public boolean hobbyupd(String hobb, Userinfo u){
        if (!hobb.equals(null)){
            u.setUseraddress(hobb);
            return true;
        }
        else{
            return false;
        }
    }
}
