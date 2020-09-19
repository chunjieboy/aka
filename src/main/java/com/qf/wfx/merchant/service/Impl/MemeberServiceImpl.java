package com.qf.wfx.merchant.service.Impl;

import com.qf.wfx.merchant.beans.Memeber;
import com.qf.wfx.merchant.dao.MemeberDAO;
import com.qf.wfx.merchant.service.MemeberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemeberServiceImpl implements MemeberService {
    @Resource
    private MemeberDAO memeberDAO;

    public Memeber login(String account, String password) {
        return memeberDAO.login(account,password);
    }

    @Override
    public int register(Memeber memeber) {
        return memeberDAO.insterMember(memeber);
    }
}
