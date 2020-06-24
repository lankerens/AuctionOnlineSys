package com.lankeren.auction.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lankeren.auction.bean.*;
import com.lankeren.auction.enums.Constant;
import com.lankeren.auction.mapper.AccountMapper;
import com.lankeren.auction.mapper.GoodsMapper;
import com.lankeren.auction.service.GoodsService;
import com.lankeren.auction.utils.MFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lankeren
 * @ClassName GoodsServiceImpl
 * @Deacription:
 * @create: 2020-06-22 09:05
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private AccountMapper accountMapper;

    private static volatile Map<Integer, Object> picPathWrapper = new ConcurrentHashMap<>();


    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object saveGoodInfo(GoodAuction goodAuction) {
        JSONObject res = new JSONObject();
        res.put("msg", "f");
        Integer id = goodAuction.getAccountId();
        if(goodsMapper.getIdentity(id) < Constant.SalerUser){
            return res;
        }
        goodAuction.setPic((String)picPathWrapper.get(id));
        picPathWrapper.remove(id);
        goodAuction.setStartTime(LocalDateTime.now());
        goodAuction.setNowPrice(goodAuction.getStartPrice());
        int f = goodsMapper.saveGoodInfo(goodAuction);
        GoodEnsure goodEnsure = new GoodEnsure(goodAuction);
        goodsMapper.saveGoodEnsure(goodEnsure);
        if(f == 0){
            return res;
        }
        res.put("msg", "ok");
        return res;
    }

    @Override
    public Object savePic(MultipartFile file, Integer id) {
        JSONObject res = new JSONObject();
        String picPath = null;
        try {
            picPath = "/picFiles/" + MFileUtil.sacePicFile(file);
            res.put("src",  picPath);
        }catch (Exception e){
            e.printStackTrace();
        }
        picPathWrapper.put(id, picPath);
        return res;
    }

    @Override
    public Object salerApply(SalerInfo salerInfo) {
        // 参数懒得检验了....
        JSONObject res = new JSONObject();
        res.put("msg", "f");
        if("null".equals(salerInfo.getAccount())  || "null".equals(salerInfo.getBusineName()) ){return  res;}
        int exists = goodsMapper.theUserIsExists(salerInfo.getAccount());
        if(exists == 1){
            res.put("msg", "exists");
            return res;
        }
        salerInfo.setApplyTime(LocalDateTime.now());
        int f = goodsMapper.saveSalerInfo(salerInfo);
        if(f == 1){
            res.put("msg", "ok");
        }
        return res;
    }

    @Override
    public Object getAuctionList(Integer currentPage, Integer pageSize) {
        JSONObject res0 = new JSONObject();
        JSONObject res1 = new JSONObject();
        try {
            PageHelper.startPage(currentPage, pageSize);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String nowTime = formatter.format(LocalDateTime.now());
            List<GoodCard> list = goodsMapper.getAuctionList(nowTime);
            PageInfo<GoodCard> pageInfo = new PageInfo<>(list);
            res0.put("msg", "ok");
            res1.put("totalSize", pageInfo.getPages());
            res1.put("AuctionNums", goodsMapper.getAucNums(nowTime));
            res1.put("AuctionList", list);
            res0.put("data", res1);
        }catch (Exception e){
            res0.put("msg", "f");
            System.out.println(e);
        }
        return res0;
    }

    @Override
    public Object getGoodInfoById(Integer id) {
        JSONObject res = new JSONObject();
        Map<String, Object> goodInfo = goodsMapper.getGoodInfoById(id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        goodInfo.put("start_time", formatter.format(((Timestamp) goodInfo.get("start_time")).toLocalDateTime()));
        goodInfo.put("end_time", formatter.format(((Timestamp) goodInfo.get("end_time")).toLocalDateTime()));

        res.put("GoodInfo", goodInfo);
        res.put("msg", "ok");

        return res;
    }

    @Override
    public Object addShopCart(Integer aid, Integer gid) {
        JSONObject res = new JSONObject();

        return res;
    }

    @Override
    public Object auction(AuctionRecord auctionRecord) {
        JSONObject res = new JSONObject();

        return res;
    }
}
