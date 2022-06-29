package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Pcplanzsy;
import com.trkj.crmproject.vo.CollectionVo;
import com.trkj.crmproject.vo.PcplanVozsy;

import java.util.List;

public interface PcplanzsyService {
    public PageInfo<CollectionVo> selectcollection(int pageNum, int pageSize);
    public PageInfo<CollectionVo> selectcollectiontj(int pageNum, int pageSize,String type,int totalone,int totaltwo);
    public List<Pcplanzsy> selecthkmx(int orderId);
    public PcplanVozsy selectminhk(int orderId);
    public int updatehkjhzt(int pcId);
    public int updatemn(int pcId,int mn);
}
