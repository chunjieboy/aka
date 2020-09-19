package com.qf.wfx.merchant.service;

import com.qf.wfx.merchant.beans.Good;
import com.qf.wfx.merchant.dao.GoodDAO;

import javax.annotation.Resource;
import java.util.List;

public interface GoodService {
    public List<Good> listAllGoods(String customerId);
    public List<Good> selectGoodListByCustomerId( String customerId, int page, int size) ;

    public int delectGood(String gid);
    public int updateGood(Good good);
    public int insertGood(Good good);

    public List<Good> goodCount();
    public List<Good> selectGoodList( int start, int limit);
    public List<Good> searchGoods(String keyword , int start, int limit);
    public Good selectGoodById(String goodId);
}
