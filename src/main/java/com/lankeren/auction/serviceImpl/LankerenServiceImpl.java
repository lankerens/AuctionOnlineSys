package com.lankeren.auction.serviceImpl;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        return theSame(lankerenMapper.getGoodAuctionList() , "list");
    }

    @Override
    public Object getAuctionRecordList(Integer curr, Integer pageSize) {
        PageHelper.startPage(curr, pageSize);
        return theSame(lankerenMapper.getAuctionRecordList() , "list");
    }

    @Override
    public Object getOrderList(Integer curr, Integer pageSize) {
        PageHelper.startPage(curr, pageSize);
        return theSame( lankerenMapper.getOrderList() , "list");
    }

    @Override
    public Object getSalerApply(Integer curr, Integer pageSize) {
        PageHelper.startPage(curr, pageSize);
        return theSame(lankerenMapper.getSalerApply() , "list");
    }


    private Object theSame(List<Map<String, Object>> list, String name){
        JSONObject res0 = new JSONObject();
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
