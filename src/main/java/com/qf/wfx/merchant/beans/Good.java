package com.qf.wfx.merchant.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Good {
    private String goodId;
    private String goodName;
    private String customerId;
    private String goodPic1;
    private String goodPic2;
    private String goodPic3;
    private String promoteDesc;//推广说明
    private String copyIds;//文案ID
    private String copyDesc;//文案说明
    private String forwardLink;//跳转链接
    private int orderNo;//排序编号
    private String typeId;
    private String tags;//标签信息
    private int state;
    private String createTime;//加入时间
    private int toped;//是否置顶
    private int recomed;//是否推荐
    private String topedTime;//置顶时间
    private String recomedTime;//推荐时间
    private String spcId;//站内文案ID
    private String zonId;//空间文案ID
    private String sellNum;//作弊值
    private String webSite;//产品网址
    private String kfqq;//客服QQ
    private String skuPrice;//套餐价格
    private GoodType goodType;
    private Customer customer;
    private GoodSku goodSku;

    public Good(String goodId, String goodName, String goodPic1, String promoteDesc) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.goodPic1 = goodPic1;
        this.promoteDesc = promoteDesc;
    }

    public Good(String goodId,String goodName, String customerId, String goodPic1, String goodPic2, String goodPic3, String promoteDesc, String typeId) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.customerId = customerId;
        this.goodPic1 = goodPic1;
        this.goodPic2 = goodPic2;
        this.goodPic3 = goodPic3;
        this.promoteDesc = promoteDesc;
        this.typeId = typeId;
    }
}
