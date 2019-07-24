package com.moozhy.repository;

import com.moozhy.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Amboo Chou on 2018/3/17.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
