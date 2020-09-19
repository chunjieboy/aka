package com.qf.wfx.merchant.service;

import com.qf.wfx.merchant.beans.Customer;

public interface CustomerService {
    public Customer login( String loginName, String loginPwd);
}
