package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Pcplan;
import com.trkj.crmproject.vo.CollectionVo;
import com.trkj.crmproject.vo.PcplanVo;

import java.util.List;

public interface PcplanService {
    public PageInfo<CollectionVo> selectcollection(int pageNum, int pageSize);
    public PageInfo<CollectionVo> selectcollectiontj(int pageNum, int pageSize,String type,int totalone,int totaltwo);
    public List<Pcplan> selecthkmx(int orderId);
    public PcplanVo selectminhk(int orderId);
    public int updatehkjhzt(int pcId);
    public int updatemn(int pcId,int mn);
}
