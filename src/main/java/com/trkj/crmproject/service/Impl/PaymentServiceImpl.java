package com.trkj.crmproject.service;

import com.trkj.crmproject.dao.PaymentDao;
import com.trkj.crmproject.entity.Payment;
import com.trkj.crmproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    @Transactional
    public int tjqc(int paId) {
        return paymentDao.tjqc(paId);
    }

    @Override
    @Transactional
    public int addfkjh(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Date yzPyMntime(int sqid, int paqc) {
        return paymentDao.yzPyMntime(sqid,paqc);
    }
}
