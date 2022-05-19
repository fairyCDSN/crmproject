package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Cggoods;
import com.trkj.crmproject.vo.CggoodsVo;

import java.util.List;

public interface CggoodsService {
    public PageInfo<CggoodsVo> findgoods(int pageNum, int pageSize);
    public PageInfo<CggoodsVo> selectgoods(int pageNum,int pageSize,String gdName);
    public PageInfo<CggoodsVo>updategoods(Integer gdNumber,Integer gdId,int pageNum,int pageSize,String gdname);
    public PageInfo<CggoodsVo> updategoodsjs(Integer gdNumber,Integer gdId,int pageNum,int pageSize,String gdname);
}