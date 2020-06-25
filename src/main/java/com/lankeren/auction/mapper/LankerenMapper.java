package com.lankeren.auction.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface LankerenMapper {

    @Select("SELECT id, name, account, identity, email, phone, reg_time, `status` from account " +
            "LEFT JOIN account_info on id = aid")
    List<Map<String, Object>> getUserList();

    @Select("SELECT id, good_name, good_type, saler_name, start_price, price_plus, now_price, end_time, `status` from goods_auction ")
    List<Map<String, Object>> getGoodAuctionList();

    @Select("SELECT id, good_name, start_price, now_price, my_plus, account_name, saler_id, `status`, start_time, end_time, create_time from auction_record ")
    List<Map<String, Object>> getAuctionRecordList();

//    @Select("SELECT order_id, account, good_name, start_price, end_price, account_name, address, create_time, `status` from `order`")
    @Select("SELECT order_id, o.account, good_name, start_price, end_price, account_name, address, create_time, `status`, saler_id, (SELECT busine_address from saler_info WHERE id = saler_id) salerAddress from `order` o")
    List<Map<String, Object>> getOrderList();

    @Select("SELECT id, busine_name, saler_name, busine_contact, saler_email, apply_reason, account, `status` from saler_info ")
    List<Map<String, Object>> getSalerApply();




}
