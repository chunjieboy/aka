package com.qf.wfx.merchant.service.Impl;

import com.qf.wfx.merchant.beans.Copy;
import com.qf.wfx.merchant.dao.CopyDAO;
import com.qf.wfx.merchant.service.CopyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CopyServiceImpl implements CopyService {
    @Resource
    private CopyDAO copyDAO;

    @Override
    public List<Copy> listAllCopy() {
        return copyDAO.listAllCopy();
    }

    @Override
    public List<Copy> listCopyByPage(int page, int limit) {
        int start = (page-1)*limit;
        return copyDAO.listCopyByPage(start,limit);
    }

    @Override
    public int delectCopy(String cid) {
        return copyDAO.delectCopy(cid);
    }

    @Override
    public int updateCopy(Copy copy) {
        return copyDAO.updateCopy(copy);
    }

    @Override
    public int insertCopy(Copy copy) {
        return copyDAO.insertCopy(copy);
    }
}
