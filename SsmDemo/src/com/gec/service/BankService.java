package com.gec.service;

import com.gec.bean.Bank;

import java.util.List;

//业务层及抽象接口及方法定义
public interface BankService {

    //银行插入功能
    public boolean insert(Bank bank);

    //银行列表查询
    public List<Bank> query();

    //根据id进行银行查询
    public Bank queryId(int id);

    //银行根据id进行修改功能
    public boolean updateBank(Bank bank);

    //银行根据id删除银行数据
    public boolean delete(int id);
}
