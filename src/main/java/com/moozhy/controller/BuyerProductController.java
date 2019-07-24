package com.moozhy.controller;

import com.moozhy.vo.ProductInfoVO;
import com.moozhy.vo.ProductVO;
import com.moozhy.vo.ResultVO;
import com.moozhy.dataobject.ProductCategory;
import com.moozhy.dataobject.ProductInfo;
import com.moozhy.service.CategoryService;
import com.moozhy.service.ProductService;
import com.moozhy.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Amboo Chou on 2018/3/17.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product",key = "123",unless = "#result.getCode()!=0")
    public ResultVO list(){

        //1.查询所有的上架的商品
        List<ProductInfo> productInfoList=productService.findUpAll();

        //2.查询在架商品所属类目（一次性查询）
        //精简方法lamba表达式
        List<Integer> categoryTypeList=productInfoList.stream()
                .map(e->e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼装
        List<ProductVO> productVOList=new ArrayList<>();
        for(ProductCategory productCategory: productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for(ProductInfo productInfo: productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        ResultVO resultVO=ResultVOUtil.success(productVOList);
        return resultVO;
    }

}
