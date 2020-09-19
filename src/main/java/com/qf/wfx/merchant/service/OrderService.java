package com.qf.wfx.merchant.service;

import com.qf.wfx.merchant.beans.Order;

import java.util.List;

public interface OrderService {
    public List<Order> listAllOrder(String customerId);

    public List<Order> selectOrderByCustomerId(String customerId, int page, int limit);   // 根据商户id查询所有的商品信息
    public int updateOrder(Order order);
    public int insertOrder(Order order);
}
