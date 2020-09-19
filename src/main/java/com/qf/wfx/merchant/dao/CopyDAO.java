package com.qf.wfx.merchant.dao;

import com.qf.wfx.merchant.beans.Copy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CopyDAO {
    public List<Copy> listAllCopy();

    public List<Copy> listCopyByPage(@Param("start") int start,
                                      @Param("limit") int limit);//分页查询
    public int delectCopy(String cid);

    public int updateCopy(Copy copy);

    public int insertCopy(Copy copy);
}
