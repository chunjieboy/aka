package com.qf.wfx.merchant.service;

import com.qf.wfx.merchant.beans.Memeber;

public interface MemeberService {
    public Memeber login(String account, String password);
    public int register(Memeber memeber);
}
