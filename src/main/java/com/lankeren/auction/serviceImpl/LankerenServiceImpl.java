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
    public Object getUserList(Integer curr, Integer pageSize) {
        return theSame(curr, pageSize, lankerenMapper.getUserList() , "adUserList");
    }

    @Override
    public Object getGoodAuctionList(Integer curr, Integer pageSize) {
        return theSame(curr, pageSize, lankerenMapper.getGoodAuctionList() , "adGoodAuctionList");
    }

    @Override
    public Object getAuctionRecordList(Integer curr, Integer pageSize) {
        return theSame(curr, pageSize, lankerenMapper.getAuctionRecordList() , "adAuctionRecordList");
    }

    @Override
    public Object getOrderList(Integer curr, Integer pageSize) {
        return theSame(curr, pageSize, lankerenMapper.getOrderList() , "adOrderList");
    }

    @Override
    public Object getSalerApply(Integer curr, Integer pageSize) {
        return theSame(curr, pageSize, lankerenMapper.getSalerApply() , "adSalerApplyList");
    }


    private Object theSame(Integer curr, Integer pageSize, List<Map<String, Object>> list, String name){
        JSONObject res = new JSONObject();
        try {
            PageHelper.startPage(curr, pageSize);
            PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
            res.put("msg", "ok");
            res.put(name, list);
            res.put("totalSize", pageInfo.getPages());
        }catch (Exception e){
            res.put("msg", "f");
            return  res;
        }
        return res;
    }

}
