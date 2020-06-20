package com.lankeren.auction.mapper;

import com.lankeren.auction.bean.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {

    @Select("select * from account where account = #{account}")
    Account getAccountByaccount(String account);

    @Insert("INSERT INTO `account`(`account`, `password`) VALUES (#{account}, #{password})")
    int registerAccount(Account account);



}
