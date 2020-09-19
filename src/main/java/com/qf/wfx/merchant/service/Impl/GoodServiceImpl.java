package com.qf.wfx.merchant.service.Impl;

import com.qf.wfx.merchant.beans.Good;
import com.qf.wfx.merchant.dao.GoodDAO;
import com.qf.wfx.merchant.service.GoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GoodServiceImpl implements GoodService {
    @Resource
    private GoodDAO goodDAO;

    @Override
    public List<Good> listAllGoods(String customerId) {
        return goodDAO.listAllGoods(customerId);
    }

    @Override
    public List<Good> selectGoodListByCustomerId(String customerId, int page, int limit) {
        int start = (page-1)*limit;
        return goodDAO.selectGoodListByCustomerId(customerId,start,limit);
    }

    @Override
    public int delectGood(String gid) {
        return goodDAO.delectGood(gid);
    }

    @Override
    public int updateGood(Good good) {
        return goodDAO.updateGood(good);
    }

    @Override
    public int insertGood(Good good) {
        return goodDAO.insertGood(good);
    }

    @Override
    public List<Good> goodCount() {
        return goodDAO.goodCount();
    }

    @Override
    public List<Good> selectGoodList(int start, int limit) {
        return goodDAO.selectGoodList(start,limit);
    }

    @Override
    public List<Good> searchGoods(String keyword, int start, int limit) {
        return goodDAO.searchGoods(keyword,start,limit);
    }

    @Override
    public Good selectGoodById(String goodId) {
        return goodDAO.selectGoodById(goodId);
    }
}
