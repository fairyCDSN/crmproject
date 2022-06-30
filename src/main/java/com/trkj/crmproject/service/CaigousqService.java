package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Caigousq;
import com.trkj.crmproject.vo.CaigousqVo;
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
    public PageInfo<Caigousq> selectcgsqdd(int pageNum,int pageSize,String cgDh,Integer total,String type);
    public List<CaigousqVo> selectcgmx(int sqid);
    public Caigousq selectcgsqid(int sqid);
    public int addcgsq(Caigousq caigousq);
    public int updatecgsq(int stateId,int sqid);
}
