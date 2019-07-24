package com.moozhy.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.moozhy.dataobject.OrderDetail;
import com.moozhy.enums.OrderStatusEnum;
import com.moozhy.enums.PayStatusEnum;
import com.moozhy.utils.EnumUtil;
import com.moozhy.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Amboo Chou on 2018/3/18.
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /**订单**/
    private String orderId;

    /**买家名字 **/
    private String buyerName;

    /**卖家手机号**/
    private String buyerPhone;

    /**卖家地址**/
    private String buyerAddress;

    /**买家微信Openid*/
    private String buyerOpenid;

    /**订单金额*/
    private BigDecimal orderAmount;

    /**订单状态，默认为新下单*/
    private Integer orderStatus;

    /**支付状态，默认为0未支付*/
    private Integer payStatus;

    /**创建时间*/
    @JsonSerialize(using=Date2LongSerializer.class)
    private Date createTime;

    /**更新时间*/
    @JsonSerialize(using=Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;//=new ArrayList<>();

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }


}
