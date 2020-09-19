package com.qf.wfx.merchant.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LayuiVO {
    private int code;
    private String msg;
    private int count;
    private List data;
}
