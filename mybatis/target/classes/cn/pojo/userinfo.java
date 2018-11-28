package cn.pojo;

import java.util.List;

public class userinfo {

    private String username;
    private String password;
    private String phone;
   /* private String address;
    private String hobby;
    private Integer sex;*/
    private List<ulogin> ul;

    public List<ulogin> getUl() {
        return ul;
    }

    public void setUl(List<ulogin> ul) {
        this.ul = ul;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
/*

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
*/
}
