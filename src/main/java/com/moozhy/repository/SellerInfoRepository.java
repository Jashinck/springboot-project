package com.moozhy.repository;

import com.moozhy.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Amboo Chou on 2018/3/31.
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {

    SellerInfo findByOpenid(String openid);
}
