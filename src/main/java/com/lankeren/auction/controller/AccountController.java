package com.lankeren.auction.controller;

import com.alibaba.fastjson.JSONObject;
import com.lankeren.auction.bean.Account;
import com.lankeren.auction.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lankeren
 * @ClassName AccountController
 * @Deacription:
 * @create: 2020-06-19 18:42
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody Account account){
        Object res = accountService.login(account);
        return res;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(@RequestBody Account account){
        Object res = accountService.register(account);
        return res;
    }


    @RequestMapping(value = "getAccountInfo", method = RequestMethod.POST)
    public Object getAccountInfo(Account account){
        Object res =  accountService.register(account);
        return res;
    }




}
