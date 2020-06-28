package com.lankeren.auction.serviceImpl;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lankeren.auction.enums.Constant;
import com.lankeren.auction.mapper.LankerenMapper;
import com.lankeren.auction.service.LankerenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author lankeren
 * @ClassName LankerenServiceImpl
 * @Deacription:
 * @create: 2020-06-25 01:42
 */
@Service
public class LankerenServiceImpl implements LankerenService {

    @Autowired
    private  LankerenMapper lankerenMapper;

    @Override
    public Object getUserList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        return theSame(lankerenMapper.getUserList() , "data");
    }

    @Override
    public Object getGoodAuctionList(Integer curr, Integer pageSize) {
        PageHelper.startPage(curr, pageSize);
        return theSame(lankerenMapper.getGoodAuctionList() , "data");
    }

    @Override
    public Object getAuctionRecordList(Integer curr, Integer pageSize) {
        PageHelper.startPage(curr, pageSize);
        return theSame(lankerenMapper.getAuctionRecordList() , "data");
    }

    @Override
    public Object getOrderList(Integer curr, Integer pageSize) {
        PageHelper.startPage(curr, pageSize);
        return theSame( lankerenMapper.getOrderList() , "data");
    }

    @Override
    public Object getSalerApply(Integer curr, Integer pageSize) {
        PageHelper.startPage(curr, pageSize);
        return theSame(lankerenMapper.getSalerApply() , "data");
    }

    @Override
    public Object forbiddenAccount(Integer aid, Integer status) {
        JSONObject res = new JSONObject();
        res.put("msg", "f");
        if(aid != null && status != null) {
            status = status == 1 ? 0 : 1;
            lankerenMapper.forbiddenAccount(aid, status);
            res.put("msg", "ok");
            res.put("Leaststatus", status);
        }
        return res;
    }

    @Override
    public Object pswReset(Integer aid) {
        JSONObject res = new JSONObject();
        res.put("msg", "f");
        if(aid == null){ return  res; }
        Integer f = lankerenMapper.pswReset(Constant.DefualtPsw, aid);
        res.put("msg", "ok");
        return res;
    }

    @Override
    public Object delAccount(Integer aid) {
        JSONObject res = new JSONObject();
        res.put("msg", "f");
        Integer f = lankerenMapper.delAccount(aid);
        res.put("msg", "ok");
        return res;
    }

    @Override
    public Object salerApply(Integer sid, Integer status) {
        JSONObject res = new JSONObject();
        res.put("msg", "f");
        if(status == null || status == null) {return  res;}
        Integer f = lankerenMapper.updateSalerInfo(status, sid);
        if(f != 0){
            res.put("msg", "ok");
        }
        return res;
    }


    private Object theSame(List<Map<String, Object>> list, String name){
        JSONObject res1 = new JSONObject();
        try {
            PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
            res1.put("msg", "ok");
            res1.put("code", "0");
            res1.put(name, list);
            res1.put("count", pageInfo.getTotal());
        }catch (Exception e){
            res1.put("msg", "f");
            res1.put("count", 0);
            return  res1;
        }
        return res1;
    }

}
