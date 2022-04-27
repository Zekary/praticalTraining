package com.gec.service.impl;

import com.gec.bean.Bankcard;
import com.gec.bean.BankcardExample;
import com.gec.mapper.BankcardMapper;
import com.gec.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankCardServiceImpl implements BankCardService {

    //IOC中获取BankcardMapper的对象
    @Autowired
    BankcardMapper bankcardMapper;

    @Override
    public boolean insert(Bankcard bankcard) {
        return bankcardMapper.insertSelective(bankcard) >0 ? true:false;
    }

    @Override
    public List<Bankcard> query() {
        return bankcardMapper.selectByExample(new BankcardExample());
    }

    @Override
    public Bankcard queryId(int id) {
        return bankcardMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateBankcard(Bankcard bankcard) {
        return bankcardMapper.updateByPrimaryKeySelective(bankcard)>0 ? true:false;
    }

    @Override
    public boolean delete(int id) {
        return bankcardMapper.deleteByPrimaryKey(id)>0 ? true:false;
    }
}
