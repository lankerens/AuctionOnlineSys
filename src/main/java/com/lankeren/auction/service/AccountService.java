package com.lankeren.auction.service;

import com.lankeren.auction.bean.Account;
import com.lankeren.auction.bean.AccountInfo;

/**
 * @author lankeren
 * @ClassName AccountService
 * @Deacription:
 * @create: 2020-06-19 18:43
 */
public interface AccountService {

    public Object login(Account account);

    public Object register(Account account);

    public Object getAccountInfo(Account account);


    public Object updateAccountInfo(AccountInfo accountInfo);


}
