package com.qf.wfx.merchant.dao;

import com.qf.wfx.merchant.beans.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodDAO {
    public List<Good> listAllGoods(String customerId);
    public List<Good> goodCount();

    public List<Good> selectGoodListByCustomerId(@Param("customerId") String customerId,
                                                 @Param("start") int start,
                                                 @Param("limit") int limit);   // 根据商户id查询所有的商品信息
    public List<Good> selectGoodList(@Param("start") int start,
                                     @Param("limit") int limit);   // 查询所有的商品信息
    public List<Good> searchGoods(@Param("keyword") String keyword,
                                     @Param("start") int start,
                                     @Param("limit") int limit);
    public int delectGood(String gid);

    public int updateGood(Good good);

    public int insertGood(Good good);
    public Good selectGoodById(String goodId);
}
