package com.qf.wfx.merchant.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodSku {
    private String skuId;
    private String skuName;
    private String skuCost;
    private String skuPrice;
    private String skuPmoney;//分成
    private String goodId;
    private int orderNo;
    private String serviceMoney;//客服提成
}
