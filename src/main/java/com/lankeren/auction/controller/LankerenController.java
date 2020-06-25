package com.lankeren.auction.controller;

import com.lankeren.auction.service.LankerenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lankeren
 * @ClassName LankerenController
 * @Deacription:
 * @create: 2020-06-25 01:42
 */
@RestController
public class LankerenController {

    @Autowired
    private LankerenService lankerenService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public  Object getUserList( Integer page,  Integer limit){
        Object res =  lankerenService.getUserList(page, limit);
        return res;
    }

    @RequestMapping(value = "/getGoodAuctionList", method = RequestMethod.GET)
    public  Object getGoodAuctionList(@RequestParam("page") Integer curr, @RequestParam("limit") Integer pageSize){
        Object res =  lankerenService.getGoodAuctionList(curr, pageSize);
        return res;
    }

    @RequestMapping(value = "/getAuctionRecordList", method = RequestMethod.GET)
    public  Object getAuctionRecordList(@RequestParam("page") Integer curr, @RequestParam("limit") Integer pageSize){
        Object res =  lankerenService.getAuctionRecordList(curr, pageSize);
        return res;
    }

    @RequestMapping(value = "/getOrderList", method = RequestMethod.GET)
    public  Object getOrderList(@RequestParam("page") Integer curr, @RequestParam("limit") Integer pageSize){
        Object res =  lankerenService.getOrderList(curr, pageSize);
        return res;
    }

    @RequestMapping(value = "/getSalerApply", method = RequestMethod.GET)
    public  Object getSalerApply(@RequestParam("page") Integer curr, @RequestParam("limit") Integer pageSize){
        Object res =  lankerenService.getSalerApply(curr, pageSize);
        return res;
    }



}
