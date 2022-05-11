package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Caigousq;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaigousqService {
    public List<Caigousq> selectsupname();
    public PageInfo<Caigousq> findpur(int pageNum, int pageSize);
    public PageInfo<Caigousq> selectPurchaseplan(int pageNum, int pageSize,Integer sqid,Integer supplierId,String type);
    public int addcaigousq(Caigousq caigousq);
    public List<Caigousq> selectsqid();
    public int updatestate(int sqid,String usestate);
}
