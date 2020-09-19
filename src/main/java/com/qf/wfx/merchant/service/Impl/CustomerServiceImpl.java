package com.qf.wfx.merchant.service.Impl;

import com.qf.wfx.merchant.beans.Customer;
import com.qf.wfx.merchant.dao.CustomerDAO;
import com.qf.wfx.merchant.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDAO customerDAO;

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Customer login(String loginName, String loginPwd) {
        return customerDAO.login(loginName,loginPwd);
    }
}
