package com.trkj.crmproject.service.Impl;

import com.trkj.crmproject.dao.PaymentDao;
import com.trkj.crmproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int tjqc(int paId) {
        return paymentDao.tjqc(paId);
    }
}
