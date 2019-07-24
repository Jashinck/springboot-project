package com.moozhy.service;

import com.moozhy.dataobject.ProductCategory;

import java.util.List;

/**
 * @author Amboo Chou on 2018/3/17.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
