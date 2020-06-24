package com.lankeren.auction.mapper;

import com.lankeren.auction.bean.GoodAuction;
import com.lankeren.auction.bean.GoodCard;
import com.lankeren.auction.bean.GoodEnsure;
import com.lankeren.auction.bean.SalerInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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


    @Select("SELECT g.id, g.good_name, g.pic, g.saler_name, g.now_price,(SELECT count(*) ttt from auction_record WHERE gid = g.id) aucNum from goods_auction g " +
            "WHERE end_time > #{nowTime}  and `status` = 1 " +
            "ORDER BY end_time ASC")
    List<GoodCard> getAuctionList(String nowTime);

    @Select("SELECT (SELECT count(*) from goods_auction WHERE `status` = 1 and end_time > #{nowTime} " +
            "and start_time < #{nowTime}) allowAuc, " +
            "(SELECT count(*) from goods_auction WHERE `status` = 1 and start_time > #{nowTime}) unOpen")
    Map<String, Integer> getAucNums(String nowTime);



    @Select("SELECT a.id, a.good_name, a.start_price, a.start_time, a.pic, a.price_plus, a.end_time, a.account_id, a.goods_dec, a.`status` , a.now_price, a.saler_name, b.goodType, e.pack_mail, e.oimei, e.ensure FROM goods_auction a " +
            " LEFT JOIN goodtype b ON b.id = a.good_type " +
            " LEFT JOIN goods_ensure e ON e.gid = a.id " +
            "WHERE " +
            " a.id = #{id}")
    Map<String, Object> getGoodInfoById(Integer id);




}
