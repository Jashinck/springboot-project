package com.moozhy.dto;

import lombok.Data;

/**
 * @author Amboo Chou on 2018/3/19.
 */
@Data
public class CartDTO {

    /**商品*/
    private String productId;

    /** 数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
