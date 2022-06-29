package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Cggoods;
import com.trkj.crmproject.vo.CggoodsVo;

import java.util.List;

public interface CggoodsService {
    public PageInfo<CggoodsVo> findgoods(int pageNum, int pageSize);
    public PageInfo<CggoodsVo> selectgoods(int pageNum,int pageSize,String gdName,String type,String name);
    public PageInfo<CggoodsVo> updategoods(Integer cgNumber,Integer gdId,int pageNum,int pageSize,String gdname,String type,String name);
    public PageInfo<CggoodsVo> updategoodsjs(Integer cgNumber,Integer gdId,int pageNum,int pageSize,String gdname,String type,String name);
    public List<Cggoods> findsCggoods(int supplierId);
    public int addgoods(Cggoods cggoods);
    public String yzgoodname(int supplierId,String goodname);
    public List<String> findgoodstype();
}
