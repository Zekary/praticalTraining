package com.gec.bean;

import java.math.BigDecimal;

public class Bankcard {
    private Integer id;

    private Integer cardbank;

    private Integer type;

    private String cardnum;

    private Integer userid;

    private BigDecimal balance;

    private Integer defaultl;

    //一对一的关联引用
    private Bank bank;
    private User user;
    //提供对应的get，set方法
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardbank() {
        return cardbank;
    }

    public void setCardbank(Integer cardbank) {
        this.cardbank = cardbank;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum == null ? null : cardnum.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getDefaultl() {
        return defaultl;
    }

    public void setDefaultl(Integer defaultl) {
        this.defaultl = defaultl;
    }

}