package com.qf.wfx.merchant.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private String customerId;
    private String customerName;
    private String cusQQ;
    private String cusWxh;
    private String cusPhone;
    private Date createTime;
    private String loginName;
    private String loginPwd;
    private int state;
    private int level;
    private Double accBalance;
    private Date updateTime;
    private String webSite;
}
