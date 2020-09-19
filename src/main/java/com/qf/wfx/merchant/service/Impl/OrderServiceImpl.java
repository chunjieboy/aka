package com.qf.wfx.merchant.service.Impl;

import com.qf.wfx.merchant.beans.Order;
import com.qf.wfx.merchant.dao.OrderDAO;
import com.qf.wfx.merchant.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDAO orderDAO;
    @Override
    public List<Order> listAllOrder(String customerId) {
        return orderDAO.listAllOrder(customerId);
    }

    @Override
    public List<Order> selectOrderByCustomerId(String customerId, int page, int limit) {
        int start = (page-1)*limit;
        return orderDAO.selectOrderByCustomerId(customerId,start,limit);
    }

    @Override
    public int updateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    @Override
    public int insertOrder(Order order) {
        return orderDAO.insertOrder(order);
    }
}
