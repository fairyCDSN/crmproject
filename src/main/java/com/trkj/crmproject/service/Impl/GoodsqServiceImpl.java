package com.trkj.crmproject.service.Impl;

import com.trkj.crmproject.dao.GoodsqDao;
import com.trkj.crmproject.entity.Goodsq;
import com.trkj.crmproject.service.GoodsqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsqServiceImpl implements GoodsqService {

    @Autowired
    private GoodsqDao goodsqDao;

    @Override
    @Transactional
    public int addgoodsq(Goodsq goodsq) {
        return goodsqDao.insert(goodsq);
    }
}
