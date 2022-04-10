package com.gec.bean;

//根据数据来定义
public class User {
    private int id;
    private String username;
    private String realname;
    private String password;
    private String idcard;
    private String phone;
    private String email;
    private String paypwd;
    private int status;
    private String reputation;

    public User() {
    }

    public User(int id, String username, String realname, String password, String idcard, String phone, String email, String paypwd, int status, String reputation) {
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.idcard = idcard;
        this.phone = phone;
        this.email = email;
        this.paypwd = paypwd;
        this.status = status;
        this.reputation = reputation;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", paypwd='" + paypwd + '\'' +
                ", status=" + status +
                ", reputation='" + reputation + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaypwd() {
        return paypwd;
    }

    public void setPaypwd(String paypwd) {
        this.paypwd = paypwd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }
}
