package com.qf.wfx.merchant.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultVO {

    private int code;
    private String msg;
    private Object data;

    public ResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
