package com.lankeren.auction.controller;

import com.alibaba.fastjson.JSONObject;
import com.lankeren.auction.bean.GoodAuction;
import com.lankeren.auction.bean.SalerInfo;
import com.lankeren.auction.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.spi.http.HttpContext;
import java.util.List;
import java.util.Map;

/**
 * @author lankeren
 * @ClassName GoodsController
 * @Deacription:
 * @create: 2020-06-22 00:01
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @RequestMapping(value = "/savePic/{id}", method = RequestMethod.POST)
    public  Object savePic(MultipartFile file, @PathVariable Integer id){
        JSONObject r = new JSONObject();
       try {
           Object res =  goodsService.savePic(file, id);
           r.put("data", res);
           r.put("code", 0);
           r.put("msg", "ok");
       }catch (Exception e){
           r.put("msg", "f");
           return r;
       }
        return r;
    }


    @RequestMapping(value = "/saveGood", method = RequestMethod.POST)
    public  Object saveGoodInfo(@RequestBody GoodAuction goodAuction){
        Object res =  goodsService.saveGoodInfo(goodAuction);
        return res;
    }


    @RequestMapping(value = "/salerApply", method = RequestMethod.POST)
    public  Object salerApply(@RequestBody SalerInfo salerInfo){
        Object res =  goodsService.salerApply(salerInfo);
        return res;
    }


}
