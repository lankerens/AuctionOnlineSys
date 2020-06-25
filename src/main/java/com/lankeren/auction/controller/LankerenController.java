package com.lankeren.auction.controller;

import com.lankeren.auction.service.LankerenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/getMyAuction/{curr}/{pageSize}", method = RequestMethod.GET)
    public  Object getUserList( @PathVariable Integer curr, @PathVariable Integer pageSize){
        Object res =  lankerenService.getUserList(curr, pageSize);
        return res;
    }

    @RequestMapping(value = "/getGoodAuctionList/{curr}/{pageSize}", method = RequestMethod.GET)
    public  Object getGoodAuctionList( @PathVariable Integer curr, @PathVariable Integer pageSize){
        Object res =  lankerenService.getGoodAuctionList(curr, pageSize);
        return res;
    }

    @RequestMapping(value = "/getAuctionRecordList/{curr}/{pageSize}", method = RequestMethod.GET)
    public  Object getAuctionRecordList( @PathVariable Integer curr, @PathVariable Integer pageSize){
        Object res =  lankerenService.getAuctionRecordList(curr, pageSize);
        return res;
    }

    @RequestMapping(value = "/getOrderList/{curr}/{pageSize}", method = RequestMethod.GET)
    public  Object getOrderList( @PathVariable Integer curr, @PathVariable Integer pageSize){
        Object res =  lankerenService.getOrderList(curr, pageSize);
        return res;
    }

    @RequestMapping(value = "/getSalerApply/{curr}/{pageSize}", method = RequestMethod.GET)
    public  Object getSalerApply( @PathVariable Integer curr, @PathVariable Integer pageSize){
        Object res =  lankerenService.getSalerApply(curr, pageSize);
        return res;
    }



}
