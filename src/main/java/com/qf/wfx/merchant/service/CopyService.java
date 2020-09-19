package com.qf.wfx.merchant.service;

import com.qf.wfx.merchant.beans.Copy;

import java.util.List;

public interface CopyService {
    public List<Copy> listAllCopy();

    public List<Copy> listCopyByPage(int page, int limit);//分页查询
    public int delectCopy(String cid);

    public int updateCopy(Copy copy);

    public int insertCopy(Copy copy);
}
