package com.moozhy.service.impl;

import com.moozhy.dataobject.SellerInfo;
import com.moozhy.repository.SellerInfoRepository;
import com.moozhy.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Amboo Chou on 2018/4/1.
 */
@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
