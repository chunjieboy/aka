package com.qf.wfx.merchant.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Copy {
    private int copyId;
    private String copyTitle;
    private String copyLink;
    private String copyContent;
    private int orderNo;
    private int typeId;
    private String goodsId;
}
