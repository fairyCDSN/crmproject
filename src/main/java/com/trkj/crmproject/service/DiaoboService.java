package com.trkj.crmproject.service;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.Diaobo;
import com.trkj.crmproject.vo.DiaoboVo;
import com.trkj.crmproject.vo.ProductVo;

import java.util.List;

public interface DiaoboService {

    //调拨列表 查询全部（ckName[dcName,drName]
    List<DiaoboVo> selectDbAll();
    //分页
    public PageInfo<DiaoboVo> finddb(int pageNum, int pageSize);

    //调拨详情  根据调拨id查询商品信息
    List<ProductVo> selectDbidproName(int dbId);
    //调拨详情 根据调拨id查询调拨信息
    DiaoboVo selectDbidxq(int dbId);

    //调拨管理  修改
    int updateDbidbz(Diaobo diaobo);
}
