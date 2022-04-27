package com.gec.service;

import com.gec.bean.Bankcard;

import java.util.List;

//业务层及抽象接口及方法定义
public interface BankCardService {

    //银行卡插入功能
    public boolean insert(Bankcard bankcard);

    //银行卡列表查询
    public List<Bankcard> query();

    //根据id进行银行卡查询
    public Bankcard queryId(int id);

    //银行卡根据id进行修改功能
    public boolean updateBankcard(Bankcard bankcard);

    //银行卡根据id删除银行卡数据
    public boolean delete(int id);
}
