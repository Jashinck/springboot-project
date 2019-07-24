package com.moozhy.service;

import com.moozhy.dataobject.SellerInfo;

/**
 * 卖家端
 * @author Amboo Chou on 2018/4/1.
 */
public interface SellerService {

    /**
     * 通过openid查询
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
