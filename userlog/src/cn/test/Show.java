package cn.test;

import cn.pojo.Userinfo;
import cn.service.LoginService;

import cn.service.UserService;
import cn.util.Page;
import cn.util.Util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Show {
    Scanner in = new Scanner(System.in);
    ApplicationContext ac = new ClassPathXmlApplicationContext("application-mybatis.xml");
    LoginService ls = (LoginService) ac.getBean("ls");
    UserService usi = (UserService) ac.getBean("usi");
    Userinfo u = new Userinfo();
    Page p = new Page();

    /**
     * 登录
     */
    public void login() {

        System.out.println("请登录：");
        System.out.println("请输入手机号或用户名：");
        u.setUsername(in.next());
        System.out.println("请输入密码：");
        u.setPassword(in.next());
        u = ls.sellogin(u);
        if (u != null) {
            if (u.getState() != 0) {
                //普通用户
                useroperate(u);
            } else {
                //管理员
                adminoperating(u);
            }
        } else {
            System.out.println("输入错误，登录错误，请重新登录");
            login();
        }
    }

    /**
     * 判断用户名
     *
     * @param username
     * @return
     */
    public String userNameFactory(String username) {
        if (username.length() > 7) {
            String[] str = username.split("");
            StringBuffer strs = new StringBuffer();
            for (int i = 0; i < 5; i++) {
                strs.append(str[i]);
            }
            strs.append("...");
            String newName = strs.toString();
            return newName;
        }
        return username;
    }

    /**
     * 普通用户操作
     *
     * @param u
     */
    public void useroperate(Userinfo u) {
        System.out.println("欢迎：" + userNameFactory(u.getUsername()) +
                "请选择要修改的信息：" + "\n1.姓名：" + u.getUsername()
                + "\t" + "2.密码：" + u.getPassword() + "\t3.手机号：" +
                u.getPhone() + "\t4.地址：" + u.getAddress() + "\t5.性别："
                + u.getSex() + "\t6.年龄：" + u.getAge() + "\t7.收入：" +
                u.getWage());
        upda(in.nextInt(), u);
    }


    /**
     * 管理员操作
     *
     * @param u
     */
    public void adminoperating(Userinfo u) {
        System.out.println("欢迎管理员：" + userNameFactory(u.getUsername()) + "\n1.修改信息 \t 2.显示用户信息");
        switch (in.nextInt()) {
            case 1:
                useroperate(u);
                break;
            case 2:
                p.setCurrentPageNumber(1);
                List<Userinfo> lis = usi.sele(u, p.getCurrentPageNumber(), p);
                adminupd(lis);
                break;
            default:
                System.out.println("输入错误，重输");
                adminoperating(u);
        }
    }

    /**
     * 显示用户信息
     *
     * @param lis
     */
    public void adminupd(List<Userinfo> lis) {
        for (Userinfo u : lis) {
            System.out.println(u.getId() + ".\t" + "姓名：" + userNameFactory
                    (u.getUsername()) +
                    "\t手机号：" + u.getPhone() + "\t地址：" + u.getAddress()
                    + "\t性别：" + u.getSex() + "\t年龄：" + u.getAge() +
                    "\t收入：" + u.getWage());
        }
        System.out.println("--------------------------------" + "\n总页数" +
                p.getTotalPages() + "\t" + "当前页数" + p.getCurrentPageNumber()
                + "\n" + "1.上一页 \t 2.下一页\t" + "3.修改");
        int num = in.nextInt();
        if (num > 0 && num < 4) {
            page(num);
        } else {
            System.out.println("输入错误，请重新选择：");
            adminupd(lis);
        }
    }

    /**
     * 分页 上一页，下一页
     *
     * @param index
     */
    public void page(int index) {
        List<Userinfo> li = null;
        switch (index) {
            case 1:
                if (p.getCurrentPageNumber() == 1) {
                    li = usi.sele(u, p.getTotalPages(), p);
                } else {
                    p.setCurrentPageNumber(p.getCurrentPageNumber() - 1);
                    li = usi.sele(u, p.getCurrentPageNumber(), p);
                }
                adminupd(li);
                break;
            case 2:
                if (p.getCurrentPageNumber() == p.getTotalPages()) {
                    p.setCurrentPageNumber(1);
                    li = usi.sele(u, p.getCurrentPageNumber(), p);
                } else {
                    p.setCurrentPageNumber(p.getCurrentPageNumber() + 1);
                    li = usi.sele(u, p.getCurrentPageNumber(), p);
                }
                adminupd(li);
                break;
            case 3:
                System.out.println("请输入要修改的用户的id编号");
                Userinfo us = new Userinfo();
                us.setId(in.nextInt());
                u = usi.sellogin(us);
                adminupdate(u);
        }
    }

    /**
     * 管理员修改用户
     *
     * @param u
     */
    public void adminupdate(Userinfo u) {
        System.out.println("请选择要修改的信息：" + "\n姓名：" + u.getUsername()
                + "\t" + "密码：" + u.getPassword() + "\t手机号：" +
                u.getPhone() + "\t1.地址：" + u.getAddress() + "\t2.性别："
                + u.getSex() + "\t3.年龄：" + u.getAge() + "\t4.收入：" +
                u.getWage() + "管理员不能修改用户的姓名、密码和手机号,输入其他" +
                "返回上一级");
        update(in.nextInt(), u);
    }

    /**
     * 修改
     */
    public void update(int count, Userinfo u) {
        switch (count) {
            case 1:
                System.out.println("请输入地址");
                if (!addressupd(in.next(), u)) {
                    System.out.println("输入错误！");
                    update(1, u);
                }
                break;
            case 2:
                System.out.println("请输入新性别");
                if (!sexupd(in.next(), u)) {
                    System.out.println("输入错误！");
                    update(2, u);
                }
                break;
            case 3:
                System.out.println("请输入新年龄");
                if (!ageupd(in.nextInt(), u)) {
                    System.out.println("输入错误！");
                    update(3, u);
                }
                break;
            case 4:
                System.out.println("请输入新工资(可以精确到2位小数)");
                if (!wageupd(in.nextDouble(), u)) {
                    System.out.println("输入错误！");
                    update(4, u);
                }
                break;
            default:
                page(1);
        }
        System.out.println("是否继续？（是1/否(其他)");
        if (in.nextInt() == 1) {
            System.out.println("请选择要修改的信息:");
            update(in.nextInt(), u);
        } else {
            System.out.println(usi.updat(u));
        }
    }

    /**
     * 自己修改自己
     */
    public void upda(int count, Userinfo u) {
        switch (count) {
            case 1:
                System.out.println("请输入新用户名（3~6位)");
                if (!nameupd(in.next(), u)) {
                    System.out.println("输入错误！");
                    upda(1, u);
                }
                break;
            case 2:
                System.out.println("请输入密码(6~12位)");
                if (!pwdupd(in.next(), u)) {
                    System.out.println("输入错误！");
                    upda(2, u);
                }
                break;
            case 3:
                System.out.println("请输入新手机号");
                if (phoneupd(in.next(), u)) {
                    System.out.println("输入错误！");
                    upda(3, u);
                }
                break;
            case 4:
                System.out.println("请输入地址");
                if (!addressupd(in.next(), u)) {
                    System.out.println("输入错误！");
                    upda(4, u);
                }
                break;
            case 5:
                System.out.println("请输入新性别");
                if (!sexupd(in.next(), u)) {
                    System.out.println("输入错误！");
                    upda(5, u);
                }
                break;
            case 6:
                System.out.println("请输入新年龄");
                if (!ageupd(in.nextInt(), u)) {
                    System.out.println("输入错误！");
                    upda(6, u);
                }
                break;
            case 7:
                System.out.println("请输入新工资(可以精确到2位小数)");
                if (!wageupd(in.nextDouble(), u)) {
                    System.out.println("输入错误！");
                    upda(7, u);
                }
                break;
            default:
                System.out.println("输入错误，请重新输入：");
                int num = in.nextInt();
                upda(num, u);
        }
        System.out.println("是否继续？（是1/否(其他)");
        if (in.nextInt() == 1) {
            System.out.println("请选择要修改的信息:");
            upda(in.nextInt(), u);
        } else {
            System.out.println(usi.updat(u));
        }
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
        if (flag && !phone.equals(u.getPhone())) {
            u.setPhone(phone);
            flag = false;
        }
        return flag;
    }

    /**
     * 修改用户名
     *
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
        if (pwd.length() < 13 && pwd.length() > 5 && !pwd.equals(u.getPassword())) {
            u.setPassword(pwd);
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
     * 修改年龄
     *
     * @param age
     * @param u
     * @return
     */
    public boolean ageupd(int age, Userinfo u) {
        if (age > -1 && age < 151){
            u.setAge(age);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 修改工资
     *
     * @param wage
     * @param u
     * @return
     */
    public boolean wageupd(double wage, Userinfo u) {
        double money = new BigDecimal(wage).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        boolean f = false;
        if (money != u.getWage()){
            u.setWage(money);
            f=true;
        }
       return f;
    }

    /**
     * 修改地址
     *
     * @param add
     * @param u
     * @return
     */
    public boolean addressupd(String add, Userinfo u) {
        if (!add.equals(null)){
            u.setAddress(add);
            return true;
        }
        else{
            return false;
        }
    }
}
