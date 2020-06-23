package com.lankeren.auction.mapper;

import com.lankeren.auction.bean.GoodAuction;
import com.lankeren.auction.bean.GoodEnsure;
import com.lankeren.auction.bean.SalerInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GoodsMapper {

    @Insert("INSERT INTO `goods_auction`(`good_name`, `good_type`, `start_price`, `price_plus`, `start_time`, `end_time`, `account_id`, " +
            "`goods_dec`, `pic`, `status`, `saler_name`, `now_price`) " +
            "VALUES (#{goodName}, #{goodType}, #{startPrice}, #{pricePlus}, #{startTime}, #{endTime}, #{accountId}, " +
            "#{goodsDec}, #{pic}, #{status}, #{salerName}, #{nowPrice})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveGoodInfo(GoodAuction goodAuction);


    @Insert("INSERT INTO `goods_ensure`(`gid`, `pack_mail`, `oimei`, `ensure`) VALUES (#{gid}, #{packMail}, #{oimei}, #{ensure})")
    int saveGoodEnsure(GoodEnsure goodEnsure);


    @Select("SELECT identity from account where id = #{id}")
    Integer getIdentity(Integer id);

    @Insert("INSERT INTO `saler_info`(`busine_name`, `saler_name`, `busine_address`, `busine_contact`, `saler_email`, `apply_reason`, " +
            "`account`, `apply_time`) VALUES " +
            "(#{busineName}, #{salerName}, #{busineAddress}, #{busineContact}, #{salerEmail}, #{applyReason}, #{account}, #{applyTime})")
    int saveSalerInfo(SalerInfo salerInfo);


    @Select("select count(*) from account where account = #{account}")
    int theUserIsExists(String account);



}
