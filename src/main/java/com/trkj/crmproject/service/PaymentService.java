package com.trkj.crmproject.service;

import com.trkj.crmproject.entity.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface PaymentService {
    public int tjqc(int paId);
    public int addfkjh(Payment payment);
    public Date yzPyMntime(int sqid,int paqc);
}
