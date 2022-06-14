package com.trkj.crmproject.service.Impl;

import com.trkj.crmproject.dao.GoodsqDao;
import com.trkj.crmproject.entity.Goodsq;
import com.trkj.crmproject.service.GoodsqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsqServiceImpl implements GoodsqService {

    @Autowired
    private GoodsqDao goodsqDao;

    @Override
    public int addgoodsq(Goodsq goodsq) {
        return goodsqDao.insert(goodsq);
    }
}
