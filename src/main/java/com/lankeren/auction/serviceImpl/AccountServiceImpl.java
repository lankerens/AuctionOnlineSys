package com.lankeren.auction.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.lankeren.auction.bean.Account;
import com.lankeren.auction.mapper.AccountMapper;
import com.lankeren.auction.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author lankeren
 * @ClassName AccountServiceImpl
 * @Deacription:
 * @create: 2020-06-19 18:44
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Object login(Account account) {
        JSONObject res = new JSONObject();
        String password = account.getPassword();
        Account byaccount = accountMapper.getAccountByaccount(account.getAccount());
        if(!StringUtils.isEmpty(password) && account.getPassword().equals(password)){
            res.put("msg", "ok");
            byaccount.setPassword("null");
            res.put("account", byaccount);
            return res;
        }
        res.put("msg", "f");
        return res;
    }
}
