package com.lankeren.auction.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.lankeren.auction.bean.GoodAuction;
import com.lankeren.auction.bean.GoodEnsure;
import com.lankeren.auction.bean.SalerInfo;
import com.lankeren.auction.enums.Constant;
import com.lankeren.auction.mapper.AccountMapper;
import com.lankeren.auction.mapper.GoodsMapper;
import com.lankeren.auction.service.GoodsService;
import com.lankeren.auction.utils.MFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
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
}
