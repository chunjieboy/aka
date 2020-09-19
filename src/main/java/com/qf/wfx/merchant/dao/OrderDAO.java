package com.qf.wfx.merchant.dao;



import com.qf.wfx.merchant.beans.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDAO {
    public List<Order> listAllOrder(String customerId);

    public List<Order> selectOrderByCustomerId(@Param("customerId") String customerId,
                                                 @Param("start") int start,
                                                 @Param("limit") int limit);   // 根据商户id查询所有的商品信息
    public int updateOrder(Order order);
    public int insertOrder(Order order);
}
