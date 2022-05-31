package com.trkj.crmproject.dao;

import com.trkj.crmproject.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    int deleteByPrimaryKey(Integer py_id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Integer py_id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);

    int tjqc(int paId);
}