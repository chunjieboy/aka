package com.qf.wfx.merchant.dao;

import com.qf.wfx.merchant.beans.Customer;
import org.apache.ibatis.annotations.Param;

public interface CustomerDAO {
    public Customer login(@Param("loginName") String loginName, @Param("loginPwd") String loginPwd);

}
