package com.qf.wfx.merchant.dao;

import com.qf.wfx.merchant.beans.Memeber;
import org.apache.ibatis.annotations.Param;

public interface MemeberDAO {
    public Memeber login(@Param("account") String account, @Param("password") String password);
    public int insterMember(Memeber memeber);
}
