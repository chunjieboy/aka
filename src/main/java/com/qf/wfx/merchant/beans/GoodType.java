package com.qf.wfx.merchant.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodType {
    private String typeId;
    private String typeName;
    private String parentId;
    private String typeTag;
    private int orderNo;
    private String alisaCode;
}
