package com.lankeren.auction.service;

import com.lankeren.auction.bean.GoodAuction;
import com.lankeren.auction.bean.SalerInfo;
import org.springframework.web.multipart.MultipartFile;

public interface GoodsService {

    public  Object saveGoodInfo(GoodAuction goodAuction);

    public Object savePic(MultipartFile file, Integer id);

    public Object salerApply(SalerInfo salerInfo);

}
