package com.lankeren.auction.mapper;

import com.lankeren.auction.bean.Account;
import com.lankeren.auction.bean.AccountInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AccountMapper {

    @Select("select * from account where account = #{account} and status = 1")
    Account getAccountByaccount(String account);

    @Insert("INSERT INTO `account`(`account`, `password`, `reg_time`) VALUES (#{account}, #{password}, #{regTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int registerAccount(Account account);

    @Insert("INSERT INTO `auctiononlinesys`.`account_info`(`aid`) VALUES (#{aid})")
    int registerAccountInfo(Integer aid);

    @Select("select id from account where account = #{account}")
    Integer getAccountIdByAccount(String account);

    @Select("select id from account where account = #{account} and identity = #{identity}")
    Integer getAccountIdByAccountWIden(String account, Integer identity);

    @Select("SELECT * from account_info where aid = #{aid}")
    AccountInfo getAccountInfoByaid(Integer aid);

    @Select("SELECT a.`name`, a.account, a.identity, b.* from account a " +
            "LEFT JOIN account_info b on a.id = b.aid " +
            " where a.account = #{account} and a.identity = #{identity}")
    AccountInfo getAccountInfoByAccount(Account account);


    @Insert("UPDATE `account_info` SET `sex` = #{sex}, `location` = #{location}, `phone` = #{phone}, " +
            "`email` = #{email}, `personal_sign` = #{personalSign}, `love` = #{love} WHERE `aid` = #{aid}")
    int updateAccountInfo(AccountInfo accountInfo);

    @Update("UPDATE `account` SET `name` = #{name} WHERE `id` = #{aid}")
    int updateAccountName(AccountInfo accountInfo);

    @Update("UPDATE `auctiononlinesys`.`account` SET `password` = #{psw} WHERE `id` = #{id} and password = #{old}")
    int updateAccountPsw(String old, String psw, Integer id);


    @Select("select identity from account where account = #{account}")
    Integer getIdentityByAccount(String account);

}
