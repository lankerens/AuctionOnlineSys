package com.lankeren.auction.service;

public interface LankerenService {


    public Object getUserList( Integer curr, Integer pageSize);

    public Object getGoodAuctionList( Integer curr, Integer pageSize);

    public Object getAuctionRecordList( Integer curr, Integer pageSize);

    public Object getOrderList( Integer curr, Integer pageSize);

    public Object getSalerApply( Integer curr, Integer pageSize);


}
